package usuarios;

/**
 *
 * @author Nicolas Ribeiro, Leandro Conte, Nicolas Pereyra
 */
public enum Rol {
    admin("admin"),
    user("user");
    
    private final String valorEnBD;
    
    Rol(String rol){
        this.valorEnBD = rol;
    }
    
    public String obtenerValorParaBD(){
        return this.valorEnBD;
    }
    
    public static Rol desdeBD(String rol){
        return Rol.valueOf(rol);
    }
    
    @Override
    public String toString(){
        return this.valorEnBD;
    }
}
