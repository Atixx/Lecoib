package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Empleado;

public class EmpleadoDao 
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

    public int agregar(Empleado objeto) 
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
    
    public void actualizar(Empleado objeto) throws HibernateException {
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

    public void eliminar(Empleado objeto) throws HibernateException {
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

	    public Empleado traerEmpleado(long idEmpleado) throws HibernateException {
        Empleado objeto = null;
        try {
            iniciaOperacion();
            objeto = (Empleado) session.get(Empleado.class, idEmpleado);
        } finally {
            session.close();
        }
        return objeto;
    }
    /*
    public Empleado traerEmpleado(int dni) throws HibernateException {
        Empleado objeto = null;
        try {
            iniciaOperacion();
            objeto = (Empleado) session.createQuery("from Empleado c where c.dni ="+dni).uniqueResult();
        } finally {
            session.close();
        }
        return objeto;
    }
    */
    @SuppressWarnings("unchecked")
    public List<Empleado> traerEmpleado() throws HibernateException 
    {
    	List<Empleado> lista=null;
        try 
        {
            iniciaOperacion();                    
            lista=session.createQuery("from Empleado c order by c.apellido asc c.nombre asc").list();
           
        } 
        finally {
            session.close();
        }

        return lista;
    }
    

}