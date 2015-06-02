package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Solicitud;
import negocio.SolicitudABM;

/**
 * Servlet implementation class ControladorSolicitud
 */
@WebServlet("/ControladorSolicitud")
public class ControladorSolicitud extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String titulo = "Buscar Solicitud";
		request.setAttribute("titulo", titulo);
		request.getRequestDispatcher("jsp/buscarSolicitud.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			int idSolicitud = Integer.parseInt(request.getParameter("idSolicitud"));
			SolicitudABM sAbm = new SolicitudABM();
			Solicitud solicitud = sAbm.traerSolicitud(idSolicitud);
			request.setAttribute("solicitud", solicitud);
			String titulo = "Solicitud";
			request.setAttribute("titulo", titulo);
			request.getRequestDispatcher("jsp/vistaSolicitud.jsp").forward(request, response);
		}
		catch (Exception e)
		{
			request.setAttribute("msg", e.getMessage()); //La busqueda real no va a ser texto abierto error de forma provisoria
			request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
		}
	}

}
