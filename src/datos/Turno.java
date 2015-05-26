package datos;

import java.util.GregorianCalendar;

public class Turno 
{
	
	private long idTurno;
	private String turno;
	private GregorianCalendar horaInicio;
	private GregorianCalendar horaFin;
	private int cupos;
	
	public Turno(){}
	
	public Turno(String turno, GregorianCalendar horaInicio, GregorianCalendar horaFin)
	{
		super();
		this.turno = turno;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}
	
	public long getIdTurno()
	{
		return this.idTurno;
	}
	
	protected void setIdTurno(long idTurno) 
	{
		this.idTurno = idTurno;
	}

	public String getTurno() 
	{
		return turno;
	}

	public void setTurno(String turno)
	{
		this.turno = turno;
	}

	public GregorianCalendar getHoraInicio()
	{
		return horaInicio;
	}

	public void setHoraInicio(GregorianCalendar horaInicio) 
	{
		this.horaInicio = horaInicio;
	}

	public GregorianCalendar getHoraFin()
	{
		return horaFin;
	}

	public void setHoraFin(GregorianCalendar horaFin) 
	{
		this.horaFin = horaFin;
	}

	public int getCupos()
	{
		return cupos;
	}

	public void setCupos(int cupos) 
	{
		this.cupos = cupos;
	}
	
	public String toString()
	{
		return idTurno+" "+turno+" "+horaInicio+" "+horaFin+" "+cupos;
	}
	
	
	
	
	

}
