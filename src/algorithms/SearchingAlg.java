package algorithms;
import java.util.List;

public interface SearchingAlg<T> {

    /**
     * Used to search for a given element in a list. Implementation is left for user
     *
     * @param element the given element
     * @return the specified element if found, otherwise returns <code>null</code>
     */

    T search(T element);

    int search(List<T> elements);

}
