package negocio;

import dao.SolicitudDao;
import datos.Solicitud;
import datos.Empleado;
import datos.Jornada;



public class SolicitudABM 
{
	SolicitudDao dao = new SolicitudDao();
	
	public Solicitud traerSolicitud(long idSolicitud) throws Exception
	{
	
		Solicitud s = dao.traerSolicitud(idSolicitud);		
		
		if (s == null)
		{
		    throw new Exception("No se encontro la solicitud con ID: "+idSolicitud);	
		}
		return s;
	}
	
	public int agregarSolicitud(Jornada JornadaTitular, Jornada JornadaReemplazante, Empleado Autoriza) throws Exception
	{
		Solicitud s = new Solicitud(JornadaTitular, JornadaReemplazante, Autoriza);
		return dao.agregar(s);
	}
		
	 
	public void modificarSolicitud(Solicitud s) throws Exception
	{
		if (dao.traerSolicitud(s.getIdSolicitud()) == null)
	    {
            throw new Exception("No se encontro el Balance Mensual Id:"+s.getIdSolicitud()+" a modificarse");	
        }
		dao.actualizar(s);		
	}
	

	public void eliminarSolicitud(long idSolicitud) throws Exception
	{
		
		Solicitud s = dao.traerSolicitud(idSolicitud);
		if (s == null)
		{
		    throw new Exception("No existe la Solicitud con ID: "+idSolicitud+" para eliminar");
		}
		dao.eliminar(s);
	}
	
}
