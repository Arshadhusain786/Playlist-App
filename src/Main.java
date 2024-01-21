import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create albums and add songs to them
        album album1= new album("Raaz Reboot","Arijit singh");
        album1.addSongtoAlbum("Lo maan liya",3.60);
        album1.addSongtoAlbum("Raaz aankhein teri",3.40);
        album1.addSongtoAlbum("Yaad hai na",4.50);
        album1.addSongtoAlbum("khayaalon mein bhi",4.20);

        album album2= new album("Aawarapan","Mustafa zahid");
        album2.addSongtoAlbum("tera mera rishta",3.60);
        album2.addSongtoAlbum("to phir ao",3.40);
        album2.addSongtoAlbum("maula maula",4.50);

        album album3= new album("Khamoshiyan","Arijit singh");
        album3.addSongtoAlbum("khamoshiyan",3.60);
        album3.addSongtoAlbum("baatein ye kabhi na",3.40);
        album3.addSongtoAlbum("tu har lamha",4.50);

        album album4= new album("Ashiqui 2","Arijit singh");
        album4.addSongtoAlbum("chahu mein ya na",3.60);
        album4.addSongtoAlbum("tum hi ho",3.40);
        album4.addSongtoAlbum("sun raha hai na tu",4.50);

        List<Song> MyPlaylist= new LinkedList<Song>();
        // Create a playlist and add songs from different albums

        album1.addSongToPlayListFromAlbum(3, MyPlaylist);
        album2.addSongToPlayListFromAlbum(2,MyPlaylist);
        album4.addSongToPlayListFromAlbum(2,MyPlaylist);
        album2.addSongToPlayListFromAlbum(3,MyPlaylist);
        album3.addSongToPlayListFromAlbum(1,MyPlaylist);
        album1.addSongToPlayListFromAlbum("Lo maan liya",MyPlaylist );
        album3.addSongToPlayListFromAlbum("tu har lamha",MyPlaylist);
        album4.addSongToPlayListFromAlbum("sun raha hai na tu",MyPlaylist);
        album3.addSongToPlayListFromAlbum(2,MyPlaylist);

// Play the playlist
        play(MyPlaylist);
    }

    private static void play(List<Song> myPlaylist) {

        ListIterator<Song> itr= myPlaylist.listIterator();// creating iterator

        // Check if the playlist is empty

        if(myPlaylist.isEmpty()) {
            System.out.println("playlist is empty");
            return;
        }
        // Variables to track current song and direction
        boolean isNext= false;
        // Print the currently playing song
        System.out.println("currently playing :  ");
        System.out.println(itr.next());
        isNext=true;
        // Scanner for user input
        Scanner sc= new Scanner(System.in);
        // Print the menu and start handling user input
        printMenu();
        while(true){
            System.out.println("enter your choice: ");
            int choice= sc.nextInt();
            switch (choice){

                case 1:
                    if(!isNext)
                    {  // because if isNext is false then itr.prev must have done
                        // so to avoid repetition take one step ahead
                        itr.next();
                        isNext= true;
                    }
                    if(itr.hasNext()) {
                        System.out.println("now playing:");
                        System.out.println(itr.next());
                        isNext=true;
                    }
                    else
                        System.out.println("you have reached to the end");
                    break;

                case 2:
                    if(isNext)
                    {   // because if isNext is true then itr.next must have done
                        // so to avoid repetition take one step ahead
                        itr.previous();
                        isNext= false;
                    }
                    if(itr.hasPrevious()) {
                        System.out.println("now playing:");
                        System.out.println(itr.previous());
                        isNext=false;
                    }
                    else
                        System.out.println("you are on first song");
                    break;

                case 3:
                    if(isNext) {
                        System.out.println(itr.previous());
                        isNext=false;
                    }
                    else {
                        System.out.println(itr.next());
                        isNext=true;
                    }
                    break;

                case 4:
                    itr.remove();
                    System.out.println("song deleted");
                    break;

                case 5:
                    printListOfSongs(myPlaylist);
                    break;

                case 6:
                    printMenu();
                    break;

                case 7:
                    return;

                default:
                    System.out.println("Wrong choice. Please select again");
            }
        }
    }
    public static void printListOfSongs(List<Song> playList)
    {

        for(Song song: playList)
            System.out.println(song);

        return;
    }
    public static void printMenu()
    {
        System.out.println("choices:");
        System.out.println("1. play next song");
        System.out.println("2. play Previous song");
        System.out.println("3. play current song again");
        System.out.println("4. delete current song");
        System.out.println("5. show the list of songs");
        System.out.println("6. show choices again");
        System.out.println("7. exit");


    }

}