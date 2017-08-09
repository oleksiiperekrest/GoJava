package gojava.techskills.module5_inheritance.Player;


public abstract class SuperPlayer {

    final private double price;
    String song;

    public SuperPlayer(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public void playSong() {
        System.out.println("Now playing: " + song);
    }

}
