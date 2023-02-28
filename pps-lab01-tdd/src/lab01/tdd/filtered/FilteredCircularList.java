package lab01.tdd.filtered;

import java.util.Optional;
import java.util.function.Predicate;

public interface FilteredCircularList {
    /**
     * Add an element to the list
     * @param i
     */
    void add(int i);


    /**
     * Finds and returns the next element that satisfies a given condition
     * @param evenPredicate
     * @return
     */
    Optional<Integer> filteredNext(Predicate<Integer> predicate);
}
