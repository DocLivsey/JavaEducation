package topic_2.java_object_oriented_programming;

import java.time.Year;

public class ObjectOrientedProgrammingTraining {
    public static void main(String[] args) {
        int year = Year.now().getValue();
        System.out.println(year);
        System.out.println(year > 2024);
    }

}
