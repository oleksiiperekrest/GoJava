package gojava.techskills.offline8.Store;

import gojava.techskills.offline8.Store.Products.AnimalProduct;
import gojava.techskills.offline8.Store.Products.FruitProduct;
import gojava.techskills.offline8.Store.Products.TechProduct;
import gojava.techskills.offline8.Store.Store;

public class TradeQuarters {
    private Store <FruitProduct> fruitStore;
    private Store <TechProduct> techStore;
    private Store <AnimalProduct> animalStore;

    public Store getFruitStore() {
        return fruitStore;
    }

    public Store getTechStore() {
        return techStore;
    }

    public Store getAnimalStore() {
        return animalStore;
    }

    public void setFruitStore(Store<FruitProduct> fruitStore) {
        this.fruitStore = fruitStore;
    }

    public void setTechStore(Store<TechProduct> techStore) {
        this.techStore = techStore;
    }

    public void setAnimalStore(Store<AnimalProduct> animalStore) {
        this.animalStore = animalStore;
    }

    public void show() {
        this.fruitStore.show();
        this.techStore.show();
        this.animalStore.show();

    }
}
