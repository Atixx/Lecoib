package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Empleado;
import datos.Jornada;
import datos.Turno;
import negocio.JornadaABM;

public class ControladorMostrarJornadas extends HttpServlet
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//procesarPeticion(request, response);
		request.getRequestDispatcher("agregarJornada.jsp").forward(request, response);
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
			
			GregorianCalendar fecha = new GregorianCalendar();
			Empleado empleado = new Empleado();
			Turno turno = new Turno();
			JornadaABM jornadaAbm = new JornadaABM();
			int idJornada = jornadaAbm.agregarJornada(fecha, empleado, turno);
			
			request.setAttribute("idJornada", idJornada);
			request.getRequestDispatcher("/vistaJornada.jsp").forward(request , response);
		}
		catch (Exception e)
		{
			response.sendError(500, "La jornada no existe en la base de datos");
		}
	}
}
