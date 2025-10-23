package equipos;


import java.util.List;

/**
 * Clase principal para probar las operaciones CRUD del EquipoDAO.
 */
public class TestEquipos {

    public static void main(String[] args) {
        EquiposDAO dao = new EquiposDAO();

        // 1. INSERTAR (CREATE)
        System.out.println("--- Agregando Equipos ---");
        dao.agregarEquipo(new Equipo("Real Madrid"));
        dao.agregarEquipo(new Equipo("Barcelona"));
        dao.agregarEquipo(new Equipo("Liverpool"));

        // 2. LISTAR (READ)
        System.out.println("\n--- Lista de Equipos Actual ---");
        List<Equipo> equipos = dao.obtenerTodosLosEquipos();
        for (Equipo eq : equipos) {
            System.out.println(eq); // Llama al método toString()
        }

        // 3. ACTUALIZAR (UPDATE)
        // Vamos a actualizar el primer equipo de la lista
        if (!equipos.isEmpty()) {
            Equipo primerEquipo = equipos.get(0);
            System.out.println("\n--- Actualizando a '" + primerEquipo.getNombre() + "' ---");
            primerEquipo.setNombre("Real Madrid CF (Editado)");
            dao.actualizarEquipo(primerEquipo);
        }

        // 4. ELIMINAR (DELETE)
        // Vamos a eliminar el segundo equipo de la lista (si existe)
        if (equipos.size() > 1) {
            Equipo segundoEquipo = equipos.get(1);
            System.out.println("\n--- Eliminando a '" + segundoEquipo.getNombre() + "' ---");
            dao.eliminarEquipo(segundoEquipo.getIdEquipo());
        }

        // 5. LISTAR DE NUEVO
        System.out.println("\n--- Lista Final de Equipos ---");
        equipos = dao.obtenerTodosLosEquipos(); // Obtenemos la lista fresca
        for (Equipo eq : equipos) {
            System.out.println(eq);
        }
    }
}