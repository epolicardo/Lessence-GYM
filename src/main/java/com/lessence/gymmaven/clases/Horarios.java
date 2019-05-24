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
public class Horarios {

    public static List<Horarios> consultaHorarios() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Criteria consulta = sesion.createCriteria(Horarios.class);
        List<Horarios> lista = consulta.list();
        sesion.close();
        return lista;
    }

     public static List<Horarios> consultaHorarios(String SQL) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Query consulta = sesion.createQuery(SQL);
        List<Horarios> lista = consulta.list();
        sesion.close();
        return lista;
    }
    private int idHorario;
    private String Horario;
    private Dias dia;

    public Horarios() {

    }

    public Dias getDia() {
        return dia;
    }

    public void setDia(Dias dia) {
        this.dia = dia;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String Horario) {
        this.Horario = Horario;
    }

}
