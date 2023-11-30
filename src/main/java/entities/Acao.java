package entities;

public class Acao {
	private int id;
	private String nome;
	private String descricao;
	private float preco_unitario;

	public Acao() {
	}
	
	public Acao(String nome, String descricao, float preco_unitario) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco_unitario = preco_unitario;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco_unitario() {
		return preco_unitario;
	}

	public void setPreco_unitario(float preco_unitario) {
		this.preco_unitario = preco_unitario;
	}
}
