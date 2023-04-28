package howard.edu.lsp.finals.problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SongsDatabase {
    /* Key is the genre, HashSet contains associated songs */
    private Map<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();

    /* Add a song title to a genre */
    public void addSong(String genre, String songTitle) {
        if (map.containsKey(genre)) {
            HashSet<String> songs = map.get(genre);
            songs.add(songTitle);
        } else {
            HashSet<String> songs = new HashSet<String>();
            songs.add(songTitle);
            map.put(genre, songs);
        }
    }

    /* Return the Set that contains all songs for a genre */
    public Set<String> getSongs(String genre) {
        if (map.containsKey(genre)) {
            return map.get(genre);
        } else {
            return new HashSet<String>();
        }
    }

    /* Return genre, i.e., jazz, given a song title */
    public String getGenreOfSong(String songTitle) {
        for (Map.Entry<String, HashSet<String>> entry : map.entrySet()) {
            if (entry.getValue().contains(songTitle)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
