package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.SolicitudDao;
import datos.Solicitud;
import datos.Jornada;


public class SolicitudABM 
{
	SolicitudDao dao = new SolicitudDao();
	
	public Solicitud traerSolicitud(int idSolicitud) throws Exception
	{
	
		Solicitud s = dao.traerSolicitud(idSolicitud);		
		
		if (s == null)
		{
		    throw new Exception("No se encontro la solicitud con ID: "+idSolicitud);	
		}
		return s;
	}
	
	public List<Solicitud> traerSolicitud(boolean estado, int idEmpleado) throws Exception
	{
	    List<Solicitud> lista = new ArrayList<Solicitud>();
	    lista = dao.traerSolicitud(estado, idEmpleado);
	    if (lista == null || lista.isEmpty())
	    {
	        throw new Exception("No existen solicitudes en estado: "+estado+" del empelado con ID: "+idEmpleado);
	    }
	    
	    return lista;
	}
	
	
	public int agregarSolicitud(Jornada JornadaTitular, Jornada JornadaReemplazante) throws Exception
	{
		Solicitud s = new Solicitud(JornadaTitular, JornadaReemplazante);
		return dao.agregar(s);
	}
		
	 
	public void modificarSolicitud(Solicitud s) throws Exception
	{
		if (dao.traerSolicitud(s.getIdSolicitud()) == null)
	    {
            throw new Exception("No se encontro la solicitud con Id:"+s.getIdSolicitud()+" a modificarse");	
        }
		dao.actualizar(s);		
	}
	

	public void eliminarSolicitud(int idSolicitud) throws Exception
	{
		
		Solicitud s = dao.traerSolicitud(idSolicitud);
		if (s == null)
		{
		    throw new Exception("No existe la solicitud con ID: "+idSolicitud+" para eliminar");
		}
		dao.eliminar(s);
	}
	
}
