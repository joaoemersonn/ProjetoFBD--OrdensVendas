package dao;

import java.util.List;

import modelo.Cliente;
import modelo.DaoException;
import modelo.Endereco;

public interface IClienteDao {
	
	public void salvar(Cliente cliente) throws DaoException;
	public void salvarEndereco(String cpfCliente, Endereco end) throws DaoException;
	public List<Cliente> getClientes(String string) throws DaoException;
	public void excluir(String cpfCliente) throws DaoException;
	public void editar(Cliente cliente, String cpfOld) throws DaoException;
	public Cliente getCliente(String cpf) throws DaoException;
	public void alterarDebito(Cliente c) throws DaoException;
}
