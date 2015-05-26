package datos;

//import datos.Jornada;

public class Solicitud 
{
	private long idSolicitud;
	private boolean estado;
	private int idJornadaTitular;
	private int idJornadaReemplazante;
	private int idAutoriza;
	private boolean confirmaReemplazante;
	
	public Solicitud(){}
	
	public Solicitud(int idJornadaTitular, int idJornadaReemplazante, int idAutoriza)
	{
		super();
		this.estado = false;
		this.idJornadaTitular = idJornadaTitular; 
		this.idJornadaReemplazante = idJornadaReemplazante;
		this.idAutoriza = idAutoriza;
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

	public int getIdJornadaTitular()
	{
		return idJornadaTitular;
	}

	public void setIdJornadaTitular(int idJornadaTitular) 
	{
		this.idJornadaTitular = idJornadaTitular;
	}

	public int getIdJornadaReemplazante()
	{
		return idJornadaReemplazante;
	}

	public void setIdJornadaReemplazante(int idJornadaReemplazante) 
	{
		this.idJornadaReemplazante = idJornadaReemplazante;
	}

	public int getIdAutoriza() 
	{
		return idAutoriza;
	}

	public void setIdAutoriza(int idAutoriza) 
	{
		this.idAutoriza = idAutoriza;
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
