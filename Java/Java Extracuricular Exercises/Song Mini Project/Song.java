package songs;

public class Song implements SongInt{

    private String artist, title;    

    public Song(String songTitle, String songArtist){
        title = songTitle;
        artist = songArtist;
    }

    public String getTitle(){
    	return title;
    }

    public String getArtist(){
    	return artist;
    }
}

