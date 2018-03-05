package dao;

import java.util.List;

import fachada.Fachada;
import modelo.DaoException;
import modelo.OServico;

public interface IOServicoDao {
	
	public void salvar(OServico oservico) throws DaoException;

	public List<OServico> getOrdens(String string, Fachada fachada) throws DaoException;

	public void excluir(int id) throws DaoException;

	public void finalizar(OServico ordem) throws DaoException;

	public void editar(OServico ordem) throws DaoException;
}
