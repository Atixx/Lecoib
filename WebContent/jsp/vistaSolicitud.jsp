<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Solicitud"%>
<%@ include file="cabecera.jsp" %>
<div class="page-header">
  <h1>Solicitud creada</h1>
</div>
<div class="panel panel-default">
    <div class="panel-body">
	    <% Solicitud solicitud = (Solicitud)request.getAttribute("solicitud"); %>
	    ID Solicitud: <%= solicitud.getIdSolicitud() %><BR>
	    Jornada Titular: <%= solicitud.getJornadaTitular() %><BR>
	    Jornada Reemplazane: <%= solicitud.getJornadaReemplazante() %><BR>
	    <% if (solicitud.getAutoriza() != null)
	    	{%>
	    Autorizado por: <%= solicitud.getAutoriza() %>	
	        <%} %>
    </div>
</div>
<div class="alert alert-success" role="alert">
   <strong>Éxito!</strong>Se ha agregado la solicitud de cambio y se ha enviado un e-mail a su compañero
</div>
<h6>La pagina se refrescara en unos momentos, presione <em><a href="/LecoibWeb/">aqui</a></em> si no lo hace</h6>
<meta http-equiv="Refresh" content="15;url=/LecoibWeb/">
<%@ include file="pie.jsp" %>