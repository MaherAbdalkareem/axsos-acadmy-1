import java.util.HashMap;
import java.util.Set;

class  Lyrics {
    public static void main(String[] args) {
        HashMap<String,String> trackList=new HashMap<String,String>();
        trackList.put("The Most","This winter was as cold as you");
        trackList.put("All Too Well","'All Too Well' by Taylor Swift ");
        trackList.put("Supermarket Flowers","Even before I knew he wrote it ");
        trackList.put("Landslide","I lost my dad almost three");
        Set<String> track=trackList.keySet();
        for(String lyrics : track){
            System.out.println(lyrics);
            System.out.println(trackList.get(lyrics));
        }
    }
}