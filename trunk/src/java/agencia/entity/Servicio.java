package agencia.entity;
// Generated 04/06/2011 18:38:36 by Hibernate Tools 3.2.1.GA



/**
 * Servicio generated by hbm2java
 */
public class Servicio  implements java.io.Serializable {


     private ServicioId id;
     private Proveedor proveedor;
     private String nombre;
     private Float precio;
     private Integer disponibilidad;

    public Servicio() {
    }

	
    public Servicio(ServicioId id, Proveedor proveedor) {
        this.id = id;
        this.proveedor = proveedor;
    }
    public Servicio(ServicioId id, Proveedor proveedor, String nombre, Float precio, Integer disponibilidad) {
       this.id = id;
       this.proveedor = proveedor;
       this.nombre = nombre;
       this.precio = precio;
       this.disponibilidad = disponibilidad;
    }
   
    public ServicioId getId() {
        return this.id;
    }
    
    public void setId(ServicioId id) {
        this.id = id;
    }
    public Proveedor getProveedor() {
        return this.proveedor;
    }
    
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Float getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(Float precio) {
        this.precio = precio;
    }
    public Integer getDisponibilidad() {
        return this.disponibilidad;
    }
    
    public void setDisponibilidad(Integer disponibilidad) {
        this.disponibilidad = disponibilidad;
    }




}


