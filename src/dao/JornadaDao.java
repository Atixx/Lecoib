package dao;

import java.util.GregorianCalendar;
import java.util.List;

import modelo.Funciones;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Jornada;


public class JornadaDao 
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

    public int agregar(Jornada objeto) 
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
    
    public void actualizar(Jornada objeto) throws HibernateException {
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

    public void eliminar(Jornada objeto) throws HibernateException {
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

	    public Jornada traerJornada(int idJornada) throws HibernateException {
        Jornada objeto = null;
        try {
            iniciaOperacion();
            objeto = (Jornada) session.get(Jornada.class, idJornada);
        } finally {
            session.close();
        }
        return objeto;
    }
        
    //TODO: Tiene que traer todas las jornadas por fecha (y empleado?)
    @SuppressWarnings("unchecked")
    public List<Jornada> traerJornada() throws HibernateException 
    {
    	List<Jornada> lista=null;
        try 
        {
            iniciaOperacion();                    
            lista=session.createQuery("from Jornada j order by j.fecha asc").list();
           
        } 
        finally {
            session.close();
        }

        return lista;
    }
    
    @SuppressWarnings("unchecked")
    public List<Jornada> traerJornadaEmpleado(int idEmpleado) throws HibernateException 
    {
    	List<Jornada> lista=null;
        try 
        {
            iniciaOperacion();                    
            lista=session.createQuery("from Jornada j where idEmpleado="+idEmpleado+" order by j.fecha asc").list();
           
        } 
        finally {
            session.close();
        }

        return lista;
    }
    
    @SuppressWarnings("unchecked")
    public List<Jornada> traerJornadasFuturasEmpleado(int idEmpleado) throws HibernateException 
    {
    	List<Jornada> lista=null;
        try 
        {
            iniciaOperacion();                    
            lista=session.createQuery("from Jornada j where idEmpleado="+idEmpleado+" AND fecha > CURDATE() order by j.fecha asc").list();
           
        } 
        finally {
            session.close();
        }

        return lista;
    }
    
    @SuppressWarnings("unchecked")
    public List<Jornada> traerJornadasFuturas() throws HibernateException 
    {
    	List<Jornada> lista=null;
        try 
        {
            iniciaOperacion();                    
            lista=session.createQuery("from Jornada j where fecha > CURDATE() order by j.fecha asc").list();
           
        } 
        finally {
            session.close();
        }

        return lista;
    }

    
    @SuppressWarnings("unchecked")
    public List<Jornada> traerJornadasPorFecha(GregorianCalendar fecha) throws HibernateException 
    {
    	List<Jornada> lista=null;
        try 
        {
            iniciaOperacion();                    
            lista=session.createQuery("from Jornada j where fecha = '"+Funciones.traerFechaHQL(fecha)+"'").list();
           
        } 
        finally {
            session.close();
        }

        return lista;
    }
    
}
