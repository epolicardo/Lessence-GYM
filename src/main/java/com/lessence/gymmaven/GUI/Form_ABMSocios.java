/*
 * Form_ABMSocios.java
 *
 * Created on 10 de junio de 2015, 09:10
 */
package com.lessence.gymmaven.GUI;

import com.lessence.gymmaven.clases.Domicilios;
import com.lessence.gymmaven.clases.EstadoCivil;
import com.lessence.gymmaven.clases.Estados;
import com.lessence.gymmaven.clases.HibernateUtil;
import com.lessence.gymmaven.clases.Localidades;
import com.lessence.gymmaven.clases.Personas;
import static com.lessence.gymmaven.clases.Personas.consultaBase;
import com.lessence.gymmaven.clases.Socios;
import com.lessence.gymmaven.clases.claseFunciones;
import com.lessence.gymmaven.clases.seteosGUI;
import java.awt.Image;
import java.io.File;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Emiliano
 */
public class Form_ABMSocios extends javax.swing.JFrame {

    /**
     * Creates new form Form_ABMSocios
     */
    private int OpcionSexo;
    private String Piso;
    private int Sexo = 0;
    private String localidad_seleccionada;
    private String url_foto;

    private Estados estado;
    private Localidades localidad;
    String certificado = "certificado";
    String apto = "apto";
    private boolean bandera;

    public void inicioFormulario() {
        initComponents();
        claseFunciones.ComboGenerico(jCLocalidades, "Localidades", "idLocalidad", "Localidad");
        claseFunciones.ComboGenerico(jCEstadoCivil, "Estado_Civil", "idEstado", "estadoCivil");
        claseFunciones.ComboGenerico(jCEstado, "Estados", "idEstado", "Estado");
        jCEstado.setSelectedIndex(0);
        jDCAlta.setDate(Date.from(Instant.now()));
        this.setLocationRelativeTo(null);
//        this.setExtendedState(MAXIMIZED_BOTH);
    }

    public Form_ABMSocios() {
        inicioFormulario();
        jBGuardaSocio.setText("Guardar");
        labelDNI.setVisible(false);
        jcbVigente.setSelected(true);
        jCEstado.setSelectedIndex(0);
        jDCAlta.setDate(Date.from(Instant.now()));

    }

    public Form_ABMSocios(String DNI) {
        inicioFormulario();
        jBGuardaSocio.setText("Guardar Cambios");
        jTDocumento.setText(String.valueOf(DNI));
        RellenarTextos(DNI);
        labelDNI.setVisible(false);
        labelDNI.setText(DNI);

    }

    private void RellenarTextos(String DNI) {

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Socios> listaSocios = Socios.listaSocios();
        for (int i = 0; i < listaSocios.size(); i++) {
            Socios socio = listaSocios.get(i);
            if (socio.getPersona().getDNI().equals(DNI)) {

                jTDocumento.setText(socio.getPersona().getDNI());
                jTApellido.setText(socio.getPersona().getApellido());
                jTNombre.setText(socio.getPersona().getNombre());
                jTCalle.setText(socio.getPersona().getDomicilios().get(0).getCalle());
                jTNro.setText(socio.getPersona().getDomicilios().get(0).getNro());
                jTPiso.setText(socio.getPersona().getDomicilios().get(0).getPiso());
                jTDpto.setText(socio.getPersona().getDomicilios().get(0).getDpto());
                jTBarrio.setText(socio.getPersona().getDomicilios().get(0).getBarrio());
                jCLocalidades.setSelectedIndex(socio.getPersona().getDomicilios().get(0).getLocalidad().getIdLocalidad() - 1);
                jTCodigoPostal.setText(socio.getPersona().getDomicilios().get(0).getCodigoPostal());
                jDCNacimiento.setDate(socio.getPersona().getFechaNacimiento());
                jSHijos.setValue(socio.getPersona().getHijos());
                if (socio.getPersona().getSexo() == 1) {
                    jRBMasculino.setSelected(true);
                } else {
                    jRBFemenino.setSelected(true);
                }
                jTTelefono.setText(socio.getPersona().getTelefono());
                jTCelular.setText(socio.getPersona().getCelular());
                jTMail.setText(socio.getPersona().getCorreo());
                jDCAlta.setDate(socio.getFechaAlta());
                jtVencimientoAsignado.setText(seteosGUI.fechaLarga(socio.getPrimerVencimiento()));
                jcbPeriodos.setSelectedIndex(socio.getCiclo() - 1);
                jCEstado.setSelectedIndex(socio.getEstado().getIdEstado() - 1);
                jCEstadoCivil.setSelectedIndex(socio.getPersona().getEstadoCivil().getIdEstado() - 1);
                if (socio.getSituacion() == 1) {
                    jcbVigente.setSelected(true);
                } else {
                    jcbVigente.setSelected(false);
                }

            }
        }
        sesion.close();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel12 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jCEstadoCivil = new javax.swing.JComboBox();
        jPanel6 = new javax.swing.JPanel();
        jRBMasculino = new javax.swing.JRadioButton();
        jRBFemenino = new javax.swing.JRadioButton();
        jDCNacimiento = new com.toedter.calendar.JDateChooser();
        jSHijos = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTTelefono = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTCelular = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTMail = new javax.swing.JTextField();
        jCEmpCelular = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTCalle = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTBarrio = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jCLocalidades = new javax.swing.JComboBox();
        jTNro = new javax.swing.JTextField();
        jTPiso = new javax.swing.JTextField();
        jTDpto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTCodigoPostal = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTDocumento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTNombre = new javax.swing.JTextField();
        labelDNI = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jBApto = new javax.swing.JButton();
        jBCertificado = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jCEstado = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jDCAlta = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        jcbPeriodos = new javax.swing.JComboBox<>();
        jLFotoSocio = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jcbVigente = new javax.swing.JCheckBox();
        jtVencimientoAsignado = new javax.swing.JTextField();
        jcbVencimientoManual = new javax.swing.JCheckBox();
        jdcVencimientoManual = new com.toedter.calendar.JDateChooser();
        jPanel8 = new javax.swing.JPanel();
        jBGuardaSocio = new javax.swing.JButton();
        jBCancelaSocio = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel12.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos Personales", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("BankGothic Lt BT", 0, 14))); // NOI18N
        jPanel1.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        jLabel14.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel14.setText("Hijos");

        jLabel16.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel16.setText("Estado civil");

        jLabel15.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel15.setText("Fecha de Nacimiento");

        jCEstadoCivil.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jCEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Soltero", "Casado" }));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sexo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("BankGothic Lt BT", 0, 14))); // NOI18N
        jPanel6.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        buttonGroup2.add(jRBMasculino);
        jRBMasculino.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jRBMasculino.setText("Masculino");
        jRBMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBMasculinoActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRBFemenino);
        jRBFemenino.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jRBFemenino.setText("Femenino");
        jRBFemenino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBFemeninoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRBMasculino)
                .addGap(18, 18, 18)
                .addComponent(jRBFemenino)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBMasculino)
                    .addComponent(jRBFemenino))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDCNacimiento.setDateFormatString("dd-MM-yyyy");
        jDCNacimiento.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jSHijos.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDCNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSHijos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jCEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSHijos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(jLabel16)
                                .addComponent(jLabel14))
                            .addGap(2, 2, 2)
                            .addComponent(jDCNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Contactos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("BankGothic Lt BT", 0, 14))); // NOI18N

        jLabel9.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel9.setText("Teléfono");

        jTTelefono.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel10.setText("Celular");

        jTCelular.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel11.setText("Correo electrónico");

        jTMail.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jCEmpCelular.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jCEmpCelular.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Claro", "Movistar", "Nextel", "Personal", "Quam", "Otras" }));

        jLabel17.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel17.setText("Empresa");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTTelefono)
                    .addComponent(jTCelular)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jCEmpCelular, 0, 336, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addComponent(jTMail)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel17))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCEmpCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel6.setText("Calle");

        jTCalle.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel5.setText("Barrio");

        jTBarrio.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel12.setText("Localidad");

        jCLocalidades.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jCLocalidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCLocalidadesActionPerformed(evt);
            }
        });

        jTNro.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jTPiso.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jTDpto.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel1.setText("Nro");

        jLabel13.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel13.setText("Piso");

        jLabel27.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel27.setText("Dpto");

        jTCodigoPostal.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel18.setText("Código Postal");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jTBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCLocalidades, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTCodigoPostal)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jTCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTNro)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jTPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jTDpto, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTDpto, jTPiso});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1)
                    .addComponent(jLabel13)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTDpto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel12)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCLocalidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel2.setText("Documento");

        jTDocumento.setFont(new java.awt.Font("BankGothic Lt BT", 1, 18)); // NOI18N
        jTDocumento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTDocumentoFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel3.setText("Apellido");

        jTApellido.setFont(new java.awt.Font("BankGothic Lt BT", 1, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel4.setText("Nombre");

        jTNombre.setFont(new java.awt.Font("BankGothic Lt BT", 1, 18)); // NOI18N

        labelDNI.setText("DNI");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelDNI))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 32, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDNI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTApellido)
                    .addComponent(jTNombre))
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos de Socio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("BankGothic Lt BT", 0, 14))); // NOI18N

        jBApto.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jBApto.setText("Cargar Apto Físico");
        jBApto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAptoActionPerformed(evt);
            }
        });

        jBCertificado.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jBCertificado.setText("Cargar Certificado Médico");
        jBCertificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCertificadoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel8.setText("Estado");

        jCEstado.setFont(new java.awt.Font("BankGothic Lt BT", 1, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel7.setText("Fecha de Alta");

        jDCAlta.setDateFormatString("dd-MM-yyyy");
        jDCAlta.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Periodo de Vencimientos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("BankGothic Lt BT", 0, 14))); // NOI18N

        jcbPeriodos.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jcbPeriodos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mensual", "Quincenal", "Semanal" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbPeriodos, 0, 358, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbPeriodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLFotoSocio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLFotoSocio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Lessence.png"))); // NOI18N
        jLFotoSocio.setToolTipText("Doble click para seleccionar imágen");
        jLFotoSocio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLFotoSocio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLFotoSocioMouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel19.setText("Vencimiento asignado");

        jcbVigente.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jcbVigente.setText("Vigente");

        jtVencimientoAsignado.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jtVencimientoAsignado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtVencimientoAsignado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtVencimientoAsignado.setEnabled(false);

        jcbVencimientoManual.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jcbVencimientoManual.setText("Modifica Vencimiento");

        jdcVencimientoManual.setDateFormatString("dd-MM-yyyy");
        jdcVencimientoManual.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jdcVencimientoManual.setMinSelectableDate(new java.util.Date(-1577907792000L));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jcbVencimientoManual)
                        .addGap(18, 18, 18)
                        .addComponent(jdcVencimientoManual, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBCertificado, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                            .addComponent(jBApto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(13, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jDCAlta, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jCEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtVencimientoAsignado))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLFotoSocio)
                            .addComponent(jcbVigente))
                        .addGap(36, 36, 36))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDCAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19))
                    .addComponent(jLFotoSocio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbVigente)
                    .addComponent(jtVencimientoAsignado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbVencimientoManual)
                    .addComponent(jdcVencimientoManual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBCertificado)
                .addGap(18, 18, 18)
                .addComponent(jBApto)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jDCAlta, jdcVencimientoManual});

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBGuardaSocio.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jBGuardaSocio.setText("Guardar");
        jBGuardaSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardaSocioActionPerformed(evt);
            }
        });

        jBCancelaSocio.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jBCancelaSocio.setText("Cerrar");
        jBCancelaSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelaSocioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBGuardaSocio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBCancelaSocio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBGuardaSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCancelaSocio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBCancelaSocio, jBGuardaSocio});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel12, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBGuardaSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardaSocioActionPerformed
       
        if ("Guardar".equals(jBGuardaSocio.getText())) {

            if (bandera == false) {
                nuevoSocio();
            }

        } else if ("Guardar Cambios".equals(jBGuardaSocio.getText())) {
            int decisionUsuario = JOptionPane.showConfirmDialog(rootPane, "¿Desea guardar los cambios realizados?", "ABM Socios", JOptionPane.YES_NO_OPTION);
            if (decisionUsuario == 1) {
                JOptionPane.showMessageDialog(rootPane, "No se guardaron los cambios realizados");
                rootPane.removeAll();
                inicioFormulario();
            } else if (decisionUsuario == 0) {
                Session sesion = HibernateUtil.getSessionFactory().openSession();
                Criteria consultaSocios = sesion.createCriteria(Socios.class);
                List<Socios> listaSocios = consultaSocios.list();
                for (int i = 0; i < listaSocios.size(); i++) {
                    Socios socio = listaSocios.get(i);
                    if (socio.getPersona().getDNI().equals(labelDNI.getText())) {
                        Personas persona = socio.getPersona();
                        persona.setDNI(jTDocumento.getText());
                        persona.setApellido(jTApellido.getText().toUpperCase());
                        persona.setNombre(jTNombre.getText().toUpperCase());
                        persona.setTelefono(jTTelefono.getText());
                        persona.setCelular(jTCelular.getText());
                        persona.setCorreo(jTMail.getText());
                        persona.setFechaNacimiento(jDCNacimiento.getDate());
                        persona.setSexo(Sexo);
                        persona.setHijos(Integer.valueOf(jSHijos.getValue().toString()));
                        persona.setFoto("Foto");

                        Domicilios domicilio = socio.getPersona().getDomicilios().get(0);
                        domicilio.setCalle(jTCalle.getText());
                        domicilio.setNro(jTNro.getText());
                        domicilio.setPiso(jTPiso.getText());
                        domicilio.setDpto(jTDpto.getText());
                        domicilio.setBarrio(jTBarrio.getText());
                        domicilio.setCodigoPostal(jTCodigoPostal.getText());
                        socio.setAptoFisico(apto);
                        socio.setDecJurada(certificado);
                        socio.setFechaAlta(jDCAlta.getDate());
//                        socio.setFoto();
                        socio.setFechaAlta(jDCAlta.getDate());
                        if (jcbVigente.isSelected()) {
                            socio.setSituacion(1);
                        } else {
                            socio.setSituacion(0);
                        }
                        if (jcbVencimientoManual.isSelected()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(jdcVencimientoManual.getDate()); // Configuramos la fecha que se recibe
                            socio.setPrimerVencimiento(calendar.getTime());
                            calendar.add(Calendar.DAY_OF_YEAR, 10);
                            socio.setSegundoVencimiento(calendar.getTime());
                            socio.setCiclo(jcbPeriodos.getSelectedIndex() + 1);
                        } else if (0 == JOptionPane.showConfirmDialog(this, "Desea actualizar la fecha de vencimiento asignada?\n"
                                + "Si acepta el cambio la fecha del nuevo vencimiento\nserá 30 dias posterior a la "
                                + "fecha actualmente asignada.", "Vencimientos", JOptionPane.YES_NO_OPTION)) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(socio.getPrimerVencimiento()); // Configuramos la fecha que se recibe
                            int ciclo = 0;
                            int dias = 0;
                            switch (jcbPeriodos.getSelectedIndex()) {
                                case 0:
                                    dias = 30;
                                    ciclo = 1;
                                    break;
                                case 1:
                                    dias = 15;
                                    ciclo = 2;
                                    break;
                                case 2:
                                    dias = 7;
                                    ciclo = 3;
                                    break;
                                default:
                                    break;
                            }
                            calendar.add(Calendar.DAY_OF_YEAR, dias);
                            socio.setPrimerVencimiento(calendar.getTime());
                            calendar.add(Calendar.DAY_OF_YEAR, 10);
                            socio.setSegundoVencimiento(calendar.getTime());
                            socio.setCiclo(jcbPeriodos.getSelectedIndex() + 1);
                        }
                        Criteria cr_Estado = sesion.createCriteria(Estados.class);
                        List<Estados> listaEstados = cr_Estado.list();
                        for (int h = 0; h < listaEstados.size(); h++) {
                            estado = listaEstados.get(h);
                            if (estado.getIdEstado() == jCEstado.getSelectedIndex() + 1) {
                                socio.setEstado(estado);
                            }
                        }
                        sesion.beginTransaction();
                        sesion.update(domicilio);
                        persona.addDomicilio(domicilio);
                        sesion.update(persona);
                        socio.setPersona(persona);
                        sesion.update(socio);
                        sesion.getTransaction().commit();
                        sesion.close();
                        JOptionPane.showMessageDialog(rootPane, "Se guardaron con éxito los cambios realizados");
                        this.getContentPane().removeAll();
                        inicioFormulario();
                    }

                }
            }
        }
    }//GEN-LAST:event_jBGuardaSocioActionPerformed

    private void jLFotoSocioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLFotoSocioMouseClicked
        if (evt.getClickCount() == 2) {
            JFileChooser archivo = new JFileChooser();
            int ventana = archivo.showOpenDialog(null);
            if (ventana == JFileChooser.APPROVE_OPTION) {
                File file = archivo.getSelectedFile();
                url_foto = file.getPath();
                Image FotoSocio = getToolkit().getImage(jLFotoSocio.getIcon().toString());
                FotoSocio = FotoSocio.getScaledInstance(220, 165, Image.SCALE_DEFAULT);
                jLFotoSocio.setIcon(new ImageIcon(FotoSocio));

            }
        }

    }//GEN-LAST:event_jLFotoSocioMouseClicked

    private void jBCertificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCertificadoActionPerformed
        JFileChooser archivo = new JFileChooser();
        int ventana = archivo.showOpenDialog(null);
        if (ventana == JFileChooser.APPROVE_OPTION) {
            certificado = archivo.getSelectedFile().getPath();

        }
    }//GEN-LAST:event_jBCertificadoActionPerformed

    private void jBAptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAptoActionPerformed
        JFileChooser archivo = new JFileChooser();
        int ventana = archivo.showOpenDialog(null);
        if (ventana == JFileChooser.APPROVE_OPTION) {
            apto = archivo.getSelectedFile().getPath();

        }
    }//GEN-LAST:event_jBAptoActionPerformed

    private void jRBFemeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBFemeninoActionPerformed
        OpcionSexo = 2;
    }//GEN-LAST:event_jRBFemeninoActionPerformed

    private void jRBMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBMasculinoActionPerformed
        OpcionSexo = 1;
    }//GEN-LAST:event_jRBMasculinoActionPerformed

    private void jCLocalidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCLocalidadesActionPerformed

    }//GEN-LAST:event_jCLocalidadesActionPerformed

    private void jBCancelaSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelaSocioActionPerformed
        if ("Guardar Cambios".equals(jBGuardaSocio.getText())) {
            if (JOptionPane.showConfirmDialog(this, "Desea deshacer los cambios realizados", "ABM Socios - Modificación", JOptionPane.YES_NO_OPTION) == 0) {
//                this.getContentPane().removeAll();
//                inicioFormulario();
                this.dispose();
            }
        } else if (JOptionPane.showConfirmDialog(this, "Desea deshacer los cambios realizados", "ABM Socios", JOptionPane.YES_NO_OPTION) == 0) {
//            this.getContentPane().removeAll();
//            initComponents();
            this.dispose();
        }
    }//GEN-LAST:event_jBCancelaSocioActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Inicial inicial = new Inicial();
        inicial.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void jTDocumentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTDocumentoFocusLost
        List<Personas> consultaBase = Personas.consultaBase();
        if (consultaBase.isEmpty()) {
            nuevoSocio();
            bandera = true;
        } else {

            for (int i = 0; i < consultaBase.size(); i++) {
                Personas p = consultaBase.get(i);
                if (jTDocumento.getText().equals(p.getDNI())) {
                    //La persona ya existe
                    JOptionPane.showMessageDialog(this, "El número de DNI está asignado a una persona existente", "ABM Socios", JOptionPane.ERROR_MESSAGE);
                    i = consultaBase.size();
                    bandera = true;
                    if (0 == JOptionPane.showConfirmDialog(this,
                            "Desea cargar los datos de la persona ya existente?\nEsto reemplazará los campos que se hayan utilizado",
                            "ABM Socios", JOptionPane.YES_NO_OPTION)) {

                        jBGuardaSocio.setText("Guardar Cambios");
                        RellenarTextos(jTDocumento.getText());
                        jTDocumento.setText(String.valueOf(jTDocumento.getText()));
                        labelDNI.setVisible(false);
                        labelDNI.setText(jTDocumento.getText());
                    }
                }
            }

        }
    }//GEN-LAST:event_jTDocumentoFocusLost

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jBApto;
    private javax.swing.JButton jBCancelaSocio;
    private javax.swing.JButton jBCertificado;
    private javax.swing.JButton jBGuardaSocio;
    private javax.swing.JComboBox jCEmpCelular;
    private javax.swing.JComboBox jCEstado;
    private javax.swing.JComboBox jCEstadoCivil;
    private javax.swing.JComboBox jCLocalidades;
    private com.toedter.calendar.JDateChooser jDCAlta;
    private com.toedter.calendar.JDateChooser jDCNacimiento;
    private javax.swing.JLabel jLFotoSocio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRBFemenino;
    private javax.swing.JRadioButton jRBMasculino;
    private javax.swing.JSpinner jSHijos;
    private javax.swing.JTextField jTApellido;
    private javax.swing.JTextField jTBarrio;
    private javax.swing.JTextField jTCalle;
    private javax.swing.JTextField jTCelular;
    private javax.swing.JTextField jTCodigoPostal;
    private javax.swing.JTextField jTDocumento;
    private javax.swing.JTextField jTDpto;
    private javax.swing.JTextField jTMail;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTNro;
    private javax.swing.JTextField jTPiso;
    private javax.swing.JTextField jTTelefono;
    private javax.swing.JComboBox<String> jcbPeriodos;
    private javax.swing.JCheckBox jcbVencimientoManual;
    private javax.swing.JCheckBox jcbVigente;
    private com.toedter.calendar.JDateChooser jdcVencimientoManual;
    private javax.swing.JTextField jtVencimientoAsignado;
    private javax.swing.JLabel labelDNI;
    // End of variables declaration//GEN-END:variables

    private void nuevoSocio() {

        String Nombre = jTNombre.getText().toUpperCase();
        String Apellido = jTApellido.getText().toUpperCase();
        String Calle = jTCalle.getText();
        String Nro = jTNro.getText();
        Piso = jTPiso.getText();
        String Dpto = jTDpto.getText();
        String Bario = jTBarrio.getText();
        String Telefono = jTTelefono.getText();
        int Empresa = jCEmpCelular.getSelectedIndex();
        String Celular = jTCelular.getText();
        String Correo = jTMail.getText();
        int Hijos = Integer.parseInt(jSHijos.getValue().toString());
        String Foto = jLFotoSocio.getIcon().toString();
        if (jRBFemenino.isSelected()) {
            Sexo = 2;
        } else if (jRBMasculino.isSelected()) {
            Sexo = 1;
        }

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Personas persona = new Personas();
        Socios socio = new Socios();
        Domicilios domicilio = new Domicilios();

        List<Object> listaEstadoCivil = EstadoCivil.consultaBase();
        for (int i = 0; i < listaEstadoCivil.size(); i++) {
            EstadoCivil estadoCivil = (EstadoCivil) listaEstadoCivil.get(i);
            if (estadoCivil.getIdEstado() == jCEstadoCivil.getSelectedIndex() + 1) {
                persona.setEstadoCivil(estadoCivil);
            }
        }

        Criteria cr_Estado = sesion.createCriteria(Estados.class);
        List<Estados> listaEstados = cr_Estado.list();
        for (int i = 0; i < listaEstados.size(); i++) {
            estado = listaEstados.get(i);
            if (estado.getIdEstado() == jCEstado.getSelectedIndex() + 1) {
                socio.setEstado(estado);
            }
        }

        List<Object> listaLocalidades = Localidades.consultaBase();
        for (int i = 0; i < listaLocalidades.size(); i++) {
            localidad = (Localidades) listaLocalidades.get(i);
            if (localidad.getIdLocalidad() == jCLocalidades.getSelectedIndex() + 1) {
                domicilio.setLocalidad(localidad);
            }
        }
        persona.setDNI(jTDocumento.getText());
        persona.setApellido(Apellido);
        persona.setNombre(Nombre);
        persona.setTelefono(Telefono);
        persona.setCelular(Celular);
        persona.setCorreo(Correo);
        persona.setFechaNacimiento(jDCNacimiento.getDate());
        persona.setSexo(Sexo);
        persona.setHijos(Hijos);
        persona.setFoto(Foto);

        domicilio.setCalle(Calle);
        domicilio.setNro(Nro);
        domicilio.setPiso(Piso);
        domicilio.setDpto(Dpto);
        domicilio.setBarrio(Bario);
        domicilio.setCodigoPostal(jTCodigoPostal.getText());
        socio.setSituacion(1);
        socio.setAptoFisico(apto);
        socio.setDecJurada(certificado);
        socio.setFechaAlta(jDCAlta.getDate());
        socio.setVencimientoPrevio(Date.from(Instant.now()));
//        socio.setFoto("url_foto");
        socio.setPersona(persona);
        if (jcbVencimientoManual.isSelected()) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(jdcVencimientoManual.getDate()); // Configuramos la fecha que se recibe
            socio.setPrimerVencimiento(calendar.getTime());
            calendar.add(Calendar.DAY_OF_YEAR, 10);
            socio.setSegundoVencimiento(calendar.getTime());
            socio.setCiclo(jcbPeriodos.getSelectedIndex() + 1);
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(jDCAlta.getDate()); // Configuramos la fecha que se recibe
            int dias = 30;
            calendar.add(Calendar.DAY_OF_YEAR, dias);
            socio.setPrimerVencimiento(calendar.getTime());
            calendar.add(Calendar.DAY_OF_YEAR, 10);
            socio.setSegundoVencimiento(calendar.getTime());
            socio.setCiclo(jcbPeriodos.getSelectedIndex() + 1);
        }

//            dias = 0;
        sesion.beginTransaction();
        sesion.save(domicilio);
        persona.addDomicilio(domicilio);
        sesion.save(persona);
        sesion.save(socio);
        sesion.getTransaction().commit();

        sesion.close();

        JOptionPane.showMessageDialog(rootPane, "El Socio " + Nombre + " " + Apellido
                + " fue guardado con éxito.", "ABM Socios", JOptionPane.INFORMATION_MESSAGE);

        this.getContentPane().removeAll();
        inicioFormulario();

    }

}
