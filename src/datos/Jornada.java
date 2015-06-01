package datos;

import java.util.GregorianCalendar;
import java.util.Set;

public class Jornada 
{
	private long idJornada;
	private GregorianCalendar fecha;
	private Empleado empleado;
	private Set<Solicitud> solicitudesTit;
	private Set<Solicitud> solicitudesReemp;
	//private Set<Turno> turnos;
	private Turno turno;

	public Jornada(){}
	
	public Jornada(GregorianCalendar fecha, Empleado empleado, Turno turno)
	{
		super();
		this.fecha = fecha;
		this.empleado = empleado;
		this.turno = turno;
	}
	

	public long getIdJornada()
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
	
	public Set<Solicitud> getSolicitudTit() {
		return solicitudesTit;
	}
	
	public void setSolicitudTit(Set<Solicitud> solicitudesTit) {
		this.solicitudesTit = solicitudesTit;
	}
	
	public Set<Solicitud> getSolicitudReemp() {
		return solicitudesReemp;
	}
	
	public void setSolicitudReemp(Set<Solicitud> solicitudesReemp) {
		this.solicitudesReemp = solicitudesReemp;
	}
	
	public String toString()
	{
		return idJornada+" "+fecha+" "+empleado+" "+turno;
	}
	
}
