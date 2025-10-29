/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalprogramacion.encuentro;

/**
 *
 * @author Leo
 */
public class Encuentro {
    // Modelo de la tabla encuentro ;)
    private int idEncuentro;
    private String fecha;
    private String horaInicio;
    private String horaFin;
    private String estado; // Posibles estados: habilitado, jugando y finalizado
    private String nombreLocal;
    private String nombreVisita;
    private Integer resultadoLocal;
    private Integer resultadoVisita;
    private int idLocal;
    private int idVisita;  
    
    // Constructor vacio
    public Encuentro () {
        
    }
    
    // Constructor con los campos

    public Encuentro(int idEncuentro, String fecha, String horaInicio, String horaFin,
            String estado, Integer resultadoLocal, Integer resultadoVisita, int idLocal, int idVisita) {
        
        this.idEncuentro = idEncuentro;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estado = estado;
        this.resultadoLocal = resultadoLocal;
        this.resultadoVisita = resultadoVisita;
        this.idLocal = idLocal;
        this.idVisita = idVisita;
    }
    
    // Getters & Setters

    public int getIdEncuentro() {
        return idEncuentro;
    }

    public void setIdEncuentro(int idEncuentro) {
        this.idEncuentro = idEncuentro;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }
    
    public String getNombreLocal(){
        return this.nombreLocal;
    }
    
    public String getNombreVisita(){
        return this.nombreVisita;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getResultadoLocal() {
        return resultadoLocal;
    }

    public void setResultadoLocal(Integer resultadoLocal) {
        this.resultadoLocal = resultadoLocal;
    }

    public Integer getResultadoVisita() {
        return resultadoVisita;
    }

    public void setResultadoVisita(Integer resultadoVisita) {
        this.resultadoVisita = resultadoVisita;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public int getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }
    
    public void setNombreLocal(String nombre){
        this.nombreLocal = nombre;
    }
    
    public void setNombreVisita(String nombre){
        this.nombreVisita = nombre;
    }

    @Override
    public String toString() {
        return "Esto es una instancia de la clase de tipo Encuentro... local: " + this.getNombreLocal() + " - Visita: " + this.getNombreVisita();
    }
    
    
    
    
}
