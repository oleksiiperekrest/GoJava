package gojava.techskills.module5_inheritance.Player;

public abstract class PlayerSongList extends SuperPlayer {

    public PlayerSongList(double price) {
        super(price);
    }

    public abstract void playAllSongs();
}
