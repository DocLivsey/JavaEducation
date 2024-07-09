package topic_3.java_collections;

import java.util.ArrayList;

public class CollectionsFrameworkExamples {

    public static void arrayListExamples() {
        ArrayList<String> list = new ArrayList<>();
        list.add("John");
        list.add("Jane");
        list.add("Bob");
        list.add("Jack");

        System.out.println(list);

        list.removeFirst();
        list.removeLast();

        System.out.println(list);

        list.add("Vladimir");
        list.add("Alex");

        System.out.println(list);

        list.remove("Jane");

        System.out.println(list);
    }
}
