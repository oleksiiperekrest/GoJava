package gojava.techskills.offline6_company.workers;

public class WorkerFreelancer extends WorkerHourlyWage {
    private double workhours;

    public WorkerFreelancer(String name, String surname, double hourlyRate, double workhours) {
        super(name, surname, hourlyRate);
        this.workhours = workhours;
    }

    public double getWorkhours() {
        return workhours;
    }
}
