/**
 * 
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Leandro Marques
 *
 */
public class SingleConnection {

	private static String banco = "jdbc:postgresql://localhost:5432/curso-jsp4?autoReconnect=true";
	private static String password = "123";
	private static String user = "leandro";
	private static Connection connection = null;

	static {
		conectar();
	}

	private static void conectar() {
		try {
			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(banco, user, password);
				connection.setAutoCommit(false);
				System.out.println("SUCESSSOOO");
				System.out.println("SUCESSSOOO");
				System.out.println("SUCESSSOOO");

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle finally clause
			throw new RuntimeException(" Erro ao conectar com o banco de dados ");
			
		}

	}

	public static Connection getConnection() {
		return connection;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		conectar();
	}

}
