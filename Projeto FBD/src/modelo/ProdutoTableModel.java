package modelo;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;


@SuppressWarnings("serial")
public class ProdutoTableModel extends AbstractTableModel{
	private Vector colunas;
	private Vector linhas;
	private int numItem;
	private boolean isVenda;

	@SuppressWarnings("unchecked")
	public ProdutoTableModel(boolean isVenda) {
		this.isVenda = isVenda;
		colunas = new Vector();
		colunas.add("Item");
		colunas.add("Código");
		colunas.add("Descrição");
		colunas.add("Quantidade");
		colunas.add("Preço Unidade(R$)");		
		if(isVenda)
			colunas.add("Subtotal(R$)");
		//colunas.add("Data Validade");
		linhas = new Vector();

	}
	public int getRowCount() {
		return linhas.size();
	}

	public int getColumnCount() {
		return colunas.size();
	}

	public String getColumnName(int coluna) {
		String nomeColuna = (String) colunas.get(coluna);
		return nomeColuna;
	}

	public Object getValueAt(int linha, int coluna) {
		Vector registro = (Vector) linhas.get(linha);
		Object dado = registro.get(coluna);
		return dado;
	}
	public void limparTable() {
		linhas = new Vector();
		numItem=0;
		fireTableDataChanged();
	}


	@SuppressWarnings("unchecked")
	public void atualizarTable(List<Produto> produtos) {
		linhas = new Vector();		
		numItem=0;
		for(Produto d: produtos){
			Float soma = (float) 0;
			Vector<Object> linha = new Vector<Object>();
			linha.add(numItem);
			linha.add(d.getCodigo());
			linha.add(d.getDescricao());
			for(Lote l:d.getLotes())
				soma+= l.getQuantidade();
			linha.add(soma);
			if(!d.getLotes().isEmpty()) {
				linha.add(d.getLotes().get(0).getPrecoV());				
				if(isVenda)
					linha.add(d.getLotes().get(0).getPrecoV()*d.getLotes().get(0).getQuantidade());
				//linha.add(d.getLotes().get(0).getDataVenc());
			}else {
				linha.add("Não há Lotes Ativos");
				linha.add("Não há Lotes Ativos");
				if(isVenda)
					linha.add("Não há Lotes Ativos");
				}
			
			numItem++;
			this.linhas.add(linha);	
		}
		fireTableDataChanged();
	}
	@SuppressWarnings("unchecked")
	public void addInTable(Produto d) {		
		//linhas = new Vector();
		//for(Produto d: produtos){
		Vector<Object> linha = new Vector<Object>();
		Float soma = (float) 0;
		linha.add(numItem);
		linha.add(d.getCodigo());
		linha.add(d.getDescricao());
		for(Lote l:d.getLotes())
			soma+= l.getQuantidade();
		linha.add(soma);
		if(!d.getLotes().isEmpty()) {
			linha.add(d.getLotes().get(0).getPrecoV());				
			if(isVenda)
				linha.add(d.getLotes().get(0).getPrecoV()*d.getLotes().get(0).getQuantidade());
			//linha.add(d.getLotes().get(0).getDataVenc());
		}else {
			linha.add("Não há Lotes Ativos");
			linha.add("Não há Lotes Ativos");
			if(isVenda)
				linha.add("Não há Lotes Ativos");
			}
		
		numItem++;
		this.linhas.add(linha);	
		//float precoV = (d.getPrecoCompra()+d.getPrecoCompra()*(d.getMargemLucro()/100));
		//		linha.add(numItem);
		//		linha.add(d.getCodigo());
		//		linha.add(d.getDescricao());
		//		linha.add(d.getQuantidade());
		//		linha.add(d.getPrecoV());
		//		if(isVenda)
		//			linha.add(d.getPrecoV()*d.getQuantidade());
		//		numItem++;
		//		linha.add(d.getDataVenc());
		//		this.linhas.add(linha);
		///}
		fireTableDataChanged();
	}


}
