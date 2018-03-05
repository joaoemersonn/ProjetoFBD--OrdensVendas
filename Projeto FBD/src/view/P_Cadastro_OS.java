package view;

import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import modelo.Cliente;
import modelo.Endereco;
import modelo.Funcionario;


@SuppressWarnings("serial")
public class P_Cadastro_OS extends JPanel{
	
	JLabel tituloL, clienteL, endClienteL, tecnicoL, descricaoL, valorL,observacoesL;//,dataAberturaL, horaAberturaL ;
	JComboBox<String> clienteF, tecnicoF, endClienteF ;
	JTextField	valorF,dataAberturaF,horaAberturaF;
	JTextArea descricaoA, observacoesA;
	JButton salvar, cancelar;
	private JTextField pesquisar;
	
	public P_Cadastro_OS(){
		setSize(Tela.LARGURA,Tela.ALTURA);
		setLayout(null);
		tituloL =  new JLabel("Nova Ordem de Serviço");
		clienteL = new JLabel("Cliente:");
		endClienteL = new JLabel("Endereço:");
		tecnicoL = new JLabel("Tecnico:");
		descricaoL = new JLabel("Descrição do Serviço:");
		valorL = new JLabel("Valor do Serviço:");
		observacoesL = new JLabel("Observações:");
			
		clienteF = new JComboBox<String>();
		endClienteF = new JComboBox<String>();
		tecnicoF =  new JComboBox<String>();
		descricaoA = new JTextArea();
		valorF =  new JTextField(5);
		observacoesA = new JTextArea();
		
		salvar = new JButton("Salvar");
		cancelar =  new JButton("Voltar");
		
		tituloL.setBounds(483, 20, 400, 30);
		tituloL.setFont(new Font("Batang", Font.BOLD, 24));
		
		clienteL.setBounds(141, 116, 81, 28);
		clienteF.setBounds(247, 118, 600, 25);
		endClienteL.setBounds(139, 157, 89, 33);
		endClienteF.setBounds(251, 165, 400, 25);
		tecnicoL.setBounds(135, 273, 105, 31);
		tecnicoF.setBounds(247, 278, 557, 25);
		descricaoL.setBounds(137, 373, 200, 25);
		descricaoA.setBounds(137, 403, 1084, 80);
		valorL.setBounds(837, 279, 139, 26);
		valorF.setBounds(989, 277, 115, 27);
		observacoesL.setBounds(141, 479, 110, 52);
		observacoesA.setBounds(141, 536, 1084, 88);
		salvar.setBounds(1225, 673, 131, 52);
		cancelar.setBounds(1001, 673, 136, 52);
		
		
		
		add(tituloL);
		add(clienteL);
		add(clienteF);
		add(endClienteL);
		add(endClienteF);
		add(tecnicoL);
		add(tecnicoF);
		add(descricaoL);
		add(descricaoA);
		add(valorL);
		add(valorF);
		add(observacoesL);
		add(observacoesA);
		add(salvar);
		add(cancelar);
		
		pesquisar = new JTextField();
		pesquisar.setText("Pesquisar...");
		pesquisar.setBounds(247, 88, 427, 28);
		add(pesquisar);
		pesquisar.setColumns(10);
		
		setVisible(false);
	}
	public void limparCampos() {
		pesquisar.setText("Pesquisar...");
		descricaoA.setText("");
		valorF.setText("");
		observacoesA.setText("");
		observacoesA.setText("");
	}
	public void atualizarBoxFuncionario(List<Funcionario> list) {
		tecnicoF.removeAllItems();
		for(Funcionario f: list) {
			tecnicoF.addItem(f.getNome());
		}
	}
	public void atualizarBoxClientes(List<Cliente> list) {
		clienteF.removeAllItems();
		for(Cliente c: list) {
			clienteF.addItem(c.getNome());
		}
	}
	public void atualizarBoxEnderecos(List<Endereco> list) {
		endClienteF.removeAllItems();
		for(Endereco c: list) {
			endClienteF.addItem(c.getNumero()+", Rua "+c.getRua());
		}
	}

	public JComboBox<String> getEndClienteF() {
		return endClienteF;
	}

	

	public JTextArea getDescricaoA() {
		return descricaoA;
	}

	public JTextArea getObservacoesA() {
		return observacoesA;
	}

	public JButton getSalvar() {
		return salvar;
	}

	public JButton getCancelar() {
		return cancelar;
	}
	

	public JTextField getValorF() {
		return valorF;
	}

	public JTextField getDataAberturaF() {
		return dataAberturaF;
	}

	public JTextField getHoraAberturaF() {
		return horaAberturaF;
	}
	public JComboBox<String> getClienteF() {
		return clienteF;
	}
	public JTextField getPesquisar() {
		return pesquisar;
	}
	public JComboBox<String> getTecnicoF() {
		return tecnicoF;
	}
}
