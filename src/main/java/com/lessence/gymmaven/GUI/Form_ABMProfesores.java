/*
 * Form_ABMProfesores.java
 *
 * Created on 10 de junio de 2015, 14:02
 */
package com.lessence.gymmaven.GUI;


import com.lessence.gymmaven.clases.Domicilios;
import com.lessence.gymmaven.clases.EstadoCivil;
import com.lessence.gymmaven.clases.Estados;
import com.lessence.gymmaven.clases.HibernateUtil;
import com.lessence.gymmaven.clases.Localidades;
import com.lessence.gymmaven.clases.Personas;
import com.lessence.gymmaven.clases.Profesores;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Emiliano
 */
public class Form_ABMProfesores extends javax.swing.JDialog {
    
    private int OpcionSexo;
    String Piso = "";
    private Estados estado;
    private Personas NuevaPersona;
    private Personas persona;

    /**
     *  //TODO En el abm de todos los formularios, en el combo Localidades y
     * combos similares, // mostrar al fin de la lista la opcion de añadir uno
     * nuevo sin salir de esa pantalla y poder continuar en caso de haber
     * cargado algun dato.
     */
    public Form_ABMProfesores() {
        inicioFormulario();
        jBGuardaProfesor.setText("Guardar");
        
//        jCEstado.setSelectedIndex(0); //Activo por defecto
    }
    
    public Form_ABMProfesores(String DNI) {
        inicioFormulario();
        jBGuardaProfesor.setText("Guardar Cambios");
        RellenarTextos(DNI);
        
        labelDNI.setText(DNI);
        
    }
    
    public void inicioFormulario() {
        initComponents();
        
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Criteria CriteriaEstados = sesion.createCriteria(Estados.class);
        List<Estados> listaEstados = CriteriaEstados.list();
        for (int i = 0; i < listaEstados.size(); i++) {
            jCEstado.addItem(listaEstados.get(i).getEstado());
        }
        Criteria CriteriaLocalidad = sesion.createCriteria(Localidades.class);
        List<Localidades> listaLocalidad = CriteriaLocalidad.list();
        for (int i = 0; i < listaLocalidad.size(); i++) {
            jCLocalidades.addItem(listaLocalidad.get(i).getLocalidad());
        }
        Criteria CriteriaEstadoCivil = sesion.createCriteria(EstadoCivil.class);
        List<EstadoCivil> listaEstadoCivil = CriteriaEstadoCivil.list();
        for (int i = 0; i < listaEstadoCivil.size(); i++) {
            jCEstadoCivil.addItem(listaEstadoCivil.get(i).getEstadoCivil());
        }
        
        
        
//        claseFunciones.ComboGenerico(jCLocalidades, "Localidades", "idLocalidad", "Localidad");
//        claseFunciones.ComboGenerico(jCEstadoCivil, "Estado_Civil", "idEstado", "estadoCivil");
//        claseFunciones.ComboGenerico(jCEstado, "Estados", "idEstado", "Estado");
        this.setLocationRelativeTo(null);
        labelDNI.setVisible(false);
        jDCAlta.setDate(Date.from(Instant.now()));
    }
    
    private void RellenarTextos(String DNI) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Criteria consultaProfesores = sesion.createCriteria(Profesores.class);
        List<Profesores> listaProfesores = consultaProfesores.list();
        int listaProfesoresSize = listaProfesores.size();
        for (int i = 0; i < listaProfesoresSize; i++) {
            Profesores profesor = listaProfesores.get(i);
            if (profesor.getPersona().getDNI().equals(DNI)) {
                
                jTDocumento.setText(profesor.getPersona().getDNI());
                jTApellido.setText(profesor.getPersona().getApellido());
                jTNombre.setText(profesor.getPersona().getNombre());
                jTCalle.setText(profesor.getPersona().getDomicilios().get(0).getCalle());
                jTNro.setText(profesor.getPersona().getDomicilios().get(0).getNro());
                jTPiso.setText(profesor.getPersona().getDomicilios().get(0).getPiso());
                jTDpto.setText(profesor.getPersona().getDomicilios().get(0).getDpto());
                jTBarrio.setText(profesor.getPersona().getDomicilios().get(0).getBarrio());
                jCLocalidades.setSelectedIndex(profesor.getPersona().getDomicilios().get(0).getLocalidad().getIdLocalidad() - 1);
                jDCNacimiento.setDate(profesor.getPersona().getFechaNacimiento());
                jSHijos.setValue(profesor.getPersona().getHijos());
                if (profesor.getPersona().getSexo() == 1) {
                    jRBMasculino.setSelected(true);
                } else {
                    jRBFemenino.setSelected(true);
                }
                jTTelefono.setText(profesor.getPersona().getTelefono());
                jTCelular.setText(profesor.getPersona().getCelular());
                jTMail.setText(profesor.getPersona().getCorreo());
                jDCAlta.setDate(profesor.getFechaAlta());
                jCEstado.setSelectedIndex(profesor.getEstado().getIdEstado() - 1);
                jCEstadoCivil.setSelectedIndex(profesor.getPersona().getEstadoCivil().getIdEstado() - 1);
                
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
        jCEmpCelular = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTMail = new javax.swing.JTextField();
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
        jLabel18 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTDocumento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTNombre = new javax.swing.JTextField();
        labelDNI = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jBDocumento2 = new javax.swing.JButton();
        jBDocumento1 = new javax.swing.JButton();
        jTDocumento1 = new javax.swing.JTextField();
        jTDocumento2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jDCAlta = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCEstado = new javax.swing.JComboBox();
        jPanel8 = new javax.swing.JPanel();
        jBGuardaProfesor = new javax.swing.JButton();
        jBCancelaSocio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("BankGothic Lt BT", 0, 14))); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        jLabel14.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel14.setText("Hijos");

        jLabel16.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel16.setText("Estado civil");

        jLabel15.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel15.setText("Fecha de Nacimiento");

        jCEstadoCivil.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Sexo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("BankGothic Lt BT", 0, 14))); // NOI18N

        buttonGroup1.add(jRBMasculino);
        jRBMasculino.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jRBMasculino.setText("Masculino");
        jRBMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBMasculinoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBFemenino);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRBMasculino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBFemenino))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jRBMasculino)
                .addComponent(jRBFemenino))
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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDCNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jCEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jSHijos, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jDCNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSHijos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel9.setText("Teléfono");

        jTTelefono.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel10.setText("Celular");

        jTCelular.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jCEmpCelular.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jCEmpCelular.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Claro", "Movistar", "Nextel", "Personal", "Tuenti", "Otras" }));
        jCEmpCelular.setSelectedIndex(-1);

        jLabel17.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel17.setText("Prestador");

        jLabel11.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel11.setText("Correo electrónico");

        jTMail.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTMail)
                    .addComponent(jLabel11)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jTTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jTCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jCEmpCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(167, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTCelular, jTTelefono});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCEmpCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
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

        jTNro.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jTPiso.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jTDpto.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel1.setText("Nro");

        jLabel18.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel18.setText("Piso");

        jLabel27.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel27.setText("Dpto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jTCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTNro, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jTPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jTDpto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jTBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jCLocalidades, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(294, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTDpto, jTNro, jTPiso});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1)
                    .addComponent(jLabel18)
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
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCLocalidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel2.setText("Documento");

        jTDocumento.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jTDocumento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTDocumentoFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel3.setText("Apellido");

        jTApellido.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jTApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTApellidoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel4.setText("Nombre");

        jTNombre.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        labelDNI.setText("jLabel13");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jTApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(213, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelDNI)
                        .addGap(140, 140, 140))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelDNI)
                                .addComponent(jTDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBDocumento2.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jBDocumento2.setText("Cargar Otro Documento");
        jBDocumento2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDocumento2ActionPerformed(evt);
            }
        });

        jBDocumento1.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jBDocumento1.setText("Cargar Matricula");
        jBDocumento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDocumento1ActionPerformed(evt);
            }
        });

        jTDocumento1.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jTDocumento2.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jButton4.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jButton4.setText("Ver Archivo");

        jButton5.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jButton5.setText("Ver Archivo");

        jDCAlta.setDateFormatString("dd-MM-yyyy");
        jDCAlta.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel7.setText("Fecha de Alta");

        jLabel8.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jLabel8.setText("Estado");

        jCEstado.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jCEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDCAlta, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                            .addComponent(jBDocumento1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton4))
                        .addComponent(jTDocumento1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTDocumento2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                            .addComponent(jBDocumento2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton5))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDCAlta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBDocumento1)
                            .addComponent(jButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTDocumento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBDocumento2)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTDocumento2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBGuardaProfesor.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jBGuardaProfesor.setText("Guardar");
        jBGuardaProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardaProfesorActionPerformed(evt);
            }
        });

        jBCancelaSocio.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jBCancelaSocio.setText("Cancelar");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBGuardaProfesor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBCancelaSocio, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBGuardaProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBCancelaSocio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRBMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBMasculinoActionPerformed
        OpcionSexo = 1;
    }//GEN-LAST:event_jRBMasculinoActionPerformed

    private void jRBFemeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBFemeninoActionPerformed
        OpcionSexo = 2;
    }//GEN-LAST:event_jRBFemeninoActionPerformed

    private void jBDocumento2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDocumento2ActionPerformed
        JFileChooser archivo = new JFileChooser();
        int ventana = archivo.showOpenDialog(null);
        if (ventana == JFileChooser.APPROVE_OPTION) {
            jTDocumento2.setText(archivo.getSelectedFile().getPath());
            
        }
    }//GEN-LAST:event_jBDocumento2ActionPerformed

    private void jBDocumento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDocumento1ActionPerformed
        JFileChooser archivo = new JFileChooser();
        int ventana = archivo.showOpenDialog(null);
        if (ventana == JFileChooser.APPROVE_OPTION) {
            jTDocumento1.setText(archivo.getSelectedFile().getPath());
            
        }
    }//GEN-LAST:event_jBDocumento1ActionPerformed
    
    @SuppressWarnings("null")
    private void jBGuardaProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardaProfesorActionPerformed
        boolean existePersona = false;
        boolean existeProfe = false;
        if ("Guardar".equals(jBGuardaProfesor.getText())) {
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            List<Personas> personasExistentes = Personas.consultaBase();
            int personasExistentesSize = personasExistentes.size();
            Criteria query_profe = sesion.createCriteria(Profesores.class);
            List<Profesores> profesores = query_profe.list();
            
            if (personasExistentes.isEmpty()) {
                NuevaPersona = NuevaPersona();
                NuevoProfesor(NuevaPersona);
            } else {
                for (int i = 0; i < personasExistentesSize; i++) {
                    persona = personasExistentes.get(i);
                    if (jTDocumento.getText().equals(persona.getDNI())) {
                        existePersona = true;
                        break;
                    }
                }
                if (existePersona == false) {
                    NuevaPersona = NuevaPersona();
                    NuevoProfesor(NuevaPersona);
                    JOptionPane.showMessageDialog(rootPane, "El profesor " + jTApellido.getText() + " " + jTNombre.getText() + " fue dado de alta correctamente", "ABM Profesores", JOptionPane.INFORMATION_MESSAGE, null);
                } else {
                    //Existe como persona, chequear profesores para no cargar dos vees
//                    if (JOptionPane.showConfirmDialog(this, "El profesor que esta guardando es también un socio. ¿Desea cargarlo también como profesor? ", "Gestión de Profesores",
//                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
                    if (profesores.isEmpty()) {
                        NuevoProfesor(persona);
                        JOptionPane.showMessageDialog(rootPane, "El profesor " + jTApellido.getText() + " " + jTNombre.getText() + " fue dado de alta correctamente", "ABM Profesores", JOptionPane.INFORMATION_MESSAGE, null);
                    } else {
                        int profesoresSize = profesores.size();
                        for (int i = 0; i < profesoresSize; i++) {
                            Profesores profe = profesores.get(i);
                            if (profe.getPersona().getDNI().equals(jTDocumento.getText())) {
                                existeProfe = true;
                                break;
                            }
                        }
                        if (existeProfe == false) {
                            NuevoProfesor(persona);
                            JOptionPane.showMessageDialog(rootPane, "El profesor " + jTApellido.getText() + " " + jTNombre.getText() + " fue dado de alta correctamente", "ABM Profesores", JOptionPane.INFORMATION_MESSAGE, null);
                        } else {
                            JOptionPane.showMessageDialog(this, "El profesor " + jTApellido.getText() + " " + jTNombre.getText() + " ya esta cargado", "Gestion de Profesores", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
            
        } else //Aca estoy guardando cambios
        {
            int decisionUsuario = JOptionPane.showConfirmDialog(rootPane, "¿Desea guardar los cambios realizados?", "ABM Profesores", JOptionPane.YES_NO_OPTION);
            if (decisionUsuario == 1) {
                JOptionPane.showMessageDialog(rootPane, "No se guardaron los cambios realizados");
                rootPane.removeAll();
                inicioFormulario();
            } else if (decisionUsuario == 0) {
                Session sesion = HibernateUtil.getSessionFactory().openSession();
                List<Profesores> consultaBase = Profesores.consultaBase();
                for (int i = 0; i < consultaBase.size(); i++) {
                    Profesores profesor = consultaBase.get(i);
                    if (profesor.getPersona().getDNI().equals(labelDNI.getText())) {
                        Personas persona = profesor.getPersona();
                        persona.setDNI(jTDocumento.getText());
                        persona.setApellido(jTApellido.getText().toUpperCase());
                        persona.setNombre(jTNombre.getText().toUpperCase());
                        persona.setTelefono(jTTelefono.getText());
                        persona.setCelular(jTCelular.getText());
                        persona.setCorreo(jTMail.getText());
                        persona.setFechaNacimiento(jDCNacimiento.getDate());
                        
                        List<Object> listaEstadoCivil = EstadoCivil.consultaBase();
                        for (int j = 0; j < listaEstadoCivil.size(); j++) {
                            EstadoCivil estadoCivil = (EstadoCivil) listaEstadoCivil.get(j);
                            if (estadoCivil.getIdEstado() == jCEstadoCivil.getSelectedIndex() + 1) {
                                persona.setEstadoCivil(estadoCivil);
                            }
                        }
                        if (jRBFemenino.isSelected()) {
                            persona.setSexo(2);
                        } else {
                            persona.setSexo(1);
                        }
                        persona.setHijos((Integer) jSHijos.getValue());
                        persona.setFoto("Foto");
                        
                        Domicilios domicilio = profesor.getPersona().getDomicilios().get(0);
                        domicilio.setCalle(jTCalle.getText());
                        domicilio.setNro(jTNro.getText());
                        domicilio.setPiso(Piso);
                        domicilio.setDpto(jTDpto.getText());
                        domicilio.setBarrio(jTBarrio.getText());
                        domicilio.setCodigoPostal("5000"); //TODO Revisar
                        List<Object> listaLocalidades = Localidades.consultaBase();
                        int listaLocalidadesSize = listaLocalidades.size();
                        for (int j = 0; j < listaLocalidadesSize; j++) {
                            Localidades localidad = (Localidades) listaLocalidades.get(j);
                            if (localidad.getIdLocalidad() == jCLocalidades.getSelectedIndex() + 1) {
                                domicilio.setLocalidad(localidad);
                            }
                        }
                        profesor.setFechaAlta(jDCAlta.getDate());
                        Criteria cr_Estado = sesion.createCriteria(Estados.class);
                        List<Estados> listaEstados = cr_Estado.list();
                        int listaEstadosSize = listaEstados.size();
                        for (int h = 0; h < listaEstadosSize; h++) {
                            estado = listaEstados.get(h);
                            if (estado.getIdEstado() == jCEstado.getSelectedIndex() + 1) {
                                profesor.setEstado(estado);
                            }
                        }
                        sesion.beginTransaction();
                        sesion.update(domicilio);
                        persona.addDomicilio(domicilio);
                        sesion.update(persona);
                        profesor.setPersona(persona);
                        sesion.update(profesor);
                        sesion.getTransaction().commit();
                        sesion.close();
                        JOptionPane.showMessageDialog(rootPane, "Se guardaron con éxito los cambios realizados");
                        this.getContentPane().removeAll();
                        inicioFormulario();
                    }
                    
                }
            }
        }
        

    }//GEN-LAST:event_jBGuardaProfesorActionPerformed
    
    private Personas NuevaPersona() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        
        Personas persona = new Personas();
        Localidades localidad = new Localidades();
        Domicilios domicilio = new Domicilios();
        
        int Sexo = 0;
        switch (OpcionSexo) {
            case 1:
                Sexo = 1;
                break;
            case 2:
                Sexo = 2;
                break;
            default:
                JOptionPane.showMessageDialog(rootPane, "Debe seleccionar el sexo", "Carga de profesores", JOptionPane.INFORMATION_MESSAGE, null);
                break;
            
        }
        persona.setDNI(jTDocumento.getText());
        persona.setApellido(jTApellido.getText());
        persona.setNombre(jTNombre.getText());
        persona.setFechaNacimiento(jDCNacimiento.getDate());
        persona.setSexo(Sexo);
        persona.setTelefono(jTTelefono.getText());
        persona.setCelular(jTCelular.getText());
        persona.setCorreo(jTMail.getText());
        persona.setHijos(Integer.parseInt(jSHijos.getValue().toString()));
        persona.setFoto("No seteado");
        
        List<Object> listaEstadoCivil = EstadoCivil.consultaBase();
        int listaEstadoCivilSize = listaEstadoCivil.size();
        for (int i = 0; i < listaEstadoCivilSize; i++) {
            EstadoCivil estadoCivil = (EstadoCivil) listaEstadoCivil.get(i);
            if (estadoCivil.getIdEstado() == jCEstadoCivil.getSelectedIndex() + 1) {
                persona.setEstadoCivil(estadoCivil);
            }
        }
        
        String calle = jTCalle.getText();
        String nro = jTNro.getText();
        String piso = jTPiso.getText();
        String dpto = jTDpto.getText();
        String barrio = jTBarrio.getText();
        String codigoPostal = "No seteado";
        domicilio.setCalle(calle);
        domicilio.setNro(nro);
        domicilio.setDpto(dpto);
        domicilio.setPiso(piso);
        domicilio.setBarrio(barrio);
        
        Criteria cr_Localidades = sesion.createCriteria(Localidades.class
        );
        List<Localidades> listaLocalidades = cr_Localidades.list();
        int listaLocalidadesSize = listaLocalidades.size();
        for (int i = 0; i < listaLocalidadesSize; i++) {
            localidad = listaLocalidades.get(i);
            if (localidad.getIdLocalidad() == jCLocalidades.getSelectedIndex() + 1) {
                domicilio.setLocalidad(localidad);
            }
        }
        domicilio.setLocalidad(localidad);
        domicilio.setCodigoPostal(codigoPostal);
        persona.addDomicilio(domicilio);
        
        sesion.save(persona);
        sesion.save(domicilio);
        sesion.getTransaction().commit();
        sesion.close();
        
        return persona;
    }
    
    private void NuevoProfesor(Personas persona) {
        
        Profesores profesor = new Profesores();
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        Criteria crPersonas = sesion.createCriteria(Personas.class
        );
        Criteria crEstados = sesion.createCriteria(Estados.class
        );
        
        List<Estados> listaEstados = crEstados.list();
        int listaEstadosSize = listaEstados.size();
        for (int i = 0; i < listaEstadosSize; i++) {
            Estados estado = listaEstados.get(i);
            if (jCEstado.getSelectedIndex() + 1 == estado.getIdEstado()) {
                profesor.setEstado(estado);
            }
        }
//        List<Personas> listaPersonas = crPersonas.list();
//        int listaPersonasSize = listaPersonas.size();
//        for (int j = 0; j < listaPersonasSize; j++) {
//            Personas personas = listaPersonas.get(j);
//            if (jTDocumento.getText().equals(personas.getDNI())) {
        profesor.setDocumento1(jTDocumento1.getText());
        profesor.setDocumento2(jTDocumento2.getText());
        profesor.setFechaAlta(jDCAlta.getDate());
        profesor.setPersona(persona);
//            }
//        }
        sesion.save(profesor);
        sesion.getTransaction().commit();
        sesion.close();
        
    }
    
    private void ModificarProfesor() {
        
    }
    private void jTApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTApellidoActionPerformed

    }//GEN-LAST:event_jTApellidoActionPerformed

    private void jTDocumentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTDocumentoFocusLost
        
        if ("".equals(jTDocumento.getText())) {
            
        } else {
            
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            List<Personas> consultaBase = Personas.consultaBase();
            int size = consultaBase.size();
            for (int i = 0; i < size; i++) {
                Personas persona = consultaBase.get(i);
                if (persona.getDNI().equals(jTDocumento.getText())) {
                    if (JOptionPane.showConfirmDialog(this, "El documento que ingresó existe en la base de datos de personas. "
                            + "Desea utilizar los datos asociados al mismo?", "Gestión de Profesores", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
                        labelDNI.setText(jTDocumento.getText());
                        jTApellido.setText(persona.getApellido());
                        jTNombre.setText(persona.getNombre());
                        List<Domicilios> listDomicilio = persona.getDomicilios();
                        Domicilios domicilio = listDomicilio.get(0);
                        jTCalle.setText(domicilio.getCalle());
                        jTNro.setText(domicilio.getNro());
                        jTPiso.setText(domicilio.getPiso());
                        jTDpto.setText(domicilio.getDpto());
                        jTBarrio.setText(domicilio.getBarrio());
                        jCLocalidades.setSelectedIndex(domicilio.getLocalidad().getIdLocalidad() - 1);
                        jDCNacimiento.setDate(persona.getFechaNacimiento());
                        jCEstadoCivil.setSelectedIndex(persona.getEstadoCivil().getIdEstado() - 1);
                        if (persona.getSexo() == 1) {
                            jRBMasculino.setSelected(true);
                        } else {
                            jRBFemenino.setSelected(true);
                        }
                        jSHijos.setValue(persona.getHijos());
                        jTTelefono.setText(persona.getTelefono());
                        jTCelular.setText(persona.getCelular());
                        jTMail.setText(persona.getCorreo());
                        List<Profesores> consultaProfesores = Profesores.consultaBase();
                        int consultaProfesoresSize = consultaProfesores.size();
                        for (int j = 0; j < consultaProfesoresSize; j++) {
                            Profesores profesor = consultaProfesores.get(i);
                            if (profesor.getPersona().getDNI().equals(jTDocumento.getText())) {
                                jDCAlta.setDate(profesor.getFechaAlta());
                                jCEstado.setSelectedIndex(profesor.getEstado().getIdEstado() - 1);
                                jTDocumento1.setText(profesor.getDocumento1());
                                jTDocumento2.setText(profesor.getDocumento2());
                            }
                        }
                        if (rootPaneCheckingEnabled) {
                            
                        }
                        
                        jBGuardaProfesor.setText("Guardar Cambios");
                        
                    } else {
                        jTDocumento.setText("");
                        jTDocumento.requestFocus();
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
    private javax.swing.JButton jBCancelaSocio;
    private javax.swing.JButton jBDocumento1;
    private javax.swing.JButton jBDocumento2;
    private javax.swing.JButton jBGuardaProfesor;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jCEmpCelular;
    private javax.swing.JComboBox jCEstado;
    private javax.swing.JComboBox jCEstadoCivil;
    private javax.swing.JComboBox jCLocalidades;
    private com.toedter.calendar.JDateChooser jDCAlta;
    private com.toedter.calendar.JDateChooser jDCNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRBFemenino;
    private javax.swing.JRadioButton jRBMasculino;
    private javax.swing.JSpinner jSHijos;
    private javax.swing.JTextField jTApellido;
    private javax.swing.JTextField jTBarrio;
    private javax.swing.JTextField jTCalle;
    private javax.swing.JTextField jTCelular;
    private javax.swing.JTextField jTDocumento;
    private javax.swing.JTextField jTDocumento1;
    private javax.swing.JTextField jTDocumento2;
    private javax.swing.JTextField jTDpto;
    private javax.swing.JTextField jTMail;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTNro;
    private javax.swing.JTextField jTPiso;
    private javax.swing.JTextField jTTelefono;
    private javax.swing.JLabel labelDNI;
    // End of variables declaration//GEN-END:variables

}
