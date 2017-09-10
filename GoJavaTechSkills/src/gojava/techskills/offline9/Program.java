package gojava.techskills.offline9;

import com.alibaba.fastjson.JSON;
import gojava.techskills.offline9.Tasks.Task2;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Program {
    public static void main(String[] args) {
        taskOne();
//        taskTwo();
//        double x = 2.0;//        System.out.println(x/0.0);
//        int cores = Runtime.getRuntime().availableProcessors();
//        System.out.println("Cores: " + cores);
    }

    /**
     * Задание 1
     Создать один объект Runnable который умеет выводить в консоль информацию о потоке:
     Имя потока
     ID потока
     Главный ли это поток?
     Затем создайте несколько потоков которые будут выполнять этот runnable. В том числе выполните этот же runnable в main методе.
     */
    static void taskOne() {
        Semaphore semaphore = new Semaphore(1);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    System.out.println("Thread name: " + Thread.currentThread().getName());
                    System.out.println("Thread ID: " + Thread.currentThread().getId());
                    System.out.println("This Thread is " + (Thread.currentThread().getId() == 1 ? "main" : "not main"));
                    System.out.println();
                    semaphore.release();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 7; i++) {
            new Thread(runnable).start();
        }

        runnable.run();
    }

    /**
     * Задание 2
     Дан файл с json в котором лежит массив целых чисел. Необходимо считать массив и выполнить с ним следующие
     независимые действия и по каждому отдельно вывести число - ответ:
     Найти сумму всех чисел 1 + 2 + 3 … + N
     Перемножить все числа друг на друга 1 * 2 * 3 … * N
     Делить каждое число на его индекс в массиве+1, найти сумму всех результатов деления 12 / 1 + 8 / 2 + 20 / 3 + 30
     / 4 … x / N  (1,2,3,4 … N - это индексы+1 элемента массива)
     Найти разницу всех чисел. 1 - 2 - 3 … - N

     Одновременно может выполняться только одна из 4 операций.
     Замерьте время выполнения каждой операции отдельно.
     Ускорьте время выполнения каждой операции разделив ее логику на потоки.

     Подсказка: гугл Thread.join

     */
    static void taskTwo() {
        String filename = "Files/Offline9/10 000 000 Numbers.txt";
        try {
            System.out.println("Starting parsing");
            long startTime = System.currentTimeMillis();
            int[] numbers = JSON.parseObject(new Scanner(new File(filename)).useDelimiter("\\Z").next(), int[].class);
            long finishTime = System.currentTimeMillis();
            System.out.println("Parsing done. Time elapsed: " + (finishTime - startTime));
            System.out.println();

            startTime = System.currentTimeMillis();
            Task2.printSum(numbers);
            finishTime = System.currentTimeMillis();
            System.out.println("Time elapsed: " + (finishTime - startTime));
            System.out.println();

            startTime = System.currentTimeMillis();
            Task2.printProduct(numbers);
            finishTime = System.currentTimeMillis();
            System.out.println("Time elapsed: " + (finishTime - startTime));
            System.out.println();

            startTime = System.currentTimeMillis();
            Task2.printSumNumbersDividedByIndex(numbers);
            finishTime = System.currentTimeMillis();
            System.out.println("Time elapsed: " + (finishTime - startTime));
            System.out.println();

            startTime = System.currentTimeMillis();
            Task2.printDifference(numbers);
            finishTime = System.currentTimeMillis();
            System.out.println("Time elapsed: " + (finishTime - startTime));
        }

        catch (Exception e) {
            e.printStackTrace();
        }


    }

}
