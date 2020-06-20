package Models;

public class Usuario {

    public Usuario(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
    
    public Usuario(int id, String userName){
        this.id = id;
        this.userName = userName;
    }
    
    private int id;
    private String userName;
    private String password;

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void actulizarUsuario(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
}
