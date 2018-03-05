package modelo;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class EnderecoTableModel extends AbstractTableModel{
	private Vector colunas;
	private Vector linhas;

	@SuppressWarnings("unchecked")
	public EnderecoTableModel() {
		colunas = new Vector();
		colunas.add("Nº");
		colunas.add("Rua");
		colunas.add("Bairro");
		colunas.add("Cidade");
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
		fireTableDataChanged();
	}


	@SuppressWarnings("unchecked")
	public void atualizarTable(List<Endereco> endereco) {
		linhas = new Vector();
		for(Endereco d: endereco){
			Vector<Object> linha = new Vector<Object>();
			linha.add(d.getNumero());
			linha.add(d.getRua());
			linha.add(d.getBairro());
			linha.add(d.getCidade());
			this.linhas.add(linha);	
		}
		fireTableDataChanged();
	}
	@SuppressWarnings("unchecked")
	public void addInTable(Endereco d) {		
			Vector<Object> linha = new Vector<Object>();
			linha.add(d.getNumero());
			linha.add(d.getRua());
			linha.add(d.getBairro());
			linha.add(d.getCidade());
			this.linhas.add(linha);			
		fireTableDataChanged();
	}
}
