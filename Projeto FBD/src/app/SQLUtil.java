package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.SQLConnection;
import modelo.DaoException;



public class SQLUtil {
	
	static Connection conexao;
	
	private SQLUtil(){};

	//SQL INSER√á√ÉO
	public static final String INSERIR_PRODUTO = "insert into produto (descricao, codigo,marca) values ( ?, ?, ?) ";
	public static final String INSERIR_LOTE = "insert into lote (id_lote,quantidade, data_venc, data_fabric,preco_compra, margem_lucro, codigo_produto) values ( ?,?, ?, ?, ?, ?, ?) ";
	public static final String INSERIR_CLIENTE = "insert into cliente (nome, rg, cpf, telefone) values (?, ?, ?, ?) ";
	public static final String INSERIR_ENDERECO= "insert into endereco (rua, numero, bairro, cidade, cep, cpf_cliente) values (?, ?, ?, ?, ?, ?) ";
	public static final String INSERIR_CLIENTE_ENDERECO= "insert into cliente_endereco (id_cliente, id_endereco) values (?, ?) ";
	public static final String INSERIR_VENDA = "insert into venda ( cpf_cliente,cpf_funcionario,data_venda,hora,valor) values (?,?,?,?,?) ";
	public static final String INSERIR_VENDA_PRODUTO = "insert into venda_produto (id_venda,codigo_produto,quantidade_produto) values (?,?,?) ";
	public static final String INSERIR_OSERVICO = "insert into servico(data_abertura, hora_abertura,valor,descricao, obsevacoes,cpf_funcionario,cpf_cliente,cpf_tecnico, end_select) values (?,?,?,?,?,?,?,?,?) ";
	public static final String INSERIR_FUNCIONARIO = "insert into funcionario(nome, cpf,rg,login,senha) values (?,?,?,?,?)";
	
	//SQL EDI«√O
	public static final String ALTERAR_PRODUTO = "update produto set descricao = ?, marca = ? where codigo = ? ";
	public static final String ALTERAR_LOTE = "update lote set quantidade = ?,data_venc = ?, data_fabric = ?, preco_compra = ?, margem_lucro = ? where id_lote = ? ";
	public static final String VENDER_PRODUTO = "update lote set quantidade = (quantidade - ?) where id_lote = ? ";
	public static final String EDITAR_FUNCIONARIO = "update funcionario set nome = ?, cpf = ?, rg = ?, login = ?, senha = ? where cpf = ? ";
	public static final String EDITAR_CLIENTE = "update cliente set nome = ?, cpf=?, rg=?,telefone=? where cpf=? ";
	public static final String FINALIZAR_OS = "update servico set data_inicio = ?, data_fim=?, hora_inicio=?, hora_fim=?, valor =? where id_servico = ?";
	public static final String ALTERAR_OSERVICO = "update servico set valor = ?,descricao=?, obsevacoes=?,cpf_funcionario=?,cpf_cliente=?,cpf_tecnico=?, end_select=? where id_servico = ? ";
	public static final String EDITAR_VENDA = "update venda set data_venda = ?, hora = ?, valor=?, cpf_funcionario=?,cpf_cliente =? where id_venda = ?";
	public static final String CANCELAR_VENDA = "update lote set quantidade = (quantidade + ?) where id_lote = ? ";
	
		//SQL CONEXAO
    public static String URL_POSTGRES = "jdbc:postgresql://localhost:5432/projetofbd";
    public static String USUARIO_POSTGRES = "postgres";
    public static String SENHA_POSTGRES = "postgres";
    
    
    public static PreparedStatement prepareStatement(String SQL) throws Exception {
    	conexao =  SQLConnection.getConexao(SQLConnection.BD__POSTGRESS);    	
		return conexao.prepareStatement(SQL);
    }
    public static int getCurrentValorTabela(String nomeTabela) throws DaoException {
        int id = 0;
        try {
            Connection conexao = SQLConnection.getConexao(SQLConnection.BD__POSTGRESS);
            PreparedStatement statement = conexao.prepareStatement("select * from " + nomeTabela + " order by id_"+nomeTabela+" desc limit 1");
            ResultSet result = statement.executeQuery();
            result.next();
            id = result.getInt(1);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DaoException("erro ao consulta corrent valor da tabela no banco de dados");
        }
        return id;
    }
	
}
