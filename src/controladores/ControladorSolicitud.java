package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Funciones;
import negocio.JornadaABM;
import negocio.SolicitudABM;
import datos.Jornada;
import datos.Solicitud;

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
			try
			{
			String titulo = "Buscar Solicitud";
			request.setAttribute("titulo", titulo);
			HttpSession session = request.getSession(false);
			SolicitudABM sAbm = new SolicitudABM();
			JornadaABM jAbm = new JornadaABM();
			List<Jornada> jornadas = jAbm.traerJornadasFuturasEmpleado((int) session.getAttribute("userId"));
			if (!jornadas.isEmpty())
			{
				request.setAttribute("jornadas", jornadas);
			}
			List<Solicitud> solicitudes = sAbm.traerSolicitudEmpleado((int) session.getAttribute("userId"));
			if (solicitudes.size() >= 3)
			{
				request.setAttribute("solicitudes", "disabled");
			}
			 //request.getRequestDispatcher("jsp/buscarSolicitud.jsp").forward(request, response);
			}
			catch (Exception e)
			{
				request.setAttribute("msg", e.getMessage());
				//request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
			}
			finally
			{
				request.getRequestDispatcher("jsp/buscarSolicitud.jsp").forward(request, response);
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
				int idReemplaza = Integer.parseInt(reemplaza);
				int idJornadaTitular = Integer.parseInt(request.getParameter("jornada"));
				SolicitudABM sAbm = new SolicitudABM();
				JornadaABM jAbm = new JornadaABM();
				
/*				List<Solicitud> creadas = sAbm.traerSolicitudEmpleado();
				if (creadas != null)
				{
					for (Solicitud s : creadas)
					{
						if (s.getJornadaReemplazante().getIdJornada() == idReemplaza)
						{
							
						}
					}
				}*/
				
				int idSolicitud = sAbm.agregarSolicitud(jAbm.traerJornada(idJornadaTitular), jAbm.traerJornada(idReemplaza));
				request.setAttribute("solicitud", sAbm.traerSolicitud(idSolicitud));
				request.getRequestDispatcher("jsp/vistaSolicitud.jsp").forward(request, response);
			}
			else
			{
				boolean error = false;
				HttpSession session = request.getSession(false);
				String idJornada = request.getParameter("jornada");
				GregorianCalendar fecha = Funciones.traerFecha(request.getParameter("fechaReemplaza"));
				if (!Funciones.esFechaFutura(fecha))
				{
					error = true;
					request.setAttribute("error", "La fecha seleccionada ya paso");
				}
				JornadaABM jAbm = new JornadaABM();
				SolicitudABM sAbm = new SolicitudABM();
				Jornada titular = jAbm.traerJornada(Integer.parseInt(idJornada));
				List<Jornada> jornadasTitular = jAbm.traerJornadasPorFecha(titular.getFecha());
				List<Jornada> jornadasFecha = jAbm.traerJornadasPorFecha(fecha);
				for (Jornada j : jornadasFecha )
				{
					if (!error)
					{
						if (j.getEmpleado().getIdEmpleado() == (int) session.getAttribute("userId"))
						{
							error = true;
							request.setAttribute("error", "Usted trabaja en la fecha seleccionada");
						}
					}
				}
				
				if (!error)
				{
					List<Solicitud> creadas = sAbm.traerSolicitudJornadaTitular(Integer.parseInt(idJornada));
					List<Jornada> candidatos = jornadasFecha;
					List<Jornada> remover = new ArrayList<Jornada>();
					for (Jornada j : jornadasFecha )
					{
						for (Jornada jo : jornadasTitular)
						{
							if (j.getEmpleado().equals(jo.getEmpleado()))
							{
								remover.add(j); //Junta lo que hay que remover
							}
						}
						if (creadas != null) 
						{
							for (Solicitud s : creadas) //Compara las jornadas candidatos para verificar que no se hayan pedido
							{
								if (j.getIdJornada() == s.getJornadaReemplazante().getIdJornada())
								{
									remover.add(j);
								}
							}
						}
					}
					candidatos.removeAll(remover);//lo saca
					request.setAttribute("jornadasCambio", candidatos);
					request.setAttribute("jornada", idJornada);
					request.setAttribute("fecha", Funciones.traerFechaLarga(fecha));
				}
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
