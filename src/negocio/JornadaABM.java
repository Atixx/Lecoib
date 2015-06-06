package negocio;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;

import modelo.Funciones;
import dao.JornadaDao;
import negocio.EmpleadoABM;
import datos.Empleado;
import datos.Jornada;
import datos.Turno;

public class JornadaABM
{
	JornadaDao dao = new JornadaDao();
	
	public Jornada traerJornada(int idJornada) throws Exception
	{
		Jornada j = dao.traerJornada(idJornada);
		if (j == null)
		{
		    throw new Exception("No se encontro la jornada con ID: "+idJornada);
		}
		return j;
	}
	
	public int agregarJornada(GregorianCalendar fecha, Empleado empleado, Turno turno)
	{
		Jornada j = new Jornada(fecha, empleado, turno);
		return dao.agregar(j);
	}
	
	public void generarJornadasMes(int mes, int anio)throws Exception {
		//para cada los turno levanta los empleados y da de alta jornadas
		//TODO: Hay que checkear los cupos?
		GregorianCalendar fecha = new GregorianCalendar(anio, mes, 1);
		if(Funciones.esFechaFutura(fecha)){
			EmpleadoABM eABM = new EmpleadoABM();
			List<Empleado> lstEmpleados = eABM.traerEmpleado();
			List<Empleado> lstSupMA = new ArrayList<Empleado>();
			List<Empleado> lstSupTA = new ArrayList<Empleado>();
			List<Empleado> lstSupNO = new ArrayList<Empleado>();
			List<Empleado> lstOpMA = new ArrayList<Empleado>();
			List<Empleado> lstOpTA= new ArrayList<Empleado>();
			List<Empleado> lstOpNO = new ArrayList<Empleado>();

			for(Empleado e : lstEmpleados){
				if(e.getCategoria().getIdCategoria() == 1) { // idCategoria=1 es supervisor
					if(e.getTurno().getTurno().equals("MA")) lstSupMA.add(e);
					else if(e.getTurno().getTurno().equals("TA")) lstSupTA.add(e);
					else if(e.getTurno().getTurno().equals("NO")) lstSupNO.add(e);
				}
				if(e.getCategoria().getIdCategoria() == 2) { // idCategoria=2 es operario
					if(e.getTurno().getTurno().equals("MA")) lstOpMA.add(e);
					else if(e.getTurno().getTurno().equals("TA")) lstOpTA.add(e);
					else if(e.getTurno().getTurno().equals("NO")) lstOpNO.add(e);
				}
			}
			
			asignaJornada(lstSupMA, mes, anio);
			asignaJornada(lstSupTA, mes, anio);
			asignaJornada(lstSupNO, mes, anio);
			asignaJornada(lstOpMA, mes, anio);
			asignaJornada(lstOpTA, mes, anio);
			asignaJornada(lstOpNO, mes, anio);			
		}
		else {//mes anio pasaron o es el mes actual
			throw new Exception ("Error: La fecha ingresada es incorrecta");
		}
	}

	public void generarJornadasMes()throws Exception 
	{
		//Alta automatica de jornadas
		GregorianCalendar fecha = new GregorianCalendar();
		String turno;
		int grupo;
		EmpleadoABM eABM = new EmpleadoABM();
		List<Empleado> lstEmpleados = eABM.traerEmpleado();		
		List<Empleado> lstGrupo = new ArrayList<Empleado>();

		for(Empleado e : lstEmpleados)
		{
			//Primer empleado pivote
			turno = e.getTurno().getTurno();
			grupo = e.getGrupoTrabajo().getidGrupo();
			lstGrupo.add(e);
			lstEmpleados.remove(e);
			for(Empleado e1 : lstEmpleados)
			{
				if (e1.getGrupoTrabajo().getidGrupo() == grupo)
				{
					lstGrupo.add(e1);
					lstEmpleados.remove(e1);
				}
				
			}
			//Aca deberia tener un grupo completo para asignar jornadas
			asignaJornada(lstGrupo, Funciones.traerMes(fecha), Funciones.traerAnio(fecha));
		}
					
	}
	
	
	public void asignaJornada(List<Empleado> lstEmpleado, int mes, int anio) throws Exception{
		//Aprovecho el método pero debo hacerle modificaciones
		int mesPasado = mes;
		int anioPasado = anio;
		int checkFranco = 0;
		int diaComienzo = 1;
		
		//Evaluo si existe jornada mes anterior o es primera
		if (mes == 1)//Prueba obligatoria para que no pinche en Enero
		{
			anioPasado = anio-1;
		}else{mesPasado = mesPasado -1;}
		
		GregorianCalendar fechaMesPasado = new GregorianCalendar(anioPasado, mesPasado, Funciones.traerCantDiasDeUnMes(mesPasado, anioPasado));
		if (evaluarMesAnterior(fechaMesPasado) == true)
		{
			//Aca tiene que hacer todo el lio para continuar el mes anterior del grupo
			
		}
		else //Debe determinar donde comenzar (Si hay otro grupo asignado buscar Franco)
		{
			boolean listo = false;
			while (listo == false)
			{
				GregorianCalendar fechaJornadaEvaluar = new GregorianCalendar(anio, mes, diaComienzo);
				List<Jornada> lstjornadasEvaluar = traerJornadasPorFecha(fechaJornadaEvaluar);
				if (lstjornadasEvaluar != null)
				{
					int z = 1;
					boolean pasar = false;
					while ( z <= lstjornadasEvaluar.size() && pasar == false)
					{
						if ( lstjornadasEvaluar.get(z).getTurno() == lstEmpleado.get(1).getTurno())
						{
							diaComienzo++;
							pasar = true;
						}
					}
					if (pasar == false)
					{
						listo =true;
					}
				}else{listo=true;}
				if (diaComienzo >= Funciones.traerCantDiasDeUnMes(mes, anio))
				{
					listo=true;
					diaComienzo=1;
				}
			}
		}
		for(Empleado e : lstEmpleado)
		{
			for(int i=diaComienzo; i<=Funciones.traerCantDiasDeUnMes(mes, anio); i++){
				//asigno jornada
				GregorianCalendar fechaJornada = new GregorianCalendar(anio, mes, i);
				Jornada jornada = new Jornada(fechaJornada, e, e.getTurno());
				dao.agregar(jornada);
				checkFranco++;//cada 4 dias asignados hace 2 saltos de dia
				if(checkFranco==4) {
					i =+2;
					checkFranco = 0;
				}
			}
		}
	}
	
	private boolean evaluarMesAnterior(GregorianCalendar fechaMesAnterior) throws Exception
	{
		boolean resultado = false;
		if ((traerJornadasPorFecha(fechaMesAnterior)) != null)
		{
			resultado = true;
		}
		return resultado;
	}
	
	public void modificarJornada(Jornada j) throws Exception
	{
		if (dao.traerJornada(j.getIdJornada()) == null)
		{
			throw new Exception("No existe la jornada con ID "+j.getIdJornada()+" para modificar");
		}
		dao.actualizar(j);
	}
	
	public List<Jornada> traerJornadaEmpleado(int idEmpleado) throws Exception
	{
		List<Jornada> j = null;
		j = dao.traerJornadaEmpleado(idEmpleado);
		if (j == null)
		{
		    throw new Exception("No se encontraron jornadas para el empleado con ID: "+idEmpleado);
		}
		return j;
	}
	
	
	public List<Jornada> traerJornadasFuturasEmpleado(int idEmpleado) throws Exception
	{
		List<Jornada> j = null;
		j = dao.traerJornadasFuturasEmpleado(idEmpleado);
		if (j == null)
		{
		    throw new Exception("No se encontraron jornadas para el empleado con ID: "+idEmpleado);
		}
		return j;
	}
	
	public List<Jornada> traerJornadasFuturas() throws Exception
	{
		List<Jornada> j = null;
		j = dao.traerJornadasFuturas();
		if (j == null)
		{
		    throw new Exception("No se encontraron jornadas futuras");
		}
		return j;
	}
	
	public List<Jornada> traerJornadasPorFecha(GregorianCalendar fecha) throws Exception
	{
		List<Jornada> j = null;
		j = dao.traerJornadasPorFecha(fecha);
		if (j == null)
		{
		    throw new Exception("No se encontraron jornadas en la fecha");
		}
		return j;
	}
	
	public Jornada traerJornadasPorFecha(GregorianCalendar fecha, int idEmpleado, int idTurno) throws Exception
	{
		Jornada j = null;
		j = dao.traerJornadasPorFecha(fecha, idEmpleado, idTurno);
		if (j == null)
		{
		    throw new Exception("No se encontraron jornadas en la fecha");
		}
		return j;
	}
	
}
