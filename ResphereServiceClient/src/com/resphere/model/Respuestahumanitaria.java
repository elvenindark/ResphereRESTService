package com.resphere.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hp
 */
/*@Entity
@Table(name = "respuestahumanitaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuestahumanitaria.findAll", query = "SELECT r FROM Respuestahumanitaria r"),
    @NamedQuery(name = "Respuestahumanitaria.findByObservacion", query = "SELECT r FROM Respuestahumanitaria r WHERE r.observacion = :observacion"),
    @NamedQuery(name = "Respuestahumanitaria.findByIdevento", query = "SELECT r FROM Respuestahumanitaria r WHERE r.idevento = :idevento"),
    @NamedQuery(name = "Respuestahumanitaria.findByAplica", query = "SELECT r FROM Respuestahumanitaria r WHERE r.aplica = :aplica")})*/
public class Respuestahumanitaria implements Serializable {
    private static final long serialVersionUID = 1L;
    
    //@Column(name = "observacion")
    private String observacion;
    //@Id
    //@Basic(optional = false)   
    //@Column(name = "idevento")
    private String idevento;    
    //@Column(name = "aplica")
    private String aplica;
    //@Column(name = "idindicadorclave")    
    private String idindicadorclave;
    

    public Respuestahumanitaria() {
    }

    public Respuestahumanitaria(String idevento) {
        this.idevento = idevento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getIdevento() {
        return idevento;
    }

    public void setIdevento(String idevento) {
        this.idevento = idevento;
    }

    public String getAplica() {
        return aplica;
    }

    public void setAplica(String aplica) {
        this.aplica = aplica;
    }

    public String getIdindicadorclave() {
        return idindicadorclave;
    }

    public void setIdindicadorclave(String idindicadorclave) {
        this.idindicadorclave = idindicadorclave;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idevento != null ? idevento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuestahumanitaria)) {
            return false;
        }
        Respuestahumanitaria other = (Respuestahumanitaria) object;
        if ((this.idevento == null && other.idevento != null) || (this.idevento != null && !this.idevento.equals(other.idevento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.resphere.server.model.Respuestahumanitaria[ idevento=" + idevento + " ]";
    }
    
}

