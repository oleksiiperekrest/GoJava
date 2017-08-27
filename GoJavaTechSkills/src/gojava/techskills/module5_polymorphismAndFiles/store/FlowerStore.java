package gojava.techskills.module5_polymorphismAndFiles.store;
/*
Создать класс FlowerStore который продает букеты цветов через функцию sell. Эта функция принимает 3 числа.
Кол-во роз, кол-во ромашек, кол-во тюльпанов. А вернуть должна один массив цветов, в котором будут храниться цветы.
Один объект в массив == один цветок в букете. Последовательность расстановки цветов в букете не имеет значения.
Добавить метод sellSequence который работает так же как и метод sell, принимает 3 числа(кол-во цветов)
но теперь цветы в букете должны идти чередуясь: роза, ромашка, тюльпан. Если для последовательности не хватает цветков,
продолжать выводить по той же последовательности но пропуская цветки которые лишние.
Например 5 розы, 3 ромашки, 1 тюльпан:
роза, ромашка, тюльпан, роза, ромашка, роза, ромашка, роза, роза

В главном классе программы продемонстрировать работу метода sell и sellSequence
Вывести по букету в консоль через запятую в одну строчку.
Поля String name у классов-цветов нет

Задание 2
Добавить к классам-цветам поле - цена. Роза стоит 100, ромашка 70, тюльпан 45.
Добавить к классу FlowerStore кошелек. Который хранит сколько в магазине денег. После продажи букета - пополнять
кошелек магазина на сумму проданных цветов.
 */

import gojava.techskills.module5_polymorphismAndFiles.flower.Chamomile;
import gojava.techskills.module5_polymorphismAndFiles.flower.Flower;
import gojava.techskills.module5_polymorphismAndFiles.flower.Rose;
import gojava.techskills.module5_polymorphismAndFiles.flower.Tulip;

import java.util.Random;

public class FlowerStore {

    private double wallet = 0;

    public double getWallet() {
        return wallet;
    }


    public void sell(int roses, int chamomiles, int tulips) {
        int size = roses + chamomiles + tulips;
        Flower[] bouquet = new Flower[size];

        for (int i = 0; i < bouquet.length; i++) {
            if (i < roses) bouquet[i] = new Rose();
            else if (i < (roses + chamomiles)) bouquet[i] = new Chamomile();
            else bouquet[i] = new Tulip();
        }

        sellInfo(bouquet);
    }

    public void sellSequence(int roses, int chamomiles, int tulips) {
        int size = roses + chamomiles + tulips;
        Flower[] bouquet = new Flower[size];
        String last = "Tulip";

        for (int i = 0; i < bouquet.length; i++) {
            if (last.equals("Tulip")) {
                if (roses > 0) {
                    bouquet[i] = new Rose();
                    roses--;
                    last = "Rose";
                    continue;
                }
                if (chamomiles > 0) {
                    bouquet[i] = new Chamomile();
                    chamomiles--;
                    last = "Chamomile";
                    continue;
                }
                if (tulips > 0) {
                    bouquet[i] = new Tulip();
                    tulips--;
                    last = "Tulip";
                    continue;
                }

            }
            if (last.equals("Rose")) {
                if (chamomiles > 0) {
                    bouquet[i] = new Chamomile();
                    chamomiles--;
                    last = "Chamomile";
                    continue;
                }
                if (tulips > 0) {
                    bouquet[i] = new Tulip();
                    tulips--;
                    last = "Tulip";
                    continue;
                }
                if (roses > 0) {
                    bouquet[i] = new Rose();
                    roses--;
                    last = "Rose";

                    continue;
                }
            }
            if (last.equals("Chamomile")) {
                if (tulips > 0) {
                    bouquet[i] = new Tulip();
                    tulips--;
                    last = "Tulip";
                    continue;
                }
                if (roses > 0) {
                    bouquet[i] = new Rose();
                    roses--;
                    last = "Rose";
                    continue;
                }
                if (chamomiles > 0) {
                    bouquet[i] = new Chamomile();
                    chamomiles--;
                    last = "Chamomile";
                }
            }
        }
        sellInfo(bouquet);
    }

    public Flower[] randomBouquet(int flowersNumber) {
        int typesNumber = 3;
        Random random = new Random();
        Flower[] bouquet = new Flower[flowersNumber];

        for (int i = 0; i < bouquet.length; i++) {
            int choice = random.nextInt(typesNumber);
            switch (choice) {
                case 0:
                    bouquet[i] = new Rose();
                    break;
                case 1:
                    bouquet[i] = new Chamomile();
                    break;
                case 2:
                    bouquet[i] = new Tulip();
                    break;
            }
        }
        return bouquet;
    }


    private double countPrice(Flower[] bouquet) {
        double price = 0;
        for (Flower flower : bouquet) {
            price += flower.getPrice();
        }
        return price;
    }

    public void printBouquet(Flower[] bouquet) {
        for (int i = 0; i < (bouquet.length - 1); i++) {
            System.out.print(checkFlowerType(bouquet[i]) + ", ");
        }
        System.out.println(checkFlowerType(bouquet[(bouquet.length - 1)]) + ".");
    }

    private String checkFlowerType(Flower flower) {
        if (flower instanceof Rose) return "Rose";
        else if (flower instanceof Chamomile) return "Chamomile";
        else if (flower instanceof Tulip) return "Tulip";
        else return "Flower";
    }

    private void sellInfo(Flower[] bouquet) {
        printBouquet(bouquet);
        double bouquetPrice = countPrice(bouquet);
        wallet += bouquetPrice;
        System.out.println("Bouquet price: " + bouquetPrice);
        System.out.println("Store wallet balance: " + wallet);
        System.out.println();
    }

}
