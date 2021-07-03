/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author SERGIO
 */
@Entity
@Table(name = "empleados")
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e")
    , @NamedQuery(name = "Empleados.findByNumLegajo", query = "SELECT e FROM Empleados e WHERE e.numLegajo = :numLegajo")
    , @NamedQuery(name = "Empleados.findByNombreApellido", query = "SELECT e FROM Empleados e WHERE e.nombreApellido = :nombreApellido")
    , @NamedQuery(name = "Empleados.findByFechaNacimineto", query = "SELECT e FROM Empleados e WHERE e.fechaNacimineto = :fechaNacimineto")
    , @NamedQuery(name = "Empleados.findByDni", query = "SELECT e FROM Empleados e WHERE e.dni = :dni")
    , @NamedQuery(name = "Empleados.findBySueldoBasico", query = "SELECT e FROM Empleados e WHERE e.sueldoBasico = :sueldoBasico")})
public class Empleados implements Serializable, Comparable<Empleados>  {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "num_legajo", nullable = false)
    private Integer numLegajo;
    @Column(name = "nombre_apellido", length = 50)
    private String nombreApellido;
    @Column(name = "fecha_nacimineto")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimineto;
    @Column(name = "dni")
    private Integer dni;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sueldo_basico")
    private Double sueldoBasico;

    public Empleados() {
    }

    public Empleados(Integer numLegajo) {
        this.numLegajo = numLegajo;
    }

    public Integer getNumLegajo() {
        return numLegajo;
    }

    public void setNumLegajo(Integer numLegajo) {
        this.numLegajo = numLegajo;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public Date getFechaNacimineto() {
        return fechaNacimineto;
    }

    public void setFechaNacimineto(Date fechaNacimineto) {
        this.fechaNacimineto = fechaNacimineto;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(Double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numLegajo != null ? numLegajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.numLegajo == null && other.numLegajo != null) || (this.numLegajo != null && !this.numLegajo.equals(other.numLegajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Empleados[ numLegajo=" + numLegajo + " ]";
    }

    @Override
    public int compareTo(Empleados t) {
        return getNombreApellido().compareTo(t.getNombreApellido());
    }
    
}
