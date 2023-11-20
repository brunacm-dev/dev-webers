package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Usuario;


public class UsuarioDAO {
	private String sqlCreate = "INSERT INTO Usuarios(nome, sobrenome, email, cpf, senha) VALUES (?, ?, ?, ?, ?)";
	
	public UsuarioDAO() {
	}
	
	public boolean save(Usuario usuario) {
		Conexao db = new Conexao();
		Connection con = db.getConexao();

		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sqlCreate);

			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getSobrenome());
			pstm.setString(3, usuario.getEmail());
			pstm.setString(4, usuario.getCpf());
			pstm.setString(5, usuario.getSenha());


			System.out.println(pstm.executeUpdate());
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			db.closeConexao();
		}
	}
}
