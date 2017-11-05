package gojava.techskills.module7_SDK_JSON_Generics.fruit;

import java.text.ParseException;

/**
 * Потребуется создать класс фрукта. Фрукт хранит:
 * вид (клубника, яблоко, груша и т.д.) храниться в Enum. Придумать до 10 видов.
 * срок годности (10 дней, 20 дней и т.д.)
 * дата поставки
 * цена POMEGRANATE
 */
public class Fruit {

    private FruitType fruitType;
    private int shelfLife;
//    private Date date;
    private String date;
    private int price;


    public enum FruitType {Apple, Pear, Plum, Banana, Peach, Avocado, Mango, Apricot, Ppineapple, Orange}

    public Fruit(FruitType fruitType, int shelfLife, String date, int price) throws ParseException {
        this.fruitType = fruitType;
        this.shelfLife = shelfLife;
//        this.date = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        this.date = date;

        this.price = price;
    }

    public FruitType getFruitType() {
        return fruitType;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public String getDate() {
        return date;
    }

    public int getPrice() {
        return price;
    }

    public String info() {
        return ("Fruit: " + this.fruitType)
                + ("\nShelf life: " + this.shelfLife)
//                + ("\nDate: " + new SimpleDateFormat("dd.MM.yyyy").format(this.date))
                + ("\nDate: " + this.date)
                + ("\nPrice: " + this.price);
    }
}
