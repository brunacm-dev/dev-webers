package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ContaDAO;
import DAO.OperacaoDAO;
import model.Conta;
import model.Operacao;
import model.Usuario;

/**
 * Servlet implementation class operacao
 */
@WebServlet(urlPatterns={"/operacao"})
public class operacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public operacao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		float valor = Float.parseFloat(request.getParameter("valor"));
		String action = request.getParameter("action");
		System.out.println(action);
		HttpSession sessao = request.getSession();
		Operacao operacao = null;
		Usuario usuario = (Usuario)sessao.getAttribute("usuario");
		ContaDAO contaDAO = new ContaDAO();
		OperacaoDAO operacaoDAO = new OperacaoDAO();
		if(usuario !=  null) {
			Conta conta = contaDAO.get(usuario.getCpf());
			if(action.equals("depositar")) {
				System.out.println(conta.getSaldo() + conta.getCpf());
				operacao = new Operacao(conta.getCodigo(), 1, valor );
				conta.depositar(valor);
				contaDAO.update(conta);
				operacaoDAO.save(operacao);
			}else if(action.equals("sacar")){
				operacao = new Operacao(conta.getCodigo(), 2, valor );
				conta.sacar(valor);
				contaDAO.update(conta);
				operacaoDAO.save(operacao);
			}
			response.sendRedirect("/sistema-bancario/views/cliente.jsp");
//			if(operacao != null) {
//				contaDAO.update(conta);
//				operacaoDAO.save(operacao);
//			}
		}
		
//		doGet(request, response);
	}

}
