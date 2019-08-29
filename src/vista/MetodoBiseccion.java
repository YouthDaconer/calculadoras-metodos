/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.Biseccion;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author JSRA
 */
public class MetodoBiseccion extends javax.swing.JFrame {

    /**
     * Creates new form Biseccion
     */
    public MetodoBiseccion() {
        initComponents();
    }

    //método que limpiar las cajas de texto de la interfaz
    private void limpiar() {
        txt_error.setText("");
        txt_errorTolerado.setText("");
        txt_iteraciones.setText("");
        txt_limiteInferior.setText("");
        txt_limiteSuperior.setText("");
        txt_resultado.setText("");
        expresion_math.setText("");
    }
    //-------------------------------------

    public void calcular() {
        String resultado = "NaN";
        try {

            String expresion = expresion_math.getText();

            Double x1 = Double.parseDouble(txt_limiteInferior.getText());
            Double x2 = Double.parseDouble(txt_limiteSuperior.getText());
            Double error = Double.parseDouble(txt_errorTolerado.getText());

            if (x1 >= x2 || error<=0 || error >=1 ) {
                JOptionPane.showMessageDialog(this, "Asegúrate de que el intervalo esté bien y el valor del error sea > 0 y menor a 1", "Error :(", JOptionPane.ERROR_MESSAGE);
            } else {
                Biseccion b = new Biseccion(expresion, x1, x2, error);

                resultado = "" + b.biseccion();

                if (resultado.equals("NaN")) {
                    JOptionPane.showMessageDialog(this, "No se pudo calcular la expresión", "Error :(", JOptionPane.ERROR_MESSAGE);
                } else {
                    txt_resultado.setText(resultado);
                    txt_error.setText("" + b.getError());
                    txt_iteraciones.setText("" + b.getIteraciones());
                }
            }
        } catch (ArithmeticException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error :(", JOptionPane.ERROR_MESSAGE);
        }

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
        jLabelFx = new javax.swing.JLabel();
        jLabelBiseccion = new javax.swing.JLabel();
        expresion_math = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_limiteInferior = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_limiteSuperior = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_errorTolerado = new javax.swing.JTextField();
        calcular_btn = new javax.swing.JButton();
        limpiar_btn = new javax.swing.JButton();
        cerrar_btn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_resultado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_error = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_iteraciones = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelFx.setText("Expresión Matemática F(x):");

        jLabelBiseccion.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelBiseccion.setText("MÉTODO DE BISSECCIÓN");

        jLabel3.setText("Límite inferior:");

        txt_limiteInferior.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_limiteInferiorKeyTyped(evt);
            }
        });

        jLabel4.setText("Límite superior:");

        txt_limiteSuperior.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_limiteSuperiorKeyTyped(evt);
            }
        });

        jLabel5.setText("Error de tolerancia:");

        txt_errorTolerado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_errorToleradoKeyTyped(evt);
            }
        });

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

        jLabel6.setText("Raiz r:");

        txt_resultado.setEditable(false);

        jLabel7.setText("Error relativo err:");

        txt_error.setEditable(false);

        jLabel8.setText("Iteraciones   n");

        txt_iteraciones.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_error, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_iteraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_resultado, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(calcular_btn)
                            .addGap(30, 30, 30)
                            .addComponent(limpiar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(cerrar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jLabelBiseccion, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabelFx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_errorTolerado, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_limiteSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(expresion_math, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_limiteInferior, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(222, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelBiseccion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFx)
                    .addComponent(expresion_math, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_limiteInferior, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_limiteSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_errorTolerado, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calcular_btn)
                    .addComponent(limpiar_btn)
                    .addComponent(cerrar_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_resultado, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_error, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_iteraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void txt_limiteInferiorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_limiteInferiorKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE)
                || (c == KeyEvent.VK_PERIOD)
                || (c == KeyEvent.VK_MINUS))) {
            getToolkit().beep();
            evt.consume();
        }
        if (c == KeyEvent.VK_PERIOD && txt_limiteInferior.getText().contains(".")) {
            getToolkit().beep();
            evt.consume();
        }

        if (c == KeyEvent.VK_MINUS && txt_limiteInferior.getText().contains("-")) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_limiteInferiorKeyTyped

    private void txt_limiteSuperiorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_limiteSuperiorKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE)
                || (c == KeyEvent.VK_PERIOD)
                || (c == KeyEvent.VK_MINUS))) {
            getToolkit().beep();
            evt.consume();
        }
        if (c == KeyEvent.VK_PERIOD && txt_limiteSuperior.getText().contains(".")) {
            getToolkit().beep();
            evt.consume();
        }

        if (c == KeyEvent.VK_MINUS && txt_limiteSuperior.getText().contains("-")) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_limiteSuperiorKeyTyped

    private void txt_errorToleradoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_errorToleradoKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE)
                || (c == KeyEvent.VK_PERIOD)
                || (c == KeyEvent.VK_MINUS))) {
            getToolkit().beep();
            evt.consume();
        }
        if (c == KeyEvent.VK_PERIOD && txt_errorTolerado.getText().contains(".")) {
            getToolkit().beep();
            evt.consume();
        }

        if (c == KeyEvent.VK_MINUS && txt_errorTolerado.getText().contains("-")) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_errorToleradoKeyTyped

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
            java.util.logging.Logger.getLogger(MetodoBiseccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MetodoBiseccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MetodoBiseccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MetodoBiseccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MetodoBiseccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calcular_btn;
    private javax.swing.JButton cerrar_btn;
    private javax.swing.JTextField expresion_math;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelBiseccion;
    private javax.swing.JLabel jLabelFx;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton limpiar_btn;
    private javax.swing.JTextField txt_error;
    private javax.swing.JTextField txt_errorTolerado;
    private javax.swing.JTextField txt_iteraciones;
    private javax.swing.JTextField txt_limiteInferior;
    private javax.swing.JTextField txt_limiteSuperior;
    private javax.swing.JTextField txt_resultado;
    // End of variables declaration//GEN-END:variables
}
