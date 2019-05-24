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
class TiposProductos {

    private int idTipo;
    private String tipoProducto;

    // 1-Bienes de Cambio / 2-Bienes de uso // Puede estar en varias categorias, por ejemplo insumo y bien de cambio (Harina en una panaderia)
    public TiposProductos() {
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

}
