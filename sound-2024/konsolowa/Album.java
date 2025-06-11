public class Album {
    public String artist;
    public String album;
    public int songsNumber;
    public int year;
    public int downloadNumber;

    public Album(String artist, String album, int songsNumber, int year, int downloadNumber) {
        this.artist = artist;
        this.album = album;
        this.songsNumber = songsNumber;
        this.year = year;
        this.downloadNumber = downloadNumber;
    }

    @Override
    public String toString() {
        return artist + "\n" +
                album + "\n" +
                songsNumber + "\n" +
                year + "\n" +
                downloadNumber + "\n";
    }
}
