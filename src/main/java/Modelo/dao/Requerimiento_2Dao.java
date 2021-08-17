package Modelo.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import Util.JDBCUtilities;

import Modelo.vo.Requerimiento_2;

public class Requerimiento_2Dao {
    public ArrayList<Requerimiento_2> ejecutarRequerimiento2() throws SQLException{

        ArrayList<Requerimiento_2> res = new ArrayList<Requerimiento_2>();
        Connection conexion = JDBCUtilities.getConnection();
    
        String consulta = "SELECT Nombre,Primer_Apellido, Ciudad_Residencia,Cargo,Salario FROM Lider WHERE (Cargo = 'Asesor' OR Cargo = 'Coordinador') AND (Salario <= 510000)";
        
        PreparedStatement statement = conexion.prepareStatement(consulta);
        ResultSet resultSet = statement.executeQuery();
    
        while (resultSet.next()) {
            String nombre = resultSet.getString("Nombre");
            String primerA = resultSet.getString("Primer_Apellido");
            String ciudad = resultSet.getString("Ciudad_Residencia");
            String cargo = resultSet.getString("Cargo");
            int salario = resultSet.getInt("Salario");
    
            Requerimiento_2 objTemp = new Requerimiento_2(nombre, primerA, ciudad, cargo, salario);
            res.add(objTemp);
        }
        
        resultSet.close();
        statement.close();
    
        return res;
       }
}

