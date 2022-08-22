package academits.evdoshenko.hashTable;

import java.util.*;

public class HashTable<T> implements Collection<T> {
    private final ArrayList<T>[] listsArray;
    private int capacity;
    private int modCount = 0;

    public HashTable(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Array size must be >= 0! Current value is " + capacity);
        }

        //noinspection unchecked
        listsArray = new ArrayList[capacity];
        this.capacity = 0;
    }

    private int getIndex(Object object) {
        if (object == null) {
            return 0;
        }

        return Math.abs(object.hashCode() % listsArray.length);
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
        int index = getIndex(object);

        if (listsArray[index] == null) {
            return false;
        }

        for (T t : listsArray[index]) {
            if (t.equals(object)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[capacity];

        if (capacity > 0) {
            objects = Arrays.copyOf(listsArray, capacity);
        }

        return objects;
    }

    @Override
    public <T1> T1[] toArray(T1[] array) {
        for (int i = 1; i < capacity; i++) {
            //noinspection unchecked
            array[i] = (T1) listsArray[i];
        }

        return array;
    }

    @Override
    public boolean add(T o) {
        int index = getIndex(o);

        if (listsArray[index] == null) {
            listsArray[index] = new ArrayList<>(1);
        }

        listsArray[index].add(o);

        modCount++;
        capacity++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = getIndex(o);

        if (listsArray[index] == null) {
            return false;
        }

        //noinspection unchecked
        if (listsArray[index].contains((T) o)) {
            listsArray[index].remove(o);

            modCount++;
            capacity--;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null) {
            throw new IllegalArgumentException("The collection is null!");
        }

        for (Object item : c) {
            if (!this.contains(item)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T object : c) {
            this.add(object);
        }

        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null) {
            throw new IllegalArgumentException("The collection is null!");
        }

        for (Object object : c) {
            int index = getIndex(object);

            if (listsArray[index] != null) {
                //noinspection unchecked
                while (listsArray[index].contains((T) c)) {
                    //noinspection unchecked
                    this.listsArray[index].remove((T) object);
                }
            }
        }

        modCount++;
        capacity = 0;

        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (Object object : c) {
            int index = getIndex(object);

            if (listsArray[index] != null) {
                listsArray[index].removeIf(o -> !o.equals(c));
            }
        }

        modCount++;

        return false;
    }

    @Override
    public void clear() {
        Arrays.fill(listsArray, null);
        modCount++;
    }

    private class HashTableIterator implements Iterator<T> {
        private int currentIndex = -1;
        private final int currentModCount = modCount;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < capacity;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("The collection has ended");
            }

            if (currentModCount != modCount) {
                throw new ConcurrentModificationException("The collection has been changed!");
            }

            ++currentIndex;

            //noinspection unchecked
            return (T) listsArray[currentIndex];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new HashTableIterator();
    }
}