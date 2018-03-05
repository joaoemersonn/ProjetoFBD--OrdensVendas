package dao;

import java.util.List;

import modelo.DaoException;
import modelo.Funcionario;

public interface IFuncionarioDao {
	public void salvar(Funcionario funcionario) throws DaoException;
	public List<Funcionario> getFuncionarios(String busca) throws DaoException;
	public Funcionario getFuncionario(String busca) throws DaoException;
	public void excluir(String cpf) throws DaoException;
	public void editar(Funcionario f, String cpfOld) throws DaoException;
}
