/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lessence.gymmaven.clases;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 * Los estados de un socio son representados en dos formas. 
 * - Activo e Inactivo
 * - Vigente o No vigente
 * @author Emiliano Policardo http://www.facebook.com/policomputacion
 */
public class Estados {

    private int idEstado;
    private String estado;
    private List<Socios> socios = new ArrayList<Socios>();
    private List<Profesores> profesores = new ArrayList<Profesores>();

    public List<Profesores> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesores> profesores) {
        this.profesores = profesores;
    }

    public Estados() {
    }

    public Estados(int idEstado, String estado, List<Socios> socios) {
        this.idEstado = idEstado;
        this.estado = estado;
        this.socios = socios;
    }

    public List<Socios> getSocios() {
        return socios;
    }

    public void setSocios(List<Socios> socios) {
        this.socios = socios;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

     public static List<Estados> listaEstados() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Criteria consulta = sesion.createCriteria(Estados.class);
        List<Estados> lista = consulta.list();
        sesion.close();
        return lista;
    }
}
