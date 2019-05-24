package com.lessence.gymmaven.GUI;

import com.lessence.gymmaven.clases.IntConexion;
import com.lessence.gymmaven.clases.Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LoginVisual extends javax.swing.JDialog implements IntConexion {

    public LoginVisual(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getRootPane().setDefaultButton(jBAceptar);
        Windows.setSelected(true);
        jTClave.requestFocus();

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupodeBotones = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jBAceptar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jBNuevo = new javax.swing.JButton();
        jBAyuda = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTUsuario = new javax.swing.JTextField();
        jTClave = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Ribbon = new javax.swing.JRadioButton();
        Metal = new javax.swing.JRadioButton();
        Windows = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jtNombreEquipo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso al sistema");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("Login"); // NOI18N
        setResizable(false);

        jPanel1.setName("jPanel1"); // NOI18N

        jBAceptar.setText("Aceptar");
        jBAceptar.setFocusPainted(false);
        jBAceptar.setName("jBAceptar"); // NOI18N
        jBAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAceptarActionPerformed(evt);
            }
        });

        jBCancelar.setText("Cancelar");
        jBCancelar.setName("jBCancelar"); // NOI18N
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jBNuevo.setText("Nuevo");
        jBNuevo.setName("jBNuevo"); // NOI18N
        jBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNuevoActionPerformed(evt);
            }
        });

        jBAyuda.setText("Ayuda");
        jBAyuda.setName("jBAyuda"); // NOI18N
        jBAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAyudaActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuario");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText("Clave");
        jLabel2.setName("jLabel2"); // NOI18N

        jTUsuario.setText("epolicardo");
        jTUsuario.setName("jTUsuario"); // NOI18N

        jTClave.setText("123");
        jTClave.setName("jTClave"); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setName("jPanel2"); // NOI18N

        jLabel3.setText("Decoración de ventanas");
        jLabel3.setName("jLabel3"); // NOI18N

        GrupodeBotones.add(Ribbon);
        Ribbon.setText("Ribbon");
        Ribbon.setName("Ribbon"); // NOI18N

        GrupodeBotones.add(Metal);
        Metal.setText("Metal");
        Metal.setName("Metal"); // NOI18N

        GrupodeBotones.add(Windows);
        Windows.setText("Windows");
        Windows.setName("Windows"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addComponent(Ribbon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Metal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Windows)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Ribbon)
                    .addComponent(Metal)
                    .addComponent(Windows))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jBAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTUsuario)
                            .addComponent(jTClave, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBAceptar, jBAyuda, jBCancelar, jBNuevo});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBAyuda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setName("jPanel3"); // NOI18N

        jtNombreEquipo.setText("Lessence-PC");
        jtNombreEquipo.setName("jtNombreEquipo"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtNombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtNombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void jBAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAceptarActionPerformed

        
//        if (Metal.isSelected()) {
//            try {
//                UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
//            } catch (Exception e) {
//            }
//        } else if (Ribbon.isSelected()) {
//
//            try {
//                UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
//            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
//                Logger.getLogger(LoginVisual.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        } else {
//            try {
//                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
//                Logger.getLogger(LoginVisual.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }

//        if (jTUsuario.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Debe ingresar un usuario para ingresar.", "Ingreso al sistema", JOptionPane.ERROR_MESSAGE);
//
//        } else {
//            if (jTClave.getPassword().toString().equals("")) {
//                JOptionPane.showMessageDialog(this, "El campo 'Clave' no debe quedar vacío.", "Ingreso al sistema", JOptionPane.ERROR_MESSAGE);
//
//            } else {
//
//                ArrayList<Object> vt = new ArrayList<Object>();
//                String usuario = jTUsuario.getText();
//
//                String sql = "Select * from usuarios.usuarios where Usuario='" + usuario + "'";
//
//                try {
//                Cnx.Conexion();
//                    ResultSet respuesta = Cnx.Consulta(sql);
//
//                    while (respuesta.next()) {
//                        String Nombre = respuesta.getString("Nombre");
//                        String Apellido = respuesta.getString("Apellido");
//                        String Usuario = respuesta.getString("Usuario");
//                        String Clave = respuesta.getString("Clave");
//                        String Base = respuesta.getString("Base");
//                        Login resultado = new Login(Base, Usuario, Clave, Nombre, Apellido);
//                        vt.add(resultado);
//
//                    }
//                    if (vt.isEmpty()) {
//                        JOptionPane.showMessageDialog(this, "El usuario ingresado no existe.", "Error de Logueo", JOptionPane.ERROR_MESSAGE);
//
//                    }
//                    for (int i = 0; i
//                            < vt.size(); i++) {
//                        Login usuarioleido = (Login) vt.get(i);
//                        ComprobarUsuario(
//                                usuarioleido);
//
//                    }
//
//                } catch (SQLException ex) {
//                    Logger.getLogger(LoginVisual.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//            }
//        }

    }

    public void ComprobarUsuario(Login Usuario) {
        String Clave = new String(jTClave.getPassword());
        String ClaveBase = Usuario.getClave();

        if (Clave.equals(ClaveBase)) {
            new Inicial().setVisible(true);
            Cnx.Conexion();
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(this,
                    "La clave ingresada no es correcta.",
                    "Ingreso al sistema",
                    JOptionPane.ERROR_MESSAGE);

        }


}//GEN-LAST:event_jBAceptarActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        jTUsuario.setText("");
        jTClave.setText("");
        jTUsuario.requestFocus();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNuevoActionPerformed
        NuevoUsuario NU = new NuevoUsuario(null, false);
        NU.setVisible(true);
    }//GEN-LAST:event_jBNuevoActionPerformed
    private void jBAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAyudaActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Si es la primera vez que ingresa, debe crear un nuevo usuario, \n presionando el boton Nuevo.", "Mensaje de ayuda", 1);
// Aca hacer un acerca de como la gente..

    }//GEN-LAST:event_jBAyudaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupodeBotones;
    private javax.swing.JRadioButton Metal;
    private javax.swing.JRadioButton Ribbon;
    private javax.swing.JRadioButton Windows;
    private javax.swing.JButton jBAceptar;
    private javax.swing.JButton jBAyuda;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jTClave;
    private javax.swing.JTextField jTUsuario;
    private javax.swing.JTextField jtNombreEquipo;
    // End of variables declaration//GEN-END:variables

}
