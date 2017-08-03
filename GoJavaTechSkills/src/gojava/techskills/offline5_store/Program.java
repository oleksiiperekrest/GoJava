package gojava.techskills.offline5_store;


import gojava.techskills.offline5_store.wares.Technical.Computer;

public class Program {
    public static void main(String[] args) {

        Computer computer = createComputer();
        computer.showInfo();
    }

    private static Computer createComputer() {

        return new Computer();
    }

}
