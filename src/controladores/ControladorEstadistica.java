package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.JornadaABM;

@WebServlet("/ControladorEstadistica")
public class ControladorEstadistica extends HttpServlet {
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
			
		} 
		catch (Exception e) 
		{
			String msg = e.getMessage();
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
		}
		response.sendRedirect("/LecoibWeb");
	}

}
