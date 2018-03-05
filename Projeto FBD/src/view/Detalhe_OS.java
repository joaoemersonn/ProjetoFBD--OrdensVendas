package view;

import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Detalhe_OS extends JInternalFrame{
	private JTextField cliente;
	private JTextField telefone;
	private JTextField funcionario;
	private JTextField dataA;
	private JTextField horaA;
	private JTextField dataI;
	private JTextField horaI;
	private JTextField dataF;
	private JTextField horaF;
	private JTextField tecnico;
	private JTextField valor;
	private JButton fechar;
	private JTextArea endereco; 
	JTextField descricao,observacao;
	public Detalhe_OS() {
		setSize(900, 565);
		getContentPane().setLayout(null);
		setResizable(false);
		//setLocationRelativeTo(null);
		setLocation((Tela.LARGURA - this.getSize().width) / 2, (Tela.ALTURA - this.getSize().height) / 2); 
		requestFocus();
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(195, 80, 84, 30);
		getContentPane().add(lblCliente);
		
		cliente = new JTextField();
		cliente.setEnabled(false);
		cliente.setEditable(false);
		cliente.setBounds(270, 80, 582, 30);
		getContentPane().add(cliente);
		cliente.setColumns(10);
		
		JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio:");
		lblFuncionrio.setBounds(10, 339, 103, 30);
		getContentPane().add(lblFuncionrio);
		
		JLabel lblTcnico = new JLabel("T\u00E9cnico:");
		lblTcnico.setBounds(510, 339, 84, 30);
		getContentPane().add(lblTcnico);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(20, 133, 84, 30);
		getContentPane().add(lblEndereo);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 211, 101, 30);
		getContentPane().add(lblTelefone);
		
		endereco = new JTextArea();
		endereco.setEnabled(false);
		endereco.setBackground(SystemColor.menu);
		endereco.setEditable(false);
		endereco.setBounds(108, 136, 744, 64);
		getContentPane().add(endereco);
		
		telefone = new JTextField();
		telefone.setEnabled(false);
		telefone.setEditable(false);
		telefone.setBounds(95, 211, 175, 30);
		getContentPane().add(telefone);
		telefone.setColumns(10);
		
		JLabel lblDataAbertura = new JLabel("Data Abertura:");
		lblDataAbertura.setBounds(316, 211, 101, 30);
		getContentPane().add(lblDataAbertura);
		
		JLabel lblHoraAbertura = new JLabel("Hora Abertura:");
		lblHoraAbertura.setBounds(610, 211, 132, 30);
		getContentPane().add(lblHoraAbertura);
		
		JLabel lblDataIncio = new JLabel("Data Incio:");
		lblDataIncio.setBounds(10, 265, 101, 30);
		getContentPane().add(lblDataIncio);
		
		JLabel lblHoraInicio = new JLabel("Hora Inicio:");
		lblHoraInicio.setBounds(266, 265, 101, 30);
		getContentPane().add(lblHoraInicio);
		
		JLabel lblDataFim = new JLabel("Data Fim:");
		lblDataFim.setBounds(458, 265, 101, 30);
		getContentPane().add(lblDataFim);
		
		JLabel lblHoraFim = new JLabel("Hora Fim:");
		lblHoraFim.setBounds(681, 265, 101, 30);
		getContentPane().add(lblHoraFim);
		
		funcionario = new JTextField();
		funcionario.setEnabled(false);
		funcionario.setEditable(false);
		funcionario.setBounds(123, 339, 270, 30);
		getContentPane().add(funcionario);
		funcionario.setColumns(10);
		
		dataA = new JTextField();
		dataA.setEnabled(false);
		dataA.setEditable(false);
		dataA.setBounds(424, 211, 100, 30);
		getContentPane().add(dataA);
		dataA.setColumns(10);
		
		horaA = new JTextField();
		horaA.setEnabled(false);
		horaA.setEditable(false);
		horaA.setBounds(752, 211, 100, 30);
		getContentPane().add(horaA);
		horaA.setColumns(10);
		
		dataI = new JTextField();
		dataI.setEnabled(false);
		dataI.setEditable(false);
		dataI.setBounds(104, 265, 100, 30);
		getContentPane().add(dataI);
		dataI.setColumns(10);
		
		horaI = new JTextField();
		horaI.setEnabled(false);
		horaI.setEditable(false);
		horaI.setBounds(361, 265, 60, 30);
		getContentPane().add(horaI);
		horaI.setColumns(10);
		
		dataF = new JTextField();
		dataF.setEnabled(false);
		dataF.setEditable(false);
		dataF.setBounds(548, 265, 100, 30);
		getContentPane().add(dataF);
		dataF.setColumns(10);
		
		horaF = new JTextField();
		horaF.setEnabled(false);
		horaF.setEditable(false);
		horaF.setBounds(792, 265, 60, 30);
		getContentPane().add(horaF);
		horaF.setColumns(10);
		
		tecnico = new JTextField();
		tecnico.setEnabled(false);
		tecnico.setEditable(false);
		tecnico.setBounds(603, 339, 249, 30);
		getContentPane().add(tecnico);
		tecnico.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(20, 16, 93, 27);
		getContentPane().add(lblDescrio);
		
		descricao = new JTextField();
		descricao.setEnabled(false);
		descricao.setEditable(false);
		descricao.setBounds(123, 11, 729, 51);
		getContentPane().add(descricao);
		
		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es:");
		lblObservaes.setBounds(10, 397, 101, 30);
		getContentPane().add(lblObservaes);
		
		observacao = new JTextField();
		observacao.setEnabled(false);
		observacao.setEditable(false);
		observacao.setBounds(114, 392, 738, 51);
		getContentPane().add(observacao);
		
		fechar = new JButton("Fechar");
		fechar.setBounds(752, 467, 100, 35);
		getContentPane().add(fechar);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(24, 83, 60, 27);
		getContentPane().add(lblValor);
		
		valor = new JTextField();
		valor.setEnabled(false);
		valor.setEditable(false);
		valor.setBounds(85, 80, 86, 30);
		getContentPane().add(valor);
		valor.setColumns(10);
		
	}
	public JTextField getCliente() {
		return cliente;
	}
	public JTextField getTelefone() {
		return telefone;
	}
	public JTextField getFuncionario() {
		return funcionario;
	}
	public JTextField getDataA() {
		return dataA;
	}
	public JTextField getHoraA() {
		return horaA;
	}
	public JTextField getDataI() {
		return dataI;
	}
	public JTextField getHoraI() {
		return horaI;
	}
	public JTextField getDataF() {
		return dataF;
	}
	public JTextField getHoraF() {
		return horaF;
	}
	public JTextField getTecnico() {
		return tecnico;
	}
	public JTextField getValor() {
		return valor;
	}
	public JButton getFechar() {
		return fechar;
	}
	public JTextArea getEndereco() {
		return endereco;
	}
	public JTextField getDescricao() {
		return descricao;
	}
	public JTextField getObservacao() {
		return observacao;
	}
}
