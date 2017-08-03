package gojava.techskills.offline5_store.wares.Technical;

/*TechnicalProducts
    ->id
    ->название
    ->кол-во
    ->описание
    ->цена
    *тех. спецификация
    +гарантийный срок
*/

import gojava.techskills.offline5_store.wares.Item;
import java.util.Calendar;

abstract class TechnicalProducts extends Item {
    private Calendar warrantyTerm;

    public void showInfo() {
        super.showInfo();
        System.out.println("Warranty term: " + warrantyTerm.toString());
    }
}
