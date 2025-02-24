
    const editBtn = document.getElementById('edit-btn');
    const popup = document.getElementById('popup');
    const closeBtn = document.getElementById('close-btn');

    // Hiển thị popup khi bấm nút "Chỉnh Sửa Hồ Sơ"
    editBtn.addEventListener('click', () => {
    popup.style.display = 'flex';
});

    // Đóng popup khi bấm nút "Hủy"
    closeBtn.addEventListener('click', () => {
    popup.style.display = 'none';
});

    // Đóng popup khi click ra ngoài
    window.addEventListener('click', (e) => {
    if (e.target === popup) {
    popup.style.display = 'none';
}
});
