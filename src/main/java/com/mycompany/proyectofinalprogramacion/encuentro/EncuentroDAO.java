/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalprogramacion.encuentro;

import com.mycompany.proyectofinalprogramacion.DBConnector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leo
 */
public class EncuentroDAO {
    //Listar encuentros
    public List<Encuentro> listar() {
        List<Encuentro> encuentros = new ArrayList<>();
        String sql = "SELECT e.idEncuentro, e.fecha, e.horaInicio, el.nombre AS NombreLocal, ev.nombre AS NombreVisita, e.resultadoLocal, e.resultadoVisita, e.estado, e.horaFin FROM encuentro AS e JOIN equipo AS el ON e.idLocal = el.idEquipo JOIN equipo AS ev ON e.idVisita = ev.idEquipo;";
        
        try 
            (Connection conn = DBConnector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){
            
            while (rs.next()) {
                Encuentro e = new Encuentro();
                e.setIdEncuentro(rs.getInt("idEncuentro"));
                e.setFecha(rs.getString("fecha"));
                e.setHoraInicio(rs.getString("horaInicio"));
                e.setHoraFin(rs.getString("horaFin"));
                e.setEstado(rs.getString("estado"));
                e.setNombreLocal(rs.getString("NombreLocal"));
                e.setNombreVisita(rs.getString("NombreVisita"));
                e.setResultadoLocal((Integer)rs.getObject("resultadoLocal"));
                e.setResultadoVisita((Integer)rs.getObject("resultadoVisita"));
                
                encuentros.add(e);
            }           
        } catch (SQLException ex) {
            System.out.println("Error al listar el encuentro: " + ex.getMessage());
        }
        return encuentros;    
    }
    // Agregar un encuentro
    public void agregarEncuentro (Date fecha, Time horaInicio, Time horaFin, String estado,
            int idLocal, int idVisita)
    {
        String sql = "INSERT INTO encuentro (fecha, horaInicio, horaFin, estado,idLocal, idVisita) VALUES (?,?,?,?,?,?)";
        
        try (Connection conn = DBConnector.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setDate(1, fecha);
            ps.setTime(2, horaInicio);
            ps.setTime(3, horaFin);
            ps.setString(4, estado);
            ps.setInt(5, idLocal);
            ps.setInt(6, idVisita);
            
            ps.executeUpdate();
            System.out.println("Encuentro agregado correctamente bro!");
        } catch (SQLException e){
            System.out.println("Algo hiciste mal pibe: " + e.getMessage());
        }
    }
    
    public void actualizarEncuentro(Encuentro encuentro){
       String query = "UPDATE encuentro SET estado=?, resultadoLocal=?, resultadoVisita=? WHERE idEncuentro = ?";
        try{
            Connection conn = DBConnector.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            
            statement.setString(1, encuentro.getEstado());
            statement.setObject(2, encuentro.getResultadoLocal());
            statement.setObject(3, encuentro.getResultadoVisita());
            statement.setInt(4, encuentro.getIdEncuentro());

            int affectedRows = statement.executeUpdate();
            
            if(affectedRows > 0){
                System.out.println("Encuentro '"+ encuentro.getIdEncuentro()+ "' actualizado correctamente");
            }else{
                System.out.println("El encuentro seleccionado no existe");
            }
            
            
        }catch(SQLException error){
            System.out.println("Algo salio mal durante la actualizacion del usuario: " + error.getMessage());
        } 
    }
    
    public Encuentro traerEncuentro (int idEncuentro) {
        String query = "SELECT * FROM encuentro WHERE idEncuentro= ?";
        Encuentro encuentro = null;
        try{
            Connection conn = DBConnector.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            
            statement.setInt(1, idEncuentro);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                encuentro = new Encuentro();
                encuentro.setIdEncuentro(result.getInt("idEncuentro"));
                encuentro.setFecha(result.getString("fecha"));
                encuentro.setHoraInicio(result.getString("horaInicio"));
                encuentro.setHoraFin(result.getString("horaFin"));
                encuentro.setEstado(result.getString("estado"));
                
                encuentro.setResultadoLocal(result.getInt("resultadoLocal"));
                encuentro.setResultadoVisita(result.getInt("resultadoVisita"));
                encuentro.setIdLocal(result.getInt("idLocal"));
                encuentro.setIdVisita(result.getInt("idVisita"));
            }
        }catch(SQLException error){
            System.out.println("Ocurrio un error al obtener el usuario: " + error.getMessage());
        }
        return encuentro;
    
    }
    
    // Eliminar un encuentro
    public void borrarEncuentro (int idEncuentro){
        String sql = "DELETE FROM encuentro WHERE idEncuentro =?";
        
        try (Connection conn = DBConnector.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setInt(1, idEncuentro);
            int filas = ps.executeUpdate();
            
            if (filas > 0){
                System.out.println("Encuentro eliminado correctamente");
            }else {
                System.out.println("No se encontro el encuentro con ID: " + idEncuentro);
            }
            
        }catch (SQLException e){
            if (e.getMessage().contains("foreign key")){
                System.out.println("No se puede eliminar el encuentro porque tiene pronosticos asociados");
            }else{
                System.out.println("Error al eliminar encuentro: " + e.getMessage());
            }
        }
    }
    
    
}
           