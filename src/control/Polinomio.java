package control;

import java.util.ArrayList;

/**
 *
 * @author JSRA
 */
public class Polinomio {

    private double[] coeficientes;
    private ArrayList<Character> exponentes = new ArrayList<>();
    private String expresion;
    private Graeffe g;

    public Polinomio(String expresion) {
        this.expresion = expresion.trim();
    }

    public String getExpresion() {
        return expresion;
    }

    private void coeficientes() {
        int cont = 0;
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < expresion.length(); i++) {
            if (expresion.charAt(i) == 'x') {
                lista.add(expresion.substring(cont, i));
                if (expresion.substring(i, i + 2).contains("x^")) {
                    exponentes.add(expresion.charAt(i + 2));
                    i = i + 2;
                    cont = i + 1;
                } else {
                    exponentes.add('1');
                    i++;
                    cont = i;
                }
            }

            if (expresion.charAt(i) == '+') {
                cont = i + 1;
            }
            if (expresion.charAt(i) == '-') {
                cont = i;
            }
            if (i == (expresion.length() - 1)) {
                lista.add(expresion.substring(cont, i + 1));
            }
        }

        if (!lista.isEmpty()) {
            coeficientes = new double[lista.size()];

            for (int i = 0; i < coeficientes.length; i++) {
                String numero = lista.get(i);
                coeficientes[i] = Double.parseDouble(numero);

            }
        }
    }

    public String getRaices() {
        g = new Graeffe(coeficientes);
        return g.getRaicesReales();
    }

    public String getRaicesComplejas() {
        g = new Graeffe(coeficientes);
        return g.getRaicesComplejas();
    }

    public static void main(String[] args) {
        Polinomio p = new Polinomio("3x^4-6.5x^3+8.96x^2-15.25x-9.45");
        p.coeficientes();
        System.out.println("Expresion: "+p.getExpresion()+"\nreales:\n"+p.getRaices() +"\ncomplejas:\n"+ p.getRaicesComplejas());
        
        Polinomio p2 = new Polinomio("-8.234x^3 -36.05x^2 +69.95x +19.56");
        p2.coeficientes();
        System.out.println("Expresion: "+p2.getExpresion()+"\nreales:\n"+p2.getRaices() +"\ncomplejas:\n"+ p2.getRaicesComplejas());
    }

}
