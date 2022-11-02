package teste;

import java.util.ArrayList;

public class Funcionario {
	
	String cpf;
	String nome;
	int idade;
	double salario;
	String cargo;
	ArrayList<String> habilidades;
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public ArrayList<String> getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(ArrayList<String> habilidades) {
		this.habilidades = habilidades;
	}
	
}
