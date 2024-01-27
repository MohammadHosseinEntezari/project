import java.util.ArrayList;

public class Artist {
    private String name;
    private String biography;
    private ArrayList<String> albums = new ArrayList<String>();
    public Artist(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setBio(String Text){
        this.biography = Text;
    }
    public String getBio(){
        return biography;
    }

}
