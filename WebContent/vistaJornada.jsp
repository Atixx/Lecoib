<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Proyecto Lecoib: Jornadasss</title>
    </head>
    <body>
        <%@ include file="cabecera.jsp" %>
        <BR>
        <p>Las Jornadas son:</p>
            <% PrintWriter salida = response.getWriter(); %>
            <% salida.println("La nueva jornada es numero:" + request.getAttribute("idJornada"));  %>
            <% salida.println("<br/> <A href=\"/LecoibWeb/MostrarJornadas\">Volver...</A>"); %> 
        
        <a href="/LeCoib/index.jsp">Regresar</a>
        <BR>
        <%@ include file="pie.jsp" %>
    </body>
</html>