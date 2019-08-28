package modelo.Conversor;

/**
 *
 * @author salas
 */
public class Decimal {

    //Dominio de caracteres={0,1,2,3,4,5,6,7,8,9}
    //Atributos
    private int entero;
    private double fraccion;
    private final String[] letras = {"A", "B", "C", "D", "E", "F"};
    private final String digitos = "0123456789ABCDEF";
    //----------------------------------------

    //Constructor
    public Decimal() {

    }
    //------------------------------

    //si es fraccion
    public boolean esFraccion(String numero) {
        return numero.contains(".");
    }
    //---------------------------

    //Método que cambia la base actual a una base pasada por parámetro
    public String cambiarABase(String numero, int base, int presicion) {
        String cadena = "";
        if (!numero.trim().equals("")) {
            if (base != 10) {// si es la base actual, no necesita cambio
                if (esFraccion(numero)) {// si es fracción procedemos a separar la parte entera de la fraccionaria
                    Double n = Double.parseDouble(numero);
                    entero = n.intValue();
                    fraccion = (n - entero);
                    cadena = Integer.toString(entero, base) + '.' + fraccion(fraccion, base, presicion);
                } else {
                    entero = Integer.parseInt(numero);
                    cadena = Integer.toString(entero, base);
                }
                if (base > 10) {
                    cadena = cadena.toUpperCase();//Para los números con base > 10
                }

            } else {
                cadena = numero;
            }
        }
        return cadena;
    }
    //-------------------------------------

    //En caso de que el número sea fracción, se aproximará 
    private String fraccion(double num, int base, int precision) {
        StringBuilder cadena = new StringBuilder();

        while (num > 0 && cadena.length() < precision) {
            Double r = num * base;
            int parteEntera = r.intValue();

            if (r >= 1) {
                if (r > 9) {
                    int diferencia = Math.abs(parteEntera - 10);// para seleccionar la letra correspondiente
                    cadena.append(letras[diferencia]);
                } else {
                    cadena.append(parteEntera);
                }

                num = r - parteEntera;

            } else {
                cadena.append(0);
                num = r;
            }
        }
        return cadena.toString();
    }
    //--------------------------------------

    //de una base pasada por parametro a base decimal
    public String aDecimal(String numero, int baseOrigen) {

        String cadena = "";
        if (baseOrigen != 10) {

            numero = numero.toUpperCase();
            if (!esFraccion(numero)) {
                cadena = "" + leerEntero(numero, baseOrigen);
            } else {
                cadena = "" + leerFraccion(numero, baseOrigen);
            }

        } else {
            return numero;
        }
        return cadena;
    }
    //--------------------------------------

    //para leer solo numeros enteros
    private int leerEntero(String numero, int baseOrigen) {
        int decimal = 0;
        for (int i = 0; i < numero.length(); i++) {
            char c = numero.charAt(i);
            int d = digitos.indexOf(c);
            decimal = decimal * baseOrigen + d;
        }
        return decimal;
    }
    //---------------------------------------

    //para leer numeros fraccionados
    private double leerFraccion(String numero, int baseOrigen) {
        double decimal = 0;
        int i = 0;
        int exponente = 1;
        char c;
        do {
            c = numero.charAt(i);
            if (c == '.') {
                double fraccion = 0.0;
                for (int j = i + 1; j < numero.length(); j++) {
                    int d = digitos.indexOf(numero.charAt(j));
                    fraccion += d / (Math.pow(baseOrigen, exponente));
                    exponente++;
                }
                decimal += fraccion;
            } else {
                int d = digitos.indexOf(c);
                decimal = decimal * baseOrigen + d;
            }
            i++;
        } while (c != '.' && i < numero.length());

        return decimal;
    }
    //-----------------------------------------

    //pruebas
    /*public static void main(String[] args) {
        Decimal num = new Decimal();
        for (int i = 2; i <= 16; i++) {
            System.out.println("873 en base " + i + " es:" + num.cambiarABase("873", i, 10));
        }
        for (int i = 2; i <= 16; i++) {
            System.out.println("3.141516 en base " + i + " es:" + num.cambiarABase("3.141516", i, 10));
        }

        System.out.println("73BC5f a decimal es: " + num.aDecimal("73BC5f", 16));
        System.out.println("73BC5f.3 a decimal es: " + num.aDecimal("73BC5f.3", 16));
    }*/
}
