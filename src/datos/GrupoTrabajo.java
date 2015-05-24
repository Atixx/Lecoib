package datos;

import java.util.ArrayList;
import java.util.List;

public class GrupoTrabajo
{
	private int idGrupoTrabajo;
	private String nombreGrupo;
	private List<Empleado> empleados = new ArrayList<Empleado>();
	
	public GrupoTrabajo(){}
	
	public GrupoTrabajo(String nombreGrupo)
	{
		super();
		this.nombreGrupo = nombreGrupo;		
	}
	
	public int getIdGrupoTrabajo()
	{
		return this.idGrupoTrabajo;
	}
	
	protected void setIdGrupoTrabajo( int idGrupoTrabajo) 
	{
		this.idGrupoTrabajo = idGrupoTrabajo;
	}

	public String getNombreGrupo() {
		return nombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	public List<Empleado> getEmpleados() 
	{
		return empleados;
	}	
	
	//TODO:definir lista empleados
	
	public String toString()
	{
		return idGrupoTrabajo+nombreGrupo+empleados; //ver bien
	}
	
	
}