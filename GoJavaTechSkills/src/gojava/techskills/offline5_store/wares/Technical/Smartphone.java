package gojava.techskills.offline5_store.wares.Technical;

/*смартфон
    ->id
    ->название
    ->кол-во
    ->описание
    ->цена
    +тех. спецификация
        операционная система (iOS / Android / Windows Phone)
        оперативная память
            объем
            тип памяти (DDR1 / DDR2 / DDR3 / DDR4 / DDR5)
        процессор
            кол-во ядер
            тактовая частота ядра
        диагональ экрана
        время работы от батареи
    ->гарантийный срок
*/

import gojava.techskills.offline5_store.wares.Technical.TechSpecification.PhoneTechSpecification;

public class Smartphone extends TechnicalProducts {
    private PhoneTechSpecification techSpecification;

    public void showInfo() {
        super.showInfo();
        System.out.println("Specification: " + techSpecification.toString());
    }
}
