<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Usuario"%>
<%@ include file="cabecera.jsp" %>
	<% Usuario usuario = (Usuario)request.getAttribute("usuario"); %>
			Usuario: <%= usuario.getNombreUsr() %><BR>
			Ultimo cambio de clave: <%= usuario.getUltimoCambioClave() %><BR>
			Ultima sesion iniciada: <%= usuario.getUltimaSesion() %><BR>
			Nivel de privilegio:<%= usuario.getPrivilegio() %><BR><BR>
<%@ include file="pie.jsp" %>