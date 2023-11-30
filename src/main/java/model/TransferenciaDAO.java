package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Transferencia;

public class TransferenciaDAO {
	private String sqlCreate = "INSERT INTO Transferencias(codigo_remetente, codigo_destinatario, valo) VALUES (?, ?, ?)";
	private String sqlAll = "Select * from Transferencias";
	private String sqlUpdate = "UPDATE Transferencias Set codigo_remetente = ?, codigo_destinatario = ?, valor = ? WHERE id = ?";
	private String sqlDelete = "DELETE from Transferencias WHERE id = ?";
	
	public TransferenciaDAO() {
	}
	
	public boolean save(Transferencia transferencia) {
		Conexao db = new Conexao();
		Connection con = db.getConexao();

		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sqlCreate);

			pstm.setString(1, transferencia.getCodigo_remetente());
			pstm.setString(2, transferencia.getCodigo_destinatario());
			pstm.setFloat(3, transferencia.getValor());

			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			db.closeConexao();
		}
	}
	
	public List<Transferencia> all() {
		Conexao db = new Conexao();
		Connection con = db.getConexao();
		List<Transferencia> transferencias = new ArrayList<Transferencia>();

		PreparedStatement pstm = null;
		ResultSet res = null;

		try {
			pstm = con.prepareStatement(sqlAll);
			res = pstm.executeQuery();
			
			while(res.next()) {
				Transferencia transferencia = new Transferencia();
				transferencia.setId(res.getInt("id"));
				transferencia.setCodigo_remetente(res.getString("codigo_remetente"));
				transferencia.setCodigo_destinatario(res.getString("codigo_destinatario"));
				transferencia.setValor(res.getFloat("valor"));
				
				transferencias.add(transferencia);
			}
			
			return transferencias;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			db.closeConexao();
		}
	}

	public boolean update(Transferencia transferencia, int id) {
		Conexao db = new Conexao();
		Connection con = db.getConexao();

		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sqlUpdate);

			pstm.setString(1, transferencia.getCodigo_remetente());
			pstm.setString(2, transferencia.getCodigo_destinatario());
			pstm.setFloat(3, transferencia.getValor());
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
	
	public boolean update(Transferencia transferencia) {
		Conexao db = new Conexao();
		Connection con = db.getConexao();

		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sqlUpdate);

			pstm.setString(1, transferencia.getCodigo_remetente());
			pstm.setString(2, transferencia.getCodigo_destinatario());
			pstm.setFloat(3, transferencia.getValor());
			pstm.setInt(4, transferencia.getId());

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
