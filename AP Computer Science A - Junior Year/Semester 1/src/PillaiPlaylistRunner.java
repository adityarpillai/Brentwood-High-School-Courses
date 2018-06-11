import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PillaiPlaylistRunner {
    //Create a menu that can do each of the following:
    //
    //
    //

    public static void main(String[] args) {
        int menuRepeat = 0;
        int num = 0;
        Scanner scan = new Scanner(System.in);
        String titles = "";
        Playlist myPlaylist = new Playlist(titles);
        while (menuRepeat != 5) {
            System.out.println("Press the following keys: \n1) New Playlist \n2) Play Next Song \n3) Play Random Song \n4) Shuffle List \n5) Exit");
            if (scan.hasNextInt()) {
                int userChoice = scan.nextInt();
                switch (userChoice) {
                    case 1:
                        //noinspection UnusedAssignment
                        myPlaylist = null;
                        int repeat = Integer.MIN_VALUE;
                        while (repeat != 0) {
                            System.out.println("Enter number of songs:");
                            if (scan.hasNextInt()) {
                                num = scan.nextInt();
                                scan.nextLine();
                                repeat = 0;
                            } else {
                                System.out.println("Error in input.");
                                scan.nextLine();
                            }
                        }
                        for (int i = 0; i < num; i++) {
                            System.out.println("Enter the songs as (Name of Song)-(Artist)-(Length of Song in Seconds), and press enter.");
                            titles += "-" + scan.nextLine();
                        }
                        myPlaylist = new Playlist(titles);
                        break;
                    case 2:
                        System.out.println(myPlaylist.playNext());
                        break;
                    case 3:
                        System.out.println(myPlaylist.playRandom());
                        break;
                    case 4:
                        myPlaylist.shuffleList();
                        System.out.println("List shuffled. \n");
                        break;
                    case 5:
                        menuRepeat = 5;
                        System.out.println("You're dead to me.");
                        break;
                    default:
                        System.out.println("Error in input. Try again.");

                }
            } else {
                System.out.println("No number is entered.");
            }

        }

    }
}

@SuppressWarnings("WeakerAccess")
class Playlist {
    private ArrayList<Song> songs;//holds the playlist
    private int currentSong;// holds the value of the current song playing

    //Preconditions: titles.length > 0
    //Purpose: Initialize songs from titles in the same order.
    public Playlist(String titles) {
        songs = new ArrayList<>();
        Scanner cutter = new Scanner(titles);
        cutter.useDelimiter("-");
        while (cutter.hasNext()) {
            String songTitle = cutter.next();
            String artist = cutter.next();
            int length = cutter.nextInt();
            songs.add(new Song(songTitle, artist, length));
        }
        currentSong = -1;
    }

    //Purpose: shuffle the list and play the first song
    public String playRandom() {
        String current = songs.get(currentSong).toString();
        do {
            shuffleList();
        } while (current.equals(songs.get(0).toString()));
        currentSong = -1;
        return playNext();
    }

    //Purpose: play the next song
    public String playNext() {
        currentSong++;
        if (currentSong < songs.size()) {
            return songs.get(currentSong).toString();
        }
        currentSong--;
        return "\nNo songs left.";
    }

    //Purpose: shuffle the list completely
    public void shuffleList() {
        currentSong = -1;
        Collections.shuffle(songs);
    }

    //


}

@SuppressWarnings("WeakerAccess")
class Song {
    private String title;// title of the song
    private String artist;// artist of the song
    private int len;     // length of the song;

    public Song(String title, String genre, int len) {
        this.title = title;
        this.artist = genre;
        this.len = len;
    }

    public String toString() {
        int minutes = len / 60;
        int seconds = len % 60;
        return ("\n\"" + title + "\"" + "\nBy: " + artist + "\nPlaytime: " + minutes + ":" + seconds + "\n");
        //implement
    }

}