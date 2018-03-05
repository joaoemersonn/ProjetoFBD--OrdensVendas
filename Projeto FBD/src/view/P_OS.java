package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import modelo.OSTableModel;

@SuppressWarnings("serial")
public class P_OS extends JPanel{

	//private JLabel tituloL, descricaoProdL;
	private JTable table;
	private JButton voltar, excluir, editar, finalizar, verOs;
	private OSTableModel modelo;
	private JScrollPane scroll;
	private JTextField txtPesquisar;
	
	public P_OS(){
		setSize(Tela.LARGURA,Tela.ALTURA);
		setLayout(null);

		txtPesquisar = new JTextField();
		txtPesquisar.setBounds(118, 71, 489, 30);
		add(txtPesquisar);
		txtPesquisar.setColumns(10);	
				
		table = new JTable();
		scroll = new JScrollPane(table);
		scroll.setLocation(98, 112);
		table.setModel(new OSTableModel());
		modelo = (OSTableModel) table.getModel(); 
		scroll.setLocation(119, 112);
		scroll.setSize(1165, 526);
		add(scroll);
		finalizar = new JButton("Iniciar/Finalizar OS");
		finalizar.setBounds(21, 680, 247, 58);
		add(finalizar);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setBounds(119, 58, 80, 16);
		add(lblPesquisar);
		
		JLabel lblFuncionrios = new JLabel("Ordens de Serviço");
		lblFuncionrios.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 27));
		lblFuncionrios.setBounds(559, 11, 247, 63);
		add(lblFuncionrios);
		
		voltar = new JButton("Voltar");
		voltar.setBounds(1093, 680, 247, 58);
		add(voltar);
		
		editar = new JButton("Editar OS");
		editar.setBounds(825, 680, 247, 58);
		add(editar);
		
		excluir = new JButton("Excluir OS");
		excluir.setBounds(557, 680, 247, 58);
		add(excluir);
		
		verOs = new JButton("Ver OS");
		verOs.setBounds(289, 680, 247, 58);
		add(verOs);
		setVisible(false);
		
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		table.getColumnModel().getColumn(0).setPreferredWidth(50);
//		table.getColumnModel().getColumn(1).setPreferredWidth(220);
//		table.getColumnModel().getColumn(2).setPreferredWidth(542);
//		table.getColumnModel().getColumn(3).setPreferredWidth(150);
//		table.getColumnModel().getColumn(4).setPreferredWidth(200);
		
		
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

	public JButton getFinalizar() {
		return finalizar;
	}

	public OSTableModel getModelo() {
		return modelo;
	}

	public JButton getVerOs() {
		return verOs;
	}
	public JTextField getTxtPesquisar() {
		return txtPesquisar;
	}
}