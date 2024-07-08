package topic_1.java_operators;

import java.util.ArrayList;
import java.util.List;

public class CalculateFunctionalSeries {
    protected static final double INFINITY = 1e5;
    protected static final double EPSILON = 1 / INFINITY;
    protected static List<Long> factorials = new ArrayList<>(List.of(1L));

    public static void main(String[] args) {
        int number = 1;
        double x = 1;
        calculate(number, x);
    }

    public static void calculate(int number, double x) {
        switch (number) {
            case 1 -> System.out.println(firstFunctionalSeries(x));
            case 2 -> System.out.println(secondFunctionalSeries(x));
            default -> System.out.println(STR."Unexpected value: \{number}");
        };
    }

    public static long getFactorial(int number) {
        if (number >= factorials.size()) {
            factorials.add(factorials.get(number - 1) * number);
        }
        return factorials.get(number);
    }

    public static double firstFunctionalSeries(double x) {
        double sum = 0, new_sum = sum;
        do {
            sum = new_sum;
            int i = 1;
            long factorial = getFactorial(i++);
            new_sum += Math.pow(-1, i) * 2 * i * Math.pow(x, 2 * i + 1) / factorial;
        } while (Math.abs(new_sum - sum) >= EPSILON);
        return new_sum;
    }

    public static double secondFunctionalSeries(double x) {
        double sum = 0, new_sum = sum;
        do {
            sum = new_sum;
            int i = 1;
            sum += Math.pow(x, 2 * i + 1) / 2 * i + 1;
        } while (Math.abs(new_sum - sum) >= EPSILON);
        return x > -1 & x < 1 ? new_sum : Double.NaN;
    }
}
