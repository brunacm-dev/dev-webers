package entities;

public class Operacao {
	private int	id;
	private String codigo;
	private int tipo;
	private float valor;

	public Operacao() {
	}

	public Operacao (String codigo, int tipo, float valor) {
		super();
		this.tipo = tipo;
		this.codigo = codigo;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int id) {
		this.tipo = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
}