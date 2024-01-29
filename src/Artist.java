import java.io.IOException;
import java.util.ArrayList;

public class Artist extends User {
    private String name;
    private String biography;
    private ArrayList<String> albums = new ArrayList<String>();

    public Artist(String username, String password) throws IOException {
        super(username, password);
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
