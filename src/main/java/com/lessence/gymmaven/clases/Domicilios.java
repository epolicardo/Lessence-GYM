/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lessence.gymmaven.clases;


import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Emiliano
 */
public class Domicilios implements Serializable {

    private int idDomicilio;
    private String Calle;
    private String Nro;
    private String Piso;
    private String Dpto;
    private String Barrio;
    private String CodigoPostal;
    private List<Personas> personas;
    private Localidades localidad;

    public Domicilios() {

    }

    public Domicilios(String Calle, String Nro, String Piso, String Dpto, String Barrio, String CodigoPostal, Localidades localidad) {
        this.Calle = Calle;
        this.Nro = Nro;
        this.Piso = Piso;
        this.Dpto = Dpto;
        this.Barrio = Barrio;
        this.CodigoPostal = CodigoPostal;
        this.localidad = localidad;
    }

    public String getBarrio() {
        return Barrio;
    }

    public void setBarrio(String Barrio) {
        this.Barrio = Barrio;
    }

    public Localidades getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidades localidad) {
        this.localidad = localidad;
    }

    public int getIdDomicilio() {
        return idDomicilio;
    }

    public List<Personas> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Personas> persona) {
        this.personas = persona;
    }

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public String getNro() {
        return Nro;
    }

    public void setNro(String Nro) {
        this.Nro = Nro;
    }

    public String getPiso() {
        return Piso;
    }

    public void setPiso(String Piso) {
        this.Piso = Piso;
    }

    public String getDpto() {
        return Dpto;
    }

    public void setDpto(String Dpto) {
        this.Dpto = Dpto;
    }

    public String getCodigoPostal() {
        return CodigoPostal;
    }

    public void setCodigoPostal(String CodigoPostal) {
        this.CodigoPostal = CodigoPostal;
    }

    public void addPersona(Personas persona) {
        this.personas.add(persona);
        persona.addDomicilio(this);
    }

}
