/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.util;

import agencia.entity.Cliente;
import agencia.entity.Servicio;
import java.awt.List;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Zero
 */
@WebService(serviceName = "ClienteLiviano")
public class ClienteLiviano {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "log")
    public Boolean log(@WebParam(name = "usuario")
    String usuario, @WebParam(name = "pass") String pass) {
        ClienteHelper ch = new ClienteHelper();
       return ch.obtenerClientePorUsuario(usuario).getPass().equals(pass);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "guardarCliente")
    @Oneway
    public void guardarCliente(Cliente cli) {
        ClienteHelper ch = new ClienteHelper();
        ch.guardarCliente(cli);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listarServicios")
    public List listarServicios() {
        ServicioHelper sh = new ServicioHelper();
        return (List) sh.listarServicio();
    }

    /**
     * Web service operation
     */
   /*
    @WebMethod(operationName = "listarServicios")
    public org.hibernate.mapping.List listarServicios() {
        ServicioHelper sh = new ServicioHelper();
        return sh.listarServicio();
    }
    */
    

}
