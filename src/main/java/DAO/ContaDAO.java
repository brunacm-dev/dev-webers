package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Conta;


public class ContaDAO {
	private String sqlGet = "SELECT * FROM Contas WHERE cpf = ?";
	private String sqlCreate = "INSERT INTO Contas(codigo, cpf) VALUES (?, ?)";
	private String sqlAll = "Select * from Contas";
	private String sqlUpdate = "UPDATE Contas Set saldo = ?, cpf = ? WHERE codigo = ?";
	private String sqlDelete = "DELETE from Contas WHERE codigo = ?";
	
	public ContaDAO() {
	}
	
	public Conta get(String cpf) {
		Conexao db = new Conexao();
		Connection con = db.getConexao();
		Conta conta = new Conta();

		PreparedStatement pstm = null;
		ResultSet res = null;

		try {
			pstm = con.prepareStatement(sqlGet);
			pstm.setString(1, cpf);
			res = pstm.executeQuery();

			if(res.next()) {
				conta.setCodigo(res.getString("codigo"));
				conta.setSaldo(res.getFloat("saldo"));
				conta.setCpf(res.getString("cpf"));
				
			}else {
				System.out.println("Conta não encontrada");
			}
			
			return conta;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			db.closeConexao();
		}
	}
	
	public boolean save(Conta conta) {
		Conexao db = new Conexao();
		Connection con = db.getConexao();

		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sqlCreate);

			pstm.setString(1, conta.getCodigo());
			pstm.setString(2, conta.getCpf());

			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			db.closeConexao();
		}
	}
	
	public List<Conta> all() {
		Conexao db = new Conexao();
		Connection con = db.getConexao();
		List<Conta> contas = new ArrayList<Conta>();

		PreparedStatement pstm = null;
		ResultSet res = null;

		try {
			pstm = con.prepareStatement(sqlAll);
			res = pstm.executeQuery();

			while(res.next()) {
				Conta conta = new Conta();
				conta.setCodigo(res.getString("codigo"));
				conta.setSaldo(res.getFloat("saldo"));
				conta.setCpf(res.getString("cpf"));
				
				contas.add(conta);
			}
			
			return contas;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			db.closeConexao();
		}
	}
	
	public boolean update(Conta conta, String codigo) {
		Conexao db = new Conexao();
		Connection con = db.getConexao();

		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sqlUpdate);

			pstm.setFloat(1, conta.getSaldo());
			pstm.setString(2, conta.getCpf());
			pstm.setString(3, codigo);

			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			db.closeConexao();
		}
	}
	
	public boolean update(Conta conta) {
		Conexao db = new Conexao();
		Connection con = db.getConexao();

		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sqlUpdate);

			pstm.setFloat(1, conta.getSaldo());
			pstm.setString(2, conta.getCpf());
			pstm.setString(3, conta.getCodigo());

			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			db.closeConexao();
		}
	}
	
	public void deleteByCpf(String codigo) {
		Conexao db = new Conexao();
		Connection con = db.getConexao();

		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sqlDelete);
			pstm.setString(1, codigo);
			pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			db.closeConexao();
		}
	}
}