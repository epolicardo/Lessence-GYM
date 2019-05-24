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
package com.lessence.gymmaven.GUI;

import com.lessence.gymmaven.clases.Actividades_Socios_Turnos;
import com.lessence.gymmaven.clases.HibernateUtil;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Emiliano Policardo <www.facebook.com/policomputacion>
 */
public class Form_Gestion_Pases extends javax.swing.JFrame {

    /**
     * Creates new form Form_Gestion_Pases
     */
    public Form_Gestion_Pases() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jcPrimerActividad = new javax.swing.JCheckBox();
        jcSegundaActividad = new javax.swing.JCheckBox();
        jPPasesActividad1 = new javax.swing.JPanel();
        jCActividades1 = new javax.swing.JComboBox<>();
        jRBPaseLibre1 = new javax.swing.JRadioButton();
        jRB4Pases1 = new javax.swing.JRadioButton();
        jRB8Pases1 = new javax.swing.JRadioButton();
        jRB12Pases1 = new javax.swing.JRadioButton();
        jsPasesVariablesAct1 = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        jRBPases = new javax.swing.JRadioButton();
        jcEliminaPasesPrevios = new javax.swing.JCheckBox();
        jPPasesActividad2 = new javax.swing.JPanel();
        jCActividades2 = new javax.swing.JComboBox<>();
        jrbPaseLibre = new javax.swing.JRadioButton();
        jrb4Pases = new javax.swing.JRadioButton();
        jrb8Pases = new javax.swing.JRadioButton();
        jrb12Pases = new javax.swing.JRadioButton();
        jsPasesVariablesAct2 = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        jrbPases = new javax.swing.JRadioButton();
        jtDocumento = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jBBuscar = new javax.swing.JButton();
        jTNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBGuardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jcPrimerActividad.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jcPrimerActividad.setText("Primer Actividad");
        jcPrimerActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcPrimerActividadActionPerformed(evt);
            }
        });

        jcSegundaActividad.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jcSegundaActividad.setText("Segunda Actividad");
        jcSegundaActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcSegundaActividadActionPerformed(evt);
            }
        });

        jPPasesActividad1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Asignar Pases", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("BankGothic Lt BT", 0, 14))); // NOI18N
        jPPasesActividad1.setEnabled(false);

        jCActividades1.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jCActividades1.setEnabled(false);

        buttonGroup1.add(jRBPaseLibre1);
        jRBPaseLibre1.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jRBPaseLibre1.setText("Pase Libre");
        jRBPaseLibre1.setEnabled(false);

        buttonGroup1.add(jRB4Pases1);
        jRB4Pases1.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jRB4Pases1.setText("4 Pases");
        jRB4Pases1.setEnabled(false);

        buttonGroup1.add(jRB8Pases1);
        jRB8Pases1.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jRB8Pases1.setText("8 Pases");
        jRB8Pases1.setEnabled(false);

        buttonGroup1.add(jRB12Pases1);
        jRB12Pases1.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jRB12Pases1.setText("12 Pases");
        jRB12Pases1.setEnabled(false);

        jsPasesVariablesAct1.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jsPasesVariablesAct1.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel16.setText("Pases");
        jLabel16.setEnabled(false);

        buttonGroup1.add(jRBPases);
        jRBPases.setEnabled(false);

        javax.swing.GroupLayout jPPasesActividad1Layout = new javax.swing.GroupLayout(jPPasesActividad1);
        jPPasesActividad1.setLayout(jPPasesActividad1Layout);
        jPPasesActividad1Layout.setHorizontalGroup(
            jPPasesActividad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPasesActividad1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPPasesActividad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCActividades1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPPasesActividad1Layout.createSequentialGroup()
                        .addGroup(jPPasesActividad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRB12Pases1)
                            .addComponent(jRB8Pases1)
                            .addComponent(jRB4Pases1)
                            .addComponent(jRBPaseLibre1)
                            .addGroup(jPPasesActividad1Layout.createSequentialGroup()
                                .addComponent(jRBPases)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jsPasesVariablesAct1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)))
                        .addGap(0, 95, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPPasesActividad1Layout.setVerticalGroup(
            jPPasesActividad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPasesActividad1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCActividades1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jRB4Pases1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRB8Pases1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRB12Pases1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBPaseLibre1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPPasesActividad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsPasesVariablesAct1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jRBPases))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jcEliminaPasesPrevios.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jcEliminaPasesPrevios.setText("Elimina pases previos disponibles");

        jPPasesActividad2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Asignar Pases", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("BankGothic Lt BT", 0, 14))); // NOI18N
        jPPasesActividad2.setEnabled(false);

        jCActividades2.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jCActividades2.setEnabled(false);

        buttonGroup2.add(jrbPaseLibre);
        jrbPaseLibre.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jrbPaseLibre.setText("Pase Libre");
        jrbPaseLibre.setEnabled(false);

        buttonGroup2.add(jrb4Pases);
        jrb4Pases.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jrb4Pases.setText("4 Pases");
        jrb4Pases.setEnabled(false);

        buttonGroup2.add(jrb8Pases);
        jrb8Pases.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jrb8Pases.setText("8 Pases");
        jrb8Pases.setEnabled(false);

        buttonGroup2.add(jrb12Pases);
        jrb12Pases.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jrb12Pases.setText("12 Pases");
        jrb12Pases.setEnabled(false);

        jsPasesVariablesAct2.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jsPasesVariablesAct2.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel14.setText("Pases");
        jLabel14.setEnabled(false);

        buttonGroup2.add(jrbPases);
        jrbPases.setEnabled(false);

        javax.swing.GroupLayout jPPasesActividad2Layout = new javax.swing.GroupLayout(jPPasesActividad2);
        jPPasesActividad2.setLayout(jPPasesActividad2Layout);
        jPPasesActividad2Layout.setHorizontalGroup(
            jPPasesActividad2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPasesActividad2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPPasesActividad2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCActividades2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPPasesActividad2Layout.createSequentialGroup()
                        .addGroup(jPPasesActividad2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrb12Pases)
                            .addComponent(jrb8Pases)
                            .addComponent(jrb4Pases)
                            .addComponent(jrbPaseLibre)
                            .addGroup(jPPasesActividad2Layout.createSequentialGroup()
                                .addComponent(jrbPases)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jsPasesVariablesAct2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)))
                        .addGap(0, 95, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPPasesActividad2Layout.setVerticalGroup(
            jPPasesActividad2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPasesActividad2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCActividades2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jrb4Pases)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrb8Pases)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrb12Pases)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbPaseLibre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPPasesActividad2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsPasesVariablesAct2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jrbPases))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcEliminaPasesPrevios)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcPrimerActividad)
                            .addComponent(jPPasesActividad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcSegundaActividad)
                            .addComponent(jPPasesActividad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPPasesActividad1, jPPasesActividad2});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jcEliminaPasesPrevios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcPrimerActividad)
                    .addComponent(jcSegundaActividad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPPasesActividad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPPasesActividad2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jtDocumento.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jtDocumento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtDocumentoFocusGained(evt);
            }
        });
        jtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtDocumentoKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel8.setText("Apellido y Nombre");

        jLabel1.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel1.setText("Documento");

        jBBuscar.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jTNombre.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Actividad", "Turno", "Profesor", "Pases"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jBGuardar.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBBuscar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBBuscar)
                    .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBGuardar)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        List<Actividades_Socios_Turnos> listaActividades_Socios_Turnos = Actividades_Socios_Turnos.listaActividades_Socios_Turnos();
        int pases = 0;
        if (jcPrimerActividad.isSelected()) {
            for (int r = 0; r < listaActividades_Socios_Turnos.size(); r++) {
                Actividades_Socios_Turnos ast = listaActividades_Socios_Turnos.get(r);
                if (ast.getSocio().getPersona().getDNI().equals(jtDocumento.getText())) {
                    if (ast.getRelacion().getActividad().getActividad().equals(jCActividades1.getItemAt(jCActividades1.getSelectedIndex()))) {
                        if (jcEliminaPasesPrevios.isSelected()) {
                            pases = 0;
                            ast.setPases(0);
                        }
                        pases = ast.getPases();
                        if (jRB4Pases1.isSelected()) {
                            pases = pases + 4;
                            ast.setPases(pases);
                            ast.setPaseLibre(0);
                        }
                        if (jRB8Pases1.isSelected()) {
                            pases = pases + 8;
                            ast.setPases(pases);
                            ast.setPaseLibre(0);
                        }
                        if (jRB12Pases1.isSelected()) {
                            pases = pases + 12;
                            ast.setPases(pases);
                            ast.setPaseLibre(0);
                        }
                        if (jRBPases.isSelected()) {
                            pases = pases + Integer.parseInt(jsPasesVariablesAct1.getValue().toString());
                            ast.setPases(pases);
                            ast.setPaseLibre(0);
                        }
                        if (jRBPaseLibre1.isSelected()) {
                            ast.setPases(0);
                            ast.setPaseLibre(1);
                        }
                    } else {
                        if (jcSegundaActividad.isSelected()) {
                            if (ast.getRelacion().getActividad().getActividad().equals(jCActividades2.getItemAt(jCActividades2.getSelectedIndex()))) {
                                if (jcEliminaPasesPrevios.isSelected()) {
                                    pases = 0;
                                    ast.setPases(0);
                                }
                                pases = ast.getPases();
                                if (jrb4Pases.isSelected()) {
                                    pases = pases + 4;
                                    ast.setPases(pases);
                                    ast.setPaseLibre(0);
                                }
                                if (jrb8Pases.isSelected()) {
                                    pases = pases + 8;
                                    ast.setPases(pases);
                                    ast.setPaseLibre(0);
                                }
                                if (jrb12Pases.isSelected()) {
                                    pases = pases + 12;
                                    ast.setPases(pases);
                                    ast.setPaseLibre(0);
                                }
                                if (jrbPases.isSelected()) {
                                    pases = pases + Integer.parseInt(jsPasesVariablesAct2.getValue().toString());
                                    ast.setPases(pases);
                                    ast.setPaseLibre(0);
                                }
                                if (jrbPaseLibre.isSelected()) {
                                    ast.setPases(0);
                                    ast.setPaseLibre(1);
                                }
                            }
                        }
                    }
                    sesion.update(ast);
                }

            }

            sesion.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "La modificación se realizó con éxito", "Gestión de pases", JOptionPane.INFORMATION_MESSAGE);

            sesion.close();
        }
    }//GEN-LAST:event_jBGuardarActionPerformed

    

    private void LlenarComboActividades(JComboBox<String> comboaLlenar) {
        comboaLlenar.removeAllItems();
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Criteria consultaActividades = sesion.createCriteria(Actividades_Socios_Turnos.class
        );
        List<Actividades_Socios_Turnos> listaFiltrada = consultaActividades.list();
        listaFiltrada.clear();

        List<Actividades_Socios_Turnos> listaActividades = consultaActividades.list();
        boolean existeActividad = false;
        for (int i = 0; i < listaActividades.size(); i++) {
            Actividades_Socios_Turnos actividad = listaActividades.get(i);
            if (actividad.getSocio().getPersona().getDNI().equals(jtDocumento.getText())) {
                existeActividad = false;
                if (listaFiltrada.isEmpty()) {
                    listaFiltrada.add(actividad);

                } else {
                    for (int j = 0; j < listaFiltrada.size(); j++) {
                        if (listaFiltrada.get(j).getRelacion().getActividad().getIdActividad() == actividad.getRelacion().getActividad().getIdActividad()) {
                            existeActividad = true;
                        } else {
                        }

                    }
                    if (existeActividad == false) {
                        listaFiltrada.add(actividad);
                    }

                }

            }
        }
        for (int h = 0; h < listaFiltrada.size(); h++) {
            comboaLlenar.addItem(listaFiltrada.get(h).getRelacion().getActividad().getActividad());

        }
    }


    private void jtDocumentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtDocumentoFocusGained
        getRootPane().setDefaultButton(jBBuscar);
    }//GEN-LAST:event_jtDocumentoFocusGained

    private void jtDocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDocumentoKeyPressed

    }//GEN-LAST:event_jtDocumentoKeyPressed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed

        if (jtDocumento.getText().equals("")) {
            //Pedir documento
        } else {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0);
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            Criteria consultaRelacion = sesion.createCriteria(Actividades_Socios_Turnos.class
            );
            List<Actividades_Socios_Turnos> listaRelaciones = consultaRelacion.list();
            String pases = "";

            for (int h = 0; h < listaRelaciones.size(); h++) {
                Actividades_Socios_Turnos relacion = listaRelaciones.get(h);

                if (relacion.getSocio().getPersona().getDNI().equals(jtDocumento.getText())) {
                    jTNombre.setText(relacion.getSocio().getPersona().getApellido() + ", " + relacion.getSocio().getPersona().getNombre());
                    if (relacion.getPaseLibre() == 1) {
                        pases = "Pase Libre";
                    } else {
                        pases = String.valueOf(relacion.getPases());
                    }
                    Object[] fila = {relacion.getRelacion().getActividad().getActividad(),
                        relacion.getRelacion().getHorario().getHorario(),
                        relacion.getRelacion().getProfesor().getPersona().getApellido() + ", "
                        + relacion.getRelacion().getProfesor().getPersona().getNombre(), pases};
                    modelo.addRow(fila);
                }
            }
        }

    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jcPrimerActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcPrimerActividadActionPerformed
        if (jcPrimerActividad.isSelected()) {
            LlenarComboActividades(jCActividades1);
            jPPasesActividad1.setEnabled(true);
            for (int i = 0; i < jPPasesActividad1.getComponentCount(); i++) {
                jPPasesActividad1.getComponent(i).setEnabled(true);
            }
        } else {
            jPPasesActividad1.setEnabled(false);
        }
    }//GEN-LAST:event_jcPrimerActividadActionPerformed

    private void jcSegundaActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcSegundaActividadActionPerformed
        if (jcPrimerActividad.isSelected()) {
            if (jcSegundaActividad.isSelected()) {
                if (jCActividades1.getItemCount() > 1) {
                    LlenarComboActividades(jCActividades2);
                    jPPasesActividad2.setEnabled(true);
                    for (int i = 0; i < jPPasesActividad2.getComponentCount(); i++) {
                        jPPasesActividad2.getComponent(i).setEnabled(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El socio tiene asignada solo una actividad", "Gestión de Cuentas", JOptionPane.ERROR_MESSAGE);
                    jcSegundaActividad.setSelected(false);
                }
            } else {
                jPPasesActividad2.setEnabled(false);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No puede asignar pases sin seleccionar antes la primer actividad.",
                    "Gestion de Cuenta y Pases", JOptionPane.INFORMATION_MESSAGE);
            jcSegundaActividad.setSelected(false);
        }
    }//GEN-LAST:event_jcSegundaActividadActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jCActividades1;
    private javax.swing.JComboBox<String> jCActividades2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPPasesActividad1;
    private javax.swing.JPanel jPPasesActividad2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRB12Pases1;
    private javax.swing.JRadioButton jRB4Pases1;
    private javax.swing.JRadioButton jRB8Pases1;
    private javax.swing.JRadioButton jRBPaseLibre1;
    private javax.swing.JRadioButton jRBPases;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTable jTable1;
    private javax.swing.JCheckBox jcEliminaPasesPrevios;
    private javax.swing.JCheckBox jcPrimerActividad;
    private javax.swing.JCheckBox jcSegundaActividad;
    private javax.swing.JRadioButton jrb12Pases;
    private javax.swing.JRadioButton jrb4Pases;
    private javax.swing.JRadioButton jrb8Pases;
    private javax.swing.JRadioButton jrbPaseLibre;
    private javax.swing.JRadioButton jrbPases;
    private javax.swing.JSpinner jsPasesVariablesAct1;
    private javax.swing.JSpinner jsPasesVariablesAct2;
    private javax.swing.JTextField jtDocumento;
    // End of variables declaration//GEN-END:variables
}