/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lessence.gymmaven.clases;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;


/**
 *
 * @author Emiliano
 */
public final class Relaciones {

    public int idRelacion;
    public Actividades actividad;
    public Horarios horario;
    public Profesores profesor;

    public Relaciones() {
    }

    public Relaciones(int idRelacion, Actividades actividad, Horarios horario, Profesores profesor) {
        this.idRelacion = idRelacion;
        this.actividad = actividad;
        this.horario = horario;
        this.profesor = profesor;
    }

    public int getIdRelacion() {
        return idRelacion;
    }

    public void setIdRelacion(int idRelacion) {
        this.idRelacion = idRelacion;
    }

    public Actividades getActividad() {
        return actividad;
    }

    public void setActividad(Actividades actividad) {
        this.actividad = actividad;
    }

    public Horarios getHorario() {
        return horario;
    }

    public void setHorario(Horarios horario) {
        this.horario = horario;
    }

    public Profesores getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }

   public static List<Relaciones> listaRelaciones() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Criteria consulta = sesion.createCriteria(Relaciones.class);
        List<Relaciones> lista = consulta.list();
        sesion.close();
        return lista;
    }

   
  

}
