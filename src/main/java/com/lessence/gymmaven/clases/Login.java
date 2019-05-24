/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lessence.gymmaven.clases;

/**
 *
 * @author Emiliano
 */
public class Login {
  
    String Usuario;
    String Clave;
    String Base;
    String Nombre;
    String Apellido;


    public Login (String Base, String Usuario, String Clave, String Nombre, String Apellido){
         
            this.setUsuario(Usuario);
            this.setClave(Clave);
            this.setBase(Base);
            this.setNombre(Nombre);
            this.setApellido(Apellido);


    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getBase() {
        return Base;
    }

    public void setBase(String Base) {
        this.Base = Base;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }


}
