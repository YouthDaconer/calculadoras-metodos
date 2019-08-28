/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author JSRA
 */
public class Biseccion {

    private double a, b, errorTolerado, error;
    private int iteraciones, maxIteraciones;
    private Funcion f;

    //Constructores
    public Biseccion(String expresion, double a, double b, double error) {
        this.a = a;
        this.b = b;
        this.errorTolerado = error;
        iteraciones = 0;
        this.error=0;
        maxIteraciones = 200;
        f = new Funcion(expresion);
    }

    public Biseccion(String expresion, double a, double b, double error, int maxIteraciones) {
        this.a = a;
        this.b = b;
        this.errorTolerado = error;
        this.iteraciones = 0;
        this.error=0;
        this.maxIteraciones = maxIteraciones;
        this.f = new Funcion(expresion);
    }

    public Biseccion(double a, double b, double error, int maxIteraciones, Funcion f) {
        this.a = a;
        this.b = b;
        this.errorTolerado = error;
        this.iteraciones = 0;
        this.error=0;
        this.maxIteraciones = maxIteraciones;
        this.f = f;
    }
    //-----------------------------

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

    public Funcion getF() {
        return f;
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
    
    

    public double biseccion() {
        double solucion = Double.NaN;        
        if (!(f.f(a) * f.f(b) < 0)) {
            double a1, b1, s1, s2;
            double fa ,fb, fs;
            a1 = this.a;
            b1 = this.b;
            int i = 0;
            do{
                s1 = prom(a1, b1);
                fa = f.f(a1);
                fb = f.f(b1);
                fs = f.f(s1);
                
                if (fs == 0) {
                    return s1;
                }
                if (fa * fs < 0) {
                    b1 = s1;                    
                }else{
                    a1 = s1;
                } 
                s2 = prom(a1, b1);                
                i++;
                error = Math.abs(s1-s2)/s2;
                
                fs = f.f(s2);
                solucion = s2;
            }while(i <= maxIteraciones && error>=errorTolerado);          
            
            iteraciones=i;
        }

        return solucion;
    }

    private double prom(double a, double b) {
        return (a + b) / 2;
    }

    public static void main(String[] args) {
        
        Biseccion b = new Biseccion("sin(x)", 2, 3, 1e-12);
        System.out.println("raiz = "+ b.biseccion()+"\niteraciones:"+b.getIteraciones());
    }
}
