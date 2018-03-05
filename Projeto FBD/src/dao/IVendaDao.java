package dao;

import java.util.List;

import fachada.Fachada;
import modelo.DaoException;
import modelo.Venda;

public interface IVendaDao {
	
	public void finalizar(Venda venda) throws DaoException;

	public List<Venda> getVendas(String string, Fachada fachada) throws DaoException;
	public Venda getVenda(String string, Fachada fachada) throws DaoException;
	public void excluir(int id_venda, Fachada fachada) throws DaoException;
	public void editar(Venda v) throws DaoException;
}
