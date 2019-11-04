/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Random;

/**
 *
 * @author JSRA
 */
public class Integral {

    private Funcion f;//Evaluación de la función(altura)
    private Double delta;//bases
    private Double a, b;//Limite inferior y superior
    private Double[] xi;
    private int n;//Número de particiones o puntos para montecarlo
    private boolean cambiaSigno;//Determina si cambia de signo en el intervalo
    private Double m;//punto medio
    private Double error;//error calculado
    private Double random;//valor que guardará un x aleatorio perteneciente [a,b]
    private int puntos;// Número de puntos (Montecarlo)

    //Constructores
    public Integral(Funcion f, Double a, Double b, int n) {
        this.f = f;
        this.a = a;
        this.b = b;
        this.n = n;
        this.m = (a + b) / 2;
        this.delta = Math.abs(b - a) / n;
        this.error = 0.0;
        this.random = getRandom();
        basesXi();
        this.cambiaSigno = f.f(a) * f.f(b) < 0;

    }

    public Integral(String expresion, Double a, Double b, int n) {
        this.f = new Funcion(expresion);
        this.a = a;
        this.b = b;
        this.n = n;
        this.m = (a + b) / 2;
        this.delta = Math.abs(b - a) / n;
        this.error = 0.0;
        this.random = getRandom();
        basesXi();
        this.cambiaSigno = f.f(a) * f.f(b) < 0;
    }

    public Integral(String expresion, Double a, Double b) {
        this.f = new Funcion(expresion);
        this.a = a;
        this.b = b;
        this.n = 10000;
        this.m = (a + b) / 2;
        this.delta = Math.abs(b - a) / n;
        this.error = 0.0;
        this.random = getRandom();
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
    public Double getMax() {// retorna el indice del xi con mayor altura
        int i = 0;
        double max = 0;
        double fTemp;
        for (i = 0; i <= n; i++) {
            fTemp = Math.abs(f.f(xi[i]));
            if (fTemp > max) {
                max = fTemp;
            }
        }
        return max;
    }

    public Double getA() {
        return a;
    }

    public Double getRandom() {
        return a + (b - a) * new Random().nextDouble();
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

    public Double getError() {
        return error;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    //---------------------------------------
    //Método de rectangulos izquierdo
    public Double rectanguloIzquierdo() {
        Double resultado = Double.NaN;
        try {

            resultado = 0.0;
            for (int i = 0; i < n; i++) {
                resultado += f.f(xi[i]);
            }
            resultado = resultado * delta;

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

            resultado = 0.0;
            for (int i = 1; i <= n; i++) {
                resultado += f.f(xi[i]);
            }
            resultado = resultado * delta;

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

            resultado = 0.0;
            for (int i = 0; i < n; i++) {
                resultado += f.f(xP[i]);
            }
            resultado = resultado * delta;

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

            resultado = 0.0;
            for (int i = 0; i < n; i++) {
                resultado += f.f(xi[i]) + f.f(xi[i + 1]);
            }
            resultado = resultado * (delta / 2);

            error = Math.abs(-Math.pow((b - a), 3) / (12 * (Math.pow(n, 2))) * new Derivada(getFuncion()).segundaDerivadaCentral(random, 100));

        } catch (ArithmeticException e) {
            throw new ArithmeticException("No se pudo evaluar en un punto del intervalo :(\n" + e.getMessage());
        }
        return resultado;
    }
    //------------------------------------

    //Método Simson1/3
    public Double simpson13() {
        Double resultado = Double.NaN;
        try {

            double impares = 0;
            double pares = 0;
            if (n % 2 != 0) {//verfificar la cantidad de particiones(siempre debe ser par)
                n++;
                delta = (b - a) / n;
                basesXi();
            }
            int i;
            for (i = 1; i < n; i += 2) {//sumo los impares
                impares += f.f(xi[i]);
            }
            impares *= 4;

            for (i = 2; i < n - 1; i += 2) {//sumo los pares
                pares += f.f(xi[i]);
            }
            pares *= 2;
            resultado = (f.f(a) + pares + impares + f.f(b)) * (delta / 3);

            error = Math.abs((b - a) * (Math.pow(delta, 4) / 180) * new Derivada(getFuncion()).cuartaDerivadaCentral(random, 100));

        } catch (ArithmeticException e) {
            throw new ArithmeticException("No se pudo evaluar en un punto del intervalo :(\n" + e.getMessage());
        }
        return resultado;
    }
    //--------------------------------------

    //Método Simson3/8
    public Double simpson38() {
        Double resultado = Double.NaN;
        try {

            if (n % 3 != 0) {//n tiene que ser multiplo de 3
                while (n % 3 != 0) {
                    n++;
                }
                delta = (b - a) / n;
                basesXi();
            }
            //divido los tres grupos
            double grupo_1 = 0;
            double grupo_2 = 0;
            double grupo_3 = 0;
            int i;
            //sumo los grupos independientemente
            for (i = 1; i < n - 1; i += 3) {
                grupo_1 += f.f(xi[i]);
            }
            grupo_1 *= 3;

            for (i = 2; i < n; i += 3) {
                grupo_2 += f.f(xi[i]);
            }
            grupo_2 *= 3;

            for (i = 3; i < n - 2; i += 3) {
                grupo_3 += f.f(xi[i]);
            }
            grupo_3 *= 2;

            resultado = (f.f(a) + grupo_1 + grupo_2 + grupo_3 + f.f(b)) * (3 * delta / 8);//fórmula                
            error = Math.abs((n / 80) * Math.pow(delta, 5) * new Derivada(getFuncion()).cuartaDerivadaCentral(random, 100));//error del cálculo

        } catch (ArithmeticException e) {
            throw new ArithmeticException("No se pudo evaluar en un punto del intervalo :(\n" + e.getMessage());
        }
        return resultado;
    }
    //--------------------------------------

    /**
     * Método montecarlo
     *
     *
     * @param puntos de prueba
     * @return el resultado aproximado de la integral desde (a,b) por montecarlo
     */
    public Double monteCarlo(int puntos) {
        Double resultado = Double.NaN;

        try {

            int N = 0;
            double max = getMax();
            double xRandom;
            double yRandom;
            this.puntos = puntos;

            for (int i = 0; i < puntos; i++) {
                xRandom = getRandom();
                yRandom = max * Math.random();
                if (yRandom <= f.f(xRandom)) {
                    N++;
                }
            }
            resultado = (b - a) * max * ((double) N / (double) puntos);

        } catch (ArithmeticException e) {
            throw new ArithmeticException("No se pudo evaluar en un punto del intervalo :(\n" + e.getMessage());
        }
        return resultado;
    }
    //--------------------------------------    

//    //Pruebas
//    public static void main(String[] args) {
//        Integral i = new Integral("(sin(sqrt(x)+5) * e^sqrt(x)) / sqrt(x)", Math.PI, Math.PI + 2, 1000);
//        if (i.cambiaDeSigno()) {
//            System.out.println("Existen cambios de signo para la integral de f(x)=" + i.getFuncion()
//                    + "Desde " + i.getA() + " Hasta " + i.getB());
//
//        }
//        System.out.println("Los resultadoss de la integral de f(x)=" + i.getFuncion()
//                + " Desde " + i.getA() + " Hasta " + i.getB() + " son:");
//        System.out.println("Con " + i.getN() + " rectángulos:");
//        System.out.println("Izquierdo: " + i.rectanguloIzquierdo());
//        System.out.println("Central: " + i.rectanguloCentral());
//        System.out.println("Derecho: " + i.rectanguloDerecho());
//        System.out.println("\nCon " + i.getN() + " trapecios:");
//        System.out.println("Trapecio: " + i.trapecio() + " +-  el Error: " + i.getError());
//
//        System.out.println("\nMontecarlo: " + i.monteCarlo(1000) + " con " + i.getPuntos() + " puntos");
//        System.out.println("\nRegla Simpson con " + i.getN() + " particiones:");
//        System.out.println("Simpson 1/3: " + i.simpson13() + " +-  el Error: " + i.getError());
//        System.out.println("Simpson 3/8: " + i.simpson38() + " +-  el Error: " + i.getError());
//    }
//    //------------------------
}
