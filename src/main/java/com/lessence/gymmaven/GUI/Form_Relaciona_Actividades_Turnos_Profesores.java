/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lessence.gymmaven.GUI;

import com.lessence.gymmaven.clases.Actividades;
import com.lessence.gymmaven.clases.HibernateUtil;
import com.lessence.gymmaven.clases.Horarios;
import com.lessence.gymmaven.clases.Profesores;
import com.lessence.gymmaven.clases.Relaciones;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

/**
 *
 * @author Emiliano
 */
public class Form_Relaciona_Actividades_Turnos_Profesores extends javax.swing.JDialog {

    private Relaciones modificarRelacion;

    public Form_Relaciona_Actividades_Turnos_Profesores(java.awt.Frame parent, boolean modal) {
        this.modificarRelacion = null;
        initComponents();
        LlenarTabla();
        this.setLocationRelativeTo(null);
    }

    public void LlenarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) jTActividades.getModel();
        modelo.setRowCount(0);
        List<Relaciones> listaRelaciones = Relaciones.listaRelaciones();
        for (int i = 0; i < listaRelaciones.size(); i++) {
            Relaciones relacion = listaRelaciones.get(i);
            Object[] fila = {relacion.getActividad().getActividad(), relacion.getHorario().getHorario(), relacion.getProfesor().getPersona().getNombre() + " "
                + relacion.getProfesor().getPersona().getApellido()};
            modelo.addRow(fila);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPNuevaDisciplinaenSocio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCActividades = new javax.swing.JComboBox();
        jCProfesores = new javax.swing.JComboBox();
        jCHorarios = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jBGuardarRelacion = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTActividades = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jBAgregar = new javax.swing.JButton();
        jBModificar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel1.setText("Actividades");
        jLabel1.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel2.setText("Profesores");
        jLabel2.setEnabled(false);

        jCActividades.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jCActividades.setEnabled(false);

        jCProfesores.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jCProfesores.setEnabled(false);

        jCHorarios.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jCHorarios.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel5.setText("Turnos");
        jLabel5.setEnabled(false);

        jBGuardarRelacion.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jBGuardarRelacion.setText("Grabar Relación");
        jBGuardarRelacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarRelacionActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jButton1.setText("Cancelar");

        javax.swing.GroupLayout jPNuevaDisciplinaenSocioLayout = new javax.swing.GroupLayout(jPNuevaDisciplinaenSocio);
        jPNuevaDisciplinaenSocio.setLayout(jPNuevaDisciplinaenSocioLayout);
        jPNuevaDisciplinaenSocioLayout.setHorizontalGroup(
            jPNuevaDisciplinaenSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPNuevaDisciplinaenSocioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPNuevaDisciplinaenSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jCActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPNuevaDisciplinaenSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPNuevaDisciplinaenSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPNuevaDisciplinaenSocioLayout.createSequentialGroup()
                        .addComponent(jCProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBGuardarRelacion, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addComponent(jLabel2))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPNuevaDisciplinaenSocioLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCActividades, jCHorarios, jCProfesores});

        jPNuevaDisciplinaenSocioLayout.setVerticalGroup(
            jPNuevaDisciplinaenSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPNuevaDisciplinaenSocioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPNuevaDisciplinaenSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPNuevaDisciplinaenSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCActividades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBGuardarRelacion)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTActividades.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jTActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Actividades", "Turnos", "Profesor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTActividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTActividadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTActividades);

        jScrollPane2.setViewportView(jScrollPane1);

        jBAgregar.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jBAgregar.setText("Agregar Relación");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        jBModificar.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jBModificar.setText("Modificar Relación");
        jBModificar.setEnabled(false);
        jBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jButton2.setText("Eliminar Relacion");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAgregar)
                    .addComponent(jBModificar)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPNuevaDisciplinaenSocio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPNuevaDisciplinaenSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed

        List<Profesores> listaProfesores = Profesores.consultaBase();
        for (int i = 0; i < listaProfesores.size(); i++) {
            Profesores profesor = listaProfesores.get(i);
            jCProfesores.addItem(profesor.getPersona().getNombre() + " " + profesor.getPersona().getApellido());
        }
        List<Actividades> listaActividades = Actividades.listaActividades();
        for (int i = 0; i < listaActividades.size(); i++) {
            Actividades actividad = listaActividades.get(i);
            jCActividades.addItem(actividad.toString());
        }

        List<Horarios> listaHorarios = Horarios.consultaHorarios();
        for (int i = 0; i < listaHorarios.size(); i++) {
            Horarios horario = listaHorarios.get(i);
            jCHorarios.addItem(horario.getHorario());
        }

        int i = jPNuevaDisciplinaenSocio.getComponentCount();
        for (int j = 0; j < i; j++) {
            jPNuevaDisciplinaenSocio.getComponent(j).setEnabled(true);

        }
        jCActividades.setSelectedIndex(-1);
        jCHorarios.setSelectedIndex(-1);
        jCProfesores.setSelectedIndex(-1);

    }//GEN-LAST:event_jBAgregarActionPerformed


    private void jTActividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTActividadesMouseClicked
        jBModificar.setEnabled(true);

    }//GEN-LAST:event_jTActividadesMouseClicked

    private void jBGuardarRelacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarRelacionActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTActividades.getModel();
        if (jBGuardarRelacion.getText().equals("Guardar Modificación")) {
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();

            List<Actividades> listaActividades = Actividades.listaActividades();
            List<Horarios> consultaHorarios = Horarios.consultaHorarios();
            List<Profesores> listaProfesores = Profesores.consultaBase();
            List<Relaciones> listaRelaciones = Relaciones.listaRelaciones();
            for (int i = 0; i < listaRelaciones.size(); i++) {
                Relaciones relacion = listaRelaciones.get(i);
                if (relacion.getActividad().getActividad().equals(modelo.getValueAt(jTActividades.getSelectedRow(), 0))) {
                    if (relacion.getHorario().getHorario().equals(modelo.getValueAt(jTActividades.getSelectedRow(), 1))) {
                        String profesor = relacion.getProfesor().getPersona().getNombre() + " " + relacion.getProfesor().getPersona().getApellido();
                        if (profesor.equals(modelo.getValueAt(jTActividades.getSelectedRow(), 2))) {
                            modificarRelacion = relacion;

                        }

                    }
                }
            }
            for (int i = 0; i < listaActividades.size(); i++) {
                Actividades actividad = listaActividades.get(i);
                if (jCActividades.getSelectedItem().toString().equals(actividad.getActividad())) {
                    for (int j = 0; j < consultaHorarios.size(); j++) {
                        Horarios horario = consultaHorarios.get(j);
                        if (jCHorarios.getSelectedItem().equals(horario.getHorario())) {
                            for (int k = 0; k < listaProfesores.size(); k++) {
                                Profesores profesor = listaProfesores.get(k);
                                if (jCProfesores.getSelectedItem().equals(profesor.getPersona().getNombre() + " " + profesor.getPersona().getApellido())) {
                                    modificarRelacion.setActividad(actividad);
                                    modificarRelacion.setHorario(horario);
                                    modificarRelacion.setProfesor(profesor);
                                    sesion.update(modificarRelacion);
                                    k = listaProfesores.size();
                                    j = consultaHorarios.size();
                                    i = listaActividades.size();
                                    JOptionPane.showMessageDialog(this, "La actualizacion se completó con éxito", "Gestion de Profesores", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        }
                    }
                }
            }
            sesion.getTransaction().commit();
            sesion.close();
            LlenarTabla();
        } else {

            Session sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            Relaciones relacion = new Relaciones();
            List<Actividades> listaActividades = Actividades.listaActividades();
            for (int i = 0; i < listaActividades.size(); i++) {
                Actividades actividad = listaActividades.get(i);
                if (jCActividades.getSelectedItem().equals(actividad.getActividad())) {
                    relacion.setActividad(actividad);
                }
            }
            List<Horarios> listaHorarios = Horarios.consultaHorarios();
            for (int j = 0; j < listaHorarios.size(); j++) {
                Horarios horario = listaHorarios.get(j);
                if (jCHorarios.getSelectedIndex() + 1 == horario.getIdHorario()) {
                    relacion.setHorario(horario);
                }
            }
            List<Profesores> listaProfesores = Profesores.consultaBase();
            for (int k = 0; k < listaProfesores.size(); k++) {
                Profesores profesor = listaProfesores.get(k);
                String profe = profesor.getPersona().getNombre() + " " + profesor.getPersona().getApellido();
                if (profe.equals(jCProfesores.getSelectedItem())) {
                    relacion.setProfesor(profesor);
                }
            }

            sesion.save(relacion);

            sesion.getTransaction().commit();
            JOptionPane.showMessageDialog(rootPane,
                    "La relación fue guardada con éxito.", "Relacion de Actividades", JOptionPane.INFORMATION_MESSAGE);
            LlenarTabla();
        }
    }//GEN-LAST:event_jBGuardarRelacionActionPerformed

    private void jBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTActividades.getModel();
        jTActividades.setEnabled(false);
        jBGuardarRelacion.setText("Guardar Modificación");
        jBAgregarActionPerformed(evt);
        jCActividades.setEnabled(true);
        jCHorarios.setEnabled(true);
        jCProfesores.setEnabled(true);
        jCActividades.setSelectedItem(modelo.getValueAt(jTActividades.getSelectedRow(), 0));
        jCHorarios.setSelectedItem(modelo.getValueAt(jTActividades.getSelectedRow(), 1));
        jCProfesores.setSelectedItem(modelo.getValueAt(jTActividades.getSelectedRow(), 2));


    }//GEN-LAST:event_jBModificarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        DefaultTableModel modelo = (DefaultTableModel) jTActividades.getModel();
        sesion.getTransaction().begin();
        List<Relaciones> listaRelaciones = Relaciones.listaRelaciones();
        for (int i = 0; i < listaRelaciones.size(); i++) {
            Relaciones relacion = listaRelaciones.get(i);
            if (relacion.getActividad().getActividad().equals(modelo.getValueAt(jTActividades.getSelectedRow(), 0))) {
                if (relacion.getHorario().getHorario().equals(modelo.getValueAt(jTActividades.getSelectedRow(), 1))) {
                    String profesor = relacion.getProfesor().getPersona().getNombre() + " " + relacion.getProfesor().getPersona().getApellido();
                    if (profesor.equals(modelo.getValueAt(jTActividades.getSelectedRow(), 2))) {

                        try {

                            sesion.delete(relacion);
                            sesion.getTransaction().commit();
                            sesion.close();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(rootPane, "No se puede eliminar la relación seleccionada.", "Gestion de Actividades", JOptionPane.ERROR_MESSAGE);
                        }

                    }

                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBGuardarRelacion;
    private javax.swing.JButton jBModificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jCActividades;
    private javax.swing.JComboBox jCHorarios;
    private javax.swing.JComboBox jCProfesores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPNuevaDisciplinaenSocio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTActividades;
    // End of variables declaration//GEN-END:variables
}
