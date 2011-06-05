/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.util;

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
    public List listarClientes() {
        ClienteHelper ch = new ClienteHelper();
        return ch.listarClientes();
    }
}
