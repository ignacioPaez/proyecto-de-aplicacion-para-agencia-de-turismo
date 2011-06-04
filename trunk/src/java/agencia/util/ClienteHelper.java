/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.util;

import agencia.entity.Cliente;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author javier
 */
public class ClienteHelper {
    
    Session session = null;
    
    public ClienteHelper(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public Boolean logCliente(String usuario, String pass){
        Cliente logueado = new Cliente();
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Cliente cliente where cliente.usuario='"+usuario+"'");
            logueado = (Cliente)q.uniqueResult();            
        }catch (Exception e){
            e.printStackTrace();
        }
        return (logueado.getPass().equals(pass));
    }
    
}
