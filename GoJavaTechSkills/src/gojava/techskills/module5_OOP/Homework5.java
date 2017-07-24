package gojava.techskills.module5_OOP;

/*
Задача 1
Создать пакет соответствующий(название на ваш вкус, но должно быть логично связанно с именами классов) пакет
и поместить туда все последующие классы

Класс CarDoor
На прямую к переменным этого класса никто не может, только через методы
--------------------
Хранит:
состояние двери(открыта/закрыта)
состояние окна (открыто/закрыто)

Конструктор
--------------------
Требуется насколько конструкторов на различные случаи
Один без аргументов. Он должен присвоить переменым значения на случай если данных нет.
Один конструктор принимает оба состояния, двери и окна. Присваивает эти значения переменным внутри объекта.

Методы
--------------------
открыть дверь
закрыть дверь
открыть/закрыть дверь (если дверь открыта и вызывается эта функция, значит дверь необходимо закрыть и наоборот)
открыть окно
закрыть окно
открыть/закрыть окно(если дверь открыта и вызывается эта функция, значит дверь необходимо закрыть и наоборот)
Вывести в консоль данные об объекте

Класс CarWheel
На прямую к переменным этого класса никто не может, только через методы
--------------------
Хранит:
Состояние целостности шины (дробное число от 0-стерта до 1-новая)

Конструктор
--------------------
Аналогичный принцип как в классе CarDoor

Методы
--------------------
Сменить шину на новую
Стереть шину на X%
Получить состояние (return)
Вывести в консоль данные об объекте

Класс CarParts.
На прямую к переменным этого класса никто не может, только через методы
--------------------
Хранит:
дата производства (не изменна после создания объекта)
тип двигателя
максимальная скорость машины (если она новая)
время разгона до 100км/ч
пассажировместимость
кол-во пасажиров внутри в данный момент
текущая скорость
массив колес
массив дверей

Конструктор
--------------------
Нет пустого конструктора. Так как есть поля в классе, которые нельзя изменять после создания объекта.
Например дата производства.
Конструктор с датой производства.
Конструктор со всеми полями, кроме массива колес и массива дверей.

Методы
--------------------
Изменить текущую скорость
Посадить 1 пассажира в машину
Высадить 1 пассажира
Высадить всех пассажиров
Получить дверь по индексу
Получить колесо по индексу
Снять все колеса с машины
Установить на машину X новых колесу (в добаков к имеющимся, то есть если было 4 колеса,
после вызова метода с Х аргументом равным трем, колес будет 4+3=7)
Вычислить текущую возможную максимальную скорость (Скорость машины вычисляется так.
 Максимальная скорость новой машины множиться на самое стертое колесо в машине.
 Максимальная скорость равна 0 если в машине нет ни одного пассажира, так как некому ее вести)
Вывести в консоль данные об объекте (все поля и вычисленную максимальную скорость в зависимости от целостности колес
и наличия водителя)

Доп. задание
Создать консольный пользовательский интерфейс. В котором пользователя программа будет спрашивать какое действие
выполнить и с какими параметрами.
Кол-во различных действий = кол-ву функций в ДЗ.
*/

import gojava.techskills.methods;

import java.util.Scanner;

public class Homework5 {
    static Scanner in = new Scanner(System.in);
    static Car car;

    public static void main(String[] args) {


        System.out.println("Car current speed = " + car.getCurrentSpeed());
        setCarCurrentSpeed(car);
        System.out.println("Car current speed = " + car.getCurrentSpeed());
        damageWheel(car);
        setCarCurrentSpeed(car);
        System.out.println("Car current speed = " + car.getCurrentSpeed());

//        car.printWheelsState();
//        System.out.println("Max speed: " + car.calculateCurrentMaxSpeed());
//        System.out.println("\nAttempting to damage one wheel.");
//        damageWheel(car);
//        car.printWheelsState();
//        System.out.println("Current max speed: " + car.calculateCurrentMaxSpeed());
//        car.printCarInfo();

    }


    private static void setCarCurrentSpeed(Car car) {
        double speed = methods.getDoubleInput("Enter new current speed.");
        try {
            car.setCurrentSpeed(speed);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            setCarCurrentSpeed(car);
        }
    }

    private static void damageWheel(Car car) {
        int index = methods.getBoundIntInput
                ("Enter index of a wheel.", 0, car.getWheelsQuantity() - 1);
        double damage = methods.getDoubleInput("Enter value of damage");
        try {
            car.damageWheel(index, damage);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            damageWheel(car);
        }
    }

}
