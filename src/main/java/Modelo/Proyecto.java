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
@Table(name = "proyecto")
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")
    , @NamedQuery(name = "Proyecto.findByCodigoProyecto", query = "SELECT p FROM Proyecto p WHERE p.codigoProyecto = :codigoProyecto")
    , @NamedQuery(name = "Proyecto.findByNombreProyecto", query = "SELECT p FROM Proyecto p WHERE p.nombreProyecto = :nombreProyecto")
    , @NamedQuery(name = "Proyecto.findByFechaInicio", query = "SELECT p FROM Proyecto p WHERE p.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Proyecto.findByFechaFinalizacion", query = "SELECT p FROM Proyecto p WHERE p.fechaFinalizacion = :fechaFinalizacion")
    , @NamedQuery(name = "Proyecto.findByMontoProsupuestado", query = "SELECT p FROM Proyecto p WHERE p.montoProsupuestado = :montoProsupuestado")
    , @NamedQuery(name = "Proyecto.findByNumLegajo", query = "SELECT p FROM Proyecto p WHERE p.numLegajo = :numLegajo")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo_proyecto")
    private Integer codigoProyecto;
    @Column(name = "nombre_proyecto")
    private String nombreProyecto;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_finalizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaFinalizacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto_prosupuestado")
    private Double montoProsupuestado;
    @Column(name = "num_legajo")
    private Integer numLegajo;

    public Proyecto() {
    }

    public Proyecto(Integer codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }

    public Integer getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(Integer codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public Double getMontoProsupuestado() {
        return montoProsupuestado;
    }

    public void setMontoProsupuestado(Double montoProsupuestado) {
        this.montoProsupuestado = montoProsupuestado;
    }

    public Integer getNumLegajo() {
        return numLegajo;
    }

    public void setNumLegajo(Integer numLegajo) {
        this.numLegajo = numLegajo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoProyecto != null ? codigoProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.codigoProyecto == null && other.codigoProyecto != null) || (this.codigoProyecto != null && !this.codigoProyecto.equals(other.codigoProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Proyecto[ codigoProyecto=" + codigoProyecto + " ]";
    }
    
}
