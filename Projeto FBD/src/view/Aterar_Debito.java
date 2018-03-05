package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Aterar_Debito extends JInternalFrame{
	private JLabel debitoL,valorPago,troco,titulo;
	private JTextField debito,valorPagoF,trocoF;
	private JButton finalizar, voltar;
	private Font fonte;
	private JTextField ndebito;
	public Aterar_Debito(){
		setTitle("Alterar D\u00E9bito");
		setSize(382, 480);
		getContentPane().setLayout(null);
		setResizable(false);
		//setLocationRelativeTo(null);
		setLocation((Tela.LARGURA - this.getSize().width) / 2, (Tela.ALTURA - this.getSize().height) / 2); 
		requestFocus();
		fonte = new Font("Comic Sans", Font.BOLD, 12);
		
		debitoL = new JLabel("D\u00E9bito:");		
		valorPago = new JLabel("Valor Pago: ");		
		titulo = new JLabel("Alterar D\u00E9bito");
		troco = new JLabel("Troco: ");
		titulo.setFont(new Font("Arial",Font.BOLD,20));
		
		debito = new JTextField(6);
		valorPagoF= new JTextField(6);
		trocoF = new JTextField(6);
		trocoF.setEnabled(false);
		
		finalizar = new JButton("Salvar");
		voltar = new JButton("Voltar");
		voltar.setLocation(104, 381);
		voltar.setSize(107, 42);
		finalizar.setLocation(234, 381);
		finalizar.setSize(107, 42);
		
		titulo.setSize(157, 49);
		titulo.setLocation(109, 11);
		debitoL.setBounds(47, 94, 39, 34);
		valorPago.setBounds(47, 139, 73, 34);
		troco.setBounds(47, 184, 39, 34);
		debito.setBounds(125, 98, 197, 30);
		valorPagoF.setBounds(125, 143, 197, 30);
		trocoF.setBounds(125, 188, 197, 30);
		trocoF.setEditable(false);
		
		debitoL.setFont(fonte);
		valorPago.setFont(fonte);
		troco.setFont(fonte);
		
		getContentPane().add(titulo);
		getContentPane().add(debitoL);
		getContentPane().add(debito);
		getContentPane().add(valorPago);
		getContentPane().add(valorPagoF);
		getContentPane().add(troco);
		getContentPane().add(trocoF);
		getContentPane().add(finalizar);
		getContentPane().add(voltar);
		
		JLabel lblNovoDbito = new JLabel("Novo D\u00E9bito:");
		lblNovoDbito.setBounds(47, 272, 85, 21);
		getContentPane().add(lblNovoDbito);
		
		ndebito = new JTextField();
		ndebito.setEnabled(false);
		ndebito.setEditable(false);
		ndebito.setBounds(125, 267, 197, 30);
		getContentPane().add(ndebito);
		ndebito.setColumns(10);
		lblNovoDbito.setFont(fonte);
	}

	public JTextField getDebito() {
		return debito;
	}
	public JButton getFinalizar() {
		return finalizar;
	}
	public JButton getVoltar() {
		return voltar;
	}
	public JTextField getNdebito() {
		return ndebito;
	}

	public JTextField getValorPagoF() {
		return valorPagoF;
	}

	public void setValorPagoF(JTextField valorPagoF) {
		this.valorPagoF = valorPagoF;
	}

	public JTextField getTrocoF() {
		return trocoF;
	}

	public void setTrocoF(JTextField trocoF) {
		this.trocoF = trocoF;
	}

	public void setDebito(JTextField debito) {
		this.debito = debito;
	}

	public void limparCampos() {
		debito.setText("");
		valorPagoF.setText("");
		trocoF.setText("");
		ndebito.setText("");
	}
}
