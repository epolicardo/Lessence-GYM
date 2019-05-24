package com.lessence.gymmaven.GUI;

import com.lessence.gymmaven.clases.IntConexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class NuevoUsuario extends javax.swing.JDialog implements IntConexion {

    public NuevoUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getRootPane().setDefaultButton(jBAceptar);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jBAceptar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jBVolver = new javax.swing.JButton();
        jTNombre = new javax.swing.JTextField();
        jTApellido = new javax.swing.JTextField();
        jTUsuario = new javax.swing.JTextField();
        jTDNI = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTClave = new javax.swing.JPasswordField();
        jTRepetirClave = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Creación de usuarios");
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        setModalityType(java.awt.Dialog.ModalityType.TOOLKIT_MODAL);
        setName("DNuevosUsuarios"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setText("Nombre");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText("Apellido");
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText("Nombre de Usuario");
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText("Contraseña");
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText("Repetir Contraseña");
        jLabel5.setName("jLabel5"); // NOI18N

        jBAceptar.setText("Aceptar");
        jBAceptar.setName("jBAceptar"); // NOI18N
        jBAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAceptarActionPerformed(evt);
            }
        });

        jBCancelar.setText("Cancelar");
        jBCancelar.setName("jBCancelar"); // NOI18N

        jBVolver.setText("Volver");
        jBVolver.setName("jBVolver"); // NOI18N
        jBVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVolverActionPerformed(evt);
            }
        });

        jTNombre.setName("jTNombre"); // NOI18N

        jTApellido.setName("jTApellido"); // NOI18N

        jTUsuario.setName("jTUsuario"); // NOI18N

        jTDNI.setName("jTDNI"); // NOI18N

        jLabel6.setText("Documento");
        jLabel6.setName("jLabel6"); // NOI18N

        jTClave.setToolTipText("Ingrese una clave nueva");
        jTClave.setName("jTClave"); // NOI18N

        jTRepetirClave.setToolTipText("Repita la clave utilizada");
        jTRepetirClave.setName("jTRepetirClave"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                            .addComponent(jTApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                            .addComponent(jTDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTClave, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTRepetirClave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jBAceptar)
                .addGap(18, 18, 18)
                .addComponent(jBCancelar)
                .addGap(18, 18, 18)
                .addComponent(jBVolver)
                .addContainerGap(169, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBAceptar, jBCancelar, jBVolver});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTRepetirClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAceptar)
                    .addComponent(jBCancelar)
                    .addComponent(jBVolver))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAceptarActionPerformed
        String DNI = jTDNI.getText();
        String Nombre = jTNombre.getText();
        String Apellido = jTApellido.getText();
        String Usuario = jTUsuario.getText();
        String Clave = new String(jTClave.getPassword());
        String RepetirClave = new String(jTRepetirClave.getPassword());


        String sql = "INSERT INTO usuarios.usuarios (Base, Nombre, Apellido, DNI, Usuario, Clave) VALUES ('gym', '" + Nombre + "', '" + Apellido + "','" + DNI + "','" + Usuario + "','" + Clave + "')";
        String CrearUsuario = "create user '" + Usuario + "' identified by '" + Clave + "';";
        String GrantUsuario = "grant select, update, insert on gym.* to '" + Usuario + "'@'localhost' identified by '" + Clave + "';";
        String GrantUsuario1 = "grant select, update, insert, create on cuentascorrientes.* to '" + Usuario + "'@'localhost' identified by '" + Clave + "';";
        String GrantUsuario2 = "grant select, update, insert, create on movimientos.* to '" + Usuario + "'@'localhost' identified by '" + Clave + "';";
        if (Clave.equals(RepetirClave)) {
            Cnx.Conexion();
            Cnx.Ejecutar(sql);
            Cnx.Ejecutar(CrearUsuario);
            Cnx.Ejecutar(GrantUsuario);
           // Cnx.Ejecutar(GrantUsuario1);
            //Cnx.Ejecutar(GrantUsuario2);
            Cnx.CerrarConexionDB();
            JOptionPane.showMessageDialog(rootPane, "El Usuario '" + jTUsuario.getText() + "' fue generado con éxito. " +
                    "\n Vuelva a la pantalla anterior y efectue el logueo", "Generación de Usuarios", JOptionPane.INFORMATION_MESSAGE);
            jTDNI.setText(null);
            jTApellido.setText(null);
            jTNombre.setText(null);
            jTClave.setText(null);
            jTRepetirClave.setText(null);
            jTUsuario.setText(null);

        } else {
            JOptionPane.showMessageDialog(rootPane, "Las claves no coinciden", "Verificación de Claves", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBAceptarActionPerformed

    private void jBVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBVolverActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAceptar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTApellido;
    private javax.swing.JPasswordField jTClave;
    private javax.swing.JTextField jTDNI;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JPasswordField jTRepetirClave;
    private javax.swing.JTextField jTUsuario;
    // End of variables declaration//GEN-END:variables
}
