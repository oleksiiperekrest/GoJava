package gojava.techskills.module5_OOP;

import gojava.techskills.methods;

import java.util.Calendar;

public class CreateCar {

    private static double maxSpeedHolder;
    private static int passengerCapacityHolder;

    static void menuCreateCar() {
        String greetingMessage = "Hello, please make a choice.";
        String line1 = "1. Create a new car with default properties (year of production must be entered).";
        String line2 = "2. Create a new car with 4 doors and 4 wheels, all other attributes must be entered.";
        String line3 = "3. Create a new car, with all attributes entered by user.";
        String line0 = "0. Exit program.";

        System.out.println(greetingMessage);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line0);
    }

    static void createCarWithYear() {
        Homework5.car = new Car(inputCarYear());
    }

    static void createCarWithAttributes() {
        Homework5.car = new Car(inputCarYear(), inputEngineType(), inputMaxSpeed(), inputCurrentSpeed(), inputAccelerationTime(),
                inputPassengersCapacity(), inputPassengersCurrent());
    }

    static void createCarWithAttributesAndWheels() {
        Homework5.car = new Car(inputCarYear(), inputEngineType(), inputMaxSpeed(), inputCurrentSpeed(), inputAccelerationTime(),
                inputPassengersCapacity(), inputPassengersCurrent(), inputWheelsQuantity(), inputDoorsQuantity());
    }

    private static int inputDoorsQuantity() {
        return methods.getPositiveIntInput("Enter quantity of doors in the car");
    }

    private static int inputWheelsQuantity() {
        return methods.getPositiveIntInput("Enter quantity of wheels in the car");
    }

    private static int inputPassengersCurrent() {
        int passengers = methods.getPositiveIntInput("Enter current passengers quantity in the car.");
        if (passengers <= passengerCapacityHolder) return passengers;
        else {
            System.out.println("This car cannot hold more than " + passengerCapacityHolder + " passengers!");
            return inputPassengersCurrent();
        }
    }

    private static int inputPassengersCapacity() {
        return passengerCapacityHolder = methods.getPositiveIntInput("Enter passenger capacity.");
    }

    private static double inputAccelerationTime() {
        return methods.getPositiveDoubleInput("Please enter acceleration time to 100 km/h in seconds.");
    }

    private static double inputCurrentSpeed() {
        double speed = methods.getPositiveDoubleInput("Enter current speed of the car");
        if (speed <= maxSpeedHolder) return speed;
        else {
            System.out.println("Current speed may not exceed maximal speed!");
            return inputCurrentSpeed();
        }
    }

    private static double inputMaxSpeed() {
        return maxSpeedHolder =  methods.getPositiveDoubleInput("Please enter max speed of the car in km/h");
    }

    private static String inputEngineType() {
        System.out.println("Please enter engine type of the car.");
        return Homework5.in.nextLine();
    }

    private static int inputCarYear() {
        int firstCarYear = 1808; //(Wikipedia) In 1808 François Isaac de Rivaz designed
        // the first car powered by an internal combustion engine fueled by hydrogen.

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        return methods.getBoundIntInput(
                "Enter a year of car's production.",
                "Please enter a year between " + firstCarYear + " and " + currentYear + ".",
                firstCarYear, currentYear);
    }
}
