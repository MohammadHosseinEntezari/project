import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlayListMenu {
    private static File folder=new File("music");
    public static void showMenu(HashMap<String,ArrayList<Integer>> playLists){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Choose an option\n1-Show playlists\n2-Delete playlist\n3-create a playlist\n4-Exit");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    showPlayLists(playLists);
                    break;
                case 2:
                case 3:
                case 4:
                    return;
            }

        }


    }
    private static void showPlayLists(HashMap<String,ArrayList<Integer>> playLists){
        Scanner scanner=new Scanner(System.in);
        while (true){
            int counter=1;
            System.out.println("Choose an option:\n for exit enter 0");
            for(Map.Entry<String,ArrayList<Integer>> entry:playLists.entrySet()){
                System.out.println(counter+"-"+entry.getKey());
            }
            String choice=scanner.nextLine();
            if(choice.equals("0"))return;
            if(playLists.containsKey(choice)){
                showAPlayList(playLists.get(choice));
            }
            else System.out.println("invalid name");
        }
    }
    private static void showAPlayList(ArrayList<Integer> playlist){
        Scanner scanner=new Scanner(System.in);
        while (true){
            int counter=1;
            ArrayList<File> files=new ArrayList<>();
            System.out.println("Choose an option:\n for exit enter 0");
            for(Integer i:playlist){
                files.add(folder.listFiles()[i]);
                System.out.println(counter+"-"+folder.listFiles()[i].getName());
            }
            int choice=scanner.nextInt();
            if(choice==0)return;
            if(choice>=counter){
                System.out.println("invalid number!");
                continue;
            }
            MusicPlayer musicPlayer=new MusicPlayer(files,choice-1);
            musicPlayer.playMusic();
        }
    }
}
