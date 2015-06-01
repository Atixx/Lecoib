package datos;

import java.util.Set;

public class Categoria 
{
	private int idCategoria;
	private String nombreCat;
	private float sueldoBasico;
	
	private Set<Empleado> empleados;
	
	public Categoria(){}
	
	public Categoria(String nombreCat, float sueldoBasico)
	{
		super();
		this.nombreCat = nombreCat;
		this.sueldoBasico = sueldoBasico;
	}
	
	public int getIdCategoria()
	{
		return this.idCategoria;
	}
	
	protected void setIdCategoria( int idCategoria) 
	{
		this.idCategoria = idCategoria;		
	}

	public String getNombreCat()
	{
		return nombreCat;
	}

	public void setNombreCat(String nombreCat)
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
		return idCategoria+" "+nombreCat+" "+sueldoBasico;
	}
	
	
}
