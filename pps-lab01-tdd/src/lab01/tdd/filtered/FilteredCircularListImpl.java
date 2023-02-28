package lab01.tdd.filtered;

import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FilteredCircularListImpl implements FilteredCircularList {

    private CircularList list = new CircularListImpl();
    private Set<Integer> elementsOfTheList = new HashSet<>();

    @Override
    public void add(int i) {
        this.list.add(i);
        this.elementsOfTheList.add(i);
    }

    private Boolean checkPredicate(Predicate<Integer> predicate){
        return this.elementsOfTheList.stream()
                .anyMatch(predicate);
    }

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> predicate) {
        return this.checkPredicate(predicate) ?
                Optional.empty() :
                Stream.generate(list::next)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .filter(predicate)
                        .findFirst();
    }
}
