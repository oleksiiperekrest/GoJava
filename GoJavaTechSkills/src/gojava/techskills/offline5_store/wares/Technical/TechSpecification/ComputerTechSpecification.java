package gojava.techskills.offline5_store.wares.Technical.TechSpecification;

/*
тех. спецификация
    ->оперативная память
    ->процессор
    +видео карта
 */

import gojava.techskills.offline5_store.wares.Technical.TechSpecification.TechSpecificationComponents.GraphicCard;

public class ComputerTechSpecification extends TechSpecification {

    private GraphicCard graphicCard;

    public void showInfo() {
        super.showInfo();
        System.out.println("Graphic card: " + graphicCard.toString());
    }

}
