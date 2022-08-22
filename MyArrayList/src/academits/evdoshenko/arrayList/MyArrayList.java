package academits.evdoshenko.arrayList;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private int capacity;
    private T[] items;
    private int modCount = 0;

    public MyArrayList(int capacity) {
        //noinspection unchecked
        items = (T[]) new Object[capacity];
        this.capacity = 0;
    }

    public MyArrayList(T[] array) {
        capacity = array.length;
        items = Arrays.copyOf(array, capacity);
    }

    private void increaseCapacity() {
        items = Arrays.copyOf(items, items.length * 2);
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return capacity == 0;
    }

    @Override
    public boolean contains(Object object) {
        return indexOf(object) >= 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, capacity);
    }

    @Override
    public <T1> T1[] toArray(T1[] array) {
        //noinspection unchecked
        return (T1[]) Arrays.copyOf(items, capacity);
    }

    @Override
    public boolean add(T t) {
        add(capacity, t);

        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("The object is null!");
        }

        for (int i = 0; i < capacity; i++) {
            if (items[i].equals(o)) {
                remove(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null) {
            throw new IllegalArgumentException("The collection is null!");
        }

        for (Object cItem : c) {
            if (!contains(cItem)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c == null) {
            throw new IllegalArgumentException("The collection is null!");
        }

        for (T cItem : c) {
            add(cItem);
        }

        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (c == null) {
            throw new IllegalArgumentException("The collection is null!");
        }

        if (index < 0 || index > items.length) {
            throw new IllegalArgumentException("The index can't be < 0!");
        }

        for (T cItem : c) {
            add(index, cItem);
            index++;
        }

        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null) {
            throw new IllegalArgumentException("The collection is null!");
        }

        for (int i = 0; i < capacity; i++) {
            if (c.contains(items[i])) {
                remove(i);
                --i;
            }
        }

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null) {
            throw new IllegalArgumentException("This collection is null!");
        }

        boolean wasRetainedAll = false;

        for (int i = 0; i < capacity; i++) {
            if (!c.contains(items[i])) {
                remove(i);
                wasRetainedAll = true;
                i--;
            }
        }

        return wasRetainedAll;
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            items[i] = null;
        }

        capacity = 0;
    }

    @Override
    public T get(int index) {
        return items[index];
    }

    @Override
    public T set(int index, T element) {
        return items[index] = element;
    }

    @Override
    public void add(int index, T element) {
        if (index >= items.length) {
            increaseCapacity();
        }

        items[index] = element;

        ++capacity;
        ++modCount;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= capacity) {
            throw new IllegalArgumentException("The index is incorrect!");
        }

        items[index] = null;

        //noinspection unchecked
        T[] temp = (T[]) new Object[items.length - 1];

        for (int i = 0, j = 0; i < items.length; i++) {
            if (items[i] != null) {
                temp[j] = items[i];
                j++;
            }
        }

        items = Arrays.copyOf(temp, temp.length);

        modCount++;
        capacity--;

        return null;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < capacity; i++) {
            if (items[i].equals(o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = capacity - 1; i >= 0; i--) {
            if (items[i].equals(o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        //noinspection ConstantConditions
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        //noinspection ConstantConditions
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        //noinspection ConstantConditions
        return null;
    }

    private class MyListIterator implements Iterator<T> {
        private int currentIndex = -1;
        private final int modCountCurrent = modCount;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < items.length;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("There are no next elements!");
            }
            if (modCountCurrent != modCount) {
                throw new ConcurrentModificationException("There has been a list change!");
            }

            currentIndex++;

            return items[currentIndex];
        }
    }
}