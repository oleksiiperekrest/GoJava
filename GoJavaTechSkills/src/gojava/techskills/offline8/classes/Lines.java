package gojava.techskills.offline8.classes;

public class Lines {
    public String[] lines;

    public String[] getLines() {
        return lines;
    }

    public void printLines() {
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
