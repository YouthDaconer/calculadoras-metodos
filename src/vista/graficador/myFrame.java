package vista.graficador;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import modelo.GraficadorClasico;

public class myFrame extends JFrame {

    JPanel aaa;

    public myFrame() {
        setSize(900, 690);//500,350
        setTitle("interfaz grafica");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        Container Contenedor = getContentPane();
        GraficadorClasico mipanel = new GraficadorClasico(Contenedor);
        this.add(mipanel);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
}
