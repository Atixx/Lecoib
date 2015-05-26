package datos;

import java.util.GregorianCalendar;

public class Ficha 
{
	private long idFicha;
	private GregorianCalendar diaHora;
	private boolean entradaSalida;
	private Empleado empleado;
	
	public Ficha(){}
	
	public Ficha(GregorianCalendar diaHora, Empleado empleado)
	{
		super();
		this.diaHora = diaHora;
		this.entradaSalida = true;
		this.empleado = empleado;
	}
	
	public long getIdFicha()
	{
		return this.idFicha;
	}
	
	protected void setIdFicha(long idFicha) 
	{
		this.idFicha = idFicha;
	}

	public GregorianCalendar getDiaHora() {
		return diaHora;
	}

	public void setDiaHora(GregorianCalendar diaHora) {
		this.diaHora = diaHora;
	}

	public boolean isEntradaSalida() {
		return entradaSalida;
	}

	public void setEntradaSalida(boolean entradaSalida) {
		this.entradaSalida = entradaSalida;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	public String toString()
	{
		return idFicha+" "+diaHora+" "+entradaSalida+" "+empleado;
	}
}
