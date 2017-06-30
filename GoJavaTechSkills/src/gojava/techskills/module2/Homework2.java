package gojava.techskills.module2;

/*1. Создать новый проект на своем компе
2. Создать новый проект на GitHub и объеденить проекст локальный с проектом на GitHub
3. Написать программу, которая делает следующее:
3.1 спрашивает у пользователя имя (String)
3.2 спрашивает у пользователя город проживания (String)
3.3 спрашивает у пользователя возраст (int)
3.5 спрашивает у пользователя хобби (String)
3.6 перед каждым вводом данных, программа должна вывести информацию пользователю с требованием ввода соответствующей информации.
3.7 прогрмма выводит красиво оформленно всю информацию о пользователе в трех разных вариантах:
----------------------------------
Вариант 1 (табличный):
Имя: хххххх
Город: хххххх
Возраст: хххххх
Хобби: хххххх
----------------------------------
Вариант 2 (текстовый):
Человек по имени хххххх живет в городе хххххх.
Этому человеку хххххх лет и любит он заниматься хххххх.
----------------------------------
Вариант 3 (иной):
хххххх - имя
хххххх - город
хххххх - возраст
хххххх - хобби
----------------------------------
4. По ходу решения задачи, пушить изменения на GitHub
5. Финальный рабочий код программы которая соответствует всем подпунктам пункта 3, залить на GitHub
 */
import java.util.Scanner;
public class Homework2 {

    public static void main(String[] args) {

        String name, hometown, hobby;
        int age;

        name = firstLetterToUpperCase(getName());
        hometown = firstLetterToUpperCase(getHometown());
        age = getAge();
        hobby = firstLetterToUpperCase(getHobby());

        resultTable(name, hometown, age, hobby);
        resultText(name, hometown, age, hobby);
        resultOther(name, hometown, age, hobby);

    }

    private static int getAge() {
        System.out.println("How old are you?");
        return getIntInput();
    }

    private static String getName() {
        System.out.println("What is your name?");
        return getStringInput();
    }

    private static String getHometown() {
        System.out.println("What is your hometown?");
        return getStringInput();
    }

    private static String getHobby() {
        System.out.println("What's your hobby?");
        return getStringInput();
    }


    static int getIntInput() {
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            System.out.println("(Enter a whole number)");
            input.next();
        }
        return input.nextInt();
    }

    private static String getStringInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private static void resultTable(String name, String hometown, int age, String hobby) {
        System.out.println();
        System.out.println("Name: " + name);
        System.out.println("Hometown: " + hometown);
        System.out.println("Age: " + age);
        System.out.println("Hobby: " + hobby);
    }

    private static void resultText(String name, String hometown, int age, String hobby) {
        System.out.println();
        System.out.println("A person named " + name + " lives in " + hometown + "." +
                "\nThis person is " + age + " years old and they like doing " + firstLetterToLowerCase(hobby) + ".");
    }

    private static void resultOther(String name, String hometown, int age, String hobby) {
        System.out.println();
        System.out.println(name + " - name");
        System.out.println(hometown + " - hometown");
        System.out.println(age + " - age");
        System.out.println(hobby + " - hobby");
    }


    private static String firstLetterToLowerCase(String s) {
        char c[] = s.toCharArray();
        c[0] = Character.toLowerCase(c[0]);
        return new String(c);
    }

    private static String firstLetterToUpperCase(String s) {
        char c[] = s.toCharArray();
        c[0] = Character.toUpperCase(c[0]);
        return new String(c);
    }

}
