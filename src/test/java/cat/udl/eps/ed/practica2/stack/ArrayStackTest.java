package cat.udl.eps.ed.practica2.stack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;

public class ArrayStackTest {
    @Test
    void pop_on_empty_stack_should_throw_nse_exception() {
        var emptyStack = new ArrayStack<Integer>();
        assertThrows(NoSuchElementException.class, () -> {
            emptyStack.pop();
        });
    }

    @Test
    void top_on_empty_stack_should_throw_nse_exception() {
        var emptyStack = new ArrayStack<Integer>();
        assertThrows(NoSuchElementException.class, () -> {
            emptyStack.top();
        });
    }

    @Test
    void isEmpty_on_empty_stack_should_throw_true() {
        var emptyStack = new ArrayStack<Integer>();
        assertTrue(emptyStack.isEmpty());
    }

    @Test
    void isEmpty_on_onePlace_stack_should_throw_true() {
        var emptyStack = new ArrayStack<Integer>();
        var prov1 = 10;
        emptyStack.push(prov1);
        assertFalse(emptyStack.isEmpty());
    }

    @Test
    void isEmpty_on_twoPlace_stack_should_throw_true() {
        var emptyStack = new ArrayStack<Integer>();
        var prov1 = 10;
        emptyStack.push(prov1);
        emptyStack.push(prov1);
        assertFalse(emptyStack.isEmpty());
    }


}
