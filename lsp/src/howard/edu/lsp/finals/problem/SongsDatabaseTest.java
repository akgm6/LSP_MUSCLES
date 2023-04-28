package howard.edu.lsp.finals.problem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Set;

public class SongsDatabaseTest {
    private SongsDatabase db;

    @Before
    public void setUp() {
        db = new SongsDatabase();
    }

    @Test
    @DisplayName("Tests for addSong function")
    public void testAddSong() {
    	db.addSong("Rap", "Savage");
        db.addSong("Rap", "Gin and Juice");
        db.addSong("Jazz", "Always There");
        
        // Check if songs were added to the correct genres
         assertEquals(2, db.getSongs("Rap").size());
         assertEquals(1, db.getSongs("Jazz").size());

        // Check if songs were added correctly
         assertTrue(db.getSongs("Rap").contains("Savage"));
         assertTrue(db.getSongs("Rap").contains("Gin and Juice"));
         assertTrue(db.getSongs("Jazz").contains("Always There"));
    }
    
    @Test
    @DisplayName("Tests for getSongs function")
    public void testGetSongs() {
    	db.addSong("Rap", "Savage");
        db.addSong("Rap", "Gin and Juice");
        db.addSong("Jazz", "Always There");
        
        Set<String> songs = db.getSongs("Rap");
         assertTrue(songs.contains("Savage"));
         assertTrue(songs.contains("Gin and Juice"));
        Set<String> jazzSongs = db.getSongs("Jazz");
         assertTrue(jazzSongs.contains("Always There"));
        Set<String> unknownGenreSongs = db.getSongs("Unknown");
         assertTrue(unknownGenreSongs.isEmpty());
    }

    @Test
    @DisplayName("Tests for getGenreOfSong function")
    public void testGetGenreOfSong() {
    	db.addSong("Rap", "Savage");
        db.addSong("Rap", "Gin and Juice");
        db.addSong("Jazz", "Always There");
        
         assertEquals("Rap", db.getGenreOfSong("Savage"));
         assertEquals("Jazz", db.getGenreOfSong("Always There"));
    }
}