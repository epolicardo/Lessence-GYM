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

import com.lessence.gymmaven.clases.Actividades;
import com.lessence.gymmaven.clases.HibernateUtil;
import com.lessence.gymmaven.clases.Marcas;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Emiliano
 */
public class Form_ABMMarcas extends javax.swing.JDialog {

    public Form_ABMMarcas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getRootPane().setDefaultButton(jBAñadir);
        this.setLocationRelativeTo(null);
        ActualizarJTable();

    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jBAñadir = new javax.swing.JButton();
        jTActividades = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTaActividades = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setText("Marcas");
        jLabel1.setName("jLabel1"); // NOI18N

        jBAñadir.setText("Añadir");
        jBAñadir.setName("jBAñadir"); // NOI18N
        jBAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAñadirActionPerformed(evt);
            }
        });

        jTActividades.setName("jTActividades"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBAñadir)))
                .addContainerGap(194, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTActividades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAñadir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTaActividades.setAutoCreateRowSorter(true);
        jTaActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Actividad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTaActividades.setEditingColumn(0);
        jTaActividades.setEditingRow(0);
        jTaActividades.setName("jTaActividades"); // NOI18N
        jTaActividades.setShowVerticalLines(false);
        jTaActividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTaActividadesMouseClicked(evt);
            }
        });
        jTaActividades.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTaActividadesPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTaActividades);
        if (jTaActividades.getColumnModel().getColumnCount() > 0) {
            jTaActividades.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTaActividades.getColumnModel().getColumn(1).setPreferredWidth(90);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jBAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAñadirActionPerformed
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        if (jTActividades.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Debe ingresar el nombre de una marca",
                    "ABM Marcas", JOptionPane.ERROR_MESSAGE);

        } else {
            Marcas marca = new Marcas();
            marca.setMarca(jTActividades.getText());
            sesion.beginTransaction();
            sesion.save(marca);
            sesion.getTransaction().commit();
            sesion.close();
            JOptionPane.showMessageDialog(this,
                    "La marca fue cargada con éxito",
                    "ABM Marcas", JOptionPane.INFORMATION_MESSAGE);
            jTActividades.setText("");
            ActualizarJTable();
        }
    }//GEN-LAST:event_jBAñadirActionPerformed

    private void jTaActividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTaActividadesMouseClicked
        if (evt.getClickCount() == 2) {
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            DefaultTableModel modelo = (DefaultTableModel) jTaActividades.getModel();
            Criteria consulta_actividades = sesion.createCriteria(Actividades.class);
            List<Actividades> lista_actividades = consulta_actividades.list();
            for (int i = 0; i < lista_actividades.size(); i++) {
                Actividades actividad = lista_actividades.get(i);
                if (modelo.getValueAt(jTaActividades.getSelectedRow(), 0).toString().equals(actividad.getActividad())) {
                    if (0 == JOptionPane.showConfirmDialog(this, "Desea modificar?", "ABM Actividades", JOptionPane.YES_NO_OPTION)) {
                        try {
                            sesion.beginTransaction();
                            actividad.setIdActividad((int) modelo.getValueAt(jTaActividades.getSelectedRow(), 0));
                            sesion.saveOrUpdate(actividad);
                            sesion.getTransaction().commit();
                            sesion.close();
                            ActualizarJTable();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(rootPane, "No se puede actualizar esta actividad, la misma esta en uso.\nPara poder eliminar una actividad,\nes necesario que la misma "
                                    + "no esté asociada a ningun socio ni profesor ni turno.");
                        }
                    } else if (0 == JOptionPane.showConfirmDialog(this, "Va a eliminar la actividad seleccionada. "
                            + "\nDesea continuar?", "ABM Actividades", JOptionPane.YES_NO_OPTION)) {
                        try {
                            sesion.beginTransaction();
                            sesion.delete(actividad);
                            sesion.getTransaction().commit();
                            sesion.close();
                            ActualizarJTable();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(rootPane, "No se puede eliminar esta actividad, la misma esta en uso.\nPara poder eliminar una actividad,\nes necesario que la misma "
                                    + "no esté asociada a ningun socio ni profesor ni turno.");

                        }
                    }
                }
            }
        }

    }//GEN-LAST:event_jTaActividadesMouseClicked

    private void jTaActividadesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTaActividadesPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTaActividadesPropertyChange

    private void ActualizarJTable() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        DefaultTableModel modelo = (DefaultTableModel) jTaActividades.getModel();
        modelo.setRowCount(0);
        Criteria consulta_actividades = sesion.createCriteria(Actividades.class
        );
        List<Actividades> lista_actividades = consulta_actividades.list();
        for (int i = 0; i < lista_actividades.size(); i++) {
            Actividades actividad = lista_actividades.get(i);
            Object[] fila = {actividad.getIdActividad(), actividad.getActividad()};
            modelo.addRow(fila);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAñadir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTActividades;
    private javax.swing.JTable jTaActividades;
    // End of variables declaration//GEN-END:variables
}
