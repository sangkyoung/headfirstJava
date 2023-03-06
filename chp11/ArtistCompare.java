package chp11;

import java.util.Comparator;

public class ArtistCompare implements Comparator<SongV2> {
    
    @Override
    public int compare(SongV2 one, SongV2 two) {
        return one.getArtist().compareTo(two.getArtist());
    }
}
