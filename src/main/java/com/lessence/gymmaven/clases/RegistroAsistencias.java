/*
 * Copyright 2016 Emiliano Policardo <www.facebook.com/policomputacion>.
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
package com.lessence.gymmaven.clases;

import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Emiliano Policardo <www.facebook.com/policomputacion>
 */
public class RegistroAsistencias {

    private int idRegistroAsistencia;
    private Date fecha;
    private Socios socio;
    private Relaciones relacion;

    public RegistroAsistencias() {
    }

    
    public int getIdRegistroAsistencia() {
        return idRegistroAsistencia;
    }

    public void setIdRegistroAsistencia(int idRegistroAsistencia) {
        this.idRegistroAsistencia = idRegistroAsistencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Socios getSocio() {
        return socio;
    }

    public void setSocio(Socios socio) {
        this.socio = socio;
    }

    public Relaciones getRelacion() {
        return relacion;
    }

    public void setRelacion(Relaciones relacion) {
        this.relacion = relacion;
    }

 
     public static List<RegistroAsistencias> listaAsistencias() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Criteria consulta = sesion.createCriteria(RegistroAsistencias.class);
        List<RegistroAsistencias> lista = consulta.list();
        sesion.close();
        return lista;
    }
}
