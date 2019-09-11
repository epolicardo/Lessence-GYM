/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * Form_ABM_Localidades.java
 *
 * Created on 21/11/2010, 23:03:37
 */
package com.lessence.gymmaven.GUI;


import com.lessence.gymmaven.clases.HibernateUtil;
import com.lessence.gymmaven.clases.Localidades;
import com.lessence.gymmaven.clases.Provincias;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Emiliano
 */
public class Form_ABM_Localidades extends javax.swing.JDialog {

    public Form_ABM_Localidades(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getRootPane().setDefaultButton(jBAñadir);
        this.setLocationRelativeTo(null);
        ActualizarJTable(jTLocalidades, "FROM Localidades");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jBAñadir = new javax.swing.JButton();
        jTLocalidad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTLocalidades = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setText("Localidad");
        jLabel1.setName("jLabel1"); // NOI18N

        jBAñadir.setText("Añadir");
        jBAñadir.setName("jBAñadir"); // NOI18N
        jBAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAñadirActionPerformed(evt);
            }
        });

        jTLocalidad.setName("jTLocalidad"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jBAñadir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(jTLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBAñadir)
                .addContainerGap())
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Localidades"));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTLocalidades.setAutoCreateRowSorter(true);
        jTLocalidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Localidad"
            }
        ));
        jTLocalidades.setEditingColumn(0);
        jTLocalidades.setEditingRow(0);
        jTLocalidades.setName("jTLocalidades"); // NOI18N
        jTLocalidades.setShowVerticalLines(false);
        jTLocalidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTLocalidadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTLocalidades);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAñadirActionPerformed
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        if (jTLocalidad.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el nombre de una localidad", 
                    "ABM Localidades", ERROR);

        } else {
            Localidades localidad = new Localidades();
            localidad.setLocalidad(jTLocalidad.getText());
            Provincias prov = new Provincias();
            //TODO Hacer pantalla de registro de direcciones, incluyendo
            // domicilios, localidades, provincias y paises
            prov.setProvincia("Córdoba");
            localidad.setProvincia(prov);
            sesion.beginTransaction();
            sesion.save(localidad);
            sesion.save(prov);
            sesion.getTransaction().commit();
            sesion.close();
            jTLocalidad.setText("");
            ActualizarJTable(jTLocalidades, "FROM Localidades");
            JOptionPane.showMessageDialog(this, "La localidad fue cargada con éxito", 
                    "ABM Localidades", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_jBAñadirActionPerformed

    private void jTLocalidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTLocalidadesMouseClicked
        if (evt.getClickCount() == 2) {
            JOptionPane.showMessageDialog(rootPane, "Eliminar localidad");
            eliminarLinea(jTLocalidades);
        }

    }//GEN-LAST:event_jTLocalidadesMouseClicked

    private void ActualizarJTable(JTable tabla, String HQL) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        Query consulta_lista = sesion.createQuery(HQL);
        List<Localidades> lista_obtenida = consulta_lista.list();
        for (int i = 0; i < lista_obtenida.size(); i++) {
            Localidades localidad = lista_obtenida.get(i);
            Object[] fila = {localidad.getLocalidad()};
            modelo.addRow(fila);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAñadir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTLocalidad;
    private javax.swing.JTable jTLocalidades;
    // End of variables declaration//GEN-END:variables

    private void eliminarLinea(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        String linea = modelo.getValueAt(tabla.getSelectedRow(),0).toString();
        
    }
}
