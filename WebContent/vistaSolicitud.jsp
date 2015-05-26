<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Solicitud"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Proyecto LeCoib: Solicitud</title>
	</head>
	<body>
		<%@ include file="/cabecera.jsp" %>
		<% Solicitud solicitud= (Solicitud)request.getAttribute("solicitud"); %>
		<BR>
			Estado: <%= solicitud.isEstado() %><BR>
			<!-- 
			
			demas...
			
			-->
		<BR>	
		<a href="/Lecoib/index.jsp">Regresar</a>	
		<BR>
		<%@ include file="pie.jsp" %>
	</body>
</html>