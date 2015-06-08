package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import negocio.JornadaABM;

/**
 * Servlet implementation class ControladorJornadas
 */
@WebServlet("/ControladorJornadas")
public class ControladorJornadas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		procesar(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		procesar(request,response);
	}
	
	protected void procesar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try 
		{
			JornadaABM jAbm = new JornadaABM();
			jAbm.generarJornadasMes();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			String msg = e.getMessage(); //No existe el usuario, manejar!
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
		}
		response.sendRedirect("/LecoibWeb");
	}

}
