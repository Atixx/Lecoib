package datos;


import java.util.Set;

import datos.Empleado;

public class GrupoTrabajo
{
	private int idGrupo;
	private String nombreGrupo;
	
	private Set<Empleado> empleados;
	
	public GrupoTrabajo(){}
	
	public GrupoTrabajo(String nombreGrupo)
	{
		super();
		this.nombreGrupo = nombreGrupo;		
	}
	
	public int getidGrupo()
	{
		return this.idGrupo;
	}
	
	protected void setidGrupo( int idGrupo) 
	{
		this.idGrupo = idGrupo;
	}

	public String getNombreGrupo() {
		return nombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	
	public Set<Empleado> getEmpleados()
	{
	    return this.empleados;
	}
	public void setEmpleados(Set<Empleado> empleados)
	{
	    this.empleados = empleados;
	}
	
	public String toString()
	{
		return idGrupo+nombreGrupo+empleados; //ver bien
	}
	
	
}
