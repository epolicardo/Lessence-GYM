/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 *
 * Created on 9 de junio de 2015, 12:11
 */
package com.lessence.gymmaven.clases;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    public ResultSet result;
    public Statement St;
    public Connection cn = null;

    public void Conexion() {
        try {
            String UserBD = "root";
            String PassBD = "30782195";

            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/gym?useUnicode=true&amp;useJDBCCompliantTimezoneShift=true&amp;useLegacyDatetimeCode=false&amp;serverTimezone=UTC", UserBD, PassBD);
            System.out.println("Se conecto correctamente. Usuario: " + UserBD + "\n");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
//        return Conexion();
    }

//    public void Conexion(String DB, String UserBD, String PassBD) {
//
//        
//            Class.forName("org.gjt.mm.mysql.Driver");
//            String MyserverName = "localhost";
//            String Mydatabase = "mydatabase";
//            cn = DriverManager.getConnection("jdbc:mysql://localhost/" + DB, UserBD, PassBD);
//            System.out.println("Se conecto correctamente: " + UserBD + " / Base: " + DB);
//       
//    }
    public void CerrarConexionDB() {
        //TODO Corregir Aperturas y Cierres de la base de datos
        /* try {
           // cn.close();
            System.out.println("Conexion Cerrada."+ "\n");
        } catch (SQLException ex) {
            System.out.println("Error al intentar cerrar la base " + ex.getMessage()+ "\n");
        }*/
    }

    public String Ejecutar(String sql) {
        String error = "";
        try {
            St = cn.createStatement();
            St.execute(sql);
            System.out.println("Ejecutado correctamente: " + sql + "\n");
        } catch (Exception ex) {
            error = ex.getMessage();
            System.err.println(error + " -/- Sentencia erronea: " + sql + "\n");
        }

        return (error);
    }

    public String Actualizar(String sql) {
        String error = "";
        try {
            St = cn.createStatement();
            St.executeUpdate(sql);
            System.out.println("Ejecutado correctamente: " + sql + "\n");
        } catch (Exception ex) {
            error = ex.getMessage();
            System.err.println(error + " -/- Sentencia erronea: " + sql + "\n");
        }

        return (error);
    }

    public ResultSet Consulta(String sql) {
        String error = "";
        try {
            St = cn.createStatement();
            result = St.executeQuery(sql);

        } catch (Exception ee) {
            error = ee.getMessage();
            System.err.print(error + " -/- Sentencia erronea: " + sql + "\n");
        }
        return (result);
    }

}
