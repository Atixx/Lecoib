package negocio;

import java.util.GregorianCalendar;

import dao.TurnoDao;
import datos.Turno;

public class TurnoABM
{
	TurnoDao dao = new TurnoDao();
	
	public Turno traerTurno(long idTurno) throws Exception
	{
		Turno t = dao.traerTurno(idTurno);
		return t;
	}
	
	public int agregarTurno(String turno, String horaInicio, String horaFin)
	{
		Turno t = new Turno(turno, horaInicio, horaFin);
		return dao.agregar(t);
	}
	
	public void modificarTurno(Turno t)
	{
		dao.actualizar(t);
	}
}
