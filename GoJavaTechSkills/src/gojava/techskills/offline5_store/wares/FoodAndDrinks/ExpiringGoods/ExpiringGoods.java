package gojava.techskills.offline5_store.wares.FoodAndDrinks.ExpiringGoods;

/*ExpiringGoods
    ->id
    ->название
    ->кол-во
    ->описание
    ->цена
    +срок годности
 */

import gojava.techskills.offline5_store.wares.Item;

public abstract class ExpiringGoods extends Item {
    protected ExpirationPeriod expirationPeriod;

    public void showInfo() {
        super.showInfo();
        System.out.println("Expiration date: " + expirationPeriod.toString());
    }
}
