package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Ficha;

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

    public int agregar(Ficha objeto) 
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
    
    public void actualizar(Ficha objeto) throws HibernateException {
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
    
    public void eliminar(Ficha objeto) throws HibernateException {
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
    
    public Turno traerFicha(long idFicha) throws HibernateException 
    {
        Ficha objeto = null;
        try {
            iniciaOperacion();
            objeto = (Ficha) session.get(Ficha.class, idFicha);
        } finally {
            session.close();
        }
        return objeto;
    }
        
    public List<Ficha> traerFicha() throws HibernateException 
    {
    	List<Ficha> lista=null;
        try 
        {
            iniciaOperacion();                    
            lista=session.createQuery("from Ficha f order by f.idEmpleado asc f.diaHora asc").list();
           
        } 
        finally {
            session.close();
        }

        return lista;
    }
    
}