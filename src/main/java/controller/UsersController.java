package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ContaDAO;
import DAO.UsuarioDAO;
import model.Conta;
import model.Usuario;

@WebServlet("/users")
public class UsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioDAO DaoUsuario = new UsuarioDAO();
	ContaDAO DaoConta = new ContaDAO();
       
    public UsersController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");

		if (acao != null && acao.equals("Cadastrar")) {
			criaCliente(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/views/form-cadastro.jsp");
		}
	}
	
	protected void criaCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario user = new Usuario();
		
		user.setNome(request.getParameter("nome"));
		user.setSobrenome(request.getParameter("sobrenome"));
		user.setEmail(request.getParameter("email"));
		user.setCpf(request.getParameter("cpf"));
		user.setSenha(request.getParameter("senha"));
		
		user.SetEmSolicitacao();
		user.SetCliente();
		
		if(DaoUsuario.save(user) ) {
			Conta conta = new Conta();
			conta.setCpf(user.getCpf());
			
			if(DaoConta.save(conta)) {
				request.setAttribute("usuarios", DaoUsuario.all());
				response.sendRedirect(request.getContextPath() + "/views/admin.jsp");
			} else {
				response.sendRedirect(request.getContextPath() + "/views/form-cadastro.jsp");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/views/form-cadastro.jsp");
		}
	}

}
