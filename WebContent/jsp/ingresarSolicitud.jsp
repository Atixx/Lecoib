<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="datos.Jornada, java.util.ArrayList"%>
<%@ include file="cabecera.jsp" %>

<% String msg = (String) request.getAttribute("jornada"); %>
<% String fechaReemplazo = (String) request.getAttribute("fecha"); %>
<% if (msg == null) 
{
   msg = (String) request.getAttribute("error"); %>
   <h3> <%=msg %></h3>
<%}
else {%>
<h3><%= msg %></h3>
<h4><%= fechaReemplazo %></h4>
<%} %>

<%
ArrayList<Jornada> empleados = (ArrayList<Jornada>) request.getAttribute("empleados");
%>
<% if (empleados == null)
    {%>    
<h3>No hay..</h3>
    <%}
else
    {%>
    <h3>Empleados:</h3>
    <form class="form-inline" method="post">
    <label>Empleados:</label>
    <div class="form-group">
        <select name="reemplazante" class="selectpicker">
        
        <% for (Jornada e : empleados)
        {%>
            <option value="<%= e.getIdJornada()%>"><%=e.getEmpleado().toString() %></option>
        <%} %>
        </select>
    </div>
    <input type="hidden" name="jornada" value=<%= msg %>>
    <button type="submit" class="btn btn-default">Solicitar</button>
    </form>
<%}%>


<%@ include file="pie.jsp" %>