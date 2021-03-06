<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Usu�rio</title>
</head>
<body>
	<h1>Cadastro de Usuario</h1>
	<form action="salvarUsuario" method="post">
		<table>
		<tr>
				<td>Id:</td>
				<td><input type="text" id="id" name="id" value="${user.id}">
			</tr>
			<tr>
				<td>Login:</td>
				<td><input type="text" id="login" name="login" value="${user.login}">
			</tr>
			<tr>
				<td>Senha:</td>
				<td><input type="text" id="senha" name="senha" value="${user.senha}">
			</tr>
		</table>
		<input type="submit" value="Salvar">
	</form>
	
	<table>
		<c:forEach items="${usuarios}" var="user">
		<tr> 
			<td style="width: 150px"><c:out value="${user.login}"></c:out></td>
			<td><c:out value="${user.senha}"></c:out></td>
			<td><a href="salvarUsuario?acao=delete&user=${user.login }">Excluir</a></td>
			<td><a href="salvarUsuario?acao=editar&user=${user.login }">Editar</a></td>
		</tr>
			
		</c:forEach>
	</table>
</body>
</html>