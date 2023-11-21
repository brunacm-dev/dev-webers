package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;


public class UsuarioDAO {
	private String sqlCreate = "INSERT INTO Usuarios(nome, sobrenome, email, cpf, senha) VALUES (?, ?, ?, ?, ?)";
	private String sqlAll = "Select * from Usuarios";
	
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


			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			db.closeConexao();
		}
	}
	
	public List<Usuario> all() {
		Conexao db = new Conexao();
		Connection con = db.getConexao();
		List<Usuario> usuarios = new ArrayList<Usuario>();

		PreparedStatement pstm = null;
		ResultSet res = null;

		try {
			pstm = con.prepareStatement(sqlAll);
			res = pstm.executeQuery();
			
			while(res.next()) {
				Usuario user = new Usuario();
				user.setNome(res.getString("nome"));
				user.setSobrenome(res.getString("sobrenome"));
				user.setEmail(res.getString("email"));
				user.setTipo(res.getInt("tipo"));
				user.setCpf(res.getString("cpf"));
				user.setSenha(res.getString("senha"));
				
				usuarios.add(user);
			}
			
			return usuarios;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			db.closeConexao();
		}
	}
}