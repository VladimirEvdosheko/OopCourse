package academits.evdoshenko.main;

import academits.evdoshenko.hashTable.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> integersArrayList1 = new ArrayList<>(100);
        ArrayList<Integer> integersArrayList2 = new ArrayList<>(Arrays.asList(10, 25));

        for (int i = 1; i <= 100; i++) {
            integersArrayList1.add(i);
        }

        HashTable<Integer> hashTable = new HashTable<>(100);

        hashTable.addAll(integersArrayList1);

        Iterator<Integer> iterator = hashTable.iterator();

        // Если исправлять этот warning, то программа падает
        //noinspection WhileLoopReplaceableByForEach
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Object[] numbers = hashTable.toArray();

        System.out.println();
        System.out.println("Result of method \"toArray\":");
        System.out.println(Arrays.toString(numbers));

        System.out.println();
        System.out.println("Is myHashTable contains 100?");
        System.out.println(hashTable.contains(100));


        hashTable.retainAll(integersArrayList2);

        System.out.println();
        System.out.println("Is myHashTable contains 10 or 25?");
        System.out.println(hashTable.contains(10) || hashTable.contains(25));

        hashTable.removeAll(integersArrayList1);

        System.out.println();
        System.out.println("Is hashTable empty?");
        System.out.println(hashTable.isEmpty());
    }
}