package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList{
    private final List<Integer> list = new ArrayList<>();

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
        return this.list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        return this.isEmpty() ? Optional.empty() : Optional.of(this.list.get((index++) % this.list.size() ));
  }

    @Override
    public Optional<Integer> previous() {
        if(this.index >= this.list.size()){
            this.index = this.list.size() - 1;
        }

        int FIRST_ELEMENT_INDEX = 0;
        if(this.index > FIRST_ELEMENT_INDEX){
            return Optional.of(this.list.get(--index));
        }
        else{
            index = this.list.size() - 1;
            return Optional.of(this.list.get(index));
        }
    }

    @Override
    public void reset() {
        this.index = 0;
    }
}
