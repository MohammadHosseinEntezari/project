
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, JavaLayerException {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Choose an option from the menu \n1-Sign up\n2-Log in\n3-Exit");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    SignUp.showMenu();
                    break;
                case 2:
                    Login.loginMenu();
                    break;
                case 3:
                    return;
            }

        }
    }
}