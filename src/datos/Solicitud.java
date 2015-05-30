package datos;

public class Solicitud 
{
	private long idSolicitud;
	private boolean estado;
	private Jornada jornadaTitular;
	private Jornada jornadaReemplazante;
	private Empleado autoriza;
	private boolean confirmaReemplazante;
	
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
	
	public long getIdSolicitud()
	{
		return this.idSolicitud;
	}
	
	protected void setIdSolicitud( long idSolicitud) 
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

	public Jornada getIdJornadaTitular()
	{
		return jornadaTitular;
	}

	public void setIdJornadaTitular(Jornada jornadaTitular) 
	{
		this.jornadaTitular = jornadaTitular;
	}

	public Jornada getIdJornadaReemplazante()
	{
		return jornadaReemplazante;
	}

	public void setIdJornadaReemplazante(Jornada jornadaReemplazante) 
	{
		this.jornadaReemplazante = jornadaReemplazante;
	}

	public Empleado getIdAutoriza() 
	{
		return autoriza;
	}

	public void setIdAutoriza(Empleado autoriza) 
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
