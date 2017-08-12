package gojava.techskills.offline6_company.workers;

public class WorkerFixedWage extends Worker {
    private double monthWage;

    public WorkerFixedWage(String name, String surname, double monthWage) {
        super(name, surname);
        this.monthWage = monthWage;
    }

    public double monthlyWage() {
        return monthWage;
    }

    public double getMonthWage() {
        return monthWage;
    }
}
