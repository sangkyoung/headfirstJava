package chp11;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Jukebox8 {
    public static void main(String[] args) {
        new Jukebox8().go();
    }
    public void go() {
        List<SongV2> songList = MockSongs.getSongsV2();
        System.out.println(songList);

        System.out.println("Sorted by title:");
        songList.sort((one,two) -> one.getTitle().compareTo(two.getTitle()));
        System.out.println(songList);

        Set<SongV2> songSet = new HashSet<>(songList);
        System.out.println("Set: "+songSet);

        System.out.println("TreeSet:");
        Set<SongV2> songTreeSet = new TreeSet<>(songList);
        System.out.println(songTreeSet);

        System.out.println("Sorted by bpm:");
        Set<SongV2> sTS = new TreeSet<>((one,two) -> two.getBpm() - one.getBpm());
        sTS.addAll(songList);
        System.out.println(sTS);
    }
}
