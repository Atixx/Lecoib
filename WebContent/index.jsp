<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="jsp/cabecera.jsp" %>
<!-- Aca empieza Body -->
<%-- include file="jsp/slider.html" --%>
<script src="static/js/jssor.slider.mini.js"></script>
<script src="static/js/index.js"></script>
<h1 id="titulo">Lecoib</h1>
<div class="containter-fluid">
	<div class="row">
		<div class="col-md-6 col-md-push-3">
		<%@ include file="jsp/slider.html" %>
		</div>
	</div>
	<div class="row">
		<div class="col-md-1"><p></p></div>
	</div>
	<div class="row">
		<div class="col-md-1"><p></p></div>
	</div>
<%
if (s != null) 
{
 int privilegio = (int) session.getAttribute("privilegio");
	if (privilegio == 1) 
	 {%>
	<div class="row">
		<div class="col-md-6">
			<a class="btn btn-default" href="jornadas" role="button">Generar Jornadas</a>
			<a class="btn btn-default" href="generarBalances" role="button">Generar Balance Mensual</a>
		</div>
	</div>
	
	<%} 
 } %>
	
</div>
<!-- Aca termina Body -->
<%@ include file="jsp/pie.jsp" %>