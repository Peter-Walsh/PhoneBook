package algorithms.sorting;

import algorithms.SortingAlg;
import java.util.List;
import java.util.ArrayList;

public class QuickSort<T extends Comparable<T>> implements SortingAlg<T> {

    private List<T> list;

    public QuickSort(List<T> list) {
        this.list = list;
    }

    @Override
    public void sort() {
        if (list != null) {
            quickSort(0, list.size() - 1);
        }
    }

    public List<T> getList() {
        return this.list;
    }

    private void quickSort(int left, int right) {
        if (left < right) {
            int pivotIndex = partition(left, right);
            quickSort(left, pivotIndex - 1);
            quickSort(pivotIndex + 1, right);
        }
    }

    private int partition(int left, int right) {
        T pivot = list.get(right);
        int partitionIndex = left;
        for (int i = left; i < right; i++) {
            if (pivot.compareTo(list.get(i)) > 0) {
                SortingAlg.swap(list, i, partitionIndex);
                partitionIndex++;
            }
        }
        SortingAlg.swap(list, partitionIndex, right);
        return partitionIndex;
    }
}
