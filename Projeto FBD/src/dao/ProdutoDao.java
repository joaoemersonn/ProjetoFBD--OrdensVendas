package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import app.SQLUtil;
import modelo.DaoException;
import modelo.Lote;
import modelo.Produto;
import view.Mensagens;

public class ProdutoDao implements IProdutoDao{
	PreparedStatement statement;
	@Override
	public void salvar(Produto produto) throws DaoException {
		try {
			statement = SQLUtil.prepareStatement(SQLUtil.INSERIR_PRODUTO);
			statement.setString(1, produto.getDescricao());
			statement.setString(2, produto.getCodigo());
			statement.setString(3, produto.getMarca());
			statement.execute();
			for(Lote l: produto.getLotes()) {
				//id_lote,quantidade, data_venc, data_fabric,preco_compra, margem_lucro, codigo_produto) 
				statement = SQLUtil.prepareStatement(SQLUtil.INSERIR_LOTE);
				statement.setString(1, l.getId());
				statement.setFloat(2, l.getQuantidade());
				statement.setString(3,l.getDataVenc());		
				statement.setString(4,l.getDataFab());		
				statement.setFloat(5, l.getPrecoCompra());
				statement.setFloat(6, l.getMargemLucro());
				statement.setString(7, produto.getCodigo());				
				statement.execute();
			}
			if(produto.getLote_ativo()!=null) {
				statement = SQLUtil.prepareStatement("update produto set lote_ativo = '"+produto.getLote_ativo()+"' where codigo = '"+produto.getCodigo()+"'");
				statement.execute();
			}
			Mensagens.confirmado("O Produto Foi Cadastrado Com Sucesso!");	
		} catch (Exception e) {
			throw new DaoException("Erro ao Inserir Produto",e.getMessage());
		}

	}
	public List<Produto> getProdutosDisp(String chaveBusca) throws DaoException{
		List<Produto> produtos = new ArrayList<Produto>();
		try {
			statement = SQLUtil.prepareStatement(chaveBusca.isEmpty()?"select * from produto ":"select * "
					+ "from produto where codigo like '"+chaveBusca+"%' or descricao ilike '%"+chaveBusca+"%' order by codigo");
			ResultSet result = this.statement.executeQuery();
			Produto produto;
			while(result.next()){		           
				produto= new Produto();
				produto.setDescricao(result.getString(1));
				produto.setCodigo(result.getString(2));
				produto.setMarca(result.getString(3));
				produto.setLote_ativo(result.getString(4));
				//System.out.println(""+produto.getLote_ativo());
				statement = SQLUtil.prepareStatement("select * from lote where id_lote = '"+produto.getLote_ativo()+"' ");
				ResultSet resLote = statement.executeQuery();
				while(resLote.next()) {
				//id_lote,quantidade, data_venc, data_fabric,preco_compra, margem_lucro, codigo_produto					
				Lote l = new Lote();
				l.setId(resLote.getString(1));
				l.setQuantidade(resLote.getFloat(2));
				l.setDataVenc(resLote.getString(3));
				l.setDataFab(resLote.getString(4));
				l.setPrecoCompra(resLote.getFloat(5));
				l.setMargemLucro(resLote.getFloat(6));
				produto.getLotes().add(l);
				}
				///if(!produto.getLotes().isEmpty())
				produtos.add(produto);
			}
			return produtos;

		} catch (Exception e) {throw new DaoException("Erro ao Buscar Produto",e.getMessage());}

	}

	@Override
	public List<Produto> getProdutos(String chaveBusca) throws DaoException {
		List<Produto> produtos = new ArrayList<Produto>();
		try {
			statement = SQLUtil.prepareStatement(chaveBusca.isEmpty()?"select * from produto ":"select * "
					+ "from produto where codigo like '"+chaveBusca+"%' or descricao ilike '%"+chaveBusca+"%' order by codigo");
			ResultSet result = this.statement.executeQuery();
			Produto produto;
			while(result.next()){		           
				produto= new Produto();
				produto.setDescricao(result.getString(1));
				produto.setCodigo(result.getString(2));
				produto.setMarca(result.getString(3));
				produto.setLote_ativo(result.getString(4));

				statement = SQLUtil.prepareStatement("select * from lote where codigo_produto = '"+produto.getCodigo()+"'");
				ResultSet resLote = statement.executeQuery();
				while(resLote.next()) {
					//id_lote,quantidade, data_venc, data_fabric,preco_compra, margem_lucro, codigo_produto					
					Lote l = new Lote();
					l.setId(resLote.getString(1));
					l.setQuantidade(resLote.getFloat(2));
					l.setDataVenc(resLote.getString(3));
					l.setDataFab(resLote.getString(4));
					l.setPrecoCompra(resLote.getFloat(5));
					l.setMargemLucro(resLote.getFloat(6));
					produto.getLotes().add(l);
				}

				produtos.add(produto);
			}
			return produtos;

		} catch (Exception e) {throw new DaoException("Erro ao Buscar Produto",e.getMessage());}


	}

	@Override
	public void excluirProduto(String codigo) throws DaoException {
		try {
			statement = SQLUtil.prepareStatement("update produto set lote_ativo = null where codigo ='"+codigo+"'");
			statement.execute();
			statement = SQLUtil.prepareStatement("delete from lote where codigo_produto = '"+codigo+"'");
			statement.execute();
			statement = SQLUtil.prepareStatement("delete from produto where codigo = '"+codigo+"'");
			statement.execute();
		} catch (Exception e) {throw new DaoException("Erro ao Excluir Produto",e.getMessage());}
	}

	@Override
	public void editarProduto(Produto produto) throws DaoException {
		try {
			if(produto.getLote_ativo()!=null) {
				//System.out.println("1.LoteAtivo"+produto.getLote_ativo());
				try {
					statement = SQLUtil.prepareStatement("update produto set lote_ativo = '"+produto.getLote_ativo()+"' where codigo = '"+produto.getCodigo()+"'");
					statement.execute();
				}catch (Exception e43) {
					for(Lote lot: produto.getLotes()) {
						if(lot.getId().equals(produto.getLote_ativo())) {
							statement = SQLUtil.prepareStatement(SQLUtil.INSERIR_LOTE);
							statement.setString(1, lot.getId());
							statement.setFloat(2, lot.getQuantidade());
							statement.setString(3,lot.getDataVenc());		
							statement.setString(4,lot.getDataFab());		
							statement.setFloat(5, lot.getPrecoCompra());
							statement.setFloat(6, lot.getMargemLucro());
							statement.setString(7, produto.getCodigo());				
							statement.execute();
							statement = SQLUtil.prepareStatement("update produto set lote_ativo = '"+produto.getLote_ativo()+"' where codigo = '"+produto.getCodigo()+"'");
							statement.execute();
							break;
						}
					}
				}
			}
		//	System.out.println("2.LoteAtivo"+produto.getLote_ativo());
			statement = SQLUtil.prepareStatement("delete from lote where id_lote <> '"+produto.getLote_ativo()+"' AND codigo_produto = '"+produto.getCodigo()+"'");
			statement.execute();
			statement = SQLUtil.prepareStatement(SQLUtil.ALTERAR_PRODUTO);
			statement.setString(1, produto.getDescricao());
			statement.setString(2, produto.getMarca());
			statement.setString(3, produto.getCodigo());
			statement.execute();
			for(Lote lot: produto.getLotes()) {
				if(!lot.getId().equals(produto.getLote_ativo())) {
					statement = SQLUtil.prepareStatement(SQLUtil.INSERIR_LOTE);
					statement.setString(1, lot.getId());
					statement.setFloat(2, lot.getQuantidade());
					statement.setString(3,lot.getDataVenc());		
					statement.setString(4,lot.getDataFab());		
					statement.setFloat(5, lot.getPrecoCompra());
					statement.setFloat(6, lot.getMargemLucro());
					statement.setString(7, produto.getCodigo());				
					statement.execute();
				}else {
					statement = SQLUtil.prepareStatement(SQLUtil.ALTERAR_LOTE);
					statement.setFloat(1, lot.getQuantidade());
					statement.setString(2,lot.getDataVenc());		
					statement.setString(3,lot.getDataFab());		
					statement.setFloat(4, lot.getPrecoCompra());
					statement.setFloat(5, lot.getMargemLucro());
					statement.setString(6, lot.getId());
					statement.execute();
				}
			}


			//			statement = SQLUtil.prepareStatement("select * from lote where codigo_produto ='"+produto.getCodigo()+"'");
			//			ResultSet resLote = statement.executeQuery();
			//			ArrayList<Lote> lotes = new ArrayList<>();
			//			while(resLote.next()) {
			//				Lote l = new Lote();
			//				l.setId(resLote.getString(1));
			//				l.setQuantidade(resLote.getFloat(2));
			//				l.setDataVenc(resLote.getString(3));
			//				l.setDataFab(resLote.getString(4));
			//				l.setPrecoCompra(resLote.getFloat(5));
			//				l.setMargemLucro(resLote.getFloat(6));
			//				lotes.add(l);
			//			}

			//			boolean temNoProduto[] = new boolean[lotes.size()];
			//			int pos[] = new int[produto.getLotes().size()];
			//			Lote lot;
			//			//boolean [] = new boolean[lotes.size()];
			//			for(int i=0;i<lotes.size();i++){
			//				for(int j=0;j<produto.getLotes().size();j++) {
			//					lot =produto.getLotes().get(j);
			//					if(lotes.get(i).getId().equals(produto.getLotes().get(j).getId())) {
			//						temNoProduto[i] = true;
			//						pos[i] = j;
			//						
			//					} 
			//				}
			//			}
			//			for(int i=0;i<lotes.size();i++){				
			//				for(int j=0;j<produto.getLotes().size();j++) {
			//					lot =produto.getLotes().get(pos[i]);
			//					if(temNoProduto[i]) {
			//						statement = SQLUtil.prepareStatement(SQLUtil.ALTERAR_LOTE);
			//						statement.setFloat(1, lot.getQuantidade());
			//						statement.setString(2,lot.getDataVenc().isEmpty()?null:lot.getDataVenc());		
			//						statement.setString(3,lot.getDataFab());		
			//						statement.setFloat(4, lot.getPrecoCompra());
			//						statement.setFloat(5, lot.getMargemLucro());
			//						statement.setString(6, lot.getId());
			//						statement.execute();
			//						//temNoProduto[i] = true;						
			//					}
			//					else {
			//						try {
			//							System.out.println("Apagou! espero :-|");
			//							statement = SQLUtil.prepareStatement("delete from lote where id_lote = '"+lotes.get(i).getId()+"'");
			//							statement.execute();
			//						}catch (Exception e) {
			//							e.printStackTrace();
			//							statement = SQLUtil.prepareStatement(SQLUtil.INSERIR_LOTE);
			//							statement.setString(1, lot.getId());
			//							statement.setFloat(2, lot.getQuantidade());
			//							statement.setString(3,lot.getDataVenc().isEmpty()?null:lot.getDataVenc());		
			//							statement.setString(4,lot.getDataFab());		
			//							statement.setFloat(5, lot.getPrecoCompra());
			//							statement.setFloat(6, lot.getMargemLucro());
			//							statement.setString(7, produto.getCodigo());				
			//							statement.execute();
			//						}
			//						//temNoProduto[i] = false;
			//					}
			//				}
			//			}
			Mensagens.confirmado("O Produto Foi Alterado Com Sucesso!");
		} catch (Exception e) {
			throw new DaoException("Erro ao Alterar Produto",e.getMessage());
		}
	}

}
