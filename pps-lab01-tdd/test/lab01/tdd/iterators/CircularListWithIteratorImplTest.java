package lab01.tdd.iterators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

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
    void testIfAreTheIteratorsIndependent(){
        int nElements = 4;
        this.fillTheList(nElements);
        for(int i = 0; i < N_OF_ITERACTIONS; i++){
            Iterator<Integer> iter = this.list.forwardIterator();
            assertTrue(iter.hasNext());
            assertEquals(0, iter.next());
        }
    }

    @Test
    void testBackWardIterator(){
        int nElements = 5;
        this.fillTheList(nElements);
        Iterator<Integer> iter = this.list.backwardIterator();
        assertTrue(iter.hasNext());
        assertEquals(nElements - 1, iter.next());

    }

    @Test
    void testBothIteratorNext(){
        int nElements = 40;
        this.fillTheList(nElements);
        Iterator<Integer> forward = this.list.forwardIterator();
        Iterator<Integer> backward = this.list.backwardIterator();
        for(int i = 0; i < nElements * 5; i++){
            assertTrue(forward.hasNext());
            assertEquals(i % nElements, forward.next());
        }
        for(int i = 0; i < nElements; i++){
            assertTrue(backward.hasNext());
            assertEquals(nElements - (i+1), backward.next());
        }
    }
}