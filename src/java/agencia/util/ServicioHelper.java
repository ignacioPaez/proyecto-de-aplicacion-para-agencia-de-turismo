/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.util;

import agencia.entity.Servicio;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author javier
 */
public class ServicioHelper {
    Session session = null;
    
    public ServicioHelper(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
       
    public List<Servicio> listarServicio(){
        List<Servicio> listaServicios = null;
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Servicio");
            listaServicios = q.list();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return listaServicios;
    }
    
    public void guardarServicio(Servicio servicio){
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            session.persist(servicio);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public void eliminarServicioPorID(int idServicio){
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Servicio servicio where servicio.idServicio='"+idServicio+"'");
            session.delete(q.uniqueResult());
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
        public Servicio obtenerServicioPorID(int idServicio){
            Servicio cli = null;
            try{
                org.hibernate.Transaction tx = session.beginTransaction();
                Query q = session.createQuery("from Servicio servicio where servicio.idServicio='"+idServicio+"'");
                cli = (Servicio) q.uniqueResult();                
        }catch(Exception e){
            e.printStackTrace();
        }
            return cli;
    }
}
