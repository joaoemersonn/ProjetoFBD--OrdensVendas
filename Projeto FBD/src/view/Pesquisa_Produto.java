package view;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import modelo.ProdutoTableModel;

@SuppressWarnings("serial")
public class Pesquisa_Produto extends JInternalFrame{
	
	private JLabel buscarProdutoL;
	private JTextField buscaProdutoF;
	private JTable table;
	private JScrollPane scroll;
	private ProdutoTableModel modelo;
	private JButton adicionar;

	public Pesquisa_Produto(){
		super("Busca de Produto");
		setSize(600, 300);
		setLayout(null);
	    setLocation((Tela.LARGURA - this.getSize().width) / 2, (Tela.ALTURA - this.getSize().height) / 2); 
	    setClosable(true);
	    setDefaultCloseOperation(HIDE_ON_CLOSE);
		//setLocationRelativeTo(null);
				
		buscarProdutoL = new JLabel("Procure o produto por nome: ");
		buscaProdutoF = new JTextField();
		//getGraphicsConfiguration().getDevice().setFullScreenWindow(this);
		buscarProdutoL.setBounds(10, 20, 565, 25);
		buscaProdutoF.setBounds(10, 40, 565, 25);
		
		table = new JTable();
		table.setModel(new ProdutoTableModel(false));
		modelo = (ProdutoTableModel) table.getModel();
		scroll = new JScrollPane(table);
		scroll.setBounds(10, 75, 565, 130);
		adicionar = new JButton("Adicionar");		
		adicionar.setBounds(421, 217, 149, 31);
		
		add(buscarProdutoL);
		add(buscaProdutoF);
		add(scroll);
		add(adicionar);
		
		//setVisible(false);
	}
	public String getCodigoInTable(){
		return (String) table.getValueAt(table.getSelectedRow(),1); 
	}
	public JLabel getBuscarProdutoL() {
		return buscarProdutoL;
	}

	public JTextField getBuscaProdutoF() {
		return buscaProdutoF;
	}

	public JTable getTable() {
		return table;
	}

	public ProdutoTableModel getModelo() {
		return modelo;
	}

	public JButton getAdicionar() {
		return adicionar;
	}

	
}
