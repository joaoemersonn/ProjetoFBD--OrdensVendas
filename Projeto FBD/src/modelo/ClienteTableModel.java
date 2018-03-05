package modelo;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ClienteTableModel extends AbstractTableModel {
	private Vector colunas;
	private Vector linhas;

	@SuppressWarnings("unchecked")
	public ClienteTableModel() {
		colunas = new Vector();
		colunas.add("Nome");
		colunas.add("CPF");
		colunas.add("Telefone");
		colunas.add("Débito");
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
	public void atualizarTable(List<Cliente> clientes) {
		linhas = new Vector();
		for(Cliente d: clientes){
			Vector<Object> linha = new Vector<Object>();
			linha.add(d.getNome());
			String cpf = d.getCpf();
			if(cpf.length() >= 11)
				linha.add(cpf.substring(0, 3)+"."+cpf.substring(3, 6)+"."+cpf.substring(6,9)+"-"+cpf.substring(9, 11));
			else
				linha.add(cpf);
			linha.add(d.getTelefone());
			linha.add(d.getDebito());
			this.linhas.add(linha);	
		}
		fireTableDataChanged();
	}
	@SuppressWarnings("unchecked")
	public void addInTable(Cliente d) {		
			Vector<Object> linha = new Vector<Object>();
			linha.add(d.getNome());
			linha.add(d.getCpf());
			linha.add(d.getTelefone());
			linha.add(d.getDebito());
			this.linhas.add(linha);			
		fireTableDataChanged();
	}

}
