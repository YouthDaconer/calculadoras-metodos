/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ReglaFalsa;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import modelo.ModeloTabla;

/**
 *
 * @author carlo
 */
public class ReglaFalsaVista extends javax.swing.JFrame {

    KeyListener keyListenerIntInicial;
    KeyListener keyListenerIntFinal;
    String txt_field_int_inicial = "";
    String txt_field_int_final = "";
    ReglaFalsa rf;

    /**
     * Creates new form ReglaFalsa
     */
    public ReglaFalsaVista() {
        initComponents();
        txt_resultado.setEditable(false);
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
        jLabel2 = new javax.swing.JLabel();
        regla_falsa_txt = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        int_inicial = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        int_final = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        error_tolerancia = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        txt_resultado = new javax.swing.JTextField();
        calcular_btn = new javax.swing.JButton();
        limpiar_btn = new javax.swing.JButton();
        cerrar_btn = new javax.swing.JButton();
        btnTabla = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_error = new javax.swing.JTextField();
        txt_iteraciones = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Regla Falsa");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("MÉTODO DE REGLA FALSA");

        jLabel2.setText("Función f(x):");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Intervalo"));

        jLabel3.setText("Desde (a)");

        int_inicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                int_inicialKeyTyped(evt);
            }
        });

        jLabel4.setText("Hasta (b)");

        int_final.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                int_finalKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(int_inicial, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(int_final))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(int_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(int_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel5.setText("Error de tolerancia (Et):");

        error_tolerancia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                error_toleranciaKeyTyped(evt);
            }
        });

        jLabel7.setText("Resultado:");

        txt_resultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_resultadoActionPerformed(evt);
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

        btnTabla.setText("Ver tabla");
        btnTabla.setEnabled(false);
        btnTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTablaActionPerformed(evt);
            }
        });

        jLabel8.setText("Error relativo err:");

        jLabel9.setText("Iteraciones   n");

        txt_error.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_errorActionPerformed(evt);
            }
        });

        txt_iteraciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_iteracionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(calcular_btn)
                                .addGap(30, 30, 30)
                                .addComponent(limpiar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(cerrar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(13, 13, 13)
                                    .addComponent(error_tolerancia, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                .addComponent(txt_resultado, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTabla)
                            .addComponent(txt_error, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_iteraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(regla_falsa_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(regla_falsa_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(error_tolerancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calcular_btn)
                    .addComponent(limpiar_btn)
                    .addComponent(cerrar_btn))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_resultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_error, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txt_iteraciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnTabla)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_resultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_resultadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_resultadoActionPerformed

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

    private void int_inicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_int_inicialKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE)
                || (c == KeyEvent.VK_PERIOD)
                || (c == KeyEvent.VK_MINUS))) {//que solo hacepte números, puntos, '-' y las teclas de borrado
            getToolkit().beep();
            evt.consume();//se elimina
        }
        if (c == KeyEvent.VK_PERIOD && int_inicial.getText().contains(".")) {//Si la caja de texto ya contiene un punto
            getToolkit().beep();
            evt.consume();//se elimina
        }

        if (c == KeyEvent.VK_MINUS && int_inicial.getText().contains("-")) {//Si la caja de texto ya contiene un '-'
            getToolkit().beep();
            evt.consume();//se elimina
        }
    }//GEN-LAST:event_int_inicialKeyTyped

    private void int_finalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_int_finalKeyTyped
        // TODO add your handling code here:
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE)
                || (c == KeyEvent.VK_PERIOD)
                || (c == KeyEvent.VK_MINUS))) {//que solo hacepte números, puntos, '-' y las teclas de borrado
            getToolkit().beep();
            evt.consume();//se elimina
        }
        if (c == KeyEvent.VK_PERIOD && int_final.getText().contains(".")) {//Si la caja de texto ya contiene un punto
            getToolkit().beep();
            evt.consume();//se elimina
        }

        if (c == KeyEvent.VK_MINUS && int_final.getText().contains("-")) {//Si la caja de texto ya contiene un '-'
            getToolkit().beep();
            evt.consume();//se elimina
        }
    }//GEN-LAST:event_int_finalKeyTyped

    private void error_toleranciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_error_toleranciaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE)
                || (c == KeyEvent.VK_PERIOD)
                || (c == KeyEvent.VK_MINUS))) {//que solo hacepte números, puntos, '-' y las teclas de borrado
            getToolkit().beep();
            evt.consume();//se elimina
        }
        if (c == KeyEvent.VK_PERIOD && error_tolerancia.getText().contains(".")) {//Si la caja de texto ya contiene un punto
            getToolkit().beep();
            evt.consume();//se elimina
        }

        if (c == KeyEvent.VK_MINUS && error_tolerancia.getText().contains("-")) {//Si la caja de texto ya contiene un '-'
            getToolkit().beep();
            evt.consume();//se elimina
        }
    }//GEN-LAST:event_error_toleranciaKeyTyped

    private void btnTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTablaActionPerformed
        /* Cada clase de métodos tiene sus atributos con sus datos y encabezados que se
         crean después de hacer el procedimiento del cálculo respectivo*/
        ModeloTabla modelo = new ModeloTabla(rf.getEncabezados(), rf.getDatos());
        new TablaVista(modelo).setVisible(true);
    }//GEN-LAST:event_btnTablaActionPerformed

    private void txt_errorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_errorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_errorActionPerformed

    private void txt_iteracionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_iteracionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_iteracionesActionPerformed

    private void limpiar() {
        txt_field_int_final = "";
        txt_field_int_inicial = "";
        regla_falsa_txt.setText("");
        int_inicial.setText("");
        int_final.setText("");
        error_tolerancia.setText("");
        txt_resultado.setText("");
        txt_error.setText("");
        txt_iteraciones.setText("");
        regla_falsa_txt.requestFocus();
    }

    private void calcular() {
        String resultado = "NaN";
        try {
            String expresion = regla_falsa_txt.getText();
            Double x1 = Double.parseDouble(int_inicial.getText());
            Double x2 = Double.parseDouble(int_final.getText());
            Double error = Double.parseDouble(error_tolerancia.getText());

            if (x1 >= x2 || error <= 0 || error >= 1) {// En caso de algun en el intervalo 0 con el error tolerado
                JOptionPane.showMessageDialog(this, "Asegúrate de que el intervalo esté bien y el valor del error sea > 0 y menor a 1", "Error :(", JOptionPane.ERROR_MESSAGE);
            } else {
                rf = new ReglaFalsa(expresion, x1, x2, error);

                resultado = "" + rf.resolver();//calculamos

                if (resultado.equals("NaN")) {//error
                    JOptionPane.showMessageDialog(this, "No se pudo calcular la expresión", "Error :(", JOptionPane.ERROR_MESSAGE);// En caso de algun error
                } else { //ponemos los resultados
                    txt_resultado.setText(resultado);
                    txt_error.setText("" + rf.getError());
                    txt_iteraciones.setText("" + rf.getIteraciones());
                    btnTabla.setEnabled(true); //Habilitamos el botón de ver tabla
                }
            }
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error :(", JOptionPane.ERROR_MESSAGE);// En caso de algun error
        } catch (NumberFormatException es) {
            JOptionPane.showMessageDialog(this, "Verifique que todos los campos hayan sido llenados correctamente", "Error :(", JOptionPane.ERROR_MESSAGE);// En caso de algun error
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTabla;
    private javax.swing.JButton calcular_btn;
    private javax.swing.JButton cerrar_btn;
    private javax.swing.JTextField error_tolerancia;
    private javax.swing.JTextField int_final;
    private javax.swing.JTextField int_inicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton limpiar_btn;
    private javax.swing.JTextField regla_falsa_txt;
    private javax.swing.JTextField txt_error;
    private javax.swing.JTextField txt_iteraciones;
    private javax.swing.JTextField txt_resultado;
    // End of variables declaration//GEN-END:variables
}
