package view;

import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

@SuppressWarnings("serial")
public class Cadastrar_Endereco extends JInternalFrame {
	private JLabel   ruaL, numeroL, bairroL, cidadeL, cepL;
	private JTextField  ruaF, numeroF, bairroF, cidadeF;
	private JFormattedTextField cepF;	
	private JButton cancelar, salvar;
	private MaskFormatter cep;
	
	public Cadastrar_Endereco() {
		setTitle("Cadastro de Endere\u00E7o");
		setSize(500,300);
		setResizable(false);
		getContentPane().setLayout(null);
		//setLocationRelativeTo(null);
		setLocation((Tela.LARGURA - this.getSize().width) / 2, (Tela.ALTURA - this.getSize().height) / 2); 
		try { cep = new MaskFormatter("#####-###");} catch (ParseException e1) {}
		ruaL = new JLabel("Rua:");
		numeroL = new JLabel("Numero:");
		bairroL = new JLabel("Bairro:");
		cidadeL = new JLabel("Cidade:");
		cepL = new JLabel("CEP:");
		
		ruaF = new JTextField();
		numeroF = new JTextField();
		bairroF = new JTextField();
		cidadeF = new JTextField();
		cepF = new JFormattedTextField(cep);
		
		salvar = new JButton("Salvar");
		salvar.setSize(110, 42);
		salvar.setLocation(367, 213);
		cancelar =  new JButton("Cancelar");
		cancelar.setLocation(235, 213);
		cancelar.setSize(110, 42);

		
		ruaL.setBounds(10, 21, 40, 30);
		ruaF.setBounds(52, 20, 411, 30);
		numeroL.setBounds(10, 83, 70, 30);
		numeroF.setBounds(79, 83, 70, 30);
		bairroL.setBounds(181, 83, 75, 30);
		bairroF.setBounds(254, 83, 212, 30);
		cidadeL.setBounds(10, 147, 60, 30);
		cidadeF.setBounds(77, 147, 169, 30);
		cepL.setBounds(255, 147, 39, 30);
		cepF.setBounds(304, 147, 159, 30);
		
		getContentPane().add(ruaL);
		getContentPane().add(ruaF);
		getContentPane().add(numeroL);
		getContentPane().add(numeroF);
		getContentPane().add(bairroL);
		getContentPane().add(bairroF);
		getContentPane().add(cidadeL);
		getContentPane().add(cidadeF);
		getContentPane().add(cepL);
		getContentPane().add(cepF);
		getContentPane().add(salvar);
		getContentPane().add(cancelar);
	}
	public void limparCampos() {
		ruaF.setText(null);
		numeroF.setText(null);
		bairroF.setText(null);
		cidadeF.setText(null);
		cepF.setValue(null); //= new JFormattedTextField(cep);
	}
	public JTextField getRuaF() {
		return ruaF;
	}

	public JTextField getNumeroF() {
		return numeroF;
	}

	public JTextField getBairroF() {
		return bairroF;
	}

	public JTextField getCidadeF() {
		return cidadeF;
	}

	public JTextField getCepF() {
		return cepF;
	}

	public JButton getCancelar() {
		return cancelar;
	}

	public JButton getSalvar() {
		return salvar;
	}

}
