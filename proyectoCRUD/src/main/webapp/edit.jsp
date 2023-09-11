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
	<h1>Editar Datos de Clientes</h1>
	<%
		String Id = request.getParameter("id");
		BDNegocio ObjN = new BDNegocio();
		Clientes ObjC = new Clientes();
		ObjC = ObjN.BuscarCliente(Id);
	%>
	<form action="grabar">
		<input type="hidden" name="op" value="1"/>
		<table class="table">
			<tr>
				<td>IdCliente</td><td><input name="txtid" value=<%=ObjC.getIdCliente()%> readonly/></td>
			</tr>
			<tr>
				<td>Apellidos</td><td><input name="txtape" value='<%=ObjC.getApellidos()%>' /></td>
			</tr>
			<tr>
				<td>Nombres</td><td><input name="txtnom" value='<%=ObjC.getNombres()%>' /></td>
			</tr>
			<tr>
				<td>Edad</td><td><input name="txtedad" value=<%=ObjC.getEdad()%> /></td>
			</tr>
			<tr>
				<td>Sexo</td><td><input name="txtsex" value=<%=ObjC.getSexo()%> /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Grabar" /></td>
			</tr>
		</table>
	</form>
	<a href=index.jsp>Regresar al Listado</a>
</body>
</html>