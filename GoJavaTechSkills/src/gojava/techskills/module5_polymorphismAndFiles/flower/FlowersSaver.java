package gojava.techskills.module5_polymorphismAndFiles.flower;
/*
Задание 4
Написать класс FlowersSaver. Этот класс имеет статическую функцию - save которая принимает путь к файлу и массив цветов
(букет). Должна сохранить цветы в файл.
Необходимо гарантировать чтобы объект этого класса создать было нельзя.
 */

import java.io.FileWriter;

public abstract class FlowersSaver {
    public static void save(String file, Flower[] bouquet) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(bouquet.length + "\n");

            for (Flower flower : bouquet) {
                if (flower instanceof Rose) fileWriter.write("Rose\n");
                else if (flower instanceof Chamomile) fileWriter.write("Chamomile\n");
                else if (flower instanceof Tulip) fileWriter.write("Tulip\n");
                else fileWriter.write("Flower\n");
            }
            fileWriter.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void save(String file, Exception e) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("-1\n");
            fileWriter.write(e.toString());
            fileWriter.flush();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
