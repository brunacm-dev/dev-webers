package model;

import java.sql.Date;

public class CompraRendaFixa {
	private int id;
	private float valor_investido;
	private Date datetime_compra;
	private String codigo;
	private int renda_fixa_id;

	public CompraRendaFixa() {
	}

	public CompraRendaFixa(float valor_investido, Date datetime_compra, String codigo, int renda_fixa_id) {
		super();
		this.valor_investido = valor_investido;
		this.datetime_compra = datetime_compra;
		this.codigo = codigo;
		this.renda_fixa_id = renda_fixa_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getValor_investido() {
		return valor_investido;
	}

	public void setValor_investido(float valor_investido) {
		this.valor_investido = valor_investido;
	}

	public Date getDatetime_compra() {
		return datetime_compra;
	}

	public void setDatetime_compra(Date datetime_compra) {
		this.datetime_compra = datetime_compra;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getRenda_fixa_id() {
		return renda_fixa_id;
	}

	public void setRenda_fixa_id(int renda_fixa_id) {
		this.renda_fixa_id = renda_fixa_id;
	}
}
