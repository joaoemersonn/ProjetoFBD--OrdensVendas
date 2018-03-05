package modelo;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class FuncionarioTableModel extends AbstractTableModel{
	private Vector colunas;
	private Vector linhas;

	@SuppressWarnings("unchecked")
	public FuncionarioTableModel() {
		colunas = new Vector();
		colunas.add("Nome");
		colunas.add("Login");
		colunas.add("CPF");
		colunas.add("RG");
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
	public void atualizarTable(List<Funcionario> funcionarios) {
		linhas = new Vector();
		for(Funcionario d: funcionarios){
			Vector<Object> linha = new Vector<Object>();
			linha.add(d.getNome());
			linha.add(d.getLogin());
			linha.add(d.getCpf());
			linha.add(d.getRg());
			this.linhas.add(linha);	
		}
		fireTableDataChanged();
	}
//	@SuppressWarnings("unchecked")
//	public void addInTable(Funcionario d) {		
//			Vector<Object> linha = new Vector<Object>();
//			linha.add(d.getNome());
//			linha.add(d.getLogin());
//			linha.add(d.getCpf());
//			linha.add(d.getRg());
//			this.linhas.add(linha);			
//		fireTableDataChanged();
//	}


}
