package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Categoria;
import datos.Empleado;
import datos.GrupoTrabajo;
import datos.Jornada;
import datos.Turno;
import modelo.Funciones;
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
			
			GregorianCalendar fecha = Funciones.traerFecha("13/02/2015");
			GregorianCalendar ingreso = Funciones.traerFecha("1/1/2015");
			GregorianCalendar inicio = new GregorianCalendar();
			GregorianCalendar fin	= new GregorianCalendar();
			//Turno turno = new Turno("Noche", inicio, fin);
			Categoria categoria = new Categoria("Agente", 4000);
			GrupoTrabajo grupo = new GrupoTrabajo("SuperNonos");
			Empleado empleado = new Empleado("Levy", "Maor", 34564345, ingreso, "email@example.com", categoria, turno, grupo);
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
