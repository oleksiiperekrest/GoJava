package gojava.techskills.module5_inheritance.Player;


public abstract class Player {


    final protected double price;

    public Player(double price) {
        this.price = price;
    }



    public double getPrice() {
        return this.price;
    }

    public abstract void playSong();
    public abstract void playAllSongs();

}
