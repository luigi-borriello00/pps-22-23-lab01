package lab01.tdd.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class CircularListWithIteratorImpl implements CircularListWithIterator{


    private List<Integer> list = new ArrayList<>();
    private int pointer = 0;


    @Override
    public void add(Integer element) {
        this.list.add(element);
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return pointer < list.size();
            }

            @Override
            public Integer next() {
                Integer nextElem = list.get(pointer);
                pointer = (pointer + 1) % list.size();
                return nextElem;
            }
        };
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return list.size() > 0;
            }

            @Override
            public Integer next() {
                pointer = pointer < 0 ? list.size() - 1 : pointer - 1;
                return list.get(pointer);
            }
        };
    }
}
