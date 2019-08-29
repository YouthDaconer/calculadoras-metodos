/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import modelo.Conversor.Decimal;
import modelo.Conversor.Binario;
import modelo.Conversor.Hexadecimal;
import modelo.Conversor.Octal;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Convertir extends javax.swing.JFrame {

    KeyListener keyListenerDecimal;
    KeyListener keyListenerBinario;
    KeyListener keyListenerOctal;
    KeyListener keyListenerHexadecimal;
    String txt_field_decimal = "";
    String txt_field_binario = "";
    String txt_field_octal = "";
    String txt_field_hexadecimal = "";

    /**
     * Creates new form Convertir
     */
    public Convertir() {
        initComponents();
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
                        aux_field_decimal = num_decimal.getText();
                        aux_field_decimal = borrarUltimoCaracter(aux_field_decimal);
                        num_decimal.setText(aux_field_decimal);
                        num_decimal.requestFocus();
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
                    aux_field_decimal = num_decimal.getText();
                    aux_field_decimal = borrarUltimoCaracter(aux_field_decimal);
                    num_decimal.setText(aux_field_decimal);
                    num_decimal.requestFocus();
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
                                num_decimal.setText("-");
                            }
                            return;
                        } else {
                            txt_field_decimal += KeyEvent.getKeyText(keyCode);
                        }
                    }
                    System.out.println("esto es lo que retorna: " + keyCode);
                    // Convertir a las demas bases
                    Decimal baseDecimal = new Decimal();
                    if (keyCode != 46) {//verificar el punto 
                        // Conversión a binario
                        txt_field_binario = baseDecimal.cambiarABase(txt_field_decimal, 2, 10);
                        num_binario.setText(txt_field_binario);
                        // Conversión a octal
                        txt_field_octal = baseDecimal.cambiarABase(txt_field_decimal, 8, 10);
                        num_octal.setText(txt_field_octal);
                        // Conversión a hexadecimal
                        txt_field_hexadecimal = baseDecimal.cambiarABase(txt_field_decimal, 16, 10);
                        num_hexadecimal.setText(txt_field_hexadecimal);
                    }
                }
            }
        };

        /* Eventos de conversión desde binario */
        keyListenerBinario = new KeyListener() {
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
                String aux_field_binario = "";
                // Si solto .
                if (keyCode == 46 || keyCode == 110) {
                    int count = 0;
                    char c = '.';
                    for (int i = 0; i < txt_field_binario.trim().length(); i++) {
                        if (txt_field_binario.trim().charAt(i) == c) {
                            count++;
                        }
                    }
                    if (count > 1) {
                        aux_field_binario = num_binario.getText();
                        aux_field_binario = borrarUltimoCaracter(aux_field_binario);
                        num_binario.setText(aux_field_binario);
                        num_binario.requestFocus();
                        txt_field_binario = borrarUltimoCaracter(txt_field_binario);
                        return;
                    }
                    if (txt_field_binario.trim().equals(".")) {
                        limpiarCampos();
                        return;
                    }
                    if (!txt_field_binario.contains("-")) {
                        return;
                    }
                }
                // Si solto -
                if (keyCode == 45 || keyCode == 109) {
                    if (txt_field_binario.length() < 0) {
                        return;
                    }
                }
                // Si lo que digitó no es un número, no la tecla enter o no es la tecla retroceso
                if (!(keyCode >= 48 && keyCode <= 49) && keyCode != 10 && keyCode != 8) {
                    aux_field_binario = num_binario.getText();
                    aux_field_binario = borrarUltimoCaracter(aux_field_binario);
                    num_binario.setText(aux_field_binario);
                    num_binario.requestFocus();
                }
            }

            private String borrarUltimoCaracter(String str) {
                int cantidad = 1;
                int m = Math.max(0, str.length() - cantidad);
                return str.substring(0, str.length() - cantidad);
            }

            private void printIt(String title, KeyEvent keyEvent) {
                int keyCode = keyEvent.getKeyCode();
                // Si presiona retroceso
                if (keyCode == 8 && !txt_field_binario.trim().equals("")) {
                    // Si la variable tiene tamaño 2 y contiene un negativo
                    if (txt_field_binario.length() == 2 && txt_field_binario.trim().contains("-")) {
                        limpiarCampos();
                        return;
                    }
                    txt_field_binario = borrarUltimoCaracter(txt_field_binario);
                    System.out.println("como queda al borrar el ultimo: " + txt_field_binario);
                }
                // Si está digitando números o presiona retroceso
                if (keyCode == 45 || keyCode == 109 || (keyCode >= 48 && keyCode <= 49) || keyCode == 8 || keyCode == 46 || keyCode == 110) {
                    if (keyCode != 8) {
                        // Si digito un punto
                        if (keyCode == 46 || keyCode == 110) {
                            // Si no comienza con - y no contiene un . entonces entra aqui
                            if (!txt_field_binario.contains("-")) {
                                txt_field_binario += ".";
                            }
                            return;
                        }
                        // Si digitó el signo menos y no tiene un menos en la cadena
                        if (keyCode == 45 || keyCode == 109) {
                            if (!txt_field_binario.contains("-")) {
                                txt_field_binario += "-";
                                num_binario.setText("-");
                            }
                            return;
                        } else {
                            txt_field_binario += KeyEvent.getKeyText(keyCode);
                        }
                    }
                    System.out.println("esto es lo que retorna: " + keyCode);
                    // Convertir a las demas bases
                    Binario baseBinario = new Binario();
                    if (keyCode != 46) {//verificar el punto 
                        // Conversión a decimal
                        txt_field_decimal = baseBinario.cambiarABase(txt_field_binario, 10, 10);
                        num_decimal.setText(txt_field_decimal);
                        // Conversión a octal
                        txt_field_octal = baseBinario.cambiarABase(txt_field_binario, 8, 10);
                        num_octal.setText(txt_field_octal);
                        // Conversión a hexadecimal
                        txt_field_hexadecimal = baseBinario.cambiarABase(txt_field_binario, 16, 10);
                        num_hexadecimal.setText(txt_field_hexadecimal);
                    }
                }
            }
        };

        /* Eventos de conversión desde octal */
        keyListenerOctal = new KeyListener() {
            public void keyPressed(KeyEvent keyEvent) {
                printIt("Pressed", keyEvent);
            }

            public void keyReleased(KeyEvent keyEvent) {
                borrarCampo(keyEvent);
            }

            public void keyTyped(KeyEvent keyEvent) {
            }

            private void borrarCampo(KeyEvent keyEvent) {
                int keyCode = keyEvent.getKeyCode();
                String aux_field_octal = "";
                // Si solto .
                if (keyCode == 46 || keyCode == 110) {
                    int count = 0;
                    char c = '.';
                    for (int i = 0; i < txt_field_octal.trim().length(); i++) {
                        if (txt_field_octal.trim().charAt(i) == c) {
                            count++;
                        }
                    }
                    if (count > 1) {
                        aux_field_octal = num_octal.getText();
                        aux_field_octal = borrarUltimoCaracter(aux_field_octal);
                        num_octal.setText(aux_field_octal);
                        num_octal.requestFocus();
                        txt_field_octal = borrarUltimoCaracter(txt_field_octal);
                        return;
                    }
                    if (txt_field_octal.trim().equals(".")) {
                        limpiarCampos();
                        return;
                    }
                    if (!txt_field_octal.contains("-")) {
                        return;
                    }
                }
                // Si solto -
                if (keyCode == 45 || keyCode == 109) {
                    if (txt_field_octal.length() < 0) {
                        return;
                    }
                }
                // Si lo que digitó no es un número, no la tecla enter o no es la tecla retroceso
                if (!(keyCode >= 48 && keyCode <= 55) && keyCode != 10 && keyCode != 8) {
                    aux_field_octal = num_octal.getText();
                    aux_field_octal = borrarUltimoCaracter(aux_field_octal);
                    num_octal.setText(aux_field_octal);
                    num_octal.requestFocus();
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
                    if (txt_field_octal.length() > 0) {
                        return;
                    }
                }
                // Si presiona retroceso y la variable tiene algo
                if (keyCode == 8 && !txt_field_octal.trim().equals("")) {
                    // Si la variable tiene tamaño 2 y contiene un negativo
                    if (txt_field_octal.length() == 2 && txt_field_octal.trim().contains("-")) {
                        limpiarCampos();
                        return;
                    }
                    txt_field_octal = borrarUltimoCaracter(txt_field_octal);
                    System.out.println("como queda al borrar el ultimo: " + txt_field_octal);
                }
                // Si está digitando números o presiona retroceso
                if (keyCode == 45 || keyCode == 109 || (keyCode >= 48 && keyCode <= 55) || keyCode == 8 || keyCode == 46 || keyCode == 110) {
                    if (keyCode != 8) {
                        // Si digito un punto
                        if (keyCode == 46 || keyCode == 110) {
                            // Si no comienza con - y no contiene un . entonces entra aqui
                            if (!txt_field_octal.contains("-")) {
                                txt_field_octal += ".";
                            }
                            return;
                        }
                        // Si digitó el signo menos y no tiene un menos en la cadena
                        if (keyCode == 45 || keyCode == 109) {
                            if (!txt_field_octal.contains("-")) {
                                txt_field_octal += "-";
                                num_octal.setText("-");
                            }
                            return;
                        } else {
                            txt_field_octal += KeyEvent.getKeyText(keyCode);
                        }
                    }
                    System.out.println("esto es lo que retorna: " + keyCode);
                    // Convertir a las demas bases
                    Octal baseOctal = new Octal();
                    // Conversión a decimal
                    txt_field_decimal = baseOctal.cambiarABase(txt_field_octal, 10, 10);
                    num_decimal.setText(txt_field_decimal);
                    // Conversión a binario
                    txt_field_binario = baseOctal.cambiarABase(txt_field_octal, 2, 10);
                    num_binario.setText(txt_field_binario);
                    // Conversión a hexadecimal
                    txt_field_hexadecimal = baseOctal.cambiarABase(txt_field_octal, 16, 10);
                    num_hexadecimal.setText(txt_field_hexadecimal);
                }
            }
        };

        /* Eventos de conversión desde hexadecimal */
        keyListenerHexadecimal = new KeyListener() {
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
                String aux_field_hexadecimal = "";
                // Si solto .
                if (keyCode == 46 || keyCode == 110) {
                    int count = 0;
                    char c = '.';
                    for (int i = 0; i < txt_field_hexadecimal.trim().length(); i++) {
                        if (txt_field_hexadecimal.trim().charAt(i) == c) {
                            count++;
                        }
                    }
                    if (count > 1) {
                        aux_field_hexadecimal = num_hexadecimal.getText();
                        aux_field_hexadecimal = borrarUltimoCaracter(aux_field_hexadecimal);
                        num_hexadecimal.setText(aux_field_hexadecimal);
                        num_hexadecimal.requestFocus();
                        txt_field_hexadecimal = borrarUltimoCaracter(txt_field_hexadecimal);
                        return;
                    }
                    if (txt_field_hexadecimal.trim().equals(".")) {
                        limpiarCampos();
                        return;
                    }
                    if (!txt_field_hexadecimal.contains("-")) {
                        return;
                    }
                }
                // Si solto -
                if (keyCode == 45 || keyCode == 109) {
                    if (txt_field_hexadecimal.length() < 0) {
                        return;
                    }
                }
                // Si lo que digitó no es un número, no la tecla enter o no es la tecla retroceso (Excluyo los códigos de las letras desde el 58 hasta el 64)
                if (!(keyCode >= 48 && keyCode <= 70)
                        && !(keyCode >= 65 && keyCode <= 70) && (keyCode != 10 && keyCode != 8)) {
                    aux_field_hexadecimal = num_hexadecimal.getText();
                    aux_field_hexadecimal = borrarUltimoCaracter(aux_field_hexadecimal);
                    num_hexadecimal.setText(aux_field_hexadecimal);
                    num_hexadecimal.requestFocus();
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
                    if (txt_field_hexadecimal.length() > 0) {
                        return;
                    }
                }
                // Si presiona retroceso y la variable tiene algo
                if (keyCode == 8 && !txt_field_hexadecimal.trim().equals("")) {
                    // Si la variable tiene tamaño 2 y contiene un negativo
                    if (txt_field_hexadecimal.length() == 2 && txt_field_hexadecimal.trim().contains("-")) {
                        limpiarCampos();
                        return;
                    }
                    txt_field_hexadecimal = borrarUltimoCaracter(txt_field_hexadecimal);
                    System.out.println("como queda al borrar el ultimo: " + txt_field_hexadecimal);
                }
                // Si está digitando números o presiona retroceso (Excluyo los códigos de las letras desde el 58 hasta el 64)
                if (keyCode == 45 || keyCode == 109 || (keyCode >= 48 && keyCode <= 70 && keyCode != 58 && keyCode != 59 && keyCode != 60 && keyCode != 61 && keyCode != 62 && keyCode != 63 && keyCode != 64) || keyCode == 8 || keyCode == 46 || keyCode == 110) {
                    if (keyCode != 8) {
                        // Si digito un punto
                        if (keyCode == 46 || keyCode == 110) {
                            // Si no comienza con - y no contiene un . entonces entra aqui
                            if (!txt_field_hexadecimal.contains("-")) {
                                txt_field_hexadecimal += ".";
                            }
                            return;
                        }
                        // Si digitó el signo menos y no tiene un menos en la cadena
                        if (keyCode == 45 || keyCode == 109) {
                            if (!txt_field_hexadecimal.contains("-")) {
                                txt_field_hexadecimal += "-";
                                num_hexadecimal.setText("-");
                            }
                            return;
                        } else {
                            txt_field_hexadecimal += KeyEvent.getKeyText(keyCode);
                        }
                    }
                    System.out.println("esto es lo que retorna: " + keyCode);
                    // Convertir a las demas bases
                    Hexadecimal baseHexadecimal = new Hexadecimal();
                    // Conversión a decimal
                    txt_field_decimal = baseHexadecimal.cambiarABase(txt_field_hexadecimal, 10, 10);
                    num_decimal.setText(txt_field_decimal);
                    // Conversión a binario
                    txt_field_binario = baseHexadecimal.cambiarABase(txt_field_hexadecimal, 2, 10);
                    num_binario.setText(txt_field_binario);
                    // Conversión a octal
                    txt_field_octal = baseHexadecimal.cambiarABase(txt_field_hexadecimal, 8, 10);
                    num_octal.setText(txt_field_octal);
                }
            }
        };

        num_decimal.addKeyListener(keyListenerDecimal);
        num_binario.addKeyListener(keyListenerBinario);
        num_octal.addKeyListener(keyListenerOctal);
        num_hexadecimal.addKeyListener(keyListenerHexadecimal);
    }//fin constructor

    public void limpiarCampos() {
        txt_field_decimal = "";
        txt_field_binario = "";
        txt_field_octal = "";
        txt_field_hexadecimal = "";
        num_decimal.setText("");
        num_binario.setText("");
        num_octal.setText("");
        num_hexadecimal.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        num_decimal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        num_binario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        num_octal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        num_hexadecimal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Conversor de Bases");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("CONVERSOR DE NÚMEROS A DIFERENTES BASES");

        jLabel5.setText("Número decimal:");

        jLabel6.setText("Número binario:");

        jLabel7.setText("Número octal:");

        jLabel8.setText("Número hexadecimal:");

        num_hexadecimal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLabel5)
                                .addGap(44, 44, 44)
                                .addComponent(num_decimal, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLabel6)
                                .addGap(50, 50, 50)
                                .addComponent(num_binario, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLabel7)
                                .addGap(61, 61, 61)
                                .addComponent(num_octal, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(num_hexadecimal, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 25, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(num_decimal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(num_binario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(num_octal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(num_hexadecimal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField num_binario;
    private javax.swing.JTextField num_decimal;
    private javax.swing.JTextField num_hexadecimal;
    private javax.swing.JTextField num_octal;
    // End of variables declaration//GEN-END:variables
}
