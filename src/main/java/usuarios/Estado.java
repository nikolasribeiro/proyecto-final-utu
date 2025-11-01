package usuarios;

/**
 *
 * @author Nicolas Ribeiro, Juan de la Vega, Nicolas Pereyra
 */
public enum Estado {
    activo("activo"),
    baneado("baneado");
    
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
}
