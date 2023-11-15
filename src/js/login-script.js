function showLoginForm(userType) {
    var loginForm = document.getElementById("loginForm")
    var userTypeMessage = document.getElementById("userTypeMessage")

    userTypeMessage.textContent =
      userType === "cliente" ? "Login como Cliente" : "Login como Admin"

    loginForm.classList.remove("d-none")
    console.log("Usuário selecionado:", userType)
  }

  function hideLoginForm() {
    var loginForm = document.getElementById("loginForm")
    loginForm.classList.add("d-none")
  }

  function handleLogin() {
    var userType = document
      .getElementById("loginForm")
      .classList.contains("d-none")
      ? ""
      : "cliente" // Definir o tipo de usuário com base na visibilidade do formulário
    var loginEmail = document.getElementById("loginEmail").value

    // Lógica para redirecionar com base no tipo de usuário
    if (userType === "admin") {
      window.location.href = "/public/login-admin.html"
    } else if (userType === "cliente") {
      window.location.href = "/public/login-client.html"
    }
    return false
  }