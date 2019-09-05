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
public class Graeffe {

    public int n;                                      //grado del polinomio
    public double[] raicesReales;
    public Complejo[] raicesComplejas = new Complejo[4]; // dos raíces complejas y sus correspondientes conjugadas
    public int numReales;                              //número de raíces reales
    public int numComplejas;                           //número de raíces complejas
    private double[][] a;                       //tabla de los coeficientes resultantes de elevar el polinomio al cuadrado
    private int pot2 = 1;                         //potencia de dos
    private int m;                              //número de iteracción
    private final int MAX_ITER = 10;                      //máximo número de veces que se eleva al cuadrado
    private static final double CERO = 0.0001;
    private double[] moduloComplejas = new double[2];

    public Graeffe(double[] coef) {
        n = coef.length - 1;                        //grado del polinomio
        raicesReales = new double[n];             // un polinomio de grado n tiene como máximo n raíces reales.
        a = new double[MAX_ITER][n + 1];
        //la primera fila de la tabla guarda los coeficientes del polinomio
        for (int j = 0; j < n + 1; j++) {
            a[0][j] = coef[j];
        }
        for (int m = 1; m < MAX_ITER; m++) {
            for (int j = 0; j < n + 1; j++) {
                a[m][j] = 0.0;
            }
        }
        numReales = 0;
        numComplejas = 0;
        hallarRaices();
    }

    private void tabla() {
        int k, l, signo;
        //divide el polinomio por el primer coeficiente, las raíces no cambian
        for (int i = 1; i < n + 1; i++) {
            a[0][i] /= a[0][0];
        }
        a[0][0] = 1.0;
        m = 1;
        exterior:
        do {
            //cuadrados
            for (int i = 0; i < n + 1; i++) {
                a[m][i] = a[m - 1][i] * a[m - 1][i];
                if (Double.isInfinite(a[m][i])) {
                    break exterior;
                }
            }
            //dobles productos
            for (int i = 1; i < n; i++) {
                for (int s = 1; s < n / 2 + 1; s++) {
                    k = i - s;
                    l = i + s;
                    if ((k < 0) || (l > n)) {
                        break;   //términos simétricos
                    }
                    signo = (s % 2 == 0) ? +1 : -1;
                    a[m][i] += signo * 2 * a[m - 1][k] * a[m - 1][l];
                    if (Double.isInfinite(a[m][i])) {
                        break exterior;
                    }
                }
            }
            m++;
        } while (m < MAX_ITER);

        m--;
        //potencia de m de 2
        pot2 = 1;
        for (int i = 1; i <= m; i++) {
            pot2 *= 2;
        }
    }
    //valor de un polinomio para una variabel real
    public double valorPolinomio(double x) {
        double y = 0.0;
        //sucesivas potencias de x, se puede utilizar tambien la funcion Math.pow
        double[] pot_x = new double[n + 1];
        pot_x[0] = 1.0;
        for (int i = 1; i < n + 1; i++) {
            pot_x[i] = pot_x[i - 1] * x;
        }
        //valores de los sucesivos términos
        for (int i = 0; i < n + 1; i++) {
            y += a[0][i] * pot_x[n - i];
        }
        return y;
    }

    public Complejo valorPolinomio(Complejo x) {
        Complejo y = new Complejo();
        for (int i = 0; i < n + 1; i++) {
            y = Complejo.suma(y, Complejo.producto(a[0][i], Complejo.potencia(x, (n - i))));
        }
        return y;
    }

    private void raizRealSimple(int j) {
        //valor absoluto de la raíz        
        double logaritmo = (Math.log(a[m][j]) - Math.log(a[m][j - 1])) / pot2;
        double raiz = Math.exp(logaritmo);
        //determinación del signo, y1 o y2 tienen que ser casi cero
        raicesReales[numReales] = (Math.abs(valorPolinomio(raiz)) < Math.abs(valorPolinomio(-raiz))) ? raiz : -raiz;
        numReales++;
    }

    private void raizRealDoble(int j) {
        //valor absoluto de la raíz
        double logaritmo = (Math.log(a[m][j + 1]) - Math.log(a[m][j - 1])) / (2 * pot2);
        double raiz = Math.exp(logaritmo);
        boolean bPositiva = false, bNegativa = false;
        if (Math.abs(valorPolinomio(raiz)) < CERO) {
            raicesReales[numReales] = raiz;
            numReales++;
            bPositiva = true;
        }
        if (Math.abs(valorPolinomio(-raiz)) < CERO) {
            raicesReales[numReales] = -raiz;
            numReales++;
            bNegativa = true;
        }
        if (bPositiva && !bNegativa) {
            raicesReales[numReales] = raiz;
            numReales++;
        }
        if (!bPositiva && bNegativa) {
            raicesReales[numReales] = -raiz;
            numReales++;
        }
    }

    private void unaRaizCompleja() {
        double suma = 0.0;
        for (int i = 0; i < numReales; i++) {
            suma += raicesReales[i];
        }
        double u, v;
        u = -(a[0][1] + suma) / 2;
        v = Math.sqrt(moduloComplejas[0] * moduloComplejas[0] - u * u);
        raicesComplejas[0] = new Complejo(u, v);
        raicesComplejas[1] = new Complejo(u, -v);
    }

    private void dosRaicesComplejas() {
        double suma = 0.0;
        double producto = 1.0;
        double inversa = 0.0;
        for (int i = 0; i < numReales; i++) {
            suma += raicesReales[i];
            producto *= raicesReales[i];
            inversa += 1 / raicesReales[i];
        }
        double r1 = moduloComplejas[0];
        double r2 = moduloComplejas[1];
        double y = -(a[0][1] + suma) / 2;
        int signo = ((n - 1) % 2 == 0) ? +1 : -1;
        double z = signo * a[0][n - 1] / (2 * producto) - r1 * r1 * r2 * r2 * inversa / 2;
        double u1 = (y * r1 * r1 - z) / (r1 * r1 - r2 * r2);
        double u2 = (-y * r2 * r2 + z) / (r1 * r1 - r2 * r2);
        double v1 = Math.sqrt(r1 * r1 - u1 * u1);
        double v2 = Math.sqrt(r2 * r2 - u2 * u2);
        raicesComplejas[0] = new Complejo(u1, v1);
        raicesComplejas[1] = new Complejo(u1, -v1);
        raicesComplejas[2] = new Complejo(u2, v2);
        raicesComplejas[3] = new Complejo(u2, -v2);
    }

    private boolean cambiaSigno(int j) {
        double logaritmo;
        for (int k = 2; k <= m; k++) {
            if (a[k][j] > 0) {
                continue;
            }
            numComplejas++;
//máximo dos raíces complejas, 4 contando sus respectivas conjugadas
            if (numComplejas < 3) {
                logaritmo = (Math.log(a[m][j + 1]) - Math.log(a[m][j - 1])) / (2 * pot2);
                moduloComplejas[numComplejas - 1] = Math.exp(logaritmo);
                return true;
            }
        }
        return false;
    }

    public void hallarRaices() {
        tabla();
        //el pimer coeficiente a[m][0] es siempre 1
        for (int i = 1; i < n + 1; i++) {      //i es la raíz
            if (cambiaSigno(i)) {
            //raíz compleja y su correspondiente conjugada
                i++;
                continue;
            }
            //raíces simple y dobles
            double logaritmo = Math.log(a[m][i]) - 2 * Math.log(a[m - 1][i]);
            if (Math.abs(logaritmo) < CERO) {
                raizRealSimple(i);
            } else {
                raizRealDoble(i);
                i++;
            }
        }
        if (numComplejas == 1) {
            unaRaizCompleja();
        }
        if (numComplejas == 2) {
            dosRaicesComplejas();
        }
    }

    //Método que devuelve las raices reales del polinomio
    public String getRaicesReales() {
        String cadena = "";
        if (numReales != 0) {
            for (int i = 0; i < numReales; i++) {
                cadena += (raicesReales[i] + valorPolinomio(raicesReales[i])) + "\n";
            }
        }
        return cadena;
    }
    //----------------------------------

    //Método que devuelve las raices complejas
    public String getRaicesComplejas() {
        String cadena = "";
        if (numComplejas != 0) {
            for (int i = 0; i < numComplejas; i++) {
                cadena += raicesComplejas[2 * i].toString() + "\n";
                cadena += raicesComplejas[2 * i + 1].toString() + "\n";
            }
        }
        return cadena;
    }
    //----------------------------------------------

    //Pruebas
//    public static void main(String[] args) {
//        //3x^4–6.5x^3+8.96x^2–15.25x–9.45      
//        double[] coef2 = {3, -6.5, 8.96, -15.25, -9.45};
//        Graeffe g2 = new Graeffe(coef2);
//        
//        System.out.println(g2.getRaicesReales());
//        System.out.println(g2.getRaicesComplejas());
//
//        
//        //-8.234x^3 -36.05x^2 +69.95x +19.56    
//        double[] coef3 = {-8.234, 0, 69.95, 19.56};
//        Graeffe g3 = new Graeffe(coef3);
//        
//        System.out.println(g3.getRaicesReales());
//        System.out.println(g3.getRaicesComplejas());
//    }
    //-----------------------------------
}
