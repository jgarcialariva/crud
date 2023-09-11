<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Entidades.Clientes" %>
<%@ page import="Negocio.BDNegocio" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Mantenimiento Clientes</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<%
		BDNegocio ObjN = new BDNegocio();
		ArrayList<Clientes> Lista = new ArrayList<>();
		Lista = ObjN.ListarClientes();
	%>
	<h1>Mantenimiento de la tabla Clientes</h1>
	<a href=add.jsp>Nuevo Registro</a>
	<table class="table">
		<tr>
			<th>IdCliente</th>
			<th>Apellidos</th>
			<th>Nombres</th>
			<th>Edad</th>
			<th>Sexo</th>
			<th>Opciones</th>
		</tr>
		<% for(Clientes C:Lista){
			String LinkView = "<a href=ver.jsp?id=" + C.getIdCliente() + ">Ver</a>";
			String LinkEdit = "<a href=edit.jsp?id=" + C.getIdCliente() + ">Editar</a>";
			String LinkDel = "<a href=del.jsp?id=" + C.getIdCliente() + ">Suprimir</a>";
		%>
			<tr>
				<td><%=C.getIdCliente()%></td>
				<td><%=C.getApellidos()%></td>
				<td><%=C.getNombres()%></td>
				<td><%=C.getEdad()%></td>
				<td><%=C.getSexo()%></td>
				<td><%=LinkView%> | <%=LinkEdit%> | <%=LinkDel%></td>				
			</tr>
		<% } %>
	</table>	
</body>
</html>