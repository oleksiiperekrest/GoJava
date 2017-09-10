package gojava.techskills.module5_polymorphismAndFiles;
/*
https://docs.google.com/document/d/1DcUSgTZNYaj3mUQqJ-0xSdE3Jc-6VfCJFTxsn3g2kyA/edit#heading=h.banl4cj40apm
 */

import gojava.techskills.methods;
import gojava.techskills.module5_polymorphismAndFiles.flower.Flower;
import gojava.techskills.module5_polymorphismAndFiles.flower.FlowersLoader;
import gojava.techskills.module5_polymorphismAndFiles.flower.FlowersSaver;
import gojava.techskills.module5_polymorphismAndFiles.store.FlowerStore;

public class Homework8 {
    public static void main(String[] args) {
        FlowerStore flowerStore = new FlowerStore();
        int roses = methods.getPositiveIntInput("Enter number of roses:");
        int chamomiles = methods.getPositiveIntInput("Enter number of chamomiles:");
        int tulips = methods.getPositiveIntInput("Enter number of tulips:");
        String filename = "Files/FlowerStoreFiles/bouquet.txt";

        System.out.println("Wallet: " + flowerStore.getWallet());
        System.out.println();
        System.out.println("Selling straight bouquet:");
        flowerStore.sell(roses, chamomiles, tulips);
        System.out.println("Selling organized bouquet:");
        flowerStore.sellSequence(roses, chamomiles, tulips);

        Flower[] randomBouquet = flowerStore.randomBouquet(methods.getPositiveIntInput
                ("Enter number of flowers for randomized bouquet:"));
        System.out.println("Random bouquet:");
        flowerStore.printBouquet(randomBouquet);

        System.out.println("Saving random bouquet to a file...");
        FlowersSaver.save(filename, randomBouquet);
        System.out.println("Saved to " + filename);
        System.out.println();

        System.out.println("Press Enter to read bouquet from a file.\n" +
                "(At this point something may happen to the file)");
        methods.readEmptyLine();

        System.out.println("Reading a bouquet from " + filename + "...");
        Flower[] restoredBouquet = FlowersLoader.load(filename);
        if (restoredBouquet != null) {
            System.out.println("Restored bouquet:");
            flowerStore.printBouquet(restoredBouquet);
        }
    }
}
