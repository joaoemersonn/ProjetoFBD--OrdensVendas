package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import modelo.LoteTableModel;

@SuppressWarnings("serial")
public class P_Cadastro_Produto extends JPanel{
	private JLabel tituloL, descricaoL, codigoL,  marca,loteAtivo;
	private JTextField descricaoF, codigoF,  marcaF;	
	private JButton salvar, cancelar;
	private Font fonteL = new Font("Arial", Font.BOLD, 18);
	private Cadastro_Lote lote;
	
	private JButton  adicionarLote, removerLote,editarLote,bntAtivo;
	private JScrollPane scroll;
	private JTable table;
	private LoteTableModel modelo;

	public P_Cadastro_Produto(){
		setSize(Tela.LARGURA,Tela.ALTURA);
		setLayout(null);
		lote = new Cadastro_Lote();
		tituloL = new JLabel("Novo Cadastro de Produto");
		descricaoL = new JLabel("Descrição do Produto:");
		descricaoL.setFont(fonteL);
		codigoL = new JLabel("C\u00F3digo:");
		codigoL.setFont(fonteL);
		marca = new JLabel("Marca:");
		marca.setFont(fonteL);
		descricaoF = new JTextField();
		codigoF = new JTextField();
		marcaF = new JTextField();
		salvar = new JButton("Salvar");
		cancelar = new JButton("Voltar");	

		tituloL.setBounds(528, 20, 310, 30);
		tituloL.setFont(new Font("Batang", Font.BOLD, 24));

		descricaoL.setBounds(89, 73, 228, 40);
		descricaoF.setBounds(89, 124, 1035, 40);
		codigoL.setBounds(485, 206, 83, 40);
		codigoF.setBounds(565, 211, 228, 35);		
		marca.setBounds(89, 206, 71, 40);
		marcaF.setBounds(161, 206, 191, 40);

		salvar.setSize(100, 40);
		salvar.setLocation(1239, 674);
		cancelar.setSize(100, 40);
		cancelar.setLocation(1108, 674);
		
		
		
		
		table = new JTable();
		table.setModel(new LoteTableModel());
		modelo = (LoteTableModel) table.getModel();
		scroll = new JScrollPane(table);
		scroll.setLocation(99, 340);
		scroll.setSize(837, 284);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JLabel lblEndereos = new JLabel("Lotes: ");
		lblEndereos.setFont(fonteL);
		lblEndereos.setBounds(89, 290, 109, 39);
		add(lblEndereos);
		
		adicionarLote = new JButton("Adicionar Lote");
		adicionarLote.setBounds(960, 356, 180, 50);
		add(adicionarLote);
		
		removerLote = new JButton("Remover Lote");
		removerLote.setBounds(960, 417, 180, 50);
		add(removerLote);
		
		editarLote = new JButton("Editar Lote");
		editarLote.setBounds(960, 478, 180, 50);
		add(editarLote);


		add(tituloL);
		add(descricaoL);
		add(descricaoF);
		add(codigoL);
		add(codigoF);
		add(marca);
		add(marcaF);
		add(salvar);
		add(cancelar);
		add(scroll);
		
		loteAtivo = new JLabel("Lote Ativo: ");
		loteAtivo.setBounds(99, 660, 469, 39);
		add(loteAtivo);
		
		bntAtivo = new JButton("Definir Lote Ativo");
		bntAtivo.setBounds(960, 539, 180, 50);
		add(bntAtivo);


		setVisible(false);
	}
	public void limparCampos(){
		getDescricaoF().setText("");
		loteAtivo.setText("Lote Ativo:");
		lote.getPrecoCompraF().setText("");
		marcaF.setText("");
		lote.getQntdF().setText("");
		getCodigoF().setText("");
		lote.getMargemLucroF().setText("");
		lote.getPerecivelC().setSelected(false);
		lote.getDatValF().setEditable(true);
		getCodigoF().setEditable(true);

	}
	public int indexInTable() {
		return table.getSelectedRow();
	}
	public String codigoInTable() {
		return table.getValueAt(table.getSelectedRow(), 0)+"";
	}
	public boolean verificarCampos() {
		if(!getCodigoF().getText().isEmpty() 
//				&& (!getDatValF().getText().isEmpty() || getPerecivelC().isSelected())
//				&& !getDatFabF().getText().isEmpty()
//				&& !getQntdF().getText().isEmpty()
//				&& !getPrecoCompraF().getText().isEmpty()
				&& !getMarcaF().getText().isEmpty())
			return true;
		return false;
//
//		//		!tela.getCadastroProduto().getCodigoF().getText().isEmpty() 
//		//		&& (!tela.getCadastroProduto().getDatValF().getText().isEmpty() || tela.getCadastroProduto().getPerecivelC().isSelected())
//		//		&& !tela.getCadastroProduto().getDatFabF().getText().isEmpty()
//		//		&& !tela.getCadastroProduto().getQntdF().getText().isEmpty()
//		//		&& !tela.getCadastroProduto().getPrecoCompraF().getText().isEmpty()
//		//		&& !tela.getCadastroProduto().getMarcaF().getText().isEmpty()	
}

	public JTextField getDescricaoF() {
		return descricaoF;
	}
	public JTextField getCodigoF() {
		return codigoF;
	}
	public Cadastro_Lote getLote() {
		return lote;
	}
	public JTextField getMarcaF() {
		return marcaF;
	}
	public JButton getSalvar() {
		return salvar;
	}
	public JButton getCancelar() {
		return cancelar;
	}
	public LoteTableModel getModelo() {
		return modelo;
	}
	public JButton getAdicionarLote() {
		return adicionarLote;
	}
	public JButton getRemoverLote() {
		return removerLote;
	}
	public JButton getEditarLote() {
		return editarLote;
	}
	public JLabel getLoteAtivo() {
		return loteAtivo;
	}
	public JButton getBntAtivo() {
		return bntAtivo;
	}
}
