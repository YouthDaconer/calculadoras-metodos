package control;

import java.util.Arrays;
import javax.swing.JTable;

/**
 *
 * @author JSRA
 */
public class Matriz {

    //Atributos de clase
    private Double[][] matriz;
    private Double[][] inversa;
    private Double[] soluciones;//Necesario para el método GaussJordan
    private String proceso;
    //---------------------------

    /**
     *
     * @param n número de filas
     * @param m número de columnas para utilizar gauss la matriz tiene que ser
     * n*n
     */
    public Matriz(int n, int m) {
        this.matriz = new Double[n][m];
        setSoluciones0();
        this.inversa = getMatrizIdentidad();
    }

    /**
     *
     * @param m n*n para utilizar gaus
     */
    public Matriz(Double[][] m) {
        this.matriz = m;
        setSoluciones0();
        this.inversa = getMatrizIdentidad();
    }

    /**
     * crea una matriz a partir de una tabla sirve para el método gauss
     *
     * @param tabla
     * @param gauss si la matriz es para método gauss
     */
    public Matriz(JTable tabla, boolean gauss) {
        int n;
        int m;
        try {
            if (gauss) {
                n = tabla.getColumnCount() - 1;//sin contar el término independiente
                this.soluciones = new Double[n];
                this.matriz = new Double[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matriz[i][j] = Double.parseDouble(tabla.getValueAt(i, j).toString());
                    }
                    soluciones[i] = Double.parseDouble(tabla.getValueAt(i, n).toString());
                }
            } else {
                m = tabla.getColumnCount();
                n = tabla.getRowCount();
                this.matriz = new Double[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        matriz[i][j] = Double.parseDouble(tabla.getValueAt(i, j).toString());
                    }
                }
            }

        } catch (NumberFormatException e) {
            throw new NumberFormatException("Asegúrate que la matriz esté escrita correctamente" + e.getMessage());
        }

    }

    /**
     *
     * no se puede utilizar para método gauss
     */
    public Matriz() {
    }

    //Getters and setters
    public Double[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(Double[][] matriz) {
        this.matriz = matriz;
    }

    public Double[] getSoluciones() {
        return soluciones;
    }

    public void setSoluciones(Double[] soluciones) {
        this.soluciones = soluciones;
    }

    private void setSoluciones0() {
        soluciones = new Double[this.matriz.length];
        for (int i = 0; i < this.matriz.length; i++) {
            soluciones[i] = 0.0;
        }
    }

    public String getProceso() {
        return proceso;
    }

    public Double[][] getMatizInversa() {
        return inversa;
    }
    

    public Double[][] getMatrizIdentidad() {
        Double[][] m = new Double[this.matriz.length][this.matriz[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = 0.0;
            }
            m[i][i] = 1.0;
        }
        return m;
    }
    //----------------------------

    /**
     * Calcula las soluciones del sistema de ecuaciones lineal
     *
     * @throws ArithmeticException
     * @return un arreglo con las soluciones
     */
    public Double[] metodoGaussJordan() {
        proceso = "";

        if (arreglarMatriz()) {
            int n = soluciones.length;
            Double p, c;
            Double[][] m = getMatriz();// sacamos una copia de la matriz
            Double[] sol = getSoluciones();//sacamos una copia de la columna de soluciones
            Double[][] inv = getMatrizIdentidad();

            for (int i = 0; i < n; i++) {
                c = 0.0;
                //Elementos pertenecientes a la diagonal (transformarlos en 1)
                p = m[i][i];// seleccionamos el pivote
                proceso += "(1/" + p + ") * fila" + (i + 1) + "\n";
                for (int j = 0; j < n; j++) {
                    m[i][j] = m[i][j] / p; // operamos la fila
                    inv[i][j] = inv[i][j] / p;
                }
                sol[i] = sol[i] / p; // operamos la solución de la fila

                //guardamos el proceso
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        proceso += m[j][k] + "\t";
                    }
                    proceso += "|\t" + sol[j] + "\n";
                }
                proceso += "\n\n";

                //Elementos no pertenecientes a la diagonal (transformarlos en 0)
                for (int x = 0; x < n; x++) {
                    if (i != x) {
                        c = m[x][i];
                        proceso += " - (" + c + ") * fila" + (i + 1) + " + fila" + (x + 1 + "\n");
                        for (int y = 0; y < n; y++) {
                            m[x][y] = m[x][y] - c * m[i][y];//operamos la fila
                            inv[x][y] =inv[x][y] -c *inv[i][y];
                        }
                        sol[x] = sol[x] - c * sol[i]; // operamos la solución de la fila

                        //guardamos el proceso
                        for (int j = 0; j < n; j++) {
                            for (int k = 0; k < n; k++) {
                                proceso += m[j][k] + "\t";
                            }
                            proceso += "|\t" + sol[j] + "\n";
                        }
                        proceso += "\n\n";
                    }
                }
                if (ceroEnDiagonal() != -1) {
                    throw new ArithmeticException(getMensajeGauss(ceroEnDiagonal()));
                }
            }
            inversa= inv;
            return sol;
        } else {
            throw new ArithmeticException("Verifica que la matriz esté escrita correctamente :(\n");
        }

    }

    //Mensaje de error
    public String getMensajeGauss(int i) {
        if (soluciones[i] == 0) {
            return "El sistema tiene infinitas soluciones";
        } else {
            return "El sistema no tiene solución :(";
        }
    }
    //-----------------------------------------

    //cambia la fila de la matriz por otra
    private void cambiarFila(int index1, int index2) {
        int n = soluciones.length;
        Double[] temp1 = new Double[n];
        Double[] temp2 = new Double[n];
        Double sol1 = soluciones[index1];
        soluciones[index1] = soluciones[index2];
        soluciones[index2] = sol1;
        System.arraycopy(matriz[index1], 0, temp1, 0, n);
        System.arraycopy(matriz[index2], 0, matriz[index1], 0, n);
        System.arraycopy(temp1, 0, matriz[index2], 0, n);

    }
    //----------------------------------

    //retorna el indice de la diagonal con 0
    private int ceroEnDiagonal() {
        for (int i = 0; i < soluciones.length; i++) {
            if (matriz[i][i] == 0) {
                return i;
            }
        }
        return -1;
    }
    //----------------------------------------

    //Acomoda la matrir y retorna true si logró acomodarla
    private boolean arreglarMatriz() {
        int n = soluciones.length;
        int i = 0;
        while (ceroEnDiagonal() != -1 && i < n - 1) {
            cambiarFila(i, i + 1);
            i++;
        }
        proceso = "Matriz reescrita:\n" + (Arrays.deepToString(matriz)) + "\n";
        return ceroEnDiagonal() == -1;//si existe un cero en la diagonal no está acomodada
    }
    //------------------------------

    //Métodos estáticos
    /**
     * @throws ArithmeticException
     * @param ma matriz a
     * @param mb matriz b
     * @return la suma entre ma + mb
     */
    public static Double[][] sumar(Double[][] ma, Double[][] mb) {
        if ((ma.length == mb.length) && (ma[0].length == mb[0].length)) {
            Double[][] resultado = new Double[ma.length][ma.length];
            for (int x = 0; x < ma.length; x++) {
                for (int y = 0; y < ma[x].length; y++) {
                    resultado[x][y] = ma[x][y] + mb[x][y];
                }
            }
            return resultado;
        } else {
            throw new ArithmeticException("Las matrices tienen que ser el mismo tamaño para poder sumarse");
        }
    }

    /**
     * @throws ArithmeticException
     * @param ma matriz a
     * @param mb matriz b
     * @return el resultado de ma - mb
     */
    public static Double[][] restar(Double[][] ma, Double[][] mb) {
        if ((ma.length == mb.length) && (ma[0].length == mb[0].length)) {
            Double[][] resultado = new Double[ma.length][ma.length];
            for (int x = 0; x < ma.length; x++) {
                for (int y = 0; y < ma[x].length; y++) {
                    resultado[x][y] = ma[x][y] - mb[x][y];
                }
            }
            return resultado;
        } else {
            throw new ArithmeticException("Las matrices tienen que ser el mismo tamaño para poder sumarse");
        }
    }

    /**
     *
     * @param m matriz
     * @param escalar contante que multiplica a la matriz
     * @return el producto de (escalar)*(m)
     */
    public static Double[][] productoEscalar(Double[][] m, Double escalar) {
        Double[][] resultado = new Double[m.length][m[0].length];
        for (int x = 0; x < m.length; x++) {
            for (int y = 0; y < m[x].length; y++) {
                resultado[x][y] = escalar * m[x][y];
            }
        }
        return resultado;
    }

    /**
     * @throws ArithmeticException
     * @param a matriz a
     * @param b matriz b
     * @return el resultado del producto punto de ma.mb
     */
    public static Double[][] productoPunto(Double[][] a, Double[][] b) {
        if (a[0].length == b.length) {
            Double[][] resultado = new Double[a.length][b[0].length];
            for (Double[] resultado1 : resultado) {
                for (int j = 0; j < resultado[0].length; j++) {
                    resultado1[j] = 0.0;
                }
            }
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b[0].length; j++) {
                    for (int k = 0; k < a[0].length; k++) {

                        resultado[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
            return resultado;
        } else {
            throw new ArithmeticException("No sepueden multiplicar estas matrices");
        }
    }

    /**
     *
     * @param m matriz
     * @return matriz transpuesta
     */
    public static Double[][] transpuesta(Double[][] m) {
        Double[][] transpuesta = new Double[m[0].length][m.length];
        for (int x = 0; x < m.length; x++) {
            for (int y = 0; y < m[x].length; y++) {
                transpuesta[y][x] = m[x][y];
            }
        }
        return transpuesta;
    }
    //----------------------------------------------------------

//    //pruebas
//    public static void main(String[] args) {
//        //matriz 3x3:
//        Double[][] m1 = {{0.0, 0.0, 5.0}, {5.0, 0.0, 1.2}, {1.3, 2.0, 0.0}};
//        Double sol1[] = {2.5, 3.2, 4.1};
//
//        //matriz 2x2:
//        Double[][] m2 = {{2.0, 1.0}, {5.0, 3.0}};
//        Double sol2[] = {4.0, 1.0};
//
//        //matriz 2x2 sin solución:
//        Double[][] m3 = {{3.0, 1.0}, {3.0, 1.0}};
//        Double so3[] = {9.0, -7.0};
//        
//
//        //matriz 2x2 con infinitas soluciones:
//        Double[][] m4 = {{-6.0, 4.0}, {3.0, -2.0}};
//        Double sol4[] = {2.0, -1.0};
//        
//        //matriz 2x2 para ensayar la matriz inversa:
//        Double[][] m5 = {{1.0, 3.0}, {2.0, 4.0}};        
//        Matriz matriz = new Matriz(m5);
//        
//        Double[][] m6 = {{1.0,2.0,-3.0},{4.0,0.0,-2.0}};
//        Double[][] m7 = {{3.0,1.0},{2.0,4.0},{-1.0,5.0}};
//        //matriz.setSoluciones(sol1);
//
//        System.out.println("operaciones:");
//        System.out.println("suma:\n" + Arrays.deepToString(m2) + " + " + Arrays.deepToString(m3) + " = " + Arrays.deepToString(sumar(m2, m3)));
//        System.out.println("resta:\n" + Arrays.deepToString(m2) + " - " + Arrays.deepToString(m3) + " = " + Arrays.deepToString(restar(m2, m3)));
//        System.out.println("producto escalar:\n" + Arrays.deepToString(m1) + " * " + 5 + " = " + Arrays.deepToString(productoEscalar(m1, 5.0)));
//        System.out.println("multiplicación:\n" + Arrays.deepToString(m6) + " * " + Arrays.deepToString(m7) + " = " + Arrays.deepToString(productoPunto(m6, m7)));
//        System.out.println("transpuesta:\n" + Arrays.deepToString(m1) + " = " + Arrays.deepToString(transpuesta(m1)));
//        
//        System.out.println("\nPruebas de Gauss Jordan para la matriz:\n" + Arrays.deepToString(matriz.getMatriz()));
//        System.out.println("columna extendida:\n" + Arrays.toString(matriz.getSoluciones()));
//        System.out.println("RESPUESTAS:\n" + Arrays.toString(matriz.metodoGaussJordan()));
//        Double [][]inv =matriz.getMatizInversa();        
//        System.out.println("Matriz inversa:"+Arrays.deepToString(inv));
//        //System.out.println("Proceso:\n" + matriz.getProceso());
//
//    }
//    //----------------------------------
}
