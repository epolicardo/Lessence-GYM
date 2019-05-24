/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lessence.gymmaven.clases;

/**
 *
 * @author Emiliano
 */
public class Usuarios {

    private int idUsuario;
    private String Usuario;
    private String Clave;

   public Usuarios(){
       
   }
           
    
//    public Usuarios(String Nombre, String Apellido, String DNI, String NUsuario, String Clave) {
//
//        this.setId(id);
//        this.setNombre(Nombre);
//        this.setApellido(Apellido);
//        this.setDNI(DNI);
//        this.setNUsuario(NUsuario);
//        this.setClave(Clave);
//
//    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    

    
}
