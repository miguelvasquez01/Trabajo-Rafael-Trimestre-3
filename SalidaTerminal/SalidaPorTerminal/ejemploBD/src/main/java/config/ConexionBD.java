package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    public static Connection getConexion(){
        // Datos de conexión
        // Cambia por tu nombre de base de datos
        String url = "jdbc:mysql://localhost:3306/tienda";         
        // Cambia por tu usuario de la base de datos
        String usuario = "root";         
        // Cambia por tu contraseña de la base de datos
        String clave = "Sena1234"; 

        // Intentar establecer la conexión
        Connection conexion = null;
        
        
        try {
            /*Eliminar -> Connection*/ 
            conexion = DriverManager.getConnection(url,usuario,clave);
            System.out.println("Conexión exitosa a la base de datos.");
            //conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        } 
        // Devuelve el objeto conexion
        return conexion;
    }
    
    
    public static void closeConexion(Connection conexion){
       
        try{
            conexion.close();
            System.out.println("Se cerro la conexion de "
                    + "forma exitosa");
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion"
                    + "base de datos: " + e.getMessage());
        }
        }
    
}
