package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Turno;

public class TurnoDao 
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

    public int agregar(Turno objeto) 
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
    
    public void actualizar(Turno objeto) throws HibernateException {
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
    
    public void eliminar(Turno objeto) throws HibernateException {
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
    
    public Turno traerTurno(int idTurno) throws HibernateException 
    {
        Turno objeto = null;
        try {
            iniciaOperacion();
            objeto = (Turno) session.get(Turno.class, idTurno);
        } finally {
            session.close();
        }
        return objeto;
    }
        
    public List<Turno> traerTurno() throws HibernateException 
    {
    	List<Turno> lista=null;
        try 
        {
            iniciaOperacion();                    
            lista=session.createQuery("from Turno t order by t.turno asc").list();
           
        } 
        finally {
            session.close();
        }

        return lista;
    }
    
}
