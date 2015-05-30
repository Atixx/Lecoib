package datos;

public class Categoria 
{
	private long idCategoria;
	private String nombreCat;
	private float sueldoBasico;
	
	public Categoria(){}
	
	public Categoria(String nombreCat, float sueldoBasico)
	{
		super();
		this.nombreCat = nombreCat;
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

	public String getnombreCat()
	{
		return nombreCat;
	}

	public void setnombreCat(String nombreCat)
	{
		this.nombreCat = nombreCat;
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
		return idCategoria+" "+nombreCat+" "+sueldoBasico;
	}
	
	
}
