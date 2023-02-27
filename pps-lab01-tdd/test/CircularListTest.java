import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList list;

    private void fillTheList(){
        final int ELEMENT_VALUE = 10;
        for(int i = 0; i < 5; i++){
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
        fillTheList();
        assertTrue(this.list.next().isPresent());
    }



}
