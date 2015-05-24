package datos;

import java.util.GregorianCalendar;

public class Jornada 
{
	private int idJornada;
	private GregorianCalendar fecha;
	private Empleado empleado;
	private Turno turno;
	
	public Jornada(){}
	
	public Jornada(GregorianCalendar fecha, Empleado empleado, Turno turno)
	{
		super();
		this.fecha = fecha;
		this.empleado = empleado;
		this.turno = turno;
	}
	

	public int getIdJornada()
	{
		return this.idJornada;
	}
	
	protected void setIdJornada( int idJornada) 
	{
		this.idJornada = idJornada;
	}

	public GregorianCalendar getFecha() 
	{
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha)
	{
		this.fecha = fecha;
	}

	public Empleado getEmpleado()
	{
		return empleado;
	}

	public void setEmpleado(Empleado empleado)
	{
		this.empleado = empleado;
	}

	public Turno getTurno() 
	{
		return turno;
	}

	public void setTurno(Turno turno)
	{
		this.turno = turno;
	}
	
	public String toString()
	{
		return idJornada+" "+fecha+" "+empleado+" "+turno;
	}
	
	
	

}