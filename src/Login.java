import java.util.Scanner;

public class Login {

    public static void loginMenu() {
        Scanner scanner = new Scanner(System.in);
        while(true){
            User.readUsers();
            System.out.println("Please enter your username \nexit with 0");
            String username = scanner.nextLine();
            if (username.equals("0")) break;
            System.out.println("Please enter your password");
            String password = scanner.nextLine();
            if (User.checkLogin(username, password)) {
                System.out.println("Welcome!");
            }
            else System.out.println("Username or password is not correct!");
        }

    }
}
