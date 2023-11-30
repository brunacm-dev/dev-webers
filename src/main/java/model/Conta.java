package model;

public class Conta {
	private String codigo;
	private float saldo;
	private String cpf;

	public Conta() {
	}

	public Conta(String codigo, float saldo, String cpf) {
		super();
		this.codigo = codigo;
		this.saldo = saldo;
		this.cpf = cpf;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void depositar(float valor) {
		this.saldo = this.saldo + valor;
	}
	
	public void sacar(float valor) {
		this.saldo = this.saldo - valor;
	}

}
