import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList list;

    private void fillTheList(int nElements){
        final int ELEMENT_VALUE = 10;
        for(int i = 0; i < nElements; i++){
            this.list.add(ELEMENT_VALUE - i);
        }
    }

    @BeforeEach
    void beforeEach(){
        this.list = new CircularListImpl();
    }

    @Test
    void testIsInitiallyEmpty(){
        assertTrue(this.list.isEmpty());
    }

    @Test
    void testElementCanBeAdded(){
        final int ELEMENT_VALUE = 10;
        final int EXPECTED_LIST_SIZE = 1;
        this.list.add(ELEMENT_VALUE);
        assertEquals(EXPECTED_LIST_SIZE, this.list.size());
    }

    @Test
    void testNextMethod(){
        fillTheList(1);
        assertTrue(this.list.next().isPresent());
    }

    @Test
    void testNextMethodOnTheCorner(){
        final int N_ELEMENTS = 5;
        final int EXPECTED_VALUE = 10;
        fillTheList(N_ELEMENTS);
        for(int i = 0; i < N_ELEMENTS; i++){
            this.list.next();
        }
        Optional<Integer> next = this.list.next();
        next.ifPresent(integer -> assertEquals(EXPECTED_VALUE, integer));
    }

    @Test
    void testPrevMethod(){
        final int N_ELEMENTS = 1;
        fillTheList(N_ELEMENTS);
        Optional<Integer> previous = this.list.previous();
        assertTrue(previous.isPresent());
        assertEquals(10, previous.get());
    }

    @Test
    void testPrevMethodMultipleTimes(){
        
    }





}
