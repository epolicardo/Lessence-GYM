/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lessence.gymmaven.GUI;

import static com.lessence.gymmaven.clases.IntConexion.Cnx;
import com.lessence.gymmaven.clases.ResultSetComboBoxModel;
import com.lessence.gymmaven.clases.Socios;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Emiliano
 */
public class GruposVisual extends javax.swing.JFrame {

    /**
     * Creates new form GruposVisual
     */
    public GruposVisual() {
        initComponents();
        ActualizarCombos("gym", "turnos", jCTurnos, "idTurnos", "Denominacion");
        ActualizarCombos("gym", "Disciplinas", jCDisciplinas, "idDisciplinas", "Denominacion");
        ActualizarCombos("gym", "Profesores", jCProfesor, "idProfesores", "idPersonas");
        ActualizarGrilla(null, 0);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jCDisciplinas = new javax.swing.JComboBox();
        jCProfesor = new javax.swing.JComboBox();
        jCTurnos = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTFiltrados = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jCDisciplinas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCDisciplinas.setSelectedIndex(-1);
        jCDisciplinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCDisciplinasActionPerformed(evt);
            }
        });

        jCProfesor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCProfesor.setSelectedIndex(-1);
        jCProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCProfesorActionPerformed(evt);
            }
        });

        jCTurnos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCTurnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTurnosActionPerformed(evt);
            }
        });

        jLabel1.setText("Disciplina");

        jLabel2.setText("Profesor");

        jLabel3.setText("Turno");

        jTFiltrados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Socio N°", "Nombre y Apellido", "Celular", "Correo", "Disciplina", "Profesor", "Turno"
            }
        ));
        jScrollPane1.setViewportView(jTFiltrados);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jCTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 370, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Consulta de Grupos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jCTurnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTurnosActionPerformed
        ActualizarGrilla("r.idTurnos", jCTurnos.getSelectedIndex() + 1);
        //jCDisciplinas.setSelectedIndex(-1);
        //jCProfesor.setSelectedIndex(-1);


    }//GEN-LAST:event_jCTurnosActionPerformed

    private void jCProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCProfesorActionPerformed

        ActualizarGrilla("r.idProfesores", jCProfesor.getSelectedIndex() + 1);
        //jCDisciplinas.setSelectedIndex(-1);
        //  jCTurnos.setSelectedIndex(-1);
    }//GEN-LAST:event_jCProfesorActionPerformed

    private void jCDisciplinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCDisciplinasActionPerformed

        ActualizarGrilla("r.idDisciplinas", jCDisciplinas.getSelectedIndex() + 1);
        //  jCTurnos.setSelectedIndex(-1);
        //  jCProfesor.setSelectedIndex(-1);
// TODO Mostrar Turno de cada socio:
    }//GEN-LAST:event_jCDisciplinasActionPerformed

    private void ActualizarGrilla(String Campo, int Valor) {

        try {
            ResultSet Resultado = Cnx.Consulta("SELECT * "
                    + /*s.idSocios, p. idPersonas, p.Apellido , p.Nombre, r.idTurnos, r.idDisciplinas, r.idProfesores*/ "FROM "
                    + "`gym`.`socios` S, gym.Personas P, gym.relacion_s_d_t_p R "
                    + "where S.idPersonas = P.idPersonas and S.idSocios = R.idSocios and " + Campo + "=" + Valor);

            int i = 0;
            DefaultTableModel modelo = (DefaultTableModel) jTFiltrados.getModel();
            modelo.setRowCount(i);
            while (Resultado.next()) {
                int id = Resultado.getInt("id");
                String DNI = Resultado.getString("DNI");
                int idDisciplinas = Resultado.getInt("idDisciplinas");
                int idTurnos = Resultado.getInt("idturnos");
                int idProfesores = Resultado.getInt("idProfesores");
                String Nombre = Resultado.getString("Nombre");
                String Apellido = Resultado.getString("Apellido");
                String Calle = Resultado.getString("Calle");
                String Nro = Resultado.getString("Nro");
                String Piso = Resultado.getString("Piso");
                String Dpto = Resultado.getString("Dpto");
                int Localidad = Resultado.getInt("idLocalidad");
                String Telefono = Resultado.getString("Telefono");
                String Celular = Resultado.getString("Celular");
                String Correo = Resultado.getString("CorreoElectronico");
                Date FechaNacimiento = Resultado.getDate("FechaNacimiento");
                int EstadoCivil = Resultado.getInt("EstadoCivil");
                int Hijos = Resultado.getInt("Hijos");
                int Sexo = Resultado.getInt("Sexo");
                int Estado = Resultado.getInt("Estado");
                Date FechaAlta = Resultado.getDate("FechaAlta");
                String AptoFisico = "";
                String Dec_Jurada = "";
                String Foto = "";
                Date PrimerVencimientoCuota = null;
                Date SegundoVencimientoCuota = null;
//
//                Socios socionuevo = new Socios(id, DNI, Apellido, Nombre, Calle,
//                        Nro, Piso, Dpto, Localidad, Telefono, Celular, Correo,
//                        FechaNacimiento, EstadoCivil, Hijos, Sexo, Estado, FechaAlta, AptoFisico, Dec_Jurada, Foto, PrimerVencimientoCuota, SegundoVencimientoCuota);
//                insertarEnJTableUnPersona(socionuevo, i);
//                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Form_Consulta_Socios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertarEnJTableUnPersona(Socios socionuevo, int i) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jTFiltrados.getModel();
        modelo.setRowCount(i);
//        String DNI = socionuevo.getDNI();
////        int idSocio = socionuevo.getId();
//        String Socio = socionuevo.getNombre() + " " + socionuevo.getApellido();
//        String Celular = socionuevo.getCelular();
//        String Correo = socionuevo.getCorreo();
////        Object[] fila = {idSocio, DNI, Socio, Celular, Correo};
////        modelo.addRow(fila);

    }

    private void ActualizarCombos(String Base, String Tabla, JComboBox Combo, String Columna1, String Columna2) {
        ResultSet rsl = Cnx.Consulta("select * from " + Base + "." + Tabla);
        try {
            Combo.setModel(new ResultSetComboBoxModel(rsl, Columna1, Columna2));
        } catch (SQLException ex) {
            ex.getErrorCode();
        }

    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jCDisciplinas;
    private javax.swing.JComboBox jCProfesor;
    private javax.swing.JComboBox jCTurnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTFiltrados;
    // End of variables declaration//GEN-END:variables
}