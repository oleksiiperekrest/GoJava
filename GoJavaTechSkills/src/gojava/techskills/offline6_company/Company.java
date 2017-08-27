package gojava.techskills.offline6_company;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import gojava.techskills.offline6_company.workers.Worker;
import gojava.techskills.offline6_company.workers.WorkerFixedWage;
import gojava.techskills.offline6_company.workers.WorkerFreelancer;
import gojava.techskills.offline6_company.workers.WorkerHourlyWage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/*
Задание 2
Создать класс - Company.
Компания хранит массив своих работником.
Написать функцию расчета денежных затрат компании в месяц на выплату зарплат работникам.

Написать функцию которая выводит информацию о всех работниках в консоль.

Компания должна уметь сохранять все свои данные в файл. И уметь загружать данные с файла при запуске.
Если файл поврежден / отсутствует / имеет некорректный формат, программа должна проигнорировать его и запуститься по умолчанию минуя загрузку данных с файла.

 */

public class Company {


    private Worker[] workers;

    public Company(Worker[] workers) {
        this.workers = workers;
    }

    public double countMonthlyWages() {
        double wage = 0;
        for (Worker worker : workers) {
            wage += worker.monthlyWage();
        }
        return wage;
    }

    public void printWorkersInfo() {
        for (Worker worker : workers) {
            System.out.println(worker.getWorkerInfo());
        }
    }

    public void setWorkers(Worker[] workers) {
        this.workers = workers;
    }

    public void writeToFile() {
        try {
            FileWriter writer = new FileWriter("Files/CompanyFiles/workers.txt");
            writer.write(workers.length + "\n");
            for (Worker worker : workers) {

                if (worker instanceof WorkerFreelancer) {
                    writer.write("WorkerFreelancer\n");
                    writer.write(worker.getName() + "\n");
                    writer.write(worker.getSurname() + "\n");
                    writer.write(((WorkerFreelancer) worker).getHourlyRate() + "\n");
                    writer.write(((WorkerFreelancer) worker).getWorkhours() + "\n");

//                    writer.write(";\n");
                    writer.flush();
                } else if (worker instanceof WorkerHourlyWage) {
                    writer.write("WorkerHourlyWage\n");
                    writer.write(worker.getName() + "\n");
                    writer.write(worker.getSurname() + "\n");
                    writer.write(((WorkerHourlyWage) worker).getHourlyRate() + "\n");

//                    writer.write(";\n");
                    writer.flush();
                } else if (worker instanceof WorkerFixedWage) {
                    writer.write("WorkerFixedWage\n");
                    writer.write(worker.getName() + "\n");
                    writer.write(worker.getSurname() + "\n");
                    writer.write(((WorkerFixedWage) worker).getMonthWage() + "\n");

//                    writer.write(";\n");
                    writer.flush();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Worker[] readFile(String filename) {
        try {
            FileReader reader = new FileReader(filename);
            BufferedReader br = new BufferedReader(reader);
            String sizeString = br.readLine();
            int size = Integer.parseInt(sizeString);
            Worker[] workers = new Worker[size];

            for (int i = 0; i < workers.length; i++) {
                String readType = br.readLine();
                if (readType.equals("WorkerFreelancer")) {
                    workers[i] = new WorkerFreelancer(br.readLine(), br.readLine(), Double.parseDouble(br.readLine()),
                            Double.parseDouble(br.readLine()));

                } else if (readType.equals("WorkerHourlyWage")){
                    workers[i] = new WorkerHourlyWage(br.readLine(), br.readLine(), Double.parseDouble(br.readLine()));

                } else if (readType.equals("WorkerFixedWage")){
                    workers[i] = new WorkerHourlyWage(br.readLine(), br.readLine(), Double.parseDouble(br.readLine()));
                }

            }

























        } catch (Exception e) {
            e.printStackTrace();
        }
        return workers;
    }


}
