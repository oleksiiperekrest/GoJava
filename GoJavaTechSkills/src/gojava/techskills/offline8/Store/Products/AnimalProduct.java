package gojava.techskills.offline8.Store.Products;

public class AnimalProduct extends Product {
    private int age;

    public AnimalProduct(String name, double price, int age) {
        super(name, price);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void show() {
        super.show();
        System.out.println(this.age);
    }
}
