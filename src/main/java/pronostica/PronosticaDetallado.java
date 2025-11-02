package pronostica;

import java.util.Date;


/**
 *
 * @author Nicolas Ribeiro
 */

public class PronosticaDetallado {
    private String login; // login es el usuario no administrador
    private String nombreUsuario;
    private Date fecha;
    private String nombreLocal; // Nombre del equipo locatario
    private String nombreVisita; // Nombre del equipo visitante
    
    private int prediccionLocal; // La prediccion que hace el usuario para el locatario
    private int prediccionVisita; //La prediccion que hace el usuaruio para el visitante
    
    // Se usa Integer, porque existen resultados o valores nulos. 
    private Integer resultadoRealLocal; //El resultado final del partido, introducido por el administrador Locatario
    private Integer resultadoRealVisita; //El resultado final del partido, introducido por el administrador Visitante
    
    public PronosticaDetallado() {}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    public String getNombreVisita() {
        return nombreVisita;
    }

    public void setNombreVisita(String nombreVisita) {
        this.nombreVisita = nombreVisita;
    }

    public int getPrediccionLocal() {
        return prediccionLocal;
    }

    public void setPrediccionLocal(int prediccionLocal) {
        this.prediccionLocal = prediccionLocal;
    }

    public int getPrediccionVisita() {
        return prediccionVisita;
    }

    public void setPrediccionVisita(int prediccionVisita) {
        this.prediccionVisita = prediccionVisita;
    }

    public Integer getResultadoRealLocal() {
        return resultadoRealLocal;
    }

    public void setResultadoRealLocal(Integer resultadoRealLocal) {
        this.resultadoRealLocal = resultadoRealLocal;
    }

    public Integer getResultadoRealVisita() {
        return resultadoRealVisita;
    }

    public void setResultadoRealVisita(Integer resultadoRealVisita) {
        this.resultadoRealVisita = resultadoRealVisita;
    }
    
    
}
