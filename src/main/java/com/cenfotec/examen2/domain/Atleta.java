package com.cenfotec.examen2.domain;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessorOrder;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "atletas")
public class Atleta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nombre_completo")
    private String nombre;
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Column(name = "nacimiento")
    private Date nacimiento;
    @Column(name = "deporte")
    private String deporte;
    @Column(name = "estatura")
    private int estatura;
    @Column(name = "peso")
    private double peso;
    @Column(name = "rama")
    private char rama;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "distrito")
    private String distrito;
    @Column(name = "canton")
    private String canton;
    @Column(name = "provincia")
    private String provincia;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "email")
    private String email;

    @Column(name = "historial")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "atleta")
    private Set<Historial> historiales;


    public Atleta() {
    }

    public Atleta(String nombre, String primerApellido, String segundoApellido, Date nacimiento, String deporte, int estatura, double peso, char rama, String direccion, String distrito, String canton, String provincia, String telefono, String email, Set<Historial> historiales) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nacimiento = nacimiento;
        this.deporte = deporte;
        this.estatura = estatura;
        this.peso = peso;
        this.rama = rama;
        this.direccion = direccion;
        this.distrito = distrito;
        this.canton = canton;
        this.provincia = provincia;
        this.telefono = telefono;
        this.email = email;
        this.historiales = historiales;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public int getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public char getRama() {
        return rama;
    }

    public void setRama(char rama) {
        this.rama = rama;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Historial> getHistoriales() {
        return historiales;
    }

    public void setHistoriales(Set<Historial> historiales) {
        this.historiales = historiales;
    }
}
