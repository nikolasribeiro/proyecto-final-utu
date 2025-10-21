package com.mycompany.proyectofinalprogramacion;

import com.mycompany.proyectofinalprogramacion.usuario.Genero;
import com.mycompany.proyectofinalprogramacion.usuario.User;
import com.mycompany.proyectofinalprogramacion.usuario.UserDAO;

/**
 *
 * @author Nicolas Ribeiro
 */
public class ProyectoFinalProgramacion {

    public static void main(String[] args) {
        // pruebas
        User user = new User();
        UserDAO userDao = new UserDAO();

        user.setLogin("test");
        user.setName("Test User");
        user.setPassword("1234");
        user.setGender(Genero.MASCULINO);
        user.setState("activo");
        user.setEmail("email@email.com");
        user.setPoints(10_000);

        // Creacion de usuario
        userDao.create(user);
        user.setName("Test User2");
        userDao.update(user);
    }
}
