package app;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import controller.Controlador_Tela_Login;
import fachada.Fachada;
import modelo.Cliente;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.Lote;
import modelo.OServico;
import modelo.Produto;
import modelo.Venda;
import view.Cadastrar_Endereco;
import view.Cadastro_Lote;
import view.Detalhe_OS;
import view.Finalizar_OS;
import view.Mensagens;
import view.P_Cadastro_Cliente;
import view.P_Cadastro_Funcionario;
import view.P_Cadastro_OS;
import view.P_Cadastro_Produto;
import view.P_Venda;

public class Util{	
	public static Funcionario funcionarioLogado;
	public static Controlador_Tela_Login controladorLogin;
	public static Fachada fachada = new Fachada();

	private Util(){}

	public OServico getOSTela(P_Cadastro_Produto panel) {

		return null;
	}

	public static Produto getProdutoTela(P_Cadastro_Produto panel,Produto p) {
		Produto produto = p;
		produto.setDescricao(panel.getDescricaoF().getText());
		produto.setCodigo(panel.getCodigoF().getText());
		produto.setMarca(panel.getMarcaF().getText());
		return produto;	

	}
	public static Lote getLoteTela(Cadastro_Lote panel) {
		Lote l = new Lote();
		l.setQuantidade(Float.parseFloat(panel.getQntdF().getText()));
		l.setDataFab(panel.getDatFabF().getText());
		l.setPrecoCompra(Float.parseFloat(panel.getPrecoCompraF().getText()));
		l.setMargemLucro(Float.parseFloat(panel.getMargemLucroF().getText()));//TEm que alterar
		l.setDataVenc(panel.getPerecivelC().isSelected()? null:panel.getDatValF().getText());
		l.setId(panel.getCodLote().getText());		
		return l;
		
	}
	public static String inverterString(String s) {
		StringBuilder string = new StringBuilder(s);
		string.reverse();
		return string.toString();
		
	}
	public static void setProdutoTela(P_Cadastro_Produto panel, Produto p) {
		panel.getDescricaoF().setText(p.getDescricao());
		panel.getCodigoF().setEditable(false);
		panel.getLoteAtivo().setText("Lote Ativo: Nº"+p.getLote_ativo());
		//panel.getLote().getQntdF().setText(p.getQuantidade()+"");
		//panel.getLote().getDatFabF().setText(p.getDataFab());
		//panel.getLote().getPrecoCompraF().setText(p.getPrecoCompra()+"");
		//panel.getLote().getMargemLucroF().setText(p.getMargemLucro()+"");
		panel.getCodigoF().setText(p.getCodigo());
		panel.getMarcaF().setText(p.getMarca());
		//panel.getLote().getDatValF().setText(p.getDataVenc());
//		if(p.getDataVenc().equals("NAO PERECIVEL")) {
//			panel.getLote().getPerecivelC().setSelected(true);
//			panel.getLote().getDatValF().setEditable(false);}

	}
	public static void setLoteTela(Cadastro_Lote panel, Lote l) {
		panel.getCodLote().setText(l.getId());
		panel.getCodLote().setEnabled(false);
		panel.getDatFabF().setText(l.getDataFab());
		panel.getDatValF().setText(l.getDataVenc());
		panel.getPrecoCompraF().setText(l.getPrecoCompra()+"");
		panel.getPrecoVenda().setText(l.getPrecoV()+"");
		panel.getMargemLucroF().setText(l.getMargemLucro()+"");
		panel.getPerecivelC().setSelected(l.getDataVenc()==null);
		panel.getDatValF().setEnabled(!panel.getPerecivelC().isSelected());
		panel.getQntdF().setText(l.getQuantidade()+"");
	}
	public static Endereco getEnderecoTela(Cadastrar_Endereco panel) {
		Endereco e = new Endereco();
		e.setBairro(panel.getBairroF().getText());
		e.setRua(panel.getRuaF().getText());
		e.setNumero(panel.getNumeroF().getText());
		e.setCidade(panel.getCidadeF().getText());
		e.setCep(panel.getCepF().getText());
		return e;
	}
	public static Cliente getClienteTela(P_Cadastro_Cliente panel, ArrayList<Endereco> enderecos) {
		
		Cliente c = new Cliente();

		c.setCpf(panel.getCpfF().getText().replaceAll("[.-]", ""));
		c.setNome(panel.getNomeF().getText());
		c.setRg(panel.getRgF().getText());
		c.setTelefone(panel.getTelefoneF().getText());
		c.setEnderecos(enderecos);

		return c;
	}
	@SuppressWarnings("deprecation")
	public static Funcionario getFuncionarioTela(P_Cadastro_Funcionario panel) {
		Funcionario f = new Funcionario();
		f.setNome(panel.getNomeF().getText());
		f.setCpf(panel.getCpfF().getText());
		f.setRg(panel.getRgF().getText());
		f.setLogin(panel.getLoginF().getText());
		f.setSenha(panel.getSenhaF().getText());
		return f;
	}
	public static void setFuncionarioTela(P_Cadastro_Funcionario panel,Funcionario f) {
		panel.getNomeF().setText(f.getNome());
		panel.getCpfF().setText(f.getCpf());
		panel.getRgF().setText(f.getRg());
		panel.getLoginF().setText(f.getLogin());
		panel.getSenhaF().setText(f.getSenha());
		//panel.getCpfF().setEditable(false);
	}
	public static String getDataAtual() {
		String dia = java.time.LocalDate.now().getDayOfMonth()<10?"0"+java.time.LocalDate.now().getDayOfMonth():java.time.LocalDate.now().getDayOfMonth()+"";
		String mes = java.time.LocalDate.now().getMonthValue()<10?"0"+java.time.LocalDate.now().getMonthValue():java.time.LocalDate.now().getMonthValue()+"";
		return (dia+"-"+mes+"-"+java.time.LocalDate.now().getYear());
	}
	public static String getHoraAtual() {
		return (java.time.LocalDateTime.now().getHour()+":"+java.time.LocalDateTime.now().getMinute()+":"+java.time.LocalDateTime.now().getSecond());
	}
	public static void setDefaultFont(){
		Font defaultFont = new Font("Comic Sans",Font.CENTER_BASELINE,15);
		FontUIResource font = new FontUIResource(defaultFont);

		Enumeration uiManagerKeys = UIManager.getDefaults().keys();
		while(uiManagerKeys.hasMoreElements()){
			Object key   = uiManagerKeys.nextElement(),
					value = UIManager.get(key);

			if(null != value && value instanceof FontUIResource)
				UIManager.put(key, font);
		}
	}

	public static void setClienteTela(P_Cadastro_Cliente p, Cliente c) {
		p.getCpfF().setText(c.getCpf());
		p.getRgF().setText(c.getRg());
		p.getNomeF().setText(c.getNome());
		p.getTelefoneF().setText(c.getTelefone());
		
	}

	public static void setEnderecoTela(Cadastrar_Endereco p, Endereco e) {
		p.getCepF().setText(e.getCep());
		p.getNumeroF().setText(e.getNumero());
		p.getCidadeF().setText(e.getCidade());
		p.getBairroF().setText(e.getBairro());
		p.getRuaF().setText(e.getRua());
	}

	public static OServico getOSTela(P_Cadastro_OS p) {
		OServico os = new OServico();
		try {
			p.getPesquisar().setText(p.getPesquisar().getText().equals("Pesquisar...")?"":p.getPesquisar().getText());
			os.setDescricao(p.getDescricaoA().getText());
			os.setCliente(fachada.getClientes(p.getPesquisar().getText()).get(p.getClienteF().getSelectedIndex()));
			os.setTecnico(fachada.getFuncionarios("").get(p.getTecnicoF().getSelectedIndex()));
			os.setFuncionario(funcionarioLogado);
			os.setEnd(p.getEndClienteF().getSelectedIndex());
			os.setValor(Float.parseFloat(p.getValorF().getText()));
			os.setObservacoes(p.getObservacoesA().getText());
		} catch (Exception e) { Mensagens.erro("Erro ao Salvar OS",e.getMessage());}
		return os;
	}
	public static void setOSTela(P_Cadastro_OS p, OServico o) {
		p.getPesquisar().setText(o.getCliente().getNome());		
		//p.getEndClienteF().setSelectedIndex(o.getEnd());
		p.getValorF().setText(o.getValor()+"");
		p.getDescricaoA().setText(o.getDescricao());
		p.getObservacoesA().setText(o.getObservacoes());
		p.getTecnicoF().setSelectedItem( (String)o.getTecnico().getNome());
		
	}

	public static void setFinalizarOS(Finalizar_OS p, OServico os) {
		p.getDataInicio().setText(os.getDataInicio());
		p.getHoraInicio().setText(os.getHoraInicio()==null?"HH:MM:SS":os.getHoraInicio());
		p.getDataFim().setText(os.getDataFim()==null?getDataAtual():os.getDataFim());
		p.getHoraFim().setText(os.getHoraFim()==null?getHoraAtual():os.getHoraFim());
		p.getValor().setText(os.getValor()+"");
		
	}

	public static void getFinalizarOS(Finalizar_OS p, OServico o) {
		o.setDataInicio(p.getDataInicio().getText());
		o.setHoraInicio(p.getHoraInicio().getText());
		o.setHoraFim(p.getHoraFim().getText());
		o.setDataFim(p.getDataFim().getText());
		o.setValor(Float.valueOf(p.getValor().getText()));
	}

	public static OServico getOSTela(P_Cadastro_OS p, OServico ordem) {
		OServico os = ordem;
		try {
			p.getPesquisar().setText(p.getPesquisar().getText().equals("Pesquisar...")?"":p.getPesquisar().getText());
			os.setDescricao(p.getDescricaoA().getText());
			os.setCliente(fachada.getClientes(p.getPesquisar().getText()).get(p.getClienteF().getSelectedIndex()));
			os.setTecnico(fachada.getFuncionarios("").get(p.getTecnicoF().getSelectedIndex()));
			os.setFuncionario(funcionarioLogado);
			os.setEnd(p.getEndClienteF().getSelectedIndex());
			os.setValor(Float.parseFloat(p.getValorF().getText()));
			os.setObservacoes(p.getObservacoesA().getText());
		} catch (Exception e) { Mensagens.erro("Erro ao Salvar OS",e.getMessage());}
		return os;
	}

	public static void setOSDetalheOS(Detalhe_OS p, OServico o) {
		p.getCliente().setText(o.getCliente().getNome());
		p.setTitle(o.getDescricao());
		p.getFuncionario().setText(o.getFuncionario().getNome());
		p.getTecnico().setText(o.getTecnico().getNome());
		if(o.getCliente().getEnderecos().size()-1>=o.getEnd()) {
		Endereco end = o.getCliente().getEnderecos().get(o.getEnd());
		p.getEndereco().setText("   Nº "+end.getNumero()+", Rua "+end.getRua()+"\n   Bairro: "+end.getBairro()+"\tCidade: "+end.getCidade());
		}else
			Mensagens.informacao("Não existe endereco cadastrado para essa ordem de serviço");
		p.getValor().setText("R$ "+o.getValor());
		p.getTelefone().setText(o.getCliente().getTelefone());
		p.getDataA().setText(o.getDataAbertura());
		p.getHoraA().setText(o.getHoraAbertura());
		p.getDataI().setText(o.getDataInicio());
		p.getHoraI().setText(o.getHoraInicio());
		p.getDataF().setText(o.getDataFim());
		p.getHoraF().setText(o.getHoraFim());
		p.getDescricao().setText(o.getDescricao());
		p.getObservacao().setText(o.getObservacoes());
	}

	public static void setVendaTela(P_Venda p, Venda v) {
		p.getTotalF().setText(""+v.getValor());
		p.getModelo().atualizarTable(v.getProdutos());
	}
}