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

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @since  21/12/2016
 * @author Emiliano Policardo <www.facebook.com/policomputacion>
 */
public class seteosGUI {

    /**
     * fechaCorta establece a partir de un parametro Date una fecha con formato
     * dd/MM/yy
     * FechaLarga devuelve dd/MM/yyyy
     * @see
     * @param fecha
     * @return dd/MM/yy
     */
    public static String fechaCorta(Date fecha) {
        String fechaFormateada = new SimpleDateFormat("dd/MM/yy").format(fecha);
        return fechaFormateada;
    }

    public static String fechaLarga(Date fecha) {

        String fechaFormateada = new SimpleDateFormat("dd/MM/yyyy").format(fecha);
        return fechaFormateada;
    }

    public static String fechaHora(Date fecha) {
        String fechaFormateada = new SimpleDateFormat("dd/MM/yyyy hh:mm").format(fecha);
        return fechaFormateada;
    }

    public static String fechaHoraconSegundos(Date fecha) {
        String fechaFormateada = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(fecha);
        return fechaFormateada;
    }
    public static String fechaHoraSistema (Date fecha) {
       String fechaFormateada = new SimpleDateFormat("ddMMyyyy hh:mm").format(fecha);
        return fechaFormateada;
    }

}
