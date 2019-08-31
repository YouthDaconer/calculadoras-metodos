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
    public String resolver() {

        int numDec = 5;
        double x1=a;
        double x2 = b;
        double x3, y3;
        double xp = x1;
        double y1 = f.f(x1);
        double y2 = f.f(x2);

        

        for (int i = 1; i <= maxIteraciones; i++) {
            
            if ((y2 - y1) == 0) {
                
                return "NaN";
            }

            x3 = (y2 * x1 - y1 * x2) / (y2 - y1);
            
            if (Math.abs(xp / x3 - 1) < errorTolerado) {
                
                iteraciones = i;
                return String.valueOf(x3);
            }

            y3 = f.f(x3);

           
            if (y1 * y3 < 0) {
                
                x2 = x3;
                y2 = y3;
            } else {
                
                x1 = x3;
                y1 = y3;
            }
            iteraciones = i;
            xp = x3;
        }
        return "" + xp;

    }

    //pruebas
//    public static void main(String[] args) {
//        ReglaFalsa r = new ReglaFalsa("e^(x^2)+e^x-4", 1e-10, 10);
//        System.out.println("La solución por regla falsa es:"+r.resolver(0, 1));
//        System.out.println("Iteraciones:"+ r.getIteraciones());
//        System.out.println("proceso:\n"+ r.getProceso());
//    }
    //--------------------------------
}
