package gojava.techskills.offline5_store.wares;

/*Item
    +id
    +название
    +кол-во
    +описание
    +цена
 */

import gojava.techskills.ShowInfo;

public abstract class Item implements ShowInfo {
    protected int id;
    protected String name;
    protected int quantity;
    protected double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void showInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + price);
    }
}
