package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class P_Cadastro_Funcionario extends JPanel{
	private JTextField NomeF;
	private JTextField cpfF;
	private JTextField rgF;
	private JTextField loginF;
	private JPasswordField senhaF;
	private JButton cancelar, salvar;
	
	public P_Cadastro_Funcionario() {
	setSize(Tela.LARGURA,Tela.ALTURA);
	setLayout(null);	
	JLabel lblCadastroFuncionairos = new JLabel("Cadastro Funcionairo");
	lblCadastroFuncionairos.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 20));
	lblCadastroFuncionairos.setBounds(571, 31, 223, 72);
	add(lblCadastroFuncionairos);
	
	JLabel Nome = new JLabel("Nome:");
	Nome.setBounds(331, 192, 67, 37);
	add(Nome);
	
	NomeF = new JTextField();
	NomeF.setBounds(408, 192, 549, 37);
	add(NomeF);
	NomeF.setColumns(10);
	
	JLabel cpf = new JLabel("CPF:");
	cpf.setBounds(331, 302, 56, 37);
	add(cpf);
	
	cpfF = new JTextField();
	cpfF.setBounds(397, 302, 223, 37);
	add(cpfF);
	cpfF.setColumns(10);
	
	JLabel rg = new JLabel("RG:");
	rg.setBounds(683, 302, 73, 37);
	add(rg);
	
	rgF = new JTextField();
	rgF.setBounds(759, 302, 198, 37);
	add(rgF);
	rgF.setColumns(10);
	
	JLabel login = new JLabel("Login:");
	login.setBounds(331, 403, 57, 35);
	add(login);
	
	loginF = new JTextField();
	loginF.setBounds(408, 410, 223, 37);
	add(loginF);
	loginF.setColumns(10);
	
	JLabel senha = new JLabel("Senha:");
	senha.setBounds(694, 412, 73, 37);
	add(senha);
	
	senhaF = new JPasswordField();
	senhaF.setBounds(770, 410, 187, 37);
	add(senhaF);
	
	salvar = new JButton("Salvar");
	salvar.setBounds(724, 552, 105, 37);
	add(salvar);
	
	cancelar = new JButton("Voltar");
	cancelar.setBounds(526, 552, 105, 37);
	add(cancelar);
	setVisible(false);
	}

	public JTextField getNomeF() {
		return NomeF;
	}
	public void limparCampos() {
		NomeF.setText("");
		cpfF.setText("");
		rgF.setText("");
		loginF.setText("");
		senhaF.setText("");
	}

	public JTextField getCpfF() {
		return cpfF;
	}

	public JTextField getRgF() {
		return rgF;
	}

	public JTextField getLoginF() {
		return loginF;
	}

	public JPasswordField getSenhaF() {
		return senhaF;
	}

	public JButton getCancelar() {
		return cancelar;
	}

	public JButton getSalvar() {
		return salvar;
	}
}
