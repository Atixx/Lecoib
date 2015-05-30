package negocio;

import dao.TurnoDao;
import datos.Turno;

public class TurnoABM
{
	TurnoDao dao = new TurnoDao();
	
	public Turno traerTurno(long idTurno) throws Exception
	{
		Turno t = dao.traerTurno(idTurno);
		if (t == null)
		{
		    throw new Exception("No se encontro el turno con ID: "+idTurno);
		}
		return t;
	}
	
	public int agregarTurno(String turno, String horaInicio, String horaFin)
	{
		Turno t = new Turno(turno, horaInicio, horaFin);
		return dao.agregar(t);
	}
	
	public void modificarTurno(Turno t) throws Exception
	{
		if (dao.traerTurno(t.getIdTurno()) == null)
		{
			throw new Exception("No existe el turno con ID "+t.getIdTurno()+" para modificar");
		}
		dao.actualizar(t);
	}
}
