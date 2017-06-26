/*
Найти медиану произвольного целочисленного ряда(массива, пример {4,2,6,-1,4,0,5,-34,8,23,10}).
https://ru.wikipedia.org/wiki/Медиана_(статистика)
Для сортировки, используйте сортировку выбора(постарайтесь сами реализовать данную сортировку,
ну или в википедии, есть решение =) )
 */

public class Task10 extends IntArrays{
    public static void main(String[] args) {

        int n = 7;
        int [] m = new int[n];

        m = randomizeIntArray(m,100);
        printArray(m);

        int[] sort = sortSelection(m);
        printArray(sort);

        System.out.println(findMedian(m));



    }
}
