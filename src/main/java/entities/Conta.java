package entities;
import java.util.Random;

public class Conta {
	private String codigo;
	private float saldo;
	private String cpf;

	public Conta() {
		this.codigo = gerarCodigo();
	}

	public Conta(String codigo, float saldo, String cpf) {
		super();
		this.codigo = codigo;
		this.saldo = saldo;
		this.cpf = cpf;
	}
	
	public Conta(float saldo, String cpf) {
		super();
		this.codigo = gerarCodigo();
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

    private String gerarCodigo() {
        String caracteres = "1234567890";
        StringBuilder cod = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int indice = random.nextInt(caracteres.length());
            cod.append(caracteres.charAt(indice));
        }

        return cod.toString();
    }
}
