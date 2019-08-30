/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;

/**
 *
 * @author salas
 */
public class Secante {

    //Atributos de clase
    private Funcion f;
    private double xInicial, errorTol, error;
    private final int MAX_ITERACIONES = 200;
    private double iteraciones;
    private Object[] encabezados = {"Iteración", "X0", "X1", "Xr", "error",};
    private ArrayList<Object[]> datos;
    //-----------------------

    //Constructores
    public Secante(Funcion f) {
        this.f = f;        
        this.errorTol = 1e-10;
        this.iteraciones = 0;
        this.error = 0;
        this.datos = new ArrayList<>();
    }

    public Secante(String funcion) {
        this.f = new Funcion(funcion);        
        this.iteraciones = 0;
        this.error = 0;
        this.errorTol = 1e-10;
        this.datos = new ArrayList<>();
    }
    //--------------------------

    //Getters and setters
    public String getF() {
        return f.getFuncion();
    }

    public void setF(String f) {
        this.f = new Funcion(f);
    }

    public double getIteraciones() {
        return iteraciones;
    }

    public double getXInicial() {
        return xInicial;
    }

    public void setXInicial(double x) {
        this.xInicial = x;
    }

    public double getError() {
        return error;
    }

    public Object[] getEncabezados() {
        return encabezados;
    }

    public ArrayList<Object[]> getDatos() {
        return datos;
    }
    //------------------------------

    //resuleve por el método de la secante
    public double resolver(double x1, double x2) {
        double x3, fx1, fx2, fx3;
        x3 = Double.NaN;

        try {
            if (Math.abs(f.f(x1)) < Math.abs(f.f(x2))) {// para ordenar los números
                double aux = x1;
                x1 = x2;
                x2 = aux;
            }

            fx1 = f.f(x1);
            fx2 = f.f(x2);
            int i = 0;
            String linea = "";//string que contendra la fila de valores
            Object[] fila;//recolectará los resultados de las variables
            do {
                x3 = x2 - (fx2 * (x1 - x2)) / (fx1 - fx2);//fórmula de la secante aproximada
                fx3 = f.f(x3);
                error = Math.abs(fx3);//Cálculo del error
                i++;
                linea = i + "," + x1 + "," + x2 + "," + x3 + "," + error;//le doy formato a la fila
                fila = linea.split(",");//separo los valores y los fuardo en fila
                datos.add(fila);//Adiciona a la lista de datos

                //Cambio los valores para la siguiente iteración
                x1 = x2;
                x2 = x3;
                fx1 = f.f(x1);
                fx2 = f.f(x2);

            } while (i < MAX_ITERACIONES && error >= errorTol);
            iteraciones = i;//cantidad de iteraciones totales
        } catch (ArithmeticException e) {
            throw new ArithmeticException("No se pudo aproximar la raiz de la expresión :(\n" + e.getMessage());
        }

        return x3;//Raiz aproximada
    }
    //------------------------------------------

//    //pruebas    
//    public static void main(String[] args) {
//        Secante s = new Secante("x^3+2x^2+10x-20");
//        System.out.println(s.resolver(0, 1));
//        System.out.println("Proceso:");
//        s.getDatos().forEach((fila) -> {
//            for (Object dato : fila) {
//                System.out.print(dato + "\t");
//            }
//            System.out.print("\n");
//        });
//    }
//    //-------------------------------------
}
