/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * LocalidadesVisual.java
 *
 * Created on 21/11/2010, 23:03:37
 */
package com.lessence.gymmaven.GUI;

import com.lessence.gymmaven.clases.Dias;
import com.lessence.gymmaven.clases.HibernateUtil;
import com.lessence.gymmaven.clases.Horarios;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Emiliano
 */
public class Form_ABM_Horarios extends javax.swing.JDialog{

    public Form_ABM_Horarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        LlenarTabla();

        String[] horariosDesde = new String[]{"8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00",
            "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00"};
        String[] horariosHasta = new String[]{"9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00",
            "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00", "23:30"};
        jSDesde.setModel(new javax.swing.SpinnerListModel(horariosDesde));
        jSHasta.setModel(new javax.swing.SpinnerListModel(horariosHasta));

        getRootPane().setDefaultButton(jBAñadir);
        this.setLocationRelativeTo(null);

        ActualizarDias();
//        ResultSet vtResultado = Cnx.Consulta("Select * from gym.horarios");
//
//        try {
//            while (vtResultado.next()) {
//                String horarios = vtResultado.getString("horarios");
//                InsertarenJTableHorarios(horarios);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Form_ABM_Horarios.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTaHorarios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jCDias = new javax.swing.JComboBox<>();
        jSDesde = new javax.swing.JSpinner();
        jSHasta = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTTurno = new javax.swing.JTextField();
        jBAñadir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTaHorarios.setAutoCreateRowSorter(true);
        jTaHorarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Turno"
            }
        ));
        jTaHorarios.setEditingColumn(0);
        jTaHorarios.setEditingRow(0);
        jTaHorarios.setName("jTaHorarios"); // NOI18N
        jTaHorarios.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTaHorarios);
        if (jTaHorarios.getColumnModel().getColumnCount() > 0) {
            jTaHorarios.getColumnModel().getColumn(0).setPreferredWidth(200);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Gestión de Turnos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("BankGothic Lt BT", 0, 14))); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N

        jCDias.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jCDias.setName("jCDias"); // NOI18N
        jCDias.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jCDiasFocusLost(evt);
            }
        });

        jSDesde.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jSDesde.setModel(new javax.swing.SpinnerListModel(new String[] {"8:00", "8:30", "9:00"}));
        jSDesde.setName("jSDesde"); // NOI18N
        jSDesde.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSDesdeStateChanged(evt);
            }
        });

        jSHasta.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jSHasta.setModel(new javax.swing.SpinnerListModel(new String[] {"8:30", "9:00", "9:30"}));
        jSHasta.setName("jSHasta"); // NOI18N
        jSHasta.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSHastaStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel2.setText("Día");
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel3.setText("Turno");
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel4.setText("Desde");
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel5.setText("Hasta");
        jLabel5.setName("jLabel5"); // NOI18N

        jTTurno.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jTTurno.setName("jTTurno"); // NOI18N

        jBAñadir.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jBAñadir.setText("Añadir");
        jBAñadir.setName("jBAñadir"); // NOI18N
        jBAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAñadirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCDias, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jSDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jSHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jTTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jBAñadir))))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jSDesde, jSHasta});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAñadir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ActualizarDias() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Criteria CriteriaDias = sesion.createCriteria(com.lessence.gymmaven.clases.Dias.class);
        List<com.lessence.gymmaven.clases.Dias> listaDias = CriteriaDias.list();
        for (int i = 0; i < listaDias.size(); i++) {
            jCDias.addItem(listaDias.get(i).getDia());
        }
    }


    private void jBAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAñadirActionPerformed
//        LlenarTurno();
        if (jTTurno.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar la descripcion del horario", "Carga de Horarios", ERROR);

        } else {
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();

            Criteria consulta = sesion.createCriteria(Dias.class);
            List<Dias> lista_dias = consulta.list();
            for (int i = 0; i < lista_dias.size(); i++) {
                Dias dia = lista_dias.get(i);
                if (jCDias.getSelectedIndex() + 1 == dia.getIdDia()) {
                    Horarios horario = new Horarios();
                    horario.setHorario(jTTurno.getText());
                    horario.setDia(dia);
                    sesion.save(horario);
                }
            }
            sesion.getTransaction().commit();
            JOptionPane.showMessageDialog(this, "El horario fue cargado con éxito", "Carga de Horarios", JOptionPane.INFORMATION_MESSAGE);
            LlenarTabla();
        }
    }//GEN-LAST:event_jBAñadirActionPerformed

    private void jCDiasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCDiasFocusLost
        LlenarTurno();
    }//GEN-LAST:event_jCDiasFocusLost

    private void jSDesdeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSDesdeStateChanged
        LlenarTurno();
    }//GEN-LAST:event_jSDesdeStateChanged

    private void jSHastaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSHastaStateChanged
        LlenarTurno();
    }//GEN-LAST:event_jSHastaStateChanged

    private void LlenarTurno() {
        
        jTTurno.setText(jCDias.getSelectedItem().toString() + " - "
                + jSDesde.getModel().getValue().toString() + " - "
                + jSHasta.getModel().getValue().toString());
    }

    private void FocoGanadoTextos(javax.swing.JTextField cajaTexto) {
        if (cajaTexto.getText().equals("0")) {
            cajaTexto.setText("");
            cajaTexto.setForeground(Color.black);
        }
    }

    public void LlenarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) jTaHorarios.getModel();
        modelo.setRowCount(0);
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Criteria consulta = sesion.createCriteria(Horarios.class);
        List<Horarios> listaRelaciones = consulta.list();
        for (int i = 0; i < listaRelaciones.size(); i++) {
            Horarios horario = listaRelaciones.get(i);

            Object[] fila = {horario.getHorario()};

            modelo.addRow(fila);

        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAñadir;
    private javax.swing.JComboBox<String> jCDias;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSDesde;
    private javax.swing.JSpinner jSHasta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTTurno;
    private javax.swing.JTable jTaHorarios;
    // End of variables declaration//GEN-END:variables
}
