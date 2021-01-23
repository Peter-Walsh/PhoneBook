package algorithms.sorting;

import algorithms.SortingAlg;

import java.util.List;
import java.util.ArrayList;

public class BubbleSort<T extends Comparable<T>> implements SortingAlg<T> {

    private List<T> list;

    public BubbleSort(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return this.list;
    }

    @Override
    public void sort() {
        for (int i = 0; i < list.size(); i++) {

            for (int j = 0; j < list.size() - 1; j++) {
                T first = list.get(j);
                T second = list.get(j+1);
                if (first.compareTo(second) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}
