/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lessence.gymmaven.clases;

/**
 *
 * @author emiliano
 */
public class Compras {

    private String idCompras;
    private String idProveedores;
    private String Fecha;
    private String Comprobante;
    private String CantItem;
    private String FormadePago;
    private String ImporteTotal;

    public Compras(String idCompras, String idProveedores,
            String Fecha , String ImporteTotal, String Comprobante , String CantItem ,
            String FormadePago) {

        this.setIdCompras(idCompras);
        this.setIdProveedores(idProveedores);
        this.setFormadePago(FormadePago);
        this.setCantItem(CantItem);
        this.setComprobante(Comprobante);
        this.setFecha(Fecha);
        this.setImporteTotal(ImporteTotal);



    }

    public String getImporteTotal() {
        return ImporteTotal;
    }

    public void setImporteTotal(String ImporteTotal) {
        this.ImporteTotal = ImporteTotal;
    }

    public   String getCantItem () {
        return CantItem;
    }

    public  void setCantItem(String CantItem) {
        this.CantItem = CantItem;
    }

    public  String getComprobante() {
        return Comprobante;
    }

    public  void setComprobante(String Comprobante) {
        this.Comprobante = Comprobante;
    }

    public  String getFecha() {
        return Fecha;
    }

    public  void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public  String getFormadePago() {
        return FormadePago;
    }

    public  void setFormadePago(String FormadePago) {
        this.FormadePago = FormadePago;
    }

    public  String getIdCompras() {
        return idCompras;
    }

    public  void setIdCompras(String idCompras) {
        this.idCompras = idCompras;
    }

public String getIdProveedores() {
        return idProveedores;
    }

    public void setIdProveedores(String idProveedores) {
        this.idProveedores = idProveedores;
    }




}
