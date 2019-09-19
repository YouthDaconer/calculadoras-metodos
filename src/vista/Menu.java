/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.graficador.myFrame;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        conversor_btn = new javax.swing.JButton();
        estandar_btn = new javax.swing.JButton();
        derivadas_btn = new javax.swing.JButton();
        funciones_btn = new javax.swing.JButton();
        graficadora_btn = new javax.swing.JButton();
        biseccion_btn = new javax.swing.JButton();
        regla_falsa_btn = new javax.swing.JButton();
        newton_raphson_btn = new javax.swing.JButton();
        secante_btn = new javax.swing.JButton();
        btn_raices_poli = new javax.swing.JButton();
        integracion_rectangulos_btn = new javax.swing.JButton();
        integracion_trapecio_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Métodos numéricos");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("MÉTODOS NUMÉRICOS");

        conversor_btn.setText("Conversor a diferentes bases");
        conversor_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conversor_btnActionPerformed(evt);
            }
        });

        estandar_btn.setText("Estandar IEEE754");
        estandar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estandar_btnActionPerformed(evt);
            }
        });

        derivadas_btn.setText("Calculadora de derivadas");
        derivadas_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derivadas_btnActionPerformed(evt);
            }
        });

        funciones_btn.setText("Calculadora de funciones");
        funciones_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                funciones_btnActionPerformed(evt);
            }
        });

        graficadora_btn.setText("Graficadora");
        graficadora_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graficadora_btnActionPerformed(evt);
            }
        });

        biseccion_btn.setText("Método de bisección");
        biseccion_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                biseccion_btnActionPerformed(evt);
            }
        });

        regla_falsa_btn.setText("Método de regla falsa");
        regla_falsa_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regla_falsa_btnActionPerformed(evt);
            }
        });

        newton_raphson_btn.setText("Newton Raphson");
        newton_raphson_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newton_raphson_btnActionPerformed(evt);
            }
        });

        secante_btn.setText("Método de la secante");
        secante_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secante_btnActionPerformed(evt);
            }
        });

        btn_raices_poli.setText("Raíces de polinomios");
        btn_raices_poli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_raices_poliActionPerformed(evt);
            }
        });

        integracion_rectangulos_btn.setText("Integración por Rectangulos");
        integracion_rectangulos_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                integracion_rectangulos_btnActionPerformed(evt);
            }
        });

        integracion_trapecio_btn.setText("Integración por Trapecio");
        integracion_trapecio_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                integracion_trapecio_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(jLabel1)
                .addContainerGap(205, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(integracion_rectangulos_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newton_raphson_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(derivadas_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(conversor_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(integracion_trapecio_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_raices_poli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(estandar_btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(funciones_btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(secante_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(biseccion_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(regla_falsa_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(graficadora_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(conversor_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(derivadas_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(newton_raphson_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(integracion_rectangulos_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(estandar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(biseccion_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(funciones_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(regla_falsa_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(secante_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_raices_poli, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(graficadora_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(integracion_trapecio_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void conversor_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conversor_btnActionPerformed
        // TODO add your handling code here:
        new ConversorBasesVista().setVisible(true);
    }//GEN-LAST:event_conversor_btnActionPerformed

    private void estandar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estandar_btnActionPerformed
        // TODO add your handling code here:
        new IEEE754Vista().setVisible(true);
    }//GEN-LAST:event_estandar_btnActionPerformed

    private void derivadas_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derivadas_btnActionPerformed
        // TODO add your handling code here:
        try {
            new Derivadas().setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(Derivadas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_derivadas_btnActionPerformed

    private void funciones_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funciones_btnActionPerformed
        // TODO add your handling code here:
        new EvaluadorFuncionVista().setVisible(true);
    }//GEN-LAST:event_funciones_btnActionPerformed

    private void graficadora_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graficadora_btnActionPerformed
        // TODO add your handling code here:
        myFrame aplicacion = new myFrame();
    }//GEN-LAST:event_graficadora_btnActionPerformed

    private void biseccion_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_biseccion_btnActionPerformed
        // TODO add your handling code here:
        new BiseccionVista().setVisible(true);
    }//GEN-LAST:event_biseccion_btnActionPerformed

    private void regla_falsa_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regla_falsa_btnActionPerformed
        // TODO add your handling code here:
        new ReglaFalsaVista().setVisible(true);
    }//GEN-LAST:event_regla_falsa_btnActionPerformed

    private void newton_raphson_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newton_raphson_btnActionPerformed
        // TODO add your handling code here:
        new NewtonRaphsonVista().setVisible(true);
    }//GEN-LAST:event_newton_raphson_btnActionPerformed

    private void secante_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secante_btnActionPerformed
        // TODO add your handling code here:
        new SecanteVista().setVisible(true);
    }//GEN-LAST:event_secante_btnActionPerformed

    private void btn_raices_poliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_raices_poliActionPerformed
        // TODO add your handling code here:
        new PolinomioVista().setVisible(true);
    }//GEN-LAST:event_btn_raices_poliActionPerformed

    private void integracion_rectangulos_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_integracion_rectangulos_btnActionPerformed
        // TODO add your handling code here:
        new IntegralRectangulosVista().setVisible(true);
    }//GEN-LAST:event_integracion_rectangulos_btnActionPerformed

    private void integracion_trapecio_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_integracion_trapecio_btnActionPerformed
        // TODO add your handling code here:
        new IntegralTrapecioVista().setVisible(true);
    }//GEN-LAST:event_integracion_trapecio_btnActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton biseccion_btn;
    private javax.swing.JButton btn_raices_poli;
    private javax.swing.JButton conversor_btn;
    private javax.swing.JButton derivadas_btn;
    private javax.swing.JButton estandar_btn;
    private javax.swing.JButton funciones_btn;
    private javax.swing.JButton graficadora_btn;
    private javax.swing.JButton integracion_rectangulos_btn;
    private javax.swing.JButton integracion_trapecio_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton newton_raphson_btn;
    private javax.swing.JButton regla_falsa_btn;
    private javax.swing.JButton secante_btn;
    // End of variables declaration//GEN-END:variables
}
