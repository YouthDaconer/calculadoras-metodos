/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author salas
 */
public class ModelTabla {
    
    //Método que devuelve un modelo de tabla
    public DefaultTableModel getModeloTabla(Object [] encabezados, ArrayList<Object[]> datos){
        DefaultTableModel dt = new DefaultTableModel(); //Creo el objeto  
        dt.setColumnIdentifiers(encabezados);  //pongo los encabezados
        datos.forEach((fila) -> {//recorro la lista
            dt.addRow(fila);//adiciono la fila
        });
        return dt;
    }
    //---------------------------------------
}
