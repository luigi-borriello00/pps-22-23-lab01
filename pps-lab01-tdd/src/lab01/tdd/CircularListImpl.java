package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList{
    private List<Integer> list = new ArrayList<>();

    private final int FIRST_ELEMENT_INDEX = 0;
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
        if (index == this.list.size()){
            this.index = 0;
        }
        if(this.index <= this.list.size() - 1){
            Optional<Integer> next =  Optional.of(this.list.get(index++));

            return next;

        }
        else{
            index = FIRST_ELEMENT_INDEX;
            return Optional.of(this.list.get(index));
        }
    }

    @Override
    public Optional<Integer> previous() {
        if(this.index==this.list.size()){
            this.index--;
        }
        if(this.index > 0){
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
