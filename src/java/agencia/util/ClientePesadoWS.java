/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.util;

import agencia.entity.Proveedor;
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
    @WebMethod(operationName = "listarProveedores")
    public List<Proveedor> lsitarProveedores() {
        ProveedorHelper ph = new ProveedorHelper();
        return ph.listarProveedores();
    }
    
    @WebMethod(operationName= "guardarProveedor")
    public void guardarProveedor(Proveedor pro){
        ProveedorHelper ph = new ProveedorHelper();
        ph.guardarProveedor(pro);        
    }
    
    @WebMethod(operationName="loguearProveedor")
    public Boolean loguearProveedor(String usuario, String pass){
        ProveedorHelper ph = new ProveedorHelper();
        return ph.obtenerProveedorPorUsuario(usuario).getPass()==pass;
    }
}
