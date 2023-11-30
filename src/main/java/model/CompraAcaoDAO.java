package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.CompraAcao;

public class CompraAcaoDAO {
	private String sqlCreate = "INSERT INTO CompraAcao(quantidade, datetime_compra, preco_unitario, codigo, acao_id) VALUES (?, ?, ?, ?, ?)";
	private String sqlAll = "Select * from CompraAcao";
	private String sqlUpdate = "UPDATE CompraAcao Set quantidade = ?, datetime_compra = ?, preco_unitario = ?, codigo = ?, acao_id = ? WHERE id = ?";
	private String sqlDelete = "DELETE from CompraAcao WHERE id = ?";

	public CompraAcaoDAO() {
	}

	public boolean save(CompraAcao compra_acao) {
		Conexao db = new Conexao();
		Connection con = db.getConexao();

		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sqlCreate);

			pstm.setInt(1, compra_acao.getQuantidade());
			pstm.setDate(2, compra_acao.getDatetime_compra());
			pstm.setFloat(3, compra_acao.getPreco_unitario());
			pstm.setString(4, compra_acao.getCodigo());
			pstm.setInt(5, compra_acao.getAcao_id());

			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			db.closeConexao();
		}
	}
	
	public List<CompraAcao> all() {
		Conexao db = new Conexao();
		Connection con = db.getConexao();
		List<CompraAcao> compra_acaos = new ArrayList<CompraAcao>();

		PreparedStatement pstm = null;
		ResultSet res = null;

		try {
			pstm = con.prepareStatement(sqlAll);
			res = pstm.executeQuery();
			
			while(res.next()) {
				CompraAcao compra_acao = new CompraAcao();
				compra_acao.setId(res.getInt("id"));
				compra_acao.setQuantidade(res.getInt("qauntidade"));
				compra_acao.setDatetime_compra(res.getDate("datetime_compra"));
				compra_acao.setPreco_unitario(res.getFloat("preco_unitario"));
				compra_acao.setCodigo(res.getString("codigo"));
				compra_acao.setAcao_id(res.getInt("acao_id"));
				
				compra_acaos.add(compra_acao);
			}
			
			return compra_acaos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			db.closeConexao();
		}
	}

	public boolean update(CompraAcao compra_acao, int id) {
		Conexao db = new Conexao();
		Connection con = db.getConexao();

		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sqlUpdate);

			pstm.setInt(1, compra_acao.getQuantidade());
			pstm.setDate(2, compra_acao.getDatetime_compra());
			pstm.setFloat(3, compra_acao.getPreco_unitario());
			pstm.setString(4, compra_acao.getCodigo());
			pstm.setInt(5, compra_acao.getAcao_id());
			pstm.setInt(6, id);
			

			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			db.closeConexao();
		}
	}
	
	public boolean update(CompraAcao compra_acao) {
		Conexao db = new Conexao();
		Connection con = db.getConexao();

		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sqlUpdate);

			pstm.setInt(1, compra_acao.getQuantidade());
			pstm.setDate(2, compra_acao.getDatetime_compra());
			pstm.setFloat(3, compra_acao.getPreco_unitario());
			pstm.setString(4, compra_acao.getCodigo());
			pstm.setInt(5, compra_acao.getAcao_id());
			pstm.setInt(6, compra_acao.getId());

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
