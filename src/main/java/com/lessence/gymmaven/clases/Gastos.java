/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lessence.gymmaven.clases;

import java.util.Date;

public class Gastos {

    private int idGasto;
    private Date Fecha;
    private String Concepto;
    private float Importe;
    private int Tipo;

    public Gastos() {
    }

    public Date getFecha() {
        return Fecha;
    }

    public int getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(int idGasto) {
        this.idGasto = idGasto;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getConcepto() {
        return Concepto;
    }

    public void setConcepto(String Concepto) {
        this.Concepto = Concepto;
    }

    public float getImporte() {
        return Importe;
    }

    public void setImporte(float Importe) {
        this.Importe = Importe;
    }

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

}
