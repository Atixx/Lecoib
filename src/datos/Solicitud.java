package datos;

//import java.util.Set;

public class Solicitud 
{
	private int idSolicitud;
	private boolean estado;
	private Empleado autoriza;
	private boolean confirmaReemplazante;
	
	private Jornada jornadaTitular;
	private Jornada jornadaReemplazante;
	//private Set<Jornada> jornadas;
	
	public Solicitud(){}
	
	public Solicitud(Jornada jornadaTitular, Jornada jornadaReemplazante, Empleado autoriza)
	{
		super();
		this.estado = false;
		this.jornadaTitular = jornadaTitular; 
		this.jornadaReemplazante = jornadaReemplazante;
		this.autoriza = autoriza;
		this.confirmaReemplazante = false;
	}
	
	public int getIdSolicitud()
	{
		return this.idSolicitud;
	}
	
	protected void setIdSolicitud( int idSolicitud) 
	{
		this.idSolicitud = idSolicitud;
	}

	public boolean isEstado() 
	{
		return estado;
	}

	public void setEstado(boolean estado) 
	{
		this.estado = estado;
	}
/*	
	public Set<Jornada> getJornadas()
	{
	    return this.jornadas;
	}
	public void setJornadas(Set<Jornada> jornadas)
	{
	    this.jornadas = jornadas;
	}
*/
	public Jornada getJornadaTitular()
	{
		return jornadaTitular;
	}

	public void setJornadaTitular(Jornada jornadaTitular) 
	{
		this.jornadaTitular = jornadaTitular;
	}

	public Jornada getJornadaReemplazante()
	{
		return jornadaReemplazante;
	}
	
	public void setJornadaReemplazante(Jornada jornadaReemplazante) 
	{
		this.jornadaReemplazante = jornadaReemplazante;
	}

	public Empleado getAutoriza() 
	{
		return autoriza;
	}

	public void setAutoriza(Empleado autoriza) 
	{
		this.autoriza = autoriza;
	}

	public boolean isConfirmaReemplazante() 
	{
		return confirmaReemplazante;
	}

	public void setConfirmaReemplazante(boolean confirmaReemplazante) 
	{
		this.confirmaReemplazante = confirmaReemplazante;
	}
	
	public String toString()
	{
		return "Solicitud nro.: "+idSolicitud+" "+"Estado: "+estado+"Personas involucradas: ---"+"A TERMINAR";
	}
	
}
