package test;
import modelo.Funciones;
import java.util.GregorianCalendar;
public class TestFecahFutura {

	public static void main(String[] args) {
		GregorianCalendar fecha = Funciones.traerFecha("31/05/2015");
		System.out.println(Funciones.esFechaFutura(fecha));
	}

}
