/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pronostica;

import com.mycompany.proyectofinalprogramacion.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Juan de la Vega
 */
public class PronosticaDAO {
 
    public void create(Pronostica pronostico){
        String query = "INSERT INTO pronostica(login, idEncuentro, resultadoLocal, resultadoVisita) VALUES (?,?,?,?)";
        try{
            Connection conn = DBConnector.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            
            statement.setString(1, pronostico.getLogin());            
            statement.setInt(2, pronostico.getIdEncuentro());
            statement.setInt(3, pronostico.getResultadoLocal());
            statement.setInt(4, pronostico.getResultadoVisita());
            
            statement.executeUpdate();
            System.out.println("Usuario '"+pronostico.getLogin()+"' pronostico " + pronostico.getResultadoLocal()  + " a " + pronostico.getResultadoVisita() + " en encuentro N°" + pronostico.getIdEncuentro());
            
        }catch(SQLException error){
            System.out.println("Ocurrio un error al cargar el pronostico: " + error.getMessage());
        }
    }
}
