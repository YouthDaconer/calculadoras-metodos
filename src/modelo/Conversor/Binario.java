package modelo.Conversor;

/**
 *
 * @author salas
 */
public class Binario {

    //Dominio de caracteres={0,1}
    //Constructor
    public Binario() {

    }
    //------------------------------

    //Método que cambia la base actual a una base pasada por parámetro
    public String cambiarABase(String numero, int base, int presicion) {
        String cadena = "";
        if (!numero.trim().equals("")) {
            Decimal dec = new Decimal();
            String decimal = dec.aDecimal(numero, 2);
            cadena = dec.cambiarABase(decimal, base, presicion);
        }
        return cadena;
    }
    //-------------------------------------

    //pruebas
    /*public static void main(String[] args) {
        Binario num = new Binario();
        for (int i = 2; i < 16; i++) {
            System.out.println("1010101.10101010 en base "+i+"  es:"+num.cambiarABase("1010101.10101010",i , 10));
        }
        

    }*/
}
