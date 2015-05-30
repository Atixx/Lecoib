package datos;

import java.util.GregorianCalendar;
import java.util.Set;


//import java.util.Set;
import modelo.Funciones;

public class Empleado 
{
	private long idEmpleado;
	private String apellido;
	private String nombre;
	private int dni;
	private GregorianCalendar fechaDeIngreso;
	private String email;
	private Categoria categoria;
	private Turno turno;
	private GrupoTrabajo grupo;
	private boolean baja;
	private Usuario usuario;
	
	//attribute para hibernate
	//private Set<---> ---;
	
	private Set<Ficha> fichas;
	private Set<BalanceMensual> balancesMensuales;
	
	public Empleado()
	{
	}
	
	public Empleado(String apellido, String nombre, int dni, GregorianCalendar fechaDeIngreso, String email, Categoria categoria, Turno turno, GrupoTrabajo grupo, Usuario usuario)
	{
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.fechaDeIngreso = fechaDeIngreso;
		this.email = email;
		this.categoria = categoria;
		this.turno = turno;
		this.grupo = grupo;		
		this.baja = false;
		this.usuario = usuario;
	}
	
	public long getIdEmpleado()
	{
		return this.idEmpleado;
	}
	
	protected void setIdEmpleado( long idEmpleado) 
	{
		this.idEmpleado = idEmpleado;
	}
	
	public String getApellido() 
	{
		return apellido;
	}
	
	public void setApellido(String apellido) 
	{
		this.apellido = apellido;
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	public long getDni() 
	{
		return dni;
	}
	public void setDni(int dni) 
	{
		this.dni = dni;
	}
	
	public GregorianCalendar getFechaDeIngreso()
	{
		return fechaDeIngreso;
	}
	
	public void setFechaDeIngreso(GregorianCalendar fechaDeIngreso)
	{
		this.fechaDeIngreso = fechaDeIngreso;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email =email;
	}
	
	public Categoria getCategoria() 
	{
		return categoria;
	}

	public void setCategoria(Categoria categoria) 
	{
		this.categoria = categoria;
	}

	public Turno getTurno() 
	{
		return turno;
	}

	public void setTurno(Turno turno) 
	{
		this.turno = turno;
	}

	public GrupoTrabajo getGrupo() 
	{
		return grupo;
	}

	public void setGrupo(GrupoTrabajo grupo) 
	{
		this.grupo = grupo;
	}

	public boolean isBaja() 
	{
		return baja;
	}
	
	public void setBaja(boolean baja) 
	{
		this.baja = baja;
	}
		
	public Usuario getUsuario()
	{
		return usuario;
	}

	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}

	public String toString()
	{
		return idEmpleado+" "+apellido+" "+nombre+" DNI: "+dni+" Fecha de Ingreso: "+Funciones.traerFechaCorta(fechaDeIngreso)+" "+baja;
	}
	
	public Set<Ficha> getFichas()
	{
	    return this.fichas;
	}
	public void setFichas(Set<Ficha> fichas)
	{
	    this.fichas = fichas;
	}
	
	public Set<BalanceMensual> getBalancesMensuales()
	{
	    return this.balancesMensuales;
	}
	public void setBalancesMensuales(Set<BalanceMensual> balancesMensuales)
	{
	    this.balancesMensuales = balancesMensuales;
	}
}
