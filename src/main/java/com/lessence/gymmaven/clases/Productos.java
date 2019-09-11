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

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Emiliano Policardo <www.facebook.com/policomputacion>
 */
public class Productos{

    private int idProducto;
    private String codigoProducto;
    private String descripcionCorta;
    private String descripcionLarga;
    private String EAN;
    private Marcas marca;
    private int estado; // Activo o no.
    private Familias familia; // Puede estar incluido en mas de una??
    private Proveedores proveedor; //Puede tener mas de uno
    private UnidadesMedida um;
    private TiposProductos tipoProducto; // 1-Bienes de Cambio / 2-Bienes de uso // Puede estar en varias categorias, por ejemplo insumo y bien de cambio (Harina en una panaderia)
    private boolean tieneVencimiento; //Si tiene vencimiento ofrecer opciones de tracking y fifo
    private boolean registraStock; // Contabiliza o no el stock del producto.
    private List<ListasPrecios> listasPrecios = new ArrayList<ListasPrecios>();
    private List<Precios> Precios = new ArrayList<Precios>();
    private int stockActual;
    private int stockMinimo;
    private Inventario intventario;
//Vincular precios de costo, listas de precio y mantener historico de costos y compras

    public Productos() {
    }

        public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }


    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }

    public String getDescripcionLarga() {
        return descripcionLarga;
    }

    public void setDescripcionLarga(String descripcionLarga) {
        this.descripcionLarga = descripcionLarga;
    }

    public String getEAN() {
        return EAN;
    }

    public void setEAN(String EAN) {
        this.EAN = EAN;
    }

    public Marcas getMarca() {
        return marca;
    }

    public void setMarca(Marcas marca) {
        this.marca = marca;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Familias getFamilia() {
        return familia;
    }

    public void setFamilia(Familias familia) {
        this.familia = familia;
    }

    public Proveedores getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedores proveedor) {
        this.proveedor = proveedor;
    }

    public UnidadesMedida getUm() {
        return um;
    }

    public void setUm(UnidadesMedida um) {
        this.um = um;
    }

    public TiposProductos getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TiposProductos tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public boolean isTieneVencimiento() {
        return tieneVencimiento;
    }

    public void setTieneVencimiento(boolean tieneVencimiento) {
        this.tieneVencimiento = tieneVencimiento;
    }

    public boolean isRegistraStock() {
        return registraStock;
    }

    public void setRegistraStock(boolean registraStock) {
        this.registraStock = registraStock;
    }

    public List<ListasPrecios> getListasPrecios() {
        return listasPrecios;
    }

    public void setListasPrecios(List<ListasPrecios> listasPrecios) {
        this.listasPrecios = listasPrecios;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public List<Precios> getPrecios() {
        return Precios;
    }

    public void setPrecios(List<Precios> Precios) {
        this.Precios = Precios;
    }

  

    
    /**
     *Con esta funcion devolvemos la lista de Productos para luego poder procesarla
     *
     * @return
     */
    public static List<Object> consultaBase() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Criteria consulta = sesion.createCriteria(Productos.class);
        List<Object> lista = consulta.list();
        sesion.close();
        return lista;
    }
}
