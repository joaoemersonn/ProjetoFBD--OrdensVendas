package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import app.SQLUtil;
import modelo.DaoException;
import modelo.Funcionario;
import view.Mensagens;

public class FuncionarioDao implements IFuncionarioDao{
	PreparedStatement statement;

	@Override
	public void salvar(Funcionario funcionario) throws DaoException {
		try {
			statement = SQLUtil.prepareStatement(SQLUtil.INSERIR_FUNCIONARIO);
			statement.setString(1, funcionario.getNome());
			statement.setString(2, funcionario.getCpf());
			statement.setString(3, funcionario.getRg());
			statement.setString(4, funcionario.getLogin());
			statement.setString(5, funcionario.getSenha());
			statement.execute();
		} catch (Exception e) {throw new DaoException("Erro ao inserir funcionário no Banco");}
	}

	@Override
	public List<Funcionario> getFuncionarios(String chaveBusca) throws DaoException {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try {
			statement = SQLUtil.prepareStatement(chaveBusca.isEmpty()?"select * from funcionario ":"select * "
					+ "from funcionario where cpf like '%"+chaveBusca+"%' or nome ilike '%"+chaveBusca+"%' order by nome");
			ResultSet result = this.statement.executeQuery();
			Funcionario funcionario;
			while(result.next()){		           
				funcionario= new Funcionario();
				funcionario.setNome(result.getString(1));
				funcionario.setCpf(result.getString(2));
				funcionario.setRg(result.getString(3));
				funcionario.setLogin(result.getString(4));
				funcionario.setSenha(result.getString(5));
				funcionarios.add(funcionario);
			}
			return funcionarios;

		} catch (Exception e) {throw new DaoException("Erro ao Buscar Funcionário",e.getMessage());}


	}

	@Override
	public void editar(Funcionario f, String cpfOld) throws DaoException {
		try {
			statement = SQLUtil.prepareStatement(SQLUtil.EDITAR_FUNCIONARIO);
			statement.setString(1, f.getNome());
			statement.setString(2, f.getCpf());
			statement.setString(3, f.getRg());
			statement.setString(4, f.getLogin());
			statement.setString(5, f.getSenha());
			statement.setString(6, cpfOld);
			statement.execute();
			//Mensagens.confirmado("Atualizado Com sucesso");
		} catch (Exception e) {new DaoException("Erro ao Atualizar Funcionário",e.getMessage());}

	}

	@Override
	public Funcionario getFuncionario(String busca) throws DaoException {
		try {
			statement = SQLUtil.prepareStatement("select * from funcionario where cpf = '"+busca+"' order by nome");
			ResultSet result = this.statement.executeQuery();
			Funcionario funcionario;
			result.next();		           
			funcionario= new Funcionario();
			funcionario.setNome(result.getString(1));
			funcionario.setCpf(result.getString(2));
			funcionario.setRg(result.getString(3));
			funcionario.setLogin(result.getString(4));
			funcionario.setSenha(result.getString(5));
			return funcionario;

		} catch (Exception e) {throw new DaoException("Erro ao Buscar Funcionário",e.getMessage());}

	}

	@Override
	public void excluir(String cpf) throws DaoException {
		try {
			statement = SQLUtil.prepareStatement("select * from funcionario");
			ResultSet result = statement.executeQuery();
			result.next();
			if(result.next()) {			
				statement = SQLUtil.prepareStatement("delete from funcionario where cpf = '"+cpf+"'");
				statement.execute();
			}else
				Mensagens.erro("Não É Possível Iniciar o Sistema Sem Nenhum Usuario Cadastrado, Por Favor Tente Cadastrar Um Novo Funcionario Antes Dessa Exclusão");
		} catch (Exception e) {new DaoException("Erro ao Excluir Funcioario", e.getMessage());}
	}

}