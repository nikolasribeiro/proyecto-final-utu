package pronostica;

import com.mycompany.proyectofinalprogramacion.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import usuarios.User;

/**
 *
 * @author Nicolas Ribeiro
 */
public class PronosticoDetalladoDAO {

    private String BASE_SQL_JOIN
            = "SELECT"
            + " p.login, "
            + " u.nombre AS NombreUsuario, "
            + " e.fecha, "
            + " el.nombre AS NombreLocal, "
            + " ev.nombre AS NombreVisita, "
            + " p.resultadoLocal AS PrediccionLocal, "
            + " p.resultadoVisita AS PrediccionVisita, "
            + " e.idEncuentro as idEncuentro, "
            + " e.resultadoLocal AS ResultadoRealLocal, "
            + " e.resultadoVisita AS ResultadoRealVisita "
            + "FROM "
            + " pronostica AS p "
            + "JOIN "
            + " usuario AS u ON p.login = u.login "
            + "JOIN "
            + " encuentro AS e ON p.idEncuentro = e.idEncuentro "
            + "JOIN "
            + " equipo AS el ON e.idLocal = el.idEquipo "
            + "JOIN "
            + " equipo AS ev ON e.idVisita = ev.idEquipo";

    public List<PronosticaDetallado> listarTotalDePronosticosConDatosAdicionales() {
        List<PronosticaDetallado> pronosticosDetallados = new ArrayList<>();
        String sql = BASE_SQL_JOIN + " ORDER BY idEncuentro DESC;";

        try {
            Connection conn = DBConnector.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PronosticaDetallado p = new PronosticaDetallado();
                p.setLogin(rs.getString("login"));
                p.setNombreUsuario(rs.getString("NombreUsuario"));
                p.setFecha(rs.getDate("fecha"));
                p.setNombreLocal(rs.getString("NombreLocal"));
                p.setNombreVisita(rs.getString("NombreVisita"));
                p.setPrediccionLocal(rs.getInt("PrediccionLocal"));
                p.setPrediccionVisita(rs.getInt("PrediccionVisita"));
                p.setEncuentroId(rs.getInt("idEncuentro"));
                p.setResultadoRealLocal(rs.getObject("ResultadoRealLocal", Integer.class));
                p.setResultadoRealVisita(rs.getObject("ResultadoRealVisita", Integer.class));

                pronosticosDetallados.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(" Error al listar los pronósticos: " + ex.getMessage());
        }

        return pronosticosDetallados;
    }
    
    
    public List<PronosticaDetallado> listarTotalDePronosticosConDatosAdicionalesPorUsuario(User user) {
        List<PronosticaDetallado> pronosticosDetallados = new ArrayList<>();
        String sql = BASE_SQL_JOIN + " WHERE p.login = ? ORDER BY idEncuentro DESC;";

        try {
            Connection conn = DBConnector.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getLogin());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PronosticaDetallado p = new PronosticaDetallado();
                p.setLogin(rs.getString("login"));
                p.setNombreUsuario(rs.getString("NombreUsuario"));
                p.setFecha(rs.getDate("fecha"));
                p.setNombreLocal(rs.getString("NombreLocal"));
                p.setNombreVisita(rs.getString("NombreVisita"));
                p.setPrediccionLocal(rs.getInt("PrediccionLocal"));
                p.setPrediccionVisita(rs.getInt("PrediccionVisita"));
                p.setEncuentroId(rs.getInt("idEncuentro"));
                p.setResultadoRealLocal(rs.getObject("ResultadoRealLocal", Integer.class));
                p.setResultadoRealVisita(rs.getObject("ResultadoRealVisita", Integer.class));

                pronosticosDetallados.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(" Error al listar los pronósticos: " + ex.getMessage());
        }

        return pronosticosDetallados;
    }
}
