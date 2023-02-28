package lab01.tdd.iterators;

import java.util.*;
import java.util.stream.Stream;

public class CircularListWithIteratorImpl implements CircularListWithIterator {


    private final List<Integer> list = new ArrayList<>();

    @Override
    public void add(Integer element) {
        this.list.add(element);
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return this.list.isEmpty() ?
                Collections.emptyIterator() :
                Stream.generate(() -> this.list)
                        .flatMap(List::stream)
                        .iterator();
    }

    @Override
    public Iterator<Integer> backwardIterator() {

        List<Integer> copyList = new ArrayList<>(this.list);
        Collections.reverse(copyList);

        return copyList.isEmpty() ?
                Collections.emptyIterator() :
                Stream.generate(() -> copyList)
                        .flatMap(List::stream)
                        .iterator();
    }
}
