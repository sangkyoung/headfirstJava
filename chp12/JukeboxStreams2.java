package chp12;

import java.util.List;
import java.util.Optional;

public class JukeboxStreams2 {
    public static void main(String[] args) {
        Songs songs = new Songs();
        List<Song> songlist = songs.getSongs();

        //example 1
        //is any R&B song in the list?
        boolean anyRnB = songlist.stream()
                                .anyMatch(song -> song.getGenre().equals("R&B"));
        System.out.println("is any R&B song in the list? : "+anyRnB);

        //example 2
        //number of unique artists in the list
        long uniqueArtists = songlist.stream()
                                    .map(Song::getArtist)
                                    .distinct()
                                    .count();
        System.out.println("number of unique artists in the list : "+uniqueArtists);

        //example 3
        //find the first song played that was released in 1995
        Optional<Song> result = songlist.stream()
                                        .filter(song -> song.getYear() == 1995)
                                        .findFirst();
        if (result.isPresent()) {
            System.out.println("first song played that was released in 1995 : "+result.get());
        } else {
            System.out.println("no song played that was released in 1995");
        }
    }
}
