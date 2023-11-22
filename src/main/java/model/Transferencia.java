package model;

public class Transferencia {
	private int	id;
	private String codigo_remetente;
	private String codigo_destinatario;
	private float valor;

	public Transferencia() {
	}

	public Transferencia(String codigo_rementente, String codigo_destinatario, float valor) {
		super();
		this.codigo_remetente = codigo_rementente;
		this.codigo_destinatario = codigo_destinatario;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo_remetente() {
		return codigo_remetente;
	}

	public void setCodigo_remetente(String codigo_remetente) {
		this.codigo_remetente = codigo_remetente;
	}

	public String getCodigo_destinatario() {
		return codigo_destinatario;
	}

	public void setCodigo_destinatario(String codigo_destinatario) {
		this.codigo_destinatario = codigo_destinatario;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
}
