package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import modelo.ProdutoTableModel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class P_Produtos extends JPanel {
	
	//private JLabel tituloL, descricaoProdL;
	private JTable table;
	private JButton voltar, excluir, editar, cadastrar;;
	private ProdutoTableModel modelo;
	private JScrollPane scroll;
	private JTextField txtPesquisar;
	
	public P_Produtos(){
		setSize(Tela.LARGURA,Tela.ALTURA);
		setLayout(null);
		//setBackground(Tela.BACKGROUD);
				
		table = new JTable();
		scroll = new JScrollPane(table);
		scroll.setLocation(98, 112);		
		table.setModel(new ProdutoTableModel(false));
		modelo = (ProdutoTableModel) table.getModel(); 
		scroll.setLocation(119, 112);
		scroll.setSize(1165, 526);
		add(scroll);
		cadastrar = new JButton("Cadastrar Produto");
		cadastrar.setBounds(74, 681, 247, 58);
		add(cadastrar);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JLabel lblFuncionrios = new JLabel("Produtos");
		lblFuncionrios.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 27));
		lblFuncionrios.setBounds(617, 11, 127, 63);
		add(lblFuncionrios);
		
		voltar = new JButton("Voltar");
		voltar.setBounds(1037, 681, 247, 58);
		add(voltar);
		
		editar = new JButton("Editar Produto");
		editar.setBounds(716, 681, 247, 58);
		add(editar);
		
		excluir = new JButton("Excluir Produto");
		excluir.setBounds(395, 681, 247, 58);
		add(excluir);
		setVisible(false);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		txtPesquisar = new JTextField();
		txtPesquisar.setToolTipText("");
		txtPesquisar.setBounds(118, 71, 489, 30);
		add(txtPesquisar);
		txtPesquisar.setColumns(10);
		
		//scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setBounds(119, 58, 80, 16);
		add(lblPesquisar);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(220);
		table.getColumnModel().getColumn(2).setPreferredWidth(550);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(200);
		
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		
		setVisible(false);
		
	}
	public String getCodigoInTable(){
		return (String) table.getValueAt(table.getSelectedRow(),1); 
	}

	
	public JTable getTable() {
		return table;
	}
	public JButton getCancelar() {
		return voltar;
	}
	public JButton getExcluir() {
		return excluir;
	}
	public JButton getEditar() {
		return editar;
	}
	public ProdutoTableModel getModelo() {
		return modelo;
	}
	
	public JButton getCadastrar() {
		return cadastrar;
	}
	public JTextField getTxtPesquisar() {
		return txtPesquisar;
	}
}
