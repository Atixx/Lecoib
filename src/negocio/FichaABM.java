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
	
	public int verificarFicha(int dni, int codVerificador)throws Exception{
		Ficha ficha = new Ficha();
		int idFicha = 0;
		if(ficha.esCodigoValido(dni,codVerificador)){
			//verificar entrada o salida (traerFichas(Empleado);
			EmpleadoABM eABM = new EmpleadoABM();
			Empleado e = eABM.traerEmpleado(dni);
			List<Ficha> lstFicha = new ArrayList<Ficha>();
			lstFicha = dao.traerFicha(e);
			int contFichas = 0;
			for(Ficha f : lstFicha){
				contFichas =+1;
			}
			boolean entradaSalida;
			if(contFichas%2==0) entradaSalida = true;//es entrada
			else entradaSalida = false; //es salida
			GregorianCalendar hoy = new GregorianCalendar();
			idFicha = agregarFicha(hoy, e, entradaSalida);
		}
		return idFicha; //devuelve 0 si no cargo
	}
	
	public int agregarFicha(GregorianCalendar diaHora, Empleado empleado, boolean entradaSalida) throws Exception
	{
		Ficha f = new Ficha(diaHora, empleado, entradaSalida);
		return dao.agregar(f);
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