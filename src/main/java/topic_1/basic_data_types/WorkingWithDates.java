package topic_1.basic_data_types;

import java.util.Calendar;
import java.util.Date;

public class WorkingWithDates {

    public static void main(String[] args) {
        calendarExample();
        dateExample();
        sqlDateExample();
        sqlTimeExample();
        sqlTimestampExample();
    }

    public static void calendarExample() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(STR."* calendar example \{calendar}");
    }

    public static void dateExample() {
        Date date = new Date();
        System.out.println(STR."* date example \{date}");
    }

    public static void sqlDateExample() {
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        System.out.println(STR."* sql date example \{date}");
    }

    public static void sqlTimeExample() {
        java.sql.Time time = new java.sql.Time(System.currentTimeMillis());
        System.out.println(STR."* sql time example \{time}");
    }

    public static void sqlTimestampExample() {
        java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
        System.out.println(STR."* sql timestamp example \{timestamp}");
    }

}
