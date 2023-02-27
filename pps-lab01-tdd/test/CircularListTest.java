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
    private int nOfElements;

    private void fillTheList(int nElements){
        for(int i = 0; i < nElements; i++){
            this.list.add(i);
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
        this.nOfElements = 100;
        fillTheList(this.nOfElements);
        for(int i = 0; i < this.nOfElements; i++){
            assertTrue(this.list.next().isPresent());
        }
    }

    private void goToLastElement(){
        for(int i = 0; i < this.list.size(); i++){
            this.list.next();
        }
    }
    @Test
    void testNextMethodOnTheCorner(){
        this.nOfElements = 5;
        final int FIRST_ELEMENT_VALUE = 0;
        fillTheList(this.nOfElements);
        this.goToLastElement();
        Optional<Integer> firstElem = this.list.next();
        firstElem.ifPresent(integer -> assertEquals(FIRST_ELEMENT_VALUE, integer));
    }

    @Test
    void testPrevMethod(){
        this.nOfElements = 2;
        final int EXPECTED_VALUE = 0;
        fillTheList(this.nOfElements);
        this.goToLastElement();
        Optional<Integer> previous = this.list.previous();
        assertTrue(previous.isPresent());
        assertEquals(EXPECTED_VALUE, previous.get());
    }

    /**
     * Test if the list is circular using the "previous()" method
     */
    @Test
    void testPrevMethodMultipleTimes(){
        this.nOfElements = 5;
        final int LAST_ELEMENT_VALUE = 4;
        fillTheList(this.nOfElements);
        for(int i = 0; i < this.nOfElements; i++){
            this.list.previous();
        }
        Optional<Integer> firstElementPrev = this.list.previous();
        assertTrue(firstElementPrev.isPresent());
        assertEquals(LAST_ELEMENT_VALUE, firstElementPrev.get());
    }

    @Test
    void testMultipleCommands(){
        this.nOfElements = 3;
        fillTheList(this.nOfElements);
        this.list.next();
        this.list.next();
        this.list.next();
        this.list.next();
        this.list.previous();

        assertEquals(Optional.of(1), this.list.next());
    }

    @Test
    void testReset(){
        this.nOfElements = 3;
        fillTheList(this.nOfElements);
        this.list.next();
        this.list.next();
        this.list.next();
        this.list.next();
        this.list.previous();
        this.list.reset();
        assertEquals(0, this.list.next().get());
    }





}
