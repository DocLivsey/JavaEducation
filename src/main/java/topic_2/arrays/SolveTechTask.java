package topic_2.arrays;

import java.util.Arrays;
import java.util.Random;

public class SolveTechTask {
    protected static Random random = new Random();
    protected static final int A_LENGTH = random.nextInt();
    protected static final int B_LENGTH = random.nextInt();
    protected static final int C_LENGTH = random.nextInt();

    public static void main(String[] args) {

    }

    public static int[] generateArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    public static class First {
        /* Вариант 1.
         * Написать программу, находящую минимальный элемент целочисленного массива A размера N.
         * С помощью этой программы найти минимальные элементы массивов A, B, C размера NA, NB, NC соответственно.
         */
        public static void Examples() {
            int[] A = generateArray(A_LENGTH);
            int[] B = generateArray(B_LENGTH);
            int[] C = generateArray(C_LENGTH);

            System.out.println(STR."min of array A \{getMinFromArray(A)}");
            System.out.println(STR."min of array B \{getMinFromArray(B)}");
            System.out.println(STR."min of array C \{getMinFromArray(C)}");
        }

        public static int getMinFromArray(int[] array) {
            int[] arrayCopy = Arrays.copyOf(array, array.length);
            Arrays.sort(arrayCopy);
            return arrayCopy[0];
        }
    }

    public static class Second {

    }
}
