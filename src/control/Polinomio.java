package control;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
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
    private boolean factorizable;
    //-----------------------

    /**
     * Constructor
     *
     * @param expresion polinomica
     * @throws java.lang.Exception
     */
    public Polinomio(String expresion) throws Exception {
        this.expresion = quitaEspacios(expresion);
        this.factorizable = false;
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
        if (factorizable) {
            return g.getRaicesReales(factorizable);
        } else {
            return g.getRaicesReales();
        }
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
            comprobarTerminos();//Comprobamos que Términos hacen falta
            coeficientes = new double[lista.size()];  //creamos el arreglo de coeficientes    
            for (int i = 0; i < lista.size(); i++) {
                coeficientes[i] = lista.get(i).getCoeficiente();//agregamos los coeficientes
            }
            arreglaExpresion();
        }
    }
    //---------------------------------------

    /**
     * Comprueba si hace falta un termino en la lista y lo pone con coeficiente
     * 0
     *
     */
    public void comprobarTerminos() {
        Collections.sort(lista, Collections.reverseOrder());//Ordenamos el polinomio de acuerdo de menor a mayor   
        int exp1 = lista.get(0).getExponente();
        int exp2;

        if (exp1 != 0) {//Si no existe el término independiente y una de las soluciones es x = 0
            factorizable = true;
        }
        for (int i = 0; i < lista.size() - 1; i++) {
            exp1 = lista.get(i).getExponente() + 1;//Sacamos el exponente correspondiente con + 1 para comparar con el siguiente
            exp2 = lista.get(i + 1).getExponente();//Sacamos el siguiente
            if (exp1 != exp2) {//Si no son iguales falta un Termino
                lista.add(i + 1, new Termino(exp1));//Adicionamos a una lista temporal con coeficiente cero( ver constructor de Termino)             
            }
        }
        Collections.sort(lista);//Ordenamos el polinomio de mayor a menor 
    }
    //-------------------------------------------
    
    

    /**
     * Arregla la expresión en cadena
     *
     */
    public void arreglaExpresion() {
        expresion = "";
        lista.forEach((termino) -> {//Re escribo el polinomio ordenado
            if (Math.abs(termino.getCoeficiente()) == 1 && termino.getExponente() == 1) {
                if (termino.getCoeficiente() < 0 ) {
                    expresion += "-x +";
                }else{
                    expresion += "x +";
                }                
            } else {
                if (Math.abs(termino.getCoeficiente()) > 0 && termino.getExponente() > 1) {
                    expresion += termino.getCoeficiente() + "x^" + termino.getExponente() + " +";
                } else {
                    if (Math.abs(termino.getCoeficiente()) > 0 && termino.getExponente() == 0) {
                        expresion += termino.getCoeficiente();
                    } else {
                        if (Math.abs(termino.getCoeficiente()) > 0 && termino.getExponente() == 1) {
                            expresion += termino.getCoeficiente() + "x +";
                        }
                    }
                }
            }
        });
        expresion = quitaEspacios(expresion.replace("+-", "-"));//quito espacios y reemplazo(+-)
    }
    //-------------------------------------------

    /**
     * Quita los espacios de un String
     *
     * @param cadena aquitarle espacios
     * @return cadena sin espacios
     */
    public static String quitaEspacios(String cadena) {
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
     * Arregla la expresión en cadena
     *
     * @param lista
     * @return 
     */
    public static String construirExpresion(ArrayList<Termino> lista) {
        String expr = "";
        lista.sort(null);
        BigDecimal bd;
        String coef;
        for (Termino termino : lista) {//Re escribo el polinomio ordenado
            if (Math.abs(termino.getCoeficiente()) == 1 && termino.getExponente() == 1) {
                if (termino.getCoeficiente() < 0 ) {
                    expr += "-x +";
                }else{
                    expr += "x +";
                }                
            } else {
                bd = new BigDecimal(termino.getCoeficiente());
                bd= bd.setScale(10, BigDecimal.ROUND_HALF_UP);
                coef =bd.toPlainString();
                if (Math.abs(termino.getCoeficiente()) > 0 && termino.getExponente() > 1) {    
                    
                    expr += coef + "x^" + termino.getExponente() + " +";
                } else {
                    if (Math.abs(termino.getCoeficiente()) > 0 && termino.getExponente() == 0) {
                        expr += coef;
                    } else {
                        if (Math.abs(termino.getCoeficiente()) > 0 && termino.getExponente() == 1) {
                            expr += coef + "x +";
                        }
                    }
                }
            }
        }        
        return quitaEspacios(expr.replace("+-", "-"));//quito espacios y reemplazo(+-)
    }
    //-------------------------------------------

    

//    //Pruebas
//    public static void main(String[] args) throws Exception {
////        Polinomio p = new Polinomio("3x^4-6.5x^3+8.96x^2-15.25x-9.45");
////        System.out.println("Expresion: " + p.getExpresion() + "\nreales:\n" + p.getRaices() + "\ncomplejas:\n" + p.getRaicesComplejas());
////        Polinomio p2 = new Polinomio("-8.234x^3 -36.05x^2 +69.95x +19.56");
////        System.out.println("Expresion: "+p2.getExpresion()+"\nreales:\n"+p2.getRaices() +"\ncomplejas:\n"+ p2.getRaicesComplejas());
////        Polinomio p3 = new Polinomio("19.56-36.05x^2 -8.234x^3 +69.95x");
////        System.out.println("Expresion: " + p3.getExpresion() + "\nreales:\n" + p3.getRaices() + "\ncomplejas:\n" + p3.getRaicesComplejas());
////        Polinomio p4 = new Polinomio("3x^4-6.5x^3+8.96x^2+1");
////        System.out.println("Expresion: " + p4.getExpresion() + "\nreales:\n" + p4.getRaices() + "\ncomplejas:\n" + p4.getRaicesComplejas());
//    }
//    //-------------------------------------
}
