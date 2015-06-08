package test;

import negocio.BalanceMensualABM;
import negocio.EmpleadoABM;
import datos.BalanceMensual;
import datos.Empleado;

public class testPromedio 
{
	public static void main(String[] args)
	{
		try
	    {
			BalanceMensualABM bmAbm = new BalanceMensualABM();
			BalanceMensual bm = new BalanceMensual();
			float hs = bmAbm.promedioHsTrabPorMes(5,2015);
			System.out.println("Hs Promedio: "+hs+"\n\n");
	    } 
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}	
}
