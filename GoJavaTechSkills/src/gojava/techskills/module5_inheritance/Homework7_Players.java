package gojava.techskills.module5_inheritance;

/*
https://docs.google.com/document/d/18KaJ9dRQm9cqfa2_bwt9fe1yFgxzwLapGIIKwti7COU/edit#
 */

import gojava.techskills.module5_inheritance.Player.*;

public class Homework7_Players {

    private static String song1 = "1. Tarja Turunen - I Walk Alone";
    private static String song2 = "2. Scorpions - Wind of Change";
    private static String song3 = "3. Queen - Bohemian Rhapsody";
    private static String song4 = "4. Nightwish - Over the Hills and Far Away";
    private static String song5 = "5. Samael - On Earth";
    private static String song6 = "6. Unheilig - Geboren um zu Leben";
    private static String song7 = "7. Rhapsody of Fire - Emerald Sword";
    private static String song8 = "8. White Skull - Gods of the Sea";
    private static String song9 = "9. Dragonforce - Through Fire and Flames";
    private static String song10 = "10. Delain - The Gathering";
    private static String song11 = "11. Blind Guardian - Battlefield";
    private static String song12 = "12. Therion - Son of the Staves of Time";
    private static String[] playlist = {song1, song2, song3, song4, song5, song6, song7, song8,
            song9, song10, song11, song12};

    public static void main(String[] args) {

        SuperPlayer[] players = new SuperPlayer[6];

        players[0] = new Player1(14.4);
        players[1] = new Player2(15.6);
        players[2] = new Player3(19.4);
        players[3] = new Player4(34.4);
        players[4] = new Player5(52.4);
        players[5] = new Player6(99.9);


        setSongs(players);
        playSongs(players);

    }

    private static void setSongs (SuperPlayer[] players) {
        for (SuperPlayer player : players) {
            player.setSong(song1);
            if (player instanceof PlayerSongList) ((PlayerSongList) player).setPlaylist(playlist);
        }
    }

    private static void playSongs(SuperPlayer[] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i+1));
            players[i].playSong();
            if (players[i] instanceof PlayerSongList) ((PlayerSongList) players[i]).playAllSongs();
            if (players[i] instanceof Player6) {
                ((Player6) players[i]).shuffle();
                System.out.println("---Shuffling playlist---");
                ((Player6) players[i]).playAllSongs();
            }
            System.out.println();
        }
    }
}
