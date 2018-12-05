/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import beans.Carrera;
import logicaNegocio.LogicaAplicacion;
import Cronometro.DobleClickListener;
import beans.Corredor;
import java.util.Iterator;

/**
 *
 * @author esauj
 */
public class PantallaCronometro extends javax.swing.JDialog {

    /**
     * Creates new form PantallaCronometro
     */
    private LogicaAplicacion logicaAplicacion;
    private Carrera carrera;

    public PantallaCronometro(java.awt.Frame parent, boolean modal, LogicaAplicacion logicaAplicacion, Carrera carrera) {
        super(parent, modal);
        this.carrera = carrera;
        this.logicaAplicacion = logicaAplicacion;
        initComponents();
        jTextFieldDorsal.setVisible(false);
        jLabelDorsalCorredor.setVisible(false);
        cronometro.addDobleClick(new DobleClickListener() {
            @Override
            public void dobleClick() {
                jLabelDorsalCorredor.setVisible(true);
                jTextFieldDorsal.setVisible(true);

            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelCronometro = new javax.swing.JLabel();
        jButtonStart = new javax.swing.JButton();
        jButtonStop = new javax.swing.JButton();
        jButtonPause = new javax.swing.JButton();
        jTextFieldDorsal = new javax.swing.JTextField();
        jLabelDorsalCorredor = new javax.swing.JLabel();
        cronometro = new Cronometro.Cronometro();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelCronometro.setText(org.openide.util.NbBundle.getMessage(PantallaCronometro.class, "PantallaCronometro.jLabelCronometro.text")); // NOI18N

        jButtonStart.setText(org.openide.util.NbBundle.getMessage(PantallaCronometro.class, "PantallaCronometro.jButtonStart.text")); // NOI18N
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jButtonStop.setText(org.openide.util.NbBundle.getMessage(PantallaCronometro.class, "PantallaCronometro.jButtonStop.text")); // NOI18N
        jButtonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopActionPerformed(evt);
            }
        });

        jButtonPause.setText(org.openide.util.NbBundle.getMessage(PantallaCronometro.class, "PantallaCronometro.jButtonPause.text")); // NOI18N
        jButtonPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPauseActionPerformed(evt);
            }
        });

        jTextFieldDorsal.setText(org.openide.util.NbBundle.getMessage(PantallaCronometro.class, "PantallaCronometro.jTextFieldDorsal.text")); // NOI18N
        jTextFieldDorsal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDorsalActionPerformed(evt);
            }
        });

        jLabelDorsalCorredor.setText(org.openide.util.NbBundle.getMessage(PantallaCronometro.class, "PantallaCronometro.jLabelDorsalCorredor.text")); // NOI18N

        cronometro.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelCronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabelDorsalCorredor))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonStop, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextFieldDorsal, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonStart)
                                        .addGap(80, 80, 80)
                                        .addComponent(jButtonPause)))))))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabelCronometro)
                .addGap(18, 18, 18)
                .addComponent(cronometro, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonStart)
                    .addComponent(jButtonPause))
                .addGap(18, 18, 18)
                .addComponent(jLabelDorsalCorredor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDorsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonStop)
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
        cronometro.start();
        jButtonStart.setEnabled(false);
        jButtonPause.setEnabled(true);
        jButtonStop.setEnabled(true);
    }//GEN-LAST:event_jButtonStartActionPerformed

    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
        cronometro.stop();
        if (cronometro.getT().isRunning()) {
            cronometro.start();
            jButtonStart.setEnabled(true);
        }
        jButtonStart.setText("INICIAR");
        jButtonPause.setEnabled(false);
        jButtonStop.setEnabled(false);
        cronometro.setH(0);
        cronometro.setMin(0);
        cronometro.setSeg(0);
        cronometro.setCs(0);
        cronometro.actualizarLabel();
    }//GEN-LAST:event_jButtonStopActionPerformed

    private void jButtonPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPauseActionPerformed
        cronometro.stop();
        jButtonStart.setEnabled(true);
        jButtonPause.setEnabled(false);
    }//GEN-LAST:event_jButtonPauseActionPerformed

    private void jTextFieldDorsalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDorsalActionPerformed

        int dorsal = Integer.parseInt(jTextFieldDorsal.getText());
        String tiempoFinal = cronometro.getTiempoFinal();
        Iterator it = carrera.getListaParticipantes().iterator();
        for (Corredor corredor : carrera.getListaParticipantes()) {
            while (it.hasNext()) {
                corredor = (Corredor) it.next();
                if (corredor.getDorsal() == dorsal) {
                    corredor.setTiempoFinal(tiempoFinal);
                    carrera.getListaFinalCarrera().add(corredor);
                    
                }
            }
        }
        jTextFieldDorsal.setVisible(false);
        jLabelDorsalCorredor.setVisible(false);

    }//GEN-LAST:event_jTextFieldDorsalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Cronometro.Cronometro cronometro;
    private javax.swing.JButton jButtonPause;
    private javax.swing.JButton jButtonStart;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JLabel jLabelCronometro;
    private javax.swing.JLabel jLabelDorsalCorredor;
    private javax.swing.JTextField jTextFieldDorsal;
    // End of variables declaration//GEN-END:variables
}