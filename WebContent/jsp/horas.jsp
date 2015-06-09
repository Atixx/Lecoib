<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Empleado, java.util.ArrayList"%>
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


<% int privilegio = (int) session.getAttribute("privilegio");

if (privilegio == 1)
{
	
	ArrayList<Empleado> empleados = (ArrayList<Empleado>) request.getAttribute("empleados");	
	if (empleados == null)
	{ %>
		<h3>No hay empleados en su grupo</h3>
	<%} 
	else
	{%>
	   <h3>Seleccione Empleado:</h3>
	   <form class="form-inline" method="post">
	    <div class="form-group">
	        <select name="empleadoId" class="selectpicker">      
            <% for (Empleado e : empleados)
                {%>
            <option value="<%= e.getIdEmpleado()%>"><%= e.getApellido()+", "+e.getNombre() %></option>
              <%} %>
	        </select>
	    </div>
	        <button type="submit" class="btn btn-default">Submit</button>
	    </form>
    <% } 
}
else 
{%>    
<br/><br/>  
<%} %>       
       
<canvas id="horasTrabajadas" ></canvas>
<%@ include file="pie.jsp" %>