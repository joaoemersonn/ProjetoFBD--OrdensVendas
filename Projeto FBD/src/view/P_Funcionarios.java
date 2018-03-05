package view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import modelo.FuncionarioTableModel;

import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")
public class P_Funcionarios extends JPanel{
	private JTable table;
	private JScrollPane scroll;
	private JButton cadastrar,voltar, editar,excluir;
	private FuncionarioTableModel model;
	private JTextField txtPesquisar;
	public P_Funcionarios() {
		setLayout(null);
		setSize(Tela.LARGURA,Tela.ALTURA);
		table = new JTable();
		scroll = new JScrollPane(table);
		scroll.setLocation(144, 98);
		scroll.setSize(383, 218);
		table.setModel(new FuncionarioTableModel());
		model = (FuncionarioTableModel) table.getModel(); 
		scroll.setLocation(119, 112);
		scroll.setSize(1112, 526);
		add(scroll);
		cadastrar = new JButton("Cadastrar Funcionario");
		cadastrar.setBounds(74, 681, 247, 58);
		add(cadastrar);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setBounds(119, 58, 80, 16);
		add(lblPesquisar);
		JLabel lblFuncionrios = new JLabel("Funcionários");
		lblFuncionrios.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 27));
		lblFuncionrios.setBounds(559, 11, 247, 63);
		add(lblFuncionrios);
		
		voltar = new JButton("Voltar");
		voltar.setBounds(1037, 681, 247, 58);
		add(voltar);
		
		editar = new JButton("Editar Funcion\u00E1rio");
		editar.setBounds(716, 681, 247, 58);
		add(editar);
		
		excluir = new JButton("Excluir Funcion\u00E1rio");
		excluir.setBounds(395, 681, 247, 58);
		add(excluir);
		txtPesquisar = new JTextField();
		txtPesquisar.setBounds(118, 71, 489, 30);
		add(txtPesquisar);
		txtPesquisar.setColumns(10);
		
		
		
		setVisible(false);
	}
	public String getCpfInTable() {
		return (String) table.getValueAt(table.getSelectedRow(),2);
	}
	public JButton getcFuncionario() {
		return cadastrar;
	}
	public FuncionarioTableModel getModel() {
		return model;
	}
	public JButton getVoltar() {
		return voltar;
	}
	public JButton getCadastrar() {
		return cadastrar;
	}
	public JButton getEditar() {
		return editar;
	}
	public JButton getExcluir() {
		return excluir;
	}
	public JTextField getTxtPesquisar() {
		return txtPesquisar;
	}
}
