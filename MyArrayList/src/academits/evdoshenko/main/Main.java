package academits.evdoshenko.main;

import academits.evdoshenko.arrayList.MyArrayList;

import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Integer[] integerArray1 = {1, 2, 3, 4, 5};
        Integer[] integerArray2 = {1, 2, 3, 4, 6};
        Integer[] integerArray3 = {13, 1};

        MyArrayList<Integer> numbers1 = new MyArrayList<>(integerArray1);
        MyArrayList<Integer> numbers2 = new MyArrayList<>(integerArray2);
        MyArrayList<Integer> numbers3 = new MyArrayList<>(integerArray1);
        MyArrayList<Integer> numbers4 = new MyArrayList<>(integerArray2);
        MyArrayList<Integer> numbers5 = new MyArrayList<>(integerArray3);
        MyArrayList<Integer> numbers6 = new MyArrayList<>(integerArray1);
        MyArrayList<Integer> numbers7 = new MyArrayList<>(integerArray2);
        MyArrayList<Integer> numbers8 = new MyArrayList<>(5);

        Iterator<Integer> iterator = numbers2.iterator();

        System.out.println("Iterator work result:");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        numbers1.add(7);
        numbers1.add(8);
        numbers1.add(9);
        numbers1.add(10);
        numbers1.add(11);

        System.out.println();
        System.out.println("Numbers addition result:");

        for (Integer number : numbers1) {
            System.out.print(number + " ");
        }

        System.out.println();

        numbers1.remove(Integer.valueOf(7));

        System.out.println("Removing of first integer value of 7 result:");
        for (Integer number : numbers1) {
            System.out.print(number + " ");
        }

        System.out.println("Removing of all integers values of 7 result:");
        numbers1.add(5);
        numbers1.add(5);

        numbers1.remove(5);
        for (Integer number : numbers1) {
            System.out.print(number + " ");
        }

        Object[] array = numbers1.toArray();

        System.out.println();
        System.out.println(Arrays.toString(array) + " ");

        System.out.println("Numbers3 contains numbers4 result:");
        //noinspection SlowListContainsAll
        System.out.println(numbers3.containsAll(numbers4));

        System.out.println("Numbers4 contains numbers3 result:");
        //noinspection SlowListContainsAll
        System.out.println(numbers4.containsAll(numbers3));

        numbers3.addAll(numbers4);

        for (Integer number : numbers3) {
            System.out.print(number + " ");
        }

        numbers4.retainAll(numbers5);

        System.out.println();
        System.out.println("Retain result:");

        for (Integer number : numbers4) {
            System.out.print(number + " ");
        }

        numbers8.addAll(numbers1);

        System.out.println();
        System.out.println("Add all result:");

        for (Integer number : numbers8) {
            System.out.print(number + " ");
        }

        numbers7.removeAll(numbers6);

        System.out.println();
        System.out.println("Removing all result:");

        for (Integer number : numbers7) {
            System.out.print(number + " ");
        }
    }
}