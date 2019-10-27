package modelo;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author salas
 */
public class ModeloTabla {

    //Atributos de clase
    private Object[] encabezados;
    private ArrayList<Object[]> datos;
    //-------------------------------

    /**
     * constructor
     *
     * @param encabezados
     * @param datos
     */
    public ModeloTabla(Object[] encabezados, ArrayList<Object[]> datos) {
        this.encabezados = encabezados;
        this.datos = datos;
    }
    //----------------------------

    /**
     * constructor
     *
     */
    public ModeloTabla() {
        this.encabezados = null;
        this.datos = new ArrayList<>();
    }
    //----------------------------

    /**
     *
     * @return modelo de tabla
     */
    public DefaultTableModel getModeloTabla() {
        DefaultTableModel dt = new DefaultTableModel(); //Creo el objeto  
        dt.setColumnIdentifiers(encabezados);  //pongo los encabezados
        datos.forEach((fila) -> {//recorro la lista
            dt.addRow(fila);//adiciono la fila
        });
        return dt;
    }
    //---------------------------------------

    /**
     *
     * @param n la cantidad de columnas incluyendo la columna de los términos
     * solución
     * @return modelo de tabla de la matriz aumentada
     */
    public DefaultTableModel getModeloMatrizAumentada(int n) {
        if (n > 0) {
            encabezados = new Object[n];
            //pongo los encabezados
            for (int i = 0; i < n - 1; i++) {
                encabezados[i] = "X" + i;
            }
            encabezados[n - 1] = "d";//columna solución           
            return new DefaultTableModel(encabezados, n);

        }else{
            return null;
        }
    }
    //---------------------------------------
}
