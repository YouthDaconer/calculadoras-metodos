/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 * Clase encargada de la comparación de terminos del polinomio
 *
 * @author JSRA
 *
 */
public class Termino implements Comparable<Termino> {

    private Object coeficiente, exponente;

    //Constructores
    public Termino() {
        this.coeficiente = "0";
        this.exponente = 0;
    }

    public Termino(Object exponente) {
        this.coeficiente = "0";
        this.exponente = exponente;
    }

    public Termino(Object coeficiente, Object exponente) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
    }
    //----------------------------------------

    public double getCoeficiente() {
        return Double.parseDouble(coeficiente.toString());
    }

    public void setCoeficiente(Object coeficiente) {
        this.coeficiente = coeficiente;
    }

    public int getExponente() throws NumberFormatException {
        return Integer.parseInt(exponente.toString());
    }

    public void setExponente(Object exponente) {
        this.exponente = exponente;
    }

    @Override
    public int compareTo(Termino t) {
        if (t.getExponente() < getExponente()) {
            return -1;
        } else if (t.getExponente() < getExponente()) {
            return 0;
        } else {
            return 1;
        }
    }
    
    

}
