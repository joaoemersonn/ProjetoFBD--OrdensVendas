package modelo;

import java.util.ArrayList;

public class Venda {
	private int id_venda;
	private String data,hora;// cpf_funcionario, cpf_cliente;
	private Funcionario funcionario;
	private Cliente cliente;
	private float valor;
	private ArrayList<Produto> produtos = new ArrayList<>();
	
	public int getId_venda() {
		return id_venda;
	}
	public float atualizarTotal() {
		valor = 0;
		for(Produto p: produtos)
			valor += (p.getLotes().get(0).getPrecoV()*p.getLotes().get(0).getQuantidade());
		return valor;
	}
	
	public void setId_venda(int id_venda) {
		this.id_venda = id_venda;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}




	

	
}
