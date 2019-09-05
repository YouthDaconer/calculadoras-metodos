/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.Polinomio;
import javax.swing.JOptionPane;

/**
 *
 * @author JSRA
 */
public class PolinomioVista extends javax.swing.JFrame {
    Polinomio p;

    /**
     * Creates new form PolinomioVista
     */
    public PolinomioVista() {
        initComponents();
    }
    
    private void calcular(){
        String expresion = expresion_math.getText().trim();
        if (expresion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe escribir la el polinomio", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                p= new Polinomio(expresion);                
                txt_area_raices.setText(p.getRaices()+p.getRaicesComplejas());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "No se pudo calcular las raíces del polinomio\n"+ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
    private void limpiar(){
        expresion_math.setText("");
        txt_area_raices.setText("");        
        expresion_math.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        expresion_math = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_area_raices = new javax.swing.JTextArea();
        labelRaices = new javax.swing.JLabel();
        calcular_btn = new javax.swing.JButton();
        limpiar_btn = new javax.swing.JButton();
        cerrar_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Raíces de polinomios");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("RAÍCES DE POLINOMIOS");

        jLabel1.setText("Polinomio P(x):");

        expresion_math.setToolTipText("3x^4-6.5x^3+8.96x^2-15.25x-9.45");

        txt_area_raices.setEditable(false);
        txt_area_raices.setColumns(20);
        txt_area_raices.setRows(5);
        jScrollPane1.setViewportView(txt_area_raices);

        labelRaices.setText("Raíces:");

        calcular_btn.setText("CALCULAR");
        calcular_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcular_btnActionPerformed(evt);
            }
        });

        limpiar_btn.setText("LIMPIAR");
        limpiar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar_btnActionPerformed(evt);
            }
        });

        cerrar_btn.setText("CERRAR");
        cerrar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrar_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelRaices, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(calcular_btn)
                        .addGap(60, 60, 60)
                        .addComponent(limpiar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(cerrar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                        .addComponent(expresion_math)))
                .addGap(173, 173, 173))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(expresion_math, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calcular_btn)
                    .addComponent(limpiar_btn)
                    .addComponent(cerrar_btn))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelRaices)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calcular_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcular_btnActionPerformed
        // TODO add your handling code here:
        calcular();
    }//GEN-LAST:event_calcular_btnActionPerformed

    private void limpiar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar_btnActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_limpiar_btnActionPerformed

    private void cerrar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrar_btnActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cerrar_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calcular_btn;
    private javax.swing.JButton cerrar_btn;
    private javax.swing.JTextField expresion_math;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelRaices;
    private javax.swing.JButton limpiar_btn;
    private javax.swing.JTextArea txt_area_raices;
    // End of variables declaration//GEN-END:variables
}
