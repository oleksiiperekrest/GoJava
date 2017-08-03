package gojava.techskills.offline5_store.wares.FoodAndDrinks;

/*питьевая вода
    ->id
    ->название
    ->кол-во
    ->описание
    ->цена
 */
import gojava.techskills.offline5_store.wares.Item;

public class DrinkingWater extends Item {

    public DrinkingWater(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
