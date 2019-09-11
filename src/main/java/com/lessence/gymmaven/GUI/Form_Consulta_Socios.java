/*
 * Form_Consulta_Socios.java
 *
 * Created on 10 de junio de 2015, 10:07
 */
package com.lessence.gymmaven.GUI;

import com.lessence.gymmaven.clases.Actividades_Socios_Turnos;
import com.lessence.gymmaven.clases.Cuotas_registros;
import com.lessence.gymmaven.clases.HibernateUtil;
import com.lessence.gymmaven.clases.RegistroAsistencias;
import com.lessence.gymmaven.clases.Socios;
import com.lessence.gymmaven.clases.seteosGUI;
import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Emiliano
 */
public class Form_Consulta_Socios extends javax.swing.JDialog {

    private String DNIseleccionado;
    private int personaaFiltrar;

    public Form_Consulta_Socios() {
        initComponents();

//        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());// Maximiza la ventana en cuestion
        this.setResizable(rootPaneCheckingEnabled);
        this.setLocationRelativeTo(null);
        ActualizarGrillaSocios();
        
      

    }

    private void ActualizarGrillaSocios() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        DefaultTableModel modelo = (DefaultTableModel) jTablaSocios.getModel();

        Query query_socios = sesion.createQuery("From Socios where situacion=1");
        List<Socios> lista_socios = query_socios.list();
        int lista_sociosSize = lista_socios.size();
        for (int i = 0; i < lista_sociosSize; i++) {
            modelo.setRowCount(i);
            Socios socio_leido = lista_socios.get(i);
            String DNI = socio_leido.getPersona().getDNI();
            String Socio = socio_leido.getPersona().getApellido() + " "
                    + socio_leido.getPersona().getNombre();
            String Celular = socio_leido.getPersona().getCelular();
            String vencimiento = seteosGUI.fechaLarga(socio_leido.getPrimerVencimiento());
            String Estado = socio_leido.getEstado().getEstado();
            Object[] fila = {DNI, Socio, Celular, Estado, vencimiento};
            modelo.addRow(fila);
        }
        sesion.close();
    }

    private void SocioSeleccionado(String DNI) {

        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        DefaultTableModel TablaActividades = (DefaultTableModel) jTActividades.getModel();
        TablaActividades.setRowCount(i);
        DefaultTableModel TablaCuenta = (DefaultTableModel) jTCuenta.getModel();
        TablaCuenta.setRowCount(k);
        DefaultTableModel TablaAsistencias = (DefaultTableModel) jTAsistencias.getModel();
        TablaAsistencias.setRowCount(l);

        //TODO 
        /*
        * Cuando selecciono el socio necesito
        * - Mostrar Historial de cuenta
        * - Mostrar Historial de Asistencias
        * - Mostrar Historial de Avance
        * - Mostrar Actividades que tiene asignadas
         */
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        List<Socios> listaSocios = Socios.listaSocios();
        for (int m = 0; m < listaSocios.size(); m++) {
            Socios socio = listaSocios.get(m);
            if (socio.getPersona().getDNI().equals(DNI)) {
                personaaFiltrar = socio.getIdSocio();
            }
        }

        Query consulta = sesion.createQuery("FROM Cuotas_registros c ORDER BY c.idRegistro DESC");
        List<Cuotas_registros> cuotas = consulta.list();
        int cuotasSize = cuotas.size();
        for (int m = 0; m < cuotasSize; m++) {
            Cuotas_registros registro = cuotas.get(m);
            String DNI_Obtenido = registro.getSocio().getPersona().getDNI();
            if (DNI_Obtenido.equals(DNI)) {
                Object[] fila = {seteosGUI.fechaCorta(registro.getFecha()), registro.getFormaPago().getFormaPago(), registro.getImporte()};
                TablaCuenta.addRow(fila);
//            
            }
        }

        Criteria consultaRelacion = sesion.createCriteria(Actividades_Socios_Turnos.class);
        List<Actividades_Socios_Turnos> listaRelaciones = consultaRelacion.list();
        String pases = "";
        int listaRelacionesSize = listaRelaciones.size();
        for (int h = 0; h < listaRelacionesSize; h++) {
            Actividades_Socios_Turnos relacion = listaRelaciones.get(h);
            if (relacion.getSocio().getPersona().getDNI().equals(DNI)) {
                if (relacion.getPaseLibre() == 1) {
                    pases = "Pase Libre";
                } else {
                    pases = String.valueOf(relacion.getPases());
                }
                Object[] fila = {relacion.getRelacion().getActividad().getActividad(),
                    relacion.getRelacion().getHorario().getHorario(),
                    relacion.getRelacion().getProfesor().getPersona().getApellido() + ", "
                    + relacion.getRelacion().getProfesor().getPersona().getNombre(), pases};
                TablaActividades.addRow(fila);
            }
        }

        List<RegistroAsistencias> listaAsistencias = RegistroAsistencias.listaAsistencias();
        int listaAsistenciasSize = listaAsistencias.size();
        for (int h = listaAsistenciasSize - 1; h > 0; h--) {
            RegistroAsistencias asistencia = listaAsistencias.get(h);
            if (asistencia.getSocio().getPersona().getDNI().equals(DNI)) {
                Object[] fila = {seteosGUI.fechaCorta(asistencia.getFecha()), asistencia.getRelacion().getActividad().getActividad(),
                    asistencia.getRelacion().getProfesor().getPersona().getApellido() + ", "
                    + asistencia.getRelacion().getProfesor().getPersona().getNombre(), pases};
                TablaAsistencias.addRow(fila);
            }
        }

    }

/**
 * This method is called from within the constructor to initialize the form.
 * WARNING: Do NOT modify this code. The content of this method is always
 * regenerated by the Form Editor.
 */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTFiltraDocumento = new javax.swing.JTextField();
        jTFiltraApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jCEstado = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jTFiltraNombre = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jBNuevoSocio = new javax.swing.JButton();
        jBModificarSocios = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaSocios = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTActividades = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTCuenta = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTAsistencias = new javax.swing.JTable();
        jBCuentas = new javax.swing.JButton();
        jBActividades = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Socios");
        setMinimumSize(null);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtrar resultados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("BankGothic Lt BT", 0, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel3.setText("Documento");

        jTFiltraDocumento.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jTFiltraDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFiltraDocumentoKeyReleased(evt);
            }
        });

        jTFiltraApellido.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jTFiltraApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFiltraApellidoActionPerformed(evt);
            }
        });
        jTFiltraApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFiltraApellidoKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel4.setText("Apellido");

        jLabel1.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel1.setText("Estado");

        jCEstado.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jCEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Activos", "Inactivos" }));
        jCEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCEstadoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");

        jTFiltraNombre.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jTFiltraNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFiltraNombreKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTFiltraDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTFiltraApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTFiltraNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFiltraDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFiltraApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFiltraNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jBNuevoSocio.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jBNuevoSocio.setText("Agregar Nuevo Socio");
        jBNuevoSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNuevoSocioActionPerformed(evt);
            }
        });

        jBModificarSocios.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jBModificarSocios.setText("Modificar Datos");
        jBModificarSocios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarSociosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBNuevoSocio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBModificarSocios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBNuevoSocio, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBModificarSocios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBModificarSocios, jBNuevoSocio});

        jTablaSocios.setAutoCreateRowSorter(true);
        jTablaSocios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Apellido y Nombre", "Celular", "Estado", "Vencimiento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablaSocios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTablaSocios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTablaSocios.setEditingColumn(0);
        jTablaSocios.setEditingRow(0);
        jTablaSocios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTablaSocios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaSociosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablaSocios);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actividades del Socio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("BankGothic Lt BT", 1, 14))); // NOI18N

        jTActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Actividad", "Turno", "Profesor", "Pases Disponibles"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTActividades);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Historial de Cuenta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("BankGothic Lt BT", 1, 14))); // NOI18N

        jTCuenta.setAutoCreateRowSorter(true);
        jTCuenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Forma de Pago", "Importe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTCuenta);

        jScrollPane9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Asistencias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("BankGothic Lt BT", 1, 14))); // NOI18N

        jTAsistencias.setAutoCreateRowSorter(true);
        jTAsistencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Actividad", "Profesor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(jTAsistencias);

        jBCuentas.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jBCuentas.setText("Gestión de Cuenta del Socio");
        jBCuentas.setEnabled(false);
        jBCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCuentasActionPerformed(evt);
            }
        });

        jBActividades.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jBActividades.setText("Gestión de Actividades del Socio");
        jBActividades.setEnabled(false);
        jBActividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActividadesActionPerformed(evt);
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
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addComponent(jBActividades, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBCuentas)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCuentas)
                    .addComponent(jBActividades))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jBNuevoSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNuevoSocioActionPerformed
        new Form_ABMSocios().setVisible(true);
    }//GEN-LAST:event_jBNuevoSocioActionPerformed

    private void jTablaSociosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaSociosMouseClicked
        DNIseleccionado = jTablaSocios.getValueAt(jTablaSocios.getSelectedRow(), 0).toString();
        jBActividades.setEnabled(true);
        jBCuentas.setEnabled(true);
        SocioSeleccionado(DNIseleccionado);


}//GEN-LAST:event_jTablaSociosMouseClicked

    private void jBModificarSociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarSociosActionPerformed
        if (jTablaSocios.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar primero el socio a modificar");
        } else {
            String DNI = jTablaSocios.getValueAt(jTablaSocios.getSelectedRow(), 0).toString();

            //ActualizarActividades(NroSocio);
            new Form_ABMSocios(DNI).setVisible(true);

        }
    }//GEN-LAST:event_jBModificarSociosActionPerformed

    private void jTFiltraDocumentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFiltraDocumentoKeyReleased
        if (evt.getKeyCode() == 10) {
            DefaultTableModel modelo = (DefaultTableModel) jTablaSocios.getModel();
            modelo.setRowCount(0);
            List<Socios> listaSocios = Socios.listaSocios();
            int listaSociosSize = listaSocios.size();
            for (int i = 0; i < listaSociosSize; i++) {
                Socios socio_leido = listaSocios.get(i);
                if (socio_leido.getPersona().getDNI().contains(jTFiltraDocumento.getText())) {
                    String DNI = socio_leido.getPersona().getDNI();
                    String Socio = socio_leido.getPersona().getApellido() + " "
                            + socio_leido.getPersona().getNombre();
                    String Celular = socio_leido.getPersona().getCelular();
                    String Estado = socio_leido.getEstado().getEstado();
                    String Vencimiento = seteosGUI.fechaCorta(socio_leido.getPrimerVencimiento()).toString();

                    Object[] fila = {DNI, Socio, Celular, Estado, Vencimiento};
                    modelo.addRow(fila);
                }
            }
        }
    }//GEN-LAST:event_jTFiltraDocumentoKeyReleased

    private void jTFiltraApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFiltraApellidoKeyReleased
        if (evt.getKeyCode() == 10) {
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            DefaultTableModel modelo = (DefaultTableModel) jTablaSocios.getModel();
            modelo.setRowCount(0);
            List<Socios> listaSocios = Socios.listaSocios();
            int listaSociosSize = listaSocios.size();
            for (int i = 0; i < listaSociosSize; i++) {
                Socios socio_leido = listaSocios.get(i);
                if (socio_leido.getPersona().getApellido().contains(jTFiltraApellido.getText().toUpperCase())) {
                    String DNI = socio_leido.getPersona().getDNI();
                    String Socio = socio_leido.getPersona().getApellido() + " "
                            + socio_leido.getPersona().getNombre();
                    String Celular = socio_leido.getPersona().getCelular();
                    String Estado = socio_leido.getEstado().getEstado();
                    String Vencimiento = seteosGUI.fechaCorta(socio_leido.getPrimerVencimiento()).toString();

                    Object[] fila = {DNI, Socio, Celular, Estado, Vencimiento};
                    modelo.addRow(fila);
                }
            }
            sesion.close();
        }
    }//GEN-LAST:event_jTFiltraApellidoKeyReleased

    private void jTFiltraNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFiltraNombreKeyReleased
        if (evt.getKeyCode() == 10) {
            DefaultTableModel modelo = (DefaultTableModel) jTablaSocios.getModel();
            modelo.setRowCount(0);
            List<Socios> listaSocios = Socios.listaSocios("From Socios where situacion=1");
            int listaSociosSize = listaSocios.size();
            for (int i = 0; i < listaSociosSize; i++) {
                Socios socio_leido = listaSocios.get(i);
                if (socio_leido.getPersona().getNombre().contains(jTFiltraNombre.getText().toUpperCase())) {
                    String DNI = socio_leido.getPersona().getDNI();
                    String Socio = socio_leido.getPersona().getApellido() + " "
                            + socio_leido.getPersona().getNombre();
                    String Celular = socio_leido.getPersona().getCelular();
                    String Estado = socio_leido.getEstado().getEstado();
                    String Vencimiento = seteosGUI.fechaCorta(socio_leido.getPrimerVencimiento()).toString();

                    Object[] fila = {DNI, Socio, Celular, Estado, Vencimiento};
                    modelo.addRow(fila);
                }
            }
        }
    }//GEN-LAST:event_jTFiltraNombreKeyReleased

    private void jBActividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActividadesActionPerformed
        String Socio = jTablaSocios.getValueAt(jTablaSocios.getSelectedRow(), 0).toString();
        new Form_Relaciona_Actividades_Socios(Socio).setVisible(true);
    }//GEN-LAST:event_jBActividadesActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
    }//GEN-LAST:event_formWindowGainedFocus

    private void jBCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCuentasActionPerformed

        new GestionMovimientosdeCuentas(DNIseleccionado).setVisible(true);
    }//GEN-LAST:event_jBCuentasActionPerformed

    private void jCEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCEstadoActionPerformed
        if (jCEstado.getSelectedIndex() == 0) {
        } else {
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            DefaultTableModel modelo = (DefaultTableModel) jTablaSocios.getModel();
            modelo.setRowCount(0);
            List<Socios> listaSocios = Socios.listaSocios("From Socios where situacion=1");
            int listaSociosSize = listaSocios.size();
            for (int i = 0; i < listaSociosSize; i++) {
                Socios socio_leido = listaSocios.get(i);
                if (socio_leido.getEstado().getIdEstado() == jCEstado.getSelectedIndex()) {
                    String DNI = socio_leido.getPersona().getDNI();
                    String Socio = socio_leido.getPersona().getApellido() + " "
                            + socio_leido.getPersona().getNombre();
                    String Celular = socio_leido.getPersona().getCelular();
                    String Vencimiento = seteosGUI.fechaCorta(socio_leido.getPrimerVencimiento()).toString();
                    String Estado = socio_leido.getEstado().getEstado();
                    Object[] fila = {DNI, Socio, Celular, Estado, Vencimiento};
                    modelo.addRow(fila);
                }
            }
        }
    }//GEN-LAST:event_jCEstadoActionPerformed

    private void jTFiltraApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFiltraApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFiltraApellidoActionPerformed

    public void filtraSocios(String query, String condicion, String valor) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        DefaultTableModel modelo = (DefaultTableModel) jTablaSocios.getModel();
        modelo.setRowCount(0);
        Query query_socios = sesion.createQuery(query);
        List<Socios> lista_socios = query_socios.list();
        for (int i = 0; i < lista_socios.size(); i++) {
            Socios socio_leido = lista_socios.get(i);
            if (socio_leido.getEstado().getIdEstado() == jCEstado.getSelectedIndex()) {
                String DNI = socio_leido.getPersona().getDNI();
                String Socio = socio_leido.getPersona().getApellido() + " "
                        + socio_leido.getPersona().getNombre();
                String Celular = socio_leido.getPersona().getCelular();
                String Vencimiento = seteosGUI.fechaCorta(socio_leido.getPrimerVencimiento()).toString();
                String Estado = socio_leido.getEstado().getEstado();
                Object[] fila = {DNI, Socio, Celular, Estado, Vencimiento};
                modelo.addRow(fila);
            

}
        }

    }

    public class MyCellRenderer extends DefaultTableCellRenderer {
//Analizar en donde pasar el parametro por cada fila para marcar en rojo los inactivos

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        boolean valid = String.valueOf(table.getValueAt(row, 2)).equals("Activo");
        component.setForeground(valid ? Color.black : Color.red);
        return component;
    }
}
/**
 * @param args the command line arguments
 */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActividades;
    private javax.swing.JButton jBCuentas;
    private javax.swing.JButton jBModificarSocios;
    private javax.swing.JButton jBNuevoSocio;
    private javax.swing.JComboBox jCEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTActividades;
    private javax.swing.JTable jTAsistencias;
    private javax.swing.JTable jTCuenta;
    private javax.swing.JTextField jTFiltraApellido;
    private javax.swing.JTextField jTFiltraDocumento;
    private javax.swing.JTextField jTFiltraNombre;
    private javax.swing.JTable jTablaSocios;
    // End of variables declaration//GEN-END:variables
}
