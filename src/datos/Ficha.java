package datos;

import java.util.GregorianCalendar;
import modelo.Funciones;

public class Ficha 
{
	private int idFicha;
	private GregorianCalendar diaHora;
	private boolean entradaSalida;// 0-false = salida; 1-true=entrada
	private Empleado empleado;
	
	public Ficha(){}
	
	public Ficha(GregorianCalendar diaHora, Empleado empleado, boolean entradaSalida)
	{
		super();
		this.diaHora = diaHora;
		this.entradaSalida = entradaSalida;//entrada true, salida false
		this.empleado = empleado;
	}
	
	public int getIdFicha()
	{
		return this.idFicha;
	}
	
	protected void setIdFicha(int idFicha) 
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
		return "idFicha: "+idFicha+" Dia Hora: "+Funciones.traerFechaHoraLarga(diaHora)+" Entrada: "+entradaSalida;
	}
	
	protected  int calcularCodigoVerificador(long dni){
		String dniS = Long.toString(dni);
		int dniArray[]={0,0,0,0,0,0,0,0,0};
		for(int i=0; i<dniS.length(); i++){
			dniArray[i] = Integer.parseInt(dniS.substring(i,i+1));
		}
		int sumaDni = 0, resultadoMultiParcial = 0;
		for(int i=0; i<(dniArray.length) ; i++){
			if(i%2==0){resultadoMultiParcial = dniArray[i] * 2;}
			else{resultadoMultiParcial = dniArray[i];}
			sumaDni += resultadoMultiParcial;
		}
		int codigo = Funciones.obtenerUltimoDigito(sumaDni);
		return codigo;
	}
	
	public boolean esCodigoValido(long dni, int codVerificado){
		boolean es = false;
		if(calcularCodigoVerificador(dni)==codVerificado)es = true;
		return es;
	}
}
