/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lessence.gymmaven.clases;

import java.awt.Desktop;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSize;

/**
 *
 * @author Administrador
 */
public class ServicioDeImpresion {

    private static boolean existeImpresora = false;

    public static void imprimirCocina(String textoAImprimir) {
        agregarLogoATicket(textoAImprimir);
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null); //nos da el array de los servicios de impresion

        byte[] bytes = textoAImprimir.getBytes();

//Especificamos el tipo de dato a imprimir
//Tipo: bytes; Subtipo: autodetectado
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;

        Doc doc = new SimpleDoc(bytes, flavor, null);
//Creamos un trabajo de impresión
        DocPrintJob job = null;
        if (services.length > 0) {
            for (int i = 0; i < services.length; i++) {

                if (services[i].getName().equals("Microsoft Print to PDF")) {//aqui escribimos/elegimos la impresora por la que queremos imprimir
                    //manejar error en caso de que no esté conectada
                    //Desktop.getDesktop().print(null);//para imprimir un archivo ya existente  
                    existeImpresora = true;
                    job = services[i].createPrintJob();// System.out.println(i+": "+services[i].getName());

                } else if (existeImpresora = false) {
                    System.out.println("No se encontró la impresora cocina");
                }
            }

            PrinterJob pj = PrinterJob.getPrinterJob();

            PageFormat mPageFormat = pj.defaultPage();
            //pj.setPrintable(cp, mPageFormat);
            if (pj.printDialog()) {
                try {
                    //PrintService service = pj.getPrintService();//PrintServiceLookup.lookupDefaultPrintService();
                    pj.print();
                    //DocPrintJob pjb;
                    // job = service.createPrintJob();
                } catch (PrinterException ex) {
                    Logger.getLogger(ServicioDeImpresion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

//        Imprimimos dentro de un try obligatoriamente
        try {
            if (job != null) {
                job.print(doc, null);
            }
        } catch (PrintException ex) {
            System.out.println(ex);
        }
    }

    public static void imprimirCaja(String textoAImprimir) {
        agregarLogoATicket(textoAImprimir);
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null); //nos da el array de los servicios de impresion

        byte[] bytes = textoAImprimir.getBytes();

//Especificamos el tipo de dato a imprimir
//Tipo: bytes; Subtipo: autodetectado
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;

        Doc doc = new SimpleDoc(bytes, flavor, null);
//Creamos un trabajo de impresión
        DocPrintJob job = null;
        if (services.length > 0) {
//            for (int i = 0; i < services.length; i++) {
//                if (services[i].getName().equals("caja")) {//aqui escribimos/elegimos la impresora por la que queremos imprimir
//                    job = services[i].createPrintJob();// System.out.println(i+": "+services[i].getName());
//                }
//            }
            for (PrintService service : services) {
                if (service.getName().equals("caja")) {
                    //aqui escribimos/elegimos la impresora por la que queremos imprimir
                    job = service.createPrintJob(); // System.out.println(i+": "+services[i].getName());
                }
            }
        }

//Imprimimos dentro de un try obligatoriamente
        try {
            job.print(doc, null);
        } catch (PrintException ex) {
            System.out.println(ex);
        }

    }

    public static void imprimirGenerico(String contentTicket) {
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null); //nos da el array de los servicios de impresion
//Creamos un arreglo de tipo byte 
//y le agregamos el string convertido (cuerpo del ticket) a bytes tal como 
//lo maneja la impresora(mas bien ticketera :p)
        byte[] bytes = contentTicket.getBytes(); //Especificamos el tipo de dato a imprimir 
//Tipo: bytes; Subtipo: autodetectado 
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        Doc doc = new SimpleDoc(bytes, flavor, null); //Creamos un trabajo de impresión
        DocPrintJob job = null;
        if (services.length > 0) {
            for (int i = 0; i < services.length; i++) {
                if (services[i].getName().equals("GP-5890X Series")) {
//aqui escribimos/elegimos la impresora por la que queremos imprimir 
                    job = services[i].createPrintJob();
                    System.out.println(i + ": " + services[i].getName());
                }
            }
        }
//Imprimimos dentro de un try obligatoriamente 
        try {
            job.print(doc, null);
        } catch (PrintException ex) {
            System.out.println(ex);
        }
    }

    //TODO arreglo de impresoras de caja
    //TODO arreglo de impresoras de cocina
  

    private static String agregarLogoATicket(String textoAImprimir) {
        //TODO hacer pruebas de impresión de logo
        //TODO tal vez también se necesite imprimir una parte común al final
        return textoAImprimir;
    }
}

///*
// * Copyright 2016 Emiliano Policardo <www.facebook.com/policomputacion>.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//package com.lessence.gymmaven.clases.;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Frame;
//import java.awt.Graphics;
//import java.awt.PrintJob;
//import java.awt.Toolkit;
//import javax.print.*;
//import javax.print.attribute.HashPrintRequestAttributeSet;
//import javax.print.attribute.PrintRequestAttributeSet;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
///**
// *
// * @author Emiliano Policardo <www.facebook.com/policomputacion>
// */
//public class Impresion {
//
//    public static void main(String args[]) throws IOException {
//
//        FileInputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream("c:/archivo.jpg");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        if (inputStream == null) {
//            return;
//        }
//
//        DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
//        Doc document = new SimpleDoc(inputStream, docFormat, null);
//
//        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
//
//        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
//
//        if (defaultPrintService != null) {
//            DocPrintJob printJob = defaultPrintService.createPrintJob();
//            try {
//                printJob.print(document, attributeSet);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
//            System.err.println("No existen impresoras instaladas");
//        }
//
//        inputStream.close();
//    }
//}
//
////
/////********************************************************************
////*	El siguiente programa es un ejemplo bastante sencillo de 		*
////*	impresión con JAVA. 											*
////********************************************************************/
//////import javax.swing.*;
//////import java.awt.*;
//////import java.awt.event.*;
////// 
//// 
/////********************************************************************
////*	La siguiente clase llamada "Impresora", es la encargada de  	*
////*	establecer la fuente con que se va a imprimir, de obtener el	*
////*	trabajo de impresion, la página. En esta clase hay un método	*
////*	llamado imprimir, el cual recibe una cadena y la imprime.		*
////********************************************************************/
////class Impresora
////{
////    Font fuente = new Font("Dialog", Font.PLAIN, 10);
////	PrintJob pj;
////	Graphics pagina;
//// 
//// 
////	/********************************************************************
////	*	A continuación el constructor de la clase. Aquí lo único que	*
////	*	hago es tomar un objeto de impresion.							*
////	********************************************************************/
////	Impresora()
////	{
////		pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "SCAT", null);
////	}
//// 
////	/********************************************************************
////	*	A continuación el método "imprimir(String)", el encargado de 	*
////	*	colocar en el objeto gráfico la cadena que se le pasa como 		*
////	*	parámetro y se imprime.											*
////	********************************************************************/
////    public void imprimir(String Cadena)
////	{
////		//LO COLOCO EN UN try/catch PORQUE PUEDEN CANCELAR LA IMPRESION
////		try
////		{
////			pagina = pj.getGraphics();
////			pagina.setFont(fuente);
////			pagina.setColor(Color.black);
//// 
////			pagina.drawString(Cadena, 60, 60);
//// 
////			pagina.dispose();
////			pj.end();
////		}catch(Exception e)
////		{
////			System.out.println("LA IMPRESION HA SIDO CANCELADA..");
////		}
////	}//FIN DEL PROCEDIMIENTO imprimir(String..)
//// 
//// 
////}//FIN DE LA CLASE Impresora
//// 
//// 
//// 
//////A CONTINUACION LA CLASE PRINCIPAL
////public void Programa extends JFrame
////{
////	String cadena;
////	JTextField campo;
////	JButton imprimir;
////	JLabel info;
////	Impresora imp;
////	JPanel principal = new JPanel(new BorderLayout());
////	JPanel etiq = new JPanel(new FlowLayout());
////	JPanel dos = new JPanel(new FlowLayout());
//// 
////	//CONSTRUCTOR DE LA CLASE
////	Programa()
////	{
////		super("Muestra Simple de Impresión en JAVA..");
//// 
////		info = new JLabel("ESCRIBA ALGO EN EL CAMPO Y HAGA CLIC EN IMPRIMIR..");
////		cadena = new String();
////		campo = new JTextField(30);
////		imprimir = new JButton("IMPRIMIR");
//// 
////		dos.add(campo);
////		dos.add(imprimir);
////		etiq.add(info);
//// 
////		campo.setToolTipText("ESCRIBA ALGO AQUÍ..");
////		imprimir.setToolTipText("CLIC AQUI PARA IMPRIMIR..");
//// 
////		principal.add(etiq, BorderLayout.NORTH);
////		principal.add(dos, BorderLayout.CENTER);
//// 
////		getContentPane().add(principal);
//// 
////		//AJUSTO EL TAMAÑO DE LA VENTANA AL MINIMO
////		pack();
////		//NO PERMITO QUE PUEDAN CAMBIAR EL TAMAÑO DE LA VENTANA
////		this.setResizable(false);
//// 
////		//AHORA LA CENTRARÉ EN LA PANTALLA
////		Dimension pantalla, cuadro;
////		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
////		cuadro = this.getSize();
//// 
////		this.setLocation(((pantalla.width - cuadro.width)/2),
////						  (pantalla.height - cuadro.height)/2);
//// 
//// 
////		//LE AGREGAMOS EL EVENTO AL BOTON "imprimir"
//// 
////		imprimir.addActionListener(new ActionListener()
////		{
////			public void actionPerformed(ActionEvent evt)
////			{
////				cadena = "";
////				cadena = String.valueOf(campo.getText());
////				if (!cadena.equals(""))
////				{
////					imp = new Impresora();
////					imp.imprimir(cadena);
////				}
////				else System.out.println("NO SE IMPRIME NADA EN BLANCO..");
//// 
////				campo.requestFocus();
////				campo.select(0, cadena.length());
////			}
////		});
//// 
//// 
//// 
////	}//FIN DEL CONSTRUCTOR
//// 
////	public static void main(String jm[])
////	{
////		Programa p = new Programa();
////		p.show();
//// 
////		p.addWindowListener(new WindowAdapter()
////		{
////			public void windowClosing(WindowEvent evt)
////			{
////				System.exit(0);
////			}
////		});
////	}//FIN DEL MAIN
//// 
//// 
////}//FIN DE LA CLASE PRINCIPAL
