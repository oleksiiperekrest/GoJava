package gojava.techskills.offline3;


public class CircleGenerator {
    private int count = 1;
    private Circle[] circles;
    private double randomizeRange = 10;


    private double randomNumber(){
        return Math.random() * this.randomizeRange;
    }
    public CircleGenerator(int count) {
        this.count = count;
        generate(count);
    }


    public void generate(int countOfCircles) {
        count = countOfCircles;
        for (int i = 0; i < this.circles.length; i++) {
            this.circles[i] = new Circle(new Point(randomNumber(), randomNumber()), randomNumber());
            circles[i].printCircleInfo();
        }
    }



    public void printCirclesInfo() {
        for (int i = 0; i < circles.length; i++) {
            this.circles[i].printCircleInfo();
        }
    }


}

