package control;

import java.util.ArrayList;

/**
 *
 * @author JSRA
 */
public class ReglaFalsa {

    //Atributos de clase
    private Funcion f;
    private double a, b, errorTolerado, error;
    private int iteraciones, maxIteraciones;
    private String cadena;
    private Object[] encabezados = {"Iteración",
        "Extremo\ninferior",
        "Extremo\nsuperior",
        "Imagen\nExt. inferior",
        "Imagen\nExt. superior",
        "Raiz",
        "Imagen\nraiz",
        "Error relativo"};
    private ArrayList<Object[]> datos;
    //-----------------------------------

    //Constructores
    public ReglaFalsa(Funcion f, double a, double b, double errorTolerado) {
        this.f = f;
        this.a = a;
        this.b = b;
        this.errorTolerado = errorTolerado;
        this.iteraciones = 0;
        this.error = 0;
        this.maxIteraciones = 200;
        this.datos = new ArrayList<>();
    }

    public ReglaFalsa(String f, double a, double b, double errorTolerado) {
        this.f = new Funcion(f);
        this.a = a;
        this.b = b;
        this.errorTolerado = errorTolerado;
        this.iteraciones = 0;
        this.error = 0;
        this.maxIteraciones = 200;
        this.datos = new ArrayList<>();
    }

    public ReglaFalsa(Funcion f, double a, double b, double errorTolerado, int maxIteraciones) {
        this.f = f;
        this.a = a;
        this.b = b;
        this.iteraciones = 0;
        this.error = 0;
        this.errorTolerado = errorTolerado;
        this.maxIteraciones = maxIteraciones;
        this.datos = new ArrayList<>();
    }
    //----------------------------------------------

    //Getters and Setters
    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getErrorTolerado() {
        return errorTolerado;
    }

    public double getError() {
        return error;
    }

    public int getIteraciones() {
        return iteraciones;
    }

    public int getMaxIteraciones() {
        return maxIteraciones;
    }

    public String getF() {
        return f.getFuncion();
    }

    public void setF(String f) {
        this.f = new Funcion(f);
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setErrorTolerado(double errorTolerado) {
        this.errorTolerado = errorTolerado;
    }

    public void setMaxIteraciones(int maxIteraciones) {
        this.maxIteraciones = maxIteraciones;
    }

    public Object[] getEncabezados() {
        return encabezados;
    }

    public ArrayList<Object[]> getDatos() {
        return datos;
    }
    //--------------------------------------   

    //Método que da la solución
    public double resolver() {
        double raiz = Double.NaN;
        double a1 = a;
        double b1 = b;
        double r, fr;
        double auxR = a1;
        double fa = f.f(a1);
        double fb = f.f(b1);

        try {

            if (fa * fb < 0) {// para verificar que existe una solución en el intervalo (a, b)
                int i = 0;
                String linea = "";//string que contendra la fila de valores
                Object[] fila;//recolectará los resultados de las variables
                do {
                    if ((fb - fa) == 0) {// Error
                        return Double.NaN;
                    }

                    r = (fb * a1 - fa * b1) / (fb - fa);
                    fr = f.f(r);
                    error = Math.abs((auxR - r));//Cálculo del error
                    i++;

                    linea = i + "," + a1 + "," + b1 + "," + fa + "," + fb + "," + r + "," + fr + "," + error;//le doy formato a la fila
                    fila = linea.split(",");//separo los valores y los fuardo en fila
                    datos.add(fila);//Adiciona a la lista de datos

                    if (fr == 0) {
                        error = 0.0;
                        iteraciones = i;
                        return r;//dio una raiz exacta
                    }

                    //Cambio los valores para la siguiente iteración
                    if (fa * fr < 0) {
                        b1 = r;
                        fb = fr;
                    } else {
                        a1 = r;
                        fa = fr;
                    }
                    auxR = r;

                } while (i <= maxIteraciones && error >= errorTolerado);
                raiz = r;
                iteraciones = i;
            }
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Error no se pudo calcular la solución :(\n" + e.getMessage());

        }
        return raiz;

    }

    //pruebas
//    public static void main(String[] args) {
//        ReglaFalsa r = new ReglaFalsa("exp(-2*x)+x-3",0,10, 1e-12);
//        System.out.println("La solución por regla falsa es:"+r.resolver());
//        System.out.println("Iteraciones:"+ r.getIteraciones());
//        ArrayList<Object[]> datos = r.getDatos();
//        datos.forEach((fila) -> {
//            for (Object dato : fila) {
//                System.out.print(dato+"\t");
//            }
//            System.out.print("\n");
//        });
//    }
    //--------------------------------
}
