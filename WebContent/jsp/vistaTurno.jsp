<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Turno"%>
<%@ include file="cabecera.jsp" %>
		<% Turno turno = (Turno)request.getAttribute("turno"); %>
			Turno: <%= turno.getTurno() %><BR>
			Hora de Inicio: <%= turno.getHoraInicio() %><BR>
			Hora de Finalizacion: <%= turno.getHoraFin() %><BR>
<%@ include file="pie.jsp" %>
