package Module6;

/*
Поменять наибольший и наименьший элементы массива местами. Пример: дан массив {4, -5, 0, 6, 8}.
После замены будет выглядеть {4, 8, 0, 6, -5}.
 */

public class Task4 extends IntArrays {
    public static void main(String[] args) {

        int n = 6;
        int [] m = new int[n];

        m = randomizeIntArray(m,10);
        printArray(m);

        m = switchMinMax(m);
        printArray(m);

    }


}
