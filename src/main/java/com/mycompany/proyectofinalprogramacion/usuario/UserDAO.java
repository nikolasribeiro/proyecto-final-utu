package com.mycompany.proyectofinalprogramacion.usuario;

import com.mycompany.proyectofinalprogramacion.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nicolas Ribeiro
 */
public class UserDAO {
    public void create(User user){
        String query = "INSERT INTO usuarios(login, nombre, contraseña, genero, correo, estado, puntos) VALUES (?,?,?,?,?,?,?)";
        try{
            Connection conn = DBConnector.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            
            statement.setString(1, user.getLogin());            
            statement.setString(2, user.getName());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getGender().obtenerValorParaBD());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getState());
            statement.setInt(7, user.getPoints());
            statement.executeUpdate();
            System.out.println("Usuario '"+user.getLogin()+"' creado exitosamente");
            
        }catch(SQLException error){
            System.out.println("Ocurrio un error al crear el usuario: " + error.getMessage());
        }
    }
    
    public User get(String login){
        String query = "SELECT * FROM usuario WHERE login= ?";
        User user = null;
        try{
            Connection conn = DBConnector.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            
            statement.setString(1, login);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                user = new User();
                user.setLogin(result.getString("login"));
                user.setName(result.getString("nombre"));
                user.setPassword(result.getString("contraseña"));
                user.setGender(Genero.desdeBD(result.getString("genero")));
                user.setEmail(result.getString("correo"));
                user.setState(result.getString("estado"));
                user.setPoints(result.getInt("puntos"));
            }
        }catch(SQLException error){
            System.out.println("Ocurrio un error al obtener el usuario: " + error.getMessage());
        }
        return user;
    }
    
    public void update(User user){
        String query = "UPDATE usuario SET nombre = ?, contraseña=?, genero=?,correo=?,estado=?,puntos=? WHERE login = ?";
        try{
            Connection conn = DBConnector.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getGender().obtenerValorParaBD());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getState());
            statement.setInt(6, user.getPoints());
            statement.setString(7, user.getLogin());
            
            int affectedRows = statement.executeUpdate();
            
            if(affectedRows > 0){
                System.out.println("Usuario '"+user.getLogin()+"' actualizado correctamente");
            }else{
                System.out.println("El usuario seleccionado no existe");
            }
            
            
        }catch(SQLException error){
            System.out.println("Algo salio mal durante la actualizacion del usuario: " + error.getMessage());
        }
        
    
    }

    public void delete (String login){
        String query = "DELETE FROM usuario WHERE login = ?";
        
        try{
            Connection conn = DBConnector.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            
            statement.setString(1, login);
            
            int affectedRows = statement.executeUpdate();
            
            if(affectedRows > 0){
                System.out.println("Usuario '"+login+"' eliminado correctamente.");
            }else{
                System.out.println("No se encontro un usuario con el ID: "+login);
            }
            
        }catch(SQLException error){
            System.out.println("Algo salio mal al eliminar el usuario: "+error.getMessage());
        }
    }
}
