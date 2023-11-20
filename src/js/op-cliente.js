// function mostrarSaldo() {
//   const saldoDiv = document.createElement('div')
//   saldoDiv.textContent = 'R$ 100,00'
//   const btnSaldo = document.getElementById('op-cliente')
//   btnSaldo.appendChild(saldoDiv)
// }

// Função para realizar um depósito
function realizarDeposito() {
  // alert("Operação de Depósito: Implemente aqui a lógica para realizar um depósito e mostrar o resultado na tela.");
  // Atualize a tela conforme necessário
}

// Adicione eventos de clique aos botões
//   document.getElementById("btn-saldo").addEventListener("click", mostrarSaldo);
//   document.getElementById("btn-deposito").addEventListener("click", realizarDeposito);

//   document.querySelectorAll(".btn-primary").addEventListener("click", () => {
//     alert("Operação de Depósito: Implemente aqui a lógica para realizar um depósito e mostrar o resultado na tela.");
//   })

const btns = document.querySelectorAll('.btn-primary')
const divGeral = document.createElement('div')
divGeral.classList.add('d-flex', 'justify-content-center')
const op = document.getElementById('op-cliente')

btns.forEach((btn) =>
  btn.addEventListener('click', () => {
    const divGeral = document.createElement('div')
    divGeral.classList.add('d-flex', 'justify-content-center')
    const op = document.getElementById('op-cliente')
    op.textContent = 'R$ 100,00'
    divGeral.appendChild(op)
  })
)
