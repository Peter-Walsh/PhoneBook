package algorithms.searching;
import algorithms.SearchingAlg;

import java.util.List;

public class LinearSearch<T extends Comparable<? super T>> implements SearchingAlg<T> {

    private List<T> list;

    public LinearSearch(List<T> list) {
        this.list = list;
    }

    @Override
    public T search(T element) {
        if (list == null) {
            return null;
        } else if (list.size() == 0) {
            return null;
        }
        return linearSearch(element);
    }

    @Override
    public int search(List<T> elements) {
        int count = 0;
        for (T element : elements) {
            if (search(element) != null) {
                count++;
            }
        }
        return count;
    }

    private T linearSearch(T element) {
        for (T item : list) {
            if (item.equals(element)) {
                return item;
            }
        }
        return null;
    }
}
