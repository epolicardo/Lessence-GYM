/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lessence.gymmaven.clases;

/**
 *
 * @author Emiliano
 */
public class Asistencias {

    public String Fecha;
    public String idAsistencias;
    public String idActividades;

    public Asistencias() {
    }


      
    
      public Asistencias(String Fecha, String Actividades, String idActividades) {
        this.setFecha(Fecha);
        this.setIdAsistencias(idAsistencias);
        this.setIdActividades(idActividades);
        
    }

    public String getIdActividades() {
        return idActividades;
    }

    public void setIdActividades(String idActividades) {
        this.idActividades = idActividades;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getIdAsistencias() {
        return idAsistencias;
    }

    public void setIdAsistencias(String idAsistencias) {
        this.idAsistencias = idAsistencias;
    }
}
   
