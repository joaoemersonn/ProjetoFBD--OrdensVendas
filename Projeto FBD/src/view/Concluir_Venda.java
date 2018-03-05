package view;

import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.Cliente;

@SuppressWarnings("serial")
public class Concluir_Venda extends JInternalFrame {
	JLabel total,valorPago,troco,titulo;
	JTextField totalF,valorPagoF,trocoF;
	JButton finalizar, voltar;
	Font fonte;
	JComboBox<String> comboBox;
	private JTextField pesquisar;
	public Concluir_Venda(){
		setSize(382, 480);
		getContentPane().setLayout(null);
		setResizable(false);
		//setLocationRelativeTo(null);
		setLocation((Tela.LARGURA - this.getSize().width) / 2, (Tela.ALTURA - this.getSize().height) / 2); 
		requestFocus();
		fonte = new Font("Comic Sans", Font.BOLD, 12);
		
		total = new JLabel("Total: ");		
		valorPago = new JLabel("Valor Pago: ");		
		titulo = new JLabel("Finalizar Venda");
		troco = new JLabel("Troco: ");
		titulo.setFont(new Font("Arial",Font.BOLD,20));
		
		totalF = new JTextField(6);
		valorPagoF= new JTextField(6);
		trocoF = new JTextField(6);
		
		finalizar = new JButton("Finalizar");
		voltar = new JButton("Voltar");
		voltar.setLocation(104, 381);
		voltar.setSize(107, 42);
		finalizar.setLocation(234, 381);
		finalizar.setSize(107, 42);
		
		titulo.setSize(157, 49);
		titulo.setLocation(109, 11);
		total.setBounds(55, 176, 39, 34);
		valorPago.setBounds(55, 221, 73, 34);
		troco.setBounds(55, 266, 39, 34);
		totalF.setBounds(133, 180, 197, 30);
		valorPagoF.setBounds(133, 225, 197, 30);
		trocoF.setBounds(133, 270, 197, 30);
		totalF.setEditable(false);
		trocoF.setEditable(false);
		
		total.setFont(fonte);
		valorPago.setFont(fonte);
		troco.setFont(fonte);
		
		getContentPane().add(titulo);
		getContentPane().add(total);
		getContentPane().add(totalF);
		getContentPane().add(valorPago);
		getContentPane().add(valorPagoF);
		getContentPane().add(troco);
		getContentPane().add(trocoF);
		getContentPane().add(finalizar);
		getContentPane().add(voltar);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(45, 132, 49, 27);
		getContentPane().add(lblCliente);
		lblCliente.setFont(fonte);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(130, 132, 197, 30);
		getContentPane().add(comboBox);
		
		pesquisar = new JTextField();
		pesquisar.setText("Pesquisar...");
		pesquisar.setBounds(130, 100, 197, 30);
		getContentPane().add(pesquisar);
		pesquisar.setColumns(10);
	}
	public int getInBox() {
		return comboBox.getSelectedIndex();
	}
	public void atualizarBox(List<Cliente> list) {
		comboBox.removeAllItems();		
		for(Cliente f: list) 
			comboBox.addItem(f.getNome());
		
	}
	public void empyBox() {
		comboBox.setSelectedIndex(-1);
	}
	public JTextField getTotalF() {
		return totalF;
	}
	public JTextField getValorPagoF() {
		return valorPagoF;
	}
	public JTextField getTrocoF() {
		return trocoF;
	}
	public JButton getFinalizar() {
		return finalizar;
	}
	public JButton getVoltar() {
		return voltar;
	}
	public JTextField getPesquisar() {
		return pesquisar;
	}
	public JComboBox<String> getComboBox() {
		return comboBox;
	}
}
