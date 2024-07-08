package topic_2.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

/* Вариант 1.
* Написать программу, находящую минимальный элемент целочисленного массива A размера N.
* С помощью этой программы найти минимальные элементы массивов A, B, C размера NA, NB, NC соответственно.
*/
public class SolveTechTask {
    public static void main(String[] args) {
        int array[] = {3, -1, 4, 18, 99, -19, 5, -10};
        System.out.println(Arrays.toString(array));
        System.out.println(getMinFromArray(array));
        System.out.println(Arrays.toString(array));
    }

    public static int getMinFromArray(int[] array) {
        Arrays.sort(array);
        return array[0];
    }
}
