/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lessence.gymmaven.clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Emiliano
 */
public class Profesores {

    private int idProfesor;
    private Date fechaAlta;
    private String documento1;
    private String documento2;
    private Personas persona;
    private List<Actividades> actividad = new ArrayList<Actividades>();
    private Estados estado;

    public Profesores() {
    }

    public Profesores(Date fechaAlta, String documento1, String documento2, Estados estado) {
        this.documento1 = documento1;
        this.documento2 = documento2;
        this.estado = estado;
    }

    public Profesores(Date fechaAlta, String documento1, String documento2, Personas persona, List<Actividades> actividad, List<Turnos> turno, Estados estado) {

        this.fechaAlta = fechaAlta;
        this.documento1 = documento1;
        this.documento2 = documento2;

        this.persona = persona;
        this.actividad = actividad;
        this.estado = estado;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getDocumento1() {
        return documento1;
    }

    public void setDocumento1(String documento1) {
        this.documento1 = documento1;
    }

    public String getDocumento2() {
        return documento2;
    }

    public void setDocumento2(String documento2) {
        this.documento2 = documento2;
    }

    public Personas getPersona() {
        return persona;
    }

    public void setPersona(Personas persona) {
        this.persona = persona;
    }

    public List<Actividades> getActividad() {
        return actividad;
    }

    public void setActividad(List<Actividades> actividad) {
        this.actividad = actividad;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public void addActividad(Actividades actividad) {
        this.actividad.add(actividad);
    }

    public static List<Profesores> consultaBase() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Criteria consulta = sesion.createCriteria(Profesores.class);
        List<Profesores> lista = consulta.list();
        sesion.close();
        return lista;
    }

//    @Override
//    public String toString() {
//        return this.idProfesor + " - " + persona.getNombre() + " " + persona.getApellido();

//    }
}
