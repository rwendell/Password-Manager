/**
 * @author rwendell
 */
public class Login {

    private String un;
    private String pw;

    Login(String un, String pw){
        this.un = un;
        this.pw = pw;
    }

    String getUsername(){
        return un;
    }

    String getPassword(){
        return pw;
    }


}
