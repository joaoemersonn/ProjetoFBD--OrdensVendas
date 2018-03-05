package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import app.SQLUtil;
import modelo.DaoException;


public class SQLConnection {

	public static String BD__POSTGRESS = "POSTGRES";

	private static Connection conexao = null;

	private SQLConnection() {

	}
	public static Connection getConexao(String bd) throws DaoException {
		try {
			if (conexao == null) {
				switch (bd) {
				case "POSTGRES":
					conexao = DriverManager.getConnection(
							SQLUtil.URL_POSTGRES,
							SQLUtil.USUARIO_POSTGRES,
							SQLUtil.SENHA_POSTGRES
							);
					break;
				default:
					break;
				}

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new DaoException("Problema na Conexão com o BD");
		}
		return conexao;
	}
}