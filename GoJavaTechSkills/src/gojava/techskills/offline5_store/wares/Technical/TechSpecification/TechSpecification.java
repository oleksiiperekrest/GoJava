package gojava.techskills.offline5_store.wares.Technical.TechSpecification;

/*
тех. спецификация
    +оперативная память
    +процессор
 */

import gojava.techskills.ShowInfo;
import gojava.techskills.offline5_store.wares.Technical.TechSpecification.TechSpecificationComponents.Cpu;
import gojava.techskills.offline5_store.wares.Technical.TechSpecification.TechSpecificationComponents.Ram;

public abstract class TechSpecification implements ShowInfo{

    protected Ram ram;
    protected Cpu cpu;

    public void showInfo() {
        System.out.println("RAM: " + ram.toString());
        System.out.println("CPU: " + cpu.toString());
    }
}
