package gojava.techskills.module5_OOP.CarParts;

/*
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
*/


public class CarWheel {

    //variables

    private double wheelHealth;

    //constructors

    /**
     * Default constructor, wheel is 100% healthy.
     */
    public CarWheel() {
        wheelHealth = 1.0;
    }

    /**
     * Constructor with defined wheel state (from 1.0 to 0.0).
     *
     * @param wheelState Heath of new wheel (1.0 to 0.0).
     * @throws Exception If double wheelHealth is out of bounds (1.0 to 0.0).
     */
    CarWheel(double wheelState) throws Exception {
        if (wheelState >= 0 && wheelState <= 1)
            this.wheelHealth = wheelState;
        else throw new Exception("Size out of bounds.");
    }

    //methods

    /**
     * Wheel is now new with 100% health.
     */
    void renewWheel() {
        wheelHealth = 1.0;
    }

    /**
     * Wears out wheel for defined value.
     *
     * @param damage Value of damage to wheel.
     * @throws Exception If damage is out of bounds (0.0 to 1.0).
     */
    public void wearOutWheel(double damage) throws Exception {
        if (damage >= 0) {
            if (damage >= wheelHealth)
                wheelHealth = 0;
            else wheelHealth -= damage;
        } else throw new Exception("Damage must be a positive number!");
    }

    /**
     * @return Health of the wheel (1.0 to 0.0)
     */
    public double getWheelHealth() {
        return wheelHealth;
    }

    public void printWheelState() {
        if (wheelHealth == 0.0)
            System.out.println("The wheel is totally broken. Replacement advised.");
        else if (wheelHealth == 1.0)
            System.out.println("The wheel is totally new and undamaged.");
        else {
            System.out.printf("The wheel is at %.2f%% durability.\n", wheelHealth*100);
        }
    }
}
