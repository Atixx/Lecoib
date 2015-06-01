package negocio;

import java.util.GregorianCalendar;

import dao.JornadaDao;
import datos.Empleado;
import datos.Jornada;
import datos.Turno;

public class JornadaABM
{
	JornadaDao dao = new JornadaDao();
	
	public Jornada traerJornada(int idJornada) throws Exception
	{
		Jornada j = dao.traerJornada(idJornada);
		if (j == null)
		{
		    throw new Exception("No se encontro la jornada con ID: "+idJornada);
		}
		return j;
	}
	
	public int agregarJornada(GregorianCalendar fecha, Empleado empleado, Turno turno)
	{
		Jornada j = new Jornada(fecha, empleado, turno);
		return dao.agregar(j);
	}
	
	public void modificarJornada(Jornada j) throws Exception
	{
		if (dao.traerJornada(j.getIdJornada()) == null)
		{
			throw new Exception("No existe la jornada con ID "+j.getIdJornada()+" para modificar");
		}
		dao.actualizar(j);
	}
}
