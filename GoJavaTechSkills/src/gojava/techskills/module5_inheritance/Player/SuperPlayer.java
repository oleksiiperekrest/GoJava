package gojava.techskills.module5_inheritance.Player;


public abstract class SuperPlayer {

    final private double price;

    public SuperPlayer(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public abstract void playSong();

}
