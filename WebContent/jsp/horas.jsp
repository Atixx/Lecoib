<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="cabecera.jsp" %>
<% int[] balance = (int[]) request.getAttribute("balance");
	float[] promedio = (float[]) request.getAttribute("promedio");
	int[] extras = (int[]) request.getAttribute("extras");

 for (int i=0; i < balance.length; i++)
   { %>
	 <p hidden id="balance<%=i%>"><%= balance[i] %></p>
 <%}
  for (int i=0; i < promedio.length; i++)
   { %>
	 <p hidden id="promedio<%=i%>"><%= promedio[i] %></p>
 <%}
  for (int i=0; i < extras.length; i++)
   { %>
	 <p hidden id="extras<%=i%>"><%= extras[i] %></p>
 <%} %>

       <script src="static/js/Chart.min.js"></script>
       <script src="static/js/horas.js"></script>
<div class="page-header">
    <h1>Horas Trabajadas</h1>
</div>       
       
<canvas id="horasTrabajadas" ></canvas>
<%@ include file="pie.jsp" %>