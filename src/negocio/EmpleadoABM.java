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
	
	public Empleado traerEmpleado(long idEmpleado) throws Exception
	{
		Empleado e = dao.traerEmpleado(idEmpleado);
		if (e == null)
		{
		    throw new Exception("No se encontro un cliente con ID: "+idEmpleado);
		}
		return e;
	}	

	public Empleado traerEmpleado(int dni) throws Exception
	{
		Empleado e = dao.traerEmpleado(dni);
		if (e == null)
		{
		    throw new Exception("No se econtro un cliente con DNI: "+dni);
		}
		return e;
	}
	
	public int agregarEmpleado(String apellido, String nombre, int dni, GregorianCalendar fechaDeIngreso, String email, Categoria categoria, Turno turno, GrupoTrabajo grupo) throws Exception
	{
	    Empleado e = dao.traerEmpleado(dni);
	    if (e != null)
	    {
	        throw new Exception("Ya existe el cliente con DNI numero: "+dni);
	    }
	    Empleado m = new Empleado(apellido, nombre, dni,fechaDeIngreso, email, categoria, turno, grupo);
	    return dao.agregar(m);
	}	

	public void modificarEmpleado(Empleado e) throws Exception
	{
		/* implementar antes de actualizar que no exista un cliente con el mismo documento a modificar
		y con el mismo id, lanzar la Exception */
	    List<Empleado> lista = traerEmpleado();
	    for (Empleado t : lista)
	    {
	        if (t.getDni() == e.getDni()) //si es el mismo de documento, puedo actualizar solo si es el mismo ID
	        {
	            if (t.getIdEmpleado() == e.getIdEmpleado())
	            {
	                dao.actualizar(e);
	            }
	            else
	            {
	                throw new Exception("Ya existe un cliente con el DNI: "+e.getDni()+"bajo otro ID");
	            }
	        }
	    }
		dao.actualizar(e);
	}
	
	public void eliminarEmpleado(long idEmpleado) throws Exception
	{
		/*en este caso es física en gral. no se se
		aplicaría este caso de uso, si se hiciera habría que validar que el cliente no tenga
		dependencias*/
		Empleado e = dao.traerEmpleado(idEmpleado);
		if (e == null)
		{
		    throw new Exception("No existe cliente con ID: "+idEmpleado+" para eliminar");
		}
		dao.eliminar(e);
	}
	
	public List<Empleado> traerEmpleado() throws Exception
	{
	    List<Empleado> lista = new ArrayList<Empleado>();
	    lista = dao.traerEmpleado();
	    if (lista == null || lista.isEmpty())
	    {
	        throw new Exception("No existen clientes en la base de datos");
	    }
	    return lista;
	}
	
}
