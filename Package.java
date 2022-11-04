public class Endereco {
	private String tipo;
	private String nome;
	private int numero;
	private int apto;
	private String complemento;
	//Casa.
	public Endereco(String tipo, String nome, int numero) {
		this.tipo = tipo;
		this.nome = nome;
		this.numero = numero;
	}
	//Casa com complemento.
	public Endereco(String tipo, String nome, int numero, String complemento) {
		this.tipo = tipo;
		this.nome = nome;
		this.numero = numero;
		this.complemento = complemento;
	}
	//Apartamento.
	public Endereco(String tipo, String nome, int numero, int apto) {
		this.tipo = tipo;
		this.nome = nome;
		this.numero = numero;
		this.apto = apto;
	}
	//Apartamento com blocos.
	public Endereco(String tipo, String nome, int numero, int apto, String complemento) {
		this.tipo = tipo;
		this.nome = nome;
		this.numero = numero;
		this.apto = apto;
		this.complemento = complemento;
	}
	public void exibirDados() {
		System.out.print(this.tipo + " " + this.nome + ", " + this.numero);
		if (this.apto != 0) {
			System.out.print(" apto " + this.apto);
		}
		if (this.complemento != null) {
			System.out.print(" - " + this.complemento);
		}
		System.out.println();
	} 
}
public class Cliente {
	private String nomeCliente;
	private String cpf;
	private Endereco endereco;
	public Cliente(String nomeCliente, String cpf, Endereco endereco) {
		this.nomeCliente = nomeCliente;
		this.cpf = cpf;
		this.endereco = endereco;
	}
	public void setNome(String nomeCliente){
		this.nomeCliente = nomeCliente;
	}
	public void setCpf(String cpf){
		this.cpf = cpf;
	}
	public void exibirDados() {
		System.out.println("Nome do cliente: " + this.nomeCliente);
		System.out.println("CPF do cliente: " + this.cpf);
		this.endereco.exibirDados();
	}
}
public class Conta {
	private Cliente cliente;
	private int numero;
	private float saldo;
	public Conta(Cliente cliente, int numero, float saldo) {
		this.cliente = cliente;
		this.numero = numero;
		this.saldo = saldo;
	}
	public boolean saque(float valor) {
		if (valor <= this.saldo) {
			this.saldo -= valor;
			return true;
		}
		else {
			return false;
		}
	}
	/*public void saque(float valor) {
		if (valor <= this.saldo) {
			this.saldo -= valor;
			System.out.println("Saque efetuado.");
		}
		else {
			System.out.println("Saldo insuficiente para o saque.");
		}
	}
	 */
	public void deposito(float valor) {
		this.saldo += valor;
	}
	public void exibirDados(float valor) {
		this.cliente.exibirDados();		
		System.out.println("Número da conta: " + this.numero);
		System.out.println("Saldo da conta: " + this.saldo);
	}
}
import java.util.Scanner;
public class Principal {
	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		System.out.println("Digite o nome do cliente.");
		String nomeCliente = ent.nextLine();
		System.out.println("Digite o CPF do cliente.");
		String cpf = ent.nextLine();
		int opcao;
		do {
		System.out.println("Tipo de moradia: 1- Casa, 2- Casa fundos, 3- Apto, 4- Apto blocos.");
		opcao = ent.nextInt();
		} while (opcao < 1 || opcao > 4);
		System.out.println("Qual o tipo do logradouro?");
		ent.nextLine();
		String tipo = ent.nextLine();
		System.out.println("Qual o nome do logradouro?");
		String nomeLog = ent.nextLine();
		System.out.println("Qual o número do logradouro?");
		int numero = ent.nextInt();
		Endereco endereco;
		if (opcao == 1) {
			endereco = new Endereco(tipo, nomeLog, numero);
		}
		else if (opcao == 2) {
			ent.nextLine();
			System.out.println("Qual o complemento?");
			String complemento = ent.nextLine();
			endereco = new Endereco(tipo, nomeLog, numero, complemento);
		}
		else if (opcao == 3) {
			System.out.println("Qual o número do apartamento?");
			int apto = ent.nextInt();
			endereco = new Endereco(tipo, nomeLog, numero, apto);
		}
		else {
			System.out.println("Qual o número do apartamento?");
			int apto = ent.nextInt();
			ent.nextLine();
			System.out.println("Qual o complemento?");
			String complemento = ent.nextLine();
			endereco = new Endereco(tipo, nomeLog, numero, apto, complemento);
		}
		Cliente cliente = new Cliente(nomeCliente, cpf, endereco);
		System.out.println("Qual o número da conta?");
		int numConta = ent.nextInt();
		System.out.println("Qual o saldo da conta?");
		float saldo = ent.nextFloat();
		Conta conta = new Conta(cliente, numConta, saldo);
		System.out.println("Qual o valor do saque?");
		float valor = ent.nextFloat();
		conta.saque(valor);
		System.out.println("Qual o valor do depósito?");
		valor = ent.nextFloat();
		conta.deposito(valor);
		conta.exibirDados(valor);
		ent.close();
	}
}