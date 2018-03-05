package fachada;

import java.util.List;

import app.Util;
import dao.ClienteDao;
import dao.FuncionarioDao;
import dao.IClienteDao;
import dao.IFuncionarioDao;
import dao.IOServicoDao;
import dao.IProdutoDao;
import dao.IVendaDao;
import dao.OServicoDao;
import dao.ProdutoDao;
import dao.VendaDao;
import modelo.Cliente;
import modelo.DaoException;
import modelo.Funcionario;
import modelo.OServico;
import modelo.Produto;
import modelo.Venda;

public class Fachada implements IFachada{
	IProdutoDao pdao= new ProdutoDao();
	IClienteDao cDao = new ClienteDao();
	IVendaDao vendaDao = new VendaDao();
	IOServicoDao osDao = new OServicoDao();
	IFuncionarioDao funcionarioDao = new FuncionarioDao();


	@Override
	public void salvarProduto(Produto produto) throws DaoException {
		pdao.salvar(produto);	
	}
	@Override
	public void salvarCliente(Cliente cliente) throws DaoException {
		cDao.salvar(cliente);
	}


	@Override
	public List<Produto> getProduto(String chavePesquisa) throws DaoException {
		return pdao.getProdutos(chavePesquisa);
	}
	@Override
	public void excluirProduto(String codigo) throws DaoException {
		pdao.excluirProduto(codigo);

	}
	@Override
	public void editarProduto(Produto produtoTela) throws DaoException {
		pdao.editarProduto(produtoTela);
	}
	@Override
	public void finalizarVenda(Venda venda) throws DaoException {
		venda.setData(Util.getDataAtual());
		venda.setHora(Util.getHoraAtual());
		vendaDao.finalizar(venda);

	}
	@Override
	public void salvarOS(OServico os) throws DaoException {
		os.setDataAbertura(Util.getDataAtual());
		os.setHoraAbertura(Util.getHoraAtual());
		osDao.salvar(os);
	}

	@Override
	public void salvarFuncionario(Funcionario funcionario) throws DaoException {
		funcionarioDao.salvar(funcionario);
	}
	@Override
	public List<Funcionario> getFuncionarios(String chaveBusca) throws DaoException {
		return funcionarioDao.getFuncionarios(chaveBusca);
	}
	@Override
	public void excluirFuncionario(String cpf) throws DaoException {
		funcionarioDao.excluir(cpf);
	}
	@Override
	public Funcionario getFuncionario(String cpf) throws DaoException {
		return funcionarioDao.getFuncionario(cpf);
	}
	@Override
	public void editarFuncionario(Funcionario f, String cpfOld) throws DaoException {
		funcionarioDao.editar(f, cpfOld);
	}
	@Override
	public List<Cliente> getClientes(String string) throws DaoException {
		return cDao.getClientes(string);
	}
	@Override
	public void editarCliente(Cliente clienteTela, String cpf) throws DaoException {
		cDao.editar(clienteTela, cpf);
	}
	@Override
	public void excluirCliente(String cpfInTable) throws DaoException {
		cDao.excluir(cpfInTable);
	}
	@Override
	public List<OServico> getOS(String string) throws DaoException {
		return osDao.getOrdens(string, this);
	}
	@Override
	public Cliente getCliente(String cpf) throws DaoException {
		return cDao.getCliente(cpf);
	}
	@Override
	public void excluirOS(int id) throws DaoException {
		osDao.excluir(id);
	}
	@Override
	public void finalizarOS(OServico ordem) throws DaoException {
		osDao.finalizar(ordem);
	}
	@Override
	public void editarOS(OServico ordem) throws DaoException {
		osDao.editar(ordem);
	}
	@Override
	public List<Venda> getVendas(String string) throws DaoException {
		return vendaDao.getVendas(string,this);
	}
	@Override
	public Venda getVenda(String string) throws DaoException {
		return vendaDao.getVenda(string, this);
	}
	@Override
	public void excluirVenda(int string) throws DaoException {
		vendaDao.excluir(string,this);
	}
	@Override
	public void editarVenda(Venda v) throws DaoException {
		vendaDao.editar(v);
	}
	@Override
	public void debitoCliente(Cliente c) throws DaoException {
		cDao.alterarDebito(c);
	}
	@Override
	public List<Produto> getProdutoVenda(String chavePesquisa) throws DaoException {
		return pdao.getProdutosDisp(chavePesquisa);
	}





}
