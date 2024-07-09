package topic_3.java_collections;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorExamples {
    public static void main(String[] args) {
        iteratorExample();
    }

    public static void iteratorExample() {
        ArrayList<String> list = CollectionsFrameworkExamples.generateArrayList(String.class);
        System.out.println(list);

        System.out.println("-->");
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(STR." \{listIterator.next()}");
        }

        System.out.println("\n<--");
        while (listIterator.hasPrevious()) {
            System.out.print(STR." \{listIterator.previous()}");
        }
    }
}
