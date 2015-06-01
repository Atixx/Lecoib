package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Turno;
import negocio.TurnoABM;

/**
 * Servlet implementation class ControladorTurnos
 */
@WebServlet("/ControladorTurnos")
public class ControladorTurnos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String titulo = "Buscar Turno";
		request.setAttribute("titulo", titulo);
		request.getRequestDispatcher("jsp/vistaTurno.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
		TurnoABM tABM = new TurnoABM();
		String tipo = request.getParameter("tipo");
		if (tipo.equals("buscar"))
		{
			int idTurno = Integer.parseInt(request.getParameter("idTurno"));
			String titulo = "Turno numero "+ idTurno;
			request.setAttribute("titulo", titulo);
			Turno turno = tABM.traerTurno(idTurno);
			request.setAttribute("turno", turno);
			request.getRequestDispatcher("jsp/vistaTurno.jsp").forward(request, response);
		}
		else //agregar
		{
			String nombre = request.getParameter("nombreTurno");
			String inicio = request.getParameter("horaInicio");
			String fin = request.getParameter("horaFin");
			int id = tABM.agregarTurno(nombre, inicio, fin);
			request.setAttribute("nombre", nombre);
			request.setAttribute("inicio", inicio);
			request.setAttribute("fin", fin);
			request.setAttribute("id",id);
			request.getRequestDispatcher("jsp/vistaTurno.jsp").forward(request, response);
		}
		} catch (Exception e)
		{
			request.setAttribute("msg", "Error en la busqueda"); //La busqueda real no va a ser texto abierto error de forma provisoria
			request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
		}
	}
	
}
