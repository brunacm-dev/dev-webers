package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UsuarioDAO;
import model.Usuario;


@WebServlet(urlPatterns={"/auth"})
public class auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioDAO dao = new UsuarioDAO();

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
		
		// dao.save(user);
		
		//for(Usuario user : dao.all()) {
			//System.out.println(user.getNome());
			//System.out.println(user.getSobrenome());
			//System.out.println(user.getCpf());
			//System.out.println(user.getTipo());
		//}
		
		dao.deleteByCpf("10577467386");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
