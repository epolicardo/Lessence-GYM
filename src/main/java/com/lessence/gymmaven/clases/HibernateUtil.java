/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lessence.gymmaven.clases;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {

        try {
            Configuration configuracion = new Configuration();
            String host = "localhost";
            String dbName = ParametrosSistema.db;
            String urlDB = "jdbc:mysql://" + host + "/" + dbName;

            configuracion.setProperty("hibernate.connection.url", urlDB);
            configuracion.setProperty("hibernate.connection.username", ParametrosSistema.userDB);
            configuracion.setProperty("hibernate.connection.password", ParametrosSistema.passDB);
            configuracion.setProperty("hibernate.connecttion.pool_size", "1");
            configuracion.setProperty("dialect", "org.hibernate.dialect.MySQL5Dialect");
            configuracion.setProperty("show_sql", "true");
            configuracion.setProperty("format_sql", "true");
            configuracion.setProperty("connection.driver_class", "com.mysql.jdbc.Driver");
            configuracion.setProperty("hibernate.enable_lazy_load_no_trans", "true");
            configuracion.setProperty("hbm2ddl.auto", "update"); 
            
//The list of possible options are:
//    validate: validate the schema, makes no changes to the database.
//    update: update the schema.
//    create: creates the schema, destroying previous data.
//    create-drop: drop the schema when the SessionFactory is closed explicitly, typically when the application is stopped.
            

            sessionFactory = configuracion.configure("hibernate.cfg.xml")
                    .addResource("mapeos/parametrosSistema.hbm.xml")
                    .addResource("mapeos/registroAsistenciasProfesores.hbm.xml")
                    .addResource("mapeos/Relaciones.hbm.xml")
                    .addResource("mapeos/actividades.hbm.xml")
                    .addResource("mapeos/actividadesSociosTurnos.hbm.xml")
                    .addResource("mapeos/cajaDiaria.hbm.xml")
                    .addResource("mapeos/registroAsistencias.hbm.xml")
                    .addResource("mapeos/cuotasRegistros.hbm.xml")
                    .addResource("mapeos/dias.hbm.xml")
                    .addResource("mapeos/estadoCivil.hbm.xml")
                    .addResource("mapeos/estados.hbm.xml")
                    .addResource("mapeos/formasPago.hbm.xml")
                    .addResource("mapeos/gastos.hbm.xml")
                    .addResource("mapeos/horarios.hbm.xml")
                    .addResource("mapeos/domicilios.hbm.xml")
                    .addResource("mapeos/localidades.hbm.xml")
                    .addResource("mapeos/provincias.hbm.xml")
                    .addResource("mapeos/paises.hbm.xml")
                    .addResource("mapeos/personas.hbm.xml")
                    .addResource("mapeos/profesores.hbm.xml")
                    .addResource("mapeos/socios.hbm.xml")
                    .addResource("mapeos/turnos.hbm.xml")
                    .addResource("mapeos/usuarios.hbm.xml")
                    .addResource("mapeos/proveedores.hbm.xml")
                    .addResource("mapeos/productos.hbm.xml")
                    .addResource("mapeos/marcas.hbm.xml")
                    .addResource("mapeos/familias.hbm.xml")
                    .addResource("mapeos/unidadesMedida.hbm.xml")
                    .addResource("mapeos/tiposProductos.hbm.xml")
                    .addResource("mapeos/listasPrecios.hbm.xml")
                    .addResource("mapeos/precios.hbm.xml")
                    .buildSessionFactory();
            return sessionFactory;
        } catch (HibernateException he) {
            System.err.println(
                    "Ocurrió un error en la inicialización de la SessionFactory: " + he);
            throw new ExceptionInInitializerError(he);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
