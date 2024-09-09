package topic_1.basic_data_types;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class WorkingWithDates {

    public static void main(String[] args) {
        if (args.length < 2) {
            var arg = args[0].toLowerCase();
            switch (arg) {
                case "date_examples" -> {
                    calendarExample();
                    dateExample();
                    sqlDateExample();
                    sqlTimeExample();
                    sqlTimestampExample();
                }
                case "mapping_date_examples" -> {
                    calendarToDateExample();
                    calendarToTimestampExample();
                    calendarToStringExample();
                }
                case "none" -> System.out.println("None was done");
                default -> System.out.println(STR."Unknown argument \{arg}");
            }
        }
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

    public static void calendarToDateExample() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(STR."calendar as date \{calendar}\n" +
                STR."class of calendar = \{calendar.getClass()}\n" +
                STR."class of date = \{calendar.getTime().getClass()}\n"
        );
    }

    public static void calendarToTimestampExample() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(STR."calendar as timestamp \{calendar.getTime()}\n");
    }

    public static void calendarToStringExample() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timestampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(
                STR."calendar as string date = \{dateFormat.format(calendar.getTime())}\n" +
                STR."Calendar as string timestamp = \{timestampFormat.format(calendar.getTime())}\n"
        );
    }

}
