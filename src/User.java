import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private static ArrayList<User> users = new ArrayList<>();

    private String username;
    private String password;

    public User(String username, String password) throws IOException {
        users.add(this);
        this.username = username;
        this.password = password;
    }

    public static boolean checkLogin(String username, String password) {
        for (User u : users) {
            if(u.username.equals(username) && u.password.equals(password)) return true;
        }
        return false;
    }
    public static void readUsers(){
        try {
            Scanner scanner = new Scanner(new File("UPM.txt"));
            while(scanner.hasNext()){
                String[] info = scanner.nextLine().split(" ");
                users.add(new User(info[0],info[1] ));
                if(info.length==1)break;
            }
        }catch (Exception e){
            System.out.println();
        }
    }

    public static boolean checkUsername(String username) {
        for (User u : users) {
            if (u.username.equals(username)) return true;
        }
        return false;
    }

    public String getUsername() {
        return username;
    }

}
