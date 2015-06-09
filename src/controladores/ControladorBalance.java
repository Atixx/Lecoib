package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.BalanceMensual;
import datos.Empleado;
import modelo.Funciones;
import negocio.BalanceMensualABM;
import negocio.EmpleadoABM;

@WebServlet("/ControladorBalance")
public class ControladorBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if (!ControladorLogueo.checkeaLogin(request, response))
		{
			HttpSession session = request.getSession(false);
			request.setAttribute("empleadoId", (int) session.getAttribute("userId"));
			armarSelect(request, response);
			procesar(request,response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		armarSelect(request, response);
		procesar(request,response);
	}

	protected void procesar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
			try
			{
				EmpleadoABM eAbm = new EmpleadoABM();
				int empleadoId;
				String paramEmpleado = (String) request.getParameter("empleadoId");
				if (paramEmpleado == null)
				{
				    empleadoId = (int) request.getAttribute("empleadoId");
				}
				else
				{
					empleadoId = Integer.parseInt(paramEmpleado);
				}
				//Empleado e = eAbm.traerEmpleado((int) session.getAttribute("userId"));
				Empleado e = eAbm.traerEmpleado((int) empleadoId);
				BalanceMensualABM bmAbm = new BalanceMensualABM();
				BalanceMensual bm = new BalanceMensual();
				int anio = Funciones.traerAnio(new GregorianCalendar());
				int[] balance = new int[12];
				float[] promedio = new float[12];
				int[] extras = new int[12];
				for(int i=0; i<12;i++)
				{	
					bm = bmAbm.visualizarBalanceMensual(i+1, anio, e);
					balance[i] = bm.getHorasTrabajadas();
					promedio[i] = bmAbm.promedioHsTrabPorMes(i+1, anio);
					extras[i] = bmAbm.hsExtras(i+1, anio, e);
				}				
				String titulo = "Balance Horas";
				request.setAttribute("balance", balance);
				request.setAttribute("promedio", promedio);
				request.setAttribute("extras", extras);
				request.setAttribute("titulo", titulo);
				request.getRequestDispatcher("jsp/horas.jsp").forward(request, response);
			}
			catch (Exception e)
			{
				request.setAttribute("msg", e.getMessage()); 
				request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
			}
	}
	
	
	protected void armarSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			HttpSession session = request.getSession(false);
			int privilegio = (int) session.getAttribute("privilegio");
			if (privilegio == 1)
			{
				EmpleadoABM eAbm = new EmpleadoABM();
				int grupo = (int) session.getAttribute("grupoTrabajo");
				List<Empleado> todos = eAbm.traerEmpleado();
				ArrayList<Empleado> empleadosGrupo = new ArrayList<Empleado>();
				for (Empleado e : todos)
				{
					if (e.getGrupoTrabajo().getidGrupo() == grupo)
					{
						empleadosGrupo.add(e);
					}
				}
				
				request.setAttribute("empleados", empleadosGrupo);
			}
		} 
		catch (Exception e)
		{
			request.setAttribute("msg", e.getMessage()); 
			request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
		}
		
	}
}
