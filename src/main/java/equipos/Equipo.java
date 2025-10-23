/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipos;

/**
 *
 * @author Nicolas Pereyra
 */
public class Equipo {
    private int idEquipo;
    private String nombre;
    // Constructor para cuando creamos un nuevo equipo (el ID es autogenerado)
    public Equipo(String nombre) {
        this.nombre = nombre;
    }
    // Constructor para cuando leemos un equipo de la BD (ya tiene ID)
    public Equipo(int idEquipo, String nombre) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
    }
    // --- Getters y Setters ---
    
    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Un método toString() es útil para imprimir el objeto
    @Override
    public String toString() {
        return "Equipo [ID=" + idEquipo + ", Nombre=" + nombre + "]";
    }
}
