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
public final class Medidas {

    String Fecha;
    String Alto;
    String Pecho;
    String Abdomen;
    String Cintura;
    String BrazoIzq;
    String BrazoDer;
    String MusloIzq;
    String MusloDer;

    public Medidas(String Fecha, String Alto, String Pecho, String Abdomen, String Cintura, String BrazoIzq, String BrazoDer, String MusloIzq, String MusloDer) {

        this.setAbdomen(Abdomen);
        this.setAlto(Alto);
        this.setPecho(Pecho);
        this.setCintura(Cintura);
        this.setBrazoIzq(BrazoIzq);
        this.setBrazoDer(BrazoDer);
        this.setMusloIzq(MusloIzq);
        this.setMusloDer(MusloDer);
              
        
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getAlto() {
        return Alto;
    }

    public void setAlto(String Alto) {
        this.Alto = Alto;
    }

    public String getPecho() {
        return Pecho;
    }

    public void setPecho(String Pecho) {
        this.Pecho = Pecho;
    }

    public String getAbdomen() {
        return Abdomen;
    }

    public void setAbdomen(String Abdomen) {
        this.Abdomen = Abdomen;
    }

    public String getCintura() {
        return Cintura;
    }

    public void setCintura(String Cintura) {
        this.Cintura = Cintura;
    }

    public String getBrazoIzq() {
        return BrazoIzq;
    }

    public void setBrazoIzq(String BrazoIzq) {
        this.BrazoIzq = BrazoIzq;
    }

    public String getBrazoDer() {
        return BrazoDer;
    }

    public void setBrazoDer(String BrazoDer) {
        this.BrazoDer = BrazoDer;
    }

    public String getMusloIzq() {
        return MusloIzq;
    }

    public void setMusloIzq(String MusloIzq) {
        this.MusloIzq = MusloIzq;
    }

    public String getMusloDer() {
        return MusloDer;
    }

    public void setMusloDer(String MusloDer) {
        this.MusloDer = MusloDer;
    }

}
