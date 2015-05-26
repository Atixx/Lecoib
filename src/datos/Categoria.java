package datos;

public class Categoria 
{
	private long idCategoria;
	private String nombre;
	private float sueldoBasico;
	
	public Categoria(){}
	
	public Categoria(String nombre, float sueldoBasico)
	{
		super();
		this.nombre = nombre;
		this.sueldoBasico = sueldoBasico;
	}
	
	public long getIdCategoria()
	{
		return this.idCategoria;
	}
	
	protected void setIdCategoria( long idCategoria) 
	{
		this.idCategoria = idCategoria;		
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public float getSueldoBasico()
	{
		return sueldoBasico;
	}

	public void setSueldoBasico(float sueldoBasico)
	{
		this.sueldoBasico = sueldoBasico;
	}
	
	public String toString()
	{
		return idCategoria+" "+nombre+" "+sueldoBasico;
	}
	
	
}
