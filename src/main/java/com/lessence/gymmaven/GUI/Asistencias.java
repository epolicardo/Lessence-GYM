/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lessence.gymmaven.GUI;

import com.lessence.gymmaven.clases.Actividades;
import com.lessence.gymmaven.clases.Actividades_Socios_Turnos;
import com.lessence.gymmaven.clases.HibernateUtil;
import com.lessence.gymmaven.clases.RegistroAsistencias;
import java.awt.Color;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.StatelessSession;

/**
 *
 * @author Emiliano
 */
public class Asistencias extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form Asistencias
     */
    public String Base;
    public String Usuario;
    public String Clave;
    public String Recuento = "";

    private int Lectura;
    private String Etiqueta;

    Thread hilo;

    public Asistencias() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        jcbPasesNegativos.setVisible(false);
        IniciodeVentana();
        this.setTitle("L´Essence - Control de Asistencias");
        Reloj();

//        JOptionPane jpo = new JOptionPane();
//        jpo.setFont(Font.decode("BankGothic Lt BT"));
//        Object[] options = {"CANCELAR", "IMPRIMIR"};
//        jpo.showOptionDialog(null, "Elige imprimir o cancelar", "Aviso",
//                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
//                null, options, options[0]);
    }

    Asistencias(int i) {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        IniciodeVentana();
        this.setTitle("L´Essence - Control de Asistencias");
        jcbPasesNegativos.setVisible(true);

    }

    /**
     *
     */
    public void Reloj() { //Constructor 
        hilo = new Thread(this);
        hilo.start();

    } //fin constructor 

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == hilo) {
            try {
                Hora(jlHora);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    public void Hora(JLabel label) {
        String horaActual = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(Date.from(Instant.now()));
        label.setText(horaActual);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("recursos/Lessence.png"));

        return retValue;
    }

    public void IniciodeVentana() {
        for (int i = 0; i < 9; i++) {
            jPAct1.getComponent(i).setVisible(false);
            jPAct2.getComponent(i).setVisible(false);
            jPAct3.getComponent(i).setVisible(false);
            jLNombre.setText("");
            jTActividades.setText("");
            jLPasesDisponibles.setText("");
            jTDocumento.setText("");
            jLBienvenido.setVisible(false);
            jTDocumento.requestFocus();
            jLabel8.setForeground(Color.black);
            jPanel6.setBackground(Color.lightGray);
        }

        Actividades actividad = null;
        Boolean labelsEnabled = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Criteria consulta = sesion.createCriteria(Actividades.class);
        List<Actividades> listaActividades = consulta.list();
        int listaActividadesSize  = listaActividades.size(); 
        for (int i = 0; i < listaActividadesSize; i++) {
            actividad = listaActividades.get(i);
            Lectura = actividad.getIdActividad();
            Etiqueta = actividad.getActividad();
            switch (Lectura) {
                case 1:
                    jLActividad1.setText(Lectura + " - " + Etiqueta);
                    jLActividad1.setForeground(Color.black);
                    jLActividad1.setBackground(SystemColor.control);
                    jLActividad1.setVisible(true);
                    jLActividad1.setEnabled(labelsEnabled);
                    break;
                case 2:
                    jLActividad2.setText(Lectura + " - " + Etiqueta);
                    jLActividad2.setVisible(true);
                    jLActividad2.setForeground(Color.black);
                    jLActividad2.setBackground(SystemColor.control);
                    jL1.setVisible(true);
                    jLActividad2.setEnabled(labelsEnabled);
                    break;
                case 3:
                    jLActividad3.setText(Lectura + " - " + Etiqueta);
                    jLActividad3.setVisible(true);
                    jLActividad3.setForeground(Color.black);
                    jLActividad3.setBackground(SystemColor.control);
                    jL2.setVisible(true);
                    jLActividad3.setEnabled(labelsEnabled);
                    break;
                case 4:
                    jLActividad4.setText(Lectura + " - " + Etiqueta);
                    jLActividad4.setVisible(true);
                    jLActividad4.setForeground(Color.black);
                    jLActividad4.setBackground(SystemColor.control);
                    jL3.setVisible(true);
                    jLActividad4.setEnabled(labelsEnabled);
                    break;
                case 5:
                    jLActividad5.setText(Lectura + " - " + Etiqueta);
                    jLActividad5.setVisible(true);
                    jLActividad5.setForeground(Color.black);
                    jLActividad5.setBackground(SystemColor.control);
                    jL4.setVisible(true);

                    jLActividad5.setEnabled(labelsEnabled);
                    break;
                case 6:
                    jLActividad6.setText(Lectura + " - " + Etiqueta);
                    jLActividad6.setVisible(true);
                    jLActividad6.setForeground(Color.black);
                    jLActividad6.setBackground(SystemColor.control);
                    jLActividad6.setEnabled(labelsEnabled);

                    break;
                case 7:
                    jLActividad7.setText(Lectura + " - " + Etiqueta);
                    jLActividad7.setVisible(true);
                    jL5.setVisible(true);
                    jLActividad7.setForeground(Color.black);
                    jLActividad7.setBackground(SystemColor.control);
                    jLActividad7.setEnabled(labelsEnabled);
                    break;
                case 8:
                    jLActividad8.setText(Lectura + " - " + Etiqueta);
                    jLActividad8.setVisible(true);
                    jLActividad8.setForeground(Color.black);
                    jLActividad8.setBackground(SystemColor.control);
                    jLActividad8.setEnabled(labelsEnabled);
                    jL6.setVisible(true);
                    break;
                case 9:
                    jLActividad9.setText(Lectura + " - " + Etiqueta);
                    jLActividad9.setVisible(true);
                    jLActividad9.setForeground(Color.black);
                    jLActividad9.setBackground(SystemColor.control);
                    jLActividad9.setEnabled(labelsEnabled);
                    jL7.setVisible(true);
                    break;
                case 10:
                    jLActividad10.setText(Lectura + " - " + Etiqueta);
                    jLActividad10.setVisible(true);
                    jLActividad10.setForeground(Color.black);
                    jLActividad10.setBackground(SystemColor.control);
                    jLActividad10.setEnabled(labelsEnabled);
                    jL8.setVisible(true);
                    break;
                case 11:
                    jLActividad11.setText(Lectura + " - " + Etiqueta);
                    jLActividad11.setVisible(true);
                    jLActividad11.setForeground(Color.black);
                    jLActividad11.setBackground(SystemColor.control);
                    jLActividad11.setEnabled(labelsEnabled);
                    jL9.setVisible(true);
                    break;
                case 12:
                    jLActividad12.setText(Lectura + " - " + Etiqueta);
                    jLActividad12.setVisible(true);
                    jLActividad12.setForeground(Color.black);
                    jLActividad12.setBackground(SystemColor.control);
                    jLActividad12.setEnabled(labelsEnabled);

                    break;
                case 13:
                    jL10.setVisible(true);
                    jLActividad13.setText(Lectura + " - " + Etiqueta);
                    jLActividad13.setVisible(true);
                    jLActividad13.setForeground(Color.black);
                    jLActividad13.setBackground(SystemColor.control);
                    jLActividad13.setEnabled(labelsEnabled);

                    break;
                case 14:
                    jL11.setVisible(true);
                    jLActividad14.setText(Lectura + " - " + Etiqueta);
                    jLActividad14.setVisible(true);
                    jLActividad14.setForeground(Color.black);
                    jLActividad14.setBackground(SystemColor.control);
                    jLActividad14.setEnabled(labelsEnabled);

                    break;
                case 15:
                    jL12.setVisible(true);
                    jLActividad15.setText(Lectura + " - " + Etiqueta);
                    jLActividad15.setVisible(true);
                    jLActividad15.setForeground(Color.black);
                    jLActividad15.setBackground(SystemColor.control);
                    jLActividad15.setEnabled(labelsEnabled);
                    break;

            }

        }

        sesion.close();
        jTDocumento.requestFocus();
    }

//             }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPAct1 = new javax.swing.JPanel();
        jLActividad1 = new javax.swing.JLabel();
        jL1 = new javax.swing.JLabel();
        jLActividad2 = new javax.swing.JLabel();
        jL2 = new javax.swing.JLabel();
        jLActividad3 = new javax.swing.JLabel();
        jL3 = new javax.swing.JLabel();
        jLActividad4 = new javax.swing.JLabel();
        jL4 = new javax.swing.JLabel();
        jLActividad5 = new javax.swing.JLabel();
        jPAct2 = new javax.swing.JPanel();
        jLActividad6 = new javax.swing.JLabel();
        jL5 = new javax.swing.JLabel();
        jLActividad7 = new javax.swing.JLabel();
        jL6 = new javax.swing.JLabel();
        jLActividad8 = new javax.swing.JLabel();
        jL7 = new javax.swing.JLabel();
        jLActividad9 = new javax.swing.JLabel();
        jL8 = new javax.swing.JLabel();
        jLActividad10 = new javax.swing.JLabel();
        jPAct3 = new javax.swing.JPanel();
        jLActividad11 = new javax.swing.JLabel();
        jL9 = new javax.swing.JLabel();
        jLActividad12 = new javax.swing.JLabel();
        jL10 = new javax.swing.JLabel();
        jLActividad13 = new javax.swing.JLabel();
        jL11 = new javax.swing.JLabel();
        jLActividad14 = new javax.swing.JLabel();
        jL12 = new javax.swing.JLabel();
        jLActividad15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLPasesDisponibles = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTActividades = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTDocumento = new javax.swing.JTextField();
        jLBienvenido = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLNombre = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jlHora = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcbPasesNegativos = new javax.swing.JCheckBox();

        jButton1.setText("Administración");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("L'Essence - Control de Asistencias");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(822, 530));
        setPreferredSize(new java.awt.Dimension(1300, 700));

        jPAct1.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jLActividad1.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jLActividad1.setText("1");
        jLActividad1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLActividad1.setOpaque(true);
        jPAct1.add(jLActividad1);

        jL1.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jL1.setText("I");
        jL1.setOpaque(true);
        jPAct1.add(jL1);

        jLActividad2.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jLActividad2.setText("2");
        jLActividad2.setOpaque(true);
        jPAct1.add(jLActividad2);

        jL2.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jL2.setText("I");
        jL2.setOpaque(true);
        jPAct1.add(jL2);

        jLActividad3.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jLActividad3.setText("3");
        jLActividad3.setOpaque(true);
        jPAct1.add(jLActividad3);

        jL3.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jL3.setText("I");
        jL3.setOpaque(true);
        jPAct1.add(jL3);

        jLActividad4.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jLActividad4.setText("4");
        jLActividad4.setOpaque(true);
        jPAct1.add(jLActividad4);

        jL4.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jL4.setText("I");
        jL4.setOpaque(true);
        jPAct1.add(jL4);

        jLActividad5.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jLActividad5.setText("5");
        jLActividad5.setOpaque(true);
        jPAct1.add(jLActividad5);

        jPAct2.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jLActividad6.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jLActividad6.setText("6");
        jLActividad6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLActividad6.setOpaque(true);
        jPAct2.add(jLActividad6);

        jL5.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jL5.setText("I");
        jL5.setOpaque(true);
        jPAct2.add(jL5);

        jLActividad7.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jLActividad7.setText("7");
        jLActividad7.setOpaque(true);
        jPAct2.add(jLActividad7);

        jL6.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jL6.setText("I");
        jL6.setOpaque(true);
        jPAct2.add(jL6);

        jLActividad8.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jLActividad8.setText("8");
        jLActividad8.setOpaque(true);
        jPAct2.add(jLActividad8);

        jL7.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jL7.setText("I");
        jL7.setOpaque(true);
        jPAct2.add(jL7);

        jLActividad9.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jLActividad9.setText("9");
        jLActividad9.setOpaque(true);
        jPAct2.add(jLActividad9);

        jL8.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jL8.setText("I");
        jL8.setOpaque(true);
        jPAct2.add(jL8);

        jLActividad10.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jLActividad10.setText("10");
        jLActividad10.setOpaque(true);
        jPAct2.add(jLActividad10);

        jPAct3.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jLActividad11.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jLActividad11.setText("11");
        jLActividad11.setOpaque(true);
        jPAct3.add(jLActividad11);

        jL9.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jL9.setText("I");
        jL9.setOpaque(true);
        jPAct3.add(jL9);

        jLActividad12.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jLActividad12.setText("12");
        jLActividad12.setOpaque(true);
        jPAct3.add(jLActividad12);

        jL10.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jL10.setText("I");
        jL10.setOpaque(true);
        jPAct3.add(jL10);

        jLActividad13.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jLActividad13.setText("13");
        jLActividad13.setOpaque(true);
        jPAct3.add(jLActividad13);

        jL11.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jL11.setText("I");
        jL11.setOpaque(true);
        jPAct3.add(jL11);

        jLActividad14.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jLActividad14.setText("14");
        jLActividad14.setOpaque(true);
        jPAct3.add(jLActividad14);

        jL12.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jL12.setText("I");
        jL12.setOpaque(true);
        jPAct3.add(jL12);

        jLActividad15.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jLActividad15.setText("15");
        jLActividad15.setOpaque(true);
        jPAct3.add(jLActividad15);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPAct3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPAct2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPAct1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPAct1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPAct2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPAct3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setMinimumSize(new java.awt.Dimension(12, 80));

        jLPasesDisponibles.setFont(new java.awt.Font("BankGothic Lt BT", 0, 36)); // NOI18N
        jPanel4.add(jLPasesDisponibles);

        jLabel4.setFont(new java.awt.Font("BankGothic Lt BT", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Actividades Disponibles");
        jLabel4.setOpaque(true);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel4))
        );

        jLabel8.setFont(new java.awt.Font("BankGothic Lt BT", 0, 24)); // NOI18N
        jLabel8.setText("Que rutina vas a hacer hoy?");

        jTActividades.setFont(new java.awt.Font("BankGothic Lt BT", 0, 24)); // NOI18N
        jTActividades.setForeground(new java.awt.Color(255, 51, 0));
        jTActividades.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTActividades.setToolTipText("");
        jTActividades.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTActividades.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTActividadesKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jTActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTActividades, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        jPanel13.add(jPanel6);

        jLabel2.setFont(new java.awt.Font("BankGothic Lt BT", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Por favor, ingresá tu Número de Documento");

        jTDocumento.setFont(new java.awt.Font("BankGothic Lt BT", 0, 36)); // NOI18N
        jTDocumento.setForeground(new java.awt.Color(255, 0, 0));
        jTDocumento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTDocumento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTDocumento.setMinimumSize(new java.awt.Dimension(600, 50));
        jTDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTDocumentoKeyPressed(evt);
            }
        });

        jLBienvenido.setFont(new java.awt.Font("BankGothic Lt BT", 0, 24)); // NOI18N
        jLBienvenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLBienvenido.setText("Bienvenido");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel10);

        jLNombre.setFont(new java.awt.Font("BankGothic Lt BT", 0, 36)); // NOI18N
        jLNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel8.add(jLNombre);

        jlHora.setBackground(new java.awt.Color(255, 0, 0));
        jlHora.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jlHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlHora.setText("05-09-2016 - 15:25");
        jlHora.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlHora, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTDocumento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLBienvenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLBienvenido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Lessence.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jcbPasesNegativos.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jcbPasesNegativos.setText("Habilita pases negativos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbPasesNegativos)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jcbPasesNegativos))
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jTActividadesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTActividadesKeyPressed
        if (evt.getKeyCode() == 10) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
            if ("".equals(jTDocumento.getText())) {
                JOptionPane.showMessageDialog(this, "Debe ingresar su identificación", "Registro de Asistencias", JOptionPane.ERROR_MESSAGE);
            } else if ("".equals(jTActividades.getText())) {
                JOptionPane.showMessageDialog(this, "Debe ingresar una opción de Actividad", "Registro de Asistencias", JOptionPane.ERROR_MESSAGE);
            } else {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(Date.from(Instant.now())); // Configuramos la fecha que se recibe
                int dias = 10;
                calendar.add(Calendar.DAY_OF_YEAR, dias);
                int Disponibles = 0;
                Criteria consultaRelaciones = sesion.createCriteria(Actividades_Socios_Turnos.class);
                List<Actividades_Socios_Turnos> listaActividades = consultaRelaciones.list();
                RegistroAsistencias asistencia = new RegistroAsistencias();
                sesion.beginTransaction();
                int listaActividadesSize = listaActividades.size(); 
                for (int i = 0; i < listaActividadesSize; i++) {
                    Actividades_Socios_Turnos relacion = listaActividades.get(i);
                    if (relacion.getSocio().getPersona().getDNI().equals(jTDocumento.getText())) {
                        if (relacion.getRelacion().getActividad().getIdActividad() == Integer.parseInt(jTActividades.getText())) {
                            if (relacion.getSocio().getEstado().getIdEstado() == 1) {
                                if (relacion.getPaseLibre() == 1) {
                                    //No descuenta pases
                                    asistencia.setFecha(Date.from(Instant.now()));
                                    asistencia.setSocio(relacion.getSocio());
                                    asistencia.setRelacion(relacion.getRelacion());
                                    sesion.save(asistencia);
                                    sesion.getTransaction().commit();

                                    if (relacion.getSocio().getPrimerVencimiento().before(calendar.getTime())) {
                                        new Form_AvisoVencimientos(this, rootPaneCheckingEnabled, relacion.getSocio().getPrimerVencimiento()).setVisible(rootPaneCheckingEnabled);
                                    }
                                      new Form_AvisoAccesoCorrecto(this, rootPaneCheckingEnabled).setVisible(rootPaneCheckingEnabled);
                                    jLNombre.setText("");
                                    jTActividades.setText("");
                                    jLPasesDisponibles.setText("");
                                    jTDocumento.setText("");
                                    jTDocumento.requestFocus();
                                    Recuento = "";
                                    IniciodeVentana();
                                } else if (jcbPasesNegativos.isSelected()) {
                                    asistencia.setFecha(Date.from(Instant.now()));
                                    asistencia.setSocio(relacion.getSocio());
                                    asistencia.setRelacion(relacion.getRelacion());
                                    relacion.setPases(relacion.getPases() - 1);
                                    jLPasesDisponibles.setText("Te quedan " + relacion.getPases() + " pases disponibles");
                                    sesion.save(asistencia);
                                    sesion.save(relacion);
                                    sesion.getTransaction().commit();
                                    jLNombre.setText("");
                                    jTActividades.setText("");
                                    jLPasesDisponibles.setText("");
                                    jTDocumento.setText("");
                                    jTDocumento.requestFocus();
                                    Recuento = "";
                                    IniciodeVentana();
                                } else if (relacion.getPases() >= 1) {
                                    asistencia.setFecha(Date.from(Instant.now()));
                                    asistencia.setSocio(relacion.getSocio());
                                    asistencia.setRelacion(relacion.getRelacion());
                                    relacion.setPases(relacion.getPases() - 1);
                                    jLPasesDisponibles.setText("Te quedan " + relacion.getPases() + " pases disponibles");
                                    sesion.save(asistencia);
                                    sesion.save(relacion);
                                    sesion.getTransaction().commit();

                                    if (relacion.getSocio().getPrimerVencimiento().before(calendar.getTime())) {
                                        new Form_AvisoVencimientos(this, rootPaneCheckingEnabled, relacion.getSocio().getPrimerVencimiento()).setVisible(rootPaneCheckingEnabled);
                                    }
                                    JOptionPane.showMessageDialog(this, "Se cargo correctamente el accceso.", "Control de Asistencias - L´Essence", JOptionPane.INFORMATION_MESSAGE);
                                    jLNombre.setText("");
                                    jTActividades.setText("");
                                    jLPasesDisponibles.setText("");
                                    jTDocumento.setText("");
                                    jTDocumento.requestFocus();
                                    Recuento = "";
                                    IniciodeVentana();
                                } else {
                                    JOptionPane.showMessageDialog(this, "No quedan pases disponibles para la actividad.", "Control de Asistencias - L´Essence", JOptionPane.INFORMATION_MESSAGE);
                                    jTActividades.setText("");
                                    jTDocumento.setText("");
                                    jTDocumento.requestFocus();
                                    IniciodeVentana();
                                }
                            } else {
                                new Form_AvisoInactivos(this, rootPaneCheckingEnabled).setVisible(rootPaneCheckingEnabled);
                                jTActividades.setText("");
                                jTDocumento.setText("");
                                jTDocumento.requestFocus();
                                IniciodeVentana();

                            }
                        }
                    }
                }

            }
        sesion.close();
        IniciodeVentana();
        }

    }//GEN-LAST:event_jTActividadesKeyPressed

    private void jTDocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDocumentoKeyPressed
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Criteria consulta = sesion.createCriteria(Actividades_Socios_Turnos.class);
        List<Actividades_Socios_Turnos> listaRelaciones = consulta.list();
        if (106 == evt.getKeyCode()) {
            new Form_Asitencias_Profesores(this, rootPaneCheckingEnabled).setVisible(true);
            jTDocumento.setText("");
        } else {
            int Actividad = 0;
            boolean existeSocio = false;
            if (10 == evt.getKeyCode()) {//Enter
                if ("".equals(jTDocumento.getText())) {
                    JOptionPane.showMessageDialog(this, "Debe ingresar su identificación", "Registro de Asistencias", JOptionPane.ERROR_MESSAGE);
                } else {
                    int listaRelacionesSize = listaRelaciones.size();
                    for (int i = 0; i < listaRelacionesSize; i++) {
                        Actividades_Socios_Turnos relaciones = listaRelaciones.get(i);
                        if (relaciones.getSocio().getPersona().getDNI().equals(jTDocumento.getText())) {
                            existeSocio = true;
                            jLBienvenido.setVisible(true);
                            jLNombre.setText(relaciones.getSocio().getPersona().getNombre());
                            Actividad = relaciones.getRelacion().getActividad().getIdActividad();

                            switch (Actividad) {
                                case 1:
                                    jLActividad1.setEnabled(true);
                                    jLActividad1.setForeground(Color.black);
                                    jLActividad1.setBackground(Color.red);
                                    break;
                                case 2:
                                    jLActividad2.setEnabled(true);
                                    jLActividad2.setForeground(Color.black);
                                    jLActividad2.setBackground(Color.red);
                                    break;
                                case 3:
                                    jLActividad3.setEnabled(true);
                                    jLActividad3.setForeground(Color.black);
                                    jLActividad3.setBackground(Color.red);
                                    break;
                                case 4:
                                    jLActividad4.setEnabled(true);
                                    jLActividad4.setForeground(Color.black);
                                    jLActividad4.setBackground(Color.red);
                                    break;
                                case 5:
                                    jLActividad5.setEnabled(true);
                                    jLActividad5.setForeground(Color.black);
                                    jLActividad5.setBackground(Color.red);
                                    break;
                                case 6:
                                    jLActividad6.setEnabled(true);
                                    jLActividad6.setForeground(Color.black);
                                    jLActividad6.setBackground(Color.red);
                                    break;
                                case 7:
                                    jLActividad7.setEnabled(true);
                                    jLActividad7.setForeground(Color.black);
                                    jLActividad7.setBackground(Color.red);
                                    break;
                                case 8:
                                    jLActividad8.setEnabled(true);
                                    jLActividad8.setForeground(Color.black);
                                    jLActividad8.setBackground(Color.red);
                                    break;
                                case 9:
                                    jLActividad9.setEnabled(true);
                                    jLActividad9.setForeground(Color.black);
                                    jLActividad9.setBackground(Color.red);
                                    break;
                                case 10:
                                    jLActividad10.setEnabled(true);
                                    jLActividad10.setForeground(Color.black);
                                    jLActividad10.setBackground(Color.red);

                                    break;
                                case 11:
                                    jLActividad11.setEnabled(true);
                                    jLActividad11.setForeground(Color.black);
                                    jLActividad11.setBackground(Color.red);
                                    break;
                                case 12:
                                    jLActividad12.setEnabled(true);
                                    jLActividad12.setForeground(Color.black);
                                    jLActividad12.setBackground(Color.red);
                                    break;
                                case 13:
                                    jLActividad13.setEnabled(true);
                                    jLActividad13.setForeground(Color.black);
                                    jLActividad13.setBackground(Color.red);
                                    break;
                                case 14:
                                    jLActividad14.setEnabled(true);
                                    jLActividad14.setForeground(Color.black);
                                    jLActividad14.setBackground(Color.red);
                                    break;
                                case 15:
                                    jLActividad15.setEnabled(true);
                                    jLActividad15.setForeground(Color.black);
                                    jLActividad15.setBackground(Color.red);
                                    break;
                            }
                        }

                    }
                    if (existeSocio == false) {

                        JOptionPane.showMessageDialog(this, "El documento ingresado no coincide con un socio con actividades asignadas.\nVerifique los datos.",
                                "Gestión de Asistencias", JOptionPane.ERROR_MESSAGE);
                        jTDocumento.setText("");
                        jTDocumento.requestFocus();
                    } else {
                        jPanel6.setBackground(Color.red);
                        jLabel8.setForeground(SystemColor.control);
                        jTActividades.requestFocus();
                    }
                }
                sesion.close();
            }
        }
    }//GEN-LAST:event_jTDocumentoKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new Inicial().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jL1;
    private javax.swing.JLabel jL10;
    private javax.swing.JLabel jL11;
    private javax.swing.JLabel jL12;
    private javax.swing.JLabel jL2;
    private javax.swing.JLabel jL3;
    private javax.swing.JLabel jL4;
    private javax.swing.JLabel jL5;
    private javax.swing.JLabel jL6;
    private javax.swing.JLabel jL7;
    private javax.swing.JLabel jL8;
    private javax.swing.JLabel jL9;
    private javax.swing.JLabel jLActividad1;
    private javax.swing.JLabel jLActividad10;
    private javax.swing.JLabel jLActividad11;
    private javax.swing.JLabel jLActividad12;
    private javax.swing.JLabel jLActividad13;
    private javax.swing.JLabel jLActividad14;
    private javax.swing.JLabel jLActividad15;
    private javax.swing.JLabel jLActividad2;
    private javax.swing.JLabel jLActividad3;
    private javax.swing.JLabel jLActividad4;
    private javax.swing.JLabel jLActividad5;
    private javax.swing.JLabel jLActividad6;
    private javax.swing.JLabel jLActividad7;
    private javax.swing.JLabel jLActividad8;
    private javax.swing.JLabel jLActividad9;
    private javax.swing.JLabel jLBienvenido;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLPasesDisponibles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPAct1;
    private javax.swing.JPanel jPAct2;
    private javax.swing.JPanel jPAct3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField jTActividades;
    private javax.swing.JTextField jTDocumento;
    private javax.swing.JCheckBox jcbPasesNegativos;
    private javax.swing.JLabel jlHora;
    // End of variables declaration//GEN-END:variables
}
