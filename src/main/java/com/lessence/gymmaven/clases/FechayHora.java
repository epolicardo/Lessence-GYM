package com.lessence.gymmaven.clases;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class FechayHora {

    public static String Fecha() {

        //System.out.println(new Date());
        Calendar c = new GregorianCalendar();
        String dia, mes, annio;
        dia = Integer.toString(c.get(Calendar.DATE));
        mes = Integer.toString(c.get(Calendar.MONTH) + 1);
        annio = Integer.toString(c.get(Calendar.YEAR));
        //System.out.println(dia + "/" + mes + "/" + annio);
        String Fecha = (dia + "/" + mes + "/" + annio);
        return (Fecha);

    }

    public static String FechaBD() {

        Calendar c = new GregorianCalendar();
        String dia, mes, annio;
        dia = Integer.toString(c.get(Calendar.DATE));
        mes = Integer.toString(c.get(Calendar.MONTH) + 1);
        annio = Integer.toString(c.get(Calendar.YEAR));
        String Fecha = (annio + "/" + mes + "/" + dia);
        return (Fecha);

    }

    public static String Hora() {
        // Ambas instanciaciones son válidas
        Calendar calendario = new GregorianCalendar();
        //Calendar calendario = Calendar.getInstance();
        int hora, minutos, segundos;
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        String Hora = (hora + ":" + minutos);
        return (Hora);
    }

    public static String FechayHoraDB() {

        Calendar c = new GregorianCalendar();
        String dia, mes, annio;
        int hora, minutos, segundos;
        dia = Integer.toString(c.get(Calendar.DATE));
        mes = Integer.toString(c.get(Calendar.MONTH) + 1);
        annio = Integer.toString(c.get(Calendar.YEAR));
        hora = c.get(Calendar.HOUR_OF_DAY);
        minutos = c.get(Calendar.MINUTE);
        segundos = c.get(Calendar.SECOND);
        

        String FechayHoraDB = (annio + "-" + mes + "-" + dia + " " + hora + ":" + minutos +":"+segundos);
        return (FechayHoraDB);

    }

}
