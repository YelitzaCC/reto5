package Vista;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;

// importar Modelo.dao.*;
import Controlador.ElControladorRequerimientos;
import Modelo.vo.Requerimiento_2;

public class Requerimiento2 extends JFrame {
    JTable tabla = new JTable();
    public Requerimiento2() throws SQLException{
        this.tabla = initUI();
    }
    
    //constructor 
    public JTable initUI() throws SQLException{ 
        String[]nombres = {"Nombre","Primer_Apellido", "Ciudad_Residencia","Cargo","Salario"};
        JTable tabla = new JTable(mostrar(), nombres); 
        //Color de fondo titulos
        Color color = new Color(164, 254, 205);
        tabla.getTableHeader().setBackground(color);
        //Letra titulos
        tabla.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 15));
        //Color de fondo celdas
        Color color2 = new Color(214, 250, 231);
        tabla.setBackground(color2);
        //Letra celdas
        tabla.setFont(new Font("SansSerif", Font.ITALIC, 12));
        return tabla;
    }
    
    public String[][] mostrar () throws SQLException{
    
        ArrayList<Requerimiento_2> lista = new ArrayList<Requerimiento_2>();
        //Requerimiento_2Dao requerimiento_2= new ElControladorRequerimientos();
        ElControladorRequerimientos controlador = new ElControladorRequerimientos();
        lista = controlador.consultarRequerimiento2();

        String matris [][] = new String [lista.size()][5];
        
        for (int i = 0; i <lista.size ();i++) {
            matris [i][0] = String.valueOf(lista.get (i).getNombre ());
            matris [i][1] = lista.get(i).getPrimer_Apellido();
            matris [i][2] = lista.get(i).getCiudad_Residencia();
            matris [i][3] = lista.get(i).getCargo();
            matris [i][4] = String.valueOf(lista.get(i).getSalario());
        }
        return matris;
    }
}
	