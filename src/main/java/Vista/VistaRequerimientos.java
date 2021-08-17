package Vista;

import java.sql.SQLException;
import java.util.ArrayList;

import Controlador.ElControladorRequerimientos;
import Modelo.vo.Requerimiento_1;
import Modelo.vo.Requerimiento_2;
import Modelo.vo.Requerimiento_3;
// Vista

public class VistaRequerimientos {
    public static final ElControladorRequerimientos controlador = new ElControladorRequerimientos();

    public static void requerimiento1(){
        ArrayList<Requerimiento_1> requerimiento1;
        try {
            requerimiento1 = controlador.consultarRequerimiento1();
            for (int i = 0; i < requerimiento1.size(); i++) {
                Requerimiento_1 req = requerimiento1.get(i);
                
                System.out.println(
                    req.getID_Proyecto() 
                    + " " + req.getCiudad() 
                    + " " + req.getBanco_Vinculado() 
                    + " " + req.getConstructora() 
                    + " " + req.getClasificacion()
                );
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta");
        }
    }

    public static void requerimiento2(){
        ArrayList<Requerimiento_2> requerimiento2;
        try {
            requerimiento2 = controlador.consultarRequerimiento2();
            for (int i = 0; i < requerimiento2.size(); i++) {
                Requerimiento_2 req = requerimiento2.get(i);
                
                System.out.println(
                    req.getNombre()
                    + " " + req.getPrimer_Apellido()
                    + " " + req.getCiudad_Residencia()
                    + " " + req.getCargo()
                    + " " + req.getSalario()
                );
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta");
        }
    }

    public static void requerimiento3(){
        ArrayList<Requerimiento_3> requerimiento3;
        try {
            requerimiento3 = controlador.consultarRequerimiento3();
            for (int i = 0; i < requerimiento3.size(); i++) {
                Requerimiento_3 req = requerimiento3.get(i);
                
                System.out.println(
                    req.getProveedor()
                    + " " + req.getPagado()
                    + " " + req.getConstructora()
                );
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta");
        }
    }
}

