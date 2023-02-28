package lab01.tdd.filtered;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class FilteredCircularListImplTest {
    private FilteredCircularList list;

    @BeforeEach
    void beforeEach(){
        this.list = new FilteredCircularListImpl();
    }

    private void fillTheList(){
        int nElements = 10;
        for(int i = 0; i < nElements; i++){
            this.list.add(i);
        }
    }

    @Test
    void testPredicateOnEmptyList(){
        Predicate<Integer> evenPredicate = i -> (i % 2 == 0);
        assertEquals(Optional.empty(), this.list.filteredNext(evenPredicate));
    }

    @Test
    void testCorrectPredicate(){
        this.fillTheList();
        Predicate<Integer> evenPredicate = i -> (i % 2 == 0);
        assertEquals(Optional.of(0), this.list.filteredNext(evenPredicate));
        assertEquals(Optional.of(2), this.list.filteredNext(evenPredicate));
        assertEquals(Optional.of(4), this.list.filteredNext(evenPredicate));
        assertEquals(Optional.of(6), this.list.filteredNext(evenPredicate));
        assertEquals(Optional.of(8), this.list.filteredNext(evenPredicate));
        assertEquals(Optional.of(0), this.list.filteredNext(evenPredicate));
    }

    @Test
    void testWrongPredicate(){

    }

}