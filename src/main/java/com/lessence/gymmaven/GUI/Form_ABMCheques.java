package com.lessence.gymmaven.GUI;

import com.lessence.gymmaven.clases.IntConexion;
import com.lessence.gymmaven.clases.Cheques;
import com.lessence.gymmaven.clases.ResultSetComboBoxModel;
import com.lessence.gymmaven.clases.ResultSetComboBoxModelObject;
import com.lessence.gymmaven.clases.claseFunciones;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Form_ABMCheques extends javax.swing.JFrame implements IntConexion {

  

    public Form_ABMCheques(java.awt.Frame parent, boolean modal) {

        initComponents();
        claseFunciones.ComboGenerico(jCBanco, "Bancos", "idBanco", "Banco");
        claseFunciones.ComboGenerico(jCPlaza, "Localidades", "idLocalidad", "Localidad");
//        ActualizarLocalidades();
//        ActualizarBancos();
        ActualizarGrilla();

    }
    
    private void ActualizarLocalidades() {
        ResultSet rsl = Cnx.Consulta("select * from localidades");
        try {
            jCPlaza.setModel(new ResultSetComboBoxModel(rsl, "idLocalidades", "Localidades"));
        } catch (SQLException ex) {
            ex.getErrorCode();
        }
    }

    private void ActualizarBancos() {
        ResultSet rsb = Cnx.Consulta("select * from bancos");
        try {
            jCBanco.setModel(new ResultSetComboBoxModel(rsb, "idBanco", "Banco"));
        } catch (SQLException ex) {
            ex.getErrorCode();
        }
    }

    private void ActualizarGrilla() {
        

        try {
            ResultSet RsCheques = Cnx.Consulta("Select * from cheques");

            int i = 0;
            while (RsCheques.next()) {
                String idCheque = RsCheques.getString("idCheque");
                String idCliente = RsCheques.getString("idCliente");
                String Banco = RsCheques.getString("idBanco");
                String Plaza = RsCheques.getString("idPlaza");
                String FechaCobro = RsCheques.getString("FechaCobro");
                String Importe = RsCheques.getString("Importe");
                Cheques chequenuevo = new Cheques(idCheque, idCliente, Banco, Plaza, FechaCobro, Importe);
                insertarEnJTableUnCheque(chequenuevo, i);
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Form_ABMCheques.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void insertarEnJTableUnCheque(Cheques chequenuevo, int i) {
        String LocalidadStr = null;
        String ClienteStr = null;
        String BancoStr = null;

        ResultSet RsLocalidades = Cnx.Consulta("Select * from localidades where idLocalidades =" + chequenuevo.getPlaza());
        ResultSet RsClientes = Cnx.Consulta("Select * from clientes where idCliente =" + chequenuevo.getIdCliente());
        ResultSet RsBancos = Cnx.Consulta("Select * from bancos where idBanco =" + chequenuevo.getBanco());


        try {
            while (RsLocalidades.next()) {
                   LocalidadStr = RsLocalidades.getString("Localidades");
            }
            while (RsClientes.next()) {
                   ClienteStr = RsClientes.getString("Apellido") +  ", " + RsClientes.getString("Nombre");
            }
            while (RsBancos.next()) {
                   BancoStr = RsBancos.getString("Banco");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Form_ABMCheques.class.getName()).log(Level.SEVERE, null, ex);
        }


        DefaultTableModel modelo = (DefaultTableModel) jTDatosObtenidos.getModel();
        modelo.setNumRows(i);




        Object[] fila = {chequenuevo.getIdCheque(), ClienteStr, BancoStr,
            LocalidadStr, chequenuevo.getFechaCobro().substring(0, 10), chequenuevo.getImporte()
        };
        modelo.addRow(fila);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        jFrame1 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTCliente = new javax.swing.JTextField();
        jTCheque = new javax.swing.JTextField();
        jFTImporte = new javax.swing.JFormattedTextField();
        jTEntregadoPor = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jCPlaza = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCBanco = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jBNuevo = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jDCFechaCobro = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTDatosObtenidos = new javax.swing.JTable();

        popupMenu1.setLabel("popupMenu1");

        jFrame1.setName("jFrame1"); // NOI18N

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cheques");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setName("jPanel2"); // NOI18N

        jLabel1.setText("Cheque Nº");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText("Entrego");
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel4.setText("Plaza");
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText("Fecha de cobro");
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setText("Importe");
        jLabel6.setName("jLabel6"); // NOI18N

        jTCliente.setName("jTCliente"); // NOI18N
        jTCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTClienteFocusGained(evt);
            }
        });
        jTCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTClienteKeyPressed(evt);
            }
        });

        jTCheque.setName("jTCheque"); // NOI18N

        jFTImporte.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(""))));
        jFTImporte.setName("jFTImporte"); // NOI18N
        jFTImporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFTImporteKeyPressed(evt);
            }
        });

        jTEntregadoPor.setName("jTEntregadoPor"); // NOI18N

        jBBuscar.setText("Buscar");
        jBBuscar.setName("jBBuscar"); // NOI18N
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jCPlaza.setName("jCPlaza"); // NOI18N

        jLabel7.setText("Cliente");
        jLabel7.setName("jLabel7"); // NOI18N

        jLabel3.setText("Banco");
        jLabel3.setName("jLabel3"); // NOI18N

        jCBanco.setName("jCBanco"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jBNuevo.setText("Nuevo");
        jBNuevo.setName("jBNuevo"); // NOI18N
        jPanel1.add(jBNuevo);

        jBCancelar.setText("Cancelar");
        jBCancelar.setName("jBCancelar"); // NOI18N

        jBGuardar.setText("Guardar");
        jBGuardar.setName("jBGuardar"); // NOI18N
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jDCFechaCobro.setName("jDCFechaCobro"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTCheque, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBBuscar))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jTEntregadoPor, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(46, 46, 46))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jDCFechaCobro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFTImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jCBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jCPlaza, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBBuscar)
                            .addComponent(jTEntregadoPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDCFechaCobro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCPlaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBCancelar)
                        .addComponent(jBGuardar)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jCBanco, jCPlaza, jFTImporte, jTCheque, jTCliente});

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTDatosObtenidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cheque Nº", "Entrego", "Banco", "Plaza", "Fecha de Cobro", "Importe", "Estado"
            }
        ));
        jTDatosObtenidos.setName("jTDatosObtenidos"); // NOI18N
        jScrollPane2.setViewportView(jTDatosObtenidos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
//TODO Hacer validacion de campos 

        int idCheque = Integer.parseInt(jTCheque.getText());
        int idCliente = Integer.parseInt(jTCliente.getText());
        int idBanco = ((ResultSetComboBoxModelObject) jCBanco.getSelectedItem()).getCodigo();
        String Plaza = ((ResultSetComboBoxModelObject) jCPlaza.getSelectedItem()).getDescri();
        int idPlaza = ((ResultSetComboBoxModelObject) jCPlaza.getSelectedItem()).getCodigo();

        String FehaCobro = new SimpleDateFormat("yyyy/MM/dd").format(jDCFechaCobro.getDate());
        //String FehaCobro = FechayHora.FechaBD();

        double Importe = Double.parseDouble(jFTImporte.getText());
        Cnx.Ejecutar("Insert into cheques values ('" + idCheque + "','" + idCliente + "','" + idBanco + "','" + idPlaza + "','" + FehaCobro + "','" + Importe + "')");
        ActualizarGrilla();
        JOptionPane.showMessageDialog(this, "El cheque fué cargado con éxito", "ABM Cheques", JOptionPane.INFORMATION_MESSAGE);

}//GEN-LAST:event_jBGuardarActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        try {
            int Cliente = 0;
            try {
                Cliente = Integer.parseInt(jTCliente.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "El campo codigo de cliente es requerido.");
            }

            ResultSet Resultado = Cnx.Consulta("Select * from clientes where idCliente='" + Cliente + "';");

            while (Resultado.next()) {
                jTEntregadoPor.setText(Resultado.getString("Apellido") + ", " + Resultado.getString("Nombre"));
                jCBanco.requestFocus();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Form_ABMCheques.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jTClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTClienteFocusGained
        getRootPane().setDefaultButton(jBBuscar);
    }//GEN-LAST:event_jTClienteFocusGained

    private void jTClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTClienteKeyPressed
        if (evt.getKeyCode() == 115) {
//            BuscarClientes buscarClientes = new BuscarClientes();
//            buscarClientes.setVisible(true);
//            buscarClientes.setModal(true);
//            jTCliente.setText(buscarClientes.getText());
        }
    }//GEN-LAST:event_jTClienteKeyPressed

    private void jFTImporteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFTImporteKeyPressed
   //    JOptionPane.showMessageDialog(this, evt.getKeyCode());

        if (evt.getKeyCode() == 110) {
            evt.setKeyCode(44);
           

        }
    }//GEN-LAST:event_jFTImporteKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBNuevo;
    private javax.swing.JComboBox jCBanco;
    private javax.swing.JComboBox jCPlaza;
    private com.toedter.calendar.JDateChooser jDCFechaCobro;
    private javax.swing.JFormattedTextField jFTImporte;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTCheque;
    private javax.swing.JTextField jTCliente;
    private javax.swing.JTable jTDatosObtenidos;
    private javax.swing.JTextField jTEntregadoPor;
    private java.awt.PopupMenu popupMenu1;
    // End of variables declaration//GEN-END:variables
}
