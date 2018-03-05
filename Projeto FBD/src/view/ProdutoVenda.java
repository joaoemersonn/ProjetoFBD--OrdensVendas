package view;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import modelo.ProdutoTableModel;

@SuppressWarnings("serial")
public class ProdutoVenda extends JInternalFrame {
	private JTable table;
	private ProdutoTableModel modelo;
	private JButton fechar;
	public ProdutoVenda() {
		setSize(608,425);
		getContentPane().setLayout(null);
		//setLocationRelativeTo(null);
		setLocation((Tela.LARGURA - this.getSize().width) / 2, (Tela.ALTURA - this.getSize().height) / 2); 
		table = new JTable();
		table.setModel( new ProdutoTableModel(false));
		modelo = (ProdutoTableModel) table.getModel();
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 569, 300);
		getContentPane().add(scrollPane);
		
		fechar = new JButton("Fechar");
		fechar.setBounds(445, 322, 134, 43);
		getContentPane().add(fechar);
	}
	public ProdutoTableModel getModelo() {
		return modelo;
	}
	public JButton getFechar() {
		return fechar;
	}
	
}
