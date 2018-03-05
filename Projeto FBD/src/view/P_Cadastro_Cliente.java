package view;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import modelo.EnderecoTableModel;

@SuppressWarnings("serial")
public class P_Cadastro_Cliente extends JPanel{
	
	private JLabel tituloL, nomeL, cpfL, rgL, telefoneL;
	private JTextField nomeF, rgF;
	private JFormattedTextField telefoneF, cpfF;	
	private JButton cancelar,salvar, adicionarEndereo, removerEndereco,editarEndereco;
	private JScrollPane scroll;
	private JTable table;
	private EnderecoTableModel modelo;
	private MaskFormatter telefone, cpf;
	
	public P_Cadastro_Cliente(){
		setSize(Tela.LARGURA,Tela.ALTURA);
		setLayout(null);
		try { telefone = new MaskFormatter("(##) #####-####"); 
		cpf = new MaskFormatter("###.###.###-##"); 
				} catch (ParseException e1) {}
		table = new JTable();
		table.setModel(new EnderecoTableModel());
		modelo = (EnderecoTableModel) table.getModel();
		scroll = new JScrollPane(table);
		scroll.setLocation(348, 332);
		scroll.setSize(590, 284);
		tituloL = new JLabel("Cadastro de Cliente");
		
		nomeL = new JLabel("Nome:");
		cpfL = new JLabel("CPF:");
		rgL = new JLabel("RG:");
		telefoneL = new JLabel("Telefone:");
				
		nomeF = new JTextField();
		rgF = new JTextField();
		cpfF = new JFormattedTextField(cpf);
		telefoneF = new JFormattedTextField(telefone);
		
		
		salvar = new JButton("Salvar");
		cancelar =  new JButton("Voltar");
		
		tituloL.setBounds(562, 20, 238, 30);
		tituloL.setFont(new Font("Batang", Font.BOLD, 24));
		
		nomeL.setBounds(270, 116, 60, 30);
		nomeF.setBounds(337, 116, 616, 30);
		cpfL.setBounds(270, 213, 45, 30);
		cpfF.setBounds(315, 213, 166, 30);
		rgL.setBounds(491, 213, 29, 30);
		rgF.setBounds(530, 213, 150, 30);
		telefoneL.setBounds(711, 213, 85, 30);
		telefoneF.setBounds(803, 213, 150, 30);
		
		
		salvar.setBounds(1117, 667, 150, 50);
		cancelar.setBounds(931, 667, 150, 50);
		
		add(tituloL);
		add(nomeL);
		add(nomeF);
		add(cpfL);
		add(cpfF);
		add(rgL);
		add(rgF);
		add(telefoneL);
		add(telefoneF);
		add(salvar);
		add(cancelar);
		add(scroll);
		
		JLabel lblEndereos = new JLabel("Endere\u00E7os: ");
		lblEndereos.setBounds(270, 282, 109, 39);
		add(lblEndereos);
		
		adicionarEndereo = new JButton("Adicionar Endere\u00E7o");
		adicionarEndereo.setBounds(960, 339, 180, 50);
		add(adicionarEndereo);
		
		removerEndereco = new JButton("Remover Endere\u00E7o");
		removerEndereco.setBounds(960, 440, 180, 50);
		add(removerEndereco);
		
		editarEndereco = new JButton("Editar Endere\u00E7o");
		editarEndereco.setBounds(960, 541, 180, 50);
		add(editarEndereco);
		
		setVisible(false);
	}
	public boolean verificarCampos() {
		if(!nomeF.getText().isEmpty() && !cpfF.getText().isEmpty() 
				&& !rgF.getText().isEmpty() 
				&& !telefoneF.getText().isEmpty() 
//				&& !ruaF.getText().isEmpty() 
//				&& !numeroF.getText().isEmpty() 
//				&& !bairroF.getText().isEmpty() 
//				&&!cidadeF.getText().isEmpty() 
//				&& !cepF.getText().isEmpty())
				)
			return true;
		return false;
	}
	public int getIndexTable() {
		return table.getSelectedRow();
	}
	public void limparCampos() {
		nomeF.setText("");
		rgF.setText("");
		cpfF = new JFormattedTextField(cpf);
		telefoneF = new JFormattedTextField(telefone);
		
	}

	public JTextField getNomeF() {
		return nomeF;
	}

	public JTextField getCpfF() {
		return cpfF;
	}

	public JTextField getRgF() {
		return rgF;
	}

	public JTextField getTelefoneF() {
		return telefoneF;
	}	

	public JButton getCancelar() {
		return cancelar;
	}

	public JButton getSalvar() {
		return salvar;
	}
	public EnderecoTableModel getModelo() {
		return modelo;
	}
	public JButton getAdicionarEndereo() {
		return adicionarEndereo;
	}
	public JButton getRemoverEndereco() {
		return removerEndereco;
	}
	public JButton getEditarEndereco() {
		return editarEndereco;
	}
}
