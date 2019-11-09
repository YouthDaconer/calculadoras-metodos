package modelo.Conversor;

import java.math.BigDecimal;

/**
 *
 * @author salas
 */
public class Decimal {

    //Dominio de caracteres={0,1,2,3,4,5,6,7,8,9}
    //Atributos
    private long entero;
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
                    entero = n.longValue();
                    fraccion = Math.abs(n - entero);
                    cadena = Long.toString(entero, base) + '.' + fraccion(fraccion, base, presicion);
                } else {
                    entero = Long.parseLong(numero);
                    cadena = Long.toString(entero, base);
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
                if (r >= 10) {
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
                cadena = leerEntero(numero, baseOrigen);
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
    private String leerEntero(String numero, int baseOrigen) {
        long decimal = 0;
        int pos = numero.length();
        int d = 0;
        String menos="";
        for (char dig : numero.toCharArray()) {
            if (dig!='-') {
                d = digitos.indexOf(dig);
                decimal = decimal * baseOrigen + d;
            }else{
                menos=dig+"";
            }
            
        }
        return menos+decimal + "";
    }
    //---------------------------------------

    //para leer numeros fraccionados
    private String leerFraccion(String numero, int baseOrigen) {                
        int exponente = 1;
        String[] partes = numero.split("\\.");
        String parteEntera = leerEntero(partes[0], baseOrigen);
        String parteFraccionaria;
        BigDecimal dec = new BigDecimal("0.0");
        BigDecimal dec2;
        
        for (int j = 0; j < partes[1].length(); j++) {
            int d = digitos.indexOf(partes[1].charAt(j));
            dec2 = new BigDecimal(d*Math.pow(baseOrigen, -exponente));
            dec = dec.add(dec2);
                     
            exponente++;
        }        
        parteFraccionaria = dec.toString();
        parteFraccionaria=parteFraccionaria.replace("0.", ".");
        return parteEntera+parteFraccionaria;

    }
    //-----------------------------------------

//    //pruebas
//    public static void main(String[] args) {
//        Decimal num = new Decimal();
////        for (int i = 2; i <= 16; i++) {
////            System.out.println("873 en base " + i + " es:" + num.cambiarABase("873", i, 100));
////        }
////        for (int i = 2; i <= 16; i++) {
////            System.out.println("7937623827639.57653753376276732  en base " + i + " es:" + num.cambiarABase("7937623827639.57653753376276732", i, 100));
////        }
//        System.out.println("799.5765  en base " + 2+ " es:" + num.cambiarABase("799.5765 ", 2, 100));
//        System.out.println("799.5765  en base " + 8 + " es:" + num.cambiarABase("799.5765 ", 8, 100));
//        System.out.println("799.5765  en base " + 16 + " es:" + num.cambiarABase("799.5765 ", 16, 100));
//        
//        System.out.println("-799.5765  en base " + 2+ " es:" + num.cambiarABase("-799.5765 ", 2, 100));
//        System.out.println("-799.5765  en base " + 8 + " es:" + num.cambiarABase("-799.5765 ", 8, 100));
//        System.out.println("-799.5765  en base " + 16 + " es:" + num.cambiarABase("-799.5765 ", 16, 100));
//
//        System.out.println("73BC5f a decimal es: " + num.aDecimal("73BC5f", 16));
//        System.out.println("73BC5f.3 a decimal es: " + num.aDecimal("73BC5f.3", 16));
//        System.out.println("-73BC5f a decimal es: " + num.aDecimal("-73BC5f", 16));
//        System.out.println("-73BC5f.3 a decimal es: " + num.aDecimal("-73BC5f.3", 16));
//    }
}
