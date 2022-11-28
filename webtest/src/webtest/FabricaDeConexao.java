package webtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {
	
	private static String usuario = "root";
	private static String senha = "neokoros";
	private static String textoDeConexao = "jdbc:mysql://127.0.0.1:3306/java";
	
	public static Connection obterConexao() throws SQLException {
		Connection conexao = DriverManager.getConnection(textoDeConexao, usuario, senha);
		return conexao;
	}
	

}

