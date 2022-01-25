import java.util.HashMap;
public class BandHash {
    public static void LyricsToSong(){
        HashMap<String, String>map=new HashMap<String, String>();
        map.put("Happier", "From all the sunlight of our past...");
        map.put("Can't Decide", "I can't decide if it's you or I baby...");
        map.put("Death Wish", "Who is she? She's got this way about her...");

        for (String key:map.keySet()){
            System.out.println(String.format("Track: %s Lyrics:%s", key,map.get(key)));
        }
    }
}
