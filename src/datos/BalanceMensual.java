package datos;

import java.util.GregorianCalendar;

public class BalanceMensual
{
	private int idBalanceMensual;
	private int horasTrabajadas;
	private GregorianCalendar mesAnio;
	private Empleado empleado;	
	
	public BalanceMensual(){}
	
	public BalanceMensual(GregorianCalendar mesAnio, Empleado empleado)
	{
		super();
		this.horasTrabajadas= 0;
		this.mesAnio = mesAnio;
		this.empleado = empleado;
	}
	
	public long getIdBalanceMensual()
	{
		return this.idBalanceMensual;
	}
	
	protected void setIdBalanceMensual(int idBalanceMensual) 
	{
		this.idBalanceMensual = idBalanceMensual;
	}

	public int getHorasTrabajadas() 
	{
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(int horasTrabajadas) 
	{
		this.horasTrabajadas = horasTrabajadas;
	}

	public GregorianCalendar getMesAnio()
	{
		return mesAnio;
	}

	public void setMesAnio(GregorianCalendar mesAnio)
	{
		this.mesAnio = mesAnio;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	public String toString()
	{
		return idBalanceMensual+" "+horasTrabajadas+" "+mesAnio+" "+empleado;
	}
}
