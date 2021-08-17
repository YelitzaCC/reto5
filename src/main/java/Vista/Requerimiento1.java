package Vista;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;

// importar el paquete donde se encuentra la clase a utilizar 
import Controlador.ElControladorRequerimientos; //importar del paquete controlador la clase
import Modelo.vo.Requerimiento_1;

public class Requerimiento1 extends JFrame {
    JTable tabla = new JTable();
    public Requerimiento1() throws SQLException{
        this.tabla = initUI();
    }
    
    //constructor 
    public JTable initUI() throws SQLException{
        String[]nombres = {"ID_proyecto","Ciudad","Banco_Vinculado","Constructora", "Clasificacion"};
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
    
        ArrayList<Requerimiento_1> lista = new ArrayList<Requerimiento_1>();
        //Requerimiento_1Dao requerimiento_1= new ElControladorRequerimientos();
        ElControladorRequerimientos controlador = new ElControladorRequerimientos();
        lista = controlador.consultarRequerimiento1();

        String matris [][] = new String [lista.size()][5];
        
        for (int i = 0; i <lista.size();i++) {
            matris [i][0] = String.valueOf(lista.get(i).getID_Proyecto());
            matris [i][1] = lista.get(i).getCiudad();
            matris [i][2] = lista.get(i).getBanco_Vinculado();
            matris [i][3] = lista.get(i).getConstructora();
            matris [i][4] = lista.get(i).getClasificacion();
        }
        return matris;
    }
}
	