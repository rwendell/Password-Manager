import java.util.LinkedList;

/**
 * @author rwendell
 */
public class User {

    private LinkedList<Login> logins = new LinkedList<>();
    private String pw;


    User(String pw){
        this.pw = pw;
    }

    void addLogin(Login a){
        logins.add(a);
    }

    String getPass(){
        return pw;
    }

    void printLogins(){
        String o = "";
        for(Login a : logins){
            o += "Username: " + a.getUsername() + " Password: " + a.getPassword() + System.lineSeparator();
        }
        System.out.println(o.trim());
    }

    String getLogins(){
        String o = "";
        for(Login a : logins){
            o += a.getUsername() + " " + a.getPassword() + System.lineSeparator();
        }
        return o.trim();
    }
}
