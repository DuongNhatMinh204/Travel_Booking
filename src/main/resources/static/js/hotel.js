document.addEventListener("DOMContentLoaded", function () {
    fetchHotels();
});

// Lấy danh sách khách sạn từ API
function fetchHotels() {
    fetch("http://localhost:8080/admin/getAllHotels")
        .then(response => response.json())
        .then(result => {
            if (result.code === 1000 && result.data.length > 0) {
                renderHotels(result.data);
            } else {
                showError("Không có khách sạn nào!");
            }
        })
        .catch(error => {
            console.error("Lỗi khi tải danh sách khách sạn:", error);
            showError("Không thể tải danh sách khách sạn!");
        });
}

// Hiển thị danh sách khách sạn lên trang
function renderHotels(hotels) {
    const hotelList = document.getElementById("hotel-list");
    hotelList.innerHTML = ""; // Xóa nội dung cũ

    hotels.forEach(hotel => {
        const hotelItem = document.createElement("div");
        hotelItem.classList.add("hotel-item");

        hotelItem.innerHTML = `
            <div class="hotel-name">${hotel.hotelName}</div>
            <div class="hotel-price">Giá từ: ${hotel.hotelPriceFrom.toLocaleString()} VND</div>
            <div class="hotel-address">Địa chỉ: ${hotel.address}</div>
            <div class="hotel-floors">Số tầng: ${hotel.numberFloor}</div>
            <button class="choose-hotel" data-hotel-id="${hotel.id}">Chọn khách sạn</button>
        `;

        hotelList.appendChild(hotelItem);
    });

    // Thêm sự kiện cho nút chọn khách sạn
    document.querySelectorAll(".choose-hotel").forEach(button => {
        button.addEventListener("click", function () {
            const hotelId = this.getAttribute("data-hotel-id");
            openHotelModal(hotelId);
        });
    });
}

// Hiển thị lỗi nếu API lỗi hoặc không có khách sạn
function showError(message) {
    const hotelList = document.getElementById("hotel-list");
    hotelList.innerHTML = `<p class="error-message">${message}</p>`;
}

// Mở modal khi chọn khách sạn
function openHotelModal(hotelId) {
    document.getElementById("hotel-id").value = hotelId;
    document.getElementById("hotel-modal").style.display = "flex";

    // Lấy danh sách phòng của khách sạn
    fetch(`http://localhost:8080/admin/getAllHotels`)
        .then(response => response.json())
        .then(result => {
            if (result.code === 1000 && result.data.length > 0) {
                const hotel = result.data.find(h => h.id == hotelId);
                if (hotel) {
                    renderRoomList(hotel.hotelBedrooms);
                }
            }
        })
        .catch(error => {
            console.error("Lỗi khi tải danh sách phòng:", error);
        });
}

// Hiển thị danh sách phòng trong modal
function renderRoomList(rooms) {
    const roomList = document.getElementById("room-list");
    roomList.innerHTML = ""; // Xóa nội dung cũ

    rooms.forEach(room => {
        const roomItem = document.createElement("div");
        roomItem.classList.add("room-item");

        roomItem.innerHTML = `
            <input type="checkbox" id="room-${room.id}" value="${room.id}">
            <label for="room-${room.id}">Phòng ${room.roomNumber} - ${room.roomType} (${room.price.toLocaleString()} VND)</label>
        `;

        roomList.appendChild(roomItem);
    });

    // Hiển thị danh sách phòng khi di chuột vào nút "Chọn phòng"
    document.getElementById("choose-room-btn").addEventListener("click", function () {
        roomList.classList.toggle("show");
    });
}

// Gửi API chọn khách sạn và phòng
document.getElementById("hotel-form").addEventListener("submit", function (event) {
    event.preventDefault();
    // Lấy orderId từ URL
    const urlParams = new URLSearchParams(window.location.search);
    const orderId = urlParams.get("orderId");

    if (!orderId) {
        alert("Không tìm thấy orderId. Vui lòng đặt tour trước!");
        return;
    }

    const hotelId = document.getElementById("hotel-id").value;
    const checkinDate = document.getElementById("checkin-date").value;
    const checkoutDate = document.getElementById("checkout-date").value;

    // Lấy danh sách phòng đã chọn
    const selectedRooms = Array.from(document.querySelectorAll("#room-list input[type='checkbox']:checked"))
        .map(checkbox => ({
            id: parseInt(checkbox.value),
            roomNumber: checkbox.nextElementSibling.textContent.split(" ")[1],
            price: parseFloat(checkbox.nextElementSibling.textContent.match(/\d+/g)[1]),
            roomStatus: "AVAILABLE",
            roomType: checkbox.nextElementSibling.textContent.split(" - ")[1].split(" (")[0]
        }));

    if (!hotelId || !checkinDate || !checkoutDate || selectedRooms.length === 0) {
        alert("Vui lòng nhập đầy đủ thông tin và chọn ít nhất một phòng!");
        return;
    }

    // Gửi yêu cầu API
    fetch(`http://localhost:8080/order/chooseHotel/${orderId}/${hotelId}`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            startHotel: checkinDate,
            endHotel: checkoutDate,
            hotelBedroomList: selectedRooms
        })
    })
        .then(response => response.json())
        .then(result => {
            if (result.message === "success") {
                alert("Chọn khách sạn và phòng thành công!");
                document.getElementById("hotel-modal").style.display = "none";
                window.location.href = `/flight?orderId=${result.data.id}`;
            } else {
                alert(result.message || "Chọn khách sạn và phòng thất bại!");
            }
        })
        .catch(error => {
            console.error("Lỗi khi chọn khách sạn và phòng:", error);
            alert("Lỗi khi chọn khách sạn và phòng!");
        });
});

// Đóng modal khi nhấn dấu "X"
document.querySelector(".close-modal").addEventListener("click", function () {
    document.getElementById("hotel-modal").style.display = "none";
});