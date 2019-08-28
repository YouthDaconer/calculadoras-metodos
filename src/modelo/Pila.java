package modelo;

/**
 *
 * @author JSRA
 */
public class Pila {
    private int n, tope;
    private Object pila[];

    public Pila(int n) {
        this.n = n;
        this.tope = 0;
        this.pila = new Object[n]; 
    }
    
    public boolean esVacia(){
        return tope==0;
    }
    
    public boolean estaLlena(){
        return tope==n;
    }
    
    public boolean apilar(Object dato){
        if (estaLlena()) {
            return false;
        }else{
            pila[tope]=dato;
            tope++;
            return true;
        }
    }
    
    public Object desapilar(){
        if (esVacia()) {
            return null;
        }else{
            tope--;
            return pila[tope];
        }
    }
    
    public Object elementoTope(){
        if (esVacia()) {
            return null;
        }else{            
            return pila[tope-1];
        }
    }
}
