package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Acao;

public class AcaoDAO {
	private String sqlCreate = "INSERT INTO Acoes(nome, descricao, preco_unitario) VALUES (?, ?, ?)";
	private String sqlAll = "Select * from Acoes";
	private String sqlUpdate = "UPDATE Acoes Set nome = ?, descricao = ?, preco_unitario = ? WHERE id = ?";
	private String sqlDelete = "DELETE from Acoes WHERE id = ?";
	
	public AcaoDAO() {
	}
	
	public boolean save(Acao acao) {
		Conexao db = new Conexao();
		Connection con = db.getConexao();

		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sqlCreate);

			pstm.setString(1, acao.getNome());
			pstm.setString(2, acao.getDescricao());
			pstm.setFloat(3, acao.getPreco_unitario());

			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			db.closeConexao();
		}
	}
	
	public List<Acao> all() {
		Conexao db = new Conexao();
		Connection con = db.getConexao();
		List<Acao> acoes = new ArrayList<Acao>();

		PreparedStatement pstm = null;
		ResultSet res = null;

		try {
			pstm = con.prepareStatement(sqlAll);
			res = pstm.executeQuery();
			
			while(res.next()) {
				Acao acao = new Acao();
				acao.setNome(res.getString("nome"));
				acao.setDescricao(res.getString("descricao"));
				acao.setPreco_unitario(res.getFloat("preco_unitario"));
				
				acoes.add(acao);
			}
			
			return acoes;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			db.closeConexao();
		}
	}
	
	public boolean update(Acao acao, int id) {
		Conexao db = new Conexao();
		Connection con = db.getConexao();

		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sqlUpdate);

			pstm.setString(1, acao.getNome());
			pstm.setString(2, acao.getDescricao());
			pstm.setFloat(3, acao.getPreco_unitario());
			pstm.setInt(4, id);

			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			db.closeConexao();
		}
	}
	
	public boolean update(Acao acao) {
		Conexao db = new Conexao();
		Connection con = db.getConexao();

		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sqlUpdate);

			pstm.setString(1, acao.getNome());
			pstm.setString(2, acao.getDescricao());
			pstm.setFloat(3, acao.getPreco_unitario());
			pstm.setInt(4, acao.getId());

			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			db.closeConexao();
		}
	}
	
	public void deleteById(int id) {
		Conexao db = new Conexao();
		Connection con = db.getConexao();

		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sqlDelete);
			pstm.setInt(1, id);
			pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			db.closeConexao();
		}
	}
}
