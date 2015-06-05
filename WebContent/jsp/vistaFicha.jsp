<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Ficha"%>
<%@ include file="cabecera.jsp" %>
		<h3>Agregar Ficha:</h3>
    <form method="post"> 
	    <div class="form-inline" >
	       <label for="dni">Dni:</label>
	       <input type='number' name="dni" id="dni" class="form-control" maxlength="9" required>
	    </div>
	    <div class="form-inline" >
	       <label for="codigoVerificador">Código Verificador:</label>
	       <input type='number' name="codigoVerificador" id="codigoVerificador" class="form-control" maxlength="1" required>
	    </div>
	    <input type="hidden" name="tipo" value="agregar">
	    <button type="submit" class="btn btn-default">Fichar</button>
<%@ include file="pie.jsp" %>