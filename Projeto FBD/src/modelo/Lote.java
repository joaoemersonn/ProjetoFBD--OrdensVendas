package modelo;

public class Lote {
	private String  dataVenc, dataFab, id;
	private float precoCompra, margemLucro, precoV, quantidade;	
	public void setPrecoCompra(float precoCompra) {
		this.precoCompra = precoCompra;
		precoV = precoCompra + precoCompra*(margemLucro/100);
	}
	public float getMargemLucro() {
		return margemLucro;
	}
	public void setMargemLucro(float precoVenda) {
		this.margemLucro = precoVenda;
		precoV = precoCompra + precoCompra*(margemLucro/100);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
	}
	public String getDataVenc() {
		return dataVenc;
	}
	public void setDataVenc(String dataVenc) {
		this.dataVenc = dataVenc;
	}
	public String getDataFab() {
		return dataFab;
	}
	public void setDataFab(String dataFab) {
		this.dataFab = dataFab;
	}
	public float getPrecoV() {
		return precoV;
	}
	public void setPrecoV(float precoV) {
		this.precoV = precoV;
	}
	public float getPrecoCompra() {
		return precoCompra;
	}

}
