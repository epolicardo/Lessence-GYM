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
@Table(name = "profesores", catalog = "gym", schema = "")
@NamedQueries({
    @NamedQuery(name = "Profesores.findAll", query = "SELECT p FROM Profesores p")
    , @NamedQuery(name = "Profesores.findByIdProfesor", query = "SELECT p FROM Profesores p WHERE p.idProfesor = :idProfesor")
    , @NamedQuery(name = "Profesores.findByFechaAlta", query = "SELECT p FROM Profesores p WHERE p.fechaAlta = :fechaAlta")
    , @NamedQuery(name = "Profesores.findByDocumento1", query = "SELECT p FROM Profesores p WHERE p.documento1 = :documento1")
    , @NamedQuery(name = "Profesores.findByDocumento2", query = "SELECT p FROM Profesores p WHERE p.documento2 = :documento2")
    , @NamedQuery(name = "Profesores.findByPersona", query = "SELECT p FROM Profesores p WHERE p.persona = :persona")
    , @NamedQuery(name = "Profesores.findByIdEstado", query = "SELECT p FROM Profesores p WHERE p.idEstado = :idEstado")})
public class Profesores implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProfesor")
    private Integer idProfesor;
    @Column(name = "fechaAlta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    @Column(name = "documento1")
    private String documento1;
    @Column(name = "documento2")
    private String documento2;
    @Column(name = "persona")
    private Integer persona;
    @Column(name = "idEstado")
    private Integer idEstado;

    public Profesores() {
    }

    public Profesores(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        Integer oldIdProfesor = this.idProfesor;
        this.idProfesor = idProfesor;
        changeSupport.firePropertyChange("idProfesor", oldIdProfesor, idProfesor);
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        Date oldFechaAlta = this.fechaAlta;
        this.fechaAlta = fechaAlta;
        changeSupport.firePropertyChange("fechaAlta", oldFechaAlta, fechaAlta);
    }

    public String getDocumento1() {
        return documento1;
    }

    public void setDocumento1(String documento1) {
        String oldDocumento1 = this.documento1;
        this.documento1 = documento1;
        changeSupport.firePropertyChange("documento1", oldDocumento1, documento1);
    }

    public String getDocumento2() {
        return documento2;
    }

    public void setDocumento2(String documento2) {
        String oldDocumento2 = this.documento2;
        this.documento2 = documento2;
        changeSupport.firePropertyChange("documento2", oldDocumento2, documento2);
    }

    public Integer getPersona() {
        return persona;
    }

    public void setPersona(Integer persona) {
        Integer oldPersona = this.persona;
        this.persona = persona;
        changeSupport.firePropertyChange("persona", oldPersona, persona);
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        Integer oldIdEstado = this.idEstado;
        this.idEstado = idEstado;
        changeSupport.firePropertyChange("idEstado", oldIdEstado, idEstado);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfesor != null ? idProfesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesores)) {
            return false;
        }
        Profesores other = (Profesores) object;
        if ((this.idProfesor == null && other.idProfesor != null) || (this.idProfesor != null && !this.idProfesor.equals(other.idProfesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lessence.gymmaven.GUI.Profesores[ idProfesor=" + idProfesor + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
