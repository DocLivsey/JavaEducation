package topic_1.basic_data_types;

import java.math.BigDecimal;

public class JavaNumbers {

    public static void main(String[] args) {
        BigDecimal number = new BigDecimal("19e190");
        BigDecimal miniNumber = new BigDecimal("1224235e-18");
        System.out.println(STR."\{number}\{miniNumber}");
    }

}
