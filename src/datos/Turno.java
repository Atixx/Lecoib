package datos;

import java.util.GregorianCalendar;
import java.util.Set;

public class Turno 
{
	
	private int idTurno;
	private String turno;
	private String horaInicio;
	private String horaFin;
	private int cupos;
	private Set<Jornada> jornadas;
	private Set<Empleado> empleados;
	
	public Turno(){}
	
	public Turno(String turno, String horaInicio, String horaFin)
	{
		super();
		this.turno = turno;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}
	
	public int getIdTurno()
	{
		return this.idTurno;
	}
	
	protected void setIdTurno(int idTurno) 
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

	public String getHoraInicio()
	{
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) 
	{
		this.horaInicio = horaInicio;
	}

	public String getHoraFin()
	{
		return horaFin;
	}

	public void setHoraFin(String horaFin) 
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
	
	public Set<Jornada> getJornadas()
	{
		return jornadas;
	}

	public void setJornadas(Set<Jornada> jornadas)
	{
		this.jornadas = jornadas;
	}

	public Set<Empleado> getEmpleados()
	{
		return empleados;
	}

	public void setEmpleados(Set<Empleado> empleados)
	{
		this.empleados = empleados;
	}

	public String toString()
	{
		return idTurno+" "+turno+" "+horaInicio+" "+horaFin+" "+cupos;
	}
	
	
	
	
	

}
