package gojava.techskills.offline8.Store.Products;

public class TechProduct extends Product {
    private String description;
    private int guaranteeDuration;

    public TechProduct(String name, double price, String description, int guaranteeDuration) {
        super(name, price);
        this.description = description;
        this.guaranteeDuration = guaranteeDuration;
    }

    public String getDescription() {
        return description;
    }

    public int getGuaranteeDuration() {
        return guaranteeDuration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGuaranteeDuration(int guaranteeDuration) {
        this.guaranteeDuration = guaranteeDuration;
    }

    @Override
    public void show() {
        super.show();
        System.out.println(this.description);
        System.out.println(this.guaranteeDuration);
    }
}
