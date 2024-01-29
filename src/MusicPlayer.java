import javazoom.jl.player.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MusicPlayer {
    private ArrayList<File> normalMusics;
    private ArrayList<File> shuffledMusics;
    private Thread threadPlay;
    private int currentIndex;
    private boolean isShuffled;
    private boolean isRepeated;
    private boolean isPaused;

    MusicPlayer(File folder, int current) {
        currentIndex = current;
        normalMusics=new ArrayList<>();
        shuffledMusics=new ArrayList<>();
        for (File f : folder.listFiles()) {
            normalMusics.add(f);
            shuffledMusics.add(f);
        }
    }
    MusicPlayer(ArrayList<File> files,int current){
        normalMusics=files;
        shuffledMusics=files;
        currentIndex=current;
    }

    public void playMusic() {
        Scanner scanner = new Scanner(System.in);
        play();
        while (true) {
            System.out.println(normalMusics.get(currentIndex).getName()+"\nchoose an option from here:\n1-Play previous song\n2-Pause/Play\n3-Play next song\n4-Shuffle on/off\n5-repeat one song\n6-back to song menu");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    previous();
                    break;
                case 2:
                    pause();
                    break;
                case 3:
                    next();
                    break;
                case 4:
                    shuffle();
                    break;
                case 5:
                    repeat();
                    break;
                case 6:
                    threadPlay.stop();
                    return;
            }
        }
    }
    private void play(){
        threadPlay=new Thread(){
            @Override
            public void run() {
                try {
                    Player player=new Player(new FileInputStream(shuffledMusics.get(currentIndex)));
                    player.play();
                    if(!isRepeated)currentIndex=(currentIndex+1)%normalMusics.size();
                    playMusic();
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        };
        threadPlay.start();
    }
    private void previous(){
        currentIndex=(currentIndex-1+normalMusics.size())%normalMusics.size();
        threadPlay.stop();
        play();
    }
    private void pause(){
        if(isPaused){
            play();
            isPaused=false;
        }
        else {
            threadPlay.stop();
            isPaused=true;
        }
    }
    private void next(){
        currentIndex=(currentIndex+1)%normalMusics.size();
        threadPlay.stop();
        play();
    }
    private void shuffle(){
        if(isShuffled){
            shuffledMusics=normalMusics;
            isShuffled=false;
        }else {
            Collections.shuffle(shuffledMusics);
            isShuffled=true;
        }
    }
    private void repeat(){
        if(isRepeated)isRepeated=false;
        else isRepeated=true;
    }
}
