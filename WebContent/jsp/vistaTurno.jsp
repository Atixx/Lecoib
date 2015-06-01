<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Turno"%>
<%@ include file="cabecera.jsp" %>
<% if (request.getAttribute("turno") != null) 
   { %>
	<% Turno turno = (Turno)request.getAttribute("turno"); %>
	Turno: <%= turno.getTurno() %><BR>
	Hora de Inicio: <%= turno.getHoraInicio() %><BR>
	Hora de Finalizacion: <%= turno.getHoraFin() %><BR>
<% }
else if (request.getAttribute("nombre") != null)
{ %>
    <h3>Se ha agregado el siguiente turno con exito:</h3>
    <p>
    ID: <%= request.getAttribute("id") %><br/>
    Turno: <%= request.getAttribute("nombre") %><br/>
    Hora de Inicio: <%= request.getAttribute("inicio") %><br/>
    Hora de Finalizacion: <%= request.getAttribute("fin") %>
    </p>
<% }  
   else 
   {%>
   <h3>Buscar Turno:</h3>
   <form class="form-inline" method="post">
    <div class="form-group">
        <input type="text" class="form-control" name="idTurno" id="idTurno" placeholder="Turno" required/> 
    </div>
        <input type="hidden" name="tipo" value="buscar">
        <button type="submit" class="btn btn-default">Submit</button>
    </form> 
    <br/>
    <h3>Agregar Turno:</h3>
    <form method="post"> 
	    <div class="form-inline" >
	       <label for="nombreTurno">Nombre del Turno</label>
	       <input type='text' name="nombreTurno" id="nombreTurno" class="form-control" maxlength="2" required>
	    </div>
	    <div class="form-inline" >
           <label for="HoraInicio">Hora Inicio</label>
           <input type="time" name="horaInicio" id="horaInicio" class="form-control" required>
        </div>
        <div class="form-inline" >
           <label for="horaFin">Hora Fin</label>
           <input type="time" name="horaFin" id="horaFin" class="form-control" required>
        </div>
        <input type="hidden" name="tipo" value="agregar">
	    <button type="submit" class="btn btn-default">Submit</button>
    </form>
    
<% } 
%>
<%@ include file="pie.jsp" %>
