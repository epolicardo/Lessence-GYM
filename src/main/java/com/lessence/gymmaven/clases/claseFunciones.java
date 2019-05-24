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

import static com.lessence.gymmaven.clases.IntConexion.Cnx;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Emiliano Policardo <www.facebook.com/policomputacion>
 */
public final class claseFunciones {

    public static void ComboGenerico(JComboBox combo, String clase, String columna1, String columna2) {
        try {
            Cnx.Conexion();
            ResultSet rsl = Cnx.Consulta("select * from gym." + clase);
            combo.setModel(new ResultSetComboBoxModel(rsl, columna1, columna2));
        } catch (SQLException ex) {
            ex.getErrorCode();
        }
    }

    public static void LlenarJTables(JTable tabla, Class clase) {
//        Session sesion = HibernateUtil.getSessionFactory().openSession();
//        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
//        
//        Criteria consultaGenerica = sesion.createCriteria(clase);
//        List<Class> listaGenerica = consultaGenerica.list();
//        for (int i = 0; i < listaGenerica.size(); i++) {
//            modelo.setRowCount(i);
//                clase registro = listaGenerica.get(i);
////            String DNI = socio_leido.getPersona().getDNI();
//            String Socio = socio_leido.getPersona().getApellido() + " "
//                    + socio_leido.getPersona().getNombre();
//            String Celular = socio_leido.getPersona().getCelular();
//            String Correo = socio_leido.getPersona().getCorreo();
//            String Estado = socio_leido.getEstado().getEstado();
//            Object[] fila = {DNI, Socio, Celular, Correo, Estado};
//            modelo.addRow(fila);
//        }
//        sesion.close();
    }

    public static void llenarTablasGenerico(JTable tabla, List datos) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        Object[] fila = {};
        int datosSize = datos.size();
        for (int i = 0; i < datosSize; i++) {
            fila[i + 1] = datos.get(i);
            modelo.addRow(fila);
        }
    }

    public static String MD5(String texto) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(texto.getBytes());
            byte bytes[] = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(0xff & bytes[i]);
                if (hex.length() == 1) {
                    sb.append('0');
                }
                sb.append(hex);
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static void backup() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sesion.createCriteria(ParametrosSistema.class);
        List<ParametrosSistema> lista = criteria.list();
        String fecha = new SimpleDateFormat("dd-MM-yyyy hh:mm").format(Date.from(Instant.now()))+ " - Backup.sql" ;
        for (int i = 0; i < lista.size(); i++) {
            ParametrosSistema parametro = lista.get(i);
            if ("mysqldump".equals(parametro.getParametro())) {
                ParametrosSistema.mysqldump = parametro.getValorString();
                try {
                    Process p = Runtime.getRuntime().exec(ParametrosSistema.mysqldump + " gym -u root -p30782195");
                    new HiloLector(p.getErrorStream()).start();
                    InputStream is = p.getInputStream();
                    try (FileOutputStream fos = new FileOutputStream(fecha)) {
                        byte[] buffer = new byte[10000];

                        int leido = is.read(buffer);
                        while (leido > 0) {
                            fos.write(buffer, 0, leido);
                            leido = is.read(buffer);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "La copia de seguridad fue guardada con exito.", "Copia de Seguridad", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void restore() {
//        try {
//            Process p = Runtime
//                    .getRuntime()
//                    .exec("C:/Users/Emiliano/wamp64/bin/mysql/mysql5.7.9/bin/mysql gym -u root -p30782195");
//
//            OutputStream os = p.getOutputStream();
//            FileInputStream fis = new FileInputStream("backup_pruebas.sql");
//            byte[] buffer = new byte[1000];
//
//            int leido = fis.read(buffer);
//            while (leido > 0) {
//                os.write(buffer, 0, leido);
//                leido = fis.read(buffer);
//            }
//
//            os.flush();
//            os.close();
//            fis.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}
