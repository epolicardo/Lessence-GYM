/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lessence.gymmaven.clases;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * La clase {@code Socios} representa el objeto Socio, implementando sus metodos
 * y propiedades. El primer vencimiento indica 30 dias de la fecha de pago.
 *
 */
public class Socios implements Serializable {

    private int idSocio;
    private Date fechaAlta;
    private String aptoFisico;
    private String decJurada;
    private Personas persona;
    private List<Cuotas_registros> cuotas = new ArrayList<Cuotas_registros>();
    private List<Actividades> actividades = new ArrayList<Actividades>();

    private Date primerVencimiento;
    private Date segundoVencimiento;
    private Date VencimientoPrevio;

    private Estados estado;
    private int ciclo;
    private int Situacion;

    public Socios() {
    }

    public static List<Socios> listaSocios() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Criteria consultaSocios = sesion.createCriteria(Socios.class);
        List<Socios> listaSocios = consultaSocios.list();
        sesion.close();
        return listaSocios;
    }

    public static List<Socios> listaSocios(String Query) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Query consultaSocios = sesion.createQuery(Query);
        List<Socios> listaSocios = consultaSocios.list();
        sesion.close();
        return listaSocios;
    }

    public static void VerificaEstadosySituaciones() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Date.from(Instant.now())); // Asignamos al calendario la fecha actual 
        Date ahora = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, ParametrosSistema.avisoVencimientos); //Agrego diez dias a la fecha de hoy
        Date proximosVencimientos = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, -ParametrosSistema.diasVigencia); //Resto 60 dias a hoy
        Date situacion = calendar.getTime();
        List<Socios> listaSocios = listaSocios("From Socios where situacion = 1");
        List<Estados> listaEstados = Estados.listaEstados();

        for (int i = 0; i < listaSocios.size(); i++) {
            sesion.beginTransaction();
            Socios socio = listaSocios.get(i);
            if (socio.getPrimerVencimiento().before(ahora)) {
                Estados estado = (Estados) listaEstados.get(1);//Inactivo
                socio.setEstado(estado);
            } else {
                Estados estado = (Estados) listaEstados.get(0);//Activo
                socio.setEstado(estado);
            }
            sesion.saveOrUpdate(socio);
            sesion.getTransaction().commit();
        }

        sesion.close();

    }

    public List<Actividades> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividades> actividades) {
        this.actividades = actividades;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getAptoFisico() {
        return aptoFisico;
    }

    public void setAptoFisico(String aptoFisico) {
        this.aptoFisico = aptoFisico;
    }

    public String getDecJurada() {
        return decJurada;
    }

    public void setDecJurada(String decJurada) {
        this.decJurada = decJurada;
    }

    public Personas getPersona() {
        return persona;
    }

    public void setPersona(Personas persona) {
        this.persona = persona;
    }

    public List<Cuotas_registros> getCuotas() {
        return cuotas;
    }

    public void setCuotas(List<Cuotas_registros> cuotas) {
        this.cuotas = cuotas;
    }

    public Date getPrimerVencimiento() {
        return primerVencimiento;
    }

    public void setPrimerVencimiento(Date primerVencimiento) {
        this.primerVencimiento = primerVencimiento;
    }

    public Date getSegundoVencimiento() {
        return segundoVencimiento;
    }

    public void setSegundoVencimiento(Date segundoVencimiento) {
        this.segundoVencimiento = segundoVencimiento;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public int getSituacion() {
        return Situacion;
    }

    public void setSituacion(int Situacion) {
        this.Situacion = Situacion;
    }

    public Date getVencimientoPrevio() {
        return VencimientoPrevio;
    }

    public void setVencimientoPrevio(Date VencimientoPrevio) {
        this.VencimientoPrevio = VencimientoPrevio;
    }
}
