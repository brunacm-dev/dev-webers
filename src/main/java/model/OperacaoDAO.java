package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Operacao;

public class OperacaoDAO {
	private String sqlCreate = "INSERT INTO Operacoes(codigo, valor, tipo) VALUES (?, ?, ?)";
	private String sqlAll = "Select * from Operacoes";
	private String sqlUpdate = "UPDATE Operacoes Set codigo = ?, valor = ?, tipo = ? WHERE id = ?";
	private String sqlDelete = "DELETE from Operacoes WHERE id = ?";
	
	public OperacaoDAO() {
	}
	
	public boolean save(Operacao operacao) {
		Conexao db = new Conexao();
		Connection con = db.getConexao();

		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sqlCreate);

			pstm.setString(1, operacao.getCodigo());
			pstm.setFloat(2, operacao.getValor());
			pstm.setInt(3, operacao.getTipo());

			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			db.closeConexao();
		}
	}
	
	public List<Operacao> all() {
		Conexao db = new Conexao();
		Connection con = db.getConexao();
		List<Operacao> operacoes = new ArrayList<Operacao>();

		PreparedStatement pstm = null;
		ResultSet res = null;

		try {
			pstm = con.prepareStatement(sqlAll);
			res = pstm.executeQuery();
			
			while(res.next()) {
				Operacao operacao = new Operacao();
				operacao.setId(res.getInt("id"));
				operacao.setCodigo(res.getString("codigo"));
				operacao.setValor(res.getFloat("valor"));
				operacao.setTipo(res.getInt("tipo"));
				
				operacoes.add(operacao);
			}
			
			return operacoes;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			db.closeConexao();
		}
	}

	public boolean update(Operacao operacao, int id) {
		Conexao db = new Conexao();
		Connection con = db.getConexao();

		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sqlUpdate);

			pstm.setString(1, operacao.getCodigo());
			pstm.setFloat(2, operacao.getValor());
			pstm.setInt(3, operacao.getTipo());
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
	
	public boolean update(Operacao operacao) {
		Conexao db = new Conexao();
		Connection con = db.getConexao();

		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sqlUpdate);

			pstm.setString(1, operacao.getCodigo());
			pstm.setFloat(2, operacao.getValor());
			pstm.setInt(3, operacao.getTipo());
			pstm.setInt(4, operacao.getId());

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
