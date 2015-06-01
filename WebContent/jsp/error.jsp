<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="cabecera.jsp" %>

<% String msg = (String) request.getAttribute("msg"); %>
<h1><%= msg %></h1>
<a href="/LecoibWeb/">Volver..</a>
<%@ include file="pie.jsp" %>