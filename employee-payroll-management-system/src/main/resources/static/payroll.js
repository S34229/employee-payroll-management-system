document.getElementById("payrollForm").addEventListener("submit", function(event) {

    event.preventDefault();

    const employeeId = document.getElementById("employeeId").value;
    const basicSalary = Number(document.getElementById("basicSalary").value);
    const allowance = Number(document.getElementById("allowance").value);
    const deduction = Number(document.getElementById("deduction").value);

    const netSalary = basicSalary + allowance - deduction;

    document.getElementById("message").textContent =
        "Payroll calculated successfully!";

    document.getElementById("salaryDetails").innerHTML = `
        <p><b>Employee ID:</b> ${employeeId}</p>
        <p><b>Basic Salary:</b> ₹${basicSalary}</p>
        <p><b>Allowance:</b> ₹${allowance}</p>
        <p><b>Deduction:</b> ₹${deduction}</p>
        <p><b>Net Salary:</b> ₹${netSalary}</p>
    `;
});