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
            User user = User.checkLogin(username, password);
            if (user!=null) {
                System.out.println("Welcome!");
                ProfileMenu.showMenu(user);
            }
            else System.out.println("Username or password is not correct!");
        }

    }
}
