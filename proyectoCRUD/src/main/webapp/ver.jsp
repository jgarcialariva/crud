<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Entidades.Clientes" %>
<%@ page import="Negocio.BDNegocio" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Busqueda</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<h1>Busqueda de Clientes</h1>
	<%
		String Id = request.getParameter("id");
		BDNegocio ObjN = new BDNegocio();
		Clientes ObjC = new Clientes();
		ObjC = ObjN.BuscarCliente(Id);
	%>
	<table class="table">
		<tr>
			<td>IdCliente</td><td><%=ObjC.getIdCliente()%></td>
		</tr>
		<tr>
			<td>Apellidos</td><td><%=ObjC.getApellidos()%></td>
		</tr>
		<tr>
			<td>Nombres</td><td><%=ObjC.getNombres()%></td>
		</tr>
		<tr>
			<td>Edad</td><td><%=ObjC.getEdad()%></td>
		</tr>
		<tr>
			<td>Sexo</td><td><%=ObjC.getSexo()%></td>
		</tr>		
	</table>
	<a href=index.jsp>Regresar al Listado</a>
</body>
</html>