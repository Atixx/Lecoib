<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Jornada"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Proyecto Lecoib: Jornada</title>
    </head>
    <body>
        <form method="post">
            idEmpleado: <input type="text" name="idEmpleado"/><br/>
            idTurno:<input type="text" name="idTurno"/><br/> 
            <input type="submit" name="Submit">
        </form>
        <BR>
        <a href="/LecoibWeb/index.jsp">Regresar</a>
        <BR>
        <%@ include file="pie.jsp" %>
    </body>
</html>