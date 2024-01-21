import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Album class representing an album with a name, artist, and a list of songs
public class album
{
   private String title;
   private String artist;
   private List<Song> songs;

    public album(String title,String artist) {
        this.title = title;
        this.artist=artist;
        this.songs=new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
    //find song
    boolean findsong(String title)
    {
        for(Song song:songs)
        {
            if(song.getTitle().equals(title))
            {
                return true;
            }
        }
        return false;
    }
    // add song to album
    // Method to add a song to the album
    String addSongtoAlbum(String title,double duration)
    {
        Song s = new Song(title,duration);
        if(findsong(title)==false)
        {
            songs.add(s);
            return "song added to the album";
        }

        return "Song already exist";

    }
    // Overloaded method to add a song to the playlist from the album by title
    String addSongToPlayListFromAlbum(String title, List<Song>playlist)
    {
       if(findsong(title)==true){
           for(Song s:this.songs){
               if(s.getTitle().equals(title))
               {
                   playlist.add(s);
                   return "song added to your playlist";
               }
           }

       }
        return "song not present in the album";

    }
    // overloaded Method to add a song to the playlist from the album by index
    String addSongToPlayListFromAlbum(int trackNo, List<Song>playlist){
        int index=trackNo-1;
        if(index>=0 && index<this.songs.size())
        {
            playlist.add(this.songs.get(index));
            return "song added to your playlist";
        }
        return "Invalid position of song";
    }
}
