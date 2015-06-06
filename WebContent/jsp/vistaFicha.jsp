<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Ficha"%>
<%@ include file="cabecera.jsp" %>
<% if (request.getAttribute("ficha") != null) 
   { %>
	  <h1>Ficha cargada</h1>

		    Dia Hora: <%= request.getAttribute("diaHora") %><BR>
		    Tipo: <%= request.getAttribute("tipo") %><BR>
		    <a href="/LecoibWeb/">Volver al inicio</a>
	<% }
	else 
   {%>
   		<h3>Agregar Ficha:</h3>
    <form method="post" action="ControladorFichar"> 
	    <div class="form-inline" >
	       <label for="dni">DNI:</label>
	       <input type='number' name="dni" id="dni" class="form-control" maxlength="9" min="0" step="1" required>
	    </div>
	    <div class="form-inline" >
	       <label for="codigoVerificador">Código Verificador:</label>
	       <input type='number' name="codigoVerificador" id="codigoVerificador" class="form-control" min="0" step="1" required>
	    </div>
	    <input type="hidden" name="tipo" value="fichar">
	    <button type="submit" class="btn btn-default">Fichar</button>
	 </form> 
	 <% String msg = (String) request.getAttribute("msg"); %>
	<% if(msg != null) 
	    {%>   
		<div class=" container col-md-4 alert alert-danger" role="alert">
		  <%= msg %>
		</div>
 <%} %>
   <% } 
%>
<%@ include file="pie.jsp" %>