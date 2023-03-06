package chp11;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Jukebox1 {
    public static void main(String[] args) {
        new Jukebox1().go();
    }
    public void go(){
        List<SongV2> songs = MockSongs.getSongsV2();
        System.out.println(songs);
        
        Collections.sort(songs);
        System.out.println(songs);

        ArtistCompare artistCompare = new ArtistCompare();
        songs.sort(artistCompare);
        System.out.println(songs);

        songs.sort(new Comparator<SongV2>() {
            @Override
            public int compare(SongV2 one, SongV2 two) {
                return two.getBpm() - one.getBpm();
            }
        });
        System.out.println(songs);

        songs.sort((one,two)-> one.getTitle().compareTo(two.getTitle()));
        System.out.println(songs);
    }
}
