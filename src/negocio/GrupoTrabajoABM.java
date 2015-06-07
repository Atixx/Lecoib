package negocio;

import java.util.List;

import dao.GrupoTrabajoDao;
import datos.Empleado;
import datos.GrupoTrabajo;


public class GrupoTrabajoABM 
{
	GrupoTrabajoDao dao = new GrupoTrabajoDao();
	
	public GrupoTrabajo traerGrupoTrabajo(int idGrupo) throws Exception
	{
		GrupoTrabajo g = dao.traerGrupoTrabajo(idGrupo);
		if (g == null)
		{
		    throw new Exception("No se encontro el grupo de trabajo con ID: "+idGrupo);
		}
		return g;
	}
	
	public int agregarGrupoTrabajo(String nombre)
	{
		GrupoTrabajo g = new GrupoTrabajo(nombre);
		return dao.agregar(g);
	}
	
	public void modificarGrupoTrabajo(GrupoTrabajo g) throws Exception
	{
		if (dao.traerGrupoTrabajo(g.getidGrupo()) == null)
		{
			throw new Exception("No existe el grupo de trabajo con ID "+g.getidGrupo()+" para modificar");
		}
		dao.actualizar(g);
	}
	
	public List<Empleado>traerListaEmpleados(int idGrupo) throws Exception
	{
		List<Empleado> lista = dao.traerListaEmpleados(idGrupo);
		if (lista == null)
		{
		    throw new Exception("No se encontraron empleados");
		}
		return lista;
	}
}
