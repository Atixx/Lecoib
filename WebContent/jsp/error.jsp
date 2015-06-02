<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="cabecera.jsp" %>

<% String msg = (String) request.getAttribute("msg"); %>
<h3><%= msg %></h3>
<a href="/LecoibWeb/">Volver..</a>
<%@ include file="pie.jsp" %>