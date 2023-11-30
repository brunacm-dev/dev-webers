package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.RendaFixa;

public class RendaFixaDAO {
	private String sqlCreate = "INSERT INTO RendaFixa(nome, porcentagem, tipo, data_resgate) VALUES (?, ?, ?, ?)";
	private String sqlAll = "Select * from RendaFixa";
	private String sqlUpdate = "UPDATE RendaFixa Set nome = ?, porcentagem = ?, tipo = ?, data_resgate = ? WHERE id = ?";
	private String sqlDelete = "DELETE from RendaFixa WHERE id = ?";
	
	public RendaFixaDAO() {
	}
	
	public boolean save(RendaFixa renda_fixa) {
		Conexao db = new Conexao();
		Connection con = db.getConexao();

		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sqlCreate);

			pstm.setString(1, renda_fixa.getNome());
			pstm.setFloat(2, renda_fixa.getPorcentagem());
			pstm.setInt(3, renda_fixa.getTipo());
			pstm.setDate(4, (Date) renda_fixa.getData_resgate());

			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			db.closeConexao();
		}
	}
	
	public List<RendaFixa> all() {
		Conexao db = new Conexao();
		Connection con = db.getConexao();
		List<RendaFixa> rendas_fixas = new ArrayList<RendaFixa>();

		PreparedStatement pstm = null;
		ResultSet res = null;

		try {
			pstm = con.prepareStatement(sqlAll);
			res = pstm.executeQuery();
			
			while(res.next()) {
				RendaFixa renda_fixa = new RendaFixa();
				renda_fixa.setId(res.getInt("id"));
				renda_fixa.setNome(res.getString("nome"));
				renda_fixa.setPorcentagem(res.getFloat("porcentagem"));
				renda_fixa.setTipo(res.getInt("tipo"));
				renda_fixa.setData_resgate((Date) res.getDate("data_resgate"));
				
				rendas_fixas.add(renda_fixa);
			}
			
			return rendas_fixas;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			db.closeConexao();
		}
	}

	public boolean update(RendaFixa renda_fixa, int id) {
		Conexao db = new Conexao();
		Connection con = db.getConexao();

		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sqlUpdate);

			pstm.setString(1, renda_fixa.getNome());
			pstm.setFloat(2, renda_fixa.getPorcentagem());
			pstm.setInt(3, renda_fixa.getTipo());
			pstm.setDate(4, (Date) renda_fixa.getData_resgate());
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
	
	public boolean update(RendaFixa renda_fixa) {
		Conexao db = new Conexao();
		Connection con = db.getConexao();

		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sqlUpdate);

			pstm.setString(1, renda_fixa.getNome());
			pstm.setFloat(2, renda_fixa.getPorcentagem());
			pstm.setInt(3, renda_fixa.getTipo());
			pstm.setDate(4, (Date) renda_fixa.getData_resgate());
			pstm.setInt(5, renda_fixa.getId());

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
