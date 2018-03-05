package view;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Finalizar_OS extends JInternalFrame{
	private JTextField dataInicio;
	private JTextField horaInicio;
	private JTextField dataFim;
	private JTextField horaFim;
	private JTextField valor;
	
	private JButton concluir;
	
	public Finalizar_OS() {
		setSize(500, 300);
		getContentPane().setLayout(null);
		setClosable(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		//setLocationRelativeTo(null);
		setLocation((Tela.LARGURA - this.getSize().width) / 2, (Tela.ALTURA - this.getSize().height) / 2); 
		JLabel lblDataInicio = new JLabel("Data Inicio: ");
		lblDataInicio.setBounds(10, 34, 102, 30);
		getContentPane().add(lblDataInicio);
		
		dataInicio = new JTextField();
		dataInicio.setBounds(111, 34, 100, 30);
		getContentPane().add(dataInicio);
		dataInicio.setColumns(10);
		
		JLabel horaInicioL = new JLabel("Hora Inicio: ");
		horaInicioL.setBounds(266, 34, 86, 30);
		getContentPane().add(horaInicioL);
		
		horaInicio = new JTextField();
		horaInicio.setBounds(362, 34, 100, 30);
		getContentPane().add(horaInicio);
		horaInicio.setColumns(10);
		
		JLabel lblDataFim = new JLabel("Data Fim: ");
		lblDataFim.setBounds(10, 100, 86, 30);
		getContentPane().add(lblDataFim);
		
		dataFim = new JTextField();
		dataFim.setBounds(111, 100, 100, 30);
		getContentPane().add(dataFim);
		dataFim.setColumns(10);
		
		JLabel lblHoraFim = new JLabel("Hora Fim:");
		lblHoraFim.setBounds(266, 100, 86, 30);
		getContentPane().add(lblHoraFim);
		
		horaFim = new JTextField();
		horaFim.setBounds(362, 100, 100, 30);
		getContentPane().add(horaFim);
		horaFim.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor: ");
		lblValor.setBounds(121, 157, 72, 30);
		getContentPane().add(lblValor);
		
		valor = new JTextField();
		valor.setBounds(192, 157, 100, 30);
		getContentPane().add(valor);
		valor.setColumns(10);
		
		concluir = new JButton("Concluir");
		concluir.setBounds(362, 202, 100, 30);
		getContentPane().add(concluir);
	}

	public JTextField getDataInicio() {
		return dataInicio;
	}

	public JTextField getHoraInicio() {
		return horaInicio;
	}

	public JTextField getDataFim() {
		return dataFim;
	}

	public JTextField getHoraFim() {
		return horaFim;
	}

	public JTextField getValor() {
		return valor;
	}

	public JButton getConcluir() {
		return concluir;
	}

	public void limparCampos() {
		dataInicio.setText("");
		dataFim.setText("");
		horaInicio.setText("");
		horaFim.setText("");
		valor.setText("");
	}
	
}
