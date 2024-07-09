package topic_3.java_collections;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

import org.jeasy.random.EasyRandom;
import topic_3.java_collections.compare_examples.Person;

public class CollectionsFrameworkExamples {
    public static void main(String[] args) {
        treeSetExample();
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

    public static void treeSetExample() {
        TreeSet<Person> people = generateTreeSet(Person.class);
        System.out.println(people);
    }

    public static<T extends Comparable<T>> TreeSet<T> generateTreeSet(Class<T> tClass) {
        Random random = new Random();
        int size = random.nextInt(10);

        TreeSet<T> treeSet = new TreeSet<>();

        EasyRandom generator = new EasyRandom();

        for (int i = 0; i < size; i++) {
            treeSet.add(generator.nextObject(tClass));
        }

        return treeSet;
    }
}
