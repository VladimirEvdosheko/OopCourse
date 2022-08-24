package academits.evdoshenko.main;

import academits.evdoshenko.list.ListItem;
import academits.evdoshenko.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(1);

        for (int i = 1; i < 10; i++) {
            list.add(new ListItem<>(i));
        }

        System.out.println(list);

        System.out.println("Size of the list is: " + list.getCount());
        System.out.println("First element is: " + list.getHeadData());
        System.out.println("First element got by searching by index: " + list.getData(0));

        list.setData(0, 1);
        System.out.println("First element got by searching by index after changing: " + list.getData(0));

        list.removeItem(0);
        System.out.println("First element got by searching by index after deleting: " + list.getData(0));

        list.add(new ListItem<>(1), 2);
        System.out.println("Third element got by searching by index after adding: " + list.getData(2));

        list.removeByValue(5);

        System.out.println("SinglyLinkedList after deleting by value 5:");
        System.out.println(list);

        list.removeHead();

        System.out.println("SinglyLinkedList after head deleting:");
        System.out.println(list);

        SinglyLinkedList<Integer> copy = list.getCopy();

        System.out.println("Copy result of list:");
        System.out.println(copy);

        System.out.println("Work result of method \"equals\"");
        System.out.println(list.equals(copy));

        list.reverse();

        System.out.println("SinglyLinkedList after reversing:");
        System.out.println(list);
    }
}