package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Conta;
import entities.Usuario;
import model.ContaDAO;
import model.UsuarioDAO;


@WebServlet(urlPatterns={"/auth"})
public class auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioDAO usuarioDao = new UsuarioDAO();

    public auth() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Deu certo a chamada!");
		Usuario user = new Usuario();
		user.setNome("Henriquee3");
		user.setSobrenome("");
		user.setEmail("testeee@testeee.com");
		user.setCpf("10577467386");
		user.setSenha("teste1234");
//			
//		usuarioDao.save(user);
		
		//for(Usuario user : dao.all()) {
			//System.out.println(user.getNome());
			//System.out.println(user.getSobrenome());
			//System.out.println(user.getCpf());
			//System.out.println(user.getTipo());
		//}
		
//		dao.deleteByCpf("10577467386");
		

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		Usuario usuario = usuarioDao.get(request.getParameter("cpf"));
		ContaDAO contaDAO = new ContaDAO();
		Conta conta = contaDAO.get(usuario.getCpf());
		String senha = request.getParameter("senha");
		
		HttpSession sessao = request.getSession();
		
//		System.out.println(usuario.getNome());	
		if(usuario != null && senha.equals(usuario.getSenha())) {
			sessao.setAttribute("usuario", usuario);
			sessao.setAttribute("conta", conta);
						
			
//			System.out.println("Usuario encontrado");
			//Criar sessao com o usuario
			if(usuario.isAdmin()) {
				//redirecionar 
//				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/admin.jsp");
//				dispatcher.forward(request,response);
//				request.setAttribute("usuarios",usuarioDao.all());
				response.sendRedirect("/sistema-bancario/views/admin.jsp");
			}else {
//				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/cliente.jsp");
//				dispatcher.forward(request,response);
				response.sendRedirect("/sistema-bancario/views/cliente.jsp");
			}
			//REdireciona
		}else {
//			System.out.println("Usuário ou senha incorretos");			
		}
	}

}
