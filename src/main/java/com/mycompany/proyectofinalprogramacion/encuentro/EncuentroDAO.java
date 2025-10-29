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
    
    public List<Encuentro> listar() {
        List<Encuentro> encuentros = new ArrayList<>();
        String sql = "SELECT * FROM encuentro";
        
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
                e.setResultadoLocal((Integer)rs.getObject("resultadoLocal"));
                e.setResultadoVisita((Integer)rs.getObject("resultadoVisita"));
                e.setIdLocal(rs.getInt("idLocal"));
                e.setIdVisita(rs.getInt("idVisita"));
                
                encuentros.add(e);
            }           
        } catch (SQLException ex) {
            System.out.println("Error al listar el encuentro: " + ex.getMessage());
        }
        return encuentros;    
    }
    
    public void agregarEncuentro (Date fecha, Time horaInicio, Time horaFin, String estado,
            int idLocal, int idVisita){
        String sql = "INSERT INTO encuentro (fecha, horaInicio, horaFin, estado,idLocal, idVisita) VALUES (?,?,?,?,?,?)";
        
        try (Connection conn = DBConnector.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setDate(1, fecha);
            ps.setTime(2, horaInicio);
            ps.setTime(3, horaFin);
            ps.setString(4, estado);
            ps.setInt(5, idLocal);
            ps.setInt(6, idLocal);
            
            ps.executeUpdate();
            System.out.println("Encuentro agregado correctamente bro!");
        } catch (SQLException e){
            System.out.println("Algo hiciste mal pibe: " + e.getMessage());
        }
    }
    
}
           