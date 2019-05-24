/*
 * ResultSetComboBoxModelObject.java
 */

package com.lessence.gymmaven.clases;

/**
 * ResultSet ComboBoxModel Object
 * @author Yo
 * @version 1.0
 */
public class ResultSetComboBoxModelObjectHibernate {

    private Integer codigo;
    private String descripcion;

    public ResultSetComboBoxModelObjectHibernate(Integer codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    /**
     *
     * @param codigo
     * @param descripcion
     */
 

    @Override
    public String toString() {
        return this.getDescripcion();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}