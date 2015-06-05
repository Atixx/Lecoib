package negocio;

import java.util.ArrayList;
import java.util.List;

import datos.Solicitud;
import datos.Empleado;
import datos.Jornada;
import negocio.JornadaABM;
import modelo.Funciones;


public class GestionSolicitud 
{
	/*TODO: 
	+ traerSolicitud(idEmpleado : int) : Solicitud    <---- Con  traerSolicitud(boolean estado, long idEmpleado)  estaría, pero falta probar el dao/query de esa funcion
	+ validarSolicitud (jornadaReemplazante:Jornada)
	+ confirmaReemplazante (idSolicitud:int)
	+ autorizaSupervisor (idSolicitud:int)
	*/
	
	public Solicitud altaSolicitud(int idJornadaTitular, int idJornadaReemplazante)throws Exception
	{
			int idSolicitud;
			Solicitud sol;
			JornadaABM jABM = new JornadaABM();
			SolicitudABM sABM = new SolicitudABM();
			List<Solicitud> listaT = new ArrayList<Solicitud>();
			List<Solicitud> listaR = new ArrayList<Solicitud>();
			
			Jornada jTit = jABM.traerJornada(idJornadaTitular);
			Jornada jReemp = jABM.traerJornada(idJornadaReemplazante);

			Empleado eTit = jTit.getEmpleado();//trae el Empleado de la Jornada
			Empleado eReemp = jReemp.getEmpleado();
			
			listaT = sABM.traerSolicitud(false, eTit.getIdEmpleado());//trae las solicitudes del Empleado si el estado es pendiente
			listaR = sABM.traerSolicitud(false, eReemp.getIdEmpleado());
			
			if ( listaT.size()<3 ) 
			{	//El empleado solicitante no debe tener más de tres solicitudes de cambio pendientes en el mes
				if(listaR.isEmpty())
				{//&& el empeado reemplazante no debe tener más de una solicitud pendiente
					if(Funciones.esFechaFutura(jTit.getFecha()) && Funciones.esFechaFutura(jReemp.getFecha()))
					{
						idSolicitud = sABM.agregarSolicitud(jABM.traerJornada(idJornadaTitular),jABM.traerJornada(idJornadaReemplazante));
						sol = sABM.traerSolicitud(idSolicitud);
					}
					else throw new Exception("Error: La fecha de la Jornada del Reemplazante o Titular NO son futuras");
				}
				else throw new Exception("Error: El Empleado Reempleazante aún tiene Solicitudes pendientes");
			}
			else throw new Exception("Error: El Empleado Titular tiene tres Solicitudes pendientes");

			return sol;
	}
	
}
