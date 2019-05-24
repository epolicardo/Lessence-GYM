/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lessence.gymmaven.clases;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Emiliano
 */
public final class Actividades {

    private int idActividad;
    private String Actividad;
    private List<Profesores> profesor = new ArrayList<Profesores>();

    public Actividades() {

    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getActividad() {
        return Actividad;
    }

    public void setActividad(String Actividad) {
        this.Actividad = Actividad;
    }

    public List<Profesores> getProfesor() {
        return profesor;
    }

    public void setProfesor(List<Profesores> profesor) {
        this.profesor = profesor;

    }

    public void addProfesor(Profesores profesor) {
        this.profesor.add(profesor);

    }

    @Override
    public String toString() {
        return Actividad;

    }

    public static List<Actividades> listaActividades() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Criteria consulta = sesion.createCriteria(Actividades.class);
        List<Actividades> lista = consulta.list();
        sesion.close();
        return lista;
    }

}
