package com.mycompany.proyectofinalprogramacion.usuario;

/**
 *
 * @author Nicolas Ribeiro
 */
public enum Genero {
    femenino("femenino"),
    masculino("masculino"),
    no_especificado("ns/nc");
    
    private final String valorEnBD;
    
    Genero(String valorEnDB){
        this.valorEnBD = valorEnDB;
    }
    
    public String obtenerValorParaBD(){
        return this.valorEnBD;
    }
    
    public static Genero desdeBD(String genero){
        return Genero.valueOf(genero);
    }
    
}
