package negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import dao.BalanceMensualDao;
import datos.BalanceMensual;
import datos.Empleado;


public class BalanceMensualABM 
{
	BalanceMensualDao bmDao = new BalanceMensualDao();
	
	public BalanceMensual traerBalanceMensual(int idBalanceMensual) throws Exception
	{
		BalanceMensual bm = bmDao.traerBalanceMensual(idBalanceMensual);
		if (bm == null)
		{
		    throw new Exception("No se encontro un balance mensual con ID: "+idBalanceMensual);
		}
		return bm;
	}	

	public int agregarBalanceMensual(GregorianCalendar mesAnio, Empleado empleado) throws Exception
	{		
		//hay que corroborar algo?
	    BalanceMensual bm = new BalanceMensual(mesAnio, empleado);
	    return bmDao.agregar(bm);
	}	

	public void modificarBalanceMensual(BalanceMensual bm) throws Exception
	{
		if (bmDao.traerBalanceMensual(bm.getIdBalanceMensual()) == null)
	    {
            throw new Exception("No se encontro el Balance Mensual Id:"+bm.getIdBalanceMensual()+" a modificarse");	
        }
		bmDao.actualizar(bm);		
	}
	
	public void eliminarBalanceMensual(int idBalanceMensual) throws Exception
	{
		
		BalanceMensual bm = bmDao.traerBalanceMensual(idBalanceMensual);
		if (bm == null)
		{
		    throw new Exception("No existe el Balance Mensual con ID: "+idBalanceMensual+" para eliminar");
		}
		bmDao.eliminar(bm);
	}
	
	public List<BalanceMensual> traerBalanceMensual() throws Exception
	{
	    List<BalanceMensual> lista = new ArrayList<BalanceMensual>();
	    lista = bmDao.traerBalanceMensual();
	    if (lista == null || lista.isEmpty())
	    {
	        throw new Exception("No existen empleados en la base de datos");
	    }
	    return lista;
	}		
	
}
