package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List; 

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.Empleado;
import datos.GrupoTrabajo;
import datos.Jornada;
import datos.Solicitud;
import modelo.Funciones;
import negocio.EmpleadoABM;
import negocio.GrupoTrabajoABM;
import negocio.SolicitudABM;
import negocio.JornadaABM;

/**
 * Servlet implementation class ControladorSolicitud
 */
@WebServlet("/ControladorSolicitud")
public class ControladorSolicitud extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if (!ControladorLogueo.checkeaLogin(request, response))
		{
			/* Paso 1: Elijo jornada propia para cambiar
			 * Paso 2: selecciono jornada de otro:
			 *     Debe ser del mismo grupo de trabajo
			 *     se deberia mostrar todas las jornadas de los otros empleados en la cual el usuario no esta trabajando(?????)
			 * Paso 3: mostrar cuales son los empleados que trabajan esa jornada para poder cambiar (no deberian trabajar en la
			 *     jornada original)
			 *     
			 *     Crear solicitud! :D 
			*/
			try
			{
			String titulo = "Buscar Solicitud";
			request.setAttribute("titulo", titulo);
			HttpSession session = request.getSession(false);
			JornadaABM jAbm = new JornadaABM();
			List<Jornada> jornadas = jAbm.traerJornadasFuturasEmpleado((int) session.getAttribute("userId"));
			if (!jornadas.isEmpty())
			{
				request.setAttribute("jornadas", jornadas);
			}
			request.getRequestDispatcher("jsp/buscarSolicitud.jsp").forward(request, response);
			}
			catch (Exception e)
			{
				request.setAttribute("msg", e.getMessage());
				request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String reemplaza = request.getParameter("reemplazante");
			if (reemplaza != null)
			{
				int idSolicitud = Integer.parseInt(request.getParameter("idSolicitud"));
				SolicitudABM sAbm = new SolicitudABM();
				Solicitud solicitud = sAbm.traerSolicitud(idSolicitud);
				request.setAttribute("solicitud", solicitud);
				String titulo = "Solicitud";
				request.setAttribute("titulo", titulo);
				request.getRequestDispatcher("jsp/vistaSolicitud.jsp").forward(request, response);
			}
			else
			{
				HttpSession session = request.getSession(false);
				String select = request.getParameter("jornada");
				GregorianCalendar fecha = Funciones.traerFecha(request.getParameter("fechaReemplaza"));
				JornadaABM jAbm = new JornadaABM();
				EmpleadoABM eAbm = new EmpleadoABM();
				
				List<Jornada> jornadasFecha = jAbm.traerJornadasPorFecha(fecha);
				List<Empleado> empleados = eAbm.traerEmpleado();
				empleados.remove(eAbm.traerEmpleado((int) session.getAttribute("userId"))); //saca el usuario de la lista 
				for (Jornada j : jornadasFecha )
				{
					empleados.remove(j.getEmpleado());
				}
				request.setAttribute("empleados", empleados);
				request.setAttribute("jornada", select);
				request.setAttribute("fecha", Funciones.traerFechaLarga(fecha));
				request.getRequestDispatcher("jsp/ingresarSolicitud.jsp").forward(request, response);
			}
		}
		catch (Exception e)
		{
			request.setAttribute("msg", e.getMessage()); //La busqueda real no va a ser texto abierto error de forma provisoria
			request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
		}
	}
}
