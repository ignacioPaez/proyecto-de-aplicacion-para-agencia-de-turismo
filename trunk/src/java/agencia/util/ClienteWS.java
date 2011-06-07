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
        cli.setApellido("Mino");
        cli.setNombre("Javier");
        cli.setUsuario("javier");
        cli.setPass("asd");
        cli.setNacionalidad("Argentina");
        ch.guardarCliente(cliente);        
    }
    
    @WebMethod(operationName = "eliminarCliente")
    public void eliminarCliente(int idCliente){
        ClienteHelper ch = new ClienteHelper();
        ch.eliminarCliente(idCliente);
    }
    
    @WebMethod(operationName = "obtenerCliente")
    public Cliente obtenerCliente(int idCliente){
        ClienteHelper ch = new ClienteHelper();
        return ch.obtenerCliente(idCliente);        
    }
}