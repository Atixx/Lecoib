package test;

import java.util.GregorianCalendar;

import datos.BalanceMensual;
import datos.Empleado;
import modelo.Funciones;
import negocio.BalanceMensualABM;
import negocio.EmpleadoABM;


public class testBalanceMensual 
{
	public static void main(String[] args)
	{
		try
	    {
			BalanceMensualABM bmAbm = new BalanceMensualABM();
			BalanceMensual bm = new BalanceMensual();
			EmpleadoABM eAbm = new EmpleadoABM();		
			Empleado e = new Empleado();
			e = eAbm.traerEmpleado(1);
			System.out.println("Empleado"+e+"\n\n");
			int idBM = bmAbm.generarBalcanceMensual(05, 2015, e);
			System.out.println("IdBM: "+idBM+"\n\n");
			Empleado e2 = new Empleado();
			e2 = eAbm.traerEmpleado(3);
			System.out.println("Empleado"+e+"\n\n");
			idBM = bmAbm.generarBalcanceMensual(05, 2015, e2);
			System.out.println("IdBM: "+idBM+"\n\n");
	    } 
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}	
}
