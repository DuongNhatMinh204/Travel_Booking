document.addEventListener('DOMContentLoaded', () => {
    const videoSlider = document.getElementById('video-slider');
    const controlButtons = document.querySelectorAll('.vid-btn');

    if (!videoSlider) return; // Đảm bảo videoSlider tồn tại

    controlButtons.forEach(button => {
        button.addEventListener('click', () => {
            // Loại bỏ class "active" khỏi tất cả nút
            document.querySelector('.vid-btn.active')?.classList.remove('active');

            // Thêm class "active" vào nút hiện tại
            button.classList.add('active');

            // Thay đổi nguồn video
            videoSlider.src = button.dataset.src;
            videoSlider.load();

            // Đợi video tải xong rồi mới phát
            videoSlider.oncanplay = () => videoSlider.play();
        });
    });
});
