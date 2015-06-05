package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Ficha;
import negocio.FichaABM;

/**
 * Servlet implementation class ControladorFichar
 */
@WebServlet("/ControladorFichar")
public class ControladorFichar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String titulo = "Fichar";
		request.setAttribute("titulo", titulo);
		request.getRequestDispatcher("jsp/vistaFicha.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			long dni = Long.parseLong(request.getParameter("dni"));
			//if(session.getAttribute(dni)==dni)
			//comparar dni de logueo con dni ingresado
			int codigoVerificador = Integer.parseInt(request.getParameter("codigoVerificador"));
			Ficha f = new Ficha();
			if(f.esCodigoValido(dni,codigoVerificador)){
				FichaABM fABM = new FichaABM();
				int idFicha = fABM.agregarFicha(dni, codigoVerificador);
			}
			else{
				request.setAttribute("msg", "Error: El codigo verificador no coincide"); 
				request.getRequestDispatcher("jsp/vistaFicha.jsp").forward(request, response);
			}
			
		}
		catch (Exception e)
		{
			request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
		}
	}

}
