Bernardo:

package polimorfismo;

import principal.Pessoa;

public abstract class Funcionario extends Pessoa{
	protected float salBase;
	protected float salario;

	Funcionario(String nome, String end, float salBase){
		super(nome, end);
		this.salBase = salBase;	
	}
	
	public Funcionario(String nome, String endereco) {
		super(nome, endereco);
	}
	
	public abstract void calcularSal();
	
	public void exibirDados() {
		System.out.println("Nome: " + nome);
		System.out.println("Endereço: " + end);
		System.out.println("Base salarial: " + salBase);
		System.out.println("Salário: " + salario);
	}
}

package polimorfismo;

public class PessoaJuridica extends Funcionario{
	public float numHoras;
	public float valHora;
	
	PessoaJuridica(String nome, String end, float numHoras, float valHora){
		super(nome, end);
		this.numHoras = numHoras;
		this.valHora = valHora;
	}
	
	public void calcularSalario() {
		salario = numHoras * valHora;
	}

}

package polimorfismo;

public class PessoaFisica extends Funcionario{
	public float desc;
	
	PessoaFisica(String nome, String end, float salBase){	
		super(nome, end, salBase);
	}
	
	public void setDesconto() {
		desc = calcularDesconto()*salBase;
	}
	
	public void calcularSal() {
		setDesconto();
		salario = salBase - desc;
	}
}

package principal;

public class Pessoa {
	public String nome;
	public String end;
	
	Pessoa(String nome, String end){
		this.nome = nome;
		this.end = end;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public double calcularDesconto() {
		return 0.27;		
	}

}
