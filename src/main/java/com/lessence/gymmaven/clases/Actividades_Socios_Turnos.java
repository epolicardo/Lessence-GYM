/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lessence.gymmaven.clases;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Emiliano
 */
public class Actividades_Socios_Turnos {

    public static List<Actividades_Socios_Turnos> listaActividades_Socios_Turnos(String SQL) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Query cr_Actividades_Socios_Turnos = sesion.createQuery(SQL);
        List<Actividades_Socios_Turnos> listaActividades_Socios_Turnos = cr_Actividades_Socios_Turnos.list();
        sesion.close();
        return listaActividades_Socios_Turnos;
    }
    public static List<Actividades_Socios_Turnos> listaActividades_Socios_Turnos() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Criteria cr_Actividades_Socios_Turnos = sesion.createCriteria(Actividades_Socios_Turnos.class);
        List<Actividades_Socios_Turnos> listaActividades_Socios_Turnos = cr_Actividades_Socios_Turnos.list();
        sesion.close();
        return listaActividades_Socios_Turnos;
    }

    private int idRelacion;
    private Socios socio;
    private Relaciones relacion;
    private int Pases;
    private int paseLibre;

    public int getPaseLibre() {
        return paseLibre;
    }

    public void setPaseLibre(int paseLibre) {
        this.paseLibre = paseLibre;
    }

    public Actividades_Socios_Turnos() {

    }

    public Actividades_Socios_Turnos(int idRelacion, Socios socio, Relaciones relacion) {
        this.idRelacion = idRelacion;
        this.socio = socio;
        this.relacion = relacion;
    }

    public int getIdRelacion() {
        return idRelacion;
    }

    public void setIdRelacion(int idRelacion) {
        this.idRelacion = idRelacion;
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

    public int getPases() {
        return Pases;
    }

    public void setPases(int Pases) {
        this.Pases = Pases;
    }

}
