package gojava.techskills.offline6_company;

import gojava.techskills.offline6_company.workers.Worker;
import gojava.techskills.offline6_company.workers.WorkerFixedWage;
import gojava.techskills.offline6_company.workers.WorkerFreelancer;
import gojava.techskills.offline6_company.workers.WorkerHourlyWage;

public class Program {
    public static void main(String[] args) {

        Worker[] workers = new Worker[5];
//        workers[0] = new WorkerFixedWage("Alice", "Anderson", 3800);
//        workers[1] = new WorkerFixedWage("Bob", "Barnet", 4200);
//        workers[2] = new WorkerHourlyWage("Charles", "Carlsen", 14.7);
//        workers[3] = new WorkerFreelancer("Dave", "Dilan", 3800, 4.5);
//        workers[4] = new WorkerHourlyWage("Eva", "Ermon", 12.7);

//        for (Worker worker : workers) {
//            System.out.println("Monthly wage for " + worker.getFullName() + " "  + ": " + worker.monthlyWage());
//        }

        Company company = new Company(workers);
//        System.out.println("Overall wage expenses: " + company.countMonthlyWages());
//        System.out.println("Workers info:");
//        company.printWorkersInfo();

//        company.writeToFile();
        System.out.println();

        company.setWorkers(company.readFile("CompanyFiles/workers.txt"));

//        System.out.println("Overall wage expenses: " + company.countMonthlyWages());
        System.out.println("Workers info:");
        company.printWorkersInfo();


    }


}
