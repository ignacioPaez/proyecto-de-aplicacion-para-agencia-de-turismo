package agencia.entity;
// Generated 10/06/2011 10:34:34 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.TABLE;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Cliente generated by hbm2java
 */
@Entity
@Table(name="Cliente"
    ,catalog="Agencia_de_Turismo_DB"
    , uniqueConstraints = @UniqueConstraint(columnNames="usuario") 
)
public class Cliente  implements java.io.Serializable {


     private Integer idCliente;
     private String nombre;
     private String apellido;
     private String usuario;
     private String pass;
     private Date fechaNacimiento;
     private String nacionalidad;
     private Set<Factura> facturas = new HashSet<Factura>(0);

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String usuario, String pass, Date fechaNacimiento, String nacionalidad, Set<Factura> facturas) {
       this.nombre = nombre;
       this.apellido = apellido;
       this.usuario = usuario;
       this.pass = pass;
       this.fechaNacimiento = fechaNacimiento;
       this.nacionalidad = nacionalidad;
       this.facturas = facturas;
    }
   
     @Id @GeneratedValue(strategy=TABLE)
    
    @Column(name="idCliente", unique=true, nullable=false)
    public Integer getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    
    @Column(name="nombre", length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Column(name="apellido", length=45)
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    @Column(name="usuario", unique=true, length=45)
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    @Column(name="pass", length=45)
    public String getPass() {
        return this.pass;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="fechaNacimiento", length=10)
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    @Column(name="nacionalidad", length=45)
    public String getNacionalidad() {
        return this.nacionalidad;
    }
    
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="cliente")
    public Set<Factura> getFacturas() {
        return this.facturas;
    }
    
    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }




}


