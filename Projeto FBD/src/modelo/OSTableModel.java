package modelo;


import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;


@SuppressWarnings("serial")
public class OSTableModel extends AbstractTableModel{
	private Vector colunas;
	private Vector linhas;

	@SuppressWarnings("unchecked")
	public OSTableModel() {
		colunas = new Vector();
		colunas.add("Descrição");
		colunas.add("Cliente");
		colunas.add("Tecnico");
		colunas.add("Data Inicio");
		colunas.add("Data Fim");
		colunas.add("Valor");
		
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
	public void atualizarTable(List<OServico> os) {
		linhas = new Vector();
		for(OServico d: os){
			d.setDataInicio((d.getDataInicio()== null|| d.getDataInicio().isEmpty())?"Não Iniciada":d.getDataInicio());
			d.setDataFim((d.getDataFim() == null|| d.getDataFim().isEmpty())?"Não Finalizada":d.getDataFim());
			Vector<Object> linha = new Vector<Object>();
			linha.add(d.getDescricao());
			linha.add(d.getCliente().getNome());
			linha.add(d.getTecnico().getNome());
			linha.add(d.getDataInicio());
			linha.add(d.getDataFim());
			linha.add(d.getValor());			
			this.linhas.add(linha);	
		}
		fireTableDataChanged();
	}
	

}
