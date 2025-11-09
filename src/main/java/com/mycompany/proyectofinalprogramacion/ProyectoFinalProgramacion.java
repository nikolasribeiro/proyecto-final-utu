package com.mycompany.proyectofinalprogramacion;

class Moto {
    private int totalCombustible = 100;

    Moto() {
        System.out.println("Se instancio la clase Moto");
    }

    public void prender() {
        if (totalCombustible <= 0) {
            System.out.println("No prende, no tenes combustible");
            return;
        }

        System.out.println("Se prendio la moto");
    }

    public void acelerar() {
        if (totalCombustible == 0) {
            apagar();
            return;
        }

        System.out.println("Se esta acelerando la moto");
        totalCombustible = totalCombustible - 10;
    }
    
    public void medidorDeCombustible() {
        System.out.println("Tenes en el tanque, lo siguiente: " + totalCombustible);
    }

    public void apagar() {
        System.out.println("La moto se apago.");
    }

    public void cargarCombustible(int litrosACargar) {
        if (this.totalCombustible >= 100) {
            System.out.println("El tanque esta lleno");
            return;
        }
        this.totalCombustible = this.totalCombustible + litrosACargar;
    }
}

public class ProyectoFinalProgramacion {

    public static void main(String[] args) {
     // tipo   instancia          = clase();
        Moto   nicoYaEstaEnLaMoto = new Moto();
        
        nicoYaEstaEnLaMoto.prender();
        nicoYaEstaEnLaMoto.acelerar();
        nicoYaEstaEnLaMoto.medidorDeCombustible();
        nicoYaEstaEnLaMoto.acelerar();
        nicoYaEstaEnLaMoto.acelerar();
        nicoYaEstaEnLaMoto.acelerar();
        nicoYaEstaEnLaMoto.acelerar();
        nicoYaEstaEnLaMoto.acelerar();
        nicoYaEstaEnLaMoto.acelerar();
        nicoYaEstaEnLaMoto.acelerar();
        nicoYaEstaEnLaMoto.medidorDeCombustible();
        nicoYaEstaEnLaMoto.cargarCombustible(30);
        nicoYaEstaEnLaMoto.medidorDeCombustible();
        nicoYaEstaEnLaMoto.cargarCombustible(30);
        nicoYaEstaEnLaMoto.medidorDeCombustible();
        nicoYaEstaEnLaMoto.cargarCombustible(30);
        nicoYaEstaEnLaMoto.cargarCombustible(30);
        nicoYaEstaEnLaMoto.cargarCombustible(30);
        nicoYaEstaEnLaMoto.cargarCombustible(30);
        nicoYaEstaEnLaMoto.cargarCombustible(30);
        nicoYaEstaEnLaMoto.cargarCombustible(30);
        nicoYaEstaEnLaMoto.cargarCombustible(30);
        nicoYaEstaEnLaMoto.cargarCombustible(30);
        nicoYaEstaEnLaMoto.cargarCombustible(30);
        nicoYaEstaEnLaMoto.cargarCombustible(30);
        nicoYaEstaEnLaMoto.cargarCombustible(30);
        nicoYaEstaEnLaMoto.cargarCombustible(30);
        nicoYaEstaEnLaMoto.cargarCombustible(30);
        nicoYaEstaEnLaMoto.cargarCombustible(30);
        nicoYaEstaEnLaMoto.cargarCombustible(30);
        nicoYaEstaEnLaMoto.cargarCombustible(30);

        nicoYaEstaEnLaMoto.acelerar();
        nicoYaEstaEnLaMoto.medidorDeCombustible();
        nicoYaEstaEnLaMoto.medidorDeCombustible();
    }
}
