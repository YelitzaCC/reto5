package Vista;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;

// importar Modelo.dao.*;
import Controlador.ElControladorRequerimientos;
import Modelo.vo.Requerimiento_3;


public class Requerimiento3 extends JFrame {
    JTable tabla = new JTable();
    public Requerimiento3() throws SQLException{
        this.tabla = initUI();
    }
    
    //constructor 
    public JTable initUI() throws SQLException{ 
        String[]nombres = {"Proveedor", "Pagado","Constructora"};
        JTable tabla = new JTable(mostrar(), nombres); 
        // Color de fondo titulos
        Color color = new Color(164, 254, 205);
        tabla.getTableHeader().setBackground(color);
        // Letra titulos
        tabla.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 15));
        // Color de fondo celdas
        Color color2 = new Color(214, 250, 231);
        tabla.setBackground(color2);
        // Letra celdas
        tabla.setFont(new Font("SansSerif", Font.ITALIC, 12));
        return tabla;
    }
    
    public String[][] mostrar () throws SQLException{
    
        ArrayList<Requerimiento_3> lista = new ArrayList<Requerimiento_3>();
        //Requerimiento_3Dao requerimiento_3= new ElControladorRequerimientos();
        ElControladorRequerimientos controlador = new ElControladorRequerimientos();
        lista = controlador.consultarRequerimiento3();

        String matris [][] = new String [lista.size()][3];
        
        for (int i = 0; i <lista.size ();i++) {
            matris [i][0] = String.valueOf(lista.get (i).getProveedor ());
            matris [i][1] = lista.get(i).getPagado();
            matris [i][2] = lista.get(i).getConstructora();
        }
        return matris;
    }
}