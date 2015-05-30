package test;

import java.util.GregorianCalendar;

import modelo.Funciones;
import negocio.CategoriaABM;
import negocio.EmpleadoABM;
import negocio.JornadaABM;
import negocio.TurnoABM;
import datos.Categoria;
import datos.Empleado;
import datos.GrupoTrabajo;
import datos.Turno;

public class TestAgregarTurno
{

	public static void main(String[] args)
	{
		try
		{
		//GregorianCalendar fecha = Funciones.traerFecha("13/02/2015");
		//GregorianCalendar ingreso = Funciones.traerFecha("1/1/2015");
			
			
		Turno turno = new Turno("Noche", inicio, fin);
		TurnoABM turnoAbm  = new TurnoABM();
		int idTurno = turnoAbm.agregarTurno("MA", "10:00", "18:00");
		System.out.println(idTurno);
		/*Categoria categoria = new Categoria("Agente", 4000);
		GrupoTrabajo grupo = new GrupoTrabajo("SuperNonos");*/
		Empleado empleado = new Empleado("Levy", "Maor", 34564345, ingreso, "email@example.com", categoria, turno, grupo);*/
		JornadaABM jornadaAbm = new JornadaABM();
		GregorianCalendar fecha = new GregorianCalendar(2015,12,01):
		int idJornada = jornadaAbm.agregarJornada(, empleado, turno);
		EmpleadoABM empleadoAbm = new EmpleadoABM();
		int idEmpleado;
			idEmpleado = empleadoAbm.agregarEmpleado("Levy", "Maor", 34564345, ingreso, "email@example.com", categoria, turno, grupo);
			System.out.println(idEmpleado); */
		/*CategoriaABM catAbm = new CategoriaABM();
		int idCat = catAbm.agregarCategoria("Nomb", 3000);
		System.out.println(idCat);*/
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
