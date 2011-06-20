/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.util;

import agencia.entity.LineaFactura;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author javier
 */
public class LineaFacturaHelper {
    Session session = null;
    
    public LineaFacturaHelper(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
       
    public List<LineaFactura> listarLineaFactura(){
        List<LineaFactura> listaLineasFactura = null;
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from LineaFactura");
            listaLineasFactura = (List<LineaFactura>) q.list();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return listaLineasFactura;
    }
    
    public void guardarLineaFactura(LineaFactura lineaFactura){
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            session.persist(lineaFactura);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public void eliminarLineaFacturaPorID(int idLineaFactura){
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from LineaFactura lineaFactura where lineaFactura.idLineaFactura='"+idLineaFactura+"'");
            session.delete(q.uniqueResult());
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
        public LineaFactura obtenerLineaFacturaPorID(int idLineaFactura){
            LineaFactura cli = null;
            try{
                org.hibernate.Transaction tx = session.beginTransaction();
                Query q = session.createQuery("from LineaFactura lineaFactura where lineaFactura.idLineaFactura='"+idLineaFactura+"'");
                cli = (LineaFactura) q.uniqueResult();                
        }catch(Exception e){
            e.printStackTrace();
        }
            return cli;
    }
    
}
