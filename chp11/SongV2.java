package chp11;

public class SongV2 implements Comparable<SongV2> {
    private String title;
    private String artist;
    private int bpm;

    public SongV2(String title,String artist, int bpm) {
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }
    public String getArtist() {
        return artist;
    }
    public int getBpm() {
        return bpm;
    }
    public String getTitle() {
        return title;
    }
    @Override
    public String toString() {
        return title;
    }
    @Override
    public int compareTo(SongV2 s) {
        return title.compareTo(s.getTitle());
    }
    @Override
    public boolean equals(Object aSong){
        SongV2 other = (SongV2) aSong;
        return getTitle().equals(other.getTitle());
    }
    @Override
    public int hashCode() {
        return title.hashCode();
    }
}
