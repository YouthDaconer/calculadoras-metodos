/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ReglaFalsa;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author carlo
 */
public class ReglaFalsaVista extends javax.swing.JFrame {

    KeyListener keyListenerIntInicial;
    KeyListener keyListenerIntFinal;
    String txt_field_int_inicial = "";
    String txt_field_int_final = "";

    /**
     * Creates new form ReglaFalsa
     */
    public ReglaFalsaVista() {
        initComponents();
        resultado_txt.setEditable(false);
        this.setLocationRelativeTo(null);

        /* Eventos de conversión desde decimal */
        keyListenerIntInicial = new KeyListener() {
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
                    for (int i = 0; i < txt_field_int_inicial.trim().length(); i++) {
                        if (txt_field_int_inicial.trim().charAt(i) == c) {
                            count++;
                        }
                    }
                    if (count > 1) {
                        aux_field_decimal = int_inicial.getText();
                        aux_field_decimal = borrarUltimoCaracter(aux_field_decimal);
                        int_inicial.setText(aux_field_decimal);
                        int_inicial.requestFocus();
                        txt_field_int_inicial = borrarUltimoCaracter(txt_field_int_inicial);
                        return;
                    }
                    if (txt_field_int_inicial.trim().equals(".")) {
                        limpiar();
                        return;
                    }
                    if (!txt_field_int_inicial.contains("-")) {
                        return;
                    }
                }
                // Si solto -
                if (keyCode == 45 || keyCode == 109) {
                    if (txt_field_int_inicial.length() < 0) {
                        return;
                    }
                }
                // Si lo que digitó no es un número, no la tecla enter o no es la tecla retroceso
                if (!(keyCode >= 48 && keyCode <= 57) && keyCode != 10 && keyCode != 8) {
                    aux_field_decimal = int_inicial.getText();
                    aux_field_decimal = borrarUltimoCaracter(aux_field_decimal);
                    int_inicial.setText(aux_field_decimal);
                    int_inicial.requestFocus();
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
                    if (txt_field_int_inicial.length() > 0) {
                        return;
                    }
                }
                // Si presiona retroceso y la variable tiene algo
                if (keyCode == 8 && !txt_field_int_inicial.trim().equals("")) {
                    // Si la variable tiene tamaño 2 y contiene un negativo
                    if (txt_field_int_inicial.length() == 2 && txt_field_int_inicial.trim().contains("-")) {
                        limpiar();
                        return;
                    }
                    txt_field_int_inicial = borrarUltimoCaracter(txt_field_int_inicial);
                    System.out.println("como queda al borrar el ultimo: " + txt_field_int_inicial);
                }
                // Si está digitando números o presiona retroceso
                if (keyCode == 45 || keyCode == 109 || (keyCode >= 48 && keyCode <= 57) || keyCode == 8 || keyCode == 46 || keyCode == 110) {
                    if (keyCode != 8) {
                        // Si digito un punto
                        if (keyCode == 46 || keyCode == 110) {
                            // Si no comienza con - y no contiene un . entonces entra aqui
                            if (!txt_field_int_inicial.contains("-")) {
                                txt_field_int_inicial += ".";
                            }
                            return;
                        }
                        // Si digitó el signo menos y no tiene un menos en la cadena
                        if (keyCode == 45 || keyCode == 109) {
                            if (!txt_field_int_inicial.contains("-")) {
                                txt_field_int_inicial += "-";
                                int_inicial.setText("-");
                            }
                            return;
                        } else {
                            txt_field_int_inicial += KeyEvent.getKeyText(keyCode);
                        }
                    }
                    System.out.println("esto es lo que retorna: " + keyCode);
                    if (keyCode != 46) {//verificar el punto 
                    }
                }
            }
        };

        int_inicial.addKeyListener(keyListenerIntInicial);

        /* Eventos de conversión desde decimal */
        keyListenerIntFinal = new KeyListener() {
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
                    for (int i = 0; i < txt_field_int_final.trim().length(); i++) {
                        if (txt_field_int_final.trim().charAt(i) == c) {
                            count++;
                        }
                    }
                    if (count > 1) {
                        aux_field_decimal = int_final.getText();
                        aux_field_decimal = borrarUltimoCaracter(aux_field_decimal);
                        int_final.setText(aux_field_decimal);
                        int_final.requestFocus();
                        txt_field_int_final = borrarUltimoCaracter(txt_field_int_final);
                        return;
                    }
                    if (txt_field_int_final.trim().equals(".")) {
                        limpiar();
                        return;
                    }
                    if (!txt_field_int_final.contains("-")) {
                        return;
                    }
                }
                // Si solto -
                if (keyCode == 45 || keyCode == 109) {
                    if (txt_field_int_final.length() < 0) {
                        return;
                    }
                }
                // Si lo que digitó no es un número, no la tecla enter o no es la tecla retroceso
                if (!(keyCode >= 48 && keyCode <= 57) && keyCode != 10 && keyCode != 8) {
                    aux_field_decimal = int_final.getText();
                    aux_field_decimal = borrarUltimoCaracter(aux_field_decimal);
                    int_final.setText(aux_field_decimal);
                    int_final.requestFocus();
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
                    if (txt_field_int_final.length() > 0) {
                        return;
                    }
                }
                // Si presiona retroceso y la variable tiene algo
                if (keyCode == 8 && !txt_field_int_final.trim().equals("")) {
                    // Si la variable tiene tamaño 2 y contiene un negativo
                    if (txt_field_int_final.length() == 2 && txt_field_int_final.trim().contains("-")) {
                        limpiar();
                        return;
                    }
                    txt_field_int_final = borrarUltimoCaracter(txt_field_int_final);
                    System.out.println("como queda al borrar el ultimo: " + txt_field_int_final);
                }
                // Si está digitando números o presiona retroceso
                if (keyCode == 45 || keyCode == 109 || (keyCode >= 48 && keyCode <= 57) || keyCode == 8 || keyCode == 46 || keyCode == 110) {
                    if (keyCode != 8) {
                        // Si digito un punto
                        if (keyCode == 46 || keyCode == 110) {
                            // Si no comienza con - y no contiene un . entonces entra aqui
                            if (!txt_field_int_final.contains("-")) {
                                txt_field_int_final += ".";
                            }
                            return;
                        }
                        // Si digitó el signo menos y no tiene un menos en la cadena
                        if (keyCode == 45 || keyCode == 109) {
                            if (!txt_field_int_final.contains("-")) {
                                txt_field_int_final += "-";
                                int_final.setText("-");
                            }
                            return;
                        } else {
                            txt_field_int_final += KeyEvent.getKeyText(keyCode);
                        }
                    }
                    System.out.println("esto es lo que retorna: " + keyCode);
                    if (keyCode != 46) {//verificar el punto 
                    }
                }
            }
        };

        int_final.addKeyListener(keyListenerIntFinal);
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
        jLabel6 = new javax.swing.JLabel();
        num_iteraciones = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        resultado_txt = new javax.swing.JTextField();
        calcular_btn = new javax.swing.JButton();
        limpiar_btn = new javax.swing.JButton();
        cerrar_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Regla Falsa");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("MÉTODO DE REGLA FALSA");

        jLabel2.setText("Función f(x):");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Intervalo"));

        jLabel3.setText("Desde (a)");

        jLabel4.setText("Hasta (b)");

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

        jLabel6.setText("Número de Iteraciones:");

        jLabel7.setText("Resultado:");

        resultado_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultado_txtActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(74, 74, 74))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(calcular_btn)
                        .addGap(30, 30, 30)
                        .addComponent(limpiar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(cerrar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(34, 34, 34)
                                .addComponent(regla_falsa_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(error_tolerancia, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(num_iteraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(resultado_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(regla_falsa_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(error_tolerancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(num_iteraciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(resultado_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calcular_btn)
                    .addComponent(limpiar_btn)
                    .addComponent(cerrar_btn))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resultado_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultado_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resultado_txtActionPerformed

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

    private void limpiar() {
        txt_field_int_final = "";
        txt_field_int_inicial = "";
        regla_falsa_txt.setText("");
        int_inicial.setText("");
        int_final.setText("");
        error_tolerancia.setText("");
        resultado_txt.setText("");
        num_iteraciones.setText("");
        regla_falsa_txt.requestFocus();
    }

    private void calcular() {
        ReglaFalsa regla_falsa = new ReglaFalsa(regla_falsa_txt.getText(),Double.parseDouble(int_inicial.getText()) ,Double.parseDouble(int_final.getText()) , Double.parseDouble(error_tolerancia.getText()));
        double resultado = regla_falsa.resolver();
        resultado_txt.setText(""+resultado);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton limpiar_btn;
    private javax.swing.JTextField num_iteraciones;
    private javax.swing.JTextField regla_falsa_txt;
    private javax.swing.JTextField resultado_txt;
    // End of variables declaration//GEN-END:variables
}
