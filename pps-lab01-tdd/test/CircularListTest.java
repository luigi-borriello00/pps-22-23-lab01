import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private static final int VALUE_OF_THE_FIRST_ELEMENT = 0;
    private CircularList list;
    private int nOfElements;

    private void fillTheListForTheTest(int nElements){
        for(int i = 0; i < nElements; i++){
            this.list.add(i);
        }
    }

    @BeforeEach
    void beforeEach(){
        this.list = new CircularListImpl();
        this.nOfElements = 3;
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
        fillTheListForTheTest(this.nOfElements);
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
        this.fillTheListForTheTest(nOfElements);
        this.goToLastElement();
        assertEquals(Optional.of(VALUE_OF_THE_FIRST_ELEMENT), this.list.next());
    }

    @Test
    void testPrevMethod(){
        final int EXPECTED_VALUE = 1;
        fillTheListForTheTest(this.nOfElements);
        this.goToLastElement();
        assertEquals(Optional.of(EXPECTED_VALUE), this.list.previous());
    }

    /**
     * Test if the list is circular using the "previous()" method
     */
    @Test
    void testPrevMethodOnTheCorner(){
        final int LAST_ELEMENT_VALUE = 2;
        fillTheListForTheTest(this.nOfElements);
        for(int i = 0; i < this.nOfElements; i++){
            this.list.previous();
        }
        assertEquals(Optional.of(LAST_ELEMENT_VALUE), this.list.previous());
    }

    @Test
    void testMultipleCommands(){
        fillTheListForTheTest(this.nOfElements);
        this.list.next();
        this.list.next();
        this.list.next();
        this.list.next();
        this.list.previous();
        this.list.previous();
        this.list.previous();
        this.list.previous();
        this.list.previous();

        assertEquals(Optional.of(0), this.list.next());
    }

    @Test
    void testReset(){
        fillTheListForTheTest(this.nOfElements);
        this.list.next();
        this.list.next();
        this.list.next();
        this.list.next();
        this.list.previous();
        this.list.reset();
        assertEquals(Optional.of(0), this.list.next());
    }





}
