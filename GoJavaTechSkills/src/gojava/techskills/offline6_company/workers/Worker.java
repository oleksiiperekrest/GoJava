package gojava.techskills.offline6_company.workers;

public abstract class Worker {

    protected static double workdays = 20.8;
    protected static double workhours = 8;
    private String name;
    private String surname;

    public String getSurname() {
        return surname;
    }

    public Worker(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return this.name + " " + this.surname;
    }

    public String getWorkerInfo() {
        return this.getFullName() + ": " + monthlyWage();
    }

    public abstract double monthlyWage();
}
