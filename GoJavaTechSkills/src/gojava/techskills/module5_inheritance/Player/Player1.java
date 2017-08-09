package gojava.techskills.module5_inheritance.Player;
/*
Плеер 1.
Имеет final цену(задается в конструкторе) и геттер
Имеет только 1 песню (нельзя объявить эту переменную в классе этого плеера)
playSong Может проиграть песню.
 */
public class Player1 extends SuperPlayer {

    public Player1(double price) {
        super(price);
    }
}
