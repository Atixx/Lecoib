package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControladorBalance")
public class ControladorBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		procesar(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		procesar(request,response);
	}

	protected void procesar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String titulo = "Balance Horas";
		int[] balance = {28, 48, 40, 19, 86, 27, 90, 80, 94, 33, 20, 74};
		request.setAttribute("balance", balance);
		request.setAttribute("titulo", titulo);
		request.getRequestDispatcher("jsp/horas.jsp").forward(request, response);
	}
}
