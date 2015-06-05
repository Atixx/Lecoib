package controladores;

import java.util.GregorianCalendar;
import modelo.Funciones;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		//if (!ControladorLogueo.checkeaLogin(request, response))
		//{
			String titulo = "Fichar";
			request.setAttribute("titulo", titulo);
			request.getRequestDispatcher("jsp/vistaFicha.jsp").forward(request, response);
		//}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			//if (!ControladorLogueo.checkeaLogin(request, response))
			//{
				long dni = Long.parseLong(request.getParameter("dni"));
				//if(session.getAttribute(dni)==dni)
				//comparar dni de logueo con dni ingresado
				int codigoVerificador = Integer.parseInt(request.getParameter("codigoVerificador"));
				Ficha f = new Ficha();
				boolean error = false;
				if(f.esCodigoValido(dni,codigoVerificador)){
					HttpSession session = request.getSession(false);
					if((int) session.getAttribute("dni")!=dni) {
						error = true;
						request.setAttribute("error", "El DNI ingresado no pertenece al usuario logeado");
					}
				}
				else{
					error = true;
					request.setAttribute("error", "El codigo verficador es inválido");
				}
				if (!error){
					FichaABM fABM = new FichaABM();
					int idFicha = fABM.agregarFicha(dni, codigoVerificador);
					request.setAttribute("idFicha",idFicha);
					GregorianCalendar diaHora = Funciones.traerFechaHora(request.getParameter("diaHora"));
					request.setAttribute("diaHora", diaHora);
					String titulo = "Agregada ficha "+ idFicha;
					request.setAttribute("titulo", titulo);
					String entradaSalida = Funciones.pasarBooleanAString(request.getParameter("entradaSalida"));
					request.setAttribute("entradaSalida", entradaSalida);
					request.getRequestDispatcher("jsp/vistaFicha.jsp").forward(request, response);
	
				}
				
			//}
		}
		catch (Exception e)
		{
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
		}
	}

}
