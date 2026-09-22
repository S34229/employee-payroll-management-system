document.getElementById("loginForm").addEventListener("submit", async function (event) {

    event.preventDefault();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const message = document.getElementById("message");

    try {

        const response = await fetch(
            `http://localhost:8080/api/login?username=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}`,
            {
                method: "POST"
            }
        );

        const result = await response.text();

        if (response.ok && result === "Login successful") {
            message.textContent = "Login successful!";

setTimeout(() => {
    window.location.href = "dashboard.html";
}, 1000);
        } else {
            message.textContent = "Invalid username or password";
        }

    } catch (error) {
        message.textContent = "Unable to connect to server";
        console.error(error);
    }
});S
