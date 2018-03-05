package modelo;
public class OServico {
	private String DataAbertura,HoraAbertura, DataInicio, DataFim, HoraInicio, HoraFim, observacoes,descricao;
	private Funcionario tecnico,funcionario;
	private Cliente cliente;
	private Float valor;
	private int id, end;
	public String getDataAbertura() {
		return DataAbertura;
	}
	public void setDataAbertura(String dataAbertura) {
		DataAbertura = dataAbertura;
	}
	public String getHoraAbertura() {
		return HoraAbertura;
	}
	public void setHoraAbertura(String horaAbertura) {
		HoraAbertura = horaAbertura;
	}
	public String getDataInicio() {
		return DataInicio;
	}
	public void setDataInicio(String dataInicio) {
		DataInicio = dataInicio;
	}
	public String getDataFim() {
		return DataFim;
	}
	public void setDataFim(String dataFim) {
		DataFim = dataFim;
	}
	public String getHoraInicio() {
		return HoraInicio;
	}
	public void setHoraInicio(String horaInicio) {
		HoraInicio = horaInicio;
	}
	public String getHoraFim() {
		return HoraFim;
	}
	public void setHoraFim(String horaFim) {
		HoraFim = horaFim;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Funcionario getTecnico() {
		return tecnico;
	}
	public void setTecnico(Funcionario tecnico) {
		this.tecnico = tecnico;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "OServico [DataAbertura=" + DataAbertura + ", HoraAbertura=" + HoraAbertura + ", DataInicio="
				+ DataInicio + ", DataFim=" + DataFim + ", HoraInicio=" + HoraInicio + ", HoraFim=" + HoraFim
				+ ", observacoes=" + observacoes + ", descricao=" + descricao + ", tecnico=" + tecnico
				+ ", funcionario=" + funcionario + ", cliente=" + cliente + ", valor=" + valor + ", id=" + id + ", end="
				+ end + "]";
	}
	
	
	  
}
