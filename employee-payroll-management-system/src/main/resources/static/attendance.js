document.getElementById("attendanceForm").addEventListener("submit", function(event) {

    event.preventDefault();

    const employeeId = document.getElementById("employeeId").value;
    const date = document.getElementById("date").value;
    const status = document.getElementById("status").value;

    document.getElementById("message").textContent =
        "Attendance saved successfully!";

    document.getElementById("attendanceDetails").innerHTML = `
        <p><b>Employee ID:</b> ${employeeId}</p>
        <p><b>Date:</b> ${date}</p>
        <p><b>Status:</b> ${status}</p>
    `;

});