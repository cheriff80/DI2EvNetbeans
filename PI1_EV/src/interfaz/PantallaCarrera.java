/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import beans.Carrera;
import beans.Corredor;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import logicaNegocio.LogicaAplicacion;

/**
 *
 * @author esauj
 */
public class PantallaCarrera extends javax.swing.JDialog {

    /**
     * Creates new form PantallaCarrera
     *
     * @param parent
     * @param modal
     * @param la
     */
    private LogicaAplicacion logicaAplicacion;
    private PantallaPrincipal pp;
    private PantallaListaCorredores plc;
    private Carrera carreraModificar;
    
    

    public PantallaCarrera(java.awt.Frame parent, boolean modal, LogicaAplicacion logicaAplicacion) {
        
        pp = (PantallaPrincipal) parent;
        this.logicaAplicacion = logicaAplicacion;
        
        initComponents();
        cargarTablaCarreras();
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCarrerasAcabadas = new javax.swing.JTable();
        jLabelCarrerasAcabadas = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCarreras = new javax.swing.JTable();
        jLabelCarreras = new javax.swing.JLabel();
        jButtonAltaCarrera = new javax.swing.JButton();
        jButtonBajaCarrera = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonConsultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jTableCarrerasAcabadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableCarrerasAcabadas);

        jLabelCarrerasAcabadas.setText(org.openide.util.NbBundle.getMessage(PantallaCarrera.class, "PantallaCarrera.jLabelCarrerasAcabadas.text")); // NOI18N

        jTableCarreras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableCarreras.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTableCarreras.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(jTableCarreras);

        jLabelCarreras.setText(org.openide.util.NbBundle.getMessage(PantallaCarrera.class, "PantallaCarrera.jLabelCarreras.text")); // NOI18N

        jButtonAltaCarrera.setText(org.openide.util.NbBundle.getMessage(PantallaCarrera.class, "PantallaCarrera.jButtonAltaCarrera.text")); // NOI18N
        jButtonAltaCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAltaCarreraActionPerformed(evt);
            }
        });

        jButtonBajaCarrera.setText(org.openide.util.NbBundle.getMessage(PantallaCarrera.class, "PantallaCarrera.jButtonBajaCarrera.text")); // NOI18N
        jButtonBajaCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBajaCarreraActionPerformed(evt);
            }
        });

        jButtonModificar.setText(org.openide.util.NbBundle.getMessage(PantallaCarrera.class, "PantallaCarrera.jButtonModificar.text")); // NOI18N
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonConsultar.setText(org.openide.util.NbBundle.getMessage(PantallaCarrera.class, "PantallaCarrera.jButtonConsultar.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabelCarrerasAcabadas)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelCarreras)
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))))
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jButtonAltaCarrera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBajaCarrera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonConsultar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCarreras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCarrerasAcabadas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAltaCarrera)
                    .addComponent(jButtonBajaCarrera)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonConsultar))
                .addContainerGap(123, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAltaCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAltaCarreraActionPerformed
        PantallaAltaCarrera pac = new PantallaAltaCarrera(pp, true, logicaAplicacion);
        pac.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jButtonAltaCarreraActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentResized

    private void jButtonBajaCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBajaCarreraActionPerformed
        int index = jTableCarreras.convertRowIndexToModel(jTableCarreras.getSelectedRow());
        Carrera carrera = pp.getLogicaAplicacion().getListaCarreras().get(index);
        pp.getLogicaAplicacion().borrarCarrera(carrera);
        
        cargarTablaCarreras();
        this.setVisible(false);
        pp.setVisible(true);
        
        
    }//GEN-LAST:event_jButtonBajaCarreraActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
      int index = jTableCarreras.convertRowIndexToModel(jTableCarreras.getSelectedRow());
        Carrera carrera = pp.getLogicaAplicacion().getListaCarreras().get(index);
        PantallaAltaCarrera pac = new PantallaAltaCarrera(pp, logicaAplicacion, carrera, true);
        pac.setVisible(true);
        
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void cargarTablaCarreras() {

        DefaultTableModel akf = new DefaultTableModel();
        akf.setColumnIdentifiers(new String[]{"NOMBRE", "FECHA", "LUGAR", "Max PARTICIPANTES"});

        jTableCarreras.setModel(akf);
        //jTableCarrerasAcabadas.setModel(dtm);

        //utilizamos la clase RowSorter para ordenar la tabla por columnas
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(akf);
        jTableCarreras.setRowSorter(sorter);
        //jTableCarrerasAcabadas.setRowSorter(sorter);
        for (Carrera carrera : pp.getLogicaAplicacion().getListaCarreras()) {
            akf.addRow(carrera.toStringArray());

        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAltaCarrera;
    private javax.swing.JButton jButtonBajaCarrera;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JLabel jLabelCarreras;
    private javax.swing.JLabel jLabelCarrerasAcabadas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCarreras;
    private javax.swing.JTable jTableCarrerasAcabadas;
    // End of variables declaration//GEN-END:variables
}
