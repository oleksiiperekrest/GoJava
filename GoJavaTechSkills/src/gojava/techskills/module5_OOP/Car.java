package gojava.techskills.module5_OOP;

/*
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
*/

import gojava.techskills.module5_OOP.CarParts.CarDoor;
import gojava.techskills.module5_OOP.CarParts.CarWheel;

public class Car {

    //variables

    private int productionYear;
    private String engineType = "Petrol";

    private double maxSpeed = 160.0;
    private double currentSpeed = 0.0;
    private double acceleration100Time = 10.0;

    private int passengersCapacity = 5;
    private int passengersCurrent = 1;

    private int wheelsQuantity = 4;
    private CarWheel[] wheels;
    private int doorsQuantity = 4;
    private CarDoor[] doors;

    //constructors

    /**
     * Forbid no-arg constructor;
     */
    private Car() {
    }

    /**
     * Creates a new car of defined production year.
     * All other parameters are defaults: petrol engine, max speed 160 km/h, 10 seconds acceleration to 100rm/h,
     * 5 passenger capacity, 1 current passenger (driver), 4 doors, 4 wheels.
     *
     * @param productionYear Year of production of the car.
     */
    Car(int productionYear) {
        this.productionYear = productionYear;
        wheels = new CarWheel[wheelsQuantity];
        for (int i = 0; i < wheels.length; i++) {
            wheels[i] = new CarWheel();
        }
        doors = new CarDoor[doorsQuantity];
        for (int i = 0; i < doors.length; i++) {
            doors[i] = new CarDoor();
        }
    }

    /**
     * Creates a new car with defined parameters. It would have 4 wheels and 4 doors.
     *
     * @param productionYear      Year of production of the car.
     * @param engineType          Engine type.
     * @param maxSpeed            Maximal speed in km/h.
     * @param currentSpeed        Current speed in km/h.
     * @param acceleration100Time Acceleration time to 100 km/h in seconds.
     * @param passengersCapacity  Passenger capacity (driver included).
     * @param passengersCurrent   Current passengers in the car (driver included).
     */
    public Car(int productionYear, String engineType, double maxSpeed, double currentSpeed, double acceleration100Time,
               int passengersCapacity, int passengersCurrent) {
        this.productionYear = productionYear;
        this.engineType = engineType;
        this.maxSpeed = maxSpeed;
        this.currentSpeed = currentSpeed;
        this.acceleration100Time = acceleration100Time;
        this.passengersCapacity = passengersCapacity;
        this.passengersCurrent = passengersCurrent;

        wheels = new CarWheel[wheelsQuantity];
        for (int i = 0; i < wheels.length; i++) {
            wheels[i] = new CarWheel();
        }
        doors = new CarDoor[doorsQuantity];
        for (int i = 0; i < doors.length; i++) {
            doors[i] = new CarDoor();
        }
    }

    /**
     * /**
     * Creates a new car with defined parameters.
     *
     * @param productionYear      Year of production of the car.
     * @param engineType          Engine type.
     * @param maxSpeed            Maximal speed in km/h.
     * @param currentSpeed        Current speed in km/h.
     * @param acceleration100Time Acceleration time to 100 km/h in seconds.
     * @param passengersCapacity  Passenger capacity (driver included).
     * @param passengersCurrent   Current passengers in the car (driver included).
     * @param wheelsQuantity      Quantity of wheels on the car.
     * @param doorsQuantity       Quantity of doors on the car.
     */
    public Car(int productionYear, String engineType, double maxSpeed, double currentSpeed, double acceleration100Time,
               int passengersCapacity, int passengersCurrent, int wheelsQuantity, int doorsQuantity) {
        this.productionYear = productionYear;
        this.engineType = engineType;
        this.maxSpeed = maxSpeed;
        this.currentSpeed = currentSpeed;
        this.acceleration100Time = acceleration100Time;
        this.passengersCapacity = passengersCapacity;
        this.passengersCurrent = passengersCurrent;

        wheels = new CarWheel[wheelsQuantity];
        for (int i = 0; i < wheels.length; i++) {
            wheels[i] = new CarWheel();
        }
        doors = new CarDoor[doorsQuantity];
        for (int i = 0; i < doors.length; i++) {
            doors[i] = new CarDoor();
        }
    }

    //methods

    /**
     * Sets new current speed.
     *
     * @param currentSpeed New current speed.
     * @throws Exception If new speed is out of bounds (0.0 to max speed).
     */
    void setCurrentSpeed(double currentSpeed) throws Exception {
        if (currentSpeed >= 0 && currentSpeed <= calculateCurrentMaxSpeed()) {
            this.currentSpeed = currentSpeed;
        } else throw new Exception("Value out of bounds (0.0 to " + calculateCurrentMaxSpeed() + ")!");
    }

    double getCurrentSpeed() {
        return currentSpeed;
    }

    void addOnePassenger() {
        if (passengersCurrent < passengersCapacity)
            passengersCurrent++;
        else System.out.println("No more room for another passenger!");
    }

    void removeOnePassenger() {
        if (passengersCurrent > 0)
            passengersCurrent--;
        else System.out.println("No passengers left, no one to drop off!");
    }

    void dropOffAllPassengers() {
        passengersCurrent = 0;
    }

    CarDoor getCarDoor(int index) throws IndexOutOfBoundsException {
        return doors[index];
    }



    void printDoorsState() {
        System.out.println("There are " + doors.length + " doors.");
        for (int i = 0; i < doors.length; i++) {
            System.out.print("Door #" + i + ": ");
            doors[i].printDoorState();
        }
    }

    CarWheel getCarWheel(int index) throws IndexOutOfBoundsException {
        return wheels[index];
    }

    void removeAllWheels() {
        wheels = new CarWheel[0];
    }

    void addWheels(int wheelsQuantity) {
        int oldWheelsLength = wheels.length;
        CarWheel[] newWheels = new CarWheel[oldWheelsLength + wheelsQuantity];
        for (int i = 0; i < oldWheelsLength; i++) {
            newWheels[i] = wheels[i];
        }
        for (int i = wheels.length; i < newWheels.length; i++) {
            newWheels[i] = new CarWheel();
        }

        wheels = newWheels;
    }

    void printWheelsState() {
        System.out.println("There are " + wheels.length + " wheels.");
        for (int i = 0; i < wheels.length; i++) {
            System.out.print("Wheel #" + i + ": ");
            wheels[i].printWheelState();
        }
    }

    void damageWheel(int index, double damage) throws Exception {
        try {
            wheels[index].wearOutWheel(damage);
        } catch (Exception e) {
            throw e;
        }
    }

    double calculateCurrentMaxSpeed() {
        if (passengersCurrent == 0) return 0;
        double minWheelHealth = wheels[0].getWheelHealth();
        for (int i = 1; i < wheels.length; i++) {
            minWheelHealth = minWheelHealth > wheels[i].getWheelHealth() ? wheels[i].getWheelHealth() : minWheelHealth;
        }
        return maxSpeed * minWheelHealth;
    }

    int getWheelsQuantity() {
        return wheelsQuantity;
    }

    void printCarInfo() {
        System.out.println("Car production year: " + productionYear + ";" +
                "\nCar engine type: " + engineType + ";" +
                "\nMaximal speed(technically): " + maxSpeed + " km/h;" +
                "\nCurrent speed: " + currentSpeed + " km/h;" +
                "\nAcceleration to 100 km/h: " + acceleration100Time + " seconds;" +
                "\nPassengers capacity: " + passengersCapacity + ";" +
                "\nCurrently passengers in: " + passengersCurrent + ";");

        printWheelsState();
        printDoorsState();
        System.out.printf("Current maximum speed: %.2f km/h.", calculateCurrentMaxSpeed());
    }
}
