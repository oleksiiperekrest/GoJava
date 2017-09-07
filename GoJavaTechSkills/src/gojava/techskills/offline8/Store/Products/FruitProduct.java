package gojava.techskills.offline8.Store.Products;

public class FruitProduct extends Product {
    private double weight;

    public FruitProduct(String name, double price, double weight) {
        super(name, price);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public void show() {
        super.show();
        System.out.println(this.weight);
    }
}
