package usuarios;

/**
 *
 * @author Nicolas Ribeiro, Juan de la Vega, Nicolas Pereyra
 */
public enum Estado {
    activo("activo"),
    banneado("banneado");
    
    private final String valorEnBD;
    
    Estado(String estado){
        this.valorEnBD = estado;
    }
    
    public String obtenerValorParaBD(){
        return this.valorEnBD;
    }
    
    public static Estado desdeBD(String estado){
        return Estado.valueOf(estado);
    }
    
    @Override
    public String toString(){
        return this.valorEnBD;
    }
}
