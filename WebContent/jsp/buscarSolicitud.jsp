<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Solicitud, datos.Jornada, java.util.ArrayList"%>
<%@ include file="cabecera.jsp" %>
<% int privilegio = (int) session.getAttribute("privilegio");

if (privilegio == 1)
{
%>
   <h3>Buscar Solicitud:</h3>
   <form class="form-inline" method="post">
    <div class="form-group">
        <input type="text" class="form-control" name="idSolicitud" id="idSolicitud" placeholder="ID Solicitud" required/> 
    </div>
        <input type="hidden" name="tipo" value="buscar">
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
    <br/>
    <% } %>
<%
ArrayList<Jornada> jornadas = (ArrayList<Jornada>) request.getAttribute("jornadas");
%>
<% if (jornadas == null)
	{%>    
<h3>No tiene jornadas para solicitar cambios</h3>
    <%}
else
	{%>
    <div class="page-header">
        <h1>Buscar cambio</h1>
    </div>
    <form method="post">
    <label>Jornada a cambiar</label>
    <div class="form-group">
        <select name="jornada" class="selectpicker">
        
        <% for (Jornada j : jornadas)
        {%>
            <option value="<%= j.getIdJornada()%>"><%=j.toString() %></option>
        <%} %>
        </select>
    </div>
    <div class="form-inline">
        <label for="fechaReemplaza">Fecha a reemplazar</label>
        <input type="date" class="form-control" name="fechaReemplaza" id="fechaReemplaza" placeholder="dd/mm/aa">
    </div>
    <div class="form-group">
    <button type="submit" class="btn btn-default" <%= request.getAttribute("solicitudes") %>>Buscar</button>
    </div>
    </form>
    <%}%>
	<div class="col-md-8 alert alert-info alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		<strong>Recuerde!</strong> No se podra efectuar busqueda de cambio si ya tiene 3 solicitudes pendientes
	</div>
<%@ include file="pie.jsp" %>