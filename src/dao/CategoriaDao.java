package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Categoria;

public class CategoriaDao 
{
	private static Session session;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos", he);
    }

    public int agregar(Categoria objeto) 
    {
        int id = 0;
        try {
            iniciaOperacion();
            id = Integer.parseInt(session.save(objeto).toString());
            tx.commit();
        }
        catch (HibernateException he) 
        {
            manejaExcepcion(he);
            throw he;
        } finally 
        {
            session.close();
           
        }
        return id;
    }
    
    public void actualizar(Categoria objeto) throws HibernateException {
        try 
        {
            iniciaOperacion();
            session.update(objeto);
            tx.commit();
        } 
        catch (HibernateException he) 
        {
            manejaExcepcion(he);
            throw he;
        } 
        finally 
        {
            session.close();
        }
    }

    public void eliminar(Categoria objeto) throws HibernateException {
        try 
        {
            iniciaOperacion();
            session.delete(objeto);
            tx.commit();
        } 
        catch (HibernateException he) 
        {
            manejaExcepcion(he);
            throw he;
        } 
        finally 
        {
            session.close();
        }
    }

	    public Categoria traerCategoria(long idCategoria) throws HibernateException {
        Categoria objeto = null;
        try {
            iniciaOperacion();
            objeto = (Categoria) session.get(Categoria.class, idCategoria);
        } finally {
            session.close();
        }
        return objeto;
    }
    @SuppressWarnings("unchecked")
    public List<Categoria> traerCategoria() throws HibernateException 
    {
    	List<Categoria> lista=null;
        try 
        {
            iniciaOperacion();                    
            lista=session.createQuery("from Categoria c order by c.nombreCat asc").list();
           
        } 
        finally {
            session.close();
        }

        return lista;
    }
    

}
