package modelo;

import java.util.ArrayList;

public class Cliente {

	private String nome, cpf, rg, telefone;
	private ArrayList<Endereco> enderecos = new ArrayList<>();
	private int id;
	private float debito;
	
	
	public Cliente(){};

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Endereco> getEnderecos() {
		return enderecos;
	}

	

	public float getDebito() {
		return debito;
	}

	public void setDebito(float debito) {
		this.debito = debito;
	}

	public void setEnderecos(ArrayList<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
}
