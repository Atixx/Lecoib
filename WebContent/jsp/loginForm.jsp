<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Usuario"%>
<%@page import="java.util.Enumeration" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="cabecera.jsp" %>
<h3>Login:</h3>
<form class="form-horizontal" method="post"> 
    <div class="form-inline form-group" >
       <label for="userName">Nombre de Usuario:</label>
       <input type='text' name="userName" id="userName" class="form-control" maxlength="8" required>
    </div>
    <div class="form-inline form-group" >
       <label for="password">Password:</label>
       <input type="password" name="password" id="password" class="form-control" required>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>
<% String msg = (String) request.getAttribute("msg"); %>
<% if(msg != null) 
    {%>
<div class="alert alert-danger" role="alert">
  <%= msg %>
</div>
 <%} %>
<%@ include file="pie.jsp" %>
