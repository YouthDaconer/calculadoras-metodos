package control;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author JSRA
 */
public class AjusteCurva {

    //Atributos de clase
    private Double[] x, y;
    private final int N;
    private final Double MEDIA;
    private Matriz m;
    private String polinomio;
    private ArrayList<Termino> terminos;
    //----------------------------

    /**
     *
     * @param x xi de la tabla
     * @param y yi de la tabla
     */
    public AjusteCurva(Double[] x, Double[] y) {
        this.N = y.length;
        this.x = x;
        this.y = y;
        this.polinomio = "";
        this.m = new Matriz();
        this.MEDIA = sumatoria(y, 1) / N;

    }

    /**
     *
     * @return La expresión ajustada
     */
    public String getPolinomio() {
        return polinomio;
    }

    public Double getMEDIA() {
        return MEDIA;
    }

    /**
     *
     * @return los coeficientes del polinomio
     */
    public Double[] getCoeficientes() {
        return m.metodoGaussJordan();
    }

    public Double coeficienteCorrelacion() {
        Double res;
        Double num = 0.0;
        Double den = 0.0;
        Funcion f = new Funcion(polinomio);
        for (int i = 0; i < N; i++) {
            num += Math.pow(f.f(x[i]) - MEDIA, 2);
            den += Math.pow(y[i] - MEDIA, 2);
        }
        res = num / den;

        return res;
    }

    /**
     *
     * @param grado grado al que se ajustará el polinomio
     * @param decimales decimales a redondear los coeficientes
     */
    private void ajustePolinomico(int grado, int decimales) throws Exception {
        int tam = grado + 1;
        Double[] soluciones = new Double[tam];
        Double[][] matriz = new Double[tam][tam];
        terminos = new ArrayList<>();
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                matriz[i][j] = sumatoria(x, j + i);
            }
            soluciones[i] = sumatoriaxy(i);
        }

        m.setMatriz(matriz);
        m.setSoluciones(soluciones);

        Double[] res = m.metodoGaussJordan();

        for (int i = 0; i < tam; i++) {
            terminos.add(new Termino(Funcion.redondeo(res[i] + "", decimales), i));
        }

        polinomio = Polinomio.construirExpresion(terminos);
    }

    /**
     *
     * @param arr lista de números a sumar
     * @param exp si hay exponente lo aplica a cada termino
     * @return sumatoria
     */
    private Double sumatoria(Double[] arr, int exp) {
        Double total = 0.0;
        if (exp == 0) {
            return N + 0.0;
        } else {
            for (Double xi : arr) {
                total += Math.pow(xi, exp);
            }
        }
        return total;
    }

    /**
     *
     * @param exp le pone un exponente a cada xi
     * @return sumatoria(xi^exp*yi)
     */
    private Double sumatoriaxy(int exp) {
        Double total = 0.0;
        if (exp == 0) {
            for (Double elm : y) {
                total += elm;
            }
        } else {
            for (int i = 0; i < x.length; i++) {
                total += Math.pow(x[i], exp) * y[i];
            }
        }
        return total;
    }

    //Pruebas
    public static void main(String[] args) throws Exception {
//        Double[] xi = {1.13,1.15,1.25,1.07,1.19,1.18};
//        Double[] yi = {2.75,3.02,3.15,3.3,2.95,3.29};
        
        Double[] xi ={10.0,12.0,9.0,27.0,47.0,112.0,36.0,241.0,59.0,167.0};
        Double[] yi ={9.0,14.0,7.0,29.0,45.0,109.0,40.0,238.0,60.0,170.0};
        
        System.out.println("X[i]:"+ Arrays.toString(xi));
        System.out.println("Y[i]:"+ Arrays.toString(yi));
        AjusteCurva aj = new AjusteCurva(xi, yi);
        System.out.println("Empezando ajustes...");
        for (int i = 1; i <= 6; i++) {
            aj.ajustePolinomico(i, 11);
            System.out.println("\nPolinomio ajustado a grado " + i + ":");
            System.out.println(aj.getPolinomio() + "\nR^2= " + aj.coeficienteCorrelacion());
        }        
    }


}
