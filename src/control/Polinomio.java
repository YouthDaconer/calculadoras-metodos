package control;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author JSRA
 */
public class Polinomio {

    //Atributos de clase
    private ArrayList<Termino> lista;
    private double[] coeficientes;
    private String expresion;
    private Graeffe g;
    //-----------------------

    /**
     * Constructor
     *
     * @param expresion polinomica
     * @throws java.lang.Exception
     */
    public Polinomio(String expresion) throws Exception {
        this.expresion = quitaEspacios(expresion);
        lista = new ArrayList<>();
        try {
            leerPolinomio();
        } catch (Exception e) {
            throw new Exception("No se pudo calcular los coeficientes del polinomio :(");
        }
    }
    //------------------------------------------------

    //getters and setters
    public String getRaices() {
        g = new Graeffe(coeficientes);
        return g.getRaicesReales();
    }

    public String getRaicesComplejas() {
        g = new Graeffe(coeficientes);
        return g.getRaicesComplejas();
    }

    public String getExpresion() {
        return expresion;
    }

    public double[] getCoeficientes() {
        return coeficientes;
    }

    public void setCoeficientes(double[] coeficientes) {
        this.coeficientes = coeficientes;
    }
    //-----------------------------

    /**
     * Método que lee el polinomio y lo organiza
     */
    private void leerPolinomio() {
        String polynomial = expresion;
        polynomial = polynomial.replace("-", "+-");//para poder separar los terminos depues con '+'
        String[] terminos = polynomial.split("\\+");//los terminos los separo con el '+'
        for (String termino : terminos) {//recorro cada termino
            Termino t = new Termino();//Creo un objeto tipo Termino
            if (!termino.equals("")) {
                if (termino.contains("x")) {//Si el termino contiene x
                    if (termino.charAt(0) == 'x') {//Si el primer caracter es x entonces el coeficiente es 1
                        t.setCoeficiente("1");
                        if (termino.contains("x^")) {//Si tiene exponente
                            t.setExponente(termino.charAt(termino.length() - 1));//agrego el exponente
                        } else {//si no tiene, el exponente es 1
                            t.setExponente(1);
                        }
                    } else {//Si tiene coeficiente
                        if (termino.charAt(0) == '-' && termino.charAt(1) == 'x') {//Si el primer caracter es un menos y el segundo es x
                            //entonces el coeficiente es -1
                            t.setCoeficiente(-1);
                            if (termino.contains("x^")) {//si tiene exponente
                                t.setExponente(termino.charAt(termino.length() - 1));//agrego el exponente
                            } else {//si no tiene, el exponente es 1
                                t.setExponente(1);
                            }
                        } else {//si tiene coeficiente normal
                            int i = 0;
                            while (i < termino.length()) {//recorro el termino
                                if (termino.charAt(i) == 'x') {//encuentro la x
                                    t.setCoeficiente(termino.substring(0, i));//saco el coeficiente
                                    if (termino.contains("x^")) {//si tiene exponente
                                        t.setExponente(termino.charAt(termino.length() - 1));//agrego el exponente
                                    } else {//si no tiene, el exponente es 1
                                        t.setExponente(1);
                                    }
                                }
                                i++;
                            }
                        }
                    }
                } else {//Solo hay que adicionar el número y su exponente es 0
                    t.setCoeficiente(termino);
                    t.setExponente(0);
                }
                lista.add(t);//Adicionamos a la lista de terminos
            }

        }
        if (!lista.isEmpty()) {//si la lista no está vacia
            coeficientes = new double[lista.size()];  //creamos el arreglo de coeficientes                           
            Collections.sort(lista);//Ordenamos el polinomio de acuerdo a los exponentes de los términos            
            for (int i = 0; i < lista.size(); i++) {
                coeficientes[i] = lista.get(i).getCoeficiente();//agregamos los coeficientes
            }

            expresion = "";
            lista.forEach((termino) -> {//Re escribo el polinomio ordenado
                if (Math.abs(termino.getCoeficiente()) == 1 && termino.getExponente() == 1) {
                    expresion += "x +";
                } else {
                    if (Math.abs(termino.getCoeficiente()) > 1 && termino.getExponente() > 1) {
                        expresion += termino.getCoeficiente() + "x^" + termino.getExponente() + " +";
                    } else {
                        if (Math.abs(termino.getCoeficiente()) > 1 && termino.getExponente() == 0) {
                            expresion += termino.getCoeficiente();
                        } else {
                            if (Math.abs(termino.getCoeficiente()) > 1 && termino.getExponente() == 1) {
                                expresion += termino.getCoeficiente() + "x +";
                            }
                        }
                    }
                }
            });
            expresion = quitaEspacios(expresion.replace("+-", "-"));//quito espacios y reemplazo(+-)

        }
    }
    //---------------------------------------

    /**
     * Quita los espacios de un String
     *
     * @param cadena aquitarle espacios
     * @return cadena sin espacios
     */
    private String quitaEspacios(String cadena) {
        String unspacedString = "";	//Variable donde lee la función
        for (int i = 0; i < cadena.length(); i++) {	//Le quita los espacios a la espresión que leyó
            //Si el caracter no es un espacio lo pone, sino lo quita.
            if (cadena.charAt(i) != ' ') {
                unspacedString += cadena.charAt(i);
            }
        }
        return unspacedString;
    }
    //------------------------------------

    /**
     * Clase encargada de la comparación de terminos del polinomio
     *
     * @author JSRA
     *
     */
    private class Termino implements Comparable<Termino> {

        private Object coeficiente, exponente;

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

    //Pruebas
//    public static void main(String[] args) throws Exception {
////        Polinomio p = new Polinomio("3x^4-6.5x^3+8.96x^2-15.25x-9.45");
////        System.out.println("Expresion: "+p.getExpresion()+"\nreales:\n"+p.getRaices() +"\ncomplejas:\n"+ p.getRaicesComplejas());     
////        Polinomio p2 = new Polinomio("-8.234x^3 -36.05x^2 +69.95x +19.56");
////        System.out.println("Expresion: "+p2.getExpresion()+"\nreales:\n"+p2.getRaices() +"\ncomplejas:\n"+ p2.getRaicesComplejas());
////        Polinomio p3 = new Polinomio("19.56-36.05x^2 -8.234x^3 +69.95x");
////        System.out.println("Expresion: " + p3.getExpresion() + "\nreales:\n" + p3.getRaices() + "\ncomplejas:\n" + p3.getRaicesComplejas());
//    }
    //-------------------------------------

}
