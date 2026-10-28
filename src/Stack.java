package cat.udl.eps.ed.practica2.stack;

public interface Stack<E> {
    void push(E elem);
    E top();
    void pop();
    boolean isEmpty();
}