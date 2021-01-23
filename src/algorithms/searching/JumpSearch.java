package algorithms.searching;
import algorithms.SearchingAlg;

import java.util.ArrayList;
import java.util.List;

public class JumpSearch<T extends Comparable<? super T>> implements SearchingAlg<T> {

    private List<T> list;

    public JumpSearch(List<T> list) {
        this.list = list;
    }

    @Override
    public T search(T element) {
        if (list == null) {
            return null;
        } else if (list.size() == 0) {
            return null;
        }
        return jumpSearch(element);
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

    private T jumpSearch(T element) {
        int count = 0;
        int block = (int)Math.sqrt(list.size());
        int upper = block - 1;
        int lower = 0;

        // check first element
        if (element.equals(list.get(lower))) {
            return list.get(lower);
        }

        // we move up block by block in list
        while (element.compareTo(list.get(upper)) > 0) {
            lower = upper;
            upper += block;
        }

        // backtrack through the block looking for element
        for (int j = upper; j > lower; j--) {
            if (list.get(j).equals(element)) {
                return list.get(j);
            }
        }
        return null;
    }
}
