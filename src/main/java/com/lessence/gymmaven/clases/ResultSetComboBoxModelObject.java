/*
 * ResultSetComboBoxModelObject.java
 */

package com.lessence.gymmaven.clases;

/**
 * ResultSet ComboBoxModel Object
 * @author Yo
 * @version 1.0
 */
public class ResultSetComboBoxModelObject {

    private Integer codigo;
    private String descri;

    public ResultSetComboBoxModelObject(Integer codigo, String descri) {
        this.codigo = codigo;
        this.descri = descri;
    }

    /**
     *
     * @param codigo
     * @param descri
     */
 

    @Override
    public String toString() {
        return this.getDescri();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }
}