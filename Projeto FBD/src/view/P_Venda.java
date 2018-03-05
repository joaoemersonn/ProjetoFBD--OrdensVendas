package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import modelo.ProdutoTableModel;


@SuppressWarnings("serial")
public class P_Venda extends JPanel {
	private JButton novoServico, produtos, buscarOS, cliente,funcionarios,logout,vendas ;//, cadastrarProduto;
	private JLabel funcionario;

	private JLabel descricaoProdL, codigoL, quantL, valorUnitL, subtotalL, totalL;
	private JTextField codigoF, quantF, valorUnitF, subtotalF, totalF;
	private JTable table;
	private JScrollPane scroll;
	private JButton cancelar, finalizar, excluirItem, buscarProduto;
	private ProdutoTableModel modelo;

	public P_Venda(){
		setSize(Tela.LARGURA,Tela.ALTURA);
		descricaoProdL = new JLabel("Aqui aparece a descrição do produto quando inserir o código");
		descricaoProdL.setFont(new Font("Verdana", Font.BOLD, 18));
		descricaoProdL.setBounds(366, 85, 719, 40);
		descricaoProdL.setHorizontalAlignment(SwingConstants.CENTER);
		descricaoProdL.setForeground(Color.BLUE);
		setLayout(null);

		codigoL = new JLabel("Código:");
		quantL = new JLabel("Quantidade:");
		valorUnitL = new JLabel("Valor Unitário:");
		subtotalL = new JLabel("Subtotal:");
		totalL = new JLabel("Total:");

		codigoF = new JTextField();
		quantF = new JTextField();
		valorUnitF = new JTextField();
		valorUnitF.setEnabled(false);
		subtotalF = new JTextField();
		subtotalF.setEnabled(false);
		totalF = new JTextField();
		totalF.setEnabled(false);

		cancelar = new JButton("Limpar Venda");
		finalizar = new JButton("Finalizar");
		excluirItem = new JButton("Excluir Item");
		buscarProduto = new JButton("Buscar Produto");
		codigoL.setBounds(1156, 110, 180, 25);
		codigoF.setBounds(1156, 138, 200, 40);
		quantL.setBounds(1156, 189, 180, 25);
		quantF.setBounds(1156, 214,  200, 40);
		valorUnitL.setBounds(1156, 389, 180, 25);
		valorUnitF.setBounds(1156, 418, 200, 40);
		subtotalL.setBounds(1156, 481, 180, 25);
		subtotalF.setBounds(1156, 511, 200, 40);
		totalL.setBounds(1156, 563, 180, 25);
		totalF.setBounds(1156, 600, 200, 40);

		buscarProduto.setBounds(1156, 269, 150, 40);
		excluirItem.setBounds(998, 689, 164, 50);
		cancelar.setBounds(824, 689, 164, 50);
		finalizar.setBounds(1172, 689, 164, 50);

		table = new JTable();
		table.setModel(new ProdutoTableModel(true));
		scroll = new JScrollPane(table);
		modelo = (ProdutoTableModel) table.getModel();
		scroll.setBounds(267, 135, 857, 526);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(356);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(130);
		
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(descricaoProdL);
		add(codigoL);
		add(codigoF);
		add(quantL);
		add(quantF);
		add(valorUnitL);
		add(valorUnitF);
		add(subtotalL);
		add(subtotalF);
		add(totalL);
		add(totalF);
		add(buscarProduto);
		add(excluirItem);
		add(cancelar);
		add(finalizar);		

		add(scroll);
		cliente = new JButton("Clientes");
		novoServico = new JButton("Nova Ordem de Serviço");
		produtos = new JButton("Produtos");
		buscarOS = new JButton("Ordens de Serviço");
		cliente.setBounds(22, 515, 200, 60);
		novoServico.setBounds(10, 138, 225, 76);
		produtos.setBounds(22, 444, 200, 60);
		buscarOS.setBounds(22, 373, 200, 60);
		add(cliente);
		add(novoServico);
		add(produtos);
		add(buscarOS);
		
		funcionario = new JLabel("Funcion\u00E1rio: ");
		funcionario.setForeground(Color.BLUE);
		funcionario.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 21));
		funcionario.setBounds(0, 0, 359, 50);
		add(funcionario);
		
		funcionarios = new JButton("Funcionários");
		funcionarios.setBounds(22, 586, 200, 60);
		add(funcionarios);
		
		logout = new JButton("Logout");
		logout.setBounds(0, 45, 89, 23);
		add(logout);
		
		vendas = new JButton("Vendas");
		vendas.setBounds(22, 293, 200, 60);
		add(vendas);

		setVisible(false);

	}
	public int getItemInTable(){
		return (int) table.getValueAt(table.getSelectedRow(),0); 
	}
	public float getQntdInTable(){
		return Float.parseFloat(((String)table.getValueAt(table.getSelectedRow(),2))); 
	}
	public void limparCampos() {
		codigoF.setText("");
		quantF.setText("");
		valorUnitF.setText("");
		subtotalF.setText("");
		totalF.setText("");
		descricaoProdL.setText("Aqui aparece a descrição do produto quando inserir o código");

	}

	public JLabel getDescricaoProdL() {
		return descricaoProdL;
	}
	public JLabel getCodigoL() {
		return codigoL;
	}
	public JLabel getQuantL() {
		return quantL;
	}
	public JLabel getValorUnitL() {
		return valorUnitL;
	}
	public JLabel getSubtotalL() {
		return subtotalL;
	}
	public JLabel getTotalL() {
		return totalL;
	}
	public JTextField getCodigoF() {
		return codigoF;
	}
	public JTextField getQuantF() {
		return quantF;
	}
	public JTextField getValorUnitF() {
		return valorUnitF;
	}
	public JTextField getSubtotalF() {
		return subtotalF;
	}
	public JTextField getTotalF() {
		return totalF;
	}
	public JTable getTable() {
		return table;
	}
	public JButton getCancelar() {
		return cancelar;
	}
	public JButton getFinalizar() {
		return finalizar;
	}
	public JButton getExcluirItem() {
		return excluirItem;
	}
	public JButton getBuscarProduto() {
		return buscarProduto;
	}
	public ProdutoTableModel getModelo() {
		return modelo;
	}
	public void setValorUnitF(float t) {
		this.valorUnitF.setText(""+t);
		valorUnitF.repaint();
	}
	public void setSubtotalF(float t) {
		this.subtotalF.setText(""+t);
		subtotalF.repaint();
	}
	public void setTotalF(float t) {
		this.totalF.setText(""+t);
		totalF.repaint();
	}
	public void setDescricaoProdL(String tex) {
		this.descricaoProdL.setText(tex);
		descricaoProdL.repaint();
	}

	public JButton getClientes() {
		return cliente;
	}

	

	public JButton getNovoServico() {
		return novoServico;
	}

	public JButton getProdutos() {
		return produtos;
	}

	public JButton getBuscarOS() {
		return buscarOS;
	}

	



	public JLabel getFuncionario() {
		return funcionario;
	}



	public JButton getFuncionarios() {
		return funcionarios;
	}



	public JButton getLogout() {
		return logout;
	}



	public JButton getVendas() {
		return vendas;
	}
}
