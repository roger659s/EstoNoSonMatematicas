package cat.udl.eps.ed.practica2.stack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;

public class ArrayStackTest {

    private final int FIRST_FINAL = 10;
    private final int SECOND_FINAL = 20;

    @Test
    void push_one_element_should_update_top_and_not_be_empty(){
        var stack = new ArrayStack<Integer>();
        stack.push(FIRST_FINAL);
        assertFalse(stack.isEmpty());
        assertEquals(FIRST_FINAL,stack.top());
        assertEquals(1,stack.size());
    }

    @Test
    void push_multiple_elements_elements_should_lifo_order(){
        var stack = new ArrayStack<Integer>();
        stack.push(FIRST_FINAL);
        stack.push(SECOND_FINAL);
        assertEquals(SECOND_FINAL, stack.top());
        stack.pop();
        assertEquals(FIRST_FINAL, stack.top());
        stack.pop();
        assertTrue(stack.isEmpty());

    }

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
    void isEmpty_on_onePlace_stack_should_throw_false() {
        var stack = new ArrayStack<Integer>();
        stack.push(FIRST_FINAL);
        assertFalse(stack.isEmpty());
    }

    @Test
    void isEmpty_on_twoPlace_stack_should_throw_false() {
        var stack = new ArrayStack<Integer>();
        stack.push(FIRST_FINAL);
        stack.push(FIRST_FINAL);
        assertFalse(stack.isEmpty());
    }

    @Test
    void pop_on_onePlace_stack_should_be_empty(){
        var stack = new ArrayStack<Integer>();
        stack.push(FIRST_FINAL);
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void top_on_onePlace_stack_should_not_be_empty(){
        var stack = new ArrayStack<Integer>();
        stack.push(FIRST_FINAL);
        stack.top();
        assertFalse(stack.isEmpty());
    }

    @Test
    void top_on_twoPlace_stack_should_not_be_empty_and_returns_the_second(){
        var stack = new ArrayStack<Integer>();
        stack.push(FIRST_FINAL);
        stack.push(SECOND_FINAL);
        assertEquals(SECOND_FINAL, stack.top());
        assertFalse(stack.isEmpty());
    }

    @Test
    void top_on_twoPlace_stack_returns_second_then_pop_then_top_returns_the_first(){
        var stack = new ArrayStack<Integer>();
        stack.push(FIRST_FINAL);
        stack.push(SECOND_FINAL);
        assertEquals(SECOND_FINAL, stack.top());
        stack.pop();
        assertEquals(FIRST_FINAL, stack.top());
    }

    @Test
    void push_many_elements_should_resize_array_and_maintain_lifo() {
        var stack = new ArrayStack<Integer>();
        for (int i = 0; i < SECOND_FINAL; i++) {
            stack.push(i);
        }
        assertFalse(stack.isEmpty());
        assertEquals(SECOND_FINAL-1, stack.top());
        int count = SECOND_FINAL;
        for (int i = count - 1; i >= 0; i--) {
            assertEquals(i, stack.top());
            stack.pop();
        }

        assertTrue(stack.isEmpty());
    }
}

