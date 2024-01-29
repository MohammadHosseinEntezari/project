import java.io.IOException;
import java.util.Scanner;

public class SignUp {
    public static void showMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Please enter your username\n exit with 0");
            String username = scanner.nextLine();
            if (username.equals("0"))break;
            if (User.checkUsername(username)){
                System.out.println("This username already exists!");
                continue;
            }
            System.out.println("Please enter your password");
            String password = scanner.nextLine();
            User user = new User(username ,password);
            System.out.println("Your sign up was successful");
            break;
        }
    }
}
