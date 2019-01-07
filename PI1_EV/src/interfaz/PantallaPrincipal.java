/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.io.File;
import java.net.URL;
import java.util.Locale;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import logicaNegocio.LogicaAplicacion;

/**
 *
 * @author esauj
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form PantallaPrincipal
     */
    private LogicaAplicacion logicaAplicacion;
    private final File NOMBRE_ARCHIVO_CSV = new File("resources\\listaCorredores.csv");
    private final File NOMBRE_ARCHIVO_CSV_CARRERAS = new File("resources\\carreras.csv");
    private final File NOMBRE_ARCHIVO_CSV_CARRERAS_ACABADAS = new File("resources\\carrerasAcabadas.csv");

    public PantallaPrincipal() {
        logicaAplicacion = new LogicaAplicacion();
        if (NOMBRE_ARCHIVO_CSV.exists()) {
            logicaAplicacion.cargarCSV();
        }
        //cargo las carreras
        if (NOMBRE_ARCHIVO_CSV_CARRERAS.exists()) {
            logicaAplicacion.cargarCSVCarreras();

        }
        //cargo las carreras acabadas
        if (NOMBRE_ARCHIVO_CSV_CARRERAS_ACABADAS.exists()) {
            logicaAplicacion.cargarCSVCarrerasAcabadas();
        }

        initComponents();
        cargarAyuda();
    }

    public LogicaAplicacion getLogicaAplicacion() {
        return logicaAplicacion;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCorredor = new javax.swing.JButton();
        jButtonCarrera = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonCorredor.setText("CORREDOR");
        jButtonCorredor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCorredorActionPerformed(evt);
            }
        });

        jButtonCarrera.setText("CARRERA");
        jButtonCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCarreraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 132, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jButtonCorredor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(62, 62, 62)
                .addComponent(jButtonCarrera)
                .addGap(102, 102, 102))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCorredor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCarrera))
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCorredorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCorredorActionPerformed

        PantallaCorredor pantallaCorredor = new PantallaCorredor(this, true, logicaAplicacion);
        pantallaCorredor.setLocationRelativeTo(null);
        pantallaCorredor.setVisible(true);
    }//GEN-LAST:event_jButtonCorredorActionPerformed

    private void jButtonCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCarreraActionPerformed
        PantallaCarrera pantallaCarrera = new PantallaCarrera(this, true, logicaAplicacion);
        pantallaCarrera.setLocationRelativeTo(null);
        pantallaCarrera.setVisible(true);

    }//GEN-LAST:event_jButtonCarreraActionPerformed
//Método llamado al cargar la ayuda.

    private void cargarAyuda() {
        try {
            // Carga el fichero de ayuda
            File fichero = new File("src/help/help_set.hs");
            URL hsURL = fichero.toURI().toURL();

            // Crea el HelpSet y el HelpBroker
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            HelpBroker hb = helpset.createHelpBroker();

            // Pone ayuda a item de menu al pulsar F1
            hb.enableHelpKey(getRootPane(), "principal", helpset);
            hb.enableHelpKey(jButtonCorredor, "corredores", helpset);
            hb.enableHelpKey(jButtonCarrera, "carrera", helpset);
        } catch (Exception e) {
            System.out.println("Error al cargar la ayuda: " + e);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Locale.setDefault(new Locale("es", "ES"));//para utilizar el idioma español
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCarrera;
    private javax.swing.JButton jButtonCorredor;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

  
}
