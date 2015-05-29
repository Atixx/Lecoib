package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Solicitud;


public class SolicitudDao
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

    public int agregar(Solicitud objeto) 
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
    
    public void actualizar(Solicitud objeto) throws HibernateException {
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

    public void eliminar(Solicitud objeto) throws HibernateException {
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

	    public Solicitud traerSolicitud(long idSolicitud) throws HibernateException {
        Solicitud objeto = null;
        try {
            iniciaOperacion();
            objeto = (Solicitud) session.get(Solicitud.class, idSolicitud);
        } finally {
            session.close();
        }
        return objeto;
    }
        
    //TODO: Tiene que traer todas las Solicitud por fecha (y empleado?)
    @SuppressWarnings("unchecked")
    public List<Solicitud> traerSolicitud() throws HibernateException 
    {
    	List<Solicitud> lista=null;
        try 
        {
            iniciaOperacion();                    
            lista=session.createQuery("from Solicitud j order by j.fecha asc").list();
           
        } 
        finally {
            session.close();
        }

        return lista;
    }
    
}
