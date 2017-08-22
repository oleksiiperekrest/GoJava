package gojava.techskills.module5_polymorphismAndFiles.store;

import gojava.techskills.module5_polymorphismAndFiles.flower.Chamomile;
import gojava.techskills.module5_polymorphismAndFiles.flower.Flower;
import gojava.techskills.module5_polymorphismAndFiles.flower.Rose;
import gojava.techskills.module5_polymorphismAndFiles.flower.Tulip;

public class FlowerStore {

    public void sell(int roses, int chamomiles, int tulips) {
        int size = roses + chamomiles + tulips;
        Flower[] bouquet = new Flower[size];

        for (int i = 0; i < bouquet.length; i++) {
            if (i < roses) bouquet[i] = new Rose();
            else if (i < (roses + chamomiles)) bouquet[i] = new Chamomile();
            else bouquet[i] = new Tulip();
        }

        printBouquet(bouquet);
    }

    public void printBouquet(Flower[] bouquet) {
        for (int i = 0; i < (bouquet.length - 1); i++) {
            System.out.print(bouquet[i] + ", ");
        }
        System.out.println(bouquet[(bouquet.length - 1)] + ".");
    }
}
