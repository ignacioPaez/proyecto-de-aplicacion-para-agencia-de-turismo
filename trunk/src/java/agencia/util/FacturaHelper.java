/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.util;

import agencia.entity.Factura;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author javier
 */
public class FacturaHelper {
    Session session = null;
    
    public FacturaHelper(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
       
    public List<Factura> listarFactura(){
        List<Factura> listaFacturas = null;
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Factura");
            listaFacturas = (List<Factura>)  q.list();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return listaFacturas;
    }
    
    public void guardarFactura(Factura factura){
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            session.persist(factura);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public void eliminarFacturaPorID(int idFactura){
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Factura factura where factura.idFactura='"+idFactura+"'");
            session.delete(q.uniqueResult());
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
        public Factura obtenerFacturaPorID(int idFactura){
            Factura cli = null;
            try{
                org.hibernate.Transaction tx = session.beginTransaction();
                Query q = session.createQuery("from Factura factura where factura.idFactura='"+idFactura+"'");
                cli = (Factura) q.uniqueResult();                
        }catch(Exception e){
            e.printStackTrace();
        }
            return cli;
    }
        /*
         * esta mal definida el tipo de datos con el que trabaja idcliente aca
         */
  public List<Factura>  obtenerFacturaPorIDCliente ( int idCliente){
      List<Factura> listaFac = null;
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Factura fac where fac.idcliente=: idCliente ");
            listaFac = listaFac = (List<Factura>) q.list();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return listaFac;
    }      
}
