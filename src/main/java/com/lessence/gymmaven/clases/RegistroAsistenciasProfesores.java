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

/**
 *
 * @author Emiliano Policardo <www.facebook.com/policomputacion>
 */
public class RegistroAsistenciasProfesores {

    private int idRegistroAsistenciaProfesores;
    private Date fecha;
    private Profesores profesor;

    public RegistroAsistenciasProfesores() {
    }
       
    public int getIdRegistroAsistenciaProfesores() {
        return idRegistroAsistenciaProfesores;
    }

    public void setIdRegistroAsistenciaProfesores(int idRegistroAsistenciaProfesores) {
        this.idRegistroAsistenciaProfesores = idRegistroAsistenciaProfesores;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Profesores getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }

  

}
