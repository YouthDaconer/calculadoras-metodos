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
public class NewtonRaphson {

    //Atributos de clase
    private Funcion f;
    private Derivada d;
    private double xInicial, errorTol, error;
    private final int MAX_ITERACIONES = 200;
    private double iteraciones;
    private Object[] encabezados = {"Iteración",
        "Xn",
        "Imagen Xn",
        "Derivada Xn",
        "Xn+1",
        "Error relativo"};
    private ArrayList<Object[]> datos;
    //-----------------------

    //Constructores
    public NewtonRaphson(Funcion f) {
        this.f = f;
        this.d = new Derivada(f);
        this.errorTol = 1e-16;
        this.iteraciones = 0;
        this.error = 0;
        this.datos = new ArrayList<>();
    }

    public NewtonRaphson(String funcion) {
        this.f = new Funcion(funcion);
        this.d = new Derivada(funcion);
        this.iteraciones = 0;
        this.error = 0;
        this.errorTol = 1e-16;
        this.datos = new ArrayList<>();
    }

    public NewtonRaphson(String funcion, double error) {
        this.f = new Funcion(funcion);
        this.d = new Derivada(funcion);
        this.iteraciones = 0;
        this.error = 0;
        this.errorTol = error;
        this.datos = new ArrayList<>();
    }

    public NewtonRaphson(Funcion funcion, double error) {
        this.f = funcion;
        this.d = new Derivada(funcion);
        this.error = 0;
        this.iteraciones = 0;
        this.errorTol = error;
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

    //Método que calcula la raiz de la expresión por medio de Newton Raphson
    public double resolver(double x) {
        double raiz = Double.NaN;
        double xr = Double.NaN;

        try {

            double m = d.derivacionNumericaCentral(x, 20);
            double y0 = f.f(x);
            double x0 = x;

            int i = 0;
            String linea = "";//string que contendra la fila de valores
            Object[] fila;//recolectará los resultados de las variables
            do {
                xr = x0 - (y0 / m);
                error = Math.abs(xr - x0);//Cálculo el error
                i++;
                linea = i + "," + x0 + "," + y0 + "," + m + "," + xr + "," + error;//le doy formato a la fila
                fila = linea.split(",");//separo los valores y los fuardo en fila
                datos.add(fila);//Adiciona a la lista de datos

                //Cambio los valores para la siguiente iteración
                x0 = xr;
                y0 = f.f(x0);
                m = d.derivacionNumericaCentral(x0, 20);

            } while (i < MAX_ITERACIONES && error >= errorTol);
            iteraciones = i;//cantidad de iteraciones totales            
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Error no se pudo calcular la solución :(\n" + e.getMessage());
        }
        raiz = xr;
        return raiz;//Raiz calculada
    }
    //------------------------------------------

//    //    //pruebas    
//    public static void main(String[] args) {
//        NewtonRaphson n = new NewtonRaphson("x^2-4x+2");
//        System.out.println("raiz:"+n.resolver(3.14));
//        System.out.println("Proceso:");
//        n.getDatos().forEach((fila) -> {
//            for (Object dato : fila) {
//                System.out.print(dato + "\t");
//            }
//            System.out.print("\n");
//        });
//    }
////    //-------------------------------------
}
