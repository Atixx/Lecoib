package datos;

public class Solicitud 
{
	private long idSolicitud;
	private boolean estado;
	private Jornada JornadaTitular;
	private Jornada JornadaReemplazante;
	private Empleado Autoriza;
	private boolean confirmaReemplazante;
	
	public Solicitud(){}
	
	public Solicitud(Jornada idJornadaTitular, Jornada idJornadaReemplazante, Empleado idAutoriza)
	{
		super();
		this.estado = false;
		this.JornadaTitular = idJornadaTitular; 
		this.JornadaReemplazante = idJornadaReemplazante;
		this.Autoriza = idAutoriza;
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
		return JornadaTitular;
	}

	public void setIdJornadaTitular(Jornada JornadaTitular) 
	{
		this.JornadaTitular = JornadaTitular;
	}

	public Jornada getIdJornadaReemplazante()
	{
		return JornadaReemplazante;
	}

	public void setIdJornadaReemplazante(Jornada JornadaReemplazante) 
	{
		this.JornadaReemplazante = JornadaReemplazante;
	}

	public Empleado getIdAutoriza() 
	{
		return Autoriza;
	}

	public void setIdAutoriza(Empleado Autoriza) 
	{
		this.Autoriza = Autoriza;
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
