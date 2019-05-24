/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lessence.gymmaven.clases;

import com.lessence.gymmaven.clases.FormasPago;
import java.util.Date;
import java.util.logging.Logger;


/**
 *
 * @author Emiliano
 */
public class Cuotas_registros {
    
    

    private int idRegistro;
    private Date Fecha;
    private float Importe;
    private String observaciones;
    private FormasPago formaPago;
    private Socios socio;
    private Date vencimientoAbonado;

    
    
    
    

        
    
    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public float getImporte() {
        return Importe;
    }

    public void setImporte(float Importe) {
        this.Importe = Importe;
    }

    public FormasPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormasPago formaPago) {
        this.formaPago = formaPago;
    }

    public Socios getSocio() {
        return socio;
    }

    public void setSocio(Socios socio) {
        this.socio = socio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getVencimientoAbonado() {
        return vencimientoAbonado;
    }

    public void setVencimientoAbonado(Date vencimientoAbonado) {
        this.vencimientoAbonado = vencimientoAbonado;
    }

            public Cuotas_registros() {

    }

}
