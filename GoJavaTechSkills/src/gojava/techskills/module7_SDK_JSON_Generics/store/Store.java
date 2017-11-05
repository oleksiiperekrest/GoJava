package gojava.techskills.module7_SDK_JSON_Generics.store;

import com.alibaba.fastjson.JSON;
import gojava.techskills.module7_SDK_JSON_Generics.fruit.Fruit;
import gojava.techskills.module7_SDK_JSON_Generics.fruit.FruitDates;
import gojava.techskills.offline8.utils.FileUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * И класс - торговая лавка. Он будет отвечать за хранение информации о складе лавки.
 * <p>
 * Необходимо принимать поставки фруктов и дополнять базу данных склада лавки новой информацией.
 * void addFruits(String pathToJsonFile) - метод принимает путь к файлу внутри которого находится
 * json с фруктами и датой поставки. Один файл - одна поставка. Базу данных во время работы программы
 * можно хранить в коллекции.
 * <p>
 * Нужен метод void save(String pathToJsonFile) который сохранит всю информацию со склада лавки в json файл.
 * <p>
 * Аналогичный метод void load(String pathToJsonFile) который удаляют текущую информацию из коллекции и загружает
 * новую из сохраненной версии.
 * <p>
 * Задание 2
 * Добавить к классу-лавке метод способный сказать какие продукты испортятся к заданной дате
 * List<Fruit> getSpoiledFruits(Date date)
 * <p>
 * И метод который возвращает список готовых к продаже продуктов
 * List<Fruit> getAvailableFruits(Date date)
 * <p>
 * Задание 3
 * Перегрузить имеющиеся методы spoiledFruits и availableFruits.
 * На прием еще одного параметра - вид фрукта
 * List<Fruit> getSpoiledFruits(Date date, Type type)
 * List<Fruit> getAvailableFruits(Date date, Type type)
 * Работают как и прежде, но теперь фильтруют только по заданному типу фрукта
 * <p>
 * Добавить метод который возвращает продукты которые были доставлены в заданную дату
 * List<Fruit> getAddedFruits(Date date)
 * и его переопределенная версия -
 * List<Fruit> getAddedFruits(Date date, Type type)
 */

public class Store {

    private List<Fruit> fruits = new ArrayList<>();

    public Store() {
    }

    public void add(Fruit fruit) {
        fruits.add(fruit);
    }

    public void addFruits(String pathToJsonFile) throws IOException {
        List<Fruit> newFruits = JSON.parseArray(FileUtils.readFromFile(pathToJsonFile), Fruit.class);
        for (Fruit fruit : newFruits) {
            fruits.add(fruit);
        }
    }

    public void save(String pathToJsonFile) throws IOException {
        FileUtils.writeToFile(JSON.toJSONString(fruits), pathToJsonFile);
    }

    public void load(String pathToJsonFile) throws IOException {
        System.out.println(FileUtils.readFromFile(pathToJsonFile));
        fruits = JSON.parseArray(FileUtils.readFromFile(pathToJsonFile), Fruit.class);

    }

    public List<Fruit> getFruits() {
        return fruits;
    }

    public void showInfo() {
        for (Fruit fruit : fruits) {
            System.out.println(fruit.info() + "\n");
        }
    }

    public List<Fruit> getSpoiledFruits(Date date) throws ParseException {
        List<Fruit> spoiledFruits = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if (new FruitDates(fruit).getDateSpoiled().before(date)) {
                spoiledFruits.add(fruit);
            }
        }
        return spoiledFruits;
    }

    public List<Fruit> getSpoiledFruits(Date date, Fruit.FruitType type) throws ParseException {
        List<Fruit> spoiledFruits = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if (fruit.getFruitType().equals(type) && new FruitDates(fruit).getDateSpoiled().before(date)) {
                spoiledFruits.add(fruit);
            }
        }
        return spoiledFruits;
    }


    public List<Fruit> getAvailableFruits(Date date) throws ParseException {
        List<Fruit> availableFruits = new ArrayList<>();
        for (Fruit fruit : fruits) {
            FruitDates fruitDates = new FruitDates(fruit);
            if (fruitDates.getDateSpoiled().after(date) || fruitDates.getDateSpoiled().equals(date)) {
                availableFruits.add(fruit);
            }
        }
        return availableFruits;
    }

    public List<Fruit> getAvailableFruits(Date date, Fruit.FruitType type) throws ParseException {
        List<Fruit> availableFruits = new ArrayList<>();
        for (Fruit fruit : fruits) {
            FruitDates fruitDates = new FruitDates(fruit);
            if (fruit.getFruitType().equals(type) &&
                    (fruitDates.getDateSpoiled().after(date) || fruitDates.getDateSpoiled().equals(date))) {
                availableFruits.add(fruit);
            }
        }
        return availableFruits;
    }

    public List<Fruit> getAddedFruits(Date date) throws ParseException {
        List<Fruit> addedFruits = new ArrayList<>();
        SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");

        for (Fruit fruit : fruits) {
            Date fruitDate = sdt.parse(fruit.getDate());
            if (fruitDate.equals(date)) {
                addedFruits.add(fruit);
            }
        }
        return addedFruits;
    }

    public List<Fruit> getAddedFruits(Date date, Fruit.FruitType type) throws ParseException {
        List<Fruit> addedFruits = new ArrayList<>();
        SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");

        for (Fruit fruit : fruits) {
            if (fruit.getFruitType().equals(type)) {
                Date fruitDate = sdt.parse(fruit.getDate());
                if (fruitDate.equals(date)) {
                    addedFruits.add(fruit);
                }
            }
        }
        return addedFruits;
    }
}
