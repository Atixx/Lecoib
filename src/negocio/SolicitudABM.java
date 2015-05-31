package negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.GregorianCalendar;

import dao.SolicitudDao;
import datos.Solicitud;
import datos.Empleado;
import datos.Jornada;
import negocio.JornadaABM;
import negocio.EmpleadoABM;
import modelo.Funciones;


public class SolicitudABM 
{
	/*TODO: 
	+ traerSolicitud(idEmpleado : int) : Solicitud    <---- Con  traerSolicitud(boolean estado, long idEmpleado)  estaría, pero falta probar el dao/query de esa funcion
	+ validarSolicitud (jornadaReemplazante:Jornada)
	+ confirmaReemplazante (idSolicitud:int)
	+ autorizaSupervisor (idSolicitud:int)
	*/

	



	SolicitudDao dao = new SolicitudDao();
	
	
	public int altaSolicitud(long idJornadaTitular, long idJornadaReemplazante, long idAutoriza)throws Exception{

			int idSolicitud = 0;
			JornadaABM jABM = new JornadaABM();
			EmpleadoABM eABM = new EmpleadoABM();
			SolicitudABM sABM = new SolicitudABM();
			List<Solicitud> listaT = new ArrayList<Solicitud>();
			List<Solicitud> listaR = new ArrayList<Solicitud>();
			
			Jornada jTit = jABM.traerJornada(idJornadaTitular);
			Jornada jReemp = jABM.traerJornada(idJornadaReemplazante);

			Empleado eTit = jTit.getEmpleado();//trae el Empleado de la Jornada
			Empleado eReemp = jReemp.getEmpleado();
			
			listaT = dao.traerSolicitud(false, eTit.getIdEmpleado());//trae las solicitudes del Empleado si el estado es pendiente
			listaR = dao.traerSolicitud(false, eReemp.getIdEmpleado());
			
			if ( listaT.size()<3 ) 
			{	//El empleado solicitante no debe tener más de tres solicitudes de cambio pendientes en el mes
				if(listaR.isEmpty()){//&& el empeado reemplazante no debe tener más de una solicitud pendiente
					if(Funciones.esFechaFutura(jTit.getFecha()) && Funciones.esFechaFutura(jReemp.getFecha())){
						idSolicitud = sABM.agregarSolicitud(jABM.traerJornada(idJornadaTitular),jABM.traerJornada(idJornadaReemplazante), eABM.traerEmpleado(idAutoriza));
					}
					else throw new Exception("Error: La fecha de la Jornada del Reemplazante o Titular NO  son futuras");
				}
				else throw new Exception("Error: El Empleado Reempleazante aún tiene Solicitudes pendientes");
			}
			else throw new Exception("Error: El Empleado Titular tiene tres Solicitudes pendientes");

			return idSolicitud;
	}
	
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
	
	public List<Solicitud> traerSolicitud(boolean estado, long idEmpleado) throws Exception
	{
	    List<Solicitud> lista = new ArrayList<Solicitud>();
	    lista = dao.traerSolicitud();
	    if (lista == null || lista.isEmpty())
	    {
	        throw new Exception("No existen solicitudes en la base de datos");
	    }
	    
	    return lista;
	}
	
}
