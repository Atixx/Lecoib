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
		String titulo = "Jornadas";
		request.setAttribute("titulo", titulo);
		//procesarPeticion(request, response);
		request.getRequestDispatcher("jsp/agregarJornada.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//procesarPeticion(request, response);
		request.getRequestDispatcher("jsp/vistaJornada.jsp").forward(request , response);
	}

	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		try
		{
		}
		catch (Exception e)
		{
			response.sendError(500, "La jornada no existe en la base de datos");
		}
	}
}
