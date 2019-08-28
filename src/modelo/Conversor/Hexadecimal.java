package modelo.Conversor;

/**
 *
 * @author salas
 */
public class Hexadecimal {

    ////Dominio de caracteres={0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F}
    //Constructor
    public Hexadecimal() {

    }
    //------------------------------

    //Método que cambia la base actual a una base pasada por parámetro
    public String cambiarABase(String numero, int base, int presicion) {
        String cadena = "";
        if (!numero.trim().equals("")) {
            Decimal dec = new Decimal();
            String decimal = dec.aDecimal(numero, 16);
            cadena = dec.cambiarABase(decimal, base, presicion);
        }
        return cadena;
    }
    //-------------------------------------

    //pruebas
    /*public static void main(String[] args) {
        Hexadecimal num = new Hexadecimal();
        for (int i = 2; i < 16; i++) {
            System.out.println("2435.7 en base "+i+"  es:"+num.cambiarABase("2435.7",i , 10));
        }
        
        for (int i = 2; i < 16; i++) {
            System.out.println("F243A.F2 en base "+i+"  es:"+num.cambiarABase("F243A.F2",i , 10));
        }
        

    }*/
}
