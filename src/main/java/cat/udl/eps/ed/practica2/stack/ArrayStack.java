package cat.udl.eps.ed.practica2.stack;

import java.util.NoSuchElementException;

public class ArrayStack<E> implements Stack<E> {
    // ¿?
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] array;

    public ArrayStack(){
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public E top() {
        if (isEmpty()){throw new NoSuchElementException("Empty Stack");}
        return (E) array[size-1];
    }

    @Override
    public void pop() {
        if (isEmpty()){throw new NoSuchElementException("Empty Stack");}
        array[size - 1] = null;
        size--;
    }

    @Override
    public void push(E elem) {
        ensureCapacity();
        array[size] = elem;
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int size(){
        return size;
    }

    private void ensureCapacity(){
        if (size < array.length)return;

        Object[] newArray = new Object[array.length * 2];
        for(int i = 0;i < size;i++){
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
