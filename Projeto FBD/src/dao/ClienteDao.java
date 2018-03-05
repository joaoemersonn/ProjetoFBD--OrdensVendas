package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import app.SQLUtil;
import modelo.Cliente;
import modelo.DaoException;
import modelo.Endereco;

public class ClienteDao implements IClienteDao{
	PreparedStatement statement;
	
	@Override
	public void salvar(Cliente cliente) throws DaoException {
		try {
			statement = SQLUtil.prepareStatement(SQLUtil.INSERIR_CLIENTE);			
			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getRg());
			statement.setString(3, cliente.getCpf());
			statement.setString(4, cliente.getTelefone());
			statement.execute();
			for(Endereco e : cliente.getEnderecos()) {
			statement = SQLUtil.prepareStatement(SQLUtil.INSERIR_ENDERECO);
			statement.setString(1, e.getRua());
			statement.setString(2, e.getNumero());
			statement.setString(3, e.getBairro());
			statement.setString(4, e.getCidade());
			statement.setString(5, e.getCep());
			statement.setString(6, cliente.getCpf());
			statement.execute();
			}		
			
			// Mensagens.confirmado("O Cliente Foi Cadastrado Com Sucesso!");
		} catch (Exception e) {
			throw new DaoException("Erro ao Inserir Cliente",e.getMessage());
		}
	}

	@Override
	public void salvarEndereco(String cpfCliente, Endereco end) throws DaoException {
		try {
			statement = SQLUtil.prepareStatement(SQLUtil.INSERIR_ENDERECO);
			statement.setString(1, end.getRua());
			statement.setString(2, end.getNumero());
			statement.setString(3, end.getBairro());
			statement.setString(4, end.getCidade());
			statement.setString(5, end.getCep());
			statement.setString(6, cpfCliente);
			statement.execute();		
		} catch (Exception e) {
			throw new DaoException("Erro ao Inserir Cliente",e.getMessage());
		}
		
	}
	public Cliente getCliente(String cpf) throws DaoException{
		try {
			Cliente c = new Cliente();
			statement = SQLUtil.prepareStatement("select * from cliente where cpf = '"+cpf+"'");
			ResultSet result = statement.executeQuery();
			result.next();
			c.setNome(result.getString(1));
			c.setRg(result.getString(2));
			c.setCpf(result.getString(3));
			c.setTelefone(result.getString(4));
			c.setDebito(result.getFloat(5));
			statement = SQLUtil.prepareStatement("select * from endereco where cpf_cliente = '"+c.getCpf()+"'");
			ResultSet endResult = statement.executeQuery();
			while(endResult.next()) {
				Endereco end = new Endereco();
				end.setRua(endResult.getString(2));
				end.setNumero(endResult.getString(3));
				end.setBairro(endResult.getString(4));
				end.setCidade(endResult.getString(5));
				end.setCep(endResult.getString(6));
				c.getEnderecos().add(end);
			}
			
			return c;
		} catch (Exception e) {new DaoException("Erro ao buscar Cliente");
		return null;
		}
		
	}

	@Override
	public List<Cliente> getClientes(String string) throws DaoException {
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			statement = SQLUtil.prepareStatement(string.isEmpty()?"select * from cliente ":"select * "
					+ "from cliente where cpf like '%"+string+"%' or nome ilike '%"+string+"%' order by nome");
			ResultSet result = this.statement.executeQuery();
			Cliente cliente;
			while(result.next()){		           
				cliente= new Cliente();
				cliente.setNome(result.getString(1));
				cliente.setRg(result.getString(2));
				cliente.setCpf(result.getString(3));
				cliente.setTelefone(result.getString(4));
				cliente.setDebito(result.getFloat(5));
				statement = SQLUtil.prepareStatement("select * from endereco where cpf_cliente = '"+cliente.getCpf()+"'");
				ResultSet endResult = statement.executeQuery();
				while(endResult.next()) {
					Endereco end = new Endereco();
					end.setRua(endResult.getString(2));
					end.setNumero(endResult.getString(3));
					end.setBairro(endResult.getString(4));
					end.setCidade(endResult.getString(5));
					end.setCep(endResult.getString(6));
					cliente.getEnderecos().add(end);
				}
				clientes.add(cliente);
			}
			return clientes;

		} catch (Exception e) {throw new DaoException("Erro ao Buscar Produto",e.getMessage());}

	}

	@Override
	public void excluir(String cpfCliente) throws DaoException {
		try {
			statement = SQLUtil.prepareStatement("update venda set cpf_cliente = null where cpf_cliente ='"+cpfCliente+"'");
			statement.execute();
			statement = SQLUtil.prepareStatement("delete from endereco where cpf_cliente ='"+cpfCliente+"'");
			statement.execute();
			statement = SQLUtil.prepareStatement("delete from cliente where cpf ='"+cpfCliente+"'");
			statement.execute();
		} catch (Exception e) {new DaoException("Erro ao Excluir Cliente", e.getMessage());
		}
	}

	@Override
	public void editar(Cliente cliente, String cpfOld) throws DaoException {
		try {
			statement = SQLUtil.prepareStatement("delete from endereco where cpf_cliente ='"+cpfOld+"'");
			statement.execute();
//			statement = SQLUtil.prepareStatement("update venda set cpf_cliente = '"+cliente.getCpf()+"' where cpf_cliente ='"+cpfOld+"'");
//			statement.execute();
			statement = SQLUtil.prepareStatement(SQLUtil.EDITAR_CLIENTE);
			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getCpf());
			statement.setString(3, cliente.getRg());
			statement.setString(4, cliente.getTelefone());
			statement.setString(5, cpfOld);
			statement.execute();
			for(Endereco e : cliente.getEnderecos()) {
			statement = SQLUtil.prepareStatement(SQLUtil.INSERIR_ENDERECO);			
			statement.setString(1, e.getRua());
			statement.setString(2, e.getNumero());
			statement.setString(3, e.getBairro());
			statement.setString(4, e.getCidade());
			statement.setString(5, e.getCep());
			statement.setString(6, cliente.getCpf());
			statement.execute();
			}		
			
		//	 Mensagens.confirmado("O Cliente Foi Cadastrado Com Sucesso!");
		} catch (Exception e) {
			throw new DaoException("Erro ao Inserir Cliente",e.getMessage());
		}	
	}

	@Override
	public void alterarDebito(Cliente c) throws DaoException {
		try {
			statement = SQLUtil.prepareStatement("update cliente set debito = "+c.getDebito()+" where cpf ='"+c.getCpf()+"'");
			statement.execute();
		} catch (Exception e) { throw new DaoException("Erro ao Alterar Débito do Cliente "+c.getNome(),e.getMessage());}
		
	}
	
	
}
