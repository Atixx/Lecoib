package negocio;


import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import dao.CategoriaDao;
import datos.Categoria;

public class CategoriaABM 
{
	CategoriaDao cDao=new CategoriaDao();
	
	public Categoria traerCategoria(long idCategoria) throws Exception
	{
		Categoria c = cDao.traerCategoria(idCategoria);
	if (c == null)
		{
		    throw new Exception("No se encontro la categoria con ID: "+idCategoria);
		}
		return c;
	}	
	
	
	public int agregarCategoria(String nombre, float sueldoBasico) throws Exception
	{
	    Categoria c = new Categoria(nombre, sueldoBasico);
	    return cDao.agregar(c);
	    
	    
	}	
}
