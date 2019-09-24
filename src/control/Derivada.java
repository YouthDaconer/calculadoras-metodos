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
public class Derivada {

    //Atributos de clase
    private Funcion f;
    private double h;
    //---------------------

    //constructor
    public Derivada(String funcion) {
        this.f = new Funcion(funcion);//Creo la función
        this.h = 1e-10;//Asigno un valor aproximado a cero        
    }
    //------------------------------

    //constructor sobre cargado
    public Derivada(Funcion f) {
        this.f = f;
        this.h = 1e-10;//Asigno un valor aproximado a cero        
    }
    //------------------------------

    //cambia la expresion de la funcion
    public void addFuncion(String expresion) {
        this.f = new Funcion(expresion);
    }
    //----------------------------------

    /*
     *método que calcula la derivada de la función en el punto x
     *por medio del método de derivación numerica
     **/
    public Double derivacionNumericaClasica(double x, int cifras) {

        Double resultado = Double.NaN;// no un valor numerico
        try {
            resultado = ((f.f(x + h) - f.f(x)) / h);//formula de derivación numérica
            resultado = f.redondeo(Double.toString(resultado), cifras);//redondeo a 5 cifras
        } catch (ArithmeticException e) {
            throw new ArithmeticException("No se pudo evaluar la derivada en el punto " + x);// en caso de que no se pueda hallar la derivada
        }
        return resultado;
    }
    //---------------------------------------

    /*
     *método que calcula la derivada central de la función en el punto x
     *por medio del método de derivación numerica central
     **/
    public Double derivacionNumericaCentral(double x, int cifras) {

        Double resultado = Double.NaN;// no un valor numerico
        h = 1e-10;
        try {
            resultado = ((f.f(x + h) - f.f(x - h)) / (2 * h));//formula de derivación numérica
            resultado = f.redondeo(Double.toString(resultado), cifras);//redondeo a 5 cifras
        } catch (ArithmeticException e) {
            throw new ArithmeticException("No se pudo evaluar la derivada en el punto " + x);// en caso de que no se pueda hallar la derivada
        }
        return resultado;
    }
    //---------------------------------------

    /*
     *método que calcula la derivada central de la función en el punto x
     *por medio del método de derivación numerica central
     **/
    public Double segundaDerivadaCentral(double x, int cifras) {

        Double resultado = Double.NaN;// no un valor numerico
        h = 1e-5;
        try {
            resultado = ((f.f(x + h) - (2 * f.f(x)) + f.f(x - h)) / Math.pow(h, 2));//formula de derivación numérica
            resultado = f.redondeo(Double.toString(resultado), cifras);//redondeo a 5 cifras
        } catch (ArithmeticException e) {
            throw new ArithmeticException("No se pudo evaluar la derivada en el punto " + x);// en caso de que no se pueda hallar la derivada
        }
        return resultado;
    }
    //---------------------------------------

    /*
     *método que calcula la derivada central de la función en el punto x
     *por medio del método de derivación numerica central
     **/
    public Double terceraDerivadaCentral(double x, int cifras) {

        Double resultado = Double.NaN;// no un valor numerico
        h = 1e-3;
        try {
            resultado = ((f.f(x + 2 * h) - 2*f.f(x + h) + 2 * f.f(x - h) - f.f(x - 2 * h)) / (2 * Math.pow(h, 3)));//formula de derivación numérica
            resultado = f.redondeo(Double.toString(resultado), cifras);//redondeo a 5 cifras
        } catch (ArithmeticException e) {
            throw new ArithmeticException("No se pudo evaluar la derivada en el punto " + x);// en caso de que no se pueda hallar la derivada
        }
        return resultado;
    }

    //---------------------------------------
    /*
     *método que calcula la derivada central de la función en el punto x
     *por medio del método de derivación numerica central
     **/
    public Double cuartaDerivadaCentral(double x, int cifras) {

        Double resultado = Double.NaN;// no un valor numerico
        h = 1e-2;
        try {
            resultado = (f.f(x + 2 * h) - (4 * f.f(x + h)) + 6 * f.f(x) - (4 * f.f(x - h)) + f.f(x - 2 * h)) / (Math.pow(h, 4));//formula de derivación numérica
            resultado = f.redondeo(Double.toString(resultado), cifras);//redondeo a 5 cifras
        } catch (ArithmeticException e) {
            throw new ArithmeticException("No se pudo evaluar la derivada en el punto " + x);// en caso de que no se pueda hallar la derivada
        }
        return resultado;
    }
    //---------------------------------------

    //pruebas
//    public static void main(String[] args) {
//        Derivada d = new Derivada("cos(x)+x^5");// expresion
//        System.out.println("derivada clasica: " + d.derivacionNumericaClasica(Math.PI, 10));
//        System.out.println("diferencia central: " + d.derivacionNumericaCentral(Math.PI, 10));
//        System.out.println("segunda derivada: " + d.segundaDerivadaCentral(Math.PI, 10));
//        System.out.println("tercera derivada: " + d.terceraDerivadaCentral(Math.PI, 10));
//        System.out.println("cuarta derivada: " + d.cuartaDerivadaCentral(Math.PI, 10));
//    }
    //-----------------------------------
}
