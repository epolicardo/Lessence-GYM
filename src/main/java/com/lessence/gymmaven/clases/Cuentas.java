/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lessence.gymmaven.clases;

/**
 *
 * @author Emiliano
 */
public final class Cuentas {

    String Fecha;
    String FormaPago;
    String Importe;

    public Cuentas(String Fecha, String FormaPago, String Importe) {
        
        this.setFecha(Fecha);
        this.setFormaPago(FormaPago);
        this.setImporte(Importe);
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getFormaPago() {
        return FormaPago;
    }

    public void setFormaPago(String FormaPago) {
        this.FormaPago = FormaPago;
    }

    public String getImporte() {
        return Importe;
    }

    public void setImporte(String Importe) {
        this.Importe = Importe;
    }

}
