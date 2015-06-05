package controladores;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.Empleado;
import datos.Ficha;
import negocio.EmpleadoABM;
import negocio.FichaABM;
import modelo.Funciones;

/**
 * Servlet implementation class ControladorFichar
 */
@WebServlet("/ControladorFichar")
public class ControladorFichar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if (!ControladorLogueo.checkeaLogin(request, response))
		{
			try
			{
			String titulo = "Ficha";
			request.setAttribute("titulo", titulo);
			}
			catch(Exception e)
			{
				request.setAttribute("msg", e.getMessage());
			}
			finally
			{
				request.getRequestDispatcher("jsp/vistaFicha.jsp").forward(request, response);
			}
		}		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if (!ControladorLogueo.checkeaLogin(request, response))
		{
			try
			{
				FichaABM fABM = new FichaABM();
				Ficha f = new Ficha();
				Long dni = Long.parseLong(request.getParameter("dni"));
				int codigoVerificador = Integer.parseInt(request.getParameter("codigoVerificador"));
				HttpSession session = request.getSession(false);
				boolean error = false;
				long dniUsr = (Long)session.getAttribute("dniUsr");
				if(dniUsr!=dni)//Se fija que sea del usuario
				{
						error = true;
						error = true;
						String msg = "El DNI no corresponde al usuario logeado";
						request.setAttribute("msg", msg); //La busqueda real no va a ser texto abierto error de forma provisoria
						request.getRequestDispatcher("jsp/vistaFicha.jsp").forward(request, response);
				}
				else if(!f.esCodigoValido(dniUsr, codigoVerificador)) 
				{
					error = true;
					String msg = "El codigo verificador no es valido";
					request.setAttribute("msg", msg); //La busqueda real no va a ser texto abierto error de forma provisoria
					request.getRequestDispatcher("jsp/vistaFicha.jsp").forward(request, response);
				}
				else
				{//agrega ficha
					EmpleadoABM eABM = new EmpleadoABM();
					Empleado e = eABM.traerEmpleado(dni);
					GregorianCalendar hoy = new GregorianCalendar();
					int idFicha = fABM.agregarFicha(hoy, e,fABM.verificarEntradaSalida(e));
					Ficha ficha = fABM.traerFicha(idFicha);
					request.setAttribute("diaHora", Funciones.traerFechaHoraLarga(ficha.getDiaHora()));
					request.setAttribute("tipo", ficha.getEntradaSalida());
					request.setAttribute("ficha", idFicha);
					request.getRequestDispatcher("jsp/vistaFicha.jsp").forward(request, response);
				}
				
			}
			catch (Exception e)
			{
				request.setAttribute("msg", e.getMessage()); //La busqueda real no va a ser texto abierto error de forma provisoria
				request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
			}
		}
	}
}
	
