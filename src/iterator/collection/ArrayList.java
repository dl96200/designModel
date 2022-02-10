package iterator.collection;

import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ArrayList<T> implements Collection<T>{
    @Getter
    private int size;
    private Object[] obs = new Object[16];
    public void add(T t){
        if(size == obs.length) {
            Object[] obsNew = new Object[obs.length+16];
            System.arraycopy(obs,0,obsNew,0,obs.length);
            obs = obsNew;
        }
        obs[size] = t;
        size ++;
    }
    public int size(){
        return this.size;
    }

    public T get(int index) {
        return (T) obs[index];
    }
    public void remove(int index) {
        if(index>=size){
            return;
        }
        obs[index] = null;
        while(size>=index+1) {
            obs[index] =obs[index+1] ;
            index ++;
        }
        size--;
    }
    class ArrayListIterator implements Iterator{
        int currentIndex = 0;
        @Override
        public Object next() {
            if(currentIndex >= size)
                return null;
            return obs[currentIndex++];
        }

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }
    }
    public Iterator iterator(){
        return new ArrayListIterator();
    }
}
