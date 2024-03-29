package agencia.entity;
// Generated 14/06/2011 00:41:34 by Hibernate Tools 3.2.1.GA



/**
 * ServicioId generated by hbm2java
 */
public class ServicioId  implements java.io.Serializable {


     private int idServicio;
     private int proveedorIdProveedor;

    public ServicioId() {
    }

    public ServicioId(int idServicio, int proveedorIdProveedor) {
       this.idServicio = idServicio;
       this.proveedorIdProveedor = proveedorIdProveedor;
    }
   
    public int getIdServicio() {
        return this.idServicio;
    }
    
    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }
    public int getProveedorIdProveedor() {
        return this.proveedorIdProveedor;
    }
    
    public void setProveedorIdProveedor(int proveedorIdProveedor) {
        this.proveedorIdProveedor = proveedorIdProveedor;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ServicioId) ) return false;
		 ServicioId castOther = ( ServicioId ) other; 
         
		 return (this.getIdServicio()==castOther.getIdServicio())
 && (this.getProveedorIdProveedor()==castOther.getProveedorIdProveedor());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdServicio();
         result = 37 * result + this.getProveedorIdProveedor();
         return result;
   }   


}


