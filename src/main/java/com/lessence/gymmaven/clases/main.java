package com.lessence.gymmaven.clases;

import com.lessence.gymmaven.GUI.Accesos;
import com.lessence.gymmaven.GUI.Inicial;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Emiliano Policardo
 * 
 * Se esta utilizando MariaDB 10.0.38 en puerto 3308.
 * No compatible con MySQL 10 y el conector utilizado.
 * Precaucion al actualizar el archivo pom.xml
 */
public abstract class main implements Runnable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ParametrosSistema.Host();
        ParametrosSistema.LeerParametros();
        if (ParametrosSistema.getEquipoDB().equals(ParametrosSistema.hostname)) {
            new Inicial().setVisible(true);
        } else {
            new Accesos().setVisible(true);

        }
    }

    private Thread hilo;

    /**
     *
     */
    public void Reloj() { //Constructor 
        hilo = new Thread(this);
        hilo.start();

    } //fin constructor 

    public void run(JLabel label) {
        Thread ct = Thread.currentThread();
        while (ct == hilo) {
            try {
                Hora(label);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    public void Hora(JLabel label) {
        String horaActual = new SimpleDateFormat("dd/MM/yyyy - HH:mm").format(Date.from(Instant.now()));
        label.setText(horaActual);
    }

}
