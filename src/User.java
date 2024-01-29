import java.io.*;
import java.util.Scanner;

public class User {
    private FileOutputStream UPM = new FileOutputStream("UPM.txt", true);
    private PrintStream printStream = new PrintStream(UPM);
    private String username;
    private String password;
    public User(String username, String password) throws IOException {
        this.username = username;
        this.password = password;
        printStream.append(username + " " + password + "\n");
        printStream.close();
    }

    public String getUsername() {
        return username;
    }
}
