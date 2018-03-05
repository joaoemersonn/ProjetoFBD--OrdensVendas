package view;

import java.awt.DisplayMode;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Tela extends JFrame{

	public static final int LARGURA =  1366;//(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static  final int  ALTURA = 768;//(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private P_Cadastro_Produto cadastroProduto;
	private P_Cadastro_Cliente cadastroCliente;
	private P_Venda vender;
	private P_Cadastro_OS cadastrarOrdemServico;
	private P_Produtos produtos;
	private P_Funcionarios funcionarios;
	private P_Cadastro_Funcionario cadastroFuncionarios;
	private P_OS os;
	private P_Clientes clientes;
	private P_Vendas vendas;
	public static  JDesktopPane desk;


	public Tela(boolean red){
		super("Venda e Ordem de Serviço");
		setUndecorated(red);
		redimencionar(red);
		setLayout(null);
		setSize(LARGURA, ALTURA);
		setResizable(false);		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);


		cadastroProduto = new P_Cadastro_Produto();
		cadastroCliente = new P_Cadastro_Cliente();
		vender = new P_Venda();
		cadastrarOrdemServico = new P_Cadastro_OS();
		produtos = new P_Produtos();
		funcionarios = new P_Funcionarios();
		cadastroFuncionarios = new P_Cadastro_Funcionario();
		clientes = new P_Clientes();
		os = new P_OS();
		desk = new JDesktopPane();
		vendas = new P_Vendas();
		vender.setVisible(true);
		desk.setVisible(true);
		setContentPane(desk);




		add(cadastroProduto).setBounds(0, 0, LARGURA, ALTURA);
		add(cadastroCliente).setBounds(0, 0, LARGURA, ALTURA);
		//add(inicio).setBounds(0, 0, LARGURA, ALTURA);
		add(vender).setBounds(0, 0, LARGURA, ALTURA);
		add(cadastrarOrdemServico).setBounds(0, 0, LARGURA, ALTURA);
		add(produtos).setBounds(0, 0, LARGURA, ALTURA);
		add(cadastroFuncionarios).setBounds(0, 0, LARGURA, ALTURA);
		add(funcionarios).setBounds(0, 0, LARGURA, ALTURA);
		add(clientes).setBounds(0, 0, LARGURA, ALTURA);
		add(os).setBounds(0, 0, LARGURA, ALTURA);
		add(vendas).setBounds(0, 0, LARGURA, ALTURA);

		setVisible(true);
	}


	private void redimencionar(boolean red) {
		if(red) {
			getGraphicsConfiguration().getDevice().setFullScreenWindow(this);
						try{
							getGraphicsConfiguration().getDevice().setDisplayMode(
									new DisplayMode(Tela.LARGURA, Tela.ALTURA, 32,DisplayMode.REFRESH_RATE_UNKNOWN));
						}catch(Exception e){
							Mensagens.erro("Não foi Possivel Redimensionar a Tela",e.getMessage());
						}
		}

	}





	public P_Cadastro_Produto getCadastroProduto() {
		return cadastroProduto;
	}

	public P_Cadastro_Cliente getCadastroCliente() {
		return cadastroCliente;
	}

	public P_Venda getInicio() {
		return vender;
	}

	public P_Venda getVender() {
		return vender;
	}

	public P_Cadastro_OS getCadastrarOrdemServico() {
		return cadastrarOrdemServico;
	}

	public P_Produtos getProdutos() {
		return produtos;
	}
	public P_Funcionarios getFuncionarios() {
		return funcionarios;
	}
	public P_Cadastro_Funcionario getCadastroFuncionarios() {
		return cadastroFuncionarios;
	}
	public P_Clientes getClientes() {
		return clientes;
	}
	public P_OS getOs() {
		return os;
	}


	public P_Vendas getVendas() {
		return vendas;
	}

}
