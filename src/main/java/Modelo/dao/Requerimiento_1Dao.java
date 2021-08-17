package Modelo.dao;

//Estructura de datos
import java.util.ArrayList;// es una coleccion que tiene tipo objeto

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import Util.JDBCUtilities;//importando clase util

import Modelo.vo.Requerimiento_1;//importando la clase requeri 1 DE mODELO.VO

public class Requerimiento_1Dao {
    public ArrayList<Requerimiento_1> ejecutarRequerimiento1() throws SQLException{

    ArrayList<Requerimiento_1> res = new ArrayList<Requerimiento_1>();
    Connection conexion = JDBCUtilities.getConnection();

    String consulta = "SELECT ID_Proyecto, Ciudad, Banco_Vinculado, Constructora, Clasificacion \n"
            + "FROM Proyecto \n"
            + "WHERE ( \n"
            + "Fecha_Inicio > '2019-12-31' \n"
            + "AND Clasificacion = 'Condominio')";
    
    PreparedStatement statement = conexion.prepareStatement(consulta);
    ResultSet resultSet = statement.executeQuery();

    while (resultSet.next()) {
        int id = resultSet.getInt("ID_Proyecto");
        String ciudad = resultSet.getString("Ciudad");
        String banco = resultSet.getString("Banco_Vinculado");
        String constructora = resultSet.getString("Constructora");
        String clasificacion = resultSet.getString("Clasificacion");

        Requerimiento_1 objTemp = new Requerimiento_1(id, ciudad, banco, constructora, clasificacion);
        res.add(objTemp);
    }
    
    resultSet.close();
    statement.close();

    return res;
   }
}

