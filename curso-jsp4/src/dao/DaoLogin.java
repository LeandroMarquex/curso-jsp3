/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sun.net.httpserver.Authenticator.Result;

import connection.SingleConnection;

/**
 * @author Leandro Marques
 *
 */
public class DaoLogin {

	private Connection connection;
	
	public DaoLogin() {
		// TODO Auto-generated constructor stub
		connection = SingleConnection.getConnection();
	}

	public boolean validarLogin(String login, String senha) throws Exception {
		 String sql = "select * from usuario where login = '" + login + "' and  senha = '" + senha +"'";
		 PreparedStatement statament = connection.prepareStatement(sql);
		 ResultSet resultSet = statament.executeQuery();
		 if (resultSet.next()) {
			return true; // possui usuario
		} else {
			return false; // não validou
		}
		 
		 
	}
}
