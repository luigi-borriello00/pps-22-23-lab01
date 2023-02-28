package lab01.tdd.filtered;

import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class FilteredCircularListImpl implements FilteredCircularList {

    CircularList list = new CircularListImpl();

    @Override
    public void add(int i) {
        this.list.add(i);
    }

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> predicate) {
        Optional<Integer> next;
        do {
            next = this.list.next();
            if(next.isPresent()){
                System.out.println(next + "" + predicate.test(next.get()));
            }
            else{
                break;
            }
          } while (!predicate.test(next.get()));
        return next;
    }
}
