package view;

import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class Cadastro_Lote extends JInternalFrame {
	private JFormattedTextField datFabF;	
	private JButton cancelar, salvar;
	private JLabel lblDataFabricao;
	private JLabel lblDataVencimento;
	private JFormattedTextField datValF;
	private JLabel lblPreoCompra;
	private JTextField precoCompraF;
	private JLabel margemL;
	private JTextField margemLucroF;
	private JLabel lblPreoVenda;
	private JTextField precoVenda;
	private MaskFormatter dataFormater;
	private JLabel lblddmmaaaa;
	private JLabel lblQuantidade;
	private JTextField qntdF;
	private JRadioButton perecivelC;
	private JTextField codLote;

	public Cadastro_Lote(){
		setTitle("Cadastrar Lote");
		setSize(710,430);
		setResizable(false);		
		setLocation((Tela.LARGURA - this.getSize().width) / 2, (Tela.ALTURA - this.getSize().height) / 2);
		//cepF = new JFormattedTextField();
		try { dataFormater = new MaskFormatter("##-##-####");} catch (ParseException e1) {}
		salvar = new JButton("Salvar");
		salvar.setBounds(570, 331, 110, 42);
		cancelar =  new JButton("Cancelar");
		cancelar.setBounds(426, 331, 110, 42);
		getContentPane().setLayout(null);
		getContentPane().add(salvar);
		getContentPane().add(cancelar);
		
		lblDataFabricao = new JLabel("Data Fabrica\u00E7\u00E3o:");
		lblDataFabricao.setBounds(28, 103, 135, 30);
		getContentPane().add(lblDataFabricao);
		
		datFabF = new JFormattedTextField(dataFormater);
		datFabF.setBounds(164, 103, 110, 30);
		getContentPane().add(datFabF);
		
		lblDataVencimento = new JLabel("Data Vencimento:");
		lblDataVencimento.setBounds(361, 103, 135, 30);
		getContentPane().add(lblDataVencimento);
		
		datValF = new JFormattedTextField(dataFormater);
		datValF.setBounds(493, 103, 110, 30);
		getContentPane().add(datValF);
		
		lblPreoCompra = new JLabel("Pre\u00E7o Compra:");
		lblPreoCompra.setBounds(28, 176, 135, 30);
		getContentPane().add(lblPreoCompra);
		
		precoCompraF = new JTextField();
		precoCompraF.setBounds(164, 176, 92, 30);
		getContentPane().add(precoCompraF);
		precoCompraF.setColumns(10);
		
		margemL = new JLabel("Margem Lucro:");
		margemL.setBounds(361, 176, 135, 30);
		getContentPane().add(margemL);
		
		margemLucroF = new JTextField();
		margemLucroF.setBounds(493, 176, 92, 30);
		getContentPane().add(margemLucroF);
		margemLucroF.setColumns(10);
		
		lblPreoVenda = new JLabel("Pre\u00E7o Venda:");
		lblPreoVenda.setBounds(361, 246, 135, 30);
		getContentPane().add(lblPreoVenda);
		
		precoVenda = new JTextField();
		precoVenda.setEditable(false);
		precoVenda.setEnabled(false);
		precoVenda.setBounds(493, 246, 92, 30);
		getContentPane().add(precoVenda);
		precoVenda.setColumns(10);
		
		lblddmmaaaa = new JLabel("(DD-MM-AAAA)");
		lblddmmaaaa.setBounds(164, 134, 110, 14);
		getContentPane().add(lblddmmaaaa);
		
		lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(28, 246, 135, 30);
		getContentPane().add(lblQuantidade);
		
		qntdF = new JTextField();
		qntdF.setBounds(164, 246, 92, 30);
		getContentPane().add(qntdF);
		qntdF.setColumns(10);
		
		perecivelC = new JRadioButton("Produto Não Perecivel");
		perecivelC.setBounds(493, 130, 187, 23);
		getContentPane().add(perecivelC);
		
		JLabel lblNDoLote = new JLabel("N\u00BA do Lote:");
		lblNDoLote.setBounds(28, 42, 84, 30);
		getContentPane().add(lblNDoLote);
		
		codLote = new JTextField();
		codLote.setBounds(124, 42, 110, 30);
		getContentPane().add(codLote);
		codLote.setColumns(10);
		
		JLabel lblr = new JLabel("(R$)");
		lblr.setBounds(254, 183, 55, 16);
		getContentPane().add(lblr);
		
		JLabel label = new JLabel("(%)");
		label.setBounds(585, 183, 55, 16);
		getContentPane().add(label);
		
	}

	public JFormattedTextField getDatFabF() {
		return datFabF;
	}
	public void limparCampos() {
		datFabF.setValue(null);// = new JFormattedTextField(dataFormater);
		datValF.setValue(null); //= new JFormattedTextField(dataFormater);
		codLote.setText(null);
		qntdF.setText(null);
		precoVenda.setText(null);
		precoCompraF.setText(null);
		margemLucroF.setText(null);
		perecivelC.setSelected(false);
		datValF.setEnabled(true);
	}

	public JButton getCancelar() {
		return cancelar;
	}

	public JButton getSalvar() {
		return salvar;
	}

	public JFormattedTextField getDatValF() {
		return datValF;
	}

	public JTextField getPrecoCompraF() {
		return precoCompraF;
	}

	public JTextField getMargemLucroF() {
		return margemLucroF;
	}

	public JTextField getPrecoVenda() {
		return precoVenda;
	}

	public JTextField getQntdF() {
		return qntdF;
	}

	public JRadioButton getPerecivelC() {
		return perecivelC;
	}

	public JTextField getCodLote() {
		return codLote;
	}
}
