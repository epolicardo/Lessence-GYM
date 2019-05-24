/*
 * Copyright 2017 Emiliano.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lessence.gymmaven.GUI;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Emiliano
 */
@Entity
@Table(name = "socios", catalog = "gym", schema = "")
@NamedQueries({
    @NamedQuery(name = "Socios.findAll", query = "SELECT s FROM Socios s")
    , @NamedQuery(name = "Socios.findByIdSocio", query = "SELECT s FROM Socios s WHERE s.idSocio = :idSocio")
    , @NamedQuery(name = "Socios.findByFechaAlta", query = "SELECT s FROM Socios s WHERE s.fechaAlta = :fechaAlta")
    , @NamedQuery(name = "Socios.findByAptoFisico", query = "SELECT s FROM Socios s WHERE s.aptoFisico = :aptoFisico")
    , @NamedQuery(name = "Socios.findByDecJurada", query = "SELECT s FROM Socios s WHERE s.decJurada = :decJurada")
    , @NamedQuery(name = "Socios.findByPrimerVencimiento", query = "SELECT s FROM Socios s WHERE s.primerVencimiento = :primerVencimiento")
    , @NamedQuery(name = "Socios.findBySegundoVencimiento", query = "SELECT s FROM Socios s WHERE s.segundoVencimiento = :segundoVencimiento")
    , @NamedQuery(name = "Socios.findByIdEstado", query = "SELECT s FROM Socios s WHERE s.idEstado = :idEstado")
    , @NamedQuery(name = "Socios.findByPersona", query = "SELECT s FROM Socios s WHERE s.persona = :persona")
    , @NamedQuery(name = "Socios.findByCiclo", query = "SELECT s FROM Socios s WHERE s.ciclo = :ciclo")
    , @NamedQuery(name = "Socios.findBySituacion", query = "SELECT s FROM Socios s WHERE s.situacion = :situacion")})
public class Socios implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSocio")
    private Integer idSocio;
    @Column(name = "fechaAlta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    @Column(name = "aptoFisico")
    private String aptoFisico;
    @Column(name = "decJurada")
    private String decJurada;
    @Column(name = "primerVencimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date primerVencimiento;
    @Column(name = "segundoVencimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date segundoVencimiento;
    @Column(name = "idEstado")
    private Integer idEstado;
    @Column(name = "persona")
    private Integer persona;
    @Column(name = "ciclo")
    private Integer ciclo;
    @Column(name = "Situacion")
    private Integer situacion;

    public Socios() {
    }

    public Socios(Integer idSocio) {
        this.idSocio = idSocio;
    }

    public Integer getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Integer idSocio) {
        Integer oldIdSocio = this.idSocio;
        this.idSocio = idSocio;
        changeSupport.firePropertyChange("idSocio", oldIdSocio, idSocio);
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        Date oldFechaAlta = this.fechaAlta;
        this.fechaAlta = fechaAlta;
        changeSupport.firePropertyChange("fechaAlta", oldFechaAlta, fechaAlta);
    }

    public String getAptoFisico() {
        return aptoFisico;
    }

    public void setAptoFisico(String aptoFisico) {
        String oldAptoFisico = this.aptoFisico;
        this.aptoFisico = aptoFisico;
        changeSupport.firePropertyChange("aptoFisico", oldAptoFisico, aptoFisico);
    }

    public String getDecJurada() {
        return decJurada;
    }

    public void setDecJurada(String decJurada) {
        String oldDecJurada = this.decJurada;
        this.decJurada = decJurada;
        changeSupport.firePropertyChange("decJurada", oldDecJurada, decJurada);
    }

    public Date getPrimerVencimiento() {
        return primerVencimiento;
    }

    public void setPrimerVencimiento(Date primerVencimiento) {
        Date oldPrimerVencimiento = this.primerVencimiento;
        this.primerVencimiento = primerVencimiento;
        changeSupport.firePropertyChange("primerVencimiento", oldPrimerVencimiento, primerVencimiento);
    }

    public Date getSegundoVencimiento() {
        return segundoVencimiento;
    }

    public void setSegundoVencimiento(Date segundoVencimiento) {
        Date oldSegundoVencimiento = this.segundoVencimiento;
        this.segundoVencimiento = segundoVencimiento;
        changeSupport.firePropertyChange("segundoVencimiento", oldSegundoVencimiento, segundoVencimiento);
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        Integer oldIdEstado = this.idEstado;
        this.idEstado = idEstado;
        changeSupport.firePropertyChange("idEstado", oldIdEstado, idEstado);
    }

    public Integer getPersona() {
        return persona;
    }

    public void setPersona(Integer persona) {
        Integer oldPersona = this.persona;
        this.persona = persona;
        changeSupport.firePropertyChange("persona", oldPersona, persona);
    }

    public Integer getCiclo() {
        return ciclo;
    }

    public void setCiclo(Integer ciclo) {
        Integer oldCiclo = this.ciclo;
        this.ciclo = ciclo;
        changeSupport.firePropertyChange("ciclo", oldCiclo, ciclo);
    }

    public Integer getSituacion() {
        return situacion;
    }

    public void setSituacion(Integer situacion) {
        Integer oldSituacion = this.situacion;
        this.situacion = situacion;
        changeSupport.firePropertyChange("situacion", oldSituacion, situacion);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSocio != null ? idSocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Socios)) {
            return false;
        }
        Socios other = (Socios) object;
        if ((this.idSocio == null && other.idSocio != null) || (this.idSocio != null && !this.idSocio.equals(other.idSocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lessence.gymmaven.GUI.Socios[ idSocio=" + idSocio + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
