package controladores;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Empleado;
import modelo.Funciones;
import negocio.BalanceMensualABM;
import negocio.EmpleadoABM;
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
			BalanceMensualABM bmAbm = new BalanceMensualABM();
			EmpleadoABM eAbm = new EmpleadoABM();
			List<Empleado> empleados = eAbm.traerEmpleado();
			GregorianCalendar hoy = (GregorianCalendar) new GregorianCalendar(); 
			
			for (Empleado e : empleados)
			{
				if ((Funciones.traerMes(hoy)-1) == 1)
				{
					bmAbm.generarBalcanceMensual(12, Funciones.traerAnio(hoy)-1, e);
				}
				else
				{
					bmAbm.generarBalcanceMensual(Funciones.traerMes(hoy)-1, Funciones.traerAnio(hoy), e);
				}
			}
			response.sendRedirect("/LecoibWeb");
		} 
		catch (Exception e) 
		{
			String msg = e.getMessage();
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
		}
	}

}
