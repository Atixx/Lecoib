package negocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import modelo.Funciones;
import dao.BalanceMensualDao;
import datos.BalanceMensual;
import datos.Empleado;
import datos.Ficha;



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
		BalanceMensual bm = new BalanceMensual(mesAnio, empleado);
		bm.setHorasTrabajadas(hsTrabEmplPorMes(empleado, Funciones.traerMes(mesAnio)));
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
	        throw new Exception("No existen balances mensuales en la base de datos");
	    }
	    return lista;
	}		
	
	public int hsTrabEmplPorMes(Empleado empleado, int mes) throws Exception
	{
		FichaABM fAbm = new FichaABM();
		float suma = 0; 
		int horaEntrada = 0, horaSalida, minutosEntrada = 0, minutosSalida,num;		
		List<Ficha> lista = fAbm.traerFichasDeEmpleado(empleado.getIdEmpleado());		
		for(Ficha f : lista)
		{
			if(( Funciones.traerMes(f.getDiaHora()) == mes))
			{	
				if(f.isEntradaSalida()==true)
				{
					horaEntrada = f.getDiaHora().get(Calendar.HOUR_OF_DAY);
					minutosEntrada = f.getDiaHora().get(Calendar.MINUTE);
				}
				else if(f.isEntradaSalida()==false)
				{
					horaSalida = f.getDiaHora().get(Calendar.HOUR_OF_DAY);
					minutosSalida= f.getDiaHora().get(Calendar.MINUTE);
					
					if((minutosSalida-minutosEntrada) < 0)
					{
						suma =suma+(minutosSalida+60-minutosEntrada)+((horaSalida-1-horaEntrada)*60);
					}
					else
					{
						suma = suma+(minutosSalida-minutosEntrada)+((horaSalida-horaEntrada)*60); 
					}				
				}
			}
		}	
		suma= suma/60;
		num = Math.round(suma); 
		return num;
			
	}		
		
	public float promedioHsTrabPorMes(int mes) throws Exception
	{	//TODO: 
		BalanceMensualABM bmAbm = new BalanceMensualABM();
		float suma= 0, promedio = 0;
		List<BalanceMensual> lista = bmAbm.traerBalanceMensual();		
		for (BalanceMensual bm : lista)
		{
			suma = suma +bm.getHorasTrabajadas();
		}
		promedio = suma/(lista.size());
		return promedio;
	}
	/*
	public int generarBalcanceMensual(Empleado empleado) throws Exception
	{
		int idBM = 0;
		boolean bandera = false;
		GregorianCalendar mesAnio = new GregorianCalendar();
		List<BalanceMensual> lista = new ArrayList<BalanceMensual>();
		lista = bmDao.traerBalanceMensual();		
		if(lista==null)
		{
			idBM = agregarBalanceMensual(mesAnio,empleado);
			
		}
		else	
		{
			for( BalanceMensual bm : lista)
			{
				if((bm.getMesAnio().get(Calendar.MONTH) == mesAnio.get(Calendar.MONTH))
										&& ( bm.getMesAnio().get(Calendar.YEAR) == mesAnio.get(Calendar.YEAR))) 
				{
					bandera = true;
					idBM = bm.getIdBalanceMensual();
				}
			}
			if(bandera == false)
			{
				idBM = agregarBalanceMensual(mesAnio,empleado);
			}
			
		}
		return idBM;
	}
	*/
	public int generarBalcanceMensual(int mes, int anio, Empleado empleado) throws Exception
	{
		int idBM;
		GregorianCalendar mesAnio = Funciones.traerFecha(anio, mes, 1);
		List<BalanceMensual> lista = new ArrayList<BalanceMensual>();
		Empleado e = empleado;
		lista = bmDao.traerBalanceMensualPorEmpl(e.getIdEmpleado());	
		
		if(lista==null || lista.isEmpty())
		{
			idBM = agregarBalanceMensual(mesAnio, e);			
		}
		else	
		{
			for( BalanceMensual bm : lista)
			{
				if((Funciones.traerMes(bm.getMesAnio()) == mes) && ( Funciones.traerMes(bm.getMesAnio()) == anio)) 
				{
					throw new Exception("Ya existe un Balance Mensual. No puede generarse uno nuevo");
				}
			}
			idBM = agregarBalanceMensual(mesAnio, e);
		
			
		}
		return idBM;
	}
	
	public BalanceMensual visualizarBalanceMensual(int mes, int anio, Empleado empleado) throws Exception
	{
		BalanceMensual bm = new BalanceMensual();
		List<BalanceMensual> lista = new ArrayList<BalanceMensual>();
		lista = bmDao.traerBalanceMensualPorEmpl(empleado.getIdEmpleado());
		for(BalanceMensual bm2 : lista)
		{
			if((Funciones.traerMes(bm.getMesAnio()) == mes) && ( Funciones.traerMes(bm.getMesAnio()) == anio))
			{					
				bm = bmDao.traerBalanceMensual(bm.getIdBalanceMensual());
			}
		}
		
		return bm;
	}
}
