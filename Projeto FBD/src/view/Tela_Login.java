package view;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import app.Util;

@SuppressWarnings("serial")
public class Tela_Login extends JFrame{
	private JTextField loginF;
	private JPasswordField senhaF;
	private JButton entrar;
	JCheckBox redimencionarTela;
	public Tela_Login() {
		super("Login");
		
		Util.setDefaultFont();
		setSize(500, 300);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblLoginFuncionrio = new JLabel("Login Funcion\u00E1rio");
		lblLoginFuncionrio.setBounds(172, 5, 150, 44);
		getContentPane().add(lblLoginFuncionrio);
		
		JLabel login = new JLabel("Login:");
		login.setBounds(25, 74, 72, 42);
		getContentPane().add(login);
		
		loginF = new JTextField();
		loginF.setBounds(107, 72, 268, 44);
		getContentPane().add(loginF);
		loginF.setColumns(10);
		
		JLabel senha = new JLabel("Senha:");
		senha.setBounds(25, 147, 72, 42);
		getContentPane().add(senha);
		
		senhaF = new JPasswordField();
		senhaF.setBounds(107, 147, 268, 44);
		getContentPane().add(senhaF);
		
		entrar = new JButton("Entrar");
		entrar.setBounds(361, 215, 101, 36);
		getContentPane().add(entrar);
		
		redimencionarTela = new JCheckBox("Tela Cheia");//("Redimencionar Tela");
		redimencionarTela.setSelected(true);
		redimencionarTela.setBounds(25, 222, 231, 23);
		getContentPane().add(redimencionarTela);
	}
	
	public JTextField getLoginF() {
		return loginF;
	}
	public JPasswordField getSenhaF() {
		return senhaF;
	}
	public JButton getEntrar() {
		return entrar;
	}
	public JCheckBox getRedimencionarTela() {
		return redimencionarTela;
	}
}
