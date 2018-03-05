package fachada;

import java.util.List;

import modelo.Cliente;
import modelo.DaoException;
import modelo.Funcionario;
import modelo.OServico;
import modelo.Produto;
import modelo.Venda;

public interface IFachada {
	
	public void salvarProduto(Produto produto) throws DaoException;
	public void salvarFuncionario(Funcionario funcionario) throws DaoException;
	public void salvarCliente(Cliente cliente) throws DaoException;
	public void finalizarVenda(Venda venda) throws DaoException;	
	public void salvarOS(OServico os) throws DaoException;
	
	public List<Produto> getProduto(String chavePesquisa) throws DaoException;
	public List<Produto> getProdutoVenda(String chavePesquisa) throws DaoException;
	public List<Funcionario> getFuncionarios(String chaveBusca) throws DaoException;
	public Funcionario getFuncionario(String cpf) throws DaoException;
	public Cliente getCliente(String cpf) throws DaoException;
	
	public void excluirProduto(String codigo) throws DaoException;
	public void excluirFuncionario(String cpf) throws DaoException;
	public void editarProduto(Produto produtoTela) throws DaoException;
	public void editarFuncionario(Funcionario f, String cpfOld) throws DaoException;
	public List<Cliente> getClientes(String string) throws DaoException;
	public void editarCliente(Cliente clienteTela, String cpf) throws DaoException;
	public void excluirCliente(String cpfInTable) throws DaoException;
	public List<OServico> getOS(String string) throws DaoException;
	public void excluirOS(int id) throws DaoException;
	public void finalizarOS(OServico ordem) throws DaoException;
	public void editarOS(OServico ordem) throws DaoException;
	public List<Venda> getVendas(String string) throws DaoException;
	public Venda getVenda(String string) throws DaoException;
	public void excluirVenda(int string) throws DaoException;
	public void editarVenda(Venda v) throws DaoException;
	public void debitoCliente(Cliente c) throws DaoException;
	

	
	
	
	
	
	
	
	

}
