function handleRegister() {

    const confirmacaoMensagem = document.getElementById('confirmacaoMensagem');
    confirmacaoMensagem.classList.remove('d-none');

    const registerForm = document.getElementById('registerForm');
    registerForm.classList.add('d-none');

    return false;
  }
