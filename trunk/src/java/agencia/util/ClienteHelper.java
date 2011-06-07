/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.util;

import agencia.entity.Cliente;
import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;

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
        Boolean respuesta = false;
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Cliente cliente where cliente.usuario='"+usuario+"'");
            logueado = (Cliente)q.uniqueResult();            
        }catch (Exception e){
            e.printStackTrace();
        }
        if(logueado!=null){
            respuesta = (logueado.getPass().equals(pass));
        }       
        return respuesta;
    }
    
    public List<Cliente> listarClientes(){
        List<Cliente> listaClientes = null;
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Cliente");
            listaClientes = q.list();
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaClientes;
    }
    
    public void guardarCliente(Cliente cliente){
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            session.persist(cliente);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }
    
    public void eliminarCliente(int idCliente){
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Cliente cliente where cliente.idCliente='"+idCliente+"'");
            session.delete(q.uniqueResult());
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
    }
    
    public Cliente obtenerCliente(int idCliente){
        Cliente cliente= null;
        try{
            org.hibernate.Transaction tx = session.getTransaction();
            Query q = session.createQuery("from Cliente cliente where cliente.idCliente='"+idCliente+"'");
            cliente = (Cliente) q.uniqueResult();
        }catch(Exception e){
            e.printStackTrace();
        }
        return cliente;
    }
}
