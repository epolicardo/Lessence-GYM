/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lessence.gymmaven.clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emiliano
 */
public class FormasPago {
    private int idFormaPago;
    private String formaPago;
    private List<Cuotas_registros> cuotas = new ArrayList<Cuotas_registros>(); 
    private List<Caja_diaria> movimientos = new ArrayList<Caja_diaria>(); 
    
    
    public FormasPago(){
        
    }

    public int getIdFormaPago() {
        return idFormaPago;
    }

    public List<Caja_diaria> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Caja_diaria> movimientos) {
        this.movimientos = movimientos;
    }

    public void setIdFormaPago(int idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public List<Cuotas_registros> getCuotas() {
        return cuotas;
    }

    public void setCuotas(List<Cuotas_registros> cuotas) {
        this.cuotas = cuotas;
    }

    
}
