package negocio;



import dao.CategoriaDao;
import datos.Categoria;
import datos.Categoria;

public class CategoriaABM 
{
	CategoriaDao cDao=new CategoriaDao();
	
	public Categoria traerCategoria(int idCategoria) throws Exception
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
	

	public void modificarCategoria(Categoria d) throws Exception
	{
		if (cDao.traerCategoria(d.getIdCategoria()) == null)
	    {
            throw new Exception("No se encontro el Balance Mensual Id:"+d.getIdCategoria()+" a modificarse");	
        }
		cDao.actualizar(d);		
	}
	

	public void eliminarCategoria(int idCategoria) throws Exception
	{
		
		Categoria c = cDao.traerCategoria(idCategoria);
		if (c == null)
		{
		    throw new Exception("No existe la categoria con ID: "+idCategoria+" para eliminar");
		}
		cDao.eliminar(c);
	}
	
}
