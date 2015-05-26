package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.GrupoTrabajo;

public class GrupoTrabajoDao 
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

    public int agregar(GrupoTrabajo objeto) 
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
    
    public void actualizar(GrupoTrabajo objeto) throws HibernateException {
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

    public void eliminar(GrupoTrabajo objeto) throws HibernateException {
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

	    public GrupoTrabajo traerGrupoTrabajo(long idGrupoTrabajo) throws HibernateException {
        GrupoTrabajo objeto = null;
        try {
            iniciaOperacion();
            objeto = (GrupoTrabajo) session.get(GrupoTrabajo.class, idGrupoTrabajo);
        } finally {
            session.close();
        }
        return objeto;
    }
    @SuppressWarnings("unchecked")
    public List<GrupoTrabajo> traerGrupoTrabajo() throws HibernateException 
    {
    	List<GrupoTrabajo> lista=null;
        try 
        {
            iniciaOperacion();                    
            lista=session.createQuery("from GrupoTrabajo g order by g.nombreGrupo asc").list();
           
        } 
        finally {
            session.close();
        }

        return lista;
    }
    

}
