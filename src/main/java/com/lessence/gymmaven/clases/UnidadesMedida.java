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
class UnidadesMedida {

    private int idUM;
    private String codigo;
    private String um;

    public UnidadesMedida() {
    }

    public int getIdUM() {
        return idUM;
    }

    public void setIdUM(int idUM) {
        this.idUM = idUM;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUm() {
        return um;
    }

    public void setUm(String um) {
        this.um = um;
    }

   

}
