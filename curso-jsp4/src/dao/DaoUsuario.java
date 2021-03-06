/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeanCursoJsp;
import connection.SingleConnection;

/**
 * @author Leandro Marques
 *
 */
public class DaoUsuario {

	private Connection connection;
	
	public DaoUsuario() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvarUsuario(BeanCursoJsp usuario) {
		
		try {
			

		String sql = "insert into usuario(login, senha) values (?, ?, ?)";
		PreparedStatement insert = connection.prepareStatement(sql);
		insert.setLong(1, usuario.getId());
		insert.setString(2, usuario.getLogin());
		insert.setString(3, usuario.getSenha());
		insert.execute();
		connection.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	public List<BeanCursoJsp> listar() throws Exception{
		List<BeanCursoJsp> listar = new ArrayList<BeanCursoJsp>();
		
		String sql = "select * from usuario";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			
			BeanCursoJsp beanCursoJsp = new BeanCursoJsp();
			beanCursoJsp.setLogin(resultSet.getString("login"));
			beanCursoJsp.setLogin(resultSet.getString("senha"));
			
			listar.add(beanCursoJsp);
			
		}
		
		return listar;
	}
	
	public void delete(String login) {
		try {
			String sql = "delete from usuario where login = '" + login + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			connection.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
			
		
	}

	public BeanCursoJsp consultar(String login) throws Exception {
		// TODO Auto-generated method stub
		
		String sql = "select * from usuario where login = '" + login + "'";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			
			BeanCursoJsp beanCursoJsp = new BeanCursoJsp();
			beanCursoJsp.setLogin(resultSet.getString("login"));
			beanCursoJsp.setSenha(resultSet.getString("senha"));
			
			return beanCursoJsp;
			
		}
		return null;
	}

}
