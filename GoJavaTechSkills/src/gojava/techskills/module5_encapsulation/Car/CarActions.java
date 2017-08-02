package gojava.techskills.module5_encapsulation.Car;

import gojava.techskills.methods;

public class CarActions {

    private static int menuLength = 13;

    public static void carActions(Car car) {

        boolean repeat = true;

        do {
            menuCarActions();

            int userChoice = methods.getPositiveIntInput("Please make your choice.");

            switch (userChoice) {
                case 1:
                    setCarCurrentSpeed(car);
                    break;
                case 2:
                    addOnePassenger(car);
                    break;
                case 3:
                    dropOnePassenger(car);
                    break;
                case 4:
                    dropAllPassengers(car);
                    break;
                case 5:
                    changeDoorState(car);
                    break;
                case 6:
                    viewDoorsState(car);
                    break;
                case 7:
                    changeWheelState(car);
                    break;
                case 8:
                    viewWheelsState(car);
                    break;
                case 9:
                    addWheels(car);
                    break;
                case 10:
                    removeAllWheels(car);
                    break;
                case 11:
                    calculateMaxSpeed(car);
                    break;
                case 12:
                    car.printCarInfo();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("(Please enter an integer between 0 and " + (menuLength - 1) + ")");
                    carActions(car);
            }
            if (!methods.yesNo("\nDo you wish to continue?")) repeat = false;
        }
        while (repeat);
    }

    static void menuCarActions() {
        String greetingMessage = "\n\nWhat would you like to do with your new car?";
        String[] lines = new String[menuLength];
        lines[1] = "1. Change current speed;";
        lines[2] = "2. Get one passenger into the car;";
        lines[3] = "3. Drop one passenger off the car;";
        lines[4] = "4. Drop off all the passengers;";
        lines[5] = "5. Change state of a select door;";
        lines[6] = "6. Review state of all doors;";
        lines[7] = "7. Change state of a select wheel;";
        lines[8] = "8. Review state of all wheels;";
        lines[9] = "9. Install additional wheels into the car;";
        lines[10] = "10. Remove all wheels from the car;";
        lines[11] = "11. Calculate current maximal speed of the car;";
        lines[12] = "12. Print information about the car;";

        lines[0] = "0. Exit program.";

        System.out.println(greetingMessage);
        for (int i = 1; i < menuLength; i++) {
            System.out.println(lines[i]);
        }
        System.out.println(lines[0]);

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

    private static void addOnePassenger(Car car) {
        car.addOnePassenger();
    }

    private static void dropOnePassenger(Car car) {
        car.dropOffOnePassenger();
    }

    private static void dropAllPassengers(Car car) {
        car.dropOffAllPassengers();
    }


    private static void changeDoorState(Car car) {
        int index = selectCarDoor(car);

        menuDoorActions();
        selectDoorAction(car, index);
    }

    private static int selectCarDoor(Car car) {
        int userChoice = methods.getPositiveIntInput("Select a door ( 0 to " + (car.getDoorsQuantity() - 1) + ").");
        if (userChoice < car.getDoorsQuantity()) return userChoice;
        else {
            System.out.println("Sorry, wrong input!");
            return selectCarDoor(car);
        }
    }

    private static void menuDoorActions() {
        String[] lines = new String[6];
        lines[0] = "1. Open the door;";
        lines[1] = "2. Close the door;";
        lines[2] = "3. Toggle the door;";
        lines[3] = "4. Open the window;";
        lines[4] = "5. Close the window;";
        lines[5] = "6. Toggle the window;";

        for (String line : lines) {
            System.out.println(line);
        }
    }

    private static void selectDoorAction(Car car, int index) {
        int userChoice = methods.getBoundIntInput(
                "Please make your choice.",
                "Wrong input, please try again.",
                1, 6);

        switch (userChoice) {
            case 1:
                car.openDoor(index);
                break;
            case 2:
                car.closeDoor(index);
                break;
            case 3:
                car.toggleDoor(index);
                break;
            case 4:
                car.openWindow(index);
                break;
            case 5:
                car.closeWindow(index);
                break;
            case 6:
                car.toggleWindow(index);
                break;
            default:
                System.out.println("Wrong input, please try again");
        }
    }

    private static void viewDoorsState(Car car) {
        car.printDoorsState();
    }


    private static void changeWheelState(Car car) {
        if (car.getWheelsQuantity() != 0) {
            int index = selectWheel(car);

            menuWheelActions();
            selectWheelAction(car, index);
        } else System.out.println("There are no wheels!");

    }

    private static int selectWheel(Car car) {
        int userChoice = methods.getPositiveIntInput("Select a wheel ( 0 to " + (car.getWheelsQuantity() - 1) + ").");
        if (userChoice < car.getWheelsQuantity()) return userChoice;
        else {
            System.out.println("Sorry, wrong input!");
            return selectWheel(car);
        }
    }

    private static void menuWheelActions() {
        String[] lines = new String[2];
        lines[0] = "1. Damage the wheel;";
        lines[1] = "2. Renew the wheel;";

        for (String line : lines) {
            System.out.println(line);
        }
    }

    private static void selectWheelAction(Car car, int index) {
        if (car.getWheelsQuantity() != 0) {
            int userChoice = methods.getBoundIntInput(
                    "Please make your choice.",
                    "Wrong input, please try again.",
                    1, 2);
            switch (userChoice) {
                case 1:
                    try {
                        car.damageWheel(index, inputWheelDamage() / 100);
                        if (car.getCurrentSpeed() > car.calculateCurrentMaxSpeed())
                            car.setCurrentSpeed(car.calculateCurrentMaxSpeed());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        selectWheelAction(car, index);
                    }

                    break;
                case 2:
                    try {
                        car.renewWheel(index);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                        selectWheelAction(car, index);
                    }
                    break;
            }
        } else System.out.println("There are no wheels!");
    }

    private static double inputWheelDamage() {
        return methods.getPositiveDoubleInput("Enter damage to the wheel (in percents %).");
    }

    private static void viewWheelsState(Car car) {
        if (car.getWheelsQuantity() != 0) car.printWheelsState();
        else System.out.println("There are no wheels!");
    }

    private static void addWheels(Car car) {
        car.addWheels(methods.getPositiveIntInput("Enter quantity of wheels to add."));
    }

    private static void removeAllWheels(Car car) {
        car.removeAllWheels();
    }

    private static void calculateMaxSpeed(Car car) {
        double speed = car.calculateCurrentMaxSpeed();
        try {
            car.setCurrentSpeed(speed);
        } catch (Exception e) {
        }

        System.out.printf("Current maximal speed of a car is: %.2f km/h.\n", speed);
    }

}
