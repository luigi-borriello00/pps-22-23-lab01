package lab01.tdd.iterators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CircularListWithIteratorImplTest {

    public static final int N_OF_ITERACTIONS = 100;
    CircularListWithIterator list;

    @BeforeEach
    void beforeEach(){
        this.list = new CircularListWithIteratorImpl();
    }

    @Test
    void testIsInitiallyEmpty(){
        assertFalse(this.list.forwardIterator().hasNext());
    }


    @Test
    void testElementIsAdd(){
        this.list.add(0);
        Iterator<Integer> iter = this.list.forwardIterator();
        assertTrue(iter.hasNext());
    }

    private void fillTheList(int n_elements){
        for(int i = 0; i < n_elements; i++){
            this.list.add(i);
        }
    }

    @Test
    void testForwardWithMultipleElements(){
        int nElements = 3;
        this.fillTheList(3);
        Iterator<Integer> iter = this.list.forwardIterator();
        for(int i = 0; i <
                N_OF_ITERACTIONS; i++){
            assertTrue(iter.hasNext());
            Integer next = iter.next();
        }
    }

    @Test
    void testMultipleForwardIterator(){
        int nElements = 4;
        this.fillTheList(nElements);
        for(int i = 0; i < N_OF_ITERACTIONS; i++){
            Iterator<Integer> iter = this.list.forwardIterator();
            assertTrue(iter.hasNext());
            assertEquals(i % nElements, iter.next());
        }
    }

    @Test
    void testBackWardIterator(){
        int nElements = 5;
        this.fillTheList(nElements);
        Iterator<Integer> iter = this.list.backwardIterator();
        assertTrue(iter.hasNext());

    }

    @Test
    void forwardIterator() {
    }

    @Test
    void backwardIterator() {
    }
}