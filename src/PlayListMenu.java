import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlayListMenu {
    private static File folder = new File("musics");

    public static void showMenu(HashMap<String, ArrayList<Integer>> playLists) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an option\n1-Show playlists\n2-Delete playlist\n3-create a playlist\n4-Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showPlayLists(playLists);
                    break;
                case 2:
                    playlistDeleter(playLists);
                    break;
                case 3:
                    playlistCreator(playLists);
                case 4:
                    return;
            }

        }


    }

    private static void playlistCreator(HashMap<String, ArrayList<Integer>> playListsInfo) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("please enter the name of the playlist you want to make\ntype 0 for exit");
            String name = scanner.nextLine();
            if(name.equals("0"))return;
            if (playListsInfo.containsKey(name)){
                System.out.println("this playlist already exists!");
                continue;
            }
            ArrayList<Integer> indexes = new ArrayList<>();
            int counter = 1;
            System.out.println("Please choose the music you want to add to playlist\nor type 0 to exit");
            for (File f : folder.listFiles()) {
                System.out.println(counter + "-" + f.getName());
                counter++;
            }
            while (true){
                int index = scanner.nextInt();
                if(index==0)break;
                if (index>=counter) {
                    System.out.println("invalid number");
                    continue;
                }
                indexes.add(index-1);
                System.out.println("music successfully added to "+ name +" playlist");
            }
            scanner.nextLine();
            playListsInfo.put(name, indexes);
            break;
        }
    }
        private static void playlistDeleter (HashMap < String, ArrayList < Integer >> playListsInfo){
            Scanner scanner = new Scanner(System.in);
            while (true) {
                int counter = 1;
                System.out.println("Please enter the name of the playlist you want to delete\nor type 0 to close");
                for (Map.Entry<String, ArrayList<Integer>> entry : playListsInfo.entrySet()) {
                    System.out.println(counter + "-" + entry.getKey());
                    counter++;
                }
                String choice = scanner.nextLine();
                if (choice.equals("0")) return;
                if (playListsInfo.containsKey(choice)) {
                    playListsInfo.remove(choice);
                } else System.out.println("invalid name");
            }
        }
        private static void showPlayLists (HashMap < String, ArrayList < Integer >> playListsInfo){
            Scanner scanner = new Scanner(System.in);
            while (true) {
                int counter = 1;
                System.out.println("Choose an option:\nfor exit enter 0");
                for (Map.Entry<String, ArrayList<Integer>> entry : playListsInfo.entrySet()) {
                    System.out.println(counter + "-" + entry.getKey());
                    counter++;
                }
                String choice = scanner.nextLine();
                if (choice.equals("0")) return;
                if (playListsInfo.containsKey(choice)) {
                    showAPlayList(playListsInfo.get(choice));
                } else System.out.println("invalid name");
            }
        }
        private static void showAPlayList (ArrayList < Integer > playlist) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                int counter = 1;
                ArrayList<File> files = new ArrayList<>();
                System.out.println("Choose an option:\n for exit enter 0");
                for (Integer i : playlist) {
                    files.add(folder.listFiles()[i]);
                    System.out.println(counter + "-" + folder.listFiles()[i].getName());
                    counter++;
                }
                int choice = scanner.nextInt();
                if (choice == 0) return;
                if (choice >= counter) {
                    System.out.println("invalid number!");
                    continue;
                }
                MusicPlayer musicPlayer = new MusicPlayer(files, choice - 1);
                musicPlayer.playMusic();
            }
        }
    }
