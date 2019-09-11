/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lessence.gymmaven.clases;

import java.util.List;

/**
 *
 * @author Emiliano
 */
public class Paises {

    private int idPais;
    private String pais;
    private String codigoPais;
    private String codPaisTelefonia;
    private List<Provincias> provincia;

    public Paises() {

    }

    public List<Provincias> getProvincia() {
        return provincia;
    }

    public void setProvincia(List<Provincias> provincia) {
        this.provincia = provincia;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getCodPaisTelefonia() {
        return codPaisTelefonia;
    }

    public void setCodPaisTelefonia(String codPaisTelefonia) {
        this.codPaisTelefonia = codPaisTelefonia;
    }

}
