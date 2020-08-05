import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author rwendell
 */

//ONLY WORKS FOR ONE USER AS OF NOW

//TODO: HASH PASSWORDS
public class pwm {

    private static LinkedList<User> userList = new LinkedList<>();

    static void grabSavedUsers() throws IOException {

        File f = new File(System.getProperty("user.home") + "/.data_store");
        f.createNewFile();
        Scanner sc = new Scanner(f);


        User a = new User(sc.nextLine());
        while(sc.hasNextLine()){
            String u = sc.next();
            String p = sc.nextLine();
            a.addLogin(new Login(u,p));

        }

        userList.add(a);

    }

    static void saveData() throws IOException {

        File f = new File(System.getProperty("user.home") + "/.data_store");
        f.createNewFile();
        FileWriter fw = new FileWriter(f, false);
        String o = "";

        for(User a : userList){
            o += a.getPass() + System.lineSeparator();
            o += a.getLogins();
        }
        fw.write(o);
        fw.close();


    }

    public static void main(String[] args) throws IOException {

        try {
            grabSavedUsers();
        } catch (Exception e){
            System.err.println("No users detected, storing passwords for the first time");
        }


        Scanner sc = new Scanner( System.in );
        String input = "";

        System.out.println("Welcome to Pass Manager");
        System.out.println("New users type \"new\"");
        System.out.println("Existing users press enter");

        input = sc.nextLine().trim();
        if(input.equals("new")){
            System.out.println("Password?");
            User a = new User(sc.nextLine());
            userList.add(a);
            System.out.println("User created!" +  System.lineSeparator() + "Please type your password again to login");
        }else if(input.equals("clean")){
            userList.clear();
            saveData();
            System.exit(1);
        }
        else System.out.println("Password?");

        input = sc.nextLine();
        User user = null;

        for(User a : userList){
            if(a.getPass().equals(input)){
                user = a;
            }
        }

        if(user != null) {
            System.out.println("Welcome!");
            System.out.println("To add a user type \"add\", to see your passwords type \"print\", to exit type" +
                    " \"exit\"");
            while (sc.hasNext()) {

                String choice = sc.nextLine().trim();
                if (choice.equals("add")) {
                    System.out.println("Username?");
                    String un = sc.nextLine();
                    System.out.println("Password?");
                    String pw = sc.nextLine();
                    user.addLogin(new Login(un, pw));
                    System.out.println("User Added!");
                    System.out.println("type \"add\" \"print\" or \"exit\" to continue");

                } else if (choice.equals("print")) {
                    user.printLogins();
                    System.out.println("type \"add\" \"print\" or \"exit\" to continue");

                } else if(choice.equals("exit")){
                    saveData();
                    System.exit(0);
                }
            }
        }else System.out.println("Invalid Password");
    }
}
