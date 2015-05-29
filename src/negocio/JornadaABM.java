package negocio;

import java.util.GregorianCalendar;

import dao.JornadaDao;
import datos.Empleado;
import datos.Jornada;
import datos.Turno;

public class JornadaABM
{
	JornadaDao dao = new JornadaDao();
	
	public Jornada traerJornada(long idJornada) throws Exception
	{
		Jornada j = dao.traerJornada(idJornada);
		return j;
	}
	
	public int agregarJornada(GregorianCalendar fecha, Empleado empleado, Turno turno)
	{
		Jornada j = new Jornada(fecha, empleado, turno);
		return dao.agregar(j);
	}
	
	public void modificarJornada(Jornada j)
	{
		dao.actualizar(j);
	}
}
