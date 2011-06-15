/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.util;

import agencia.entity.Cliente;
import java.util.List;
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
    
    public int logCliente(String usuario, String pass){
        Cliente logueado = new Cliente();
        Boolean respuesta = false;
        int id = 9999;
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Cliente cliente where cliente.usuario='"+usuario+"'");
            logueado = (Cliente)q.uniqueResult();
            id = logueado.getIdCliente();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        //if(logueado!=null){
        //    respuesta = (logueado.getPass().equals(pass));
        //}       
        return id;
    }
    
    public List<Cliente> listarClientes(){
        List<Cliente> listaClientes = null;
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Cliente");
            listaClientes = (List<Cliente>) q.list();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
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
        }
    }
    
    public void eliminarClientePorID(int idCliente){
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Cliente cliente where cliente.idCliente='"+idCliente+"'");
            session.delete(q.uniqueResult());
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
        public Cliente obtenerClientePorID(int idCliente){
            Cliente cli = null;
            try{
                org.hibernate.Transaction tx = session.beginTransaction();
                Query q = session.createQuery("from Cliente cliente where cliente.idCliente='"+idCliente+"'");
                cli = (Cliente) q.uniqueResult();                
        }catch(Exception e){
            e.printStackTrace();
        }
            return cli;
        }
        public Cliente obtenerClientePorUsuario(String usuario){
            Cliente cli = new Cliente();
            try{
                org.hibernate.Transaction tx = session.beginTransaction();
                Query q = session.createQuery("from Cliente cliente where cliente.usuario=:usuario");
                q.setString(usuario, usuario);
                cli = (Cliente) q.uniqueResult();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                session.close();
            }
            return cli;
        }
    
}
