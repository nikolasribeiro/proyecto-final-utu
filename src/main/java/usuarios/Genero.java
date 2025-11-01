package usuarios;

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
        if(genero.equals("ns/nc")){
            return Genero.no_especificado;
        }
        return Genero.valueOf(genero);
    }

}
