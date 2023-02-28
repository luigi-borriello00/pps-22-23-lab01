package lab01.tdd.iterators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CircularListWithIteratorImplTest {

    CircularListWithIterator list;

    @BeforeEach
    void beforeEach(){
        this.list = new CircularListWithIteratorImpl();
    }

    @Test
    void testElementIsAdd(){
        this.list.add(0);
        Iterator<Integer> iter = this.list.forwardIterator();
        assertTrue(iter.hasNext());
    }

    @Test
    void testMultipleElementsAreAdded(){
        this.list.add(0);
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);
        Iterator<Integer> iter = this.list.forwardIterator();
        for(int i = 0; i < 78; i++){
            assertTrue(iter.hasNext());
            Integer next = iter.next();
        }
    }


    @Test
    void forwardIterator() {
    }

    @Test
    void backwardIterator() {
    }
}