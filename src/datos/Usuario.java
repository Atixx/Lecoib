package datos;

import java.util.GregorianCalendar;

public class Usuario 
{
	//TODO:atributos	
	private int idUsuario;
	private String nombreUsr;
	private String clave;
	private GregorianCalendar ultimoCambioClave;
	private GregorianCalendar ultimaSesion;
	private boolean baja;
	private int privilegio;
	private Empleado empleado;
	
	
	public Usuario() 
	{	
	}
	
	public Usuario(String nombreUsr, String clave, GregorianCalendar ultimoCambioClave,
								GregorianCalendar ultimaSesion, int privilegio, Empleado empleado)
	{
		super();
		this.nombreUsr = nombreUsr;		
		this.clave = clave;
		this.ultimoCambioClave = ultimoCambioClave;
		this.ultimaSesion = ultimaSesion;
		this.baja = false;
		this.privilegio = privilegio;
		this.empleado = empleado;
	}
	
	public int getIdUsuario()
	{
		return this.idUsuario;
	}
	
	protected void setIdUsuario(int idUsuario) 
	{
		this.idUsuario = idUsuario;
	}
		
	public String getNombreUsr() 
	{
		return nombreUsr;
	}

	public void setNombreUsr(String nombreUsr) 
	{
		this.nombreUsr = nombreUsr;
	}
	//TODO:definir clave
	public String getClave() 
	{
		return clave;
	}

	public void setClave(String clave) 
	{
		this.clave = clave;
	}

	public GregorianCalendar getUltimoCambioClave() 
	{
		return ultimoCambioClave;
	}
	//TODO:definir setters para ultimoCambioClave y ultimaSesion
	public void setUltimoCambioClave(GregorianCalendar ultimoCambioClave) 
	{
		this.ultimoCambioClave = ultimoCambioClave;
	}

	public GregorianCalendar getUltimaSesion() 
	{
		return ultimaSesion;
	}

	public void setUltimaSesion(GregorianCalendar ultimaSesion) 
	{
		this.ultimaSesion = ultimaSesion;
	}

	public boolean isBaja() 
	{
		return baja;
	}

	public void setBaja(boolean baja) 
	{
		this.baja = baja;
	}

	public int getPrivilegio() 
	{
		return privilegio;
	}

	public void setPrivilegio(int privilegio) 
	{
		this.privilegio = privilegio;
	}
	public Empleado getEmpleado()
	{
		return empleado;
	}

	public void setEmpleado(Empleado empleado) 
	{
		this.empleado = empleado;
	}

	//TODO: completar metodo toString
	public String toString()
	{
		return (idUsuario+" "+nombreUsr+" "/*y resto*/);
	}

}
