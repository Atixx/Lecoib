<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.BalanceMensual"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Proyecto LeCoib: Balance Mensual</title>
	</head>
	<body>
		<%@ include file="cabecera.jsp" %>
		<% BalanceMensual balanceMensual=(BalanceMensual)request.getAttribute("balanceMensual"); %>
		<BR>
			Mes y Año: <%= balanceMensual.getMesAnio() %><BR>
			Empleado: <%= balanceMensual.getEmpleado() %><BR>
		<BR>
		<a href="/LeCoib/index.jsp">Regresar</a>
		<BR>
		<%@ include file="pie.jsp" %>
	
	</body>
</html>