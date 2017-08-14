package gojava.techskills.module5_inheritance.Player;
/*
Плеер 6.
Имеет final цену(задается в конструкторе) и геттер
Имеет плейлист
playSong Может проиграть первую песню
playAllSongs может проиграть все песни
Имеет метод public void shuffle() - перемешивает все песни в плейлисте местами
 */

import java.util.Random;

public class Player6 extends Player3 {

    public Player6(double price) {
        super(price);
    }

    public void shuffle() {
        Random random = new Random();
        int index;
        String temp;

        for (int i = 0; i < playlist.length; i++) {
            index = random.nextInt(playlist.length);
            if (i != index) {
                temp = playlist[index];
                playlist[index] = playlist[i];
                playlist[i] = temp;
            }
        }
    }

}
