<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

        <link type = "text/css" href="static/css/bootstrap.min.css" rel="stylesheet"></link>
        <link type = "text/css" href="static/css/bootstrap-theme.min.css" rel="stylesheet"></link>
        <link type= "text/css" href="static/css/Lecoib.css" rel="stylesheet"></link>
        <link type= "text/css" href="static/css/bootstrap-select.min.css" rel="stylesheet"></link>
        <link href='http://fonts.googleapis.com/css?family=Architects+Daughter' rel='stylesheet' type='text/css'>
        <script src="static/js/jquery-2.1.4.min.js"></script>
        <script src="static/js/bootstrap.min.js"></script>
        <script src="static/js/jssor.slider.mini.js"></script>
        <script src="static/js/Lecoib.js"></script>
        <script src="static/js/bootstrap-select.min.js"></script>
<% 
	String titulo;
	if (request.getAttribute("titulo") == null)
	{
	titulo = "Lecoib";
	}
	else
	{
	    titulo = "Lecoib: " +(String) request.getAttribute("titulo");
	}
	String fecha = new Date().toLocaleString(); //TODO: Hacer un formato de fecha mas lindo
%>
        
<title><%= titulo %></title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-static-top">
  <div class="container-fluid">
    <a role="button" class="btn btn-default navbar-btn" href="/LecoibWeb/">Inicio</a>
    <a role="button" class="btn btn-default navbar-btn" href="solicitud">Solicitud</a>
    <a role="button" class="btn btn-default navbar-btn" href="estadistica">Estadisticas</a>
    <a role="button" class="btn btn-default navbar-btn" href="turno">Turno</a>
    <span class="navbar-text col-md-4">Lecoib</span>
    <p class="navbar-text navbar-right"><%=fecha %></p>
	<p class="navbar-text navbar-right">Logueado como <a href="#" class="navbar-link">Mark Otto</a></p>
  </div>
</nav>
<div class="wrapper">