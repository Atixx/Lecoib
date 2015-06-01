<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.GrupoTrabajo"%>
<%@ include file="cabecera.jsp" %>
	<% GrupoTrabajo grupoTrabajo= (GrupoTrabajo)request.getAttribute("grupoTrabajo"); %>
	<BR>
		Nombre del Grupo: <%= grupoTrabajo.getNombreGrupo() %><BR>
	<%= grupoTrabajo.getEmpleados() %>--><BR><BR>
<%@ include file="pie.jsp" %>