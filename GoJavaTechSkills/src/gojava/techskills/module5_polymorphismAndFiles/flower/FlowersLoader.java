package gojava.techskills.module5_polymorphismAndFiles.flower;
/*
Задание 3
Написать класс FlowersLoader. Этот класс имеет статическую функцию - load которая принимает путь к файлу, а возвращает
массив объектов цветов (букет).
Необходимо гарантировать чтобы объект этого класса создать было нельзя.
 */

import java.io.BufferedReader;
import java.io.FileReader;

public abstract class FlowersLoader {

    public static Flower[] load(String file) {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            Flower[] bouquet = new Flower[Integer.parseInt(bufferedReader.readLine())];
            for (int i = 0; i < bouquet.length; i++) {
                String nextLine = bufferedReader.readLine();
                switch (nextLine) {
                    case "Rose" :
                        bouquet[i] = new Rose();
                        break;
                    case "Chamomile" :
                        bouquet[i] = new Chamomile();
                        break;
                    case "Tulip" :
                        bouquet[i] = new Tulip();
                        break;
                }
            }
            return bouquet;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
