/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.KeyEvent;
import modelo.ModeloTabla;
import control.NewtonRaphson;
import javax.swing.JOptionPane;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class NewtonRaphsonVista extends javax.swing.JFrame {

    NewtonRaphson nr;

    /**
     * Creates new form NewtonRaphson
     */
    public NewtonRaphsonVista() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    //método que limpiar las cajas de texto de la interfaz
    private void limpiar() {
        txt_error.setText("");
        txt_errorTolerado.setText("");
        txt_iteraciones.setText("");
        txt_resultado.setText("");
        txt_valor_x.setText("");
        expresion_math.setText("");
        btnTabla.setEnabled(false);//Únicamente se habilita cuando se hace el cálculo
        expresion_math.requestFocus();
    }

    //Método que se llama después de oprimir calcular
    public void calcular() {
        String resultado = "NaN";
        try {
            String expresion = expresion_math.getText();
            Double error = Double.parseDouble(txt_errorTolerado.getText());
            Double valor_x = Double.parseDouble(txt_valor_x.getText());
            nr = new NewtonRaphson(expresion, error);
            resultado = "" + nr.resolver(valor_x);

            if (resultado.equals("NaN")) {//error
                JOptionPane.showMessageDialog(this, "No se pudo calcular la expresión", "Error :(", JOptionPane.ERROR_MESSAGE);// En caso de algun error
            } else {//ponemos los resultados
                txt_resultado.setText(resultado);
                txt_error.setText("" + nr.getError());
                txt_iteraciones.setText("" + nr.getIteraciones());
                btnTabla.setEnabled(true);//Habilitamos el botón de ver tabla
            }
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error :(", JOptionPane.ERROR_MESSAGE);// En caso de algun error
        } catch (NumberFormatException es) {
            JOptionPane.showMessageDialog(this, "Verifique que todos los campos hayan sido llenados", "Error :(", JOptionPane.ERROR_MESSAGE);// En caso de algun error
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

        jLabelFx = new javax.swing.JLabel();
        expresion_math = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_errorTolerado = new javax.swing.JTextField();
        jLabelBiseccion = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btn_calcular = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btn_cerrar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_resultado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_error = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_iteraciones = new javax.swing.JTextField();
        btnTabla = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_valor_x = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Newton Raphson");

        jLabelFx.setText("Expresión Matemática F(x):");

        jLabel5.setText("Valor de x:");

        txt_errorTolerado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_errorToleradoKeyTyped(evt);
            }
        });

        jLabelBiseccion.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelBiseccion.setText("MÉTODO DE NEWTON RAPHSON");

        btn_calcular.setText("CALCULAR");
        btn_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcularActionPerformed(evt);
            }
        });

        btn_limpiar.setText("LIMPIAR");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        btn_cerrar.setText("CERRAR");
        btn_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarActionPerformed(evt);
            }
        });

        jLabel7.setText("Resultado:");

        txt_resultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_resultadoActionPerformed(evt);
            }
        });

        jLabel8.setText("Error relativo err:");

        txt_error.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_errorActionPerformed(evt);
            }
        });

        jLabel9.setText("Iteraciones   n");

        txt_iteraciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_iteracionesActionPerformed(evt);
            }
        });

        btnTabla.setText("Ver tabla");
        btnTabla.setEnabled(false);
        btnTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTablaActionPerformed(evt);
            }
        });

        jLabel6.setText("Error de tolerancia:");

        txt_valor_x.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_valor_xKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txt_resultado, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_error, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt_iteraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnTabla))))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btn_calcular)
                                            .addGap(30, 30, 30)
                                            .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(32, 32, 32)
                                            .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_errorTolerado, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabelFx))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(expresion_math, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_valor_x, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelBiseccion, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabelBiseccion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFx)
                    .addComponent(expresion_math, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_valor_x, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_errorTolerado, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(26, 26, 26)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_calcular)
                    .addComponent(btn_limpiar)
                    .addComponent(btn_cerrar))
                .addGap(34, 34, 34)
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

    private void txt_errorToleradoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_errorToleradoKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE)
                || (c == KeyEvent.VK_PERIOD))) {//que solo hacepte números, puntos y las teclas de borrado
            getToolkit().beep();
            evt.consume();//se elimina
        }
        if (c == KeyEvent.VK_PERIOD && txt_errorTolerado.getText().contains(".")) {//Si la caja de texto ya contiene un punto
            getToolkit().beep();
            evt.consume();//se elimina
        }
    }//GEN-LAST:event_txt_errorToleradoKeyTyped

    private void btn_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcularActionPerformed
        // TODO add your handling code here:
        calcular();
    }//GEN-LAST:event_btn_calcularActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_cerrarActionPerformed

    private void txt_resultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_resultadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_resultadoActionPerformed

    private void txt_errorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_errorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_errorActionPerformed

    private void txt_iteracionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_iteracionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_iteracionesActionPerformed

    private void btnTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTablaActionPerformed
        /* Cada clase de métodos tiene sus atributos con sus datos y encabezados que se
         crean después de hacer el procedimiento del cálculo respectivo*/
        ModeloTabla modelo = new ModeloTabla(nr.getEncabezados(), nr.getDatos());
        new TablaVista(modelo).setVisible(true);
    }//GEN-LAST:event_btnTablaActionPerformed

    private void txt_valor_xKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valor_xKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE)
                || (c == KeyEvent.VK_PERIOD)
                || (c == KeyEvent.VK_MINUS))) {//que solo hacepte números, puntos y las teclas de borrado
            getToolkit().beep();
            evt.consume();//se elimina
        }
        if (c == KeyEvent.VK_PERIOD && txt_valor_x.getText().contains(".")) {//Si la caja de texto ya contiene un punto
            getToolkit().beep();
            evt.consume();//se elimina
        }
        
        if (c == KeyEvent.VK_MINUS && txt_valor_x.getText().contains("-")) {//Si la caja de texto ya contiene un '-'
            getToolkit().beep();
            evt.consume();//se elimina
        }
    }//GEN-LAST:event_txt_valor_xKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTabla;
    private javax.swing.JButton btn_calcular;
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JTextField expresion_math;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBiseccion;
    private javax.swing.JLabel jLabelFx;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txt_error;
    private javax.swing.JTextField txt_errorTolerado;
    private javax.swing.JTextField txt_iteraciones;
    private javax.swing.JTextField txt_resultado;
    private javax.swing.JTextField txt_valor_x;
    // End of variables declaration//GEN-END:variables
}
