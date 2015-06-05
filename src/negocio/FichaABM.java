package negocio;

import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.List;

import dao.FichaDao;
import datos.Empleado;
import datos.Ficha;
import datos.Jornada;
import datos.Ficha;

public class FichaABM 
{
	FichaDao dao = new FichaDao();
	
	public Ficha traerFicha(int idFicha) throws Exception
	{
	
		Ficha f = dao.traerFicha(idFicha);		
		
		if (f == null)
		{
		    throw new Exception("No se encontro la Ficha con ID: "+idFicha);	
		}
		return f;
	}
	
	public List<Ficha> traerFichaEmpleado(long dni) throws Exception
	{
		EmpleadoABM eABM = new EmpleadoABM();
		List<Ficha> lstFicha = new ArrayList<Ficha>();
		Empleado e = eABM.traerEmpleado(dni);
		
		lstFicha = dao.traerFichaEmpleado(e.getIdEmpleado());		
		
		if (lstFicha == null)
		{
		    throw new Exception("No se encontro la Ficha del empleado con Id: "+e.getIdEmpleado());	
		}
		return lstFicha;
	}
	
	public boolean verificarFicha(Empleado e)throws Exception
	{
		boolean entradaSalida = false;
		//verificar entrada o salida (traerFichas(Empleado);
		List<Ficha> lstFicha = new ArrayList<Ficha>();
		lstFicha = dao.traerFichaEmpleado(e.getIdEmpleado());
		int contFichas = 0;
		for(Ficha f : lstFicha){
			contFichas =+1;
		}
		if(contFichas%2==0) entradaSalida = true;//es entrada
		return entradaSalida; //devuelve 0 si no cargo
	}
	
	public int agregarFicha(long dni, int codigoVerificador) throws Exception
	{
		int idFicha = 0;
		Ficha ficha = new Ficha();
		if(ficha.esCodigoValido(dni,codigoVerificador)){
			GregorianCalendar hoy = new GregorianCalendar();
			EmpleadoABM eABM = new EmpleadoABM();
			Empleado e = eABM.traerEmpleado(dni);
			Ficha f = new Ficha(hoy, e, verificarFicha(e));
			idFicha = dao.agregar(f);
		}
		return idFicha; //devuelve 0 si no cargo
	}
		
	 
	public void modificarFicha(Ficha f) throws Exception
	{
		if (dao.traerFicha(f.getIdFicha()) == null)
	    {
            throw new Exception("No se encontro el Balance Mensual Id:"+f.getIdFicha()+" a modificarse");	
        }
		dao.actualizar(f);		
	}
	

	public void eliminarFicha(int idFicha) throws Exception
	{
		
		Ficha c = dao.traerFicha(idFicha);
		if (c == null)
		{
		    throw new Exception("No existe la Ficha con ID: "+idFicha+" para eliminar");
		}
		dao.eliminar(c);
	}	
}