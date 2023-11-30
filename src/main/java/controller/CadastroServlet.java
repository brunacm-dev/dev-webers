package controller;

import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UsuarioDAO;

import java.io.IOException;

@WebServlet("/user")
public class CadastroServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		if (acao != null && acao.equals("solicitacao")) {
			cadastrarUsuario(request, response);
		} else {
			String mensagem = "Ação desconhecida: " + acao;
			request.setAttribute("mensagemErro", mensagem);
			request.getRequestDispatcher("/erro.jsp").forward(request, response);
		}
	}

	private void cadastrarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		Usuario usuario = new Usuario(nome, sobrenome, cpf, 0, email, senha);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		boolean cadastradoComSucesso = usuarioDAO.cadastrarUsuario(usuario);

		if (cadastradoComSucesso) {
			response.sendRedirect(request.getContextPath() + "/confirmacao.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/erro.jsp");
		}
	}
}
