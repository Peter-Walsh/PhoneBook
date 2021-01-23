package hashtables;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class ChainedHashTable<T> implements HashTable<T> {

    private int size;
    private int capacity;
    private List<LinkedList<T>> list;

    public ChainedHashTable(int capacity) {
        this(capacity, null);
    }

    public ChainedHashTable(List<T> elements) {
        this(elements.size() / 2, elements);
    }

    public ChainedHashTable(int capacity, List<T> elements) {
        this.size = 0;
        this.capacity = getPrime(capacity);
        this.list = new ArrayList<>(this.capacity);
        for (int i = 0; i < this.capacity; i++) this.list.add(new LinkedList<>());
        if (elements != null) {
            for (T element : elements) add(element);
        }
    }

    @Override
    public void add(T element) {
        int idx = hash(element);
        if (list.get(idx) == null) {
            list.set(idx, new LinkedList<>());
        }
        list.get(idx).add(element);
        this.size++;
    }

    @Override
    public boolean contains(T element) {
        int idx = hash(element);
        if (list.get(idx) == null) {
            return false;
        }
        return list.get(idx).contains(element);
    }

    @Override
    public boolean remove(T element) {
        int idx = hash(element);
        if (list.get(idx) == null) {
            return false;
        }
        return list.get(idx).remove(element);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (LinkedList<T> lst : this.list) {
            result.append(listAsString(lst));
            result.append("\n");
        }
        return result.toString();
    }

    private String listAsString(List<T> lst) {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (T item : lst) {
            result.append(item);
            result.append(" ");
        }
        return result.toString().trim() + "]";
    }

    private int hash(T value) {
        return Math.abs(value.hashCode() % capacity);
    }

    private int getPrime(int capacity) {
        int prime = capacity;
        while (!isPrime(prime)) {
            prime++;
        }
        return prime;
    }

    private boolean isPrime(int number) {
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
