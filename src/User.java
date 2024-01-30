import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {
    private static ArrayList<User> users = new ArrayList<>();

    private String username;
    private String password;




    private HashMap<String ,ArrayList <Integer>> playLists;
    public HashMap<String, ArrayList<Integer>> getPlayLists() {
        return playLists;
    }
    public void savePlaylist() {
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream("usersPlayLists/"+username+".txt"));
            for (Map.Entry<String , ArrayList<Integer>> entry: this.playLists.entrySet()){
                printStream.println(entry.getKey());
                for (int u : entry.getValue()){
                    printStream.print(u+ " ");
                }
                printStream.println();
            }
        }catch (Exception e) {
            System.out.println("");
        }

    }
    public void loadPlaylist(){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream("usersPlayLists/"+username+".txt"));
        } catch (FileNotFoundException e) {
            System.out.println("");
        }
        while (scanner.hasNextLine()){
            String name = scanner.nextLine();
            ArrayList<Integer> indexes= new ArrayList<>();
            String[] allIndex = scanner.nextLine().split(" ");
            for (String s: allIndex){
                indexes.add(Integer.parseInt(s));
            }
            this.playLists.put(name , indexes);
        }
    }
    public User(String username, String password) throws IOException {
        playLists = new HashMap<>();
        users.add(this);
        this.username = username;
        this.password = password;
    }

    public static User checkLogin(String username, String password) {
        for (User u : users) {
            if(u.username.equals(username) && u.password.equals(password)) return u;
        }
        return null;
    }
    public static void readUsers(){
        try {
            Scanner scanner = new Scanner(new File("UPM.txt"));
            while(scanner.hasNext()){
                String[] info = scanner.nextLine().split(" ");
                users.add(new User(info[0],info[1] ));
                if(info.length==1)break;
            }
        }catch (Exception e){
            System.out.println();
        }
    }

    public static boolean checkUsername(String username) {
        for (User u : users) {
            if (u.username.equals(username)) return true;
        }
        return false;
    }

    public String getUsername() {
        return username;
    }

}
