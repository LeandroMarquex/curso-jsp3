/**
 * 
 */
package beans;

/**
 * @author Leandro Marques
 *
 */
public class BeanCursoJsp {
	
	private Long id;
	private String login;
	private String senha;
	
	public boolean validarLoginSenha(String login, String senha) {
		if (login.equalsIgnoreCase("jsp") && senha.equalsIgnoreCase("jsp")) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return "BeanCursoJsp [login=" + login + ", senha=" + senha + "]";
	}
	
	

}
