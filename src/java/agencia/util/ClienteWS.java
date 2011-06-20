/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.util;

import agencia.entity.Cliente;
import agencia.entity.Proveedor;
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

  /* This is a sample web service operation */
  /*
   *@WebMethod(operationName = "logCliente")
   *public int logCliente(@WebParam(name = "user") String user,@WebParam(name = "pass") String pass) {
   *   ClienteHelper ch = new ClienteHelper();
   *   return ch.logCliente(user, pass);
   *}
   */
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
    
    @WebMethod(operationName = "listarProveedores")
    public List<Proveedor> listarProveedores() {
        ProveedorHelper ch = new ProveedorHelper();
        return ch.listarProveedores();
    }
    
    @WebMethod(operationName = "obtenerProveedorPorID")
    public Proveedor obtenerProveedorPorID(int idProveedor){
        ProveedorHelper ph = new ProveedorHelper();
        return ph.obtenerProveedorPorID(idProveedor);        
    }
    
    @WebMethod(operationName = "guardarProveedor")
    public void guardarProveedor(Proveedor proveedor) {
        ProveedorHelper ph = new ProveedorHelper();
        Proveedor pro = new Proveedor();
        ph.guardarProveedor(proveedor);        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "logProveedor")
    public Boolean logProveedor(@WebParam(name = "usuario")
    String usuario, @WebParam(name = "pass")String pass) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "logCliente")
    public int loCliente(@WebParam(name = "usuario")
    String usuario) {
        ClienteHelper ch = new ClienteHelper();
       return ch.obtenerClientePorUsuario(usuario).getIdCliente();
    }
}
