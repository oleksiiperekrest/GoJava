package gojava.techskills.module7_SDK_JSON_Generics;

import gojava.techskills.module7_SDK_JSON_Generics.fruit.Fruit;
import gojava.techskills.module7_SDK_JSON_Generics.fruit.FruitDates;
import gojava.techskills.module7_SDK_JSON_Generics.store.Store;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * https://docs.google.com/document/d/17m31rq58SDfQZSjgtMNkYOW8S55HPeOsbDTjiCOiB4I/edit
 */



public class Homework10 {
    public static void main(String[] args) throws ParseException, IOException {
        final String FILEPATH = "Files/Homework10/fruits.txt";

        Fruit fruitApple = new Fruit(Fruit.FruitType.Apple, 9, "21/10/2017", 14);
        Fruit fruitOrange = new Fruit(Fruit.FruitType.Orange, 5, "21/10/2017", 18);
        Fruit fruitBanana = new Fruit(Fruit.FruitType.Banana, 2, "21/10/2017", 18);
//        String jsonString = JSON.toJSONString(fruitOne);

//        System.out.println(fruitApple.info());

        Store store = new Store();
        store.add(fruitApple);
        store.add(fruitOrange);
        store.add(fruitBanana);
        String stringCheckDate = "21/10/2017";
        Date checkDate = new SimpleDateFormat("dd/MM/yyyy").parse(stringCheckDate);

//        List<Fruit> available =  store.getAvailableFruits(checkDate);
//        for (Fruit fruit : available) {
//            System.out.println(fruit.info());
//        }
//
//        List<Fruit> spoiled =  store.getSpoiledFruits(checkDate);
//        for (Fruit fruit : spoiled) {
//            System.out.println("SPOILED:\n" + fruit.info());
//        }

        List<Fruit> added = store.getAddedFruits(checkDate);
        for (Fruit fruit : added) {
            System.out.println("ADDED on " + stringCheckDate + ":\n" + fruit.info());

        }

//        store.save(FILEPATH);
//        store.load(FILEPATH);
//        store.addFruits(FILEPATH);
//        store.addFruits(FILEPATH);
//        store.showInfo();

//        FruitDates appleDates = new FruitDates(fruitApple);
//        System.out.println(("Date received: " + new SimpleDateFormat("dd.MM.yyyy").format(appleDates.getDateReceived())));
//        System.out.println(("Date spoiled: " + new SimpleDateFormat("dd.MM.yyyy").format(appleDates.getDateSpoiled())));



    }

}
