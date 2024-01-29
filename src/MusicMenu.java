import java.io.File;
import java.util.Scanner;

public class MusicMenu {
    public static void showMenu() {
        File folder = new File("musics");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose a song to play or type 0 to exit");
            int counter = 1;
            for (File f : folder.listFiles()) {
                System.out.println(counter + "-" + f.getName());

                counter++;
            }
            int num = scanner.nextInt();
            if (num== 0) return;
            if (num>=counter){
                System.out.println("invalid number!");
                continue;
            }
            MusicPlayer musicPlayer=new MusicPlayer(folder,num-1);
            musicPlayer.playMusic();
        }
    }
}
