package test;

import java.util.List;

import datos.Turno;
import negocio.TurnoABM;


public class TestTraerTurno 
{
	public static void main(String[] args)
	{
		try
	    {
	        TurnoABM tabm = new TurnoABM();        
	        Turno turno = new Turno();
	        int idTurno = tabm.agregarTurno("T0","10:00","18:00");	        
	        System.out.println("El id del turno es:"+idTurno+"\n\n");
	        turno = tabm.traerTurno(idTurno);
	        System.out.println("El turno es"+turno);
	        
	    }
	    catch (Exception e)
	    {
	    	e.printStackTrace();
	        System.out.println(e.getMessage());
	    }
	}
}
