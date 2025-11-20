package model.adt;

import exception.ADTException;

public interface MyIStack<T> {
    T pop() throws ADTException;
    void push(T v);
    boolean isEmpty();
    String toString();
}
