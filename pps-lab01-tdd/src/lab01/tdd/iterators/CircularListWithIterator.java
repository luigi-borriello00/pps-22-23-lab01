package lab01.tdd.iterators;

import java.util.Iterator;
import java.util.Optional;

public interface CircularListWithIterator {

    void add(Integer element);

    Iterator<Integer> forwardIterator();

    Iterator<Integer> backwardIterator();


}
