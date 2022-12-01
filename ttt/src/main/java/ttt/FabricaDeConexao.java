package ttt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {
	private static String usuario = "root";
	private static String senha = "admin";
	private static String textoConexao = "jdbc:mysql://localhost:3306/teste";
	
	
	public static Connection obterConexao() {
		Connection conexao = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conexao = DriverManager.getConnection(textoConexao, usuario, senha);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conexao;
	}
}