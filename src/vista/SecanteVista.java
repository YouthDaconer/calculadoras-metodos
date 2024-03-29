package vista;

import control.Secante;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import modelo.ModeloTabla;

/**
 *
 * @author Carlos Caicedo
 */
public class SecanteVista extends javax.swing.JFrame {

    Secante sec;

    /**
     * Creates new form Biseccion
     */
    public SecanteVista() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        btnTabla.setEnabled(false);//Únicamente se habilita cuando se hace el cálculo
        expresion_math.requestFocus();
    }
    //-------------------------------------

    //Método que se llama después de oprimir calcular
    public void calcular() {
        String resultado = "NaN";
        try {
            String expresion = expresion_math.getText();
            Double x1 = Double.parseDouble(txt_limiteInferior.getText());
            Double x2 = Double.parseDouble(txt_limiteSuperior.getText());
            Double error = Double.parseDouble(txt_errorTolerado.getText());
            if (x1 >= x2 || error <= 0 || error >= 1) {// En caso de algun en el intervalo 0 con el error tolerado
                JOptionPane.showMessageDialog(this, "Asegúrate de que el intervalo esté bien y el valor del error sea > 0 y menor a 1", "Error :(", JOptionPane.ERROR_MESSAGE);
            } else {
                sec = new Secante(expresion, x1, x2, error);
                resultado = "" + sec.resolver();//calculamos
                if (resultado.equals("NaN")) {//error
                    JOptionPane.showMessageDialog(this, "No se pudo calcular la expresión", "Error :(", JOptionPane.ERROR_MESSAGE);// En caso de algun error
                } else {//ponemos los resultados
                    txt_resultado.setText(resultado);
                    txt_error.setText("" + sec.getError());
                    txt_iteraciones.setText("" + sec.getIteraciones());
                    btnTabla.setEnabled(true);//Habilitamos el botón de ver tabla
                }
            }
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error :(", JOptionPane.ERROR_MESSAGE);// En caso de algun error
        } catch (NumberFormatException es) {
            JOptionPane.showMessageDialog(this, "Verifique que todos los campos hayan sido llenados", "Error :(", JOptionPane.ERROR_MESSAGE);// En caso de algun error
        }

    }
    //------------------------

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTabla = new javax.swing.JButton();
        jLabelFx = new javax.swing.JLabel();
        jLabelBiseccion = new javax.swing.JLabel();
        expresion_math = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_errorTolerado = new javax.swing.JTextField();
        btn_calcular = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btn_cerrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_resultado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_error = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_iteraciones = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_limiteInferior = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_limiteSuperior = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Método de la Secante");

        btnTabla.setText("Ver tabla");
        btnTabla.setEnabled(false);
        btnTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTablaActionPerformed(evt);
            }
        });

        jLabelFx.setText("Expresión Matemática F(x):");

        jLabelBiseccion.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelBiseccion.setText("MÉTODO DE LA SECANTE");

        jLabel5.setText("Error de tolerancia:");

        txt_errorTolerado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_errorToleradoKeyTyped(evt);
            }
        });

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

        jLabel6.setText("Resultado:");

        txt_resultado.setEditable(false);

        jLabel7.setText("Error relativo err:");

        txt_error.setEditable(false);

        jLabel8.setText("Iteraciones   n");

        txt_iteraciones.setEditable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Intervalo"));

        jLabel3.setText("Desde (a):");

        txt_limiteInferior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_limiteInferiorActionPerformed(evt);
            }
        });
        txt_limiteInferior.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_limiteInferiorKeyTyped(evt);
            }
        });

        jLabel4.setText("Hasta (b):");

        txt_limiteSuperior.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_limiteSuperiorKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_limiteSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_limiteInferior, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txt_limiteInferior, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txt_limiteSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelFx)
                                .addGap(26, 26, 26)
                                .addComponent(expresion_math, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabelBiseccion, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(txt_errorTolerado, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_error, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_iteraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btn_calcular)
                                    .addGap(30, 30, 30)
                                    .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(32, 32, 32)
                                    .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txt_resultado, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(btnTabla)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabelBiseccion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFx)
                    .addComponent(expresion_math, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_errorTolerado, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_calcular)
                    .addComponent(btn_limpiar)
                    .addComponent(btn_cerrar))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_resultado, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_error, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_iteraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnTabla)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    //keyTypeds que controla que pone el usuario de entrada
    private void txt_limiteInferiorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_limiteInferiorKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE)
                || (c == KeyEvent.VK_PERIOD)
                || (c == KeyEvent.VK_MINUS))) {//que solo hacepte números, puntos, '-' y las teclas de borrado
            getToolkit().beep();
            evt.consume();//se elimina
        }
        if (c == KeyEvent.VK_PERIOD && txt_limiteInferior.getText().contains(".")) {//Si la caja de texto ya contiene un punto
            getToolkit().beep();
            evt.consume();//se elimina
        }

        if (c == KeyEvent.VK_MINUS && txt_limiteInferior.getText().contains("-")) {//Si la caja de texto ya contiene un '-'
            getToolkit().beep();
            evt.consume();//se elimina
        }
    }//GEN-LAST:event_txt_limiteInferiorKeyTyped

    private void txt_limiteSuperiorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_limiteSuperiorKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE)
                || (c == KeyEvent.VK_PERIOD)
                || (c == KeyEvent.VK_MINUS))) {//que solo hacepte números, puntos, '-' y las teclas de borrado
            getToolkit().beep();
            evt.consume();//se elimina
        }
        if (c == KeyEvent.VK_PERIOD && txt_limiteSuperior.getText().contains(".")) {//Si la caja de texto ya contiene un punto
            getToolkit().beep();
            evt.consume();//se elimina
        }

        if (c == KeyEvent.VK_MINUS && txt_limiteSuperior.getText().contains("-")) {//Si la caja de texto ya contiene un '-'
            getToolkit().beep();
            evt.consume();//se elimina
        }
    }//GEN-LAST:event_txt_limiteSuperiorKeyTyped

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
    //----------------------------------------------------------------

    //Al presionar este botón nos dirigiremos a la vista de la tabla del procedimiento del algoritmo
    private void btnTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTablaActionPerformed
        /* Cada clase de métodos tiene sus atributos con sus datos y encabezados que se
         crean después de hacer el procedimiento del cálculo respectivo*/
        ModeloTabla modelo = new ModeloTabla(sec.getEncabezados(), sec.getDatos());
        new TablaVista(modelo).setVisible(true);
    }//GEN-LAST:event_btnTablaActionPerformed

    private void txt_limiteInferiorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_limiteInferiorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_limiteInferiorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTabla;
    private javax.swing.JButton btn_calcular;
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_limpiar;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txt_error;
    private javax.swing.JTextField txt_errorTolerado;
    private javax.swing.JTextField txt_iteraciones;
    private javax.swing.JTextField txt_limiteInferior;
    private javax.swing.JTextField txt_limiteSuperior;
    private javax.swing.JTextField txt_resultado;
    // End of variables declaration//GEN-END:variables

}
