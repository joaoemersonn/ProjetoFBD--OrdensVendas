package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import modelo.VendaTableModel;

@SuppressWarnings("serial")
public class P_Vendas extends JPanel {
	private JTable table;
	private JButton voltar, excluir, editar, cadastrar;;
	private VendaTableModel modelo;
	private JScrollPane scroll;
	private JTextField txtPesquisar;
	public P_Vendas(){
		setSize(Tela.LARGURA,Tela.ALTURA);
		setLayout(null);

		table = new JTable();
		scroll = new JScrollPane(table);
		scroll.setLocation(98, 112);
		table.setModel(new VendaTableModel());
		modelo = (VendaTableModel) table.getModel(); 
		scroll.setLocation(119, 112);
		scroll.setSize(1165, 526);
		add(scroll);
		cadastrar = new JButton("Ver Produtos Vendidos");
		cadastrar.setBounds(74, 681, 247, 58);
		add(cadastrar);

		JLabel lblFuncionrios = new JLabel("Vendas");
		lblFuncionrios.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 27));
		lblFuncionrios.setBounds(617, 11, 127, 63);
		add(lblFuncionrios);

		voltar = new JButton("Voltar");
		voltar.setBounds(1037, 681, 247, 58);
		add(voltar);

		editar = new JButton("Editar Venda");
		editar.setBounds(716, 681, 247, 58);
		add(editar);

		excluir = new JButton("Excluir Venda");
		excluir.setBounds(395, 681, 247, 58);
		add(excluir);
		
		txtPesquisar = new JTextField();
		txtPesquisar.setBounds(118, 71, 489, 30);
		add(txtPesquisar);
		txtPesquisar.setColumns(10);
		
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setBounds(119, 58, 80, 16);
		add(lblPesquisar);
		
		
		setVisible(false);
	}
	public int getIndexInTable() {
		return table.getSelectedRow();
	}
	public JButton getVoltar() {
		return voltar;
	}

	public JButton getExcluir() {
		return excluir;
	}

	public JButton getEditar() {
		return editar;
	}

	public JButton getCadastrar() {
		return cadastrar;
	}

	public VendaTableModel getModelo() {
		return modelo;
	}
	public JTextField getTxtPesquisar() {
		return txtPesquisar;
	}
}
