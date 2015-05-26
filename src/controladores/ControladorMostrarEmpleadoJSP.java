package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Empleado;
import negocio.EmpleadoABM;

public class ControladorMostrarEmpleadoJSP extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		procesarPeticion(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		procesarPeticion(request, response);
	}
		
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8");
		try 
		{
			int dni = Integer.parseInt(request.getParameter("dni"));
			EmpleadoABM empleadoAbm=new EmpleadoABM();
			Empleado empleado = empleadoAbm.traerEmpleado(dni);
			request.setAttribute("empleado", empleado);
			request.getRequestDispatcher("/vistaEmpleado.jsp").forward(request , response);
		} 
		catch (Exception e) 
		{
			response.sendError(500, "El DNI Ingresado no existe en la base de datos.");
		}
	}
	
	
}