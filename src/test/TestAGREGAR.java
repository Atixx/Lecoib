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
			/*BalanceMensualABM bmAbm = new BalanceMensualABM();
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
			GestionSolicitud sAbm = new GestionSolicitud();			
			Solicitud s = new Solicitud();
			TurnoABM tAbm = new TurnoABM();
			Turno t = new Turno();*/
		    UsuarioABM uAbm = new UsuarioABM();
		    Usuario u = uAbm.traerUsuario(1);
		    System.out.println(u);
		    
		    
		    
		    
//		    GregorianCalendar fechaDeIngreso = Funciones.traerFecha("01/07/2013");
//		    GregorianCalendar mesAnio = (GregorianCalendar)GregorianCalendar.getInstance();
		    //Categoria cTest = new Categoria("TEST",666);
		    //Turno tTest = new Turno("xx","01:00","05:00");
		    //GrupoTrabajo gTest = new GrupoTrabajo("TESTEO");
		    //Empleado eTest = new Empleado("TESTEO","TESTEO",11111111,fechaDeIngreso,"aaa@a.com", cTest, tTest, gTest);
		    
		    /*int idCat = cAbm.agregarCategoria("Obrero", 10000);
		    System.out.println("Nro CAT: "+idCat+"\n\n");		    
		    c = cAbm.traerCategoria(idCat);
		    System.out.println("La Categoria es"+c+"\n\n");
		    int idGrupo1 = gtAbm.agregarGrupoTrabajo("nerds");
		    System.out.println("Nro Grupo: "+idGrupo1+"\n\n");
		    gt = gtAbm.traerGrupoTrabajo(idGrupo1);
		    System.out.println("El Grupo de Trabajo es:"+gt+"\n\n");*/	    
		    //e = eAbm.traerEmpleado(11111111);
		    //System.out.println("El empleado es:"+e+"\n\n");		    
		    //lo mapea, pero se necesita empleado y por ahora entra en conflicto, pero mapea.
		    /*int idF = fAbm.agregarFicha(mesAnio, e);
		    System.out.println("Nro Ficha: "+idF+"\n\n");*/	    
		    /*unica, sirve una vez y anduvo
		    int idBM = bmAbm.agregarBalanceMensual(mesAnio, e);		    
		    System.out.println("Nro Balance Mensual: "+idBM+"\n\n");
		    int idTurno = tAbm.agregarTurno("AA","10:00","18:00");
		    System.out.println("Nro Turno: "+idTurno+"\n\n"); 
		    t = tAbm.traerTurno(idTurno);
		    System.out.println("El turno es"+t+"\n\n");*/
		   
		    /*
		    c = cAbm.traerCategoria(3);
		    System.out.println("La Categoria es"+c+"\n\n");
		   
		    gt = gtAbm.traerGrupoTrabajo(2);
		    System.out.println("GT es"+gt+"\n\n");
		    
		    t = tAbm.traerTurno(1);
		    System.out.println("Turno es"+t+"\n\n");*/
		    //int idJ1 = jAbm.agregarJornada(mesAnio, e, t);		    
		    //System.out.println("Nro Jornada2: "+idJ1+"\n\n");		    
		    //no impacta en bd, por lo tanto usuario tampoco
		    
		    //int idEmp = eAbm.agregarEmpleado("nionio","pepe",dni, fechaDeIngreso, "niope@aol.com", c, t, gt);
		    //System.out.println("Nro empl:"+idEmp+"\n\n");


		    //long dni = 31554934;		    
		    //e = eAbm.traerEmpleado(2);
		    //System.out.println("El empleado es:"+e+"\n\n");
		    
		    
		    
		    //int idUser = uAbm.agregarUsuario("Usr", "1234", fechaDeIngreso, mesAnio, 1,e);
		    //System.out.println("Nro User: "+idUser+"\n\n");		    
		   
		    /*
		    
		     
		    int idT2 = tAbm.agregarTurno("MA","06:00","14:00");
		    System.out.println("Nro Turno 2: "+idT2+"\n\n");	
		    int idE = eAbm.agregarEmpleado("mayor", "nerd", 37999993, fechaDeIngreso, "asd@aol.com", c, t, gt);
		    System.out.println("Nro Empl: "+idE+"\n\n");
		    
		    e = eAbm.traerEmpleado(idE);
		    System.out.println("El Empleado1 es:"+e+"\n\n");		    
		    
		    *//*
		    j = jAbm.traerJornada(idJ1);
		    System.out.println("La Jornada1 es:"+j+"\n\n");	
		    Turno t2 = tAbm.traerTurno(idT2);
		    System.out.println("El Turno2 es:"+t2+"\n\n");	
		    
		    
		    int idJ2 = jAbm.agregarJornada(mesAnio, e2, t2);
		    System.out.println("Nro Jornada2: "+idJ2+"\n\n");
		    Jornada j2 = jAbm.traerJornada(idJ2); 
		    System.out.println("La Jornada2 es:"+j2+"\n\n");	
		    int idS = sAbm.agregarSolicitud(j,/* j2,*//* e);	  
		    System.out.println("Nro Solicitud: "+idS+"\n\n");
		    s = sAbm.traerSolicitud(idS);
		    System.out.println("La Solicitud es:"+s+"\n\n");
		   	*/
		    /*        
		    System.out.println("El id del turno es:"+idTurno+"\n\n");
		    Turno turno = tAbm.traerTurno(idTurno);
		    System.out.println("El turno es"+turno);
		    */
		    
			
	    } 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}	
	
}
