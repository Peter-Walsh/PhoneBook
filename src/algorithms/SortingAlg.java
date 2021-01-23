package algorithms;
import java.util.List;

public interface SortingAlg<T extends Comparable<T>> {

    /**
     * Sorts a given list of objects. Sorting method depends on implementation
     */

    void sort();

    /**
     * Swaps elements in the provided list at the given indices
     *
     * @param list the given list
     * @param index1 index of first element
     * @param index2 index of second element
     * @param <T> type of the data in the list
     */

    static <T> void swap (List<T> list, int index1, int index2) {
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }
}
