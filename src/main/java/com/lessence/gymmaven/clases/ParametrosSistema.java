/*
 * Copyright 2016 Emiliano Policardo http://www.facebook.com/policomputacion.
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

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Emiliano Policardo http://www.facebook.com/policomputacion
 */
public class ParametrosSistema {

    public static String nombreEmpresa = "";
    public static String imagenEmpresa = "";
    public static int horasAsistencias;
    public static String mysqldump = "";
    public static int cantidadMovimientos;
    public static int estadoCaja;
    private static String equipoDB = "";
    private static String equipoAcceso = "";
    static int diasVigencia;
    static int avisoVencimientos;

    private int idParametro;
    private String parametro = "";
    private int valor;
    private String valorString = "";
    public static String hostname = "Host no Definido";
    public static String db = "gym";
    public static String userDB = "root";
    public static String passDB = "30782195";
    public static String dbRespaldo = "Ifj58oNk0a";
    public static String userDBRespaldo = "RCnZu4fCs9";
    public static String passDBRespaldo = "nAlBURMh3J";
    public static String passAdmin = "30782195";

    public ParametrosSistema() {

    }

    static String Host() {
        try {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();

        } catch (UnknownHostException ex) {
            System.out.println("El servidor no se encontró");
        }
        return hostname;
    }

    public static List<ParametrosSistema> listaParametros() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Criteria consulta = sesion.createCriteria(ParametrosSistema.class);
        List<ParametrosSistema> lista = consulta.list();
        sesion.close();
        return lista;
    }

    public static void LeerParametros() {
        List<ParametrosSistema> parametros = ParametrosSistema.listaParametros();
        if (parametros.isEmpty()) {
            inicializarSistema();
        } else {
            for (int i = 0; i < parametros.size(); i++) {
                ParametrosSistema parametro = parametros.get(i);
                switch (parametro.idParametro) {
                    case 1:
                        estadoCaja = parametro.getValor();
                        break;
                    case 2:
                        cantidadMovimientos = parametro.getValor();
                        break;
                    case 3:
                        mysqldump = parametro.getValorString();
                        break;
                    case 4:
                        diasVigencia = parametro.getValor();
                        break;
                    case 5:
                        avisoVencimientos = parametro.getValor();
                        break;
                    case 6:
                        horasAsistencias = parametro.getValor();
                        break;
                    case 7:
                        nombreEmpresa = parametro.getValorString();
                        break;
                    case 8:
                        imagenEmpresa = parametro.getValorString();
                        break;
                    case 9:
                        equipoDB = parametro.getValorString();
                        break;
                    case 10:
                        passAdmin = parametro.getValorString();

                }
            }
        }
    }

    public static void GuardaParametros() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Criteria consulta_parametros = sesion.createCriteria(ParametrosSistema.class
        );
        List<ParametrosSistema> param = consulta_parametros.list();
        sesion.beginTransaction();
        for (int i = 0; i < param.size(); i++) {
            ParametrosSistema parametro = param.get(i);
            switch (i) {
                case 0:
                    parametro.setValor(estadoCaja);
                    sesion.save(parametro);
                    break;
                case 1:
                    parametro.setValor(cantidadMovimientos);
                    sesion.save(parametro);
                    break;
                case 2:
                    parametro.setValorString(mysqldump);
                    sesion.save(parametro);
                    break;
                case 3:
                    parametro.setValor(diasVigencia);
                    sesion.save(parametro);
                    break;
                case 4:
                    parametro.setValor(avisoVencimientos);
                    sesion.save(parametro);
                    break;
                case 5:
                    parametro.setValor(horasAsistencias);
                    sesion.save(parametro);
                    break;
                case 6:
                    parametro.setValorString(nombreEmpresa);
                    sesion.save(parametro);
                    break;
                case 7:
                    parametro.setValorString(imagenEmpresa);
                    sesion.save(parametro);
                    break;
                case 8:
                    parametro.setValorString(equipoDB);
                    sesion.save(parametro);
                    break;
                case 9:
                    parametro.setValorString(passAdmin);
                    sesion.save(parametro);
                    break;
            }

        }
        sesion.getTransaction().commit();
        sesion.close();
    }

    public static void inicializarSistema() {
//        // TODO Aca cargo los datos de la base de datos inicial
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        for (int i = 1; i < 6; i++) {
            EstadoCivil estadoCivil = new EstadoCivil();
            switch (i) {
                case 1:
                    sesion.beginTransaction();
                    estadoCivil.setEstadoCivil("Soltero/a");
                    sesion.save(estadoCivil);
                    sesion.getTransaction().commit();
                    break;
                case 2:
                    sesion.beginTransaction();
                    estadoCivil.setEstadoCivil("Casado/a");
                    sesion.save(estadoCivil);
                    sesion.getTransaction().commit();
                    break;
                case 3:
                    sesion.beginTransaction();
                    estadoCivil.setEstadoCivil("Divorciado/a");
                    sesion.save(estadoCivil);
                    sesion.getTransaction().commit();
                    break;
                case 4:
                    sesion.beginTransaction();
                    estadoCivil.setEstadoCivil("Viudo/a");
                    sesion.save(estadoCivil);
                    sesion.getTransaction().commit();
                    break;
                case 5:
                    sesion.beginTransaction();
                    estadoCivil.setEstadoCivil("ND");
                    sesion.save(estadoCivil);
                    sesion.getTransaction().commit();
                    break;

            }
        }
        for (int i = 1; i < 3; i++) {
            Estados estado = new Estados();
            switch (i) {
                case 1:
                    sesion.beginTransaction();
                    estado.setEstado("Activo");
                    sesion.save(estado);
                    sesion.getTransaction().commit();
                    break;
                case 2:
                    sesion.beginTransaction();
                    estado.setEstado("Inactivo");
                    sesion.save(estado);
                    sesion.getTransaction().commit();
                    break;

            }
        }

        // Formas de pago
        for (int i = 1; i < 6; i++) {
            FormasPago formaPago = new FormasPago();
            switch (i) {
                case 1:
                    sesion.beginTransaction();
                    formaPago.setFormaPago("Contado");
                    sesion.save(formaPago);
                    sesion.getTransaction().commit();
                    break;
                case 2:
                    sesion.beginTransaction();
                    formaPago.setFormaPago("Debito");
                    sesion.save(formaPago);
                    sesion.getTransaction().commit();
                    break;
                case 3:
                    sesion.beginTransaction();
                    formaPago.setFormaPago("Crédito");
                    sesion.save(formaPago);
                    sesion.getTransaction().commit();
                    break;
                case 4:
                    sesion.beginTransaction();
                    formaPago.setFormaPago("Transferencia");
                    sesion.save(formaPago);
                    sesion.getTransaction().commit();
                    break;
                case 5:
                    sesion.beginTransaction();
                    formaPago.setFormaPago("Cheque");
                    sesion.save(formaPago);
                    sesion.getTransaction().commit();
                    break;
            }
        }

        //Dias
        for (int i = 1; i < 8; i++) {
            Dias dia = new Dias();
            switch (i) {
                case 1:
                    sesion.beginTransaction();
                    dia.setDia("Lunes");
                    sesion.save(dia);
                    sesion.getTransaction().commit();
                    break;
                case 2:
                    sesion.beginTransaction();
                    dia.setDia("Martes");
                    sesion.save(dia);
                    sesion.getTransaction().commit();
                    break;
                case 3:
                    sesion.beginTransaction();
                    dia.setDia("Miércoles");
                    sesion.save(dia);
                    sesion.getTransaction().commit();
                    break;
                case 4:
                    sesion.beginTransaction();
                    dia.setDia("Jueves");
                    sesion.save(dia);
                    sesion.getTransaction().commit();
                    break;
                case 5:
                    sesion.beginTransaction();
                    dia.setDia("Viernes");
                    sesion.save(dia);
                    sesion.getTransaction().commit();
                    break;
                case 6:
                    sesion.beginTransaction();
                    dia.setDia("Sábado");
                    sesion.save(dia);
                    sesion.getTransaction().commit();
                    break;
                case 7:
                    sesion.beginTransaction();
                    dia.setDia("Domingo");
                    sesion.save(dia);
                    sesion.getTransaction().commit();
                    break;
            }
        }

        for (int i = 1; i < 11; i++) {
            ParametrosSistema parametro = new ParametrosSistema();
            switch (i) {
                case 1:
                    sesion.beginTransaction();
                    parametro.setParametro("estadoCaja");
                    parametro.setValor(0);
                    sesion.save(parametro);
                    sesion.getTransaction().commit();
                    break;
                case 2:
                    sesion.beginTransaction();
                    parametro.setParametro("cantidadMovimientos");
                    parametro.setValor(0);
                    sesion.save(parametro);
                    sesion.getTransaction().commit();
                    break;
                case 3:
                    sesion.beginTransaction();
                    parametro.setParametro("mysqldump");
                    parametro.setValor(0);
                    sesion.save(parametro);
                    sesion.getTransaction().commit();
                    break;
                case 4:
                    sesion.beginTransaction();
                    parametro.setParametro("diasVigencia");
                    parametro.setValor(0);
                    sesion.save(parametro);
                    sesion.getTransaction().commit();
                    break;
                case 5:
                    sesion.beginTransaction();
                    parametro.setParametro("avisoVencimientos");
                    parametro.setValor(0);
                    sesion.save(parametro);
                    sesion.getTransaction().commit();
                    break;
                case 6:
                    sesion.beginTransaction();
                    parametro.setParametro("horasAsistencias");
                    parametro.setValor(0);
                    sesion.save(parametro);
                    sesion.getTransaction().commit();
                    break;
                case 7:
                    sesion.beginTransaction();
                    parametro.setParametro("nombreEmpresa");
                    parametro.setValor(0);
                    sesion.save(parametro);
                    sesion.getTransaction().commit();
                    break;
                case 8:
                    sesion.beginTransaction();
                    parametro.setParametro("imagenEmpresa");
                    parametro.setValor(0);
                    sesion.save(parametro);
                    sesion.getTransaction().commit();
                    break;
                case 9:
                    sesion.beginTransaction();
                    parametro.setParametro("equipoDB");
                    parametro.setValor(0);
                    sesion.save(parametro);
                    sesion.getTransaction().commit();
                    break;
                case 10:
                    sesion.beginTransaction();
                    parametro.setParametro("passAdmin");
                    parametro.setValor(0);
                    sesion.save(parametro);
                    sesion.getTransaction().commit();
                    break;
            }
        }
        sesion.close();
    }

    public static String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public static void setNombreEmpresa(String nombreEmpresa) {
        ParametrosSistema.nombreEmpresa = nombreEmpresa;
    }

    public static String getImagenEmpresa() {
        return imagenEmpresa;
    }

    public static void setImagenEmpresa(String imagenEmpresa) {
        ParametrosSistema.imagenEmpresa = imagenEmpresa;
    }

    public static int getHorasAsistencias() {
        return horasAsistencias;
    }

    public static void setHorasAsistencias(int horasAsistencias) {
        ParametrosSistema.horasAsistencias = horasAsistencias;
    }

    public static String getMysqldump() {
        return mysqldump;
    }

    public static void setMysqldump(String mysqldump) {
        ParametrosSistema.mysqldump = mysqldump;
    }

    public static int getCantidadMovimientos() {
        return cantidadMovimientos;
    }

    public static void setCantidadMovimientos(int cantidadMovimientos) {
        ParametrosSistema.cantidadMovimientos = cantidadMovimientos;
    }

    public static int getEstadoCaja() {
        return estadoCaja;
    }

    public static void setEstadoCaja(int estadoCaja) {
        ParametrosSistema.estadoCaja = estadoCaja;
    }

    public static String getEquipoDB() {
        return equipoDB;
    }

    public static void setEquipoDB(String equipoDB) {
        ParametrosSistema.equipoDB = equipoDB;
    }

    public static String getEquipoAcceso() {
        return equipoAcceso;
    }

    public static void setEquipoAcceso(String equipoAcceso) {
        ParametrosSistema.equipoAcceso = equipoAcceso;
    }

    public static int getDiasVigencia() {
        return diasVigencia;
    }

    public static void setDiasVigencia(int diasVigencia) {
        ParametrosSistema.diasVigencia = diasVigencia;
    }

    public static int getAvisoVencimientos() {
        return avisoVencimientos;
    }

    public static void setAvisoVencimientos(int avisoVencimientos) {
        ParametrosSistema.avisoVencimientos = avisoVencimientos;
    }

    public int getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(int idParametro) {
        this.idParametro = idParametro;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getValorString() {
        return valorString;
    }

    public void setValorString(String valorString) {
        this.valorString = valorString;
    }

    public static String getHostname() {
        return hostname;
    }

    public static void setHostname(String hostname) {
        ParametrosSistema.hostname = hostname;
    }

    public static String getDb() {
        return db;
    }

    public static void setDb(String db) {
        ParametrosSistema.db = db;
    }

    public static String getUserDB() {
        return userDB;
    }

    public static void setUserDB(String userDB) {
        ParametrosSistema.userDB = userDB;
    }

    public static String getPassDB() {
        return passDB;
    }

    public static void setPassDB(String passDB) {
        ParametrosSistema.passDB = passDB;
    }

    public static String getPassAdmin() {
        return passAdmin;
    }

    public static void setPassAdmin(String passAdmin) {
        ParametrosSistema.passAdmin = passAdmin;
    }

}
