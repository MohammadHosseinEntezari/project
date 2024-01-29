import java.util.Scanner;

public class ProfileMenu {
    public static void showMenu() {
        System.out.println("Please choose an option\n1-Show playlists\n2-Show all musics\n3-Exit");
        Scanner scanner = new Scanner(System.in);
        while (true){
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    break;
                case 2:

                    MusicMenu.showMenu();
                    break;
                case 3:
                    return;

            }
        }
    }
}
