<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Busqueda</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<h1>Registrar Cliente</h1>
	<form action="grabar">
		<input type="hidden" name="op" value="3"/>
		<table class="table">
			<tr>
				<td>IdCliente</td><td><input name="txtid" /></td>
			</tr>
			<tr>
				<td>Apellidos</td><td><input name="txtape" /></td>
			</tr>
			<tr>
				<td>Nombres</td><td><input name="txtnom" /></td>
			</tr>
			<tr>
				<td>Edad</td><td><input name="txtedad" /></td>
			</tr>
			<tr>
				<td>Sexo</td><td><input name="txtsex" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Grabar" /></td>
			</tr>
		</table>
	</form>
	<a href=index.jsp>Regresar al Listado</a>
</body>
</html>