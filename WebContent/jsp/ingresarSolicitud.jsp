<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="datos.Jornada, java.util.ArrayList"%>
<%@ include file="cabecera.jsp" %>

<% String idJornada = (String) request.getAttribute("jornada"); %>
<% String fechaReemplazo = (String) request.getAttribute("fecha"); %>
<% if (idJornada == null) 
{
   String msg = (String) request.getAttribute("error"); %>
   <div class="page-header">
        <h1>Lo sentimos</h1>
    </div> 
    <div class="row">
	    <div class="col-md-4"><div class="alert alert-danger" role="alert"><%=msg %></div></div>
	    <div class="col-md-4"></div>
    <div class="col-md-4"></div>
    </div>
    <a class="btn btn-default" href="solicitud" role="button">Regresar</a>
<%}
else 
	
{
	
	ArrayList<Jornada> empleados = (ArrayList<Jornada>) request.getAttribute("jornadasCambio");
%>
<% if (empleados == null || empleados.isEmpty())
    {%>    
    <div class="page-header">
        <h1>Lo sentimos</h1>
    </div>
    <div class="row">
        <div class="col-md-4"><div class="alert alert-danger" role="alert">No hay compañeros que lo puedan cambiar</div></div>
    <div class="col-md-4"></div>
    <div class="col-md-4"></div>
    </div>
    <a class="btn btn-default" href="solicitud" role="button">Regresar</a>    
    <%}
else
    {%>
    <div class="page-header">
        <h1>Seleccione un compañero</h1>
    </div>
    <form class="form-inline" method="post">
    <div class="form-group">
        <select name="reemplazante" class="selectpicker">
        
        <% for (Jornada e : empleados)
        {%>
            <option value="<%= e.getIdJornada()%>"><%=e.getEmpleado().getApellido()+" ,"+e.getEmpleado().getNombre() %></option>
        <%} %>
        </select>
    </div>
    <input type="hidden" name="jornada" value=<%= idJornada %>>
    <button type="submit" class="btn btn-default">Solicitar</button>
    </form>
<%}

} %>
<%@ include file="pie.jsp" %>