package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList{
    private final List<Integer> list = new ArrayList<>();

    private int pointer = 0;
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
        return this.isEmpty() ? Optional.empty() : Optional.of(this.list.get((pointer++) % this.list.size() ));
  }

    @Override
    public Optional<Integer> previous() {
        if(this.pointer >= this.list.size()){
            this.pointer = this.list.size() - 1;
        }

        int FIRST_ELEMENT_INDEX = 0;
        if(this.pointer > FIRST_ELEMENT_INDEX){
            return Optional.of(this.list.get(--pointer));
        }
        else{
            pointer = this.list.size() - 1;
            return Optional.of(this.list.get(pointer));
        }
    }

    @Override
    public void reset() {
        this.pointer = 0;
    }
}
