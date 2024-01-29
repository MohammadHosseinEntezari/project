import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private static ArrayList<User> users = new ArrayList<>();
    private FileOutputStream UPM = new FileOutputStream("UPM.txt", true);
    private PrintStream printStream = new PrintStream(UPM);
    private String username;
    private String password;
    public User(String username, String password) throws IOException {
        users.add(this);
        this.username = username;
        this.password = password;
        printStream.append(username + " " + password + "\n");
        printStream.close();
    }
    public static boolean checkUsername(String username) {
        for (User u:users){
            if (u.username.equals(username)) return true;
        }
        return false;
    }
    public String getUsername() {
        return username;
    }

}
