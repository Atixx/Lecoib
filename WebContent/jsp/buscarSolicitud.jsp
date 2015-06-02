<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Solicitud"%>
<%@ include file="cabecera.jsp" %>
   <h3>Buscar Solicitud:</h3>
   <form class="form-inline" method="post">
    <div class="form-group">
        <input type="text" class="form-control" name="idSolicitud" id="idSolicitud" placeholder="ID Solicitud" required/> 
    </div>
        <input type="hidden" name="tipo" value="buscar">
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
    
    <h3>Agregar Solicitud:</h3>
    <form class="form-inline" method="post">
    <div class="form-group">
        <select class="selectpicker">
            <option>Opcion 1</option>
            <option>Opcion 2</option>
            <option>Opcion 3</option>
        </select>
    </div>
    </form> 

<%@ include file="pie.jsp" %>