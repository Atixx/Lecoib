<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Proyecto LeCoib: Turno</title>
	<head>
	<body>
		<%@ include file="cabecera.jsp" %>
		<% Turno turno = (Turno)request.getAttribute("turno"); %>
		<BR>
			Turno: <%= turno.getTurno() %><BR>
			Hora de Inicio: <%= turno.getHoraInicio() %><BR>
			Hora de Finalizacion: <%= turno.getHoraFin() %><BR>
		<BR>
		<a href="/LeCoib/index.jsp">Regresar</a>
		<BR>
		<%@ include file="pie.jsp" %>
	</body>
</html>