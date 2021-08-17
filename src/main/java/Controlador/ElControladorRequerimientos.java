package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import Modelo.dao.Requerimiento_1Dao;
import Modelo.dao.Requerimiento_2Dao;
import Modelo.dao.Requerimiento_3Dao;

import Modelo.vo.Requerimiento_1;
import Modelo.vo.Requerimiento_2;
import Modelo.vo.Requerimiento_3;

// Controlador
public class ElControladorRequerimientos {
    private final Requerimiento_1Dao requerimiento1;
    private final Requerimiento_2Dao requerimiento2;
    private final Requerimiento_3Dao requerimiento3;

    public ElControladorRequerimientos() {
        this.requerimiento1 = new Requerimiento_1Dao();
        this.requerimiento2 = new Requerimiento_2Dao();
        this.requerimiento3 = new Requerimiento_3Dao();
    }

    public ArrayList<Requerimiento_1> consultarRequerimiento1() throws SQLException{
        return this.requerimiento1.ejecutarRequerimiento1();
    }

    public ArrayList<Requerimiento_2> consultarRequerimiento2() throws SQLException{
        return this.requerimiento2.ejecutarRequerimiento2();
    }

    public ArrayList<Requerimiento_3> consultarRequerimiento3() throws SQLException{
        return this.requerimiento3.ejecutarRequerimiento3();
    }
}
