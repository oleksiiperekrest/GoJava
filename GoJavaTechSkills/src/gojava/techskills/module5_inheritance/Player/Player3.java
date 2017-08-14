package gojava.techskills.module5_inheritance.Player;
/*
Плеер 3.
Имеет final цену(задается в конструкторе) и геттер
Имеет плейлист
playSong Может проиграть первую песню
playAllSongs может проиграть все песни
 */

public class Player3 extends PlayerSongList {

    public Player3(double price) {
        super(price);
    }

    @Override
    public void playSong() {
        setSong(playlist[0]);
        super.playSong();
    }
}
