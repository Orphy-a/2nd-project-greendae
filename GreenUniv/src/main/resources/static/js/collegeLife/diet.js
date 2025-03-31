let currentWeekStart = new Date(2025, 2, 10); // 3월 10일

function updateWeek() {
    let startYear = currentWeekStart.getFullYear();
    let startMonth = ("0" + (currentWeekStart.getMonth() + 1)).slice(-2);
    let startDay = ("0" + currentWeekStart.getDate()).slice(-2);

    let endDate = new Date(currentWeekStart);
    endDate.setDate(endDate.getDate() + 5);
    let endMonth = ("0" + (endDate.getMonth() + 1)).slice(-2);
    let endDay = ("0" + endDate.getDate()).slice(-2);

    document.getElementById("weekTitle").innerText = `${startYear}.${startMonth}.${startDay} ~ ${startYear}.${endMonth}.${endDay}`;
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