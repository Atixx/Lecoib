package test;

import java.util.GregorianCalendar;

import negocio.EmpleadoABM;
import negocio.JornadaABM;
import negocio.SolicitudABM;
import negocio.TurnoABM;
import datos.Empleado;
import datos.Jornada;
import datos.Solicitud;
import datos.Turno;

public class TestAgregarSolic {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		try
		{
			JornadaABM jAbm = new JornadaABM();
			SolicitudABM sAbm = new SolicitudABM();			
			//EmpleadoABM eAbm = new EmpleadoABM();		
			//TurnoABM tAbm = new TurnoABM();
			//Empleado e = eAbm.traerEmpleado(2);
			//Turno t = tAbm.traerTurno(1);

			//GregorianCalendar m = (GregorianCalendar)GregorianCalendar.getInstance();
			//int idJ1 = jAbm.agregarJornada(m, e, t);
			
			Jornada j = jAbm.traerJornada(1);
			Jornada j2 = jAbm.traerJornada(2);
			int ids1 = sAbm.agregarSolicitud(j, j2);
			System.out.println("Nro solicitud: "+ids1+"\n\n");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
