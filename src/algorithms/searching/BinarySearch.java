package algorithms.searching;

import algorithms.SearchingAlg;
import java.util.List;

public class BinarySearch<T extends Comparable<? super T>> implements SearchingAlg<T> {

    private List<T> list;

    public BinarySearch(List<T> list) {
        this.list = list;
    }

    @Override
    public T search(T element) {
        if (list == null) {
            return null;
        } else if (list.size() == 0) {
            return null;
        }
        return binarySearch(element);
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

    private T binarySearch(T elem) {
        int left = 0;
        int right = list.size();
        while (left <= right) {
            int mid = left + (right - left) / 2; // the index of the middle element

            if (list.get(mid).equals(elem)) {
                return elem;
            } else if (elem.compareTo(list.get(mid)) < 0) {
                right = mid - 1; // go to the left subarray
            } else {
                left = mid + 1;  // go the the right subarray
            }
        }
        return null;
    }
}
