package com.mycompany.proyectofinalprogramacion;

import com.mycompany.proyectofinalprogramacion.usuario.Estado;
import com.mycompany.proyectofinalprogramacion.usuario.Genero;
import com.mycompany.proyectofinalprogramacion.usuario.User;
import com.mycompany.proyectofinalprogramacion.usuario.UserDAO;

/**
 *
 * @author Nicolas Ribeiro
 */
public class ProyectoFinalProgramacion {

    public static void main(String[] args) {
        //Este objeto vive en memoria
        User user1 = new User(); 
        User user2 = new User();
        
        // Este objeto es el intermediario entre 
        //el objeto en memoria y la base de datos.
        UserDAO userDao = new UserDAO(); 
        
        user1.setLogin("test");
        user1.setName("Test User");
        user1.setPassword("1234");
        user1.setGender(Genero.masculino);
        user1.setState(Estado.activo);
        user1.setEmail("email@email.com");
        user1.setPoints(10_000);

        // Creacion de usuario
        //userDao.create(user1);
        //System.out.println("Nombre inicial: "+user1.getName());
        user1.setName("Test User2");
        //System.out.println("Nombre actualizado: "+user1.getName());
        //userDao.update(user1);
        
        // Creacion de usuario 2
        user2.setLogin("test2");
        user2.setName("Test User3");
        user2.setPassword("1234");
        user2.setGender(Genero.femenino);
        user2.setState(Estado.activo);
        user2.setEmail("email@email.com");
        user2.setPoints(2);
        
        //userDao.create(user2);
        
        // Traer un dato de la base de datos
        User user3 = userDao.get("test");
        System.out.println("Nombre: " + user3.getName());
        
        if(user3.getState().equals("baneado")){
            System.out.println("Usted cago fuego");
            
        }else{
            System.out.println("Usted puede pasar");
        }

        System.out.println("Estado: " + Estado.activo);
    }
}
