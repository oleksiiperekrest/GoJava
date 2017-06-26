/**
 * Created by simuran on 09.6.2017.
 */
public class SortingTesting extends IntArrays {
    public static void main(String[] args) {
        int n = 10000, max = 1000;


        int [] m = new int[n];
        long startTime, finishTime;

        m = randomizeIntArray(m, max);
        printArray(m);

        int[] sortedArray;

        //Warming up???
        sortedArray = sortBubble(randomizeIntArray(m.clone(), max));
        sortedArray = sortSelection(randomizeIntArray(m.clone(), max));
        sortedArray = sortBubble(randomizeIntArray(m.clone(), max));
        //Warming complete...




        startTime = System.currentTimeMillis();
        sortedArray = sortSelection(m);
        finishTime = System.currentTimeMillis();
        System.out.print("Selection sort. ");
        System.out.println("Time elapsed :" + (finishTime - startTime));
        printArray(sortedArray);

        printArray(m);

        startTime = System.currentTimeMillis();
        sortedArray = sortBubble(m);
        finishTime = System.currentTimeMillis();
        System.out.print("Bubble sort. ");
        System.out.println("Time elapsed :" + (finishTime - startTime));
        printArray(sortedArray);

    }
}
