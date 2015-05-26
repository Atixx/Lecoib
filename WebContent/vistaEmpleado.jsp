<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Empleado"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Proyecto LeCoib: Empleado</title>
	</head>
	<body>
		<%@ include file="/cabecera.jsp" %>
		<% Empleado empleado = (Empleado) request.getAttribute("empleado"); %>
		<BR>
			Apellido: <%= empleado.getApellido() %><BR>
			Nombre: <%= empleado.getNombre() %><BR>
			DNI: <%= empleado.getDni() %><BR>
			Fecha de Ingreso: <%= empleado.getDni() %><BR>
			Email: <%= empleado.getEmail() %><BR>
			Categoria: <%= empleado.getCategoria() %><BR>
			Turno: <%= empleado.getTurno() %><BR>
			Grupo:	<%= empleado.getGrupo() %><BR>
		<BR>	
		<a href="/Lecoib/index.jsp">Regresar</a>	
		<BR>
		<%@ include file="pie.jsp" %>
	</body>
</html>