package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.Usuario;
import negocio.UsuarioABM;

@WebServlet("/ControladorLogueo")
public class ControladorLogueo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		procesar(request,response);
		HttpSession session = request.getSession();
		request.getRequestDispatcher("jsp/loginForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		procesar(request,response);
		//String id = session.getId();
		UsuarioABM uAbm = new UsuarioABM();
		String username = (String) request.getParameter("userName");
		String password = (String) request.getParameter("password");
		/*
		 * Tomar usuario del post, corroborar que existe (usando usuarioABM)
		 * corroborar que la clave ingresada coincida con la que esta en la BD
		 * si es asi, iniciar session(?)
		*/
		try
		{
			Usuario u = uAbm.traerUsuario(username);
			if ( u.getClave().equals(password))
			{
				HttpSession session = request.getSession(true);
				session.setAttribute("session", "True");
				session.setAttribute("user", username);
				session.setAttribute("userId", u.getIdUsuario());
				session.setAttribute("userNombre", u.getEmpleado().getNombre() +" "+ u.getEmpleado().getApellido());
				session.setAttribute("privilegio", u.getPrivilegio());
				session.setAttribute("grupoTrabajo", u.getEmpleado().getGrupoTrabajo().getidGrupo());
				request.getRequestDispatcher("jsp/loginSuccess.jsp").forward(request, response);
			}
			else
			{
				String msg = "Corrobore los datos";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("jsp/loginForm.jsp").forward(request, response);
			}
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			String msg = e.getMessage(); //No existe el usuario, manejar!
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("jsp/loginForm.jsp").forward(request, response);
		}
	}

	protected void procesar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String titulo = "Login";
		request.setAttribute("titulo", titulo);
	}
	
	/* Corrobora que la session este logueada, redirecciona en caso de no estar
	 * retorna true en caso de haber redireccionado, false si no.
	 * Usar en controladores que necesiten estar logueados para su funcionalidad
	*/
	public static boolean checkeaLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false);
		String s = (String) session.getAttribute("session");
		boolean retval = false;
		if (s == null)
		{ 
			request.getRequestDispatcher("jsp/loginRequerido.jsp").forward(request, response);
			retval = true;
		}
		return retval;
	}
}
