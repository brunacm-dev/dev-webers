package entities;

import java.util.Date;

public class RendaFixa {
	private int id;
	private String nome;
	private float porcentagem;
	private int tipo;
	private Date data_resgate;

	public RendaFixa() {
		// TODO Auto-generated constructor stub
	}

	public RendaFixa(String nome, float porcentagem, int tipo, Date data_resgate) {
		super();
		this.nome = nome;
		this.porcentagem = porcentagem;
		this.tipo = tipo;
		this.data_resgate = data_resgate;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(float porcentagem) {
		this.porcentagem = porcentagem;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Date getData_resgate() {
		return data_resgate;
	}

	public void setData_resgate(Date data_resgate) {
		this.data_resgate = data_resgate;
	}
}
