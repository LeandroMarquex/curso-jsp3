/**
 * 
 */
package filter;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import connection.SingleConnection;

/**
 * @author Leandro Marques
 *
 */

@WebFilter(urlPatterns = {"/*"})
public class Filter implements javax.servlet.Filter {
	
	private static Connection connection;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		try {
			chain.doFilter(request, response);
			
			connection.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			
			try {
				e.printStackTrace();
				connection.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		connection = SingleConnection.getConnection();
	}

}
