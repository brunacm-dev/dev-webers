package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.CompraRendaFixa;

public class CompraRendaFixaDAO {
	private String sqlCreate = "INSERT INTO CompraRendaFixa(valor_investido, datetime_compra, codigo, renda_fixa_id) VALUES (?, ?, ?, ?)";
	private String sqlAll = "Select * from CompraRendaFixa";
	private String sqlUpdate = "UPDATE CompraRendaFixa Set valor_investido = ?, datetime_compra = ?, codigo = ?, renda_fixa_id = ? WHERE id = ?";
	private String sqlDelete = "DELETE from CompraRendaFixa WHERE id = ?";

	public CompraRendaFixaDAO() {
	}
	
	public boolean save(CompraRendaFixa compra_renda_fixa) {
		Conexao db = new Conexao();
		Connection con = db.getConexao();

		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sqlCreate);

			pstm.setFloat(1, compra_renda_fixa.getValor_investido());
			pstm.setDate(2, compra_renda_fixa.getDatetime_compra());
			pstm.setString(3, compra_renda_fixa.getCodigo());
			pstm.setInt(4, compra_renda_fixa.getRenda_fixa_id());

			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			db.closeConexao();
		}
	}
	
	public List<CompraRendaFixa> all() {
		Conexao db = new Conexao();
		Connection con = db.getConexao();
		List<CompraRendaFixa> compra_rendas_fixas = new ArrayList<CompraRendaFixa>();

		PreparedStatement pstm = null;
		ResultSet res = null;

		try {
			pstm = con.prepareStatement(sqlAll);
			res = pstm.executeQuery();
			
			while(res.next()) {
				CompraRendaFixa compra_renda_fixa = new CompraRendaFixa();
				compra_renda_fixa.setId(res.getInt("id"));
				compra_renda_fixa.setValor_investido(res.getFloat("valor_investido"));
				compra_renda_fixa.setCodigo(res.getString("codigo"));
				compra_renda_fixa.setDatetime_compra(res.getDate("datetime_compra"));
				compra_renda_fixa.setRenda_fixa_id(res.getInt("renda_fixa_id"));
				
				compra_rendas_fixas.add(compra_renda_fixa);
			}
			
			return compra_rendas_fixas;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			db.closeConexao();
		}
	}

	public boolean update(CompraRendaFixa compra_renda_fixa, int id) {
		Conexao db = new Conexao();
		Connection con = db.getConexao();

		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sqlUpdate);

			pstm.setFloat(1, compra_renda_fixa.getValor_investido());
			pstm.setDate(2, compra_renda_fixa.getDatetime_compra());
			pstm.setString(3, compra_renda_fixa.getCodigo());
			pstm.setInt(4, compra_renda_fixa.getRenda_fixa_id());
			pstm.setInt(5, id);
			

			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			db.closeConexao();
		}
	}
	
	public boolean update(CompraRendaFixa compra_renda_fixa) {
		Conexao db = new Conexao();
		Connection con = db.getConexao();

		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sqlUpdate);

			pstm.setFloat(1, compra_renda_fixa.getValor_investido());
			pstm.setDate(2, compra_renda_fixa.getDatetime_compra());
			pstm.setString(3, compra_renda_fixa.getCodigo());
			pstm.setInt(4, compra_renda_fixa.getRenda_fixa_id());
			pstm.setInt(5, compra_renda_fixa.getId());

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
