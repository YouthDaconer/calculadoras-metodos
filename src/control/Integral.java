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
public class Integral {

    private Funcion f;//Evaluación de la función(altura)
    private Double delta;//bases
    private Double a, b;//Limite inferior y superior
    private Double[] xi;
    private int n;//Número de particiones
    private boolean cambiaSigno;

    //Constructores
    public Integral(Funcion f, Double a, Double b, int n) {
        this.f = f;
        this.a = a;
        this.b = b;
        this.n = n;
        this.delta = Math.abs(b - a) / n;
        basesXi();
        this.cambiaSigno = f.f(a) * f.f(b) < 0;

    }

    public Integral(String expresion, Double a, Double b, int n) {
        this.f = new Funcion(expresion);
        this.a = a;
        this.b = b;
        this.n = n;
        this.delta = (b - a) / n;
        basesXi();
        this.cambiaSigno = f.f(a) * f.f(b) < 0;

    }

    //----------------------------------
    //Inicializa las bases
    private void basesXi() {
        xi = new Double[n + 1];
        xi[0] = a;
        for (int i = 1; i <= n; i++) {
            xi[i] = a + delta * i;
        }
    }
    //-----------------------------

    //Getters and Setters
    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
        basesXi();
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
        basesXi();
    }

    public String getFuncion() {
        return f.getFuncion();
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public boolean cambiaDeSigno() {
        return cambiaSigno;
    }

    //retornara los xi*
    public Double[] getXprimas() {
        Double[] xPrimas = new Double[n];

        for (int i = 0; i < n; i++) {
            xPrimas[i] = (xi[i] + xi[i + 1]) / 2;
        }
        return xPrimas;
    }
    //---------------------------------------

    //Método de rectangulos izquierdo
    public Double rectanguloIzquierdo() {
        Double resultado = Double.NaN;
        try {
            if (!cambiaSigno) {
                resultado = 0.0;
                for (int i = 0; i < n; i++) {
                    resultado += f.f(xi[i]);
                }
                resultado = resultado * delta;
            }

        } catch (ArithmeticException e) {
            throw new ArithmeticException("No se pudo evaluar en un punto del intervalo :(\n" + e.getMessage());
        }
        return resultado;
    }
    //---------------------------------------

    //Método de rectangulos izquierdo
    public Double rectanguloDerecho() {
        Double resultado = Double.NaN;
        try {
            if (!cambiaSigno) {
                resultado = 0.0;
                for (int i = 1; i <= n; i++) {
                    resultado += f.f(xi[i]);
                }
                resultado = resultado * delta;
            }

        } catch (ArithmeticException e) {
            throw new ArithmeticException("No se pudo evaluar en un punto del intervalo :(\n" + e.getMessage());
        }
        return resultado;
    }
    //---------------------------------------

    //Método de rectangulos central
    public Double rectanguloCentral() {
        Double resultado = Double.NaN;
        Double[] xP = getXprimas();
        try {
            if (!cambiaSigno) {
                resultado = 0.0;
                for (int i = 0; i < n; i++) {
                    resultado += f.f(xP[i]);
                }
                resultado = resultado * delta;
            }

        } catch (ArithmeticException e) {
            throw new ArithmeticException("No se pudo evaluar en un punto del intervalo :(\n" + e.getMessage());
        }
        return resultado;
    }
    //---------------------------------------    

    //Méttodo del trapecio
    public Double trapecio() {
        Double resultado = Double.NaN;
        try {
            if (!cambiaSigno) {
                resultado = 0.0;
                for (int i = 0; i < n; i++) {
                    resultado += f.f(xi[i]) + f.f(xi[i + 1]);
                }
                resultado = resultado * (delta / 2);
            }

        } catch (ArithmeticException e) {
            throw new ArithmeticException("No se pudo evaluar en un punto del intervalo :(\n" + e.getMessage());
        }
        return resultado;
    }
    //------------------------------------

    //Pruebas
//    public static void main(String[] args) {
//        Integral i = new Integral("tan(x)", 0.0, 1.0, 100);
//        if (!i.cambiaDeSigno()) {
//            System.out.println("Los resultadoss de la integral de f(x)=" + i.getFuncion()
//                    + " Desde " + i.getA() + " Hasta " + i.getB() + " son:");
//            System.out.println("Con " + i.getN() + " rectángulos:");
//            System.out.println("Izquierdo:" + i.rectanguloIzquierdo());
//            System.out.println("Central:" + i.rectanguloCentral());
//            System.out.println("Derecho:" + i.rectanguloDerecho());
//            System.out.println("\nCon " + i.getN() + " trapecios:");
//            System.out.println("Trapecio:" + i.trapecio());
//        } else {
//            System.out.println("Existen cambios de signo para la integral de f(x)=" + i.getFuncion()
//                    + "Desde " + i.getA() + " Hasta " + i.getB());
//        }
//
//    }
    //------------------------

}
