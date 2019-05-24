package com.lessence.gymmaven.clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

public class Personas {

    private int idPersona;
    private String DNI;
    private String Nombre;
    private String Apellido;
    private String Telefono;
    private String Celular;
    private String Correo;
    private Date FechaNacimiento;
    private EstadoCivil EstadoCivil;
    private int Hijos;
    private int Sexo;
    private String foto;
    private List<Domicilios> domicilios = new ArrayList<Domicilios>();

    public Personas() {
    }

    public Personas(int idPersona, String DNI, String Nombre, String Apellido, String Telefono, String Celular, String Correo, Date FechaNacimiento, EstadoCivil EstadoCivil, int Hijos, int Sexo, String foto) {
        this.idPersona = idPersona;
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Telefono = Telefono;
        this.Celular = Celular;
        this.Correo = Correo;
        this.FechaNacimiento = FechaNacimiento;
        this.EstadoCivil = EstadoCivil;
        this.Hijos = Hijos;
        this.Sexo = Sexo;
        this.foto = foto;
    }

    @Override
    public String toString() {
        return Nombre;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public EstadoCivil getEstadoCivil() {
        return EstadoCivil;
    }

    public void setEstadoCivil(EstadoCivil EstadoCivil) {
        this.EstadoCivil = EstadoCivil;
    }

    public int getHijos() {
        return Hijos;
    }

    public void setHijos(int Hijos) {
        this.Hijos = Hijos;
    }

    public int getSexo() {
        return Sexo;
    }

    public void setSexo(int Sexo) {
        this.Sexo = Sexo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Domicilios> getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(List<Domicilios> domicilios) {
        this.domicilios = domicilios;
    }

    public void addDomicilio(Domicilios domicilio) {
        this.domicilios.add(domicilio);
    }

    public static List<Personas> consultaBase() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Criteria consulta = sesion.createCriteria(Personas.class);
        List<Personas> lista = consulta.list();
        sesion.close();
        return lista;
    }

}
