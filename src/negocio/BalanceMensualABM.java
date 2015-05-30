package negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import dao.BalanceMensualDao;
import datos.BalanceMensual;
import datos.Categoria;
import datos.Empleado;
import datos.GrupoTrabajo;
import datos.Turno;

public class BalanceMensualABM 
{
	BalanceMensualDao bmDao = new BalanceMensualDao();
	
	public BalanceMensual traerBalanceMensual(long idBalanceMensual) throws Exception
	{
		BalanceMensual bm = bmDao.traerBalanceMensual(idBalanceMensual);
		if (bm == null)
		{
		    throw new Exception("No se encontro un empleado con ID: "+idBalanceMensual);
		}
		return bm;
	}	

	public int agregarBalanceMensual( int horasTrabajadas, GregorianCalendar mesAnio, Empleado empleado) throws Exception
	{		
		//hay que corroborar algo?
	    BalanceMensual bm = new BalanceMensual(mesAnio, empleado);
	    return bmDao.agregar(bm);
	}	

	public void modificarBalanceMensual(BalanceMensual bm) throws Exception
	{
		
	    List<BalanceMensual> lista = bmDao.traerBalanceMensual();
	    boolean encontrado = false;
	    for (BalanceMensual t : lista)
	    {
	        if (t.getIdBalanceMensual() == bm.getIdBalanceMensual()) 
	        {
	        	encontrado = true;
                bmDao.actualizar(bm);
            }
            else
            {
                throw new Exception("Ya existe un empleado con el DNI: "+bm.getIdBalanceMensual()+"bajo otro ID");
            }	        
	    }
		if(encontrado == true) throw new Exception("No se encontro el Balance Mensual Id:"+bm.getIdBalanceMensual()+" a modificarse");
	}
	
	public void eliminarBalanceMensual(long idBalanceMensual) throws Exception
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
