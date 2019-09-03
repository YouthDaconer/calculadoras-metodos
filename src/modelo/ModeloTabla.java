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
}
