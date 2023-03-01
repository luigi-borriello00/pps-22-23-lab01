package lab01.tdd.filtered;

import java.util.Optional;
import java.util.function.Predicate;

public interface FilteredCircularList {

    /**
     * Adds an element to the list, namely, after the last inserted one.
     * @param element the element to be added to the list
     */
    void add(int element);


    /**
     * Finds and returns the next element that satisfies a given condition
     * @param predicate: the predicate used to filter the next elements
     * @return the Optional of the next element
     */
    Optional<Integer> filteredNext(Predicate<Integer> predicate);
}
