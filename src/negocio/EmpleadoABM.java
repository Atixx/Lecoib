package negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import dao.EmpleadoDao;
import datos.Empleado;
import datos.Categoria;
import datos.GrupoTrabajo;
import datos.Turno;

public class EmpleadoABM 
{
	EmpleadoDao dao=new EmpleadoDao();
	
	public Empleado traerEmpleado(int idEmpleado) throws Exception
	{
		Empleado e = dao.traerEmpleado(idEmpleado);
		if (e == null)
		{
		    throw new Exception("No se encontro un empleado con ID: "+idEmpleado);
		}
		return e;
	}	
	
	public Empleado traerEmpleado(long dni) throws Exception
	{
		Empleado e = dao.traerEmpleado(dni);
		if (e == null)
		{
		    throw new Exception("No se econtro un empleado con DNI: "+dni);
		}
		return e;
	}
	
	public int agregarEmpleado(String apellido, String nombre, long dni, GregorianCalendar fechaDeIngreso,
			String email, Categoria categoria, Turno turno, GrupoTrabajo grupo) throws Exception
	{
	    Empleado e = dao.traerEmpleado(dni);
	    if (e != null)
	    {
	        throw new Exception("Ya existe el empleado con DNI numero: "+dni);
	    }
	    Empleado m = new Empleado(apellido, nombre, dni,fechaDeIngreso, email, categoria, turno, grupo);
	    return dao.agregar(m);
	}	

	public void modificarEmpleado(Empleado e) throws Exception
	{
		
	    List<Empleado> lista = traerEmpleado();
	    
	    for (Empleado t : lista)
	    {
	        if (t.getDni() == e.getDni()) 
	        {
	        	
	            if (t.getIdEmpleado() == e.getIdEmpleado())
	            {
	            	dao.actualizar(e);
	            }
	            else
	            {
	                throw new Exception("Ya existe un empleado con el DNI: "+e.getDni()+"bajo otro ID");
	            }
	        }
	    }
		dao.actualizar(e);
	}
	
	public void eliminarEmpleado(int idEmpleado) throws Exception
	{
		
		Empleado e = dao.traerEmpleado(idEmpleado);
		if (e == null)
		{
		    throw new Exception("No existe empleado con ID: "+idEmpleado+" para eliminar");
		}
		dao.eliminar(e);
	}
	
	public List<Empleado> traerEmpleado() throws Exception
	{
	    List<Empleado> lista = new ArrayList<Empleado>();
	    lista = dao.traerEmpleado();
	    if (lista == null || lista.isEmpty())
	    {
	        throw new Exception("No existen empleados en la base de datos");
	    }
	    return lista;
	}
	
}
