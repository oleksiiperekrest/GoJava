package gojava.techskills.offline6_company.workers;

public class WorkerHourlyWage extends Worker {

    private double hourlyRate;

    public double getHourlyRate() {
        return hourlyRate;
    }

    public WorkerHourlyWage(String name, String surname, double hourlyRate) {
        super(name, surname);
        this.hourlyRate = hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double monthlyWage() {
        double wage = workdays * workhours * hourlyRate;
        return wage;
    }
}
