/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.util;

import agencia.entity.Proveedor;
import org.hibernate.Session;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author javier
 */
public class ProveedorHelper {
    
    Session session = null;
    
    public ProveedorHelper(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
       
    public List<Proveedor> listarProveedor(){
        List<Proveedor> listaProveedores = null;
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Proveedor");
            listaProveedores = q.list();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return listaProveedores;
    }
    
    public void guardarProveedor(Proveedor proveedor){
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            session.persist(proveedor);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public void eliminarProveedorPorID(int idProveedor){
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Proveedor proveedor where proveedor.idProveedor='"+idProveedor+"'");
            session.delete(q.uniqueResult());
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
        public Proveedor obtenerProveedorPorID(int idProveedor){
            Proveedor cli = null;
            try{
                org.hibernate.Transaction tx = session.beginTransaction();
                Query q = session.createQuery("from Proveedor proveedor where proveedor.idProveedor='"+idProveedor+"'");
                cli = (Proveedor) q.uniqueResult();                
        }catch(Exception e){
            e.printStackTrace();
        }
            return cli;
    }
    
}
