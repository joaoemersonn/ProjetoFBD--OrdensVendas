package modelo;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class VendaTableModel  extends AbstractTableModel{
	private Vector colunas;
	private Vector linhas;

	@SuppressWarnings("unchecked")
	public VendaTableModel() {
		colunas = new Vector();
		colunas.add("Funcionário");
		colunas.add("Valor");
		colunas.add("Cliente");		
		colunas.add("Data");
		colunas.add("Hora");
		linhas = new Vector();

	}

	@SuppressWarnings("unchecked")
	public void atualizarTable(List<Venda> vendas) {
		linhas = new Vector();
		for(Venda d: vendas){
			Vector<Object> linha = new Vector<Object>();
			linha.add(d.getFuncionario().getNome());
			linha.add(d.getValor());
			linha.add(d.getCliente()!=null?d.getCliente().getNome():"");
			linha.add(d.getData());
			linha.add(d.getHora());			
			this.linhas.add(linha);	
		}
		fireTableDataChanged();
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



}
