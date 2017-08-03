package gojava.techskills.offline5_store.wares.GeneralGoods;

/*одежда
    ->id
    ->название
    ->кол-во
    ->описание
    ->цена
    +бренд
        год основания
        название
        кол-во работников
        кол-во стран в котором продаются товары
 */

import gojava.techskills.offline5_store.wares.Item;

public class Clothes extends Item {
    private ClothesBrand clothesBrand;

    public void showInfo() {
        super.showInfo();
        System.out.println("Brand: " + clothesBrand);
    }

}
