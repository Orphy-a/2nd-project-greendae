let currentWeekStart = new Date(2025, 2, 10); // 3월 10일 (JavaScript에서 월은 0부터 시작)

function updateWeek() {
    let startYear = currentWeekStart.getFullYear();
    let startMonth = ("0" + (currentWeekStart.getMonth() + 1)).slice(-2);
    let startDay = ("0" + currentWeekStart.getDate()).slice(-2);

    let endDate = new Date(currentWeekStart);
    endDate.setDate(endDate.getDate() + 5);
    let endMonth = ("0" + (endDate.getMonth() + 1)).slice(-2);
    let endDay = ("0" + endDate.getDate()).slice(-2);

    // 상단 날짜 업데이트
    document.getElementById("weekTitle").innerText = `${startYear}.${startMonth}.${startDay} ~ ${startYear}.${endMonth}.${endDay}`;

    // 표의 날짜 업데이트
    const days = ["일", "월", "화", "수", "목", "금", "토"];
    let tableHeaders = document.querySelectorAll(".table thead tr th");

    for (let i = 1; i <= 6; i++) { // 월~토 요일 업데이트
        let newDate = new Date(currentWeekStart);
        newDate.setDate(newDate.getDate() + (i - 1));

        let month = newDate.getMonth() + 1;
        let date = newDate.getDate();
        let dayOfWeek = days[newDate.getDay()];

        tableHeaders[i].innerText = `2025.${month}.${date}(${dayOfWeek})`;
    }
}

function prevWeek() {
    currentWeekStart.setDate(currentWeekStart.getDate() - 7);
    updateWeek();
}

function nextWeek() {
    currentWeekStart.setDate(currentWeekStart.getDate() + 7);
    updateWeek();
}

updateWeek();