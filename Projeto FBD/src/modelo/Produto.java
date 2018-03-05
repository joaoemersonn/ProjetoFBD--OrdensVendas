package modelo;

import java.util.ArrayList;

public class Produto {
	private int id ;
	private String descricao, codigo, marca,lote_ativo;	
	private ArrayList<Lote> lotes;


	public Produto() {
		lotes = new ArrayList<>();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public ArrayList<Lote> getLotes() {
		return lotes;
	}


	public void setLotes(ArrayList<Lote> lotes) {
		this.lotes = lotes;
	}


	public String getLote_ativo() {
		return lote_ativo;
	}


	public void setLote_ativo(String lote_ativo) {
		this.lote_ativo = lote_ativo;
	}
	
	
}
