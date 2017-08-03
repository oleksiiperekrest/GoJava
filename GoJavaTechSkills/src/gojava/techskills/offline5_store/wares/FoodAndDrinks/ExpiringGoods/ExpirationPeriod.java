package gojava.techskills.offline5_store.wares.FoodAndDrinks.ExpiringGoods;

/*срок годности
    +дата производства
    +температура хранения
    +продолжительность срока годности (30 дней / 365 дней / ...)
 */

import java.util.Calendar;

public class ExpirationPeriod {
    private Calendar manufacturingDate;
    private double storingTemperature;
    private int storingPeriod;
}
