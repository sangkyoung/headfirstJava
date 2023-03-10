package chp12;

import java.util.List;
import java.util.stream.Collectors;

public class JukeboxStreams {
    public static void main(String[] args) {
        Songs songs = new Songs();
        // List<Song> rocksongs = songs.getSongs()
        //                             .stream()
        //                             .filter(song -> song.getGenre().contains("Rock"))
        //                             .collect(Collectors.toList());
        // System.out.println("rocksongs : "+rocksongs);
        List<String> genres = songs.getSongs()
                                    .stream()
                                    .map( song -> song.getGenre())
                                    .distinct()
                                    .collect(Collectors.toList());
        System.out.println("genres : "+genres);
    }
}
