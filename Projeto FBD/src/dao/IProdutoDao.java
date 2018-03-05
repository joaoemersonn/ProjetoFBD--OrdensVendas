package dao;


import java.util.List;

import modelo.DaoException;
import modelo.Produto;

public interface IProdutoDao {
	
	public void salvar(Produto produto) throws DaoException;
	
	public void excluirProduto(String codigo) throws DaoException;
	
	public List<Produto> getProdutos(String chaveBusca) throws DaoException;
	
	public List<Produto> getProdutosDisp(String chaveBusca) throws DaoException;

	public void editarProduto(Produto produtoTela) throws DaoException;
	
}
