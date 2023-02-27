package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList{
    private List<Integer> list = new ArrayList<>();
    private int index = 0;
    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.size() == 0;
    }

    @Override
    public Optional<Integer> next() {
        if(this.index < this.list.size() - 1){
            return Optional.of(this.list.get(index++));
        }
        else{
            return Optional.empty();
        }
    }

    @Override
    public Optional<Integer> previous() {
        return Optional.empty();
    }

    @Override
    public void reset() {

    }
}
