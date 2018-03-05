package modelo;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class LoteTableModel extends AbstractTableModel{
	private Vector colunas;
	private Vector linhas;

	@SuppressWarnings("unchecked")
	public LoteTableModel() {
		colunas = new Vector();
		colunas.add("Nº do Lote");		
		colunas.add("Quantidade");
		colunas.add("Preço Compra");		
		colunas.add("Mergem de Lucro");		
		colunas.add("Data Fabricação");
		colunas.add("Data Vencimento");
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
	@SuppressWarnings("unchecked")
	public void atualizarTable(List<Lote> lotes) {
		linhas = new Vector();
		for(Lote d: lotes){
			Vector<Object> linha = new Vector<Object>();
			linha.add(d.getId());
			linha.add(d.getQuantidade());
			linha.add(d.getPrecoCompra());
			linha.add(d.getMargemLucro());
			linha.add(d.getDataFab());
			linha.add(d.getDataVenc());
			this.linhas.add(linha);	
		}
		fireTableDataChanged();
	}
	


}
