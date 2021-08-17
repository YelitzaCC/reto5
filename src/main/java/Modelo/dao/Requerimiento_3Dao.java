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

import Modelo.vo.Requerimiento_3;

public class Requerimiento_3Dao {
    
    public ArrayList<Requerimiento_3> ejecutarRequerimiento3() throws SQLException{
    
    ArrayList<Requerimiento_3> res = new ArrayList<Requerimiento_3>();
    Connection conexion = JDBCUtilities.getConnection();

    String consulta = "SELECT c.Proveedor, c.Pagado, p.Constructora \n" 
        + "FROM Compra c \n"
        + "INNER JOIN Proyecto p \n"
        + "ON c.ID_Proyecto = p.ID_Proyecto \n"
        + "WHERE (Proveedor = 'JUMBO') AND (Pagado = 'No')";
    
    PreparedStatement statement = conexion.prepareStatement(consulta);
    ResultSet resultSet = statement.executeQuery();

    while (resultSet.next()) {
        String proveedor = resultSet.getString("Proveedor");
        String pagado = resultSet.getString("Pagado");
        String constructora = resultSet.getString("Constructora");


        Requerimiento_3 objTemp = new Requerimiento_3(proveedor, pagado, constructora);
        res.add(objTemp);
    }
    
    resultSet.close();
    statement.close();

    return res;
   }
}
