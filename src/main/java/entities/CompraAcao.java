package entities;

import java.sql.Date;

public class CompraAcao {
	private int id;
	private int quantidade;
	private Date datetime_compra;
	private float preco_unitario;
	private String codigo;
	private int acao_id;

	public CompraAcao() {
	}

	public CompraAcao(int quantidade, Date datetime_compra, float preco_unitario, String codigo, int acao_id) {
		super();
		this.quantidade = quantidade;
		this.datetime_compra = datetime_compra;
		this.preco_unitario = preco_unitario;
		this.codigo = codigo;
		this.acao_id = acao_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDatetime_compra() {
		return datetime_compra;
	}

	public void setDatetime_compra(Date datetime_compra) {
		this.datetime_compra = datetime_compra;
	}

	public float getPreco_unitario() {
		return preco_unitario;
	}

	public void setPreco_unitario(float preco_unitario) {
		this.preco_unitario = preco_unitario;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getAcao_id() {
		return acao_id;
	}

	public void setAcao_id(int acao_id) {
		this.acao_id = acao_id;
	}
}
