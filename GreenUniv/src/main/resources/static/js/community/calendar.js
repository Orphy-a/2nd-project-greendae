     //달력 스크립트

    let currentYear = 2025;
    let currentMonth = 2; // 0 = January, 2 = March

    function generateCalendar(year, month) {
    const calendarBody = document.getElementById("calendar-body");
    const title = document.getElementById("calendar-title");

    calendarBody.innerHTML = "";
    title.innerText = `${year}.${String(month + 1).padStart(2, '0')}`;

    const firstDay = new Date(year, month, 1).getDay();
    const lastDate = new Date(year, month + 1, 0).getDate();

    let row = document.createElement("tr");
    for (let i = 0; i < firstDay; i++) {
    row.appendChild(document.createElement("td"));
}

    for (let date = 1; date <= lastDate; date++) {
    let cell = document.createElement("td");
    cell.innerText = date;


    if (year === 2025 && month === 2 && date === 4) {
    cell.classList.add();
}

    cell.onclick = () => alert(`${year}-${month + 1}-${date} 선택됨`);
    row.appendChild(cell);

    if ((firstDay + date) % 7 === 0 || date === lastDate) {
    calendarBody.appendChild(row);
    row = document.createElement("tr");
}
}
}

    function prevMonth() {
    if (currentMonth === 0) {
    currentMonth = 11;
    currentYear--;
} else {
    currentMonth--;
}
    generateCalendar(currentYear, currentMonth);
}

    function nextMonth() {
    if (currentMonth === 11) {
    currentMonth = 0;
    currentYear++;
} else {
    currentMonth++;
}
    generateCalendar(currentYear, currentMonth);
}

    generateCalendar(currentYear, currentMonth);
