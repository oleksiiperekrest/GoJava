package gojava.techskills.module5_OOP.Car;

import gojava.techskills.methods;

import java.util.Calendar;

public class CreateCar {

    private static double maxSpeedHolder;
    private static int passengerCapacityHolder;
    private static int menuLength = 4;

    public static Car createCar() {
        menuCreateCar();

        int userChoice = methods.getPositiveIntInput("Please make your choice.");

        switch (userChoice) {
            case 1:
                return createCarWithYear();
//                break;
            case 2:
                return createCarWithAttributes();
//                break;
            case 3:
                return createCarWithAttributesAndWheels();
//                break;
            case 0:
                System.exit(0);
                return null;
//                break;
            default:
                System.out.println("(Please enter an integer between 0 and " + (menuLength - 1) + ")");
                return createCar();
        }
    }

    private static void menuCreateCar() {
        String greetingMessage = "Hello, please make a choice.";
        String[] lines = new String[menuLength];
        lines[1] = "1. Create a new car with default properties (year of production must be entered).";
        lines[2] = "2. Create a new car with 4 doors and 4 wheels, all other attributes must be entered.";
        lines[3] = "3. Create a new car, with all attributes entered by user.";
        lines[0] = "0. Exit program.";

        System.out.println(greetingMessage);
        for (int i = 1; i < menuLength; i++) {
            System.out.println(lines[i]);
        }
        System.out.println(lines[0]);
    }

    private static Car createCarWithYear() {
        return new Car(inputCarYear());
    }

    private static Car createCarWithAttributes() {
        return new Car(inputCarYear(), inputEngineType(), inputMaxSpeed(), inputCurrentSpeed(), inputAccelerationTime(),
                inputPassengersCapacity(), inputPassengersCurrent());
    }

    private static Car createCarWithAttributesAndWheels() {
        return new Car(inputCarYear(), inputEngineType(), inputMaxSpeed(), inputCurrentSpeed(), inputAccelerationTime(),
                inputPassengersCapacity(), inputPassengersCurrent(), inputWheelsQuantity(), inputDoorsQuantity());
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

    private static String inputEngineType() {
        System.out.println("Please enter engine type of the car.");
        return methods.obtainStringInput();
    }

    private static double inputMaxSpeed() {
        return maxSpeedHolder = methods.getPositiveDoubleInput("Please enter max speed of the car in km/h");
    }

    private static double inputCurrentSpeed() {
        double speed = methods.getPositiveDoubleInput("Enter current speed of the car");
        if (speed <= maxSpeedHolder) return speed;
        else {
            System.out.println("Current speed may not exceed maximal speed!");
            return inputCurrentSpeed();
        }
    }

    private static double inputAccelerationTime() {
        return methods.getPositiveDoubleInput("Please enter acceleration time to 100 km/h in seconds.");
    }

    private static int inputPassengersCapacity() {
        return passengerCapacityHolder = methods.getPositiveIntInput("Enter passenger capacity.");
    }

    private static int inputPassengersCurrent() {
        int passengers = methods.getPositiveIntInput("Enter current passengers quantity in the car.");
        if (passengers <= passengerCapacityHolder) return passengers;
        else {
            System.out.println("This car cannot hold more than " + passengerCapacityHolder + " passengers!");
            return inputPassengersCurrent();
        }
    }

    private static int inputWheelsQuantity() {
        return methods.getPositiveIntInput("Enter quantity of wheels in the car");
    }

    private static int inputDoorsQuantity() {
        return methods.getPositiveIntInput("Enter quantity of doors in the car");
    }

}
