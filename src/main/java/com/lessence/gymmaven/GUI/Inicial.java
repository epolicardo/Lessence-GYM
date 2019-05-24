/*
 * Inicial.java
 *
 * Created on 9 de junio de 2015, 12:11
 */
package com.lessence.gymmaven.GUI;

import com.lessence.gymmaven.clases.HibernateUtil;
import com.lessence.gymmaven.clases.ParametrosSistema;
import com.lessence.gymmaven.clases.RegistroAsistencias;
import com.lessence.gymmaven.clases.Socios;
import com.lessence.gymmaven.clases.claseFunciones;
import com.lessence.gymmaven.clases.seteosGUI;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;


/*
 *
 * @author  Emiliano
 */
public class Inicial extends javax.swing.JFrame implements Runnable {

    Thread reloj, sistema;

    /**
     * Creates new form Inicial
     */
    public Inicial() {

        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);

    }

    public void Reloj() { //Constructor 
        reloj = new Thread(this);
        sistema = new Thread(this);
        reloj.start();
        sistema.start();

    } //fin constructor 

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == reloj) {
            try {
                //Hora(jLabel4);//Pasamos aca el jlabel que queremos usar como reloj
                Thread.sleep(1000); //Tiempo de demora
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
//            while (ct == sistema) {
//                try {
//                    Thread.sleep(15000);
//                    //Socios.VerificaEstadosySituaciones();
//                    ActualizarDatosdeInicio();
//                } catch (InterruptedException ex) {
//                    System.out.println(ex.getMessage());
//                }
//            }
        }
    }

    public void Hora(JLabel label) {
        String horaActual = seteosGUI.fechaHoraconSegundos(Date.from(Instant.now()));
        label.setText(horaActual);
    }

    private void ActualizarGrillaIngresos() {
        Socios.VerificaEstadosySituaciones();
        DefaultTableModel modelo = (DefaultTableModel) jtUltimasAsistencias.getModel();
        modelo.setRowCount(0);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Date.from(Instant.now()));
        Date ahora = calendar.getTime();
        calendar.add(Calendar.HOUR_OF_DAY, -ParametrosSistema.horasAsistencias);
        Date dosHoras = calendar.getTime();

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Criteria query_socios_activos = sesion.createCriteria(RegistroAsistencias.class);
        query_socios_activos.addOrder(Order.desc("fecha"));
        List<RegistroAsistencias> asistencias = query_socios_activos.list();
        int asistenciasSize = asistencias.size();
        for (int i = 0; i < asistenciasSize; i++) {
            RegistroAsistencias asistencia = asistencias.get(i);
            if (asistencia.getFecha().before(ahora) & asistencia.getFecha().after(dosHoras)) {
                Object[] fila = {asistencia.getSocio().getPersona().getNombre() + " " + asistencia.getSocio().getPersona().getApellido(), seteosGUI.fechaHora(asistencia.getFecha())};
                modelo.addRow(fila);
            }
        }
        sesion.close();
    }

    public class MyCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            boolean valid = String.valueOf(table.getValueAt(row, 2)).equals("Activo");
            component.setForeground(valid ? Color.black : Color.red);
            component.setFont((new java.awt.Font("BankGothic Lt BT", 0, 14)));
            return component;
        }
    }

    private void ActualizarDatosdeInicio() {
//        Reloj();
        Socios.VerificaEstadosySituaciones();
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Query query_socios_activos = sesion.createQuery("From Socios where estado=1 and situacion=1");
        List<Socios> lista_socios_activos = query_socios_activos.list();
        Query query_socios = sesion.createQuery("From Socios where situacion=1");
        List<Socios> lista_socios = query_socios.list();
        int lista_sociosSize = lista_socios.size();
        jPBSociosActivos.setMaximum(lista_sociosSize);
        jPBSociosActivos.setValue(lista_socios_activos.size());
        jPBSociosActivos.setString(String.valueOf(lista_socios.size()) + " Socios Vigentes / " + lista_socios_activos.size() + " Socios Activos");
        DefaultTableModel tabla_vencimientos = (DefaultTableModel) jT_Vencimientos.getModel();
        jT_Vencimientos.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14));
        jtUltimasAsistencias.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14));
        jT_Vencimientos.setDefaultRenderer(Object.class, new MyCellRenderer());
        tabla_vencimientos.setRowCount(0);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Date.from(Instant.now())); // Asignamos el calendario la fecha actual 
        Date ahora = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, +10); //Agrego diez dias a la fecha de hoy
        Date endiez = calendar.getTime();
        for (int i = 0; i < lista_sociosSize; i++) {
            Socios socio = lista_socios.get(i);
            if (socio.getPrimerVencimiento().before(endiez)) {
                Object[] fila = {socio.getPersona().getApellido() + ", " + socio.getPersona().getNombre(), seteosGUI.fechaCorta(socio.getPrimerVencimiento()), socio.getEstado().getEstado()};
                tabla_vencimientos.addRow(fila);
            }

        }
        sesion.close();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("recursos/Lessence.png"));

        return retValue;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etchedBorder1 = (javax.swing.border.EtchedBorder)javax.swing.BorderFactory.createEtchedBorder();
        jLabel5 = new javax.swing.JLabel();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem33 = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jT_Vencimientos = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPBSociosActivos = new javax.swing.JProgressBar();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtUltimasAsistencias = new javax.swing.JTable();
        jbVender = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmABMProductos = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jmABMMarcas = new javax.swing.JMenuItem();
        jMenuItem36 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMResumenCaja = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenuItem31 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        jLabel5.setText("jLabel5");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem32.setText("jMenuItem32");

        jMenuItem24.setText("jMenuItem24");

        jMenuItem25.setText("jMenuItem25");

        jMenuItem33.setText("jMenuItem33");

        jMenuItem35.setText("jMenuItem35");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("L´essence - Centro de Acondicionamiento Físico");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());
        setMinimumSize(null);
        setName("Inicial"); // NOI18N
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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jDesktopPane1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jDesktopPane1.setForeground(new java.awt.Color(255, 255, 255));
        jDesktopPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jDesktopPane1FocusGained(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("BankGothic Lt BT", 1, 18)); // NOI18N
        jLabel1.setText("Próximos Vencimientos");

        jScrollPane1.setToolTipText("");
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jT_Vencimientos.setAutoCreateRowSorter(true);
        jT_Vencimientos.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jT_Vencimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Socio", "Vencimiento", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jT_Vencimientos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jT_Vencimientos);
        if (jT_Vencimientos.getColumnModel().getColumnCount() > 0) {
            jT_Vencimientos.getColumnModel().getColumn(0).setPreferredWidth(120);
            jT_Vencimientos.getColumnModel().getColumn(2).setPreferredWidth(40);
        }

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setFont(new java.awt.Font("BankGothic Lt BT", 1, 14)); // NOI18N
        jButton3.setText("Volver a la ventana de Accesos");
        jButton3.setOpaque(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPBSociosActivos.setBackground(new java.awt.Color(255, 0, 51));
        jPBSociosActivos.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jPBSociosActivos.setForeground(new java.awt.Color(255, 0, 51));
        jPBSociosActivos.setToolTipText("");
        jPBSociosActivos.setBorderPainted(false);
        jPBSociosActivos.setFocusable(false);
        jPBSociosActivos.setString("");
        jPBSociosActivos.setStringPainted(true);

        jButton1.setFont(new java.awt.Font("BankGothic Lt BT", 1, 14)); // NOI18N
        jButton1.setText("Habilitar Pases en Negativo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Fondo Lessence - copia.png"))); // NOI18N

        jtUltimasAsistencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Socio", "Acceso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jtUltimasAsistencias);

        jbVender.setFont(new java.awt.Font("BankGothic Lt BT", 1, 24)); // NOI18N
        jbVender.setText("Vender");
        jbVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVenderActionPerformed(evt);
            }
        });

        jButton2.setText("Actualizar Listado de Vencimientos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Actualizar Listado de Accesos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPBSociosActivos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbVender, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPBSociosActivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbVender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbVender, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jButton4))
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPBSociosActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jDesktopPane1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton3});

        getContentPane().add(jDesktopPane1, java.awt.BorderLayout.CENTER);

        jMenuBar1.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jMenu1.setText("Archivo");
        jMenu1.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jMenuItem5.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jMenuItem5.setText("Salir");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem9.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jMenuItem9.setText("Ventana de Accesos");
        jMenu1.add(jMenuItem9);

        jMenuBar1.add(jMenu1);

        jMenu10.setText("Gestión de Socios");
        jMenu10.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jMenuItem11.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jMenuItem11.setText("ABM Socios");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem11);

        jMenuItem12.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jMenuItem12.setText("Consulta de Socios");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem12);

        jMenuItem13.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jMenuItem13.setText("Cobro de Cuotas");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem13);

        jMenuItem14.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jMenuItem14.setText("Asignación de Actividades");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem14);

        jMenuItem15.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jMenuItem15.setText("Gestión de Pases");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem15);

        jMenuItem8.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jMenuItem8.setText("Consulta de Asignaciones");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem8);

        jMenuItem16.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jMenuItem16.setText("Informes");
        jMenu10.add(jMenuItem16);

        jMenuBar1.add(jMenu10);

        jMenu9.setText("Gestión de Profesores");
        jMenu9.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jMenuItem17.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jMenuItem17.setText("ABM Profesores");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem17);

        jMenuItem18.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jMenuItem18.setText("Consulta de Profesores");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem18);

        jMenuItem19.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jMenuItem19.setText("Asignar Actividades a Profesores");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem19);

        jMenuBar1.add(jMenu9);

        jMenu2.setText("Gestión de Ventas");
        jMenu2.setEnabled(false);
        jMenu2.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jmABMProductos.setText("ABM Productos");
        jmABMProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmABMProductosActionPerformed(evt);
            }
        });
        jMenu2.add(jmABMProductos);

        jMenuItem21.setText("ABM Proveedores");
        jMenu2.add(jMenuItem21);

        jMenuItem20.setText("ABM Familias");
        jMenu2.add(jMenuItem20);

        jmABMMarcas.setText("ABM Marcas");
        jmABMMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmABMMarcasActionPerformed(evt);
            }
        });
        jMenu2.add(jmABMMarcas);

        jMenuItem36.setText("Unidades de Medida");
        jMenu2.add(jMenuItem36);

        jMenuBar1.add(jMenu2);

        jMenu8.setText("Gestión Financiera");
        jMenu8.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jMenuItem22.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jMenuItem22.setText("Caja diaria");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem22);

        jMenuItem23.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jMenuItem23.setText("Ingresos, Retiros y Gastos");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem23);

        jMResumenCaja.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jMResumenCaja.setText("Resumen de Movimientos");
        jMResumenCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMResumenCajaActionPerformed(evt);
            }
        });
        jMenu8.add(jMResumenCaja);

        jMenuBar1.add(jMenu8);

        jMenu7.setText("Gestión de Actividades");
        jMenu7.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jMenuItem26.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jMenuItem26.setText("ABM Actividades");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem26);

        jMenuItem27.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jMenuItem27.setText("ABM Horarios");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem27);

        jMenuItem28.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jMenuItem28.setText("Asociar Actividades con Profesores");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem28);

        jMenuBar1.add(jMenu7);

        jMenu6.setText("Gestión del Sistema");
        jMenu6.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N

        jMenuItem4.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jMenuItem4.setText("Inicializar Sistema");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem4);

        jMenuItem10.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jMenuItem10.setText("Configuraciones");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem10);

        jMenuItem6.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jMenuItem6.setText("BackUp de Datos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem6);

        jMenuItem7.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jMenuItem7.setText("Restaurar Base");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem7);

        jMenuItem30.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jMenuItem30.setText("ABM Localidades");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem30);

        jMenuItem29.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jMenuItem29.setText("ABM Tarjetas");
        jMenu6.add(jMenuItem29);

        jMenuItem31.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        jMenuItem31.setText("ABM Bancos");
        jMenu6.add(jMenuItem31);

        jMenuItem1.setText("Información del Sistema");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem1);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
//        try {
//            Thread.sleep(5000);
//        ActualizarDatosdeInicio();
//        ActualizarGrillaIngresos();
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Inicial.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_formFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
//        ActualizarDatosdeInicio();
    }//GEN-LAST:event_formWindowGainedFocus


    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Query consulta_parametros = sesion.createQuery("From ParametrosSistema");
        List<ParametrosSistema> param = consulta_parametros.list();
        sesion.beginTransaction();
        int paramSize = param.size();
        for (int i = 0; i < paramSize; i++) {
            ParametrosSistema parametro = param.get(i);
            if (parametro.getParametro().equals("cantidadMovimientos")) {
                parametro.setValor(ParametrosSistema.cantidadMovimientos);
                sesion.save(parametro);
                sesion.getTransaction().commit();

            }
        }
        sesion.close();
    }//GEN-LAST:event_formWindowClosing

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new Accesos().setVisible(rootPaneCheckingEnabled);
        this.dispose();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        int showConfirmDialog = JOptionPane.showConfirmDialog(this, "Esta acción setea datos por defecto de la base de datos. Desea continuar?");
        if (showConfirmDialog==0) {
            System.out.println("Inicializando base de datos...");
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        System.exit(0);
//        HibernateUtil.shutdown();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
        Form_Relaciona_Actividades_Turnos_Profesores relacionProfesores = new Form_Relaciona_Actividades_Turnos_Profesores(this, false);
        relacionProfesores.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
        Form_ABM_Horarios horarios = new Form_ABM_Horarios(this, false);
        horarios.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        Form_ABMActividades actividades = new Form_ABMActividades(this, false);
        actividades.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        Form_ABMSocios abmSocios = new Form_ABMSocios();
        abmSocios.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        Form_Consulta_Socios consultaSocios = new Form_Consulta_Socios();
        consultaSocios.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        GestionMovimientosdeCuentas cuentas = new GestionMovimientosdeCuentas("");
        cuentas.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        Form_Relaciona_Actividades_Socios actividadesSocios = new Form_Relaciona_Actividades_Socios("");
        actividadesSocios.setVisible(rootPaneCheckingEnabled);

    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        Form_Consulta_Profesores consultaProfesores = new Form_Consulta_Profesores();
        consultaProfesores.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        Form_ABMProfesores abmProfesores = new Form_ABMProfesores();
        abmProfesores.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        Form_Relaciona_Actividades_Turnos_Profesores relacionProfesorActividad = new Form_Relaciona_Actividades_Turnos_Profesores(this, rootPaneCheckingEnabled);
        relacionProfesorActividad.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        Form_Gestion_Caja_Diaria cajaDiaria = new Form_Gestion_Caja_Diaria();
        cajaDiaria.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        Form_Gastos_Visual gastos = new Form_Gastos_Visual();
        gastos.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    public static void MostrarRechazados(String nombreSocio, String actividad) {

    }


    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        claseFunciones.backup();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Asistencias(0).setVisible(rootPaneCheckingEnabled);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        new Form_ABM_Localidades(this, rootPaneCheckingEnabled).setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        Form_Consultainscriptos consultaInscriptos = new Form_Consultainscriptos(this, rootPaneCheckingEnabled);
        consultaInscriptos.setVisible(rootPaneCheckingEnabled);

    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        claseFunciones.restore();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        new parametrosSistema().setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jmABMProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmABMProductosActionPerformed
        Form_Articulos_Avanzado art = new Form_Articulos_Avanzado(this, rootPaneCheckingEnabled);
        art.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jmABMProductosActionPerformed

    private void jbVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVenderActionPerformed
        Form_TecladoVenta pv = new Form_TecladoVenta(this, rootPaneCheckingEnabled);
        pv.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jbVenderActionPerformed

    private void jmABMMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmABMMarcasActionPerformed
        Form_ABMMarcas marca = new Form_ABMMarcas(this, rootPaneCheckingEnabled);
        marca.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jmABMMarcasActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        Form_Gestion_Pases gestionarPases = new Form_Gestion_Pases();
        gestionarPases.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ActualizarGrillaIngresos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ActualizarDatosdeInicio();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jDesktopPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDesktopPane1FocusGained
       
     }//GEN-LAST:event_jDesktopPane1FocusGained


    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       Form_InfoSistema info = new Form_InfoSistema(this, rootPaneCheckingEnabled);
       info.setVisible(rootPaneCheckingEnabled);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMResumenCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMResumenCajaActionPerformed
        Form_Informes_Caja resumen = new Form_Informes_Caja();
        resumen.setVisible(true);
        
        
    }//GEN-LAST:event_jMResumenCajaActionPerformed


    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.border.EtchedBorder etchedBorder1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMResumenCaja;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JProgressBar jPBSociosActivos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jT_Vencimientos;
    private javax.swing.JButton jbVender;
    private javax.swing.JMenuItem jmABMMarcas;
    private javax.swing.JMenuItem jmABMProductos;
    private javax.swing.JTable jtUltimasAsistencias;
    // End of variables declaration//GEN-END:variables

}
