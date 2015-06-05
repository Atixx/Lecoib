<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Usuario"%>
<%@ include file="cabecera.jsp" %>
<div class="page-header">
        <h1>Bienvenido <%=session.getAttribute("userNombre") %></h1>
</div> 
<p>Redireccionando...</p>
<meta http-equiv="Refresh" content="2;url=index.jsp">
<%@ include file="pie.jsp" %>
