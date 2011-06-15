/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.util;

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
    @WebMethod(operationName = "operation")
    public Boolean operation(@WebParam(name = "usuario")
    String usuario, @WebParam(name = "pass") String pass) {
        ClienteHelper ch = new ClienteHelper();
       return ch.obtenerClientePorUsuario(usuario).getPass().equals(pass);
    }
}
