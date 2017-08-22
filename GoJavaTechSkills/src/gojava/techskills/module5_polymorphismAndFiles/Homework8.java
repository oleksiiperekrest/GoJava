package gojava.techskills.module5_polymorphismAndFiles;
/*
https://docs.google.com/document/d/1DcUSgTZNYaj3mUQqJ-0xSdE3Jc-6VfCJFTxsn3g2kyA/edit#heading=h.banl4cj40apm
 */

import gojava.techskills.module5_polymorphismAndFiles.store.FlowerStore;

public class Homework8 {
    public static void main(String[] args) {
        FlowerStore flowerStore = new FlowerStore();
        int roses = 3;
        int chamomiles = 2;
        int tulips = 6;

        flowerStore.sell(roses, chamomiles, tulips);
    }
}
