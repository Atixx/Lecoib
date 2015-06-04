<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="datos.Empleado, java.util.ArrayList"%>
<%@ include file="cabecera.jsp" %>

<% String msg = (String) request.getAttribute("jornada"); %>
<% String fechaReemplazo = (String) request.getAttribute("fecha"); %>
<h3><%= msg %></h3>
<h4><%= fechaReemplazo %></h4>


<%
ArrayList<Empleado> empleados = (ArrayList<Empleado>) request.getAttribute("empleados");
%>
<% if (empleados == null)
    {%>    
<h3>No hay..</h3>
    <%}
else
    {%>
    <h3>Empleados:</h3>
    <form class="form-inline" method="post">
    <label>Emp</label>
    <div class="form-group">
        <select name="jornada" class="selectpicker">
        
        <% for (Empleado e : empleados)
        {%>
            <option value="<%= e.getIdEmpleado()%>"><%=e.toString() %></option>
        <%} %>
        </select>
    </div>
    </form>
<%}%>

<a href="/LecoibWeb/">Volver..</a>


<%@ include file="pie.jsp" %>