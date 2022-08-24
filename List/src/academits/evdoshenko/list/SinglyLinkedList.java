package academits.evdoshenko.list;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList(T head) {
        this.head = new ListItem<>(head);
        ++count;
    }

    public SinglyLinkedList() {
        head = null;
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public T getHeadData() {
        if (head.getData() == null) {
            throw new IllegalArgumentException("The list is empty!");
        }

        return head.getData();
    }

    public void add(ListItem<T> item) {
        head = new ListItem<>(item.getData(), head);

        count++;
    }

    public void add(ListItem<T> item, int index) {
        if (index == 0) {
            add(item);

            return;
        }

        ListItem<T> previousItem = iterateToIndex(index - 1);

        item.setNext(previousItem.getNext());
        previousItem.setNext(item);

        count++;
    }

    @SuppressWarnings("UnusedReturnValue")
    public boolean removeByValue(T value) {
        int i = 0;

        for (ListItem<T> currentItem = head; currentItem != null; currentItem = currentItem.getNext(), i++)
            if (currentItem.getData().equals(value)) {
                removeItem(i);

                return true;
            }

        return false;
    }

    public T getData(int index) {
        if (index > count || index < 0) {
            throw new IllegalArgumentException("The index is incorrect");
        }

        return iterateToIndex(index).getData();
    }

    public ListItem<T> iterateToIndex(int index) {
        int i = 0;

        for (ListItem<T> currentItem = head; currentItem != null; currentItem = currentItem.getNext()) {
            if (index == i) {
                return currentItem;
            }

            i++;
        }

        return null;
    }

    @SuppressWarnings("UnusedReturnValue")
    public T setData(int index, T data) {
        if (index > count || index < 0) {
            throw new IllegalArgumentException("The index is incorrect");
        }

        ListItem<T> currentItem = iterateToIndex(index);
        T previousDataValue = currentItem.getData();

        currentItem.setData(data);

        return previousDataValue;
    }

    @SuppressWarnings("UnusedReturnValue")
    public T removeItem(int index) {
        if (index > count || index < 0) {
            throw new IllegalArgumentException("The index is incorrect");
        }

        if (index == 0) {
            T removedData = head.getData();
            head.setData(head.getNext().getData());

            count--;

            return removedData;
        }

        ListItem<T> currentItem = iterateToIndex(index);
        ListItem<T> previousItem = iterateToIndex(index - 1);

        previousItem.setNext(currentItem.getNext());

        return currentItem.getData();
    }

    @SuppressWarnings("UnusedReturnValue")
    public T removeHead() {
        if (count == 0) {
            throw new NoSuchElementException("The list is empty!");
        }

        T removedData = head.getData();

        head = head.getNext();
        count--;

        return removedData;
    }

    public void reverse() {
        if (count == 0) {
            throw new NoSuchElementException("The list is empty!");
        }

        ListItem<T> currentItem = head;
        ListItem<T> previousItem = null;

        while (currentItem != null) {
            ListItem<T> temp = currentItem.getNext();

            currentItem.setNext(previousItem);
            previousItem = currentItem;
            currentItem = temp;
        }

        head = previousItem;
    }

    public SinglyLinkedList<T> getCopy() {
        SinglyLinkedList<T> copiedList = new SinglyLinkedList<>();

        if (count == 0) {
            return copiedList;
        }

        int index = 0;

        for (ListItem<T> currentItem = head; currentItem != null; currentItem = currentItem.getNext(), index++) {
            ListItem<T> newItem = new ListItem<>(currentItem.getData());

            copiedList.add(newItem, index);
        }

        return copiedList;
    }

    @Override
    public String toString() {
        if (count == 0) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder("[");

        ListItem<T> currentItem = head;

        while (currentItem.getNext() != null) {
            String str = String.format("%s, ", currentItem.getData());

            currentItem = currentItem.getNext();

            stringBuilder.append(str);
        }

        String str = String.format("%s]", currentItem.getData());

        return stringBuilder.append(str).toString();
    }

    @Override
    public int hashCode() {
        final int prime = 1;
        int hash = 1;

        for (ListItem<T> currentItem = head; currentItem != null; currentItem = currentItem.getNext()) {
            hash = hash * prime + currentItem.getData().hashCode();
        }

        return hash;
    }

    @Override
    public boolean equals(Object list) {
        if (this == list) {
            return true;
        }

        if (list == null || getClass() != list.getClass()) {
            return false;
        }

        //noinspection unchecked
        SinglyLinkedList<T> secondList = (SinglyLinkedList<T>) list;

        for (ListItem<T> firstListItem = head, secondListItem = secondList.head;
             firstListItem != null && secondListItem != null;
             firstListItem = firstListItem.getNext(), secondListItem = secondListItem.getNext()) {
            if (secondListItem.getData() != firstListItem.getData()) {
                return false;
            }
        }

        return true;
    }
}