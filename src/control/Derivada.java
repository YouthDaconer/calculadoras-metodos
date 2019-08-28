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
    private final double h;
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
    public Double derivacionNumérica(double x, int cifras) {

        Double resultado = Double.NaN;// no un valor numerico
        try {
            resultado = ((f.f(x + h) - f.f(x)) / h);//formula de derivación numérica
            resultado = f.redondeo(Double.toString(resultado),cifras);//redondeo a 5 cifras
        } catch (ArithmeticException e) {
            throw new ArithmeticException("No se pudo evaluar la derivada en el punto " + x);// en caso de que no se pueda hallar la derivada
        }
        return resultado;
    }
    //---------------------------------------

//    //pruebas
//    public static void main(String[] args) {
//        Derivada d = new Derivada("5x^2");// expresion
//        System.out.println("resultado: " + d.derivacionNumérica(2, 5));
//    }
//    //-----------------------------------
}
