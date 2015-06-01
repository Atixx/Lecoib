<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

        <link type = "text/css" href="static/css/bootstrap.min.css" rel="stylesheet"></link>
        <link type = "text/css" href="static/css/bootstrap-theme.min.css" rel="stylesheet"></link>
        <link type= "text/css" href="static/css/Lecoib.css" rel="stylesheet"></link>
        <link href='http://fonts.googleapis.com/css?family=Architects+Daughter' rel='stylesheet' type='text/css'>
        <script src="static/js/jquery-2.1.4.min.js"></script>
        <script src="static/js/bootstrap.min.js"></script>
        <script src="static/js/jssor.slider.mini.js"></script>
        <script src="static/js/Lecoib.js"></script>
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
%>
        
<title><%= titulo %></title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-static-top">
  <div class="container-fluid">
    <a role="button" class="btn btn-default navbar-btn" href="/LecoibWeb/">Loguearse</a>
    <a role="button" class="btn btn-default navbar-btn" href="#">Crear Solicitud</a>
    <a role="button" class="btn btn-default navbar-btn" href="#">Estadisticas</a>
    <a role="button" class="btn btn-default navbar-btn" href="MostrarJornadas">Jornadas</a>
  </div>
</nav>