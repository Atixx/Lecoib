<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Solicitud"%>
<%@ include file="cabecera.jsp" %>

    <% Solicitud solicitud = (Solicitud)request.getAttribute("solicitud"); %>
    ID Solicitud: <%= solicitud.getIdSolicitud() %><BR>
    Jornada Titular: <%= solicitud.getJornadaTitular() %><BR>
    Jornada Reemplazane: <%= solicitud.getJornadaReemplazante() %><BR>
    <% if (solicitud.getAutoriza() != null)
    	{%>
    Autorizado por: <%= solicitud.getAutoriza() %>	
        <%} %>


<%@ include file="pie.jsp" %>