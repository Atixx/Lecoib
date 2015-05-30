package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.BalanceMensual;

public class BalanceMensualDao 
{
	private static Session session;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException 
    {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException 
    {
        tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos", he);
    }

    public int agregar(BalanceMensual objeto) 
    {
        int id = 0;
        try 
        {
            iniciaOperacion();
            id = Integer.parseInt(session.save(objeto).toString());
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
        return id;
    }
    
    public void actualizar(BalanceMensual objeto) throws HibernateException 
    {
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

    public void eliminar(BalanceMensual objeto) throws HibernateException 
    {
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

    public BalanceMensual traerBalanceMensual(long idBalanceMensual) throws HibernateException 
    {
        BalanceMensual objeto = null;
        try 
        {
            iniciaOperacion();
            objeto = (BalanceMensual) session.get(BalanceMensual.class, idBalanceMensual);
        } 
        finally 
        {
            session.close();
        }
        return objeto;
    }
    
	    
    @SuppressWarnings("unchecked")
    public List<BalanceMensual> traerBalanceMensual() throws HibernateException 
    {
    	List<BalanceMensual> lista=null;
        try 
        {
            iniciaOperacion();                    
            lista=session.createQuery("from Empleado c order by c.apellido asc c.nombre asc").list();
           
        } 
        finally 
        {
            session.close();
        }

        return lista;
    }
}
