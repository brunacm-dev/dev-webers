const loginForm = document.getElementById('loginForm')
const userTypeMessage = document.getElementById('userTypeMessage')
const userType = document.getElementById('userType')
const loginEmail = document.getElementById('loginEmail').value

function showLoginForm(userType) {
  userTypeMessage.textContent =
    userType === 'cliente' ? 'Login como Cliente' : 'Login como Admin'

  loginForm.classList.remove('d-none')
}

function hideLoginForm() {
  loginForm.classList.add('d-none')
}

function handleLogin() {
  userTypeMessage.textContent === 'Login como Cliente'
    ? (window.location.href = '/public/login-client.html')
    : (window.location.href = '/public/login-admin.html')

  return false
}
