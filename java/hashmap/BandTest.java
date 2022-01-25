import java.util.HashMap;
public class BandTest {
    public static void main (String[] args){
        HashMap<String, String>map=new HashMap<String, String>();
        BandHash generator = new BandHash();
        System.out.println(generator.LyricsToSong());
    }
}
