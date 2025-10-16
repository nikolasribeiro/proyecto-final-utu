package com.mycompany.proyectofinalprogramacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nicolas Ribeiro
 * Esta clase funcionara como un singleton para tener 1 sola instancia de conexion a la base de datos
 * y mejorar el performance general de la aplicacion
 */
public class DBConnector {
    private static final String JDBC_URI = "jdbc:mysql://localhost:3306/yoparamidb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    
    private static Connection connection = null;
    
    private DBConnector(){}
    
    public static Connection getConnection() throws SQLException {
        System.out.println("Inicializando la base de datos...");
        if(connection == null || connection.isClosed()){
            try{
                connection = DriverManager.getConnection(JDBC_URI, USERNAME, PASSWORD);
                System.out.println("Conexion con la base de datos establecida!");
            }catch( SQLException error){
                throw new SQLException("Ocurrio un error al inicializar la base de datos" + error.getMessage());
            }
        }
        
        return connection;
    }
    
    public static void closeConnection(){
        try{
            if(connection != null | !connection.isClosed()){
                System.out.println("Cerrando la conexion a la base de datos");
                connection.close();
                System.out.println("Conexion cerrada.");
            }
        }catch(SQLException error){
            System.out.println("Algo salio mal durante el proceso de cierre de conexion: " + error.getMessage());
        }
    }
    
}
