package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import app.SQLUtil;
import fachada.Fachada;
import modelo.DaoException;
import modelo.Lote;
import modelo.Produto;
import modelo.Venda;

public class VendaDao implements IVendaDao {
	PreparedStatement statement;
	@Override
	public void finalizar(Venda venda) throws DaoException {
		try {
			statement = SQLUtil.prepareStatement(SQLUtil.INSERIR_VENDA);
			statement.setString(1, venda.getCliente()!=null?venda.getCliente().getCpf():null);
			statement.setString(2, venda.getFuncionario().getCpf());
			statement.setString(3, venda.getData());
			statement.setString(4, venda.getHora());
			statement.setFloat(5, venda.getValor());
			statement.execute();
			venda.setId_venda(SQLUtil.getCurrentValorTabela("venda"));
			if(venda.getCliente()!=null) {
				statement = SQLUtil.prepareStatement("update cliente set debito ="+venda.getCliente().getDebito()+" where cpf='"+venda.getCliente().getCpf()+"'");
				statement.execute();
			}
			for(Produto p: venda.getProdutos()) {
				//p.getLotes().add(new Lote());
				statement = SQLUtil.prepareStatement(SQLUtil.INSERIR_VENDA_PRODUTO);
				Lote l = p.getLotes().get(0);
				statement.setInt(1, venda.getId_venda());
				statement.setString(2, p.getCodigo());
				statement.setFloat(3, l.getQuantidade());
				statement.execute();
				statement = SQLUtil.prepareStatement(SQLUtil.VENDER_PRODUTO);
				statement.setFloat(1, l.getQuantidade());
				statement.setString(2, p.getLote_ativo());
				statement.execute();
			}
		} catch (Exception e) {
			throw new DaoException("Erro ao Finalizar Venda",e.getMessage());

		}
	}
	@Override
	public List<Venda> getVendas(String string, Fachada fachada) throws DaoException {
		ArrayList<Venda> vendas = new ArrayList<>();
		try {
			String cpfC = "";
			if(fachada.getClientes(string).size()>0)
				cpfC  = fachada.getClientes(string).get(0).getCpf();
			//String cpfF = fachada.getFuncionarios(string).get(0)!=null?fachada.getFuncionarios(string).get(0).getCpf():"";
			statement = SQLUtil.prepareStatement(string.isEmpty()?"select * from venda":"select * from venda where  cpf_cliente = '"+cpfC+"' ");//or cpf_funcionario = '"+cpfF+"'");
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Venda venda = new Venda();
				//ArrayList<Produto> produtos = new ArrayList<>();
				venda.setId_venda(result.getInt(1));
				venda.setData(result.getString(2));
				venda.setHora(result.getString(3));
				venda.setValor(result.getFloat(4));
				venda.setFuncionario(fachada.getFuncionario(result.getString(5)));
				if(result.getString(6)!=null)
					venda.setCliente(fachada.getCliente(result.getString(6)));
				statement = SQLUtil.prepareStatement("select * from venda_produto where id_venda = '"+venda.getId_venda()+"'");
				ResultSet prodresult = statement.executeQuery();
				while(prodresult.next()) {
					Produto p = fachada.getProdutoVenda(prodresult.getString(2)).get(0);
					p.getLotes().add(new Lote());
					p.getLotes().get(0).setQuantidade(prodresult.getFloat(3));
					venda.getProdutos().add(p);
				}

				vendas.add(venda);
			}
		} catch (Exception e) {e.printStackTrace();
		throw new DaoException("Erro ao Buscar vendas",e.getMessage()); 
		}
		return vendas;
	}
	@Override
	public Venda getVenda(String string, Fachada fachada) throws DaoException {
		try {
			Venda venda = new Venda();			
			statement = SQLUtil.prepareStatement("select * from venda where id_venda = "+string);
			ResultSet result = statement.executeQuery();
			result.next(); 
			venda.setId_venda(result.getInt(1));
			venda.setData(result.getString(2));
			venda.setHora(result.getString(3));
			venda.setValor(result.getFloat(4));
			venda.setFuncionario(fachada.getFuncionario(result.getString(5)));
			if(result.getString(6)!=null)
				venda.setCliente(fachada.getCliente(result.getString(6)));
			statement = SQLUtil.prepareStatement("select * from venda_produto where id_venda = "+venda.getId_venda()+"");
			ResultSet prodresult = statement.executeQuery();
			while(prodresult.next()) {
				Produto p = fachada.getProduto(prodresult.getString(2)).get(0);
				p.getLotes().get(0).setQuantidade(prodresult.getFloat(3));
				venda.getProdutos().add(p);
			}
			return venda;
		} catch (Exception e) {throw new DaoException("Erro ao Buscar a Venda",e.getMessage());}
	}
	@Override
	public void excluir(int id_venda, Fachada fachada) throws DaoException {
		try {
			statement = SQLUtil.prepareStatement("select * from venda_produto where id_venda = "+id_venda);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				statement = SQLUtil.prepareStatement(SQLUtil.CANCELAR_VENDA);
				statement.setInt(1,(int)result.getFloat(3));
				statement.setString(2,fachada.getProdutoVenda(result.getString(2)).get(0).getLotes().get(0).getId());
				statement.execute();
			}
			statement = SQLUtil.prepareStatement("delete from venda_produto where id_venda ="+id_venda+"");
			statement.execute();
			statement = SQLUtil.prepareStatement("delete from venda where id_venda ="+id_venda+"");
			statement.execute();

		} catch (Exception e) {throw new DaoException("Erro ao Buscar a Venda",e.getMessage());}
	}
	@Override
	public void editar(Venda v) throws DaoException {
		try {
			statement = SQLUtil.prepareStatement("select * from venda_produto where id_venda = "+v.getId_venda()+"");
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				statement = SQLUtil.prepareStatement(SQLUtil.CANCELAR_VENDA);
				statement.setInt(1,(int)result.getFloat(3));
				statement.setString(2,result.getString(2));
				statement.execute();
			}
			statement = SQLUtil.prepareStatement("delete from venda_produto where id_venda ="+v.getId_venda()+"");
			statement.execute();

			statement = SQLUtil.prepareStatement(SQLUtil.EDITAR_VENDA);
			statement.setString(1, v.getData());
			statement.setString(2, v.getHora());
			statement.setFloat(3, v.getValor());
			statement.setString(4, v.getFuncionario().getCpf());
			statement.setString(5, v.getCliente().getCpf());
			statement.setInt(6, v.getId_venda());			
			statement.execute();			
			for(Produto p: v.getProdutos()) {
				statement = SQLUtil.prepareStatement(SQLUtil.INSERIR_VENDA_PRODUTO);
				statement.setInt(1, v.getId_venda());
				statement.setString(2, p.getCodigo());
				statement.setFloat(3, p.getLotes().get(0).getQuantidade());
				statement.execute();
				statement = SQLUtil.prepareStatement(SQLUtil.VENDER_PRODUTO);
				statement.setFloat(1, p.getLotes().get(0).getQuantidade());
				statement.setString(2, p.getCodigo());
				statement.execute();
			}

		} catch (Exception e) {throw new DaoException("Erro ao Editar a Venda",e.getMessage());}
	}

}
