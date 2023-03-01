package lab01.tdd.iterators;

import java.util.Iterator;
import java.util.Optional;

public interface CircularListWithIterator {

    /**
     * Adds an element to the list, namely, after the last inserted one.
     * @param element the element to be added to the list
     */
    void add(Integer element);

    /**
     * @return a new java.util.Iterator, which yields next elements, circularly
     */
    Iterator<Integer> forwardIterator();

    /**
     *
     * @return a new java.util.Iterator, which yields previous elements, circularly
     */
    Iterator<Integer> backwardIterator();


}
