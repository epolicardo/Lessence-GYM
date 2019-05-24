/*
 * Copyright 2016 Emiliano Policardo http://www.facebook.com/policomputacion.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lessence.gymmaven.clases;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Emiliano Policardo http://www.facebook.com/policomputacion
 */
public class Caja_diaria {

    private int idMovimiento;
    private Date fecha;
    private int categoria;
    private String concepto;
    private FormasPago formaPago;
    private float debe;
    private float haber;
    private float saldo;

    public Caja_diaria() {
    }

    public static float saldoPrevio() {

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Float saldo = 0.00f;
        Criteria query_caja = sesion.createCriteria(Caja_diaria.class);
        List<Caja_diaria> lista_caja = query_caja.list();

        query_caja.setFirstResult(lista_caja.size() - 1 - ParametrosSistema.cantidadMovimientos);
        query_caja.setMaxResults(ParametrosSistema.cantidadMovimientos + 1);
        lista_caja = query_caja.list();

        for (int i = 0; i < lista_caja.size(); i++) {

            Caja_diaria movimiento = lista_caja.get(i);
            saldo = movimiento.getSaldo();

        }
        sesion.close();
        return (saldo);
    }

    public static void AbrirCaja() {

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        Caja_diaria apertura = new Caja_diaria();
        FormasPago formaPago = new FormasPago();
        apertura.setFecha(Date.from(Instant.now()));
        apertura.setCategoria(1);
        apertura.setConcepto("Apertura de Caja");
        formaPago.setIdFormaPago(1);
        apertura.setFormaPago(formaPago);
        Float saldo = saldoPrevio();
        apertura.setSaldo(saldo);
        sesion.save(apertura);
        ParametrosSistema.estadoCaja = 1;
        sesion.getTransaction().commit();
        sesion.close();
        ParametrosSistema.GuardaParametros();
    }

    public void GrabarRegistro() {

    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public FormasPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormasPago formaPago) {
        this.formaPago = formaPago;
    }

    public float getDebe() {
        return debe;
    }

    public void setDebe(float debe) {
        this.debe = debe;
    }

    public float getHaber() {
        return haber;
    }

    public void setHaber(float haber) {
        this.haber = haber;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

}
