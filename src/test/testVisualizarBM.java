package test;

import negocio.BalanceMensualABM;
import negocio.EmpleadoABM;
import datos.BalanceMensual;
import datos.Empleado;

public class testVisualizarBM
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
			System.out.println("Empleado: "+e+"\n\n");
			bm = bmAbm.visualizarBalanceMensual(5, 2015, e);
			System.out.println("Balance mensual: "+bm+"\n\n");
	    } 
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}	
}
