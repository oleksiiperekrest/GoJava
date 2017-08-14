package gojava.techskills.module5_inheritance.Player;
/*
Плеер 5.
Имеет final цену(задается в конструкторе) и геттер
Имеет плейлист
playSong Может проиграть первую песню
playAllSongs может проиграть все песни с конца плейлиста в начало
 */

public class Player5 extends PlayerSongList {

    public Player5(double price) {
        super(price);
    }

    @Override
    public void playAllSongs() {
        String[] temp = playlist;
        setPlaylist(reversePlaylist());
        super.playAllSongs();
        setPlaylist(temp);
    }

    private String[] reversePlaylist() {
        String[] reversedPlaylist = new String[playlist.length];
        for (int i = 0; i < playlist.length; i++) {
            reversedPlaylist[i] = playlist[playlist.length - i - 1];
        }
        return reversedPlaylist;
    }
}
