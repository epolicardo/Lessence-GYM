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
 *
 * @author Emiliano
 */
public class Localidades {

    private int idLocalidad;
    private String Localidad;
    private Domicilios domicilio;
    private List<Domicilios> domicilios = new ArrayList<Domicilios>();
    private Provincias provincia;

    public Localidades() {
    }

//    public List<Domicilios> getDomicilios() {
//        return domicilios;
//    }
//
//    public void setDomicilios(List<Domicilios> domicilios) {
//        this.domicilios = domicilios;
//    }

    public Domicilios getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilios domicilio) {
        this.domicilio = domicilio;
    }

    
    public Provincias getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincias provincia) {
        this.provincia = provincia;
    }

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String Localidad) {
        this.Localidad = Localidad;
    }
    
    
    public static List<Object> consultaBase() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Criteria consulta = sesion.createCriteria(Localidades.class);
        List<Object> lista = consulta.list();
        sesion.close();
        return lista;
    }
    
   
    
    
}
