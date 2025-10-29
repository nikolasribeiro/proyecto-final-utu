/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pronostica;

/**
 *
 * @author Juan de la Vega
 */
public class Pronostica {
    private String login;
    private int idEncuentro;
    private int resultadoLocal;
    private int resultadoVisita;

    public Pronostica (String login, int idEncuentro, int resultadoLocal, int resultadoVisita){
            this.login = login;
            this.idEncuentro = idEncuentro;
            this.resultadoLocal = resultadoLocal;
            this.resultadoVisita = resultadoVisita;
    }

    public String getLogin() {
        return login;
    }

    public int getIdEncuentro() {
        return idEncuentro;
    }

    public int getResultadoLocal() {
        return resultadoLocal;
    }

    public int getResultadoVisita() {
        return resultadoVisita;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setIdEncuentro(int idEncuentro) {
        this.idEncuentro = idEncuentro;
    }

    public void setResultadoLocal(int resultadoLocal) {
        this.resultadoLocal = resultadoLocal;
    }

    public void setResultadoVisita(int resultadoVisita) {
        this.resultadoVisita = resultadoVisita;
    }

}
