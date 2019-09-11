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

/**
 *
 * @author Emiliano Policardo <www.facebook.com/policomputacion>
 */
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JLabel;

public class Reloj extends JLabel implements Runnable {

    private String dia, mes, año, hora, minutos, segundos;
    private Calendar calendario = new GregorianCalendar();
    Thread hilo;

    public Reloj() { //Constructor 
        hilo = new Thread(this);
        hilo.start();

    } //fin constructor 

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == hilo) {
            try {
                actualiza();
                int mesE;
                mesE = Integer.valueOf(mes) + 1;

                setText("<html><center>" + dia + " / " + mesE + " / " + año + "<br>" + hora + ":" + minutos + ":" + segundos);

                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

    public String actualiza() {

        Date fechaHoraActual = new Date();
        calendario.setTime(fechaHoraActual);
        String reloj;

        hora = String.valueOf(calendario.get(Calendar.HOUR_OF_DAY));
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
        dia = calendario.get(Calendar.DATE) > 9 ? "" + calendario.get(Calendar.DATE) : "0" + calendario.get(Calendar.DATE);
        mes = calendario.get(Calendar.MONTH) > 9 ? "" + calendario.get(Calendar.MONTH) : "0" + calendario.get(Calendar.MONTH);
        año = calendario.get(Calendar.YEAR) > 9 ? "" + calendario.get(Calendar.YEAR) : "0" + calendario.get(Calendar.YEAR);
        reloj = dia + "/" + mes + "/" + año + "-" + hora + ":" + minutos;
        return reloj;
    }

}
