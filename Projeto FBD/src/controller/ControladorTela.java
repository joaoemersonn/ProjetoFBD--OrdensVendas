package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import app.Util;
import fachada.IFachada;
import modelo.Cliente;
import modelo.DaoException;
import modelo.Endereco;
import modelo.OServico;
import modelo.Produto;
import modelo.Venda;
import view.Aterar_Debito;
import view.Cadastrar_Endereco;
import view.Concluir_Venda;
import view.Detalhe_OS;
import view.Finalizar_OS;
import view.Mensagens;
import view.Pesquisa_Produto;
import view.ProdutoVenda;
import view.Tela;

public class ControladorTela implements ActionListener, FocusListener, KeyListener, ItemListener{

	List<Cliente> clientes;
	IFachada fachada;
	Produto p,produto;
	Venda venda;
	Cliente c;
	boolean produtoEdit, funcionarioEdit,clienteEdit,enderecoEdit,ordemEdit,vendaEdit,loteEdit;
	String cpf;
	float total,troco;
	OServico ordem;
	int index = -1;
	ArrayList<Endereco> enderecos = new ArrayList<>();
	
	Tela tela;
	Pesquisa_Produto pesq;
	Concluir_Venda concluirVenda;
	Cadastrar_Endereco cadastro_endereco;
	Finalizar_OS finalizarOS;
	Detalhe_OS detalheOS;
	ProdutoVenda produtoVenda;
	Aterar_Debito debito;
	
	
	

	public ControladorTela(boolean red){
		Util.setDefaultFont();
		
		tela = new Tela(red);
		pesq = new Pesquisa_Produto();
		concluirVenda = new Concluir_Venda();
		cadastro_endereco = new Cadastrar_Endereco();
		finalizarOS = new Finalizar_OS();
		detalheOS = new Detalhe_OS();
		produtoVenda = new ProdutoVenda();
		debito = new Aterar_Debito();
		
		fachada = Util.fachada;// new Fachada();
		p = new Produto();
		venda = new Venda();
		tela.getInicio().getFuncionario().setText("Funcionário: "+Util.funcionarioLogado.getNome());
		inicialize();
		
		Tela.desk.add(pesq);
		Tela.desk.add(concluirVenda);
		Tela.desk.add(cadastro_endereco);
		Tela.desk.add(finalizarOS);
		Tela.desk.add(detalheOS);
		Tela.desk.add(produtoVenda);
		Tela.desk.add(debito);
		Tela.desk.add(tela.getCadastroProduto().getLote());
		//tela.getVender().setVisible(true);
		//tela.getVender().repaint();
	}
	public void inicialize() {	
		
		
		//tela.getInicio().getVender().addActionListener(this);
		tela.getInicio().getNovoServico().addActionListener(this);
		tela.getInicio().getClientes().addActionListener(this);
		tela.getInicio().getProdutos().addActionListener(this);
		tela.getInicio().getBuscarOS().addActionListener(this);
		tela.getInicio().getFuncionarios().addActionListener(this);
		tela.getInicio().getLogout().addActionListener(this);
		tela.getInicio().getVendas().addActionListener(this);

		tela.getCadastroProduto().getCancelar().addActionListener(this);
		tela.getCadastroProduto().getSalvar().addActionListener(this);
		tela.getCadastroProduto().getAdicionarLote().addActionListener(this);
		tela.getCadastroProduto().getRemoverLote().addActionListener(this);
		tela.getCadastroProduto().getEditarLote().addActionListener(this);
		tela.getCadastroProduto().getBntAtivo().addActionListener(this);
		
		tela.getCadastroProduto().getLote().getSalvar().addActionListener(this);
		tela.getCadastroProduto().getLote().getCancelar().addActionListener(this);
		tela.getCadastroProduto().getLote().getPerecivelC().addActionListener(this);
		tela.getCadastroProduto().getLote().getDatFabF().addFocusListener(this);
		tela.getCadastroProduto().getLote().getMargemLucroF().addKeyListener(this);
		tela.getCadastroProduto().getLote().getDatValF().addFocusListener(this);

		tela.getCadastroFuncionarios().getSalvar().addActionListener(this);
		tela.getCadastroFuncionarios().getCancelar().addActionListener(this);
		
		tela.getFuncionarios().getcFuncionario().addActionListener(this);
		tela.getFuncionarios().getVoltar().addActionListener(this);
		tela.getFuncionarios().getEditar().addActionListener(this);
		tela.getFuncionarios().getExcluir().addActionListener(this);


		tela.getVender().getCancelar().addActionListener(this);
		tela.getVender().getBuscarProduto().addActionListener(this);
		tela.getVender().getExcluirItem().addActionListener(this);
		tela.getVender().getFinalizar().addActionListener(this);
		tela.getVender().getQuantF().addKeyListener(this);
		tela.getVender().getCodigoF().addKeyListener(this);
		tela.getVender().getCodigoF().addFocusListener(this);

		tela.getCadastroCliente().getAdicionarEndereo().addActionListener(this);
		tela.getCadastroCliente().getEditarEndereco().addActionListener(this);
		tela.getCadastroCliente().getRemoverEndereco().addActionListener(this);
		tela.getCadastroCliente().getCancelar().addActionListener(this);
		tela.getCadastroCliente().getSalvar().addActionListener(this);

		tela.getCadastrarOrdemServico().getCancelar().addActionListener(this);
		tela.getCadastrarOrdemServico().getSalvar().addActionListener(this);
		tela.getCadastrarOrdemServico().getPesquisar().addKeyListener(this);
		tela.getCadastrarOrdemServico().getPesquisar().addFocusListener(this);
		tela.getCadastrarOrdemServico().getClienteF().addItemListener(this);
		
		tela.getProdutos().getCancelar().addActionListener(this);
		tela.getProdutos().getExcluir().addActionListener(this);
		tela.getProdutos().getCadastrar().addActionListener(this);
		tela.getProdutos().getEditar().addActionListener(this);

		tela.getClientes().getCadastrar().addActionListener(this);
		tela.getClientes().getVoltar().addActionListener(this);
		tela.getClientes().getEditar().addActionListener(this);
		tela.getClientes().getExcluir().addActionListener(this);
		tela.getClientes().getAlterarDbito().addActionListener(this);
		
		tela.getOs().getVoltar().addActionListener(this);
		tela.getOs().getEditar().addActionListener(this);
		tela.getOs().getExcluir().addActionListener(this);
		tela.getOs().getFinalizar().addActionListener(this);
		tela.getOs().getVerOs().addActionListener(this);
		
		tela.getVendas().getExcluir().addActionListener(this);
		tela.getVendas().getVoltar().addActionListener(this);
		tela.getVendas().getCadastrar().addActionListener(this);
		tela.getVendas().getEditar().addActionListener(this);
		
		tela.getOs().getTxtPesquisar().addKeyListener(this);
		tela.getFuncionarios().getTxtPesquisar().addKeyListener(this);
		tela.getClientes().getTxtPesquisar().addKeyListener(this);
		tela.getProdutos().getTxtPesquisar().addKeyListener(this);
		tela.getVendas().getTxtPesquisar().addKeyListener(this);

		pesq.getBuscaProdutoF().addKeyListener(this);
		pesq.getAdicionar().addActionListener(this);

		concluirVenda.getValorPagoF().addKeyListener(this);
		concluirVenda.getFinalizar().addActionListener(this);
		concluirVenda.getVoltar().addActionListener(this);
		concluirVenda.getPesquisar().addKeyListener(this);
		concluirVenda.getPesquisar().addFocusListener(this);

		cadastro_endereco.getSalvar().addActionListener(this);
		cadastro_endereco.getCancelar().addActionListener(this);
		
		debito.getFinalizar().addActionListener(this);
		debito.getVoltar().addActionListener(this);
		debito.getDebito().addKeyListener(this);
		debito.getValorPagoF().addKeyListener(this);
		
		finalizarOS.getConcluir().addActionListener(this);
		finalizarOS.getHoraInicio().addFocusListener(this);
		
		detalheOS.getFechar().addActionListener(this);
		produtoVenda.getFechar().addActionListener(this);
		




	}
	public void actionPerformed(ActionEvent e) {

//Ordem de Serviço
		{
			
			if(e.getSource().equals(tela.getOs().getExcluir())) {
				try {
					fachada.excluirOS(fachada.getOS("").get(tela.getOs().getIndexInTable()).getId());
					tela.getOs().getModelo().atualizarTable(fachada.getOS(""));
				} catch (DaoException e1) {}catch (Exception e31) {Mensagens.erro("Selecione Um Item Primeiro!");}}
			if(e.getSource().equals(tela.getOs().getFinalizar())) {
				finalizarOS.limparCampos();
				try {
					ordem = fachada.getOS("").get(tela.getOs().getIndexInTable());
					finalizarOS.setTitle(ordem.getDescricao());
					Util.setFinalizarOS(finalizarOS,ordem);} catch (DaoException e1) {}catch (Exception e31) {Mensagens.erro("Selecione Um Item Primeiro!");}
				finalizarOS.setVisible(true);
			}
			if(e.getSource().equals(tela.getOs().getVerOs())) {
				try {
					ordem = fachada.getOS("").get(tela.getOs().getIndexInTable());
					Util.setOSDetalheOS(detalheOS,ordem);
					detalheOS.setVisible(true);
				} catch (DaoException e1) {}catch (Exception e31) {Mensagens.erro("Selecione Um Item Primeiro!");}
				
			}
			if(e.getSource().equals(finalizarOS.getConcluir())) {
				
				try {
					ordem = fachada.getOS("").get(tela.getOs().getIndexInTable());
					Util.getFinalizarOS(finalizarOS,ordem);
					fachada.finalizarOS(ordem);
					tela.getOs().getModelo().atualizarTable(fachada.getOS(""));} catch (DaoException e1) {}				
				finalizarOS.setVisible(false);
				finalizarOS.limparCampos();
			}
			if(e.getSource().equals(detalheOS.getFechar()))
				detalheOS.setVisible(false);
			if(e.getSource().equals(tela.getOs().getEditar())) {
				try {
					ordem = fachada.getOS("").get(tela.getOs().getIndexInTable());
					tela.getCadastrarOrdemServico().atualizarBoxFuncionario(fachada.getFuncionarios(""));
					Util.setOSTela(tela.getCadastrarOrdemServico(), ordem);
					clientes = fachada.getClientes(tela.getCadastrarOrdemServico().getPesquisar().getText());
					tela.getCadastrarOrdemServico().atualizarBoxClientes(clientes);
					tela.getCadastrarOrdemServico().atualizarBoxEnderecos(clientes.get(tela.getCadastrarOrdemServico().getClienteF().getSelectedIndex()).getEnderecos());
					tela.getCadastrarOrdemServico().getEndClienteF().setSelectedIndex(ordem.getEnd());
					
					ordemEdit = true;					
					tela.getOs().setVisible(false);
					tela.getCadastrarOrdemServico().setVisible(true);
				} catch (DaoException e1) {}catch (Exception e31) {Mensagens.erro("Selecione Um Item Primeiro!");}
			}
		}
		
		
		
//Cadastrar Ordem de Serviço
		{
			if(e.getSource().equals(tela.getCadastrarOrdemServico().getSalvar())) {
				try {
					if(!ordemEdit)
						fachada.salvarOS(Util.getOSTela(tela.getCadastrarOrdemServico()));
					else
						fachada.editarOS(Util.getOSTela(tela.getCadastrarOrdemServico(),ordem));
					tela.getOs().getModelo().atualizarTable(fachada.getOS(""));					
				} catch (DaoException e1) {}
				tela.getCadastrarOrdemServico().setVisible(false);
				if(!ordemEdit)
					tela.getInicio().setVisible(true);
				else
					tela.getOs().setVisible(true);
				ordemEdit =false;
			}			
			if(e.getSource().equals(tela.getCadastrarOrdemServico().getSalvar()) || e.getSource().equals(tela.getCadastrarOrdemServico().getCancelar())) {
				tela.getCadastrarOrdemServico().limparCampos();
				
			}
		
		}
		
		
		
//Cadastrar Endereço
		{
			if(e.getSource().equals(cadastro_endereco.getSalvar())) {
				if(!enderecoEdit)
					enderecos.add(Util.getEnderecoTela(cadastro_endereco));
				else
					enderecos.set(tela.getCadastroCliente().getIndexTable(), Util.getEnderecoTela(cadastro_endereco));
				cadastro_endereco.setVisible(false);
				cadastro_endereco.limparCampos();
				tela.getCadastroCliente().getModelo().atualizarTable(enderecos);
				enderecoEdit = false;
			}
			if(e.getSource().equals(cadastro_endereco.getCancelar()))
				cadastro_endereco.setVisible(false); cadastro_endereco.limparCampos();
		}
		

//Cliente
		{
			if(e.getSource().equals(tela.getClientes().getAlterarDbito())){
				try {
					c = fachada.getCliente(tela.getClientes().getCpfInTable());
					debito.getDebito().setText(c.getDebito()+"");
					debito.setVisible(true);
				} catch (DaoException e1) {}
			}

			if(e.getSource().equals(debito.getFinalizar())) {
				c.setDebito(Float.parseFloat(debito.getNdebito().getText()));
				try {fachada.debitoCliente(c);
				tela.getClientes().getModelo().atualizarTable(fachada.getClientes(""));
				} catch (DaoException e1) {}
				debito.setVisible(false);
				debito.limparCampos();
			}
			if(e.getSource().equals(debito.getVoltar())){
				debito.setVisible(false);
				debito.limparCampos();
			}
			if(e.getSource().equals(tela.getClientes().getCadastrar())) {
				clienteEdit = false;
				tela.getClientes().setVisible(false);
				tela.getCadastroCliente().setVisible(true);
				enderecos.clear();
				tela.getCadastroCliente().getModelo().atualizarTable(enderecos);
			}
			if(e.getSource().equals(tela.getClientes().getEditar())) {
				try {
					Cliente c = fachada.getClientes(tela.getClientes().getCpfInTable()).get(0);
					Util.setClienteTela(tela.getCadastroCliente(), c);
					enderecos = c.getEnderecos();
					cpf = c.getCpf();
					clienteEdit = true;
					tela.getCadastroCliente().getModelo().atualizarTable(enderecos);
					tela.getClientes().setVisible(false);
					tela.getCadastroCliente().setVisible(true);
				} catch (DaoException e1) {}

			}
			if(e.getSource().equals(tela.getClientes().getExcluir())) {
				try {fachada.excluirCliente(tela.getClientes().getCpfInTable());
				tela.getClientes().getModelo().atualizarTable(fachada.getClientes(""));
				} catch (DaoException e1) {}
			}
		}



//Cadastrar Cliente
		{
			if(e.getSource() == tela.getCadastroCliente().getSalvar()) {
				if(tela.getCadastroCliente().verificarCampos()) {					
					try {
						if(clienteEdit) 
							fachada.editarCliente(Util.getClienteTela(tela.getCadastroCliente(), enderecos),cpf);
						else 
							fachada.salvarCliente(Util.getClienteTela(tela.getCadastroCliente(), enderecos));
						tela.getClientes().getModelo().atualizarTable(fachada.getClientes(""));
						tela.getCadastroCliente().setVisible(false);
						tela.getClientes().setVisible(true);
						tela.getCadastroCliente().limparCampos();
						clienteEdit = false;
					} catch (DaoException e1) {	}
				}else
					Mensagens.erro("Preencha Todos Os campos!");
			}
			if(e.getSource().equals(tela.getCadastroCliente().getAdicionarEndereo())) {
				cadastro_endereco.limparCampos();
				enderecoEdit = false;
				cadastro_endereco.setVisible(true);
			}
			if(e.getSource().equals(tela.getCadastroCliente().getEditarEndereco())) {
				try {
					Util.setEnderecoTela(cadastro_endereco,enderecos.get(tela.getCadastroCliente().getIndexTable()));
					cadastro_endereco.setVisible(true);
					enderecoEdit = true;
				}catch (Exception e33) {
					Mensagens.erro("Selecione Um Endereço Primeiro!");
				}
			}
			if(e.getSource().equals(tela.getCadastroCliente().getRemoverEndereco())) {
				try {
					enderecos.remove(tela.getCadastroCliente().getIndexTable());
					tela.getCadastroCliente().getModelo().atualizarTable(enderecos);
				}catch (Exception e33) {
					Mensagens.erro("Selecione Um Endereço Primeiro!");
				}
			}
			if(e.getSource() == tela.getCadastroCliente().getCancelar()) {
				tela.getCadastroCliente().setVisible(false);
				tela.getClientes().setVisible(true);
				tela.getCadastroCliente().limparCampos();				
			}
		}



//Funcionario
		{
			if(e.getSource() == tela.getFuncionarios().getcFuncionario()){			
				tela.getFuncionarios().setVisible(false);
				tela.getCadastroFuncionarios().getCpfF().setEnabled(true);
				tela.getCadastroFuncionarios().setVisible(true);
			}
			if(e.getSource().equals(tela.getFuncionarios().getExcluir())) {
				
					if(tela.getFuncionarios().getCpfInTable().equals( Util.funcionarioLogado.getCpf()))
						Mensagens.erro("Não é Possivel Excluir Funcionario Em Uso, Faça Logout Primeiro!");
					else {
						try {
						fachada.excluirFuncionario(tela.getFuncionarios().getCpfInTable());
						tela.getFuncionarios().getModel().atualizarTable(fachada.getFuncionarios(""));		
						} catch (DaoException e1) {}
						catch (Exception e2) {
							Mensagens.erro("Selecione um Funcionário Primeiro!");}
					}
			}
			if(e.getSource().equals(tela.getFuncionarios().getEditar())) {
				try {
					cpf = tela.getFuncionarios().getCpfInTable();
					Util.setFuncionarioTela(tela.getCadastroFuncionarios(), fachada.getFuncionario(cpf));
					funcionarioEdit = true;
					tela.getCadastroFuncionarios().getCpfF().setEnabled(false);
					tela.getFuncionarios().setVisible(false);
					tela.getCadastroFuncionarios().setVisible(true);
					tela.getFuncionarios().getModel().atualizarTable(fachada.getFuncionarios(""));
				} catch (DaoException e1) {}
				catch (Exception e2) {
					Mensagens.erro("Selecione um Funcionário Primeiro!");}
			}
		}

//Cadastrar Funcionario
		{
			if(e.getSource().equals(tela.getCadastroFuncionarios().getSalvar())) {
				try {
					if(!funcionarioEdit) 
						fachada.salvarFuncionario(Util.getFuncionarioTela(tela.getCadastroFuncionarios()));
					else { 
						fachada.editarFuncionario(Util.getFuncionarioTela(tela.getCadastroFuncionarios()),cpf);
						
					}
					funcionarioEdit = false;
					tela.getFuncionarios().getModel().atualizarTable(fachada.getFuncionarios(""));
				} catch (DaoException e1) {}
			}
			if(e.getSource().equals(tela.getCadastroFuncionarios().getCancelar()) || e.getSource().equals(tela.getCadastroFuncionarios().getSalvar())){
				tela.getCadastroFuncionarios().setVisible(false);
				tela.getCadastroFuncionarios().limparCampos();
				tela.getFuncionarios().setVisible(true);
			}
		}


//Produto
		{
			if(e.getSource() == tela.getProdutos().getExcluir()) {
				if(Mensagens.pergunta("Deseja Excluir?", "essa ação apagará todos os lotes desse Produto\nobs: Essa ação só pode ser feita caso não haja nenhuma venda realizada desse produto"))
				try {fachada.excluirProduto(tela.getProdutos().getCodigoInTable());
				tela.getProdutos().getModelo().atualizarTable(fachada.getProduto(""));	}catch (DaoException ew) {}
			}
			if(e.getSource() == tela.getProdutos().getCadastrar()){
				tela.getCadastroProduto().limparCampos();
				produto = new Produto();	
				produtoEdit = false;
				tela.getCadastroProduto().getModelo().atualizarTable(produto.getLotes());
				tela.getProdutos().setVisible(false);
				tela.getCadastroProduto().setVisible(true);
			}
			if(e.getSource() == tela.getProdutos().getEditar()) {
				try {
					p = fachada.getProduto(tela.getProdutos().getCodigoInTable()).get(0);
					produto = p;
					tela.getCadastroProduto().getModelo().atualizarTable(produto.getLotes());
					Util.setProdutoTela(tela.getCadastroProduto(), p);				
					produtoEdit= true;
					tela.getCadastroProduto().setVisible(true);
					tela.getProdutos().setVisible(false);} catch (DaoException e1) {}
			}
					}
		

//Cadastrar Produto
		{
			if(e.getSource() == tela.getCadastroProduto().getLote().getPerecivelC())
				tela.getCadastroProduto().getLote().getDatValF().setEnabled(!tela.getCadastroProduto().getLote().getPerecivelC().isSelected());
			if(e.getSource() == tela.getCadastroProduto().getCancelar()) {
				tela.getCadastroProduto().setVisible(false);
				tela.getProdutos().setVisible(true);
			}
			if(e.getSource().equals(tela.getCadastroProduto().getAdicionarLote())) {
				tela.getCadastroProduto().getLote().getCodLote().setEnabled(true);
				tela.getCadastroProduto().getLote().limparCampos();
				loteEdit=false;
				tela.getCadastroProduto().getLote().setVisible(true);				
			}
			if(tela.getCadastroProduto().getBntAtivo().equals(e.getSource())) {
				try {
				produto.setLote_ativo(tela.getCadastroProduto().codigoInTable());
				tela.getCadastroProduto().getLoteAtivo().setText("Lote Ativo: Nº"+produto.getLote_ativo());}catch (Exception e54) {
					e54.printStackTrace();
					Mensagens.erro("Selecione Um lote para defini-lo como ativo!");
				}
				
				//tela.getCadastroProduto().getLoteAtivo().repaint();
			}
			if(e.getSource().equals(tela.getCadastroProduto().getRemoverLote())){
				if(produto.getLotes().get(tela.getCadastroProduto().indexInTable()).getId().equals(produto.getLote_ativo()))
					Mensagens.erro("Não é Possivel excluir um lote ativo!");
				else {
					produto.getLotes().remove(tela.getCadastroProduto().indexInTable());
					tela.getCadastroProduto().getModelo().atualizarTable(produto.getLotes());
				}
			}
			if(e.getSource().equals(tela.getCadastroProduto().getEditarLote())) {
				index = tela.getCadastroProduto().indexInTable();
				Util.setLoteTela(tela.getCadastroProduto().getLote(),produto.getLotes().get(index));
				loteEdit=true;
				tela.getCadastroProduto().getModelo().atualizarTable(produto.getLotes());
				tela.getCadastroProduto().getLote().setVisible(true);
			}
			//Lote
			if(tela.getCadastroProduto().getLote().getSalvar().equals(e.getSource())) {
				if(!loteEdit)
					produto.getLotes().add(Util.getLoteTela(tela.getCadastroProduto().getLote()));
				else
					produto.getLotes().set(index, Util.getLoteTela(tela.getCadastroProduto().getLote()));
				tela.getCadastroProduto().getLote().setVisible(false);
				if(produto.getLote_ativo()==null || produto.getLote_ativo().isEmpty()) {
					produto.setLote_ativo(tela.getCadastroProduto().getLote().getCodLote().getText());
					tela.getCadastroProduto().getLoteAtivo().setText("Lote Ativo: Nº"+produto.getLote_ativo());
				}
				tela.getCadastroProduto().getModelo().atualizarTable(produto.getLotes());
			}
			if(tela.getCadastroProduto().getLote().getCancelar().equals(e.getSource())) {
				tela.getCadastroProduto().getLote().setVisible(false);
				loteEdit=false;
			}


			if(e.getSource() == tela.getCadastroProduto().getSalvar()){
				if(produtoEdit) {					
					try {
						tela.getCadastroProduto().setVisible(false);
						tela.getProdutos().setVisible(true);
						fachada.editarProduto(Util.getProdutoTela(tela.getCadastroProduto(),produto));
						tela.getProdutos().getModelo().atualizarTable(fachada.getProduto(""));} catch (DaoException e1) {}
					tela.getCadastroProduto().getCodigoF().setEditable(true);
					produtoEdit = false;
					
					tela.getCadastroProduto().limparCampos();
//					produto = new Produto();	
//					tela.getCadastroProduto().getModelo().atualizarTable(produto.getLotes());


				}else if(tela.getCadastroProduto().verificarCampos()){
					try{ 
						tela.getCadastroProduto().setVisible(false);
						tela.getProdutos().setVisible(true);
						fachada.salvarProduto(Util.getProdutoTela(tela.getCadastroProduto(),produto));
						tela.getProdutos().getModelo().atualizarTable(fachada.getProduto(""));
						tela.getCadastroProduto().limparCampos();
					}catch (NumberFormatException ex) {Mensagens.erro("Os campos de preço, Quantidade Só Podem Conter Numeros");
					}catch (DaoException ex) {}
				}else
					Mensagens.erro("Preencha Todos os Campos");
				
				try {tela.getProdutos().getModelo().atualizarTable(fachada.getProduto(""));} catch (DaoException e5) {}
			}

		}


//Vendas
		{
			if(e.getSource().equals(tela.getVendas().getExcluir())) {
				Mensagens.informacao("Note que Essa função não vai fazer qualquer alteração no débito do cliente,\n ou seja caso necessário deve ser feito manualmente :( ");
				try {
					fachada.excluirVenda(fachada.getVendas("").get(tela.getVendas().getIndexInTable()).getId_venda());
					tela.getVendas().getModelo().atualizarTable(fachada.getVendas(""));
				} catch (DaoException e1) {}
			}
			if(e.getSource().equals(tela.getVendas().getCadastrar())) {
				try {
					produtoVenda.getModelo().atualizarTable(fachada.getVendas("").get(tela.getVendas().getIndexInTable()).getProdutos());
					produtoVenda.setVisible(true);
				} catch (DaoException e1) {}
			}
			if(e.getSource().equals(produtoVenda.getFechar()))
				produtoVenda.setVisible(false);
			if(e.getSource().equals(tela.getVendas().getEditar())){
				Mensagens.informacao("Caso seja necessário alterações no débito do cliente deve ser feito manualmente :( ");
				try {
					venda = fachada.getVendas("").get(tela.getVendas().getIndexInTable());
					Util.setVendaTela(tela.getVender(),venda);
					concluirVenda.atualizarBox(fachada.getClientes(""));
					if(venda.getCliente()!=null)
						concluirVenda.getComboBox().setSelectedItem(venda.getCliente().getNome());
					vendaEdit = true;
					tela.getVendas().setVisible(false);
					tela.getVender().setVisible(true);
				} catch (DaoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

//Vender
		{
			if(e.getSource() == tela.getVender().getBuscarProduto()) {
				try {pesq.getModelo().atualizarTable(fachada.getProdutoVenda(pesq.getBuscaProdutoF().getText()));} catch (DaoException e1) {}
				pesq.setVisible(true);
			
			}
			if(concluirVenda.getVoltar().equals(e.getSource())) {
				concluirVenda.setVisible(false);
			}
			if(e.getSource() == pesq.getAdicionar()) {
				pesq.setVisible(false);
				tela.getVender().getCodigoF().setText(pesq.getCodigoInTable());
				tela.getVender().getCodigoF().requestFocusInWindow();
				try {p = fachada.getProduto(tela.getVender().getCodigoF().getText()).get(0);
				tela.getVender().setValorUnitF(p.getLotes().get(0).getPrecoV());
				tela.getVender().setDescricaoProdL(p.getDescricao());
				tela.getVender().setSubtotalF(p.getLotes().get(0).getPrecoV());
				} catch (Exception ee) {Mensagens.erro("Código de Produto Inválido");}
				tela.getVender().getQuantF().requestFocusInWindow();
			}
			if(e.getSource() == tela.getVender().getFinalizar()) {
				if(!venda.getProdutos().isEmpty()) {
					try {
						if(!vendaEdit) {
							concluirVenda.atualizarBox(fachada.getClientes(""));
							concluirVenda.empyBox();
							}
					} catch (DaoException e1) {}
					
					concluirVenda.getTotalF().setText(venda.getValor()+"");
					troco = Float.parseFloat(concluirVenda.getValorPagoF().getText().isEmpty()?"0":concluirVenda.getValorPagoF().getText())-(Float.parseFloat(concluirVenda.getTotalF().getText()));
					concluirVenda.getTrocoF().setText(troco+"");
					concluirVenda.getValorPagoF().setText("");
					concluirVenda.setVisible(true);
					concluirVenda.getValorPagoF().requestFocus();
				}else
					Mensagens.erro("Não é possivel Finalizar Venda", "Insira algum produto antes de finalizar a venda\n obs.: Para adicionar um produto basta precionar 'ENTER' após inserir o código");
			}
			if(e.getSource() == concluirVenda.getFinalizar()) {
				try {
					// {
						boolean temEstoque =true;
						if(!vendaEdit){
							for(Produto p: venda.getProdutos()) 
								if(p.getLotes().get(0).getQuantidade()>fachada.getProduto(p.getCodigo()).get(0).getLotes().get(0).getQuantidade()) 
									temEstoque = false;
						}
//						else
//							for(Produto p: venda.getProdutos()) 
//								if(p.getQuantidade()>fachada.getProduto(p.getCodigo()).get(0).getQuantidade()+ fachada.getVenda(p.getId()+"").getProdutos()) 
//									temEstoque = false;

						if(temEstoque ){//|| Mensagens.pergunta("Estoque Baixo", "O produto "+p.getDescricao()+" Não Tem Estoque Suficiente Para Finaizar Venda,\n Deseja Continuar?")){
							venda.setFuncionario(Util.funcionarioLogado);
							if(concluirVenda.getInBox()>=0) {
								concluirVenda.getPesquisar().setText(concluirVenda.getPesquisar().getText().equals("Pesquisar...")?"":concluirVenda.getPesquisar().getText());
								venda.setCliente(fachada.getClientes(concluirVenda.getPesquisar().getText()).get(concluirVenda.getInBox()));
							}
							if(troco>=0||venda.getCliente()!=null) {
								if(troco>=0) {
									if(vendaEdit)
										fachada.editarVenda(venda);
									else
										fachada.finalizarVenda(venda);
									vendaEdit =false;
									venda = new Venda();
									tela.getVender().getModelo().limparTable();
									tela.getVender().limparCampos();
									concluirVenda.setVisible(false);
								}
								else if(Mensagens.pergunta("Debitar?", "Será Adicionado R$ "+troco*-1+" ao debito do Cliente "+venda.getCliente().getNome()+"\nDeseja Continuar? ")) {
									troco = troco*-1;
									venda.getCliente().setDebito(venda.getCliente().getDebito() + troco);
									if(vendaEdit)
										fachada.editarVenda(venda);
									else
										fachada.finalizarVenda(venda);	
									vendaEdit =false;
									venda = new Venda();
									tela.getVender().getModelo().limparTable();
									tela.getVender().limparCampos();
									concluirVenda.setVisible(false);
								}

							}else
								Mensagens.erro("Valor Pago Insuficiente", "Valor Pago não Cobre o custo da Venda.\nPor Favor Selecione um Cliente ou Insirar Outro Valor.");
						}else
							Mensagens.erro("Erro ao Finalizar Venda", "O produto "+p.getDescricao()+" não tem estoque suficiente para finaizar venda");
					//}else {
//						fachada.editarVenda(venda);
//						venda = new Venda();
//						tela.getVender().getModelo().limparTable();
//						tela.getVender().limparCampos();
//						concluirVenda.setVisible(false);
//						vendaEdit =false;
				//	}
						
				} catch (DaoException e1) {}
				//}else
				//Mensagens.erro("Valor Pago não Cobre o custo da Venda");
			}
			if(e.getSource() == tela.getVender().getExcluirItem()) {
				try {

					venda.getProdutos().remove(tela.getVender().getItemInTable());
					tela.getVender().getModelo().limparTable();
					tela.getVender().setTotalF(venda.atualizarTotal());
					for(Produto p: venda.getProdutos())
						tela.getVender().getModelo().addInTable(p);
				}catch (Exception e14) {}
			}
			

		}



//Botões Voltar/Cancelar
		{
			if( e.getSource().equals(tela.getClientes().getVoltar())|| e.getSource() == tela.getFuncionarios().getVoltar() || 
					e.getSource() == tela.getProdutos().getCancelar()|| e.getSource() == tela.getCadastrarOrdemServico().getCancelar()
					|| e.getSource() == tela.getVender().getCancelar()
					|| tela.getOs().getVoltar().equals(e.getSource()) || tela.getVendas().getVoltar().equals(e.getSource()) ){
				tela.getInicio().setVisible(true);
				tela.getCadastroCliente().setVisible(false);
				//tela.getVender().setVisible(false);
				tela.getCadastrarOrdemServico().setVisible(false);
				tela.getProdutos().setVisible(false);
				tela.getFuncionarios().setVisible(false);
				tela.getClientes().setVisible(false);
				tela.getOs().setVisible(false);
				tela.getVendas().setVisible(false);
				//venda = new Venda();
				produtoEdit = funcionarioEdit = clienteEdit = ordemEdit = vendaEdit = false;
			}

		}	


//Botões Inicio
		{
			if(e.getSource() == tela.getInicio().getFuncionarios()) {
				tela.getInicio().setVisible(false);
				try {tela.getFuncionarios().getModel().atualizarTable(fachada.getFuncionarios(""));} catch (DaoException e1) {}
				tela.getFuncionarios().setVisible(true);
			}
			if(e.getSource().equals(tela.getInicio().getVendas())) {
				tela.getInicio().setVisible(false);
				try {tela.getVendas().getModelo().atualizarTable(fachada.getVendas(""));} catch (DaoException e1) {}
				tela.getVendas().setVisible(true);
			}
			if(e.getSource().equals(tela.getInicio().getBuscarOS())) {
				tela.getInicio().setVisible(false);
				try {tela.getOs().getModelo().atualizarTable(fachada.getOS(""));} catch (DaoException e1) {}
				tela.getOs().setVisible(true);
			}
			if(e.getSource().equals(tela.getInicio().getLogout())) {
				tela.setVisible(false);
				Util.controladorLogin.login();
			}
			if(e.getSource() == tela.getInicio().getNovoServico()){
				tela.getInicio().setVisible(false);
				ordemEdit = false;
				try {
					clientes = fachada.getClientes("");
					tela.getCadastrarOrdemServico().atualizarBoxClientes(clientes);
					tela.getCadastrarOrdemServico().atualizarBoxEnderecos(clientes.get(0).getEnderecos());
					tela.getCadastrarOrdemServico().atualizarBoxFuncionario(fachada.getFuncionarios(""));
				} catch (DaoException e1) {}
				tela.getCadastrarOrdemServico().setVisible(true);
			}				
			if(e.getSource() == tela.getInicio().getClientes()){
				tela.getInicio().setVisible(false);
				try {tela.getClientes().getModelo().atualizarTable(fachada.getClientes(""));} catch (DaoException e1) {}
				tela.getClientes().setVisible(true);
			}
			if(e.getSource() == tela.getInicio().getCancelar()){
				venda = new Venda();
				vendaEdit =false;
				tela.getVender().getModelo().limparTable();
				tela.getVender().limparCampos();
			}
			
			if(e.getSource() == tela.getInicio().getProdutos()){
				tela.getInicio().setVisible(false);
				try {tela.getProdutos().getModelo().atualizarTable(fachada.getProduto(""));} catch (DaoException e9) {}
				tela.getProdutos().setVisible(true);
			}
		}

	}
	@Override
	public void focusGained(FocusEvent f) {
		if(f.getSource().equals(finalizarOS.getHoraInicio()))
			finalizarOS.getHoraInicio().setText("");
		if(f.getSource().equals(concluirVenda.getPesquisar()))
			concluirVenda.getPesquisar().setText("");
		if(f.getSource().equals(tela.getCadastrarOrdemServico().getPesquisar()))
			tela.getCadastrarOrdemServico().getPesquisar().setText("");
//		if(f.getSource() == tela.getCadastroProduto().getDatFabF()) 
//			tela.getCadastroProduto().getDatFabF().setText("");
//		if(f.getSource() == tela.getCadastroProduto().getDatValF()) 
//			tela.getCadastroProduto().getDatValF().setText("");			


	}
	@Override
	public void focusLost(FocusEvent f) {
//		if(f.getSource() == tela.getCadastroProduto().getDatFabF() && tela.getCadastroProduto().getDatFabF().getText().isEmpty()) 
//			tela.getCadastroProduto().getDatFabF().setText("DD-MM-AAAA");
//		if(f.getSource() == tela.getCadastroProduto().getDatValF() && (tela.getCadastroProduto().getDatValF().getText().isEmpty() || tela.getCadastroProduto().getPerecivelC().isSelected() )) 
//			tela.getCadastroProduto().getDatValF().setText("DD-MM-AAAA");
		if(f.getSource() == tela.getVender().getCodigoF()) {
			try {p = fachada.getProduto(tela.getVender().getCodigoF().getText()).get(0);
			tela.getVender().setValorUnitF(p.getLotes().get(0).getPrecoV());
			tela.getVender().setDescricaoProdL(p.getDescricao());
			tela.getVender().setSubtotalF(p.getLotes().get(0).getPrecoV());
			} catch (Exception e) {Mensagens.erro("Código de Produto Inválido");}
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getSource().equals(tela.getProdutos().getTxtPesquisar()) && e.getKeyCode()!=KeyEvent.VK_ENTER)
			try {tela.getProdutos().getModelo().atualizarTable(fachada.getProduto(tela.getProdutos().getTxtPesquisar().getText()));} catch (DaoException e9) {}
		
		if(e.getSource().equals(tela.getVendas().getTxtPesquisar())&& e.getKeyCode()!=KeyEvent.VK_ENTER)
			try {tela.getVendas().getModelo().atualizarTable(fachada.getVendas(tela.getVendas().getTxtPesquisar().getText()));} catch (DaoException e9) {}
		
		if(e.getSource().equals(tela.getOs().getTxtPesquisar())&& e.getKeyCode()!=KeyEvent.VK_ENTER)
			try {tela.getOs().getModelo().atualizarTable(fachada.getOS(tela.getOs().getTxtPesquisar().getText()));} catch (DaoException e9) {}
			
		if(e.getSource().equals(tela.getClientes().getTxtPesquisar())&& e.getKeyCode()!=KeyEvent.VK_ENTER)
			try {tela.getClientes().getModelo().atualizarTable(fachada.getClientes(tela.getClientes().getTxtPesquisar().getText()));} catch (DaoException e9) {}
		
		if(e.getSource().equals(tela.getFuncionarios().getTxtPesquisar())&& e.getKeyCode()!=KeyEvent.VK_ENTER)
			try {tela.getFuncionarios().getModel().atualizarTable(fachada.getFuncionarios(tela.getFuncionarios().getTxtPesquisar().getText()));} catch (DaoException e9) {}
		
		
		if((e.getSource().equals(debito.getDebito()) || debito.getValorPagoF().equals(e.getSource())) && e.getKeyCode()!=KeyEvent.VK_ENTER) {
			try {
					Float deb = Float.parseFloat(debito.getDebito().getText().isEmpty()?"0":debito.getDebito().getText());
					Float pago = Float.parseFloat(debito.getValorPagoF().getText().isEmpty()?"0":debito.getValorPagoF().getText());
					if(pago>deb) {
						debito.getTrocoF().setText((-1*(deb-pago))+"");
						debito.getNdebito().setText(0+"");
					}else {
						debito.getNdebito().setText((deb-pago)+"");
						debito.getTrocoF().setText("0.0");
						}
				
			}catch (Exception e2w) {
				Mensagens.erro("Digite apenas Números!");
			}
		}
		
		
		if(e.getKeyCode()==KeyEvent.VK_ENTER && e.getSource().equals(concluirVenda.getValorPagoF()))
			concluirVenda.getFinalizar().doClick();
		if(e.getSource().equals(concluirVenda.getPesquisar())) {
			try {
				concluirVenda.atualizarBox(fachada.getClientes(concluirVenda.getPesquisar().getText()));
			} catch (DaoException e1) {}
		}
		if(e.getSource().equals(tela.getCadastrarOrdemServico().getPesquisar())) {
			try {
				clientes = fachada.getClientes(tela.getCadastrarOrdemServico().getPesquisar().getText());
				tela.getCadastrarOrdemServico().atualizarBoxClientes(clientes);
				tela.getCadastrarOrdemServico().atualizarBoxEnderecos(clientes.get(tela.getCadastrarOrdemServico().getClienteF().getSelectedIndex()).getEnderecos());
				
			} catch (Exception e1) {}
	}
		if(tela.getCadastroProduto().getLote().getMargemLucroF().equals(e.getSource()) && !tela.getCadastroProduto().getLote().getMargemLucroF().getText().isEmpty() ) {
			float margem = Float.parseFloat(tela.getCadastroProduto().getLote().getMargemLucroF().getText());
			float precoc = Float.parseFloat(tela.getCadastroProduto().getLote().getPrecoCompraF().getText());
			tela.getCadastroProduto().getLote().getPrecoVenda().setText(""+(precoc+precoc*(margem/100)));
		}
		if(e.getSource() == concluirVenda.getValorPagoF()) {
			troco = Float.parseFloat(concluirVenda.getValorPagoF().getText().isEmpty()?"0":concluirVenda.getValorPagoF().getText())-(Float.parseFloat(concluirVenda.getTotalF().getText()));
			concluirVenda.getTrocoF().setText(troco+"");}
		if(pesq.getBuscaProdutoF() == e.getSource())
			try {pesq.getModelo().atualizarTable(fachada.getProdutoVenda(pesq.getBuscaProdutoF().getText()));} catch (DaoException e1) {}

		Float qntd = tela.getVender().getQuantF().getText().isEmpty()?1:Float.parseFloat(tela.getVender().getQuantF().getText());
		if(e.getKeyCode() == KeyEvent.VK_ENTER && (e.getSource().equals(tela.getVender().getQuantF()) || e.getSource().equals(tela.getVender().getCodigoF()))) {			
			tela.getVender().getModelo().limparTable();
			try {
				venda.getProdutos().add(fachada.getProdutoVenda(tela.getVender().getCodigoF().getText()).get(0));
				venda.getProdutos().get(venda.getProdutos().size()-1).getLotes().get(0).setQuantidade(qntd);
				for(Produto p: venda.getProdutos()) 
					tela.getVender().getModelo().addInTable(p);
				tela.getVender().limparCampos();

			}catch (DaoException e5) {}}
		if(tela.getVender().isVisible()){
			tela.getVender().setSubtotalF(qntd*p.getLotes().get(0).getPrecoV());
			tela.getVender().setTotalF(venda.atualizarTotal());}
	}
	@Override
	public void keyTyped(KeyEvent e) {}
	public void setVisible(boolean b) {
		tela.setVisible(b);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(tela.getCadastrarOrdemServico().getClienteF().equals(e.getSource()) &&tela.getCadastrarOrdemServico().isVisible() ){
			try {
			tela.getCadastrarOrdemServico().atualizarBoxEnderecos(clientes.get(tela.getCadastrarOrdemServico().getClienteF().getSelectedIndex()).getEnderecos());
		}catch (Exception e33r) {} }
		
	}

}