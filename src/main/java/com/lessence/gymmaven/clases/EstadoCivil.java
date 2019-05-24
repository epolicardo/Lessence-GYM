/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lessence.gymmaven.clases;

import com.lessence.gymmaven.clases.Personas;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Emiliano Policardo http://www.facebook.com/policomputacion
 */
public class EstadoCivil {

    private int idEstado;
    private String estadoCivil;
    private List<Personas> personas = new ArrayList<Personas>();

    public EstadoCivil() {
    }

    public EstadoCivil(int idEstado, String estadoCivil) {
        this.idEstado = idEstado;
        this.estadoCivil = estadoCivil;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public List<Personas> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Personas> personas) {
        this.personas = personas;
    }

    
    
    public static List<Object> consultaBase() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Criteria consulta = sesion.createCriteria(EstadoCivil.class);
        List<Object> lista = consulta.list();
        sesion.close();
        return lista;
    }
}
