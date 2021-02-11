<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Usuário</title>
</head>
<body>
	<h1>Cadastro de Usuario</h1>
	<form action="salvarUsuario" method="post">
		<table>
			<tr>
				<td>Login:</td>
				<td><input type="text" id="login" name="login">
			</tr>
			<tr>
				<td>Senha:</td>
				<td><input type="text" id="senha" name="senha">
			</tr>
		</table>
		<input type="submit" value="Salvar">
	</form>
	
	<table>
		<c:forEach items="${usuarios}" var="user">
		<tr> 
			<td><c:out value="${user.login}"></c:out></td>
			<td><c:out value="${user.senha}"></c:out></td>
		</tr>
			
		</c:forEach>
	</table>
</body>
</html>