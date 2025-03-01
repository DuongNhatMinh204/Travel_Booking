document.addEventListener("DOMContentLoaded", function () {
    const urlParams = new URLSearchParams(window.location.search);
    const orderId = urlParams.get("orderId");

    if (!orderId) {
        showError("Không tìm thấy orderId. Vui lòng đặt tour trước!");
        return;
    }

    fetchHotels(orderId);
});

//  Lấy danh sách khách sạn từ API
function fetchHotels(orderId) {
    fetch("/admin/getAllHotels")
        .then(response => response.json())
        .then(result => {
            if (result.code === 1000 && result.data) {
                renderHotels(result.data, orderId);
            } else {
                showError("Lỗi tải danh sách khách sạn!");
            }
        })
        .catch(() => showError("Không thể tải danh sách khách sạn!"));
}

// Hiển thị danh sách khách sạn lên trang
function renderHotels(hotels, orderId) {
    const hotelList = document.getElementById("hotel-list");
    hotelList.innerHTML = "";

    if (hotels.length === 0) {
        showError("Không có khách sạn nào!");
        return;
    }

    hotels.forEach(hotel => {
        const hotelItem = document.createElement("div");
        hotelItem.classList.add("hotel-item");

        hotelItem.innerHTML = `
            <div class="hotel-name">${hotel.hotelName}</div>
            <div class="hotel-price">${hotel.hotelPrice.toLocaleString()} VND</div>
            <button class="choose-hotel" data-hotel-id="${hotel.id}" data-order-id="${orderId}">Chọn khách sạn</button>
        `;

        hotelList.appendChild(hotelItem);
    });

    //  Chỉ mở modal khi chọn khách sạn
    document.querySelectorAll(".choose-hotel").forEach(button => {
        button.addEventListener("click", function () {
            const hotelId = this.getAttribute("data-hotel-id");
            openHotelModal(orderId, hotelId);
        });
    });
}

//  Hiển thị lỗi nếu API lỗi hoặc không có khách sạn
function showError(message) {
    document.getElementById("hotel-list").innerHTML = `<p class="error-message">${message}</p>`;
}

//  Mở modal khi chọn khách sạn
function openHotelModal(orderId, hotelId) {
    document.getElementById("order-id").value = orderId;
    document.getElementById("hotel-id").value = hotelId;
    document.getElementById("hotel-modal").style.display = "flex";
}

//  Gửi API chọn khách sạn
document.getElementById("hotel-form").addEventListener("submit", function(event) {
    event.preventDefault();

    let orderId = document.getElementById("order-id").value;
    let hotelId = document.getElementById("hotel-id").value;
    let startHotel = document.getElementById("checkin-date").value;
    let endHotel = document.getElementById("checkout-date").value;

    fetch(`/order/chooseHotel/${orderId}/${hotelId}`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ startHotel, endHotel })
    })
        .then(response => response.json())
        .then(result => {
            if (result.message === "success") {
                alert("Chọn khách sạn thành công!");
                document.getElementById("hotel-modal").style.display = "none";
                window.location.href = `/flight?orderId=${orderId}`;
            } else {
                alert(result.message || "Chọn khách sạn thất bại!");
            }
        })
        .catch(() => alert("Lỗi khi chọn khách sạn!"));
});

//  Đóng modal khi nhấn dấu "X"
document.querySelector(".close-modal").addEventListener("click", function () {
    document.getElementById("hotel-modal").style.display = "none";
});
