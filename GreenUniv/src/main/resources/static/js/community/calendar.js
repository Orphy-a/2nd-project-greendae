let currentYear = 2025;
let currentMonth = 3;


function loadCalendar(year, month) {
    fetch(`/api/schedules/${year}/${month}`)
        .then(response => response.json())
        .then(data => renderCalendar(year, month, data))
        .catch(error => console.error("Error loading schedules:", error));
}


function renderCalendar(year, month, schedules) {
    const calendarBody = document.getElementById("calendar-body");
    const title = document.getElementById("calendar-title");


    title.innerText = `${year}.${String(month).padStart(2, '0')}`;
    calendarBody.innerHTML = "";

    const firstDay = new Date(year, month - 1, 1).getDay();
    const lastDate = new Date(year, month, 0).getDate();

    let row = document.createElement("tr");

    for (let i = 0; i < firstDay; i++) {
        row.appendChild(document.createElement("td"));
    }


    for (let date = 1; date <= lastDate; date++) {
        let cell = document.createElement("td");
        cell.innerText = date;


        let event = schedules.find(e => new Date(e.date).getDate() === date);
        if (event) {
            let eventDiv = document.createElement("div");
            eventDiv.textContent = event.title;
            eventDiv.style.backgroundColor = "#ffeb3b";
            eventDiv.style.padding = "5px";
            eventDiv.style.marginTop = "5px";
            eventDiv.style.borderRadius = "5px";
            cell.appendChild(eventDiv);
        }


        cell.addEventListener("click", () => openModal(year, month, date));

        row.appendChild(cell);


        if ((firstDay + date) % 7 === 0) {
            calendarBody.appendChild(row);
            row = document.createElement("tr");
        }
    }


    if (row.children.length > 0) {
        calendarBody.appendChild(row);
    }
}


function prevMonth() {
    if (currentMonth === 1) {
        currentMonth = 12;
        currentYear--;
    } else {
        currentMonth--;
    }
    loadCalendar(currentYear, currentMonth);
}


function nextMonth() {
    if (currentMonth === 12) {
        currentMonth = 1;
        currentYear++;
    } else {
        currentMonth++;
    }
    loadCalendar(currentYear, currentMonth);
}


function openModal(year, month, date) {
    document.getElementById("modal-date").value = `${year}-${String(month).padStart(2, '0')}-${String(date).padStart(2, '0')}`;
    document.getElementById("schedule-modal").style.display = "block";
}


function closeModal() {
    document.getElementById("schedule-modal").style.display = "none";
}


function saveSchedule() {
    const date = document.getElementById("modal-date").value;
    const title = document.getElementById("modal-title").value;

    if (!title) {
        alert("일정 제목을 입력해주세요.");
        return;
    }

    fetch("/api/schedules/add", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ title, date })
    })
        .then(response => response.json())
        .then(() => {
            alert("일정이 추가되었습니다.");
            closeModal();
            loadCalendar(new Date(date).getFullYear(), new Date(date).getMonth() + 1); // 달력 다시 로드
        })
        .catch(error => console.error("Error adding schedule:", error));
}

function fillCalendar(year, month) {
    const calendarBody = document.getElementById("calendar-body");
    calendarBody.innerHTML = "";

    const firstDay = new Date(year, month - 1, 1).getDay();
    const lastDate = new Date(year, month, 0).getDate();
    const prevLastDate = new Date(year, month - 1, 0).getDate();

    let date = 1;
    let nextMonthDate = 1;

    for (let i = 0; i < 6; i++) {
        let row = document.createElement("tr");

        for (let j = 0; j < 7; j++) {
            let cell = document.createElement("td");

            if (i === 0 && j < firstDay) {

                cell.textContent = prevLastDate - firstDay + j + 1;
                cell.classList.add("prev-month");
            } else if (date > lastDate) {

                cell.textContent = nextMonthDate++;
                cell.classList.add("next-month");
            } else {

                cell.textContent = date;
                cell.classList.add("current-month");
                date++;
            }
            row.appendChild(cell);
        }

        calendarBody.appendChild(row);

        if (date > lastDate) break;
    }
}


document.addEventListener("DOMContentLoaded", function () {
    loadCalendar(currentYear, currentMonth);
});

let selectedScheduleId = null;


function openModal(year, month, date, scheduleId = null, existingTitle = "") {
    document.getElementById("modal-date").value = `${year}-${String(month).padStart(2, '0')}-${String(date).padStart(2, '0')}`;
    document.getElementById("modal-title").value = existingTitle;
    selectedScheduleId = scheduleId;
    document.getElementById("schedule-modal").style.display = "block";


    if (scheduleId) {
        document.getElementById("delete-button").style.display = "inline-block";
    } else {
        document.getElementById("delete-button").style.display = "none";
    }
}


function saveSchedule() {
    const date = document.getElementById("modal-date").value;
    const title = document.getElementById("modal-title").value;

    if (!title) {
        alert("일정 제목을 입력해주세요.");
        return;
    }

    let method = selectedScheduleId ? "PUT" : "POST";
    let url = selectedScheduleId ? `/api/schedules/update/${selectedScheduleId}` : "/api/schedules/add";

    fetch(url, {
        method: method,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ title, date })
    })
        .then(response => response.json())
        .then(() => {
            alert(selectedScheduleId ? "일정이 수정되었습니다." : "일정이 추가되었습니다.");
            closeModal();
            loadCalendar(new Date(date).getFullYear(), new Date(date).getMonth() + 1);
        })
        .catch(error => console.error("Error updating schedule:", error));
}


function deleteSchedule() {
    if (!selectedScheduleId) {
        alert("삭제할 일정이 없습니다.");
        return;
    }

    if (!confirm("정말 삭제하시겠습니까?")) return;

    fetch(`/api/schedules/delete/${selectedScheduleId}`, { method: "DELETE" })
        .then(response => {
            if (!response.ok) {
                throw new Error("삭제에 실패했습니다");
            }
            return response.text();
        })
        .then(message => {
            alert(message || "일정이 삭제되었습니다.");
            closeModal();
            loadCalendar(new Date().getFullYear(), new Date().getMonth() + 1);
        })
        .catch(error => {
            console.error("삭제 중 오류 발생:", error);
            alert("삭제에 실패했습니다. 다시 시도해주세요.");
        });
}


function renderCalendar(year, month, schedules) {
    const calendarBody = document.getElementById("calendar-body");
    const title = document.getElementById("calendar-title");

    title.innerText = `${year}.${String(month).padStart(2, '0')}`;
    calendarBody.innerHTML = "";

    const firstDay = new Date(year, month - 1, 1).getDay();
    const lastDate = new Date(year, month, 0).getDate();

    let row = document.createElement("tr");

    for (let i = 0; i < firstDay; i++) {
        row.appendChild(document.createElement("td"));
    }

    for (let date = 1; date <= lastDate; date++) {
        let cell = document.createElement("td");
        cell.innerText = date;

        let event = schedules.find(e => new Date(e.date).getDate() === date);
        if (event) {
            let eventDiv = document.createElement("div");
            eventDiv.textContent = event.title;
            eventDiv.style.backgroundColor = "#f6b3dc";
            eventDiv.style.padding = "5px";
            eventDiv.style.marginTop = "5px";
            eventDiv.style.borderRadius = "5px";
            cell.appendChild(eventDiv);


            cell.addEventListener("click", () => openModal(year, month, date, event.id, event.title));
        } else {

            cell.addEventListener("click", () => openModal(year, month, date));
        }

        row.appendChild(cell);

        if ((firstDay + date) % 7 === 0) {
            calendarBody.appendChild(row);
            row = document.createElement("tr");
        }
    }

    if (row.children.length > 0) {
        calendarBody.appendChild(row);
    }
}


document.addEventListener("DOMContentLoaded", function () {
    loadCalendar(new Date().getFullYear(), new Date().getMonth() + 1);
});

function openEditModal(date, id, title) {
    document.getElementById("modal-date").value = date;
    document.getElementById("modal-title").value = title;
    document.getElementById("delete-button").style.display = "block";
    document.getElementById("delete-button").setAttribute("data-id", id); // 삭제 버튼에 ID 저장
}