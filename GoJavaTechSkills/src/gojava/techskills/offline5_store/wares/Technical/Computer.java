package gojava.techskills.offline5_store.wares.Technical;

/*компьютер
    ->id
    ->название
    ->кол-во
    ->описание
    ->цена
    +тех. спецификация
        оперативная память
            объем
            тип памяти (DDR1 / DDR2 / DDR3 / DDR4 / DDR5)
        процессор
            кол-во ядер
            тактовая частота ядра
        видео карта
            кол-во ядер
            тактовая частота ядра
            видеопамять
            объем
            тип памяти (DDR1 / DDR2 / DDR3 / DDR4 / DDR5)
        гарантийный срок
*/

import gojava.techskills.offline5_store.wares.Technical.TechSpecification.ComputerTechSpecification;

public class Computer extends TechnicalProducts {
    private ComputerTechSpecification techSpecification;

    public void showInfo() {
        super.showInfo();
        System.out.println("Specification: " + techSpecification.toString());
    }

}
