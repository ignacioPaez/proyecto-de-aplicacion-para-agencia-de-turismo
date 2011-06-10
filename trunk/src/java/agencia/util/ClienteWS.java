/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.util;

import agencia.entity.Cliente;
import java.util.Calendar;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.List;

/**
 *
 * @author javier
 */
@WebService(serviceName = "ClienteWS")
public class ClienteWS {

    /** This is a sample web service operation */
    @WebMethod(operationName = "logCliente")
    public Boolean logCliente(@WebParam(name = "user") String user,@WebParam(name = "pass") String pass) {
        ClienteHelper ch = new ClienteHelper();
        return ch.logCliente(user, pass);
    }
    
    @WebMethod(operationName = "listarClientes")
    public List<Cliente> listarClientes() {
        ClienteHelper ch = new ClienteHelper();
        return ch.listarClientes();
    }
    
    @WebMethod(operationName = "guardarCliente")
    public void guardarCliente(Cliente cliente) {
        ClienteHelper ch = new ClienteHelper();
        Cliente cli = new Cliente();
        ch.guardarCliente(cliente);        
    }
    
    @WebMethod(operationName = "eliminarClientePorID")
    public void eliminarClientePorID(int idCliente){
        ClienteHelper ch = new ClienteHelper();
        ch.eliminarClientePorID(idCliente);
    }
    
    @WebMethod(operationName = "obtenerClientePorID")
    public Cliente obtenerClientePorID(int idCliente){
        ClienteHelper ch = new ClienteHelper();
        return ch.obtenerClientePorID(idCliente);        
    }
}
