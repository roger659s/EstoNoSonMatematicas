package cat.udl.eps.ed.practica2.stack;

import java.util.NoSuchElementException;

public class ArrayStack<E> implements Stack<E> {
    // ¿?
    private int size = 0;

    @Override
    public E top() {
        if (isEmpty()){throw new NoSuchElementException("Empty Stack");}
    }

    @Override
    public void pop() {
        if (isEmpty()){throw new NoSuchElementException("Empty Stack");}
        size--;
    }

    @Override
    public void push(E elem) {
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
