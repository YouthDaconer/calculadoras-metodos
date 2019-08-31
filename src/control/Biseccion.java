/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;

/**
 *
 * @author JSRA
 */
public class Biseccion {

    //Atributos de clase
    private double a, b, errorTolerado, error;
    private int iteraciones, maxIteraciones;
    private Funcion f;
    private Object[] encabezados = {"Iteración",
        "Extremo\ninferior",
        "Extremo\nsuperior",
        "Imagen\nExt. inferior",
        "Imagen\nExt. superior",
        "Raiz",
        "Imagen\nraiz",
        "Error relativo"};
    private ArrayList<Object[]> datos;
    //------------------------------------

    //Constructores
    public Biseccion(String expresion, double a, double b, double error) {
        this.a = a;
        this.b = b;
        this.errorTolerado = error;
        iteraciones = 0;
        this.error = 0;
        maxIteraciones = 200;
        f = new Funcion(expresion);
        this.datos = new ArrayList<>();
    }

    public Biseccion(String expresion, double a, double b, double error, int maxIteraciones) {
        this.a = a;
        this.b = b;
        this.errorTolerado = error;
        this.iteraciones = 0;
        this.error = 0;
        this.maxIteraciones = maxIteraciones;
        this.f = new Funcion(expresion);
        this.datos = new ArrayList<>();
    }

    public Biseccion(double a, double b, double error, int maxIteraciones, Funcion f) {
        this.a = a;
        this.b = b;
        this.errorTolerado = error;
        this.iteraciones = 0;
        this.error = 0;
        this.maxIteraciones = maxIteraciones;
        this.f = f;
        this.datos = new ArrayList<>();
    }
    //-----------------------------

    //Getters and Setters
    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getErrorTolerado() {
        return errorTolerado;
    }

    public double getError() {
        return error;
    }

    public int getIteraciones() {
        return iteraciones;
    }

    public int getMaxIteraciones() {
        return maxIteraciones;
    }

    public String getF() {
        return f.getFuncion();
    }

    public void setF(String f) {
        this.f = new Funcion(f);
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setErrorTolerado(double errorTolerado) {
        this.errorTolerado = errorTolerado;
    }

    public void setMaxIteraciones(int maxIteraciones) {
        this.maxIteraciones = maxIteraciones;
    }

    public Object[] getEncabezados() {
        return encabezados;
    }

    public ArrayList<Object[]> getDatos() {
        return datos;
    }
    //--------------------------------------

    public double resolver() {
        double raiz = Double.NaN;
        double a1, b1, r, auxR;
        double fa, fb, fr;
        a1 = this.a;
        b1 = this.b;
        fa = f.f(a1);
        fb = f.f(b1);
        auxR = a;
        if (fa * fb < 0) {// para verificar que existe una solución en el intervalo (a, b)
            int i = 0;
            String linea = "";//string que contendra la fila de valores
            Object[] fila;//recolectará los resultados de las variables
            do {

                r = prom(a1, b1);
                fa = f.f(a1);
                fb = f.f(b1);
                fr = f.f(r);
                error = Math.abs((auxR - r));//Cálculo del error
                i++;

                linea = i + "," + a1 + "," + b1 + "," + fa + "," + fb + "," + r + "," + fr + "," + error;//le doy formato a la fila
                fila = linea.split(",");//separo los valores y los fuardo en fila
                datos.add(fila);//Adiciona a la lista de datos

                if (fr == 0) {
                    error = 0.0;
                    iteraciones = i;
                    return r;//dio una raiz exacta
                }

                //Cambio los valores para la siguiente iteración
                if (fa * fr < 0) {
                    b1 = r;
                } else {
                    a1 = r;
                }
                auxR = r;

            } while (i <= maxIteraciones && error >= errorTolerado);
            raiz = r;
            iteraciones = i;
        }

        return raiz;
    }

    private double prom(double a, double b) {
        return (a + b) / 2;
    }

    /*public static void main(String[] args) {
        
        Biseccion b = new Biseccion("sin(x)", 2, 3, 1e-12);
        System.out.println("raiz = "+ b.biseccion()+"\niteraciones:"+b.getIteraciones());
    }*/
}
