package usuarios;

/**
 *
 * @author Nicolas Ribeiro
 */
public class User {
    private String login;
    private String name;
    private String password;
    private Genero gender;
    private String email;
    private Estado state; // Posibles estados: "baneado" | "activo"
    private Rol role;
    private int points;

    
    
    public User(){}
    
    public User(String login){
        this.login = login;
    }
    
    public User(String login, String name, String password, Genero gender, String email){
        this.login = login;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.state = Estado.activo;
        this.points = 0;
    }
    
    public User(String login, String name, String password, Genero gender, String email, String state, int points){
        this.login = login;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.state = Estado.activo;
        this.points = points;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Genero getGender() {
        return gender;
    }
    
    public Rol getRole(){
        return role;
    }

    public void setGender(Genero gender) {
        this.gender = gender;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Estado getState() {
        return state;
    }

    public void setState(Estado state) {
        this.state = state;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    public void setRole(Rol role){
       this.role = role;
    }
}
