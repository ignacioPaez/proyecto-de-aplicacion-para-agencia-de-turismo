/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.util;

import agencia.entity.Cliente;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 *
 * @author javier
 */
@WebService(serviceName = "ClientePesadoWS")
public class ClientePesadoWS {

    /** This is a sample web service operation */
    @WebMethod(operationName = "litarClientes")
    public List<Cliente> lsitarClientes() {
        ClienteHelper ch = new ClienteHelper();
        return ch.listarClientes();
    }
}
