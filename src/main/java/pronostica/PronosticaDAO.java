/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pronostica;

import com.mycompany.proyectofinalprogramacion.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan de la Vega
 */
public class PronosticaDAO {

    public List<Pronostica> listar() {
        List<Pronostica> pronosticos = new ArrayList<>();
        String sql = "SELECT login, idEncuentro, resultadoLocal, resultadoVisita FROM pronostica"; // Seleccionamos todas las columnas

        // Usamos try-with-resources para asegurar el cierre automático
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Pronostica p = new Pronostica();
                p.setLogin(rs.getString("login"));
                p.setIdEncuentro(rs.getInt("idEncuentro"));
                p.setResultadoLocal(rs.getInt("resultadoLocal"));
                p.setResultadoVisita(rs.getInt("resultadoVisita"));
                pronosticos.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(" Error al listar los pronósticos: " + ex.getMessage());
        }
        return pronosticos;
    }
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
    
    public void delete(int idEncuentro) {
        String query = "DELETE FROM pronostica WHERE idEncuentro = ?;";
        try{
            Connection conn = DBConnector.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            
            statement.setInt(1, idEncuentro);
            statement.executeUpdate();
            System.out.println("Encuentro '"+ idEncuentro + "' Eliminado correctamente.");
            
        }catch(SQLException error){
            System.out.println("Ocurrio un error al cargar el pronostico: " + error.getMessage());
        }
    }
}