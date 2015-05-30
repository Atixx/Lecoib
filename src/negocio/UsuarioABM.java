package negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import dao.UsuarioDao;
import datos.Usuario;

public class UsuarioABM 
{
	UsuarioDao dao=new UsuarioDao();
	
	public Usuario traerUsuario(long idUsuario) throws Exception
	{
		Usuario u = dao.traerUsuario(idUsuario);
		if (u == null)
		{
		    throw new Exception("No se encontro un Usuario con ID: "+idUsuario);
		}
		return u;
	}	
	
	public int agregarUsuario(String nombreUsr, String clave, GregorianCalendar ultimoCambioClave, GregorianCalendar ultimaSesion, int privilegio) throws Exception
	{
	    Usuario e = dao.traerUsuario(nombreUsr);
	    if (e != null)
	    {
	        throw new Exception("Ya existe el Usuario con el nombre: "+nombreUsr);
	    }
	    Usuario m = new Usuario(nombreUsr, clave, ultimoCambioClave, ultimaSesion, privilegio);
	    return dao.agregar(m);
	}	
	
	public void eliminarUsuario(long idUsuario) throws Exception
	{
		
		Usuario e = dao.traerUsuario(idUsuario);
		if (e == null)
		{
		    throw new Exception("No existe Usuario con ID: "+idUsuario+" para eliminar");
		}
		dao.eliminar(e);
	}
	
	public void modificarUsuario(Usuario u) throws Exception
	{
		
	    List<Usuario> lista = traerUsuario();
	    for (Usuario t : lista)
	    {
	        if (t.getNombreUsr() == u.getNombreUsr()) 
	        {
	            if (t.getIdUsuario() == u.getIdUsuario())
	            {
	                dao.actualizar(u);
	            }
	            else
	            {
	                throw new Exception("Ya existe un usuario con el nombre: "+u.getNombreUsr()+" con otro ID");
	            }
	        }
	    }  
	    dao.actualizar(u);
	}
	
	public List<Usuario> traerUsuario() throws Exception
	{
	    List<Usuario> lista = new ArrayList<Usuario>();
	    lista = dao.traerUsuario();
	    if (lista == null || lista.isEmpty())
	    {
	        throw new Exception("No existen usuarios en la base de datos");
	    }
	    return lista;
	}
}
