document.addEventListener('DOMContentLoaded', function () {

    const btnNext = document.getElementById('btnNext');
    const check = document.getElementById('check');

    btnNext.style.pointerEvents = 'none';
    btnNext.style.opacity = '0.5';

    check.addEventListener('change', function () {

        if(this.checked) {

        // 체크박스가 채크되면 링크 활성화
        btnNext.style.pointerEvents = 'auto';
        btnNext.style.opacity = '1';

        } else {
            // 체크박스가 해제되면 링크 비활성화
            btnNext.style.pointerEvents = 'none';
            btnNext.style.opacity = '0.5';
        }

    });
});
