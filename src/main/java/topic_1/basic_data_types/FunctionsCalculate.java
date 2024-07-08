package topic_1.basic_data_types;

// $ git log --graph --all --decorate --oneline -> граф ластовых коммитов

public class FunctionsCalculate {
    protected static double a = 1;
    protected static double b = 1;

    public static double firstFunction(double x) {
        return x <= 3 ? b + 2 * Math.log(Math.abs(x)) : (x * x) / ((x * x) + a);
    }

    public static double secondFunction(double x) {
        return x > 0 ? a + 0.5 * Math.exp(-x) : Math.cos(b * x + 1);
    }

    public static double thirdFunction(double x) {
        return x <= 1 ? 1 / (a * a + x * x) : b * Math.log(Math.abs(x));
    }

    public static double fourthFunction(double x) {
        return x <= 2 ? (a + x * x) / (b + Math.log(Math.abs(x) + 1)) : Math.exp(x) + x * x;
    }

    public static double fifthFunction(double x) {
        return x <= 1 ? a * Math.pow(Math.sin(x), 2) + Math.sqrt(x) : b * Math.exp(x * x);
    }

    public static double sixthFunction(double x) {
        return x <= -1 ? a * Math.tan(x * x) : b + x * x / (x * x + a);
    }

    public static double seventhFunction(double x) {
        return x > 3 ? (a + x) * Math.atan(x * a) : Math.pow(Math.cos(b + x * x * x), 2);
    }

    public static double eighthFunction(double x) {
        return x < 5 ? Math.pow(Math.sin(a + x), 3) : Math.log(Math.sqrt(Math.abs(b - x)));
    }

    public static double ninthFunction(double x) {
        return x >= 2 ? Math.sqrt(1 + x * Math.sqrt(a * x)) : a * Math.sin(b * x) + 3;
    }

    public static void main(String[] args) {
        double x = 5;
        System.out.println(firstFunction(x));
        System.out.println(secondFunction(x));
        System.out.println(thirdFunction(x));
        System.out.println(fourthFunction(x));
        System.out.println(fifthFunction(x));
        System.out.println(sixthFunction(x));
        System.out.println(seventhFunction(x));
        System.out.println(eighthFunction(x));
    }
}
