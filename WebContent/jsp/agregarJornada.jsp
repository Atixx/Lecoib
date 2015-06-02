<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Jornada"%>
<%@ include file="cabecera.jsp" %>
<form class="form-inline" method="post">
    <div class="form-group">
	    <label for="idEmpleado">Empleado:</label>
	    <input type="text" class="form-control" id="idEmpleado"/>
    </div>
    <div class="form-group">
	    <input type="text" class="form-control" id="idTurno" placeholder="Turno"/> 
    </div>
	    <button type="submit" class="btn btn-default">Submit</button>
</form>
<br/>
<a href="/LecoibWeb/index.jsp">Regresar</a>
<%@ include file="pie.jsp" %>