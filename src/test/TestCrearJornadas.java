package test;

import java.util.GregorianCalendar;
import datos.Jornada;
import java.util.List;
import datos.Categoria;
import datos.Empleado;
import datos.GrupoTrabajo;
import datos.Turno;
import modelo.Funciones;
import negocio.CategoriaABM;
import negocio.EmpleadoABM;
import negocio.GrupoTrabajoABM;
import negocio.JornadaABM;
import negocio.TurnoABM;

public class TestCrearJornadas
{

	public static void main(String[] args)
	{
		try
		{
		/*CategoriaABM cAbm = new CategoriaABM();
		EmpleadoABM eAbm = new EmpleadoABM();
		TurnoABM tAbm = new TurnoABM();
		GrupoTrabajoABM gAbm = new GrupoTrabajoABM();
		Categoria cat = cAbm.traerCategoria(2);
		Turno tur = tAbm.traerTurno(3);
		GrupoTrabajo gru = gAbm.traerGrupoTrabajo(1);
		eAbm.agregarEmpleado("Levy", "Maor", 93781483, Funciones.traerFecha("01/02/2005"), "maor@example.com", cat , tur, gru);
		eAbm.agregarEmpleado("Irione", "Ara", 12345678, Funciones.traerFecha("01/02/2008"), "ara@example.com", cat , tur, gru);*/
			
			JornadaABM jAbm = new JornadaABM();
			jAbm.generarJornadasMes();
//			GregorianCalendar fechaJornadaEvaluar = new GregorianCalendar(2015, 5, 1);
//			List <Jornada> jorn = jAbm.traerJornadasPorFecha(fechaJornadaEvaluar);
//			System.out.println(Funciones.traerMes(fechaJornadaEvaluar));
//			
//			for (Jornada j : jorn)
//			{
//				System.out.println(j);
//			}
			//EmpleadoABM eAbm = new EmpleadoABM();
			//Empleado emp = eAbm.traerEmpleado(1);
			//System.out.println(emp);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
