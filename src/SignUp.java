import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class SignUp {
    public static void showMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Please enter your username\nexit with 0");
            String username = scanner.nextLine();
            if (username.equals("0"))break;
            if (User.checkUsername(username)){
                System.out.println("This username already exists!");
                continue;
            }
            System.out.println("Please enter your password");
            String password = scanner.nextLine();
            User user = new User(username ,password);
            PrintStream printStream=new PrintStream(new FileOutputStream("UPM.txt",true));
            printStream.append(username + " " + password + "\n");
            PrintStream txtCreator = new PrintStream(new FileOutputStream("usersPlayLists/"+username+".txt"));
            txtCreator.close();
            printStream.close();
            System.out.println("Your sign up was successful");
            break;
        }
    }
}
