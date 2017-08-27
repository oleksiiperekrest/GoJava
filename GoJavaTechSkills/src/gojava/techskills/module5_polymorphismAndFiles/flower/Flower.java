package gojava.techskills.module5_polymorphismAndFiles.flower;
/*
Задание 1
Создать базовый класс для цветов. От него наследуется 3 класса-цветка:
роза,
ромашка,
тюльпан
 */
public abstract class Flower {

    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
