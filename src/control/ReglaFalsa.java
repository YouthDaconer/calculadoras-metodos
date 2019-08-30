/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.math.BigDecimal;

/**
 *
 * @author JSRA
 */
public class ReglaFalsa {

    //Atributos de clase
    private Funcion f;
    private double err;
    private int maxIteraciones, iteraciones;
    private String cadena;
    //-----------------------------------

    //Constructores
    public ReglaFalsa(Funcion f, double err, int maxIteraciones) {
        this.f = f;
        this.err = err;
        this.maxIteraciones = maxIteraciones;
        this.iteraciones = 0;
        this.cadena = "";
    }

    public ReglaFalsa(String expresion, double err, int maxIteraciones) {
        this.f = new Funcion(expresion);
        this.err = err;
        this.maxIteraciones = maxIteraciones;
        this.iteraciones = 0;
        this.cadena = "";
    }
    
    public ReglaFalsa(String expresion, double err) {
        this.f = new Funcion(expresion);
        this.err = err;
        this.maxIteraciones = 100;
        this.iteraciones = 0;
        this.cadena = "";
    }
    
    public ReglaFalsa(String expresion) {
        this.f = new Funcion(expresion);
        this.err = 1e-12;
        this.maxIteraciones = 100;
        this.iteraciones = 0;
        this.cadena = "";
    }
    //----------------------------------------------

    //Métodos get and set
    public String getF() {
        return f.getFuncion();
    }

    public void setF(String f) {
        this.f = new Funcion(f);
    }

    public void setErr(double err) {
        this.err = err;
    }

    public int getIteraciones() {
        return iteraciones;
    }

    public String getProceso() {
        return cadena;
    }
    //--------------------------------        

    //Método que da la solución
    public String resolver(double x1, double x2) {

        int numDec = 5;

        double x3, y3;
        double xp = x1;
        double y1 = f.f(x1);
        double y2 = f.f(x2);

        //Valores iniciales
        cadena += (" x1 = " + round(x1, numDec) + "\n");
        cadena += (" x2 = " + round(x2, numDec)) + "\n";
        cadena += (" y1: f.f(" + x1 + ")= " + round(y1, numDec) + "\n");
        cadena += (" y2: f.f(" + x2 + ")= " + round(y2, numDec) + "\n");

        for (int i = 1; i <= maxIteraciones; i++) {
            cadena += ("Iteración #" + i + "\n");
            if ((y2 - y1) == 0) {
                cadena += ("Error: no converge x=NaN; iteración=" + i + "\n");
                return "NaN";
            }

            x3 = (y2 * x1 - y1 * x2) / (y2 - y1);
            cadena += (" x3 = (y2*x1-y1*x2)/(y2-y1)" + "\n");
            cadena += (" x3 = ((" + round(y2, numDec) + ")*(" + round(x1, numDec) + ")-(" + round(y1, numDec) + ")*(" + round(x2, numDec) + "))/((" + round(y2, numDec) + ")-(" + round(y1, numDec) + ")) = " + round(x3, numDec) + "\n");

            cadena += ("Error |" + round(xp, numDec) + "/" + round(x3, numDec) + "-1|<" + round(err, numDec) + "  " + (Math.abs(xp / x3 - 1) < err) + "\n");
            if (Math.abs(xp / x3 - 1) < err) {
                cadena += (round(Math.abs(xp / x3 - 1), numDec) + "<" + round(err, numDec) + " -> termina programa" + "\n");
                iteraciones = i;
                return String.valueOf(x3);
            }

            y3 = f.f(x3);

            cadena += (" y1 = " + round(y1, numDec) + "\n");
            cadena += (" y3 = fx(x3) = fx(" + round(x3, numDec) + ") = " + round(y3, numDec) + "\n");
            cadena += (" y1*y3 < 0 " + (y1 * y3 < 0) + "\n");
            if (y1 * y3 < 0) {
                cadena += ("   x2=x3=" + round(x3, numDec) + "\n");
                cadena += ("   y2=y3=" + round(y3, numDec) + "\n");
                x2 = x3;
                y2 = y3;
            } else {
                cadena += ("   x1=x3=" + round(x3, numDec) + "\n");
                cadena += ("   y1=y3=" + round(y3, numDec) + "\n");
                x1 = x3;
                y1 = y3;
            }
            iteraciones = i;
            xp = x3;
        }
        return "" + xp;

    }

    private String round(double num, int numDec) {
        BigDecimal bd = new BigDecimal(num);
        bd = bd.setScale(numDec, BigDecimal.ROUND_HALF_UP);
        return bd.toString();
    }

    //pruebas
//    public static void main(String[] args) {
//        ReglaFalsa r = new ReglaFalsa("e^(x^2)+e^x-4", 1e-10, 10);
//        System.out.println("La solución por regla falsa es:"+r.resolver(0, 1));
//        System.out.println("Iteraciones:"+ r.getIteraciones());
//        System.out.println("proceso:\n"+ r.getProceso());
//    }
    //--------------------------------
}
