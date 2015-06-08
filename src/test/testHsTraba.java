package test;

import negocio.BalanceMensualABM;
import negocio.EmpleadoABM;
import datos.BalanceMensual;
import datos.Empleado;

public class testHsTraba
{
	public static void main(String[] args)
	{
		try
	    {
			BalanceMensualABM bmAbm = new BalanceMensualABM();
			BalanceMensual bm = new BalanceMensual();
			EmpleadoABM eAbm = new EmpleadoABM();		
			Empleado e = new Empleado();
			e = eAbm.traerEmpleado(3);
			System.out.println("Empleado"+e+"\n\n");
			int hs = bmAbm.hsTrabEmplPorMes(e, 5,2015);
			System.out.println("Horas trabajadas por"+e+": "+hs+"\n\n");
	    } 
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}	
}
