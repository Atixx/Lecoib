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
    <h3>Agregar Solicitud:</h3>
    <form class="form-inline" method="post">
    <div class="form-group">
        <select class="selectpicker">
        
        <% for (Jornada j : jornadas)
        {%>
            <option><%=j.toString() %></option>
        <%} %>
        </select>
    </div>
    </form>
    <%}%>
<%@ include file="pie.jsp" %>