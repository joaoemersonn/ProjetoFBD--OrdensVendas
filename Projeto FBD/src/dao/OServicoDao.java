package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import app.SQLUtil;
import fachada.Fachada;
import modelo.DaoException;
import modelo.OServico;

public class OServicoDao implements IOServicoDao{
	PreparedStatement statement;	

	@Override
	public void salvar(OServico os) throws DaoException {
		try {
			statement = SQLUtil.prepareStatement(SQLUtil.INSERIR_OSERVICO);
			statement.setString(1, os.getDataAbertura());
			statement.setString(2, os.getHoraAbertura());
			statement.setFloat(3, os.getValor());
			statement.setString(4, os.getDescricao());
			statement.setString(5, os.getObservacoes());
			statement.setString(6, os.getFuncionario().getCpf());
			statement.setString(7, os.getCliente().getCpf());
			statement.setString(8, os.getTecnico().getCpf());
			statement.setInt(9, os.getEnd());
			statement.execute();			
		} catch (Exception edd) { throw new DaoException("Erro ao Inserir Ordem de Serviço",edd.getMessage());}
	}

	@Override
	public List<OServico> getOrdens(String string, Fachada fachada) throws DaoException {
		ArrayList<OServico> ordens = new ArrayList<>();

		try {
			statement = SQLUtil.prepareStatement(string.isEmpty()?"select * from servico ": "select * from servico where descricao ilike '%"+string+"%'"
					+ " or cpf_tecnico ilike '%"+string+"%' or cpf_funcionario ilike '%"+string+"%'");
			ResultSet result =  statement.executeQuery();
			while(result.next()) {
				OServico os = new OServico();
				os.setId(result.getInt(1));
				os.setDataAbertura(result.getString(2));
				os.setHoraAbertura(result.getString(3));
				os.setDataInicio(result.getString(4));
				os.setDataFim(result.getString(5));
				os.setHoraInicio(result.getString(6));
				os.setHoraFim(result.getString(7));
				os.setValor(result.getFloat(8));
				os.setDescricao(result.getString(9));
				os.setObservacoes(result.getString(10));				
				os.setFuncionario(fachada.getFuncionario(result.getString(11)));
				os.setCliente(fachada.getCliente(result.getString(12)));
				os.setTecnico(fachada.getFuncionario(result.getString(13)));
				os.setEnd(result.getInt(14));
				ordens.add(os);
			}

		} catch (Exception e) {throw new DaoException("Erro ao buscar Ordens de Serviço", e.getMessage());		}
		return ordens;
	}

	@Override
	public void excluir(int id) throws DaoException {
		try {
			statement = SQLUtil.prepareStatement("delete from servico where id_servico = '"+id+"'");
			statement.execute();
		} catch (Exception e) {new DaoException("Erro ao excluir OS",e.getMessage());}

	}

	@Override
	public void finalizar(OServico o) throws DaoException {
		try {
			statement = SQLUtil.prepareStatement(SQLUtil.FINALIZAR_OS);
			//data_inicio = ?, data_fim=?, hora_inicio=?, hora_fim=?, valor =? where id_servico = ?
			statement.setString(1, o.getDataInicio());
			statement.setString(2, o.getDataFim());
			statement.setString(3, o.getHoraInicio());
			statement.setString(4, o.getHoraFim());
			statement.setFloat(5, o.getValor());
			statement.setInt(6, o.getId());
			statement.execute();
		} catch (Exception e) {throw new DaoException("Erro ao Finalizar OS",e.getMessage());}
	}

	@Override
	public void editar(OServico os) throws DaoException {
		try {
		//	System.out.println(os.toString());
			statement = SQLUtil.prepareStatement(SQLUtil.ALTERAR_OSERVICO);
			statement.setFloat(1, os.getValor());
			statement.setString(2, os.getDescricao());
			statement.setString(3, os.getObservacoes());
			statement.setString(4, os.getFuncionario().getCpf());
			statement.setString(5, os.getCliente().getCpf());
			statement.setString(6, os.getTecnico().getCpf());
			statement.setInt(7, os.getEnd());
			statement.setInt(8, os.getId());
			statement.execute();			
		} catch (Exception edd) { throw new DaoException("Erro ao Editar Ordem de Serviço",edd.getMessage());}
	}
}
