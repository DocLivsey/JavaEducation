package topic_2.arrays;

import java.util.Arrays;
import java.util.Random;

public class SolveTechTask {
    protected static Random random = new Random();
    protected static final int MIN_ORIGIN = -100;
    protected static final int MAX_BOUND = 100;
    protected static final int A_LENGTH = random.nextInt(MAX_BOUND);
    protected static final int B_LENGTH = random.nextInt(MAX_BOUND);
    protected static final int C_LENGTH = random.nextInt(MAX_BOUND);

    public static void main(String[] args) {
        int[] A = generateArray(A_LENGTH);
        int[] B = generateArray(B_LENGTH);
        int[] C = generateArray(C_LENGTH);
        System.out.println(STR."array A: \{Arrays.toString(A)}");
        System.out.println(STR."array B: \{Arrays.toString(B)}");
        System.out.println(STR."array C: \{Arrays.toString(C)}");

        First.Examples(A, B, C);
        Second.Examples(A, B, C);
    }

    public static int[] generateArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(MIN_ORIGIN, MAX_BOUND);
        }
        return array;
    }

    public static class First {
        /* Вариант 1.
         * Написать программу, находящую минимальный элемент целочисленного массива A размера N.
         * С помощью этой программы найти минимальные элементы массивов A, B, C размера NA, NB, NC соответственно.
         * */
        public static void Examples(int[] A, int[] B, int[] C) {
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
        /* Вариант 4.
        * Написать программу, меняющую порядок следования элементов вещественного массива A размера N на противоположный
        * (инвертирование массива). Массив A является входным и выходным параметром.
        * С помощью этой программы инвертировать массивы A, B, C размера NA, NB, NC соответственно.
        * */
        public static void Examples(int[] A, int[] B, int[] C) {
            System.out.println(STR."Inverted array A: \{Arrays.toString(invertedArray(A))}");
            System.out.println(STR."Inverted array B: \{Arrays.toString(invertedArray(B))}");
            System.out.println(STR."Inverted array C: \{Arrays.toString(invertedArray(C))}");
        }

        public static int[] invertedArray(int[] array) {
            int[] arrayCopy = Arrays.copyOf(array, array.length);
            int length = array.length;
            for (int i = 0; i < length / 2; i++) {
                int temp = arrayCopy[i];
                arrayCopy[i] = arrayCopy[length - i - 1];
                arrayCopy[length - i - 1] = temp;
            }
            return arrayCopy;
        }
    }
}
