package negocio;

import java.util.GregorianCalendar;

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
	
	public int agregarFicha(GregorianCalendar diaHora, Empleado empleado) throws Exception
	{
		Ficha f = new Ficha(diaHora, empleado);
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