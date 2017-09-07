package gojava.techskills.offline8.Store;

import gojava.techskills.offline8.Store.Products.Product;

public class Store<T extends Product> {
    private String name;
    private String address;
    private  T[] products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public T[] getProducts() {
        return products;
    }

    public void setProducts(T[] products) {
        this.products = products;
    }

    public void show() {
        System.out.println(this.name);
        System.out.println(this.address);
        for (Product product : products) {
            System.out.print("  ");
            product.show();
        }
    }
}
