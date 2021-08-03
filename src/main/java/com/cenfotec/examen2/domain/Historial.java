package com.cenfotec.examen2.domain;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "historial_imc")
public class Historial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "imc")
    private double imc;
    @Column(name = "fecha")
    private Date fecha;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Atleta atleta;

    public Historial(){

    }

    public Historial(double imc, Date fecha, Atleta atleta) {
        this.imc = imc;
        this.fecha = fecha;
        this.atleta = atleta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }
}
