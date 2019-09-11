    /*
 * Copyright 2016 Emiliano Policardo <www.facebook.com/policomputacion>.
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

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * UFM: Ultima fecha modificacion
 * @author Emiliano Policardo <www.facebook.com/policomputacion>
 */
public class Precios {
    
    private int idPrecio;
    private ListasPrecios listaPrecios;
    private Productos producto;
    private float importeVenta;
    private float importeCosto;
    private float impuestos;
    private Date ufm;

    public Precios() {
    }

    public Precios(int idPrecio, ListasPrecios listaPrecios, Productos producto, float importeVenta, float importeCosto, float impuestos, Date ufm) {
        this.idPrecio = idPrecio;
        this.listaPrecios = listaPrecios;
        this.producto = producto;
        this.importeVenta = importeVenta;
        this.importeCosto = importeCosto;
        this.impuestos = impuestos;
        this.ufm = ufm;
    }

    public int getIdPrecio() {
        return idPrecio;
    }

    public void setIdPrecio(int idPrecio) {
        this.idPrecio = idPrecio;
    }

    public ListasPrecios getListaPrecios() {
        return listaPrecios;
    }

    public void setListaPrecios(ListasPrecios listaPrecios) {
        this.listaPrecios = listaPrecios;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public float getImporteVenta() {
        return importeVenta;
    }

    public void setImporteVenta(float importeVenta) {
        this.importeVenta = importeVenta;
    }

    public float getImporteCosto() {
        return importeCosto;
    }

    public void setImporteCosto(float importeCosto) {
        this.importeCosto = importeCosto;
    }

    public float getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(float impuestos) {
        this.impuestos = impuestos;
    }

    public Date getUfm() {
        return ufm;
    }

    public void setUfm(Date ufm) {
        this.ufm = ufm;
    }

    public static List<Object> consultaBase() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Criteria consulta = sesion.createCriteria(Precios.class);
        List<Object> lista = consulta.list();
        sesion.close();
        return lista;
    }
    public static List<Object> consultaBase(String Query) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Query consulta = sesion.createQuery(Query);
        List<Object> lista = consulta.list();
        sesion.close();
        return lista;
    }
}
