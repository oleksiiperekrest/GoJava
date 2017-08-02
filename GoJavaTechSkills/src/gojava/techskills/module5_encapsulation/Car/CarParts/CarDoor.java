package gojava.techskills.module5_encapsulation.Car.CarParts;

/*
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
*/

/**
 * A car door with a window on it.
 * Contains boolean state for both door and window (true == open, false == closed).
 */
public class CarDoor {

    //variables

    private boolean doorIsOpen;
    private boolean windowIsOpen;

    //constructors

    /**
     * Default constructor. Both door and window will be closed.
     */
    public CarDoor() {
        doorIsOpen = false;
        windowIsOpen = false;
    }

    /**
     * Constructor with boolean parameters for state of door and window (open/closed).
     *
     * @param doorIsOpen   State of door.
     * @param windowIsOpen State of window.
     */
    CarDoor(boolean doorIsOpen, boolean windowIsOpen) {
        this.doorIsOpen = doorIsOpen;
        this.windowIsOpen = windowIsOpen;
    }

    //methods

    /**
     * Opens the door.
     */
    public void openDoor() {
        doorIsOpen = true;
    }

    /**
     * Closes the door.
     */
    public void closeDoor() {
        doorIsOpen = false;
    }

    /**
     * Reverses state of the door. Opens if was closed, closes if was open.
     */
    public void toggleDoor() {
        doorIsOpen = !doorIsOpen;
    }

    /**
     * Opens the window.
     */
    public void openWindow() {
        windowIsOpen = true;
    }

    /**
     * Closes the window.
     */
    public void closeWindow() {
        windowIsOpen = false;
    }

    /**
     * Reverses state of the window. Opens if was closed, closes if was open.
     */
    public void toggleWindow() {
        windowIsOpen = !doorIsOpen;
    }

    /**
     * Prints to console states of both door and window (open/closed).
     */
    public void printDoorState() {
        if (doorIsOpen)
            System.out.print("The door is open,");
        else
            System.out.print("The door is closed,");

        if (windowIsOpen)
            System.out.println(" the window is open.");
        else
            System.out.println(" the window is closed.");
    }


}
