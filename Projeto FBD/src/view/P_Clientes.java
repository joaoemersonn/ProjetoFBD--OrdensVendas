package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import modelo.ClienteTableModel;

@SuppressWarnings("serial")
public class P_Clientes extends JPanel{
	private JTable table;
	private JScrollPane scroll;
	private JButton cadastrar,voltar, editar,excluir, alterarDbito;
	private ClienteTableModel model;
	private JTextField txtPesquisar;
	public P_Clientes() {
		setLayout(null);
		setSize(Tela.LARGURA,Tela.ALTURA);
		txtPesquisar = new JTextField();
		txtPesquisar.setBounds(118, 71, 489, 30);
		add(txtPesquisar);
		txtPesquisar.setColumns(10);
		

		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setBounds(119, 58, 80, 16);
		add(lblPesquisar);
		
		table = new JTable();
		scroll = new JScrollPane(table);
		scroll.setLocation(144, 98);
		scroll.setSize(383, 218);
		table.setModel(new ClienteTableModel());
		model = (ClienteTableModel) table.getModel(); 
		scroll.setLocation(119, 112);
		scroll.setSize(1112, 526);
		add(scroll);
		cadastrar = new JButton("Cadastrar Cliente");
		cadastrar.setBounds(21, 681, 247, 58);
		add(cadastrar);
		
		JLabel lblFuncionrios = new JLabel("Clientes");
		lblFuncionrios.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 27));
		lblFuncionrios.setBounds(559, 11, 247, 63);
		add(lblFuncionrios);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		voltar = new JButton("Voltar");
		voltar.setBounds(1093, 681, 247, 58);
		add(voltar);
		
		editar = new JButton("Editar Cliente");
		editar.setBounds(557, 681, 247, 58);
		add(editar);
		
		excluir = new JButton("Excluir Cliente");
		excluir.setBounds(289, 681, 247, 58);
		add(excluir);
		
		alterarDbito = new JButton("Alterar D\u00E9bito");
		alterarDbito.setBounds(825, 681, 247, 58);
		add(alterarDbito);
		setVisible(false);
	}
	public String getCpfInTable() {
		return ((String) table.getValueAt(table.getSelectedRow(),1)).replaceAll("[.-]", "");
	}
	public JTable getTable() {
		return table;
	}
	public JScrollPane getScroll() {
		return scroll;
	}
	public JButton getCadastrar() {
		return cadastrar;
	}
	public JButton getVoltar() {
		return voltar;
	}
	public JButton getEditar() {
		return editar;
	}
	public JButton getExcluir() {
		return excluir;
	}
	public ClienteTableModel getModelo() {
		return model;
	}
	public JTextField getTxtPesquisar() {
		return txtPesquisar;
	}
	public JButton getAlterarDbito() {
		return alterarDbito;
	}
}
