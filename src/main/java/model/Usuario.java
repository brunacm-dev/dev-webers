package model;

public class Usuario {
	private String nome;
	private String sobrenome;
	private String email;
	private int tipo;
	private int status;
	private String cpf;
	private String senha;

	
	public Usuario() {
	}

	public Usuario(String nome, String sobrenome, String email, int tipo, int status, String cpf, String senha) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.tipo = tipo;
		this.status = status;
		this.cpf = cpf;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean isAdmin() {
		return this.tipo == 1;
	}
	
	public boolean isClient() {
		return this.tipo == 0;
	}
	
	public void SetEmSolicitacao() {
		this.status = 0;
	}
	
	public void SetCliente() {
		this.tipo = 0;
	}
	
	public void SetAdmin() {
		this.tipo = 0;
	}

}
