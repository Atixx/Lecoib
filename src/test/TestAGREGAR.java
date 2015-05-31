package test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import datos.*;
import modelo.Funciones;
import negocio.*;

public class TestAGREGAR 
{	
	public static void main(String[] args)
	{
		try
	    {
			BalanceMensualABM bmAbm = new BalanceMensualABM();
			BalanceMensual bm = new BalanceMensual();			
			CategoriaABM cAbm = new CategoriaABM();
			Categoria c = new Categoria();
			EmpleadoABM eAbm = new EmpleadoABM();		
			Empleado e = new Empleado();			
			FichaABM fAbm = new FichaABM();
			Ficha f = new Ficha();
			GrupoTrabajoABM gtAbm = new GrupoTrabajoABM();
			GrupoTrabajo gt = new GrupoTrabajo();
			JornadaABM jAbm = new JornadaABM();
			Jornada j = new Jornada();
			SolicitudABM sAbm = new SolicitudABM();			
			Solicitud s = new Solicitud();
			TurnoABM tAbm = new TurnoABM();
			Turno t = new Turno();
		    UsuarioABM uAbm = new UsuarioABM();
		    Usuario u = new Usuario();
		    
		    GregorianCalendar fechaDeIngreso = Funciones.traerFecha("2013/07/01");
		    GregorianCalendar mesAnio = (GregorianCalendar)GregorianCalendar.getInstance();
		    
		    int idCat = cAbm.agregarCategoria("Obrero", 10000);
		    System.out.println("Nro CAT: "+idCat+"\n\n");		    
		    /*int idTurno = tAbm.agregarTurno("NO","10:00","18:00");
		    System.out.println("Nro Turno: "+idTurno+"\n\n");
		    int idT2 = tAbm.agregarTurno("MA","06:00","14:00");
		    System.out.println("Nro Turno 2: "+idT2+"\n\n");
		    int idGrupo = gtAbm.agregarGrupoTrabajo("nerds");
		    System.out.println("Nro Grupo: "+idGrupo+"\n\n");*/
		    c = cAbm.traerCategoria(idCat);
		    System.out.println("La Categoria es"+c+"\n\n");
		    /*t = tAbm.traerTurno(idTurno);
		    System.out.println("El turno es"+t+"\n\n");
		    gt = gtAbm.traerGrupoTrabajo(idGrupo);
		    System.out.println("El Grupo de Trabajo es:"+gt+"\n\n");
		    int idE = eAbm.agregarEmpleado("mayor", "nerd", 37168453, fechaDeIngreso, "asd@aol.com", c, t, gt);
		    System.out.println("Nro Empl: "+idE+"\n\n");
		    e = eAbm.traerEmpleado(idE);
		    System.out.println("El Empleado1 es:"+e+"\n\n");		    
		    
		    int idBM = bmAbm.agregarBalanceMensual(mesAnio, e);		    
		    System.out.println("Nro Balance Mensual: "+idBM+"\n\n");
		    int idF = fAbm.agregarFicha(mesAnio, e);
		    System.out.println("Nro Ficha: "+idF+"\n\n");
		    int idJ1 = jAbm.agregarJornada(mesAnio, e, t);
		    System.out.println("Nro Jornada1: "+idJ1+"\n\n");
		    j = jAbm.traerJornada(idJ1);
		    System.out.println("La Jornada1 es:"+j+"\n\n");	
		    Turno t2 = tAbm.traerTurno(idT2);
		    System.out.println("El Turno2 es:"+t2+"\n\n");	
		    Empleado e2 = new Empleado("nionio","pepe",31566734, fechaDeIngreso, "niope@aol.com", c, t2, gt);
		    System.out.println("El Empleado2 es:"+e2+"\n\n");
		    
		    int idJ2 = jAbm.agregarJornada(mesAnio, e2, t2);
		    System.out.println("Nro Jornada2: "+idJ2+"\n\n");
		    Jornada j2 = jAbm.traerJornada(idJ2); 
		    System.out.println("La Jornada2 es:"+j2+"\n\n");	
		    int idS = sAbm.agregarSolicitud(j, j2, e);	  
		    System.out.println("Nro Solicitud: "+idS+"\n\n");
		    s = sAbm.traerSolicitud(idS);
		    System.out.println("La Solicitud es:"+s+"\n\n");
		   /* 	        
		    System.out.println("El id del turno es:"+idTurno+"\n\n");
		    turno = tAbm.traerTurno(idTurno);
		    System.out.println("El turno es"+turno);
		    */
		    
			
	    } 
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}	
	
}
