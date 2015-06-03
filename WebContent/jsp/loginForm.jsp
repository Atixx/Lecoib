<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Usuario"%>
<%@page import="java.util.Enumeration" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="cabecera.jsp" %>
<div class="container col-md-4">
</div>
<div class="container col-md-4">
<h3 id="titulo">Ingrese los datos:</h3>
<form class="form-signin" method="post"> 
       <label for="userName">Nombre de Usuario:</label>
       <input type='text' name="userName" id="userName" class="form-control" maxlength="8" required>
       <label for="password">Password:</label>
       <input type="password" name="password" id="password" class="form-control" required>
    <button type="submit" class="btn btn-primary btn-lg btn-block">Submit</button>
</form>
</div>
<div class="container col-md-6">
</div>
<div class="container col-md-6">
</div>
<div class="container col-md-4">
</div>
<% String msg = (String) request.getAttribute("msg"); %>
<% if(msg != null) 
    {%>   
	<div class=" container col-md-4 alert alert-danger" role="alert">
	  <%= msg %>
	</div>
 <%} %>
<%@ include file="pie.jsp" %>
