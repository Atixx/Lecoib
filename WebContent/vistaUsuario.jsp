<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Proyecto Lecoib: Usuario</title>
	</head>
	<body>
		<%@ include file="cabecera.jsp" %>
		<% Usuario usuario=(Usuario) request.getAttribute("usuario"); %>
			<BR>Usuario<%= usuario.getNombreUsr() %><BR>
			Ultimo cambio de clave: <%= usuario.getUltimoCambioClave%><BR>
			Ultima sesion iniciada: <%= usuario.getUltimaSesion%><BR>
			Nivel de privilegio:<%= usuario.getPrivilegio%><BR><BR>
		
		<BR>
		<%@ include file="pie.jsp" %>
	</body>
</html>