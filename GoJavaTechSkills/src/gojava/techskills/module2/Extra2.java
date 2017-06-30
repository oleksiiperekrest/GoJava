package gojava.techskills.module2;

/*
2) Есть девятиэтажный дом, в котором 4 подъезда. Номер подъезда
начинается с единицы. На одном этаже 4 квартиры. Напишите программу
которая получит номер квартиры с клавиатуры, и выведет на экран на
каком этаже, какого подъезда расположенна эта квартира. Если такой
квартиры нет в этом доме то нужно сообщить об этом пользователю.
 */

import static gojava.techskills.module2.Homework2.getIntInput;

public class Extra2 {
    public static void main(String[] args) {

        int storeys         = 9;
        int blocks          = 4;
        int flatsOnStorey   = 4;

        System.out.println("This building has " + storeys + " storeys, " + blocks + " blocks with " +
                storeys * flatsOnStorey + " flats in each (" + flatsOnStorey + " flats on storey, " +
                storeys * blocks * flatsOnStorey + " flats in total).");
        System.out.print("Enter a flat number to find: ");
        int flat = getIntInput();


        checkFlat(storeys, blocks, flatsOnStorey, flat);

    }
    static void checkFlat(int storeys, int blocks, int flatsOnStorey, int flat){
        int totalFlats = storeys * blocks * flatsOnStorey;

        if (flat < 1 || flat > totalFlats) {
            System.out.println("Sorry, a flat with such number is not present in this building.");
        }
        else {
            int block = 1;
            while (flat > storeys * flatsOnStorey * block) block++;

            int storey = (flat - (storeys * flatsOnStorey * (block-1)) + (flatsOnStorey-1)) / flatsOnStorey;

            System.out.println("\nThe requested flat is in block " + block + " on floor " + storey + ".");

        }


    }
}
