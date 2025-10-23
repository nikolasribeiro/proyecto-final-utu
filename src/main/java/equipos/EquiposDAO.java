package equipos;

import com.mycompany.proyectofinalprogramacion.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EquiposDAO {

    /**
     * CREATE: Inserta un nuevo equipo en la base de datos.
     */
    public void agregarEquipo(Equipo equipo) {
        // Usamos "try-with-resources" para que la conexión y el statement se cierren solos
        String sql = "INSERT INTO equipo (nombre) VALUES (?)";
        
        try  {
            Connection conn = DBConnector.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, equipo.getNombre());
            pstmt.executeUpdate();
            System.out.println("Equipo agregado: " + equipo.getNombre());

        } catch (SQLException e) {
            System.err.println("Error al agregar equipo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * READ: Obtiene una lista de todos los equipos.
     */
    public List<Equipo> obtenerTodosLosEquipos() {
        List<Equipo> equipos = new ArrayList<>();
        String sql = "SELECT * FROM equipo";

        try  {
             Connection conn = DBConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                // Obtenemos los datos de cada fila
                int id = rs.getInt("idEquipo");
                String nombre = rs.getString("nombre");
                
                // Creamos un objeto Equipo y lo añadimos a la lista
                equipos.add(new Equipo(id, nombre));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener equipos: " + e.getMessage());
            e.printStackTrace();
        }
        return equipos;
    }
    
    /**
     * UPDATE: Actualiza el nombre de un equipo existente.
     */
    public void actualizarEquipo(Equipo equipo) {
        String sql = "UPDATE equipo SET nombre = ? WHERE idEquipo = ?";

        try  {
            Connection conn = DBConnector.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, equipo.getNombre());
            pstmt.setInt(2, equipo.getIdEquipo());
            
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Equipo actualizado (ID: " + equipo.getIdEquipo() + ")");
            } else {
                System.out.println("No se encontró el equipo (ID: " + equipo.getIdEquipo() + ")");
            }

        } catch (SQLException e) {
            System.err.println("Error al actualizar equipo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * DELETE: Elimina un equipo de la base de datos por su ID.
     */
    public void eliminarEquipo(int idEquipo) {
        String sql = "DELETE FROM equipo WHERE idEquipo = ?";

        try  {
            Connection conn = DBConnector.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idEquipo);
            
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Equipo eliminado (ID: " + idEquipo + ")");
            } else {
                System.out.println("No se encontró el equipo (ID: " + idEquipo + ")");
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar equipo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}