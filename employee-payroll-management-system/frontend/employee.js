document.getElementById("employeeForm").addEventListener("submit", async function(event) {

    event.preventDefault();

    const name = document.getElementById("name").value;
    const department = document.getElementById("department").value;
    const salary = document.getElementById("salary").value;

    try {

        const response = await fetch("http://localhost:8080/employees", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                name: name,
                department: department,
                salary: salary
            })
        });

        if (response.ok) {
            document.getElementById("message").textContent =
                "Employee added successfully!";

            document.getElementById("employeeForm").reset();
        } else {
            document.getElementById("message").textContent =
                "Failed to add employee.";
        }

    } catch (error) {
        document.getElementById("message").textContent =
            "Unable to connect to server.";
    }
});
async function loadEmployees() {

    try {
        const response = await fetch("http://localhost:8080/employees");

        const employees = await response.json();

        const employeeList = document.getElementById("employeeList");

        employeeList.innerHTML = "";

        employees.forEach(employee => {

            const div = document.createElement("div");

            div.innerHTML = `
                <p>
                    <b>ID:</b> ${employee.id}
                    <br>
                    <b>Name:</b> ${employee.name}
                    <br>
                    <b>Department:</b> ${employee.department}
                    <br>
                    <b>Salary:</b> ${employee.salary}
                </p>
                <hr>
            `;

            employeeList.appendChild(div);
        });

    } catch (error) {

        document.getElementById("employeeList").innerHTML =
            "Unable to load employee details.";
    }
}

loadEmployees();