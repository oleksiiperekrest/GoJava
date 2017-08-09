package gojava.techskills.module5_inheritance.Player;
/*
Плеер 2.
Имеет final цену(задается в конструкторе) и геттер
Имеет только 1 песню (нельзя объявить эту переменную в классе этого плеера)
playSong Пытаясь проиграть песню выдает ошибку в консоль - “error”.
 */
public class Player2 extends SuperPlayer {

    public Player2(double price) {
        super(price);
    }

    @Override
    public void playSong() {
        System.out.println("Error! Could not play a song...");
    }
}
