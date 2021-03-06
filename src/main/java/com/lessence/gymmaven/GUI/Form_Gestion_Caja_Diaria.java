/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lessence.gymmaven.GUI;

import com.lessence.gymmaven.clases.Caja_diaria;
import com.lessence.gymmaven.clases.HibernateUtil;
import com.lessence.gymmaven.clases.ParametrosSistema;
import com.lessence.gymmaven.clases.seteosGUI;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Emiliano
 */
public class Form_Gestion_Caja_Diaria extends javax.swing.JDialog {

    /**
     * Este formulario lleva la gestion de la caja diaria, mostrando ingresos y
     * egresos, ofreciendo como opciones, la apertura y cierre de caja, ademas
     * de utilizar un arqueo para tal fin.
     */
    public Form_Gestion_Caja_Diaria() {
        initComponents();
        cajaDiaria();
        MostrarMovimientos();
        this.setLocationRelativeTo(null);
        resizeColumns();

    }

    private void resizeColumns() {
        float[] columnWidthPercentage = {10.0f, 20.0f, 12.0f, 8.0f, 8.0f, 10.0f, 32.0f};
        int tW = jTMovimientos.getWidth();
        TableColumn column;
        TableColumnModel jTableColumnModel = jTMovimientos.getColumnModel();
        int cantCols = jTableColumnModel.getColumnCount();
        for (int i = 0; i < cantCols; i++) {
            column = jTableColumnModel.getColumn(i);
            int pWidth = Math.round(columnWidthPercentage[i] * tW);
            column.setPreferredWidth(pWidth);
        }
    }

    public final void cajaDiaria() {
        if (ParametrosSistema.estadoCaja == 0) { //0 es cerrado 1 es abierto
            jB_abrirCaja.setEnabled(true);
            jB_cerrarCaja.setEnabled(false);
        } else {
            jB_abrirCaja.setEnabled(false);
            jB_cerrarCaja.setEnabled(true);
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

        jB_abrirCaja = new javax.swing.JButton();
        jB_cerrarCaja = new javax.swing.JButton();
        jBGastos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMovimientos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jB_abrirCaja.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jB_abrirCaja.setText("Abrir Caja Diaria");
        jB_abrirCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_abrirCajaActionPerformed(evt);
            }
        });

        jB_cerrarCaja.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jB_cerrarCaja.setText("Cerrar Caja");
        jB_cerrarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_cerrarCajaActionPerformed(evt);
            }
        });

        jBGastos.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jBGastos.setText("Gastos, Ingresos y Retiros Manuales");
        jBGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGastosActionPerformed(evt);
            }
        });

        jTMovimientos.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jTMovimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Categoría", "Forma de Pago", "Debe", "Haber", "Saldo", "Concepto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTMovimientos.setColumnSelectionAllowed(true);
        jTMovimientos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTMovimientos);
        jTMovimientos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (jTMovimientos.getColumnModel().getColumnCount() > 0) {
            jTMovimientos.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTMovimientos.getColumnModel().getColumn(1).setPreferredWidth(15);
            jTMovimientos.getColumnModel().getColumn(2).setPreferredWidth(15);
            jTMovimientos.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTMovimientos.getColumnModel().getColumn(4).setPreferredWidth(10);
            jTMovimientos.getColumnModel().getColumn(5).setPreferredWidth(15);
            jTMovimientos.getColumnModel().getColumn(6).setPreferredWidth(25);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1227, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jB_abrirCaja)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBGastos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jB_cerrarCaja)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jB_abrirCaja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBGastos)
                    .addComponent(jB_cerrarCaja))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_abrirCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_abrirCajaActionPerformed

        Caja_diaria.AbrirCaja();
        ParametrosSistema.GuardaParametros();
        MostrarMovimientos();
        cajaDiaria();

    }//GEN-LAST:event_jB_abrirCajaActionPerformed

    private void jB_cerrarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_cerrarCajaActionPerformed
        new Form_Arqueo().setVisible(true);

    }//GEN-LAST:event_jB_cerrarCajaActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void jBGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGastosActionPerformed
        new Form_Gastos_Visual().setVisible(true);
    }//GEN-LAST:event_jBGastosActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        MostrarMovimientos();
        cajaDiaria();
    }//GEN-LAST:event_formWindowGainedFocus

    private void MostrarMovimientos() {

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        DefaultTableModel modelo = (DefaultTableModel) jTMovimientos.getModel();
        modelo.setRowCount(0);
        Query query_caja = sesion.createQuery("From Caja_diaria");
        List<Caja_diaria> lista_caja = query_caja.list();

        query_caja.setFirstResult(lista_caja.size() - 1 - ParametrosSistema.cantidadMovimientos);
        query_caja.setMaxResults(ParametrosSistema.cantidadMovimientos + 1);
        lista_caja = query_caja.list();

        for (int i = 0; i < lista_caja.size(); i++) {

            Caja_diaria movimiento = lista_caja.get(i);
            int categorias = movimiento.getCategoria();
            String categoria = "";
            switch (categorias) {
                case 1:
                    categoria = "Apertura de Caja";
                    break;
                case 2:
                    categoria = "Ingreso manual";
                    break;
                case 3:
                    categoria = "Retiro manual";
                    break;
                case 4:
                    categoria = "Gastos";
                    break;
                case 5:
                    categoria = "Cobro de Cuotas";
                    break;
                case 6:
                    categoria = "Ventas";
                    break;
                case 8:
                    categoria = "Diferencia de Arqueo";
                    break;
                case 9:
                    categoria = "Cierre de Caja";
                    break;
                default:
                    break;
            }
            Object[] fila = {seteosGUI.fechaCorta(movimiento.getFecha()), categoria,
                movimiento.getFormaPago().getFormaPago(), movimiento.getDebe(), movimiento.getHaber(),
                movimiento.getSaldo(), movimiento.getConcepto()};
            modelo.addRow(fila);
        }
        sesion.close();

    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGastos;
    private javax.swing.JButton jB_abrirCaja;
    private javax.swing.JButton jB_cerrarCaja;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTMovimientos;
    // End of variables declaration//GEN-END:variables

}
