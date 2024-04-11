package util;

public class Song {
    private final String url;
    private final String title;
    private final String artist;
    private final String trackUrl;

    public Song(String url, String name, String artist, String trackUrl) {
        this.url = url;
        this.title = name;
        this.artist = artist;
        this.trackUrl = trackUrl;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getTrackUrl() {
        return trackUrl;
    }
}
