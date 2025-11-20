package model.adts;
import model.exception.ADTException;

import java.util.*;

public class MyStack<T> implements MyIStack<T> {
    private final Stack<T> stack;
    public MyStack() {
        this.stack = new Stack<>();
    }
    @Override
    public void push(T v){ stack.push(v); }

    @Override
    public T pop() throws ADTException {
        if (stack.isEmpty())
            throw new ADTException("Pop from empty stack");
        return stack.pop();
    }

    @Override
    public boolean isEmpty(){
        return stack.isEmpty();
    }

    @Override
    public List<T> toList(){
        return new ArrayList<>(stack);
    }

    @Override
    public String toString(){
        return stack.toString();
    }

}
