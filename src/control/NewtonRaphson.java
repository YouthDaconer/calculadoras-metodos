/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author salas
 */
public class NewtonRaphson {

    //Atributos de clase
    private Funcion f;
    private Derivada d;
    private double xInicial, errorTol, error;
    private final double MAX_ITERACIONES = 200;
    private double iteraciones;
    //-----------------------

    //Constructores
    public NewtonRaphson(Funcion f) {
        this.f = f;
        this.d = new Derivada(f);
        this.errorTol = 1e-10;
        this.iteraciones = 0;
        this.error = 0;
    }

    public NewtonRaphson(String funcion) {
        this.f = new Funcion(funcion);
        this.d = new Derivada(funcion);
        this.iteraciones = 0;
        this.error = 0;
        this.errorTol = 1e-10;
    }

    public NewtonRaphson(String funcion, double error) {
        this.f = new Funcion(funcion);
        this.d = new Derivada(funcion);
        this.iteraciones = 0;
        this.error = 0;
        this.errorTol = error;
    }

    public NewtonRaphson(Funcion funcion, double error) {
        this.f = funcion;
        this.d = new Derivada(funcion);
        this.error = 0;
        this.iteraciones = 0;
        this.errorTol = error;
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
    //------------------------------

    public double resolver(double x) {
        double xr = Double.NaN;
        try {

            double m = d.derivacionNumericaCentral(x, 8);
            double y0 = f.f(x);
            double x0 = x;

            int i = 0;
            do {
                xr = x0 - (y0 / m);
                error = Math.abs(xr - x0) / Math.abs(xr);

                if (error >= errorTol) {
                    x0 = xr;
                    y0 = f.f(x0);
                    m = d.derivacionNumericaCentral(x0, 8);
                }
                i++;
            } while (i <= MAX_ITERACIONES && error >= errorTol);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Error no se pudo calcular la solución :(\n"+ e.getMessage());
        }

        return xr;
    }

}
