package topic_3.java_collections;

import java.util.ArrayList;
import java.util.Random;

import org.jeasy.random.EasyRandom;

public class CollectionsFrameworkExamples {
    public static void main(String[] args) {
        ArrayList<String> list = generateArrayList(String.class);
        System.out.println(list);
    }

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

    public static<T> ArrayList<T> generateArrayList(Class<T> tClass) {
        Random random = new Random();
        int size = random.nextInt(10);

        ArrayList<T> list = new ArrayList<>(size);

        EasyRandom generator = new EasyRandom();

        for (int i = 0; i < size; i++) {
            list.add(generator.nextObject(tClass));
        }

        return list;
    }
}
