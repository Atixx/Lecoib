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
					if(e.getTurno().getTurno()=="MA") lstSupMA.add(e);
					else if(e.getTurno().getTurno()=="TA") lstSupTA.add(e);
					else if(e.getTurno().getTurno()=="NO") lstSupNO.add(e);
				}
				if(e.getCategoria().getIdCategoria() == 2) { // idCategoria=2 es operario
					if(e.getTurno().getTurno()=="MA") lstOpMA.add(e);
					else if(e.getTurno().getTurno()=="TA") lstOpTA.add(e);
					else if(e.getTurno().getTurno()=="NO") lstOpNO.add(e);
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
	
	public void asignaJornada(List<Empleado> lstEmpleado, int mes, int anio){
		for(Empleado e : lstEmpleado){
			int checkFranco = 0;
			for(int i=1; i<=Funciones.traerCantDiasDeUnMes(mes, anio); i++){
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
	
	public void modificarJornada(Jornada j) throws Exception
	{
		if (dao.traerJornada(j.getIdJornada()) == null)
		{
			throw new Exception("No existe la jornada con ID "+j.getIdJornada()+" para modificar");
		}
		dao.actualizar(j);
	}
	
}
