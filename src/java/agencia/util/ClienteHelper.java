/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.util;

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
    
    public Boolean logCliente(String user, String pass){
        Boolean resultado=false;
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Cliente as cliente where cliente.usuario='"+user+"'");
            if (pass==(String)q.uniqueResult()){
                resultado = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultado;
    }
    
}
