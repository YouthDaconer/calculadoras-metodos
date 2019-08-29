/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.Derivada;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Derivadas extends javax.swing.JFrame {

    KeyListener keyListenerDecimal;
    String txt_field_decimal = "";

    /**
     * Creates new form Derivadas
     */
    public Derivadas() throws ParseException {
        initComponents();
        resultado_field.setEditable(false);
        this.setLocationRelativeTo(null);

        /* Eventos de conversión desde decimal */
        keyListenerDecimal = new KeyListener() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                printIt("Pressed", keyEvent);
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                borrarCampo(keyEvent);
            }

            @Override
            public void keyTyped(KeyEvent keyEvent) {
            }

            private void borrarCampo(KeyEvent keyEvent) {
                int keyCode = keyEvent.getKeyCode();
                String aux_field_decimal = "";
                System.out.println("el enter:" + keyCode);
                // Si solto .
                if (keyCode == 46 || keyCode == 110) {
                    int count = 0;
                    char c = '.';
                    for (int i = 0; i < txt_field_decimal.trim().length(); i++) {
                        if (txt_field_decimal.trim().charAt(i) == c) {
                            count++;
                        }
                    }
                    if (count > 1) {
                        aux_field_decimal = valor_x.getText();
                        aux_field_decimal = borrarUltimoCaracter(aux_field_decimal);
                        valor_x.setText(aux_field_decimal);
                        valor_x.requestFocus();
                        txt_field_decimal = borrarUltimoCaracter(txt_field_decimal);
                        return;
                    }
                    if (txt_field_decimal.trim().equals(".")) {
                        limpiarCampos();
                        return;
                    }
                    if (!txt_field_decimal.contains("-")) {
                        return;
                    }
                }
                // Si solto -
                if (keyCode == 45 || keyCode == 109) {
                    if (txt_field_decimal.length() < 0) {
                        return;
                    }
                }
                // Si lo que digitó no es un número, no la tecla enter o no es la tecla retroceso
                if (!(keyCode >= 48 && keyCode <= 57) && keyCode != 10 && keyCode != 8) {
                    aux_field_decimal = valor_x.getText();
                    aux_field_decimal = borrarUltimoCaracter(aux_field_decimal);
                    valor_x.setText(aux_field_decimal);
                    valor_x.requestFocus();
                }
            }

            private String borrarUltimoCaracter(String str) {
                int cantidad = 1;
                int m = Math.max(0, str.length() - cantidad);
                return str.substring(0, str.length() - cantidad);
            }

            private void printIt(String title, KeyEvent keyEvent) {
                int keyCode = keyEvent.getKeyCode();
                // Si presiona el signo negativo
                if (keyCode == 45 || keyCode == 109) {
                    if (txt_field_decimal.length() > 0) {
                        return;
                    }
                }
                // Si presiona retroceso y la variable tiene algo
                if (keyCode == 8 && !txt_field_decimal.trim().equals("")) {
                    // Si la variable tiene tamaño 2 y contiene un negativo
                    if (txt_field_decimal.length() == 2 && txt_field_decimal.trim().contains("-")) {
                        limpiarCampos();
                        return;
                    }
                    txt_field_decimal = borrarUltimoCaracter(txt_field_decimal);
                    System.out.println("como queda al borrar el ultimo: " + txt_field_decimal);
                }
                // Si está digitando números o presiona retroceso
                if (keyCode == 45 || keyCode == 109 || (keyCode >= 48 && keyCode <= 57) || keyCode == 8 || keyCode == 46 || keyCode == 110) {
                    if (keyCode != 8) {
                        // Si digito un punto
                        if (keyCode == 46 || keyCode == 110) {
                            // Si no comienza con - y no contiene un . entonces entra aqui
                            if (!txt_field_decimal.contains("-")) {
                                txt_field_decimal += ".";
                            }
                            return;
                        }
                        // Si digitó el signo menos y no tiene un menos en la cadena
                        if (keyCode == 45 || keyCode == 109) {
                            if (!txt_field_decimal.contains("-")) {
                                txt_field_decimal += "-";
                                valor_x.setText("-");
                            }
                            return;
                        } else {
                            txt_field_decimal += KeyEvent.getKeyText(keyCode);
                        }
                    }
                    System.out.println("esto es lo que retorna: " + keyCode);
                    if (keyCode != 46) {//verificar el punto 
                    }
                }
            }
        };

        valor_x.addKeyListener(keyListenerDecimal);
    }

    public void limpiarCampos() {
        txt_field_decimal = "";
        valor_x.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        expresion_math = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        valor_x = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        resultado_field = new javax.swing.JTextField();
        calcular_btn = new javax.swing.JButton();
        limpiar_btn = new javax.swing.JButton();
        cerrar_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Método de Derivación");

        jLabel1.setText("Expresión Matemática F(x)");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("MÉTODO DE DERIVACIÓN");

        jLabel3.setText("Valor de x");

        valor_x.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                valor_xKeyReleased(evt);
            }
        });

        jLabel4.setText("Resultado de la derivada F'(x)");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addComponent(calcular_btn)
                            .addGap(30, 30, 30)
                            .addComponent(limpiar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(cerrar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(26, 26, 26)
                            .addComponent(resultado_field, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(expresion_math, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valor_x, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(expresion_math, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(valor_x, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(resultado_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calcular_btn)
                    .addComponent(limpiar_btn)
                    .addComponent(cerrar_btn))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrar_btnActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cerrar_btnActionPerformed

    private void limpiar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar_btnActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_limpiar_btnActionPerformed

    private void calcular_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcular_btnActionPerformed
        // TODO add your handling code here:
        calcular();
    }//GEN-LAST:event_calcular_btnActionPerformed

    private void valor_xKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valor_xKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_valor_xKeyReleased

    private void limpiar() {
        expresion_math.setText("");
        txt_field_decimal = "";
        valor_x.setText("");
        resultado_field.setText("");
        expresion_math.requestFocus();
    }

    public void calcular() {
        if (expresion_math.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe escribir la expresión matemática", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (valor_x.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe de indicar el valor de x que será evaluado en la expresión", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String expresion = expresion_math.getText();
        Derivada derivada = new Derivada(expresion);
        Double resultado = derivada.derivacionNumérica(Double.parseDouble(valor_x.getText()), 3);
        resultado_field.setText(resultado.toString());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calcular_btn;
    private javax.swing.JButton cerrar_btn;
    private javax.swing.JTextField expresion_math;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton limpiar_btn;
    private javax.swing.JTextField resultado_field;
    private javax.swing.JTextField valor_x;
    // End of variables declaration//GEN-END:variables
}
